package com.gdu.app13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
	
  // 2개 요청 모두 웰컴페이지로 처리
	@GetMapping(value={"/", "/index.do"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/header.do")
	public String header() {
	  return "layout/header";
	}
}
