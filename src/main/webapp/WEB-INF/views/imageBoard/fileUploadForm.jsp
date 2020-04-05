<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/imageBoard/style.css"/>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/imageBoard/multiupload.js"></script>

<form id="upForm1" action="/imageboard/fileupload" method="post" enctype="multipart/form-data">
	<div id="form">
		<ul>
		  <li>
		  	<p>사진제목</p><input type="text" id="title" name="title"/>
		  	<p>사진설명</p><input type="text" id="description" name="description"/>
		    <p></p>
		    <input type="file" name="file" multiple="multiple">
		  <li>    
		    <input type="submit" id="upPro1" value="사진올리기">
		</ul>
	</div>
</form>
<div id="upResult"></div>


			