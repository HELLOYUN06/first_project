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
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/header.css">
    <title>Document</title>
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
            <a href="/"><i class="fas fa-columns"></i>  대시보드</a>
            <a href="/post"><i class="fas fa-list-alt"></i>  게시글 메뉴</a>
            <a href="#"><i class="fas fa-user-circle"></i>  회원 메뉴</a>
            <a href="#"><i class="fas fa-user-cog"></i>  관리자 메뉴</a>
        </div>
    </div>
    </header>
</body>
</html>