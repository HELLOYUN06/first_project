<%@page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/header.css">
</head>
<body>
    <header>
        <div id="menu_wrap">
        <div id="user_menu">
            <a href="#" id="profile_img">
                <img src="http://placekitten.com/100/100">
                <span>수정하기</span>
            </a>
            <a href="#" id="user_name">관리자(admin)</a>
            <a href="#" id="logout">로그아웃</a>
        </div>
        <div id="main_menu">
            <a href="#">게시글 메뉴</a>
            <a href="#">회원 메뉴</a>
            <a href="#">관리자 메뉴</a>
        </div>
    </div>
    </header>
</body>
</html>