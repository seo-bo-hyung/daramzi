<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/board/boardWrite.css"/>
<script language="javascript" type="text/javascript" src="/resources/js/board/boardWrite.js"></script>
</head>
<body>
	<form method="post" id="boardWrite" name="boardWrite" action="/board/boardWrite" enctype="multipart/form-data">
	    <table>
	            <colgroup>
	                <col width="20%">
	                <col width="80%">
	            </colgroup>
	 
                <caption>게시판 글쓰기</caption>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" id="id" name="id" size="10" value="${authInfo.id }" maxlength="8" readonly="true"/></td>
                </tr>
                <tr>
                    <td>제 목</td>
                    <td><input type="text"  id="title" name="title"/></td>
                </tr>
                <tr>
                    <td>내 용</td>
                    <td><textarea name="content" id="content" rows="10" cols="100" ></textarea></td>
                </tr>
                <tr>
                    <td colspan=2><hr size=1></td>
                </tr>
                <tr>
                	<td>첨부파일</td>
                	<td><input type="file" name="file" id="filename" multiple="multiple" accept=".jpg,.jpeg,.png,.gif,.bmp"></td>
                </tr>
                <tr>
                    <td colspan="2">
                   		<div align="center">
                            <input type="button" name="submitBtn" value="등록">  
                            <input type="button" value="뒤로" onclick="history.back()">
                        </div>
                       </td>
                </tr>
	    </table>
	</form>
	<!-- 해당 위치 안에 이미지가 쌓이게 된다. -->
	<div id="preview"></div>
	
</body>

    <!-- 목록으로 -->
    <form action="/board/boardList" name="search" method="post"  >
    </form>
</html>
