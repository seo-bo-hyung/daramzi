<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="panel-body">
   <form:form role="form" commandName="loginCommand" action="/login" method="post">
        <fieldset>
            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="ID" path="id"/>
            </div>
            <div class="form-group">
                 <form:password class="form-control" placeholder="Password" path="pw"/>
            </div>
            <div class="checkbox">
                <label>
                    <form:checkbox path="rememberId"/>아이디 기억
                </label>
            </div>
                <button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
        </fieldset>
    </form:form>
</div>
</body>
</html>