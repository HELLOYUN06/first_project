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
    <link rel="stylesheet" href="/assets/css/cate_list.css">
    <script src="/assets/js/cate.js"></script>
</head>
<body>
    <main>
        <h1>카테고리 메뉴</h1>
        <button id="add_cate"><i class="far fa-edit"></i> 카테고리 추가</button>
        <div class="content_area">
            <div class="menu_area">
                <div class="search_box">
                    <input type="text" id="keyword" placeholder="검색어 입력">
                    <button id="search_btn"><i class="fas fa-search"></i></button>
                </div>
                <div class="table_area">
                    <table>
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>카테고리 명</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>수정일</td>
                                <td>조작</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${data.total == 0}">
                                <tr>
                                    <td id="nodata" colspan="6">등록된 카테고리가 없습니다.</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${data.list}" var="c">
                                <tr>
                                    <td>${c.ci_seq}</td>
                                    <td>${c.ci_name}</td>
                                    <td>${c.ci_writer}</td>
                                    <td>${c.ci_reg_Dt}</td>
                                    <td>${c.ci_mod_dt}</td>
                                    <td>
                                        <button class="modify_btn" data-seq="${c.ci_seq}"><i class="fas fa-pen-alt"></i></button>
                                        <button class="delete_btn" data-seq="${c.ci_seq}"><i class="far fa-trash-alt"></i></button>
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
                            <a href="/cate?offset=${(i-1)*10}&keyword=${data.keyword}">${i}</a>
                        </c:forEach>
                    </div>
                    <button id="next"><i class="fas fa-chevron-right"></i></button>
                </div>
            </div>
        </div>
    </main>
    <div class="popup_wrap">
        <div class="popup" id="cate_add">
            <div class="top_area">
                <div class="ico"></div>
                <h2>카테고리 추가</h2>
                <p>카테고리 정보를 입력해주세요</p>
            </div>
            <div class="content_area">
                <input type="text" id="cate_name" placeholder="카테고리 명"><br>
                <input type="text" id="cate_wirter" placeholder="작성자"><br>
            </div>
            <div class="btun_area">
                <button id="add_category">등록하기</button>
                <button id="modify_category">수정하기</button>
                <button id="cancel_category">취소하기</button>
            </div>
        </div>
    </div>
</body>
</html>