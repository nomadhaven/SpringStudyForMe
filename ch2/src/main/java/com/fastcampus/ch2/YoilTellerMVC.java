package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//년월일을 입력하면 요일 알려주는 프로그램
@Controller
public class YoilTellerMVC {	//http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1 를 주소창에 입력해서 test
	@RequestMapping("/getYoilMVC") //반환타입을 주지 않고 Void로 설정하면 Mapping된 주소인 getYoilMVC.jsp뷰로 이동한다.
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		public ModelAndView main(int year, int month, int day) throws IOException {

		ModelAndView mv = new ModelAndView();
		//1. 유효성 검사
//		if(!isValid(year,month,day))
//			return "yoilError";
		
		//2.요일 계산
		char yoil =	getYoil(year, month, day);
		
		//3.계산한 결과를 model and view에 저장.
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		
		//4. 결과를 보여줄 view의 이름 지정
		mv.setViewName("yoil");
		
		return mv;
		
		
	//	return "yoil"; //WEB-INF/views/yoil.jsp를 return한다
		
		/*
		 컨트롤러 메서드의 반환 타입 
		 1.String일 경우 : view 이름을 반환
		 2.Void일 경우 : Mapping된 url의 끝단어가 view 이름
		 (ex: @RequestMapping("/getYoilMVC") 에서 /getYoilMVC가 뷰이름)
		 3.ModelAndView일 경우: Model과 View 이름을 반환. 
		  
		 */
		
		
		
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1,day);
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일 2:월요일
	return " 일월화수목금토".charAt(dayOfWeek);
}

}
