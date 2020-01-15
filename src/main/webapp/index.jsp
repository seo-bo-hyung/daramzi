<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>다람쥐 사이트에 오신걸 환영합니다.</h1>
<h1>index.jsp</h1>
<c:catch>
    <c:choose>
        <c:when test="${empty authInfo }">
            <li>
                 <a href="/login"><i class="fa fa-sign-in"></i> 로그인</a>
             </li>
             <li>
                 <a href="/register/step1"><i class="fa fa-user"></i> 회원가입</a>
             </li>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${authInfo.grade eq '1' }">
                    <li>
                       <p>관리자 ${authInfo.name }님, 환영합니다.</p>
                   </li>
                   <li>
                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                </c:when>
                <c:otherwise>
                    <li>
                       <p>${authInfo.name }님, 반갑습니다!</p>
                   </li>
                   <li>
                       <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</c:catch>

</body>
</html>