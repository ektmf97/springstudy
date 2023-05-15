package com.gdu.staff.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.gdu.staff.domain.StaffDTO;

public interface StaffService {
	public ResponseEntity<List<StaffDTO>> getStaffList();
	public ResponseEntity<String> addStaff2(StaffDTO staffDTO);
	public ResponseEntity <StaffDTO> getStaffSearch(HttpServletRequest request);
	
	
}
