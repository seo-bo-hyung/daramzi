<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board/boardWrite.js"></script>
</head>
<body>
 
    <table summary="글수정 전체 테이블">
        <form:form name="modComp" id="modComp" ModelAttribute="modComp" method="post" action="/board/boardUpdateComp" >
        <input type="hidden" name="seq" 		value="${modContent.seq }"/>
        
        <!-- 검색조건 유지를 위한 값 -->
        <input type="hidden" name="listNum" 	value="${search.listNum}" /> 
        <input type="hidden" name="keyField" 	value="${search.keyField }" /> 
        <input type="hidden" name="keyWord" 	value="${search.keyWord }" />
        <input type="hidden" name="page" 		value="${search.page}" /> 
        <input type="hidden" name="pageYN" 		value="N" />   
           
        <colgroup>
            <col width="20%">
            <col width="80%">
        </colgroup>
       
        <table summary="테이블 구성" >
        <caption>글 수정하기 [${modContent.seq }번] 게시물</caption>    
            <tr>
                <td>작성자</td>
                <td><input type=text id="name" name=name size=10 maxlength=8 value="${modContent.name }"></td>
            </tr>
            <tr>
                 <td>E-Mail</td>
                 <td><input type=text id="email" name=email size=30 value="${modContent.email }"></td>
            </tr>
            <tr>
                 <td>제 목</td>
                 <td><input type=text id="title" name=title value="${modContent.title }"></td>
            </tr>
            <tr>
                 <td>내 용</td>
                 <td><textarea id="content" name=content rows ="10" cols="100">${modContent.content }</textarea></td>
            </tr>
            <tr>
                 <td colspan=2><hr size=1></td>
            </tr>
            <tr>
			<td colspan="3">
				<div align="center">
					<input type="button" 	value="수정 완료" onclick="check_modify()">  
					<input type="reset"		value="다시 수정"> 
					<input type="button" 	value="뒤로" onclick="history.back()">
				</div>
			</td>
            </tr> 
        </table>
        

    </form:form> 
</table>
 
</body>
</html>
