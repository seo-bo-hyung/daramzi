<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>

<link rel = "stylesheet" type = "text/css" media = "screen" href = "/resources/jqgrid/css/jquery-ui-1.10.3.custom.min.css"/>
<link rel="stylesheet" type="text/css" media="screen" href="/resources/jqgrid/css/ui.jqgrid.css" />

<script type="text/javascript" src="/resources/jqgrid/js/jquery-1.11.0.min.js" ></script>
<script type="text/javascript" src="/resources/jqgrid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="/resources/jqgrid/js/jquery.jqGrid.min.js" ></script>

<script>
$(function(){
	$("#list2").jqGrid({
	    url : '/myFileMng/myFileList',
	    datatype : "json",
        colNames : ['파일IDX','파일순번','파일명','파일원본명','파일크기','게시판IDX','유저IDX','폴더IDX','삭제YN','공개YN','다운YN','파일설명','입력일','수정일'],
        colModel : [
					{ name : 'fileIdx',		  	index : 'fileIdx',		  	 width : 60,   align : 'center' , key:true },
					{ name : 'fileSeq',		  	index : 'fileSeq',		  	 width : 60,   align : 'center' },
					{ name : 'fileName',		index : 'fileName',		     width : 60,   align : 'center' , editable:true},
					{ name : 'fileRealName',	index : 'fileRealName',	     width : 60,   align : 'center' },
					{ name : 'fileSize',		index : 'fileSize',		     width : 60,   align : 'center' },
					{ name : 'board_idx',		index : 'board_idx',		 width : 60,   align : 'center' },
					{ name : 'userIdx',		  	index : 'userIdx',		  	 width : 60,   align : 'center' },
					{ name : 'folderIdx',		index : 'folderIdx',		 width : 60,   align : 'center' },
					{ name : 'del_yn',		  	index : 'del_yn',		  	 width : 60,   align : 'center' , editable:true},
					{ name : 'open_yn',		  	index : 'open_yn',		  	 width : 60,   align : 'center' , editable:true},
					{ name : 'down_yn',		  	index : 'down_yn',		  	 width : 60,   align : 'center' , editable:true},
					{ name : 'fileDescription',	index : 'fileDescription',	 width : 60,   align : 'center' , editable:true },
					{ name : 'ins_dt',		  	index : 'ins_dt',		  	 width : 60,   align : 'center' },
					{ name : 'upt_dt',		  	index : 'upt_dt',		  	 width : 60,   align : 'center' }
					],
	    rowNum:10,
	    rowList:[10,20,30],
	    pager:'#pager2',
	    sortname:'id',
	    viewrecords: true,
	    sortorder:"desc",
	    caption:"내 파일 관리",
	    jsonReader: {
	         repeatitems:false
	    },
	    cellEdit:true,
	    cellsubmit:'remote',
	    cellurl:'/myFileMng/myFileUpdate',
	    beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
	          return {"id":rowid, "cellName":cellname, "cellValue":value}
	    },
	    afterSubmitCell : function(res) {    // 변경 후
	         var aResult = $.parseJSON(res.responseText);
	         var userMsg = "";
	         if((aResult.msg == "success")) {
	             userMsg = "데이터가 변경되었습니다.";
	         }

	         return [(aResult.msg == "success") ? true : false, userMsg];

	         /*

	              +++ 추가 내용

	              사용자가 afterSubmitCell을 구현하는 경우

	              [성공여부, 띄울메시지] 배열을 리턴해야한다고 함

	              (나무인형님 댓글 참조)

	         */

	     }
	});
	
	$("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
});
</script>
</head>
 
<body>
	<table id="list2"></table>
	<div id="pager2"></div>
</body>
</html>

