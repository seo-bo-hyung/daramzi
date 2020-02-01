<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 삭제하기</title>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
    font-family: 'Nanum Gothic', sans-serif;
}
</style>
 
<script type="text/javascript">
function check(storPass) {
    if (document.form.password.value == "") {
        alert("패스워드를 입력하세요.");
        form.pass.focus();
        return false;
    }
    if(document.form.password.value != storPass){
        alert("비밀번호가 틀리셨습니다.");
            form.pass.focus();
        return false;
    }
    document.form.submit();
}
</script>
</head>
 
<body>
    <center>
    <br><br>
    <table width=50% cellspacing=0 cellpadding=3>
         <tr>
            <td bgcolor=#dcdcdc height=21 align=center>
            작성자의 비밀번호를 입력해 주세요.</td>
        </tr>
    </table>
    
    <table width=70% cellspacing=0 cellpadding=2>
        <form name=form method=post action="boardDelete.action" >
        <input type ="hidden"  name="storPass" value="${storPass}"/>
        <input type ="hidden"  name="seq" value="${seq }"/>
     <tr>
        <td align=center>
        <table align=center border=0 width=91%>
    <tr> 
         <td align=center>  
          <input type=password name="password" size=17 maxlength=15>
         </td> 
    </tr>
    <tr>
        <td><hr size=1 color=#eeeeee></td>
    </tr>
    <tr>
        <td align=center>
      <input type=button value="삭제완료" onClick="check('${storPass}')"> 
      <input type=reset value="다시쓰기"> 
      <input type=button value="뒤로" onClick="history.go(-1)">
        </td>
    </tr> 
    </table>
    </td>
    </tr>
    </form> 
    </table>
    </center>
</body>
</html>
