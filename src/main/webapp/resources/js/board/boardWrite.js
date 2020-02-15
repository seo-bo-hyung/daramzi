	function check_write() {
        if ($("#name").val() == "" || $("#name").val() == null) {
            alert("이름을 입력하세요.");
            $("#name").focus();
            return;
        } else if ($("#email").val() == "" || $("#email").val() == null) {
            alert("이메일을 입력하세요.");
            $("#email").focus();
            return;
        } else if ($("#title").val() == "" || $("#title").val() == null) {
            alert("제목을 입력하세요.");
            $("#title").focus();
            return;
        } else if ($("#content").val() == "" || $("#content").val() == null) {
            alert("내용을 입력하세요.");
            $("#content").focus();
            return;
        } else if ( $("#password").val() == "" || $("#password").val() == null) {
            alert("비밀번호를 입력하세요.");
            $("#password").focus();
            return;
        } else {
        	$("#boardWrite").submit();
        }
    }

	function check_modify() {
        if ($("#name").val() == "" || $("#name").val() == null) {
            alert("이름을 입력하세요.");
            $("#name").focus();
            return;
        } else if ($("#email").val() == "" || $("#email").val() == null) {
            alert("이메일을 입력하세요.");
            $("#email").focus();
            return;
        } else if ($("#title").val() == "" || $("#title").val() == null) {
            alert("제목을 입력하세요.");
            $("#title").focus();
            return;
        } else if ($("#content").val() == "" || $("#content").val() == null) {
            alert("내용을 입력하세요.");
            $("#content").focus();
            return;
        } else if ( $("#pass").val() == "" || $("#pass").val() == null) {
            alert("비밀번호를 입력하세요.");
            $("#pass").focus();
            return;
        }else if ( $("#pass").val() != $("#password").val()) {
            alert("입력하신 비밀번호가 상이합니다.");
            $("#pass").focus();
            return;
        }else {
        	$("#modComp").submit();
        }
    }