$(document).ready(function(){
	
	$("#upForm1").ajaxForm({
		success: function(data, status){
			$("#upResult").html("파일 업로드 완료.<br>");
			var appChild = "<p class='cau'><button id='refreshForm' onclick='refresh()'>";
			appChild += "업로드 폼 초기화</button>※폼을 초기화할 경우, 클릭하십시오.</p>";
			$("#upResult").append(appChild);
   		}
    });
	
});

//웹첨부파일 보안을 위한 조치
function fileCheck(frm) {
	var file = frm.file.value;
	var fileExt = file.substring(file.lastIndexOf('.') + 1); // 파일의 확장자를
																// 구합니다.
	var bSubmitCheck = true;

	if (!file) {
		alert("파일을 선택하여 주세요!");
		return;
	}

	if (fileExt.toUpperCase() == "ASP" || fileExt.toUpperCase() == "PHP"
			|| fileExt.toUpperCase() == "JSP") {
		alert("ASP,PHP,JSP 파일은 업로드 하실 수 없습니다!");
		return;
	}

	alert("파일 업로드를 시작합니다.");
	frm.submit();

}

// 업로드폼 초기화
function refresh(){
	// 페이지 리로드를 사용한 폼 초기화
	location.reload(true);
}
