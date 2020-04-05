    
	//검색 버튼
	function check_search() {
        if ($("input[name=keyWord]", "form[name=search]").val() == "") {
            alert("검색어를 입력하세요.");
            $("input[name=keyWord]", "form[name=search]").focus();
            return;
        }
        
        $('form[name="search"]').submit();
    }
    
    //드롭리스트 검색
    function listCnt_search() {
    	$('form[name="search"]').submit();
    }
    
    //페이지 이동
    function pagemove(i) {
        $("input[name=page]", "form[name=search]").val(Number(i));
        $('form[name="search"]').submit();
    }
    
    //게시판 글 보기
    function read(seq) {
        $("input[name=seq]", "form[name=read]").val(seq);
        $('form[name="read"]').submit();
        
    }
    
    //게시판 글 수정
    function modContent(seq) {
    	$('form[name="modContent"]').attr("action","/board/boardUpdate");
    	$("input[name=seq]", "form[name=modContent]").val(seq);
    	$('form[name="modContent"]').submit();
    }
    
    //게시판 글삭제
    function delContent(seq) {
    	$('form[name="modContent"]').attr("action","/board/boardDelete");
    	$("input[name=seq]", "form[name=modContent]").val(seq);
    	$('form[name="modContent"]').submit();
    }

    //사진업로드 화면
    function go_upload(loginId) {
    	if(loginId == null){
    		alert("사진업로드는 로그인 후 가능합니다.");
    		return 0;
    	}
    	
    	location.href="/imageboard/fileUploadForm";
    }    
    
    //사진삭제
    function go_fileDel(fileIdx) {
        $.ajax({
	        type: "post",
	        url : "/imageboard/fileDel",
	        data: {
	        	fileIdx : fileIdx
	        },

	        success:function (data) {//사진삭제 - 성공시
	        	alert("사진을 삭제하였습니다.");
	        	$("#" + fileIdx).empty();
            },

	        error: function (data) {//사진삭제 - 실패시
	        	alert("사진을 삭제하지 못했습니다.관리자에게 문의 바랍니다.");
            }

     	});
    }

    var imgCommonPreview = new Image(); 
    function viewPic(filepath) { 
    	if(filepath == "") {
    		alert('등록된 이미지가 없습니다.'); 
    		return;
		}imgCommonPreview.src = filepath;
		setTimeout("createPreviewWin(imgCommonPreview)", 100); 
	} 
    
    function createPreviewWin(imgCommonPreview) { 
    	if(!imgCommonPreview.complete) {
    		setTimeout("createPreviewWin(imgCommonPreview)", 100); 
    		return;
    		} var scrollsize = 17; 
    		var swidth = screen.width - 10;
    		var sheight = screen.height - 90;
    		var wsize = imgCommonPreview.width;
    		var hsize = imgCommonPreview.height;

    		if(wsize < 50) wsize = 50; // 가로 최소 크기 
    		if(hsize < 50) hsize = 50; // 세로 최소 크기 
    		if(wsize > swidth) wsize = swidth; // 가로 최대 크기
    		if(hsize > sheight) hsize = sheight; // 세로 최대 크기 
    		
    		// 세로가 최대크기를 초과한경우 세로스크롤바 자리 확보 
    		if((wsize < swidth-scrollsize) && hsize >= sheight) wsize += scrollsize; // 가로가 최대크기를 초과한경우 가로스크롤바 자리 확보 
    		if((hsize < sheight-scrollsize) && wsize >= swidth) hsize += scrollsize; // IE 6,7 전용 : 가로세로 크기가 보통일때 세로 스크롤바 자리 확보 
    		if((wsize < swidth-scrollsize) && hsize < sheight
    				&& (navigator.userAgent.indexOf("MSIE 6.0") > -1
					|| navigator.userAgent.indexOf("MSIE 7.0") > -1))wsize += scrollsize; // 듀얼 모니터에서 팝업 가운데 정렬하기 
    		var mtWidth = document.body.clientWidth; // 현재 브라우저가 있는 모니터의 화면 폭 사이즈 
    		var mtHeight = document.body.clientHeight; // 현재 브라우저가 있는 모니터의 화면 높이 사이즈
    		var scX = window.screenLeft; // 현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준) 
    		var scY = window.screenTop; // 현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준) 
    		var popX = scX + (mtWidth - wsize) / 2 - 50; // 팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준) 
    		var popY = scY + (mtHeight - hsize) / 2 - 50; // 팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준) 
    		
    		// window.open('주소', '이름(공란가능)', '속성'); 
    		imageWin = window.open("", "", 
    				"top=" + popY
    				+ ",left="+ popX
    				+ ",width=" + wsize
    				+ ",height="+ hsize
    				+",scrollbars=yes,resizable=yes,status=no");
    		imageWin.document.write("<html><title>Preview</title><body style='margin:0;cursor:pointer;' title='Close' onclick='window.close()'>");
    		imageWin.document.write("<img src='" + imgCommonPreview.src + "'>");
    		imageWin.document.write("</body></html>"); 
	} 


																																																																																																																																							// 최소
																																																																																																																																							// 크기
																																																																																																																																							// if(hsize
																																																																																																																																							// <
																																																																																																																																							// 50)
																																																																																																																																							// hsize
																																																																																																																																							// =
																																																																																																																																							// 50;
																																																																																																																																							// //
																																																																																																																																							// 세로
																																																																																																																																							// 최소
																																																																																																																																							// 크기
																																																																																																																																							// if(wsize
																																																																																																																																							// >
																																																																																																																																							// swidth)
																																																																																																																																							// wsize
																																																																																																																																							// =
																																																																																																																																							// swidth;
																																																																																																																																							// //
																																																																																																																																							// 가로
																																																																																																																																							// 최대
																																																																																																																																							// 크기
																																																																																																																																							// if(hsize
																																																																																																																																							// >
																																																																																																																																							// sheight)
																																																																																																																																							// hsize
																																																																																																																																							// =
																																																																																																																																							// sheight;
																																																																																																																																							// //
																																																																																																																																							// 세로
																																																																																																																																							// 최대
																																																																																																																																							// 크기
																																																																																																																																							// //
																																																																																																																																							// 세로가
																																																																																																																																							// 최대크기를
																																																																																																																																							// 초과한경우
																																																																																																																																							// 세로스크롤바
																																																																																																																																							// 자리
																																																																																																																																							// 확보
																																																																																																																																							// if((wsize
																																																																																																																																							// <
																																																																																																																																							// swidth-scrollsize)
																																																																																																																																							// &&
																																																																																																																																							// hsize
																																																																																																																																							// >=
																																																																																																																																							// sheight)
																																																																																																																																							// wsize
																																																																																																																																							// +=
																																																																																																																																							// scrollsize;
																																																																																																																																							// //
																																																																																																																																							// 가로가
																																																																																																																																							// 최대크기를
																																																																																																																																							// 초과한경우
																																																																																																																																							// 가로스크롤바
																																																																																																																																							// 자리
																																																																																																																																							// 확보
																																																																																																																																							// if((hsize
																																																																																																																																							// <
																																																																																																																																							// sheight-scrollsize)
																																																																																																																																							// &&
																																																																																																																																							// wsize
																																																																																																																																							// >=
																																																																																																																																							// swidth)
																																																																																																																																							// hsize
																																																																																																																																							// +=
																																																																																																																																							// scrollsize;
																																																																																																																																							// //
																																																																																																																																							// IE
																																																																																																																																							// 6,7
																																																																																																																																							// 전용 :
																																																																																																																																							// 가로세로
																																																																																																																																							// 크기가
																																																																																																																																							// 보통일때
																																																																																																																																							// 세로
																																																																																																																																							// 스크롤바
																																																																																																																																							// 자리
																																																																																																																																							// 확보
																																																																																																																																							// if((wsize
																																																																																																																																							// <
																																																																																																																																							// swidth-scrollsize)
																																																																																																																																							// &&
																																																																																																																																							// hsize
																																																																																																																																							// <
																																																																																																																																							// sheight&&
																																																																																																																																							// (navigator.userAgent.indexOf("MSIE
																																																																																																																																							// 6.0")
																																																																																																																																							// >
																																																																																																																																							// -1||
																																																																																																																																							// navigator.userAgent.indexOf("MSIE
																																																																																																																																							// 7.0")
																																																																																																																																							// >
																																																																																																																																							// -1))wsize
																																																																																																																																							// +=
																																																																																																																																							// scrollsize;
																																																																																																																																							// //
																																																																																																																																							// 듀얼
																																																																																																																																							// 모니터에서
																																																																																																																																							// 팝업
																																																																																																																																							// 가운데
																																																																																																																																							// 정렬하기
																																																																																																																																							// var
																																																																																																																																							// mtWidth
																																																																																																																																							// =
																																																																																																																																							// document.body.clientWidth;
																																																																																																																																							// //
																																																																																																																																							// 현재
																																																																																																																																							// 브라우저가
																																																																																																																																							// 있는
																																																																																																																																							// 모니터의
																																																																																																																																							// 화면 폭
																																																																																																																																							// 사이즈
																																																																																																																																							// var
																																																																																																																																							// mtHeight
																																																																																																																																							// =
																																																																																																																																							// document.body.clientHeight;
																																																																																																																																							// //
																																																																																																																																							// 현재
																																																																																																																																							// 브라우저가
																																																																																																																																							// 있는
																																																																																																																																							// 모니터의
																																																																																																																																							// 화면
																																																																																																																																							// 높이
																																																																																																																																							// 사이즈
																																																																																																																																							// var
																																																																																																																																							// scX
																																																																																																																																							// =
																																																																																																																																							// window.screenLeft;
																																																																																																																																							// //
																																																																																																																																							// 현재
																																																																																																																																							// 브라우저의
																																																																																																																																							// x
																																																																																																																																							// 좌표(모니터
																																																																																																																																							// 두 대를
																																																																																																																																							// 합한 총
																																																																																																																																							// 위치
																																																																																																																																							// 기준)
																																																																																																																																							// var
																																																																																																																																							// scY
																																																																																																																																							// =
																																																																																																																																							// window.screenTop;
																																																																																																																																							// //
																																																																																																																																							// 현재
																																																																																																																																							// 브라우저의
																																																																																																																																							// y
																																																																																																																																							// 좌표(모니터
																																																																																																																																							// 두 대를
																																																																																																																																							// 합한 총
																																																																																																																																							// 위치
																																																																																																																																							// 기준)
																																																																																																																																							// var
																																																																																																																																							// popX
																																																																																																																																							// =
																																																																																																																																							// scX
																																																																																																																																							// +
																																																																																																																																							// (mtWidth
																																																																																																																																							// -
																																																																																																																																							// wsize)
																																																																																																																																							// / 2
																																																																																																																																							// -
																																																																																																																																							// 50;
																																																																																																																																							// //
																																																																																																																																							// 팝업
																																																																																																																																							// 창을
																																																																																																																																							// 띄울 x
																																																																																																																																							// 위치
																																																																																																																																							// 지정(모니터
																																																																																																																																							// 두 대를
																																																																																																																																							// 합한 총
																																																																																																																																							// 위치
																																																																																																																																							// 기준)
																																																																																																																																							// var
																																																																																																																																							// popY
																																																																																																																																							// =
																																																																																																																																							// scY
																																																																																																																																							// +
																																																																																																																																							// (mtHeight
																																																																																																																																							// -
																																																																																																																																							// hsize)
																																																																																																																																							// / 2
																																																																																																																																							// -
																																																																																																																																							// 50;
																																																																																																																																							// //
																																																																																																																																							// 팝업
																																																																																																																																							// 창을
																																																																																																																																							// 띄울 y
																																																																																																																																							// 위치
																																																																																																																																							// 지정(모니터
																																																																																																																																							// 두 대를
																																																																																																																																							// 합한 총
																																																																																																																																							// 위치
																																																																																																																																							// 기준)
																																																																																																																																							// //
																																																																																																																																							// window.open('주소',
																																																																																																																																							// '이름(공란가능)',
																																																																																																																																							// '속성');
																																																																																																																																							// imageWin
																																																																																																																																							// =
																																																																																																																																							// window.open("",
																																																																																																																																							// "",
																																																																																																																																							// "top="
																																																																																																																																							// +
																																																																																																																																							// popY+
																																																																																																																																							// ",left="
																																																																																																																																							// +
																																																																																																																																							// popX+
																																																																																																																																							// ",width="
																																																																																																																																							// +
																																																																																																																																							// wsize+
																																																																																																																																							// ",height="
																																																																																																																																							// +
																																																																																																																																							// hsize+",scrollbars=yes,resizable=yes,status=no");imageWin.document.write("<html><title>Preview</title><body
																																																																																																																																							// style='margin:0;cursor:pointer;'
																																																																																																																																							// title='Close'
																																																																																																																																							// onclick='window.close()'>");imageWin.document.write("<img
																																																																																																																																							// src='"
																																																																																																																																							// +
																																																																																																																																							// imgCommonPreview.src
																																																																																																																																							// +
																																																																																																																																							// "'>");imageWin.document.write("</body></html>");
																																																																																																																																							// }

 

 