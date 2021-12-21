<%@page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@include file="/WEB-INF/includes/header.jsp"%>
    <link rel="stylesheet" href="/assets/css/index.css">
    <script>
        $(function(){
            $(".main_menu a:nth-child(1)").addClass("active");
        })
    </script>
</head>
<body>
    
    <main>
    <h1>중고물품 관리 대시보드</h1>
    <div class="content_area">
        <div class="cate_info">
            <h2><i class="fas fa-grip-horizontal"></i>카테고리 메뉴</h2>
            <p> 총 카테고리 : <span>${cnt.cate[0]}</span></p>
            <p> 업데이트 날짜 : <span>2021-12-21 00:00:00</span></p>
        </div>
        <div class="post_info">
            <h2><i class="fas fa-list-alt"></i>게시글 메뉴</h2>
            <p> 총 게시글 : <span>${cnt.post[0]}</span></p>
            <p> 공지글 : <span>${cnt.post[1]}</span></p>
            <p> 이미지 게시글 : <span>${cnt.post[2]}</span></p>
            <p> 업데이트 날짜 : <span>2021-12-10 00:00:00</span></p>
        </div>
        <div class="member_info">
            <h2><i class="fas fa-user-circle"></i>회원 메뉴</h2>
            <p> 총 회원 수 :  <span>${cnt.member[0]}</span></p>    
            <p> 정회원 수 : <span>${cnt.member[1]}</span></p>
            <p> 사용정지 회원 : <span>${cnt.member[2]}</span></p>
            <p> 업데이트 날짜 : <span>2021-12-10 00:00:00</span></p>
        </div>
        <div class="admin_info">
            <h2><i class="fas fa-user-cog"></i>관리자 메뉴</h2>
            <p> 총 관리자 수 : <span>${cnt.admin[0]}</span> </p>
            <p> 업데이트 날짜 : <span>2021-12-10 00:00:00</span> </p>
        </div>
    </div>
    </main>
</body>
</html>