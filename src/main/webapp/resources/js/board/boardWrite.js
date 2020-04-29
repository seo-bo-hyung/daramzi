	function check_write() {
         if ($("#title").val() == "" || $("#title").val() == null) {
            alert("제목을 입력하세요.");
            $("#title").focus();
            return;
        } else if ($("#content").val() == "" || $("#content").val() == null) {
            alert("내용을 입력하세요.");
            $("#content").focus();
            return;
        }  else {
        	$("#boardWrite").submit();
        }
    }

	function check_modify() {
        if ($("#title").val() == "" || $("#title").val() == null) {
            alert("제목을 입력하세요.");
            $("#title").focus();
            return;
        } else if ($("#content").val() == "" || $("#content").val() == null) {
            alert("내용을 입력하세요.");
            $("#content").focus();
            return;
        }else {
        	$("#modComp").submit();
        }
    }