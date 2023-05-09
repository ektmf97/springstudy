package com.gdu.app02.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {
	
	@GetMapping("/post/detail.do")
	public String detail(HttpServletRequest request) throws Exception  {    // 메소드 이름은 아무상관 없다
        // 파라미터 두개를 어떻게 처리 할 것인지 
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// name, age 정삭 작동하는지 확인 
		System.out.println("/post/detail.do");
		System.out.println("name: " + name + "age: " + age);
		
		// return "redirect:이동경로(매핑)";
		return "redirect:/post/list.do?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age; // /post/list.do 매핑으로 이동하시오! name, age 파라미터를 다시 붙인다!
		
	}
	
	@GetMapping("/post/list.do") // 위에서 작업한 리다이렉트로 이어진다.
	public String list(HttpServletRequest request,  // name, age 파라미터가 있다.
					   Model model) {               // 모델 선언은 메소드에 매개변수에서 해야한다.
		// 리다이렉트는 name, age가 전달이 안된다. 
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// 속성에 값을 추가하기 
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		// /WEB-INF/views/post/list.jsp로 forward 하겠다!  프리픽스값:/WEB-INF/views  서픽스값:/post/list
		return "post/list";
	}
	
	@GetMapping("/post/detail.me")
	public String detailMe(HttpServletRequest request,
				           RedirectAttributes redirectAttributes) { // redirect 할 때 속성(Attribute)을 전달하는 스프링인터페이스
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	// redirectAttributes에 파라미터 저장하기 
	// Redirect 경로까지 전달되는 속성 : Flash Attribute <- 항상 이거 사용해야 한다 꼭!
	redirectAttributes.addFlashAttribute("name", name); // addAttribute()가 아님을 주의하세요! 알아서 전달 파라미터가 아니고 속성이다.
	redirectAttributes.addFlashAttribute("age", age);
	
	return "redirect:/post/list.me"; 
	
	}
	
	@GetMapping("/post/list.me")
	public String listMe() { // Flash Attribute는 Redirect 경로까지 자동으로 전달되므로 별도의 코드가 필요하지 않다.
		return "post/list";
	}
	
	
}
