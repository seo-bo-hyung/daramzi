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
		  	<input type="text" id="title" name="title"/>
		  	<input type="text" id="description" name="description"/>
		    <p class="cau">※ 최대 업로드 파일 수 : 5개</p>
		    <input type="file" name="file">
		  <li>    
		    <input type="submit" id="upPro1" value="다중 파일 업로드">
		</ul>
	</div>
</form>
<div id="upResult"></div>			