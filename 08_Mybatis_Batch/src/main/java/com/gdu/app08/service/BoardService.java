package com.gdu.app08.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app08.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardByNo(HttpServletRequest requset);
	public void addBoard(HttpServletRequest requset, HttpServletResponse response);
	public void modifyBoard(HttpServletRequest requset, HttpServletResponse response);
	public void removeBoard(HttpServletRequest requset, HttpServletResponse response);
	public void removeBoardList(HttpServletRequest requset, HttpServletResponse response);
	public void getBoardCount();
}
