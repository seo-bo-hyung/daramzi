<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 읽기</title>
<script type="text/javascript">
    function list(){
        document.list.action="boardList.action";
         document.list.submit();
     } 
</script>
 
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
    font-family: 'Nanum Gothic', sans-serif;
}
</style>
</head>
 
<body>
<!--     <form name="BoardViewForm" method="post"> -->
    <table summary="전체 테이블 구성" width=600 height=400 cellpadding=5 cellspacing=0>
    <tr>
        <td ><div align="center"><h3><b>글 읽기</b></h3></div></td>
    </tr>
    <tr>
        <td colspan=2>
        <table border="1" summary="목록 테이블 구성"> 
    <tr> 
        <td align=center bgcolor=#dddddd width=20%> 작성자</td>
        <td bgcolor=#ffffe8 width=30%>${dto.name}</td>
        <td align=center bgcolor=#dddddd width=15%> 작성일</td>
        <td bgcolor=#ffffe8 width=50%>${dto.regdate }</td>
    </tr>
    <tr>
        <td align=center bgcolor=#dddddd> E-mail </td>
        <td bgcolor=#ffffe8 >${dto.email }</td> 
        <td align=center bgcolor=#dddddd> 홈페이지 </td>
        <td bgcolor=#ffffe8><a href="http://${dto.homepage}" target="_new">http://${dto.homepage}</a></td> 
    </tr>
    <tr> 
        <td align=center bgcolor=#dddddd> 제 목</td>
        <td bgcolor=#ffffe8 colspan=3>${dto.title}</td>
   </tr>
   <tr> 
        <td colspan=4><br>${dto.content }<br></td>
   </tr>
   <tr>
        <td colspan=4 align=right> 조회수  : ${dto.count}</td>
   </tr>
    </table>
    </td>
     </tr>
    <tr>
        <td align=center colspan=2> 
        <hr size=1>
        <div align="center">
        [ <a href="javascript:list()">목 록</a> | 
            <a href="boardUpdate.action?seq=${dto.seq}">수 정</a> |
            <a href="boardReply.action?seq=${dto.seq}">답 변</a> |
            <a href="boardDelete.action?seq=${dto.seq}">삭 제 </a>]<br>
        </div>
        </td>
    </tr>
    </table>
    <form name="list" method="post">
        <input type="hidden" name="seq" value="${dto.seq}">
        <input type="hidden" name="keyField" value="${keyField}">
        <input type="hidden" name="keyWord" value="${keyWord}">
    </form>
 
</body>
</html>
