package com.gdu.app10.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.gdu.app10.domain.BbsDTO;
import com.gdu.app10.mapper.BbsMapper;
import com.gdu.app10.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor // 생성자를 넣어서 오토와이드 대체
@Service
public class BbsServiceImpl implements BbsService {

	// field
	private BbsMapper bbsMapper;
	private PageUtil pageUtil; 
	
	@Override
	public void loadBbsList(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 레코드 개수
		int totalRecord = bbsMapper.getBbsCount();
		
		// 레코드 페이지
		int recordPerPage = 20;
		
		// 페이지 유틸을 불러서 페이지네이션 모든 계산 마침
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		// DB에 보낼 MAP 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// 목록 
		List<BbsDTO> bbsList = bbsMapper.getBbsList(map);
		
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("beginNo", totalRecord - (page - 1) * recordPerPage);
		model.addAttribute("pagination", pageUtil.getPagination(request.getContextPath() + "/bbs/list.do")); // 목록보기로 넘어갈 경로 작성
		/*
		 * 200 - (1페이지 - 1) * 20 200 - (2페이지 - 1) * 20
		 */
		
	}

	@Override
	public int addBbs(HttpServletRequest request) {
		
		// 파라미터 
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		
		// IP
		String ip = request.getRemoteAddr();
		
		// DB로 보낼 BbsDTO 객체 
		BbsDTO bbsDTO = new BbsDTO();
		bbsDTO.setWriter(writer);
		bbsDTO.setTitle(title);
		bbsDTO.setIp(ip);
		
		// 원글 달기
		int addResult = bbsMapper.addBbs(bbsDTO);
		
		// 결과 반환
		return addResult;
	}
	
	@Override
	public int removeBbs(int bbsNo) {
		int removeResult = bbsMapper.removeBbs(bbsNo);
		return removeResult;
	}
	
	@Transactional(readOnly = true) // INSERT, UPDATE, DELETE 중 2개 이상의 쿼리를 실행하는 경우 반드시 수행
	@Override
	public int addReply(HttpServletRequest request) {
		
		// 파라미터 writer, title
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		
		// IP
		String ip = request.getRemoteAddr();
		
		// 원글의 정보(파라미터 depth, groupNo, groupOrder)
		int depth = Integer.parseInt(request.getParameter("depth"));
		int groupNo = Integer.parseInt(request.getParameter("groupNo"));
		int groupOrder = Integer.parseInt(request.getParameter("groupOrder"));
		
		// 원글 BbsDTO (기존 답글 선행 작업 : increaseGroupOrder를 위한 DTO)
		BbsDTO bbsDTO = new BbsDTO();
		bbsDTO.setGroupNo(groupNo);
		bbsDTO.setGroupOrder(groupOrder);
		
		// 기존 답글 선행 작업
		bbsMapper.increaseGroupOrder(bbsDTO);
		
		// 답글 ReplyDTO
		BbsDTO replyDTO = new BbsDTO();
		replyDTO.setWriter(writer);
		replyDTO.setTitle(title);
		replyDTO.setIp(ip);
		replyDTO.setDepth(depth + 1);
		replyDTO.setGroupNo(groupNo);
		replyDTO.setGroupOrder(groupOrder + 1);
		
		// 답글 달기
		int addReplyResult = bbsMapper.addReply(replyDTO);
		return addReplyResult;
	}
}
