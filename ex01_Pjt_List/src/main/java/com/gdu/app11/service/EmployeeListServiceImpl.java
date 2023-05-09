package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmployeeListMapper;
import com.gdu.app11.util.PageUtil;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class EmployeeListServiceImpl implements EmployeeListService {

	private EmployeeListMapper employeeListMapper;
	private PageUtil pageUtil;
	
	@Override
	public void getEmployeeListUsingPagination(HttpServletRequest request, Model model) {
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt1.orElse("1"));
		
		int totalRecord = employeeListMapper.getEmployeeCount();
		
		HttpSession session = request.getSession();
		Optional<Object> opt2 = Optional.ofNullable(session.getAttribute("recordPerPage"));
		int recordPerPage = (int)(opt2.orElse(10));
		
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("order"));
		String order = opt3.orElse("ASC");
		
		Optional<String> opt4 = Optional.ofNullable(request.getParameter("column"));
		String column = opt4.orElse("EMPLOYEE_ID");
		
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		map.put("order", order);
		
		List<EmpDTO> employees = employeeListMapper.getEmployeeListUsingPagination(map);
		
		model.addAttribute("employees", employees);
		model.addAttribute("pagination", pageUtil.getPagination(request.getContextPath()+ "/employees/pagination.do?column=" + column + "&order=" + order));
		model.addAttribute("beginNo", totalRecord - (page - 1) * recordPerPage);
		switch(order) {
		case "ASC" : model.addAttribute("order", "DESC"); break;
		case "DESC": model.addAttribute("order", "ASC"); break;
		}
		model.addAttribute("page", page);
	}

	@Override
	public Map<String, Object> getEmployeeListUsingScroll(HttpServletRequest request) {
		// 파라미터 page가 전달되지 않는 경우 page=1로 처리한다.
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt1.orElse("1"));
		
		// 전체 레코드 개수를 구한다.
		int totalRecord = employeeListMapper.getEmployeeCount();
		
		//  recordPerPage=9으로 처리한다.
		int recordPerPage = 9; // 스크롤 한번에 9개씩 보여주기
		
		// PageUtil(Pagination에 필요한 모든 정보) 계산하기
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		// DB로 보낼 Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());

		// begin ~ end 사이의 목록 가져오기
		List<EmpDTO> employees = employeeListMapper.getEmployeeListUsingScroll(map);
		
		// scroll.jsp로 응답할 데이터 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("employees", employees);
		resultMap.put("totalPage", pageUtil.getTotalPage());
		// 응답 
		return resultMap;
	}
	@Override
	public void getEmployeeListUsingSearch(HttpServletRequest request, Model model) {
		
		// 파라미터 column이 전달되지 않는 경우 column=""로 처리한다.
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("column"));
		String column = opt2.orElse("");
		
		// 파라미터 query가 전달되지 않는 경우 query=""로 처리한다.
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("query"));
		String query = opt3.orElse("");
		
		// DB로 보낼 Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		
		// 파라미터 page가 전달되지 않는 경우 page=1로 처리한다.
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt1.orElse("1"));
		
		// 검색된 레코드 개수를 구한다.
		int totalRecord = employeeListMapper.getEmployeeSearchCount(map);
		
		//  recordPerPage=10으로 처리한다.
		int recordPerPage = 10;
		
		// PageUtil(Pagination에 필요한 모든 정보) 계산하기
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// begin ~ end 사이의 목록 가져오기
		List<EmpDTO> employees = employeeListMapper.getEmployeeListUsingSearch(map);
		
		// search.jsp로 전달할(forward)할 정보 저장하기
		model.addAttribute("employees", employees);
		model.addAttribute("pagination", pageUtil.getPagination(request.getContextPath() + "/employees/search.do?column=" + column + "&query" + query));
		model.addAttribute("beginNo", totalRecord - (page - 1) * recordPerPage);
	}
 
	@Override
	public Map<String, Object> getAutoComplete(HttpServletRequest request) {
		
		// 파라미터 column이 전달되지 않는 경우 column=""로 처리한다.
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("column"));
		String column = opt2.orElse("");
		
		// 파라미터 query가 전달되지 않는 경우 query=""로 처리한다.
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("query"));
		String query = opt3.orElse("");
		
		// DB로 보낼 Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		
		// 검색 결과 목록 가져오기 
		List<EmpDTO> employees = employeeListMapper.getAutoComplete(map);
		
		// scroll.jsp로 응답할 데이터 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("employees", employees);
		
		// 응답 
		return resultMap;
	}
}
