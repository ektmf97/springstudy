package com.gdu.app07.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repositroy.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.selectBoardList();
	}

	@Override
	public BoardDTO getBoardByNo(HttpServletRequest requset) {
		// jsp에서 상세보기 하고싶다.  /detail.do?boardNo=5 요청이 오면 컨트롤러는 requset로 받음  
		// 파라미터 boardNo가 없으면(null, "") 0을 사용한다.
		String strBoardNo = requset.getParameter("boardNo");
		int boardNo = 0;
		if(strBoardNo != null && strBoardNo.isEmpty() == false) { // isEmpty() : 빈문자열
			boardNo = Integer.parseInt(strBoardNo);
		}
		return boardDAO.selectBoardByNo(boardNo);
		// 옵셔널 처리는 null처리만 한다. 빈 문자열은 처리를 못한다.
	}

	@Override
	public int addBoard(HttpServletRequest requset) {
		try {
			// 파라미터 title, content, writer를 받아온다.
			String title = requset.getParameter("title");
			String content = requset.getParameter("content");
			String writer = requset.getParameter("writer");
			
			// BoardDAO로 전달할 BoardDTO를 만든다.
			BoardDTO board = new BoardDTO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			return boardDAO.insertBoard(board);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int modifyBoard(HttpServletRequest requset) {
		try {
			// 파라미터 title, content, boardNo를 받아온다.
			// 포스트 요청을 한다는건 주소창으로 조작이 불가능 하기 때문에 boardNo를 의도적으로 안 보낸다. 
			String title = requset.getParameter("title");
			String content = requset.getParameter("content");
			int boardNo = Integer.parseInt(requset.getParameter("boardNo"));
			
			// BoardDAO로 전달할 BoardDTO를 만든다.
			BoardDTO board = new BoardDTO();
			board.setTitle(title);
			board.setContent(content);
			board.setBoardNo(boardNo);
			return boardDAO.updateBoard(board);
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int removeBoard(HttpServletRequest requset) {
		try {
			// 파라미터 boardNo를 받아온다.
			int boardNo = Integer.parseInt(requset.getParameter("boardNo"));
			return boardDAO.deleteBoard(boardNo);
		} catch (Exception e) {
			return 0;
		}
	}

	// 트랜잭셕 확인 
	@Transactional
	@Override
	public void textTx() {
		boardDAO.insertBoard(new BoardDTO(0, "타이틀", "콘텐트", "작성자",null , null));
		boardDAO.insertBoard(new BoardDTO());
		
	}
}
