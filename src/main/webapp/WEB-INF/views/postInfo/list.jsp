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
    <link rel="stylesheet" href="/assets/css/post_list.css">
    <script src="/assets/js/post.js"></script>
<body>
    <main>
        <h1>게시글 메뉴</h1>
        <button id="add_post"><i class="far fa-edit"></i>  게시글 작성</button>
        <div class="contente_area">
            <div class="menu_area">
                <div class="search_box">
                    <select id="search_type">
                        <option value="title">제목</option>
                        <option value="cate"
                            <c:if test="${data.type=='cate'}">selected</c:if>
                        >카테고리</option>
                    </select>
                    <input type="text" id="keyword" placeholder="검색어 입력" value="${data.keyword}">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>
                <div class="table_area">
                    <table>
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>상태</td>
                                <td>카테고리</td>
                                <td>제목</td>
                                <td>내용</td>
                                <td>이미지</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>수정일</td>
                                <td>조작</td>
                            </tr>
                        </thead>
                            <tbody>
                                <c:if test="${data.total == 0}">
                                    <tr>
                                        <td id="nodata" colspan="9">등록된 게시글이 없습니다.</td>
                                    </tr>
                                </c:if>
                                <c:forEach items="${data.list}" var="p">
                                    <tr>
                                        <td>${p.pi_seq}</td>
                                        <td>
                                            <c:if test="${p.pi_state == 0}">
                                                <span>비공개</span>
                                            </c:if>
                                            <c:if test="${p.pi_state == 1}">
                                                <span>공개</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${p.pi_rq_seq == 1}">
                                                <span>가전</span>
                                            </c:if>
                                            <c:if test="${p.pi_rq_seq == 2}">
                                                <span>가구</span>
                                            </c:if>
                                            <c:if test="${p.pi_rq_seq == 3}">
                                                <span>의류</span>
                                            </c:if>
                                            <c:if test="${p.pi_rq_seq == 4}">
                                                <span>장난감/도서</span>
                                            </c:if>
                                            <c:if test="${p.pi_rq_seq == 5}">
                                                <span>etc</span>
                                            </c:if>
                                        </td>                   
                                        <td>${p.pi_title}</td>
                                        <td>${p.pi_sub}</td>
                                        <td>${p.pi_i_seq}</td>
                                        <td>${p.pi_mi_seq}</td>
                                        <td>${p.pi_reg_dt}</td>
                                        <td>${p.pi_mod_dt}</td>
                                        <td>
                                            <button class="modify_btn" data-seq="${p.pi_seq}"><i class="fas fa-pen-alt"></i></button>
                                            <button class="delete_btn" data-seq="${p.pi_seq}"><i class="far fa-trash-alt"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                    </table>
                </div>
                <div class="pager_area">
                    <button id="prev"><i class="fas fa-chevron-left"></i></button>
                    <div class="pagers">
                        <c:forEach begin="1" end="${data.pageCnt}" var="i">
                            <a href="/post?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                        </c:forEach>
                    </div>
                    <button id="next"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="post_add">
            <div class="top_area">
                <div class="ico"></div>
                <h2>게시글 추가</h2>   
                <p>게시글을 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="post_title" placeholder="제목"><br>
                <input type="text" id="post_mi_seq" placeholder="작성자">
                <input type="text" id="post_i_seq" placeholder="사진첨부">
                <select id="post_rq_seq">
                    <option value="1">가전</option>
                    <option value="2">가구</option>
                    <option value="3">의류</option>
                    <option value="4">장난감/도서</option>
                    <option value="5">etc</option>
                </select>
                <select id="post_state">
                    <option value="0">비공개</option>
                    <option value="1">공개</option>
                </select>
                <input type="text" id="post_sub" placeholder="내용">
            </div>
            <div class="btn_area">
                <button id="add_posts">등록하기</button>
                <button id="modify_posts">수정하기</button>
                <button id="cancel_posts">취소하기</button>
            </div>
</body>
</html>