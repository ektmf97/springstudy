package com.gdu.app07.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdu.app07.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardByNo(HttpServletRequest requset);
	public int addBoard(HttpServletRequest requset);
	public int modifyBoard(HttpServletRequest requset);
	public int removeBoard(HttpServletRequest requset);
	public void textTx();
}
