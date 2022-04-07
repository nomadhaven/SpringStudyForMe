<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2.*" %>
<%
	Person person = new Person();
	request.setAttribute("person", person); //attribute라는 map을 가지고 있는 request 객체에 저장
	request.setAttribute("name", "남궁성");   
	request.setAttribute("list", new java.util.ArrayList());	
%>

<!-- Server탭에서 우클릭 > Clean Tomcat Work Directory하면 웹 로딩하면서 컴파일된 파일이 삭제됨: jsp 페이지를 변경했지만 화면에 변경이 적용 안될때 사용. -->
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
person.getCar().getColor()=${person.getCar().getColor()} <br> <!-- request 객체에 저장 되지 않았으면 쓸수 없다. -->
person.getCar().getColor()=${person.car.color} <br>    <!-- request 객체에 저장 되지 않았으면 쓸수 없다. -->
name=<%=request.getAttribute("name")%> <br>   
name=${requestScope.name} <br> <!-- reuestScope은 request 객체의 저장소 이름 따라서 requestScope.name은 저장소에 있는 name의 값이란 말. -->
name=${name} <br>
id=<%=request.getParameter("id")%> <br> <!-- JSP -->
id=${pageContext.request.getParameter("id")} <br> <!-- EL, EL은 NULL값을 출력하지 않는다. -->
id=${param.id} <br> <!-- EL, EL은 NULL값을 출력하지 않는다. -->
"1"+1 = ${"1"+1} <br>
"1"+="1" = ${"1"+="1"} <br>
"2">1 = ${"2">1} <br>   
null = ${null}<br>
null+1 = ${null+1} <br>
null+null = ${null+null} <br>
"" + null = ${""+null} <br>   
""-1 = ${""-1} <br> 
empty null=${empty null} <br> <!-- 비었을때가 참인 연산 empty -->
empty list=${empty list} <br> <!-- 9번째 줄에 빈 list 저장 -->
null==0 = ${null==0} <br>
null eq 0 = ${null eq 0} <br>
name == "남궁성"=${name=="남궁성"} <br>
name != "남궁성"=${name!="남궁성"} <br>
name eq "남궁성"=${name eq "남궁성"} <br>  <!-- eq=equal이란 말 -->
name ne "남궁성"=${name ne "남궁성"} <br>  <!-- ne: not equal이란 말 -->
name.equals("남궁성")=${name.equals("남궁성")} <br>   
</body>
</html>
