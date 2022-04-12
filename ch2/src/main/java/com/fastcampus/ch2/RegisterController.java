package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o  자동 import
public class RegisterController {
	//@RequestMapping(value="/register/save", method={RequestMethod.GET, RequestMethod.POST})
	//@RequestMapping("/register/add") //신규 회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; //WEB-INF/views/registerForm.jsp
//				
//	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") //4.3부터 사용가능
	public String save(User user, Model m) throws Exception{
		
		//1.유효성 검사
		if(!isValid(user)) {
			String msg= URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
			//return "redirect:/register/add?msg="+msg; //URL 재작성(rewriting)
		}
		//2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return true;
	}
}
