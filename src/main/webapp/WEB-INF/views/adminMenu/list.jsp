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
</head>
<body>
    <main>
        <h1>관리자 메뉴</h1>
        <button>글 삭제</button>
        <div class="menu_area">
            <div class="search_box">
                <input type="text" id="keyword">
            </div>
        </div>
    </main>
</body>
</html>