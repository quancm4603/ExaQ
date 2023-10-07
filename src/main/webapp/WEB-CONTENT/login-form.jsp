<%--
  Created by IntelliJ IDEA.
  User: caomi
  Date: 10/6/2023
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập vào ExaQ</title>
    <%@include file="header.jsp" %>
</head>
<body>
<div class="container justify-content-md-center" style="width: 50vw; padding-top: 5vh; padding-top: max(10vh);">

    <h1>Login to <a href="./" style="text-decoration:none; color: chocolate">ExaQ</a></h1>

    <form name="login" method="post">
        <div class="mb-3">
            <label for="exampleInputUsername1" class="form-label">Tên đăng nhập</label>
            <input name="username" type="username" class="form-control" id="exampleInputUsername1">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Ghi nhớ đăng nhập</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <h6>Chưa có tài khoản ExaQ? <a href="./register" style="text-decoration:none; color: chocolate">Tạo tài khoản</a></h6>

</div>
</body>
</html>
