<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>제목</title>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="./static/css/global.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="wrap">
		<div id="top"><tiles:insertAttribute name="header" /></div>

		<div id="left"><tiles:insertAttribute name="left" /></div>

		<div id="main"><tiles:insertAttribute name="body" /></div>

		<div id="bottom"><tiles:insertAttribute name="footer" /></div>
	</div>

	<script type="text/javascript">
        $(function() {
        	
        });    
    </script>    
</body>
</html>
