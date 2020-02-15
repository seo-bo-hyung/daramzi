  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<span>다람쥐에 오신걸 환영합니다!!</span>
<a href="/">홈</a>
<c:catch>
		    <c:choose>
		        <c:when test="${empty authInfo }">
		                 <a href="/login">로그인</a>
		                 <a href="/register/step1">회원가입</a>
		        </c:when>
		        <c:otherwise>
		            <c:choose>
		                <c:when test="${authInfo.grade eq '1' }">
		                       <p>관리자 ${authInfo.name }님, 환영합니다.</p>
		                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
		                </c:when>
		                <c:otherwise>
		                       <p>${authInfo.name }님, 반갑습니다!</p>
		                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
		                </c:otherwise>
		            </c:choose>
		        </c:otherwise>
		    </c:choose>
		</c:catch>
		<!-- <marquee width="500">♡&lt;다람쥐에 오신걸 환영합니다.&gt;♡</marquee><font size="5"></font> -->
</body>
</html>
 