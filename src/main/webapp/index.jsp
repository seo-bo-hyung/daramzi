<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>
<div id="center">
	
	<h1>�ٶ��� ����Ʈ�� ���Ű� ȯ���մϴ�.</h1>
		<c:catch>
		    <c:choose>
		        <c:when test="${empty authInfo }">
		             <li>
		                 <a href="/login">�α���</a>
		             </li>
		             <li>
		                 <a href="/register/step1">ȸ������</a>
		             </li>
		        </c:when>
		        <c:otherwise>
		            <c:choose>
		                <c:when test="${authInfo.grade eq '1' }">
		                    <li>
		                       <p>������ ${authInfo.name }��, ȯ���մϴ�.</p>
		                   </li>
		                   <li>
		                       <a href="/logout"><i class="fa fa-sign-out"></i> �α׾ƿ�</a>
		                   </li>
		                </c:when>
		                <c:otherwise>
		                    <li>
		                       <p>${authInfo.name }��, �ݰ����ϴ�!</p>
		                   </li>
		                   <li>
		                       <a href="/logout"><i class="fa fa-sign-out"></i> �α׾ƿ�</a>
		                   </li>
		                </c:otherwise>
		            </c:choose>
		        </c:otherwise>
		    </c:choose>
		</c:catch>
</div>
</body>
</html>