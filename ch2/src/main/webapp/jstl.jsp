<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>JSTL</title>
</head>
<body>
<c:set var="to"   value="10"/> <!-- Key 는 to Value는 10으로 저장소에 저장. EL은 lv를 사용하지 못한다. -->
<c:set var="arr"  value="10,20,30,40,50,60,70"/> 
<c:forEach var="i" begin="1" end="${to}"> <!-- 1부터 end=10까지 i값 출력 -->
	${i}
</c:forEach>
<br>
<c:if test="${not empty arr}"> <!-- 배열이 비어있지 않으면 아래의 for문 싫행 -->
	<c:forEach var="elem" items="${arr}" varStatus="status"><!-- status는 count와 index라는 멤버를 가지고 있다. count는 0부터 index는 1부터 시작. -->
		${status.count}. arr[${status.index}]=${elem}<BR>
	</c:forEach>
</c:if>	
<c:if test="${param.msg != null}"> <!-- 주소창에 http://localhost:8080/ch2/jstl.jsp?msg=asdf 치면 msg가 그대로 출력 -->
	msg=${param.msg} 
	msg=<c:out value="${param.msg}"/> <!-- out으로 감싸주면 태그를 태그로 해석하지 않고 그대로 출력. msg=<p>asdf</p> 쳐서 확인해보기 -->
</c:if>
<br>
<c:if test="${param.msg == null}">메시지가 없습니다.<br></c:if>
<c:set var="age" value="${param.age}"/>
<c:choose>
	<c:when test="${age >= 19}">성인입니다.</c:when>
	<c:when test="${0 <= age && age < 19}">성인이 아닙니다.</c:when>
	<c:otherwise>값이 유효하지 않습니다.</c:otherwise>
</c:choose>
<br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/><!-- 현재 날짜를 시분초 형식으로 출력 -->
</body>
</html>