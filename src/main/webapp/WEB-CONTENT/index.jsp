<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ExaQ</title>
    <%@include file="header.jsp" %>
</head>
<body>
<div class="nav-bar container align-item-right">

    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #e3f2fd;">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="./">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Môn học
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Toán</a></li>
                            <li><a class="dropdown-item" href="#">Lí</a></li>
                            <li><a class="dropdown-item" href="#">Hóa</a></li>
                            <li><a class="dropdown-item" href="#">Sinh</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Kiểm tra
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Trắc nghiệm</a></li>
                            <li><a class="dropdown-item" href="#">Tự luận</a></li>
                        </ul>
                    </li>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </ul>
                <a href="./login">
                    <button class="btn btn-outline-success" type="submit">Sign in</button>
                </a>

            </div>
        </div>
    </nav>
</div>
<%--NAV bar--%>
</body>
</html>