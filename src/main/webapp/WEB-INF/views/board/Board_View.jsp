<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 읽기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board/board.css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board/board.js"></script>
</head>

<body>
	<table summary="전체 테이블 구성" width=600 height=400 cellpadding=5 cellspacing=0>
	    <tr>
	        <td ><div align="center"><h3><b>글 읽기</b></h3></div></td>
	    </tr>
	    <tr>
	        <td colspan=2>
	        <table border="1" summary="목록 테이블 구성"> 
	        </td>
	    <tr> 
	        <td align=center bgcolor=#dddddd width=20%> 작성자</td>
	        <td bgcolor=#ffffe8 width=30%>${viewContent.name}</td>
	        <td align=center bgcolor=#dddddd width=15%> 작성일</td>
	        <td bgcolor=#ffffe8 width=50%>${viewContent.regdate }</td>
	    </tr>
	    <tr>
	        <td align=center bgcolor=#dddddd> E-mail </td>
	        <td bgcolor=#ffffe8 >${viewContent.email }</td> 
	        <td align=center bgcolor=#dddddd> 홈페이지 </td>
	        <td bgcolor=#ffffe8><a href="http://${viewContent.homepage}" target="_new">http://${viewContent.homepage}</a></td> 
	    </tr>
	    <tr> 
	        <td align=center bgcolor=#dddddd> 제 목</td>
	        <td bgcolor=#ffffe8 colspan=3>${viewContent.title}</td>
	    </tr>
		<tr> 
		     <td colspan=4><br>${viewContent.content }<br></td>
		</tr>
		<tr>
		     <td colspan=4 align=right> 조회수  : ${viewContent.count}</td>
		</tr>
	</table>
    
    <tr>
        <td align=center colspan=2> 
        <hr size=1>
        <div align="center">
        [ <a href="javascript:list()">목 록</a> | 
            <a href="javascript:modContent(${viewContent.seq})">수 정</a> |
            <a href="boardReply.action?seq=${viewContent.seq}">답 변</a> |
            <a href="javascript:delContent(${viewContent.seq})">삭 제 </a>]<br>
        </div>
        </td>
    </tr>
    </table>
</body>
    <!-- 게시글 수정 -->
    <form name="modContent" method="post"  >
        <input type="hidden" name="seq"/>
       	<input type="hidden" name="listNum" 	value="${search.listNum}" /> 
        <input type="hidden" name="keyField" 	value="${search.keyField }" /> 
        <input type="hidden" name="keyWord" 	value="${search.keyWord }" />
        <input type="hidden" name="page" 		value="${search.page}" /> 
        <input type="hidden" name="pageYN" 		value="N" />
    </form>
    
    <!-- 목록으로 -->
    <form action="/board/boardList" name="search" method="post"  >
     	<input type="hidden" name="listNum" 	value="${search.listNum}" /> 
        <input type="hidden" name="keyField" 	value="${search.keyField }" /> 
        <input type="hidden" name="keyWord" 	value="${search.keyWord }" />
        <input type="hidden" name="page" 		value="${search.page}" /> 
        <input type="hidden" name="pageYN" 		value="N" />
    </form>
    

</html>
