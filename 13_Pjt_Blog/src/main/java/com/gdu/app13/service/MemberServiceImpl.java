package com.gdu.app13.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app13.domain.MemberDTO;
import com.gdu.app13.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberMapper memberMapper;
  
  @Override
  public void login(HttpServletRequest request) {
    // id, pw 빼겠다.
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    // db로 보낼 map 만들기
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("id", id);
    map.put("pw", pw);
    
    // map으로 memberDTO 가지고 옴
    MemberDTO memberDTO = memberMapper.selectMemberByMap(map);
    if(memberDTO != null) {
      HttpSession session =  request.getSession();
      session.setAttribute("loginId", id);
      session.setAttribute("loginNo", memberDTO.getMemberNo());
    }
  }
  
  @Override
  public void logout(HttpSession session) {
    // 세션 정보를 다 지워버린다.
    session.invalidate();
    
  }
}
