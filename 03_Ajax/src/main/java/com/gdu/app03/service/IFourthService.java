package com.gdu.app03.service;

import org.springframework.http.ResponseEntity;

public interface IFourthService {
	// 그림들을 읽어 들여서 그대로 반환
	public ResponseEntity<byte[]> display(String path, String filename); // 파라미터 
}
