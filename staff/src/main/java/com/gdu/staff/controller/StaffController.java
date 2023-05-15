package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/list.json")
	public ResponseEntity<List<StaffDTO>> list() {
		return staffService.getStaffList();
	}
		
	@PostMapping(value="/add.do", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add2(StaffDTO staffDTO){
		return staffService.addStaff2(staffDTO);
	}
	
	@GetMapping(value="/search.json", produces="application/json; charset=UTF-8")
	public ResponseEntity<StaffDTO> search(HttpServletRequest request) { 
		return staffService.getStaffSearch(request);
	}
	
	// @ResponseBody
	// @GetMapping(value="/query.json", produces="application/json; charset=UTF-8")
	// public StaffDTO query(String query) { // 파라미터 전달 int 타입이라 string으로 변환
	// StaffDTO 타입만 주는이유는 받아올 데이터가 여기 다 들어있어서 
	//	return staffService.findStaff(query);
	//}
}