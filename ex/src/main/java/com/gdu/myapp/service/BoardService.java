package com.gdu.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gdu.myapp.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list();
	public BoardDTO detail1(int boardNo); // 하나만 넘겨주는게 필요 
	public BoardDTO detail2(HttpServletRequest request); // 객체 자체 넘기는것도 가능
	public void detail3(Model model);
}
