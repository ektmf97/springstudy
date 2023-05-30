package com.gdu.app12.intercept;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PreventLoginlnterceptor implements HandlerInterceptor {

  // 로그인이 되어 있는 상태에서 
  // 다시 로그인 페이지로 이동, 회원 가입 페이지로 이동 등을 막는 인터셉트
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
   
    HttpSession session = request.getSession();
    
    // 로그인 여부 확인
    if(session != null && session.getAttribute("loginId") != null) { // 세션에 로그인 아이디가 존재한다, 널이 아니다
      
      // 응답
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('해당 기능은 사용할 수 없습니다.')"); // 메시지만 띄우면 되는거라 alert 사용
      out.println("history.back();"); // 이전 상태로 돌아가기
      out.println("</script>");
      out.flush();
      out.close();
      
      return false; // 컨트롤러의 요청이 처리되지 않는다.
    }
    
    return true; // 컨트롤러의 요청이 처리된다.
  }
  
}
