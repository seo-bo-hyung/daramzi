<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board/boardWrite.js"></script>
</head>
<body>
	<form:form role="form" commandName="writeRequest" method="post" id="boardWrite" name="boardWrite" action="/board/boardWrite">
	    <table>
	            <colgroup>
	                <col width="20%">
	                <col width="80%">
	            </colgroup>
	 
	            <table>
	                <caption>게시판 글쓰기</caption>
	                <tr>
	                    <td>작성자</td>
	                    <td><form:input type="text" path="name" id="name" size="10" value="${authInfo.name }" maxlength="8" readonly="true"/></td>
	                </tr>
	                <tr>
	                    <td>E-Mail</td>
	                    <td><form:input type="text" path="email" id="email" size="30" /></td>
	                </tr>
	                <tr>
	                    <td>홈페이지</td>
	                    <td><form:input type="text" path="homepage" id="homepage" size="30" /></td>
	                </tr>
	                <tr>
	                    <td>제 목</td>
	                    <td><form:input type="text" path="title" id="title" /></td>
	                </tr>
	                <tr>
	                    <td>내 용</td>
	                    <td><form:textarea path="content" id="content" rows="10" cols="100" /></td>
	                </tr>
	                <tr>
	                    <td colspan=2><hr size=1></td>
	                </tr>
	                <tr>
	                    <td colspan="3">
                    		<div align="center">
	                            <input type="button" value="등록" onclick="check_write()" >  
	                            <input type="button" value="뒤로" onclick="history.back()">
	                        </div>
                        </td>
	                </tr>
	            </table>
	    </table>
	</form:form>
 
</body>
</html>
