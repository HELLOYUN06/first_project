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
        <h1>회원 메뉴</h1>
        <button id="add_member"><i class="fas fa-user-plus"></i> 회원 등록</button>
        <div class="menu_area">
            <div class="search_box">
                <input type="text" id="keyword" placeholder="검색어 입력" value="${data.keyword}">
                <button id="search_btn"><i class="fas fa-search"></i></button>
            </div>
        </div>
        <div class="table_area">
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>아이디</td>
                        <td>이름</td>
                        <td>비밀번호</td>
                        <td>생년월일</td>
                        <td>주소</td>
                        <td>이메일</td>
                        <td>핸드폰번호</td>
                        <td>상태</td>
                        <td>조작</td>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${data.total==0}">
                        <tr>
                            <td id="nodata" colspan="10">등록된 회원이 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${data.list}" var="m">
                        <tr>
                            <td>${m.mi_seq}</td>
                            <td>  0:휴면회원 1:정회원 2:승인대기 3:탈퇴회원
                                <c:if test="${m.mi_state == 0}">
                                    <span>휴면회원</span>
                                </c:if>
                                <c:if test="${m.mi_state == 1}">
                                    <span>정회원</span>
                                </c:if>
                                <c:if test="${m.mi_state == 2}">
                                    <span>승인대기</span>
                                </c:if>
                                <c:if test="${m.mi_state == 3}">
                                    <span>탈퇴회원</span>
                                </c:if>
                            </td>
                            <td>${m.mi_id}</td>
                            <td>${m.mi_name}</td>
                            <td>${m.mi_pwd}</td>
                            <td>${m.mi_birth}</td>
                            <td>${m.mi_address}</td>
                            <td>${m.mi_email}</td>
                            <td>${m.mi_phone_num}</td>
                            <td>${m.mi_reg_dt}</td>
                            <td>
                                <button class="modify_btn" data-seq="${m.mi_seq}"><i class="fas fa-pen-alt"></i></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page_area">
            <button id="prev"><i class="fas fa-chevron-left"></i></button>
            <div class="pagers">
                <c:forEach begin="1" end="${data.pageCnt}" var="i"> 
                    <a href="/member?offset=${(i-1)*10}keyword=${data.keyword}">${i}</a>
                </c:forEach>
            </div>
            <button id="next"><i class="fas fa-chevron-right"></i></button>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="member_add">
            <div class="top_area">
                <div class="ico"></div>
                <h2>멤버 추가</h2>
                <p>멤버정보를 입력해주세요.</p>
            </div>
            <div class="content_area">
                <input type="text" id="member_id" placeholder="아이디">
                <input type="text" id="member_pwd" placeholder="비밀번호"><br>
                <input type="text" id="member_name" placeholder="이름">
                <input type="text" id="member_birth" placeholder="생년월일"><br>
                <input type="text" id="member_address" placeholder="주소">
                <input type="text" id="member_phone_num" placeholder="휴대폰번호">
                <input type="text" id="member_email" placeholder="이메일">
                <input type="text" id="member_state" placeholder="회원상태" disabled>
            </div>
            <div class="btn_area">
                <button id="add_members">등록</button>
                <button id="modify_members">수정</button>
                <button id="cancel_members">등록</button>
            </div>
        </div>
    </div>
</body>
</html>