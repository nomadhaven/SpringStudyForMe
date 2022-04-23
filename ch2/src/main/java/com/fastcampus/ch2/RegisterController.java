package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller // ctrl+shift+o  자동 import
public class RegisterController {
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
				
	}
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		
	}

	
	
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") //4.3부터 사용가능
	public String save(User user, BindingResult result, Model m) throws Exception{
		System.out.println("result="+result);
		//1.유효성 검사
		if(!isValid(user)) {
			String msg= URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
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
