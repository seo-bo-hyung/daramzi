<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/imageBoard/style.css"/>
<script language="javascript" type="text/javascript" src="/resources/js/imageBoard/multiupload.js"></script>

<form id="upForm1" action="/imageboard/fileupload" method="post" enctype="multipart/form-data">
	<div id="form">
		<ul>
		  <li>
		    <input type="file" name="file" multiple="multiple" accept=".jpg,.jpeg,.png,.gif,.bmp">
		  <li>    
		    <input type="button" name="submitBtn" value="사진올리기" onclick="fileCheck(this.form)">
		</ul>
	</div>
</form>
<!-- 해당 위치 안에 이미지가 쌓이게 된다. -->
<div id="preview"></div>



			