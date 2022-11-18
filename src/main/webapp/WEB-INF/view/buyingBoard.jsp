<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>삽니다</title>
</head>

<body>
<div class="flex w-100">
    <!-- top -->
    <%@include file="topNavbar.jsp" %>

    <!-- 메인페이지 -->
    <main class="min-vh-100 container-sm contentInner">
        <!-- 검색 기능 -->
        <c:choose>
            <c:when test="${obj}">
                <%@include file="searchBoxLoggedIn.jsp" %>
            </c:when>
            <c:when test="${!obj}">
                <%@include file="searchBox.jsp" %>
            </c:when>
        </c:choose>

        <div class="saleList pt-5 mt-5 border-top">
            <h1 class="h2 fw-bold mb-4">삽니다</h1>
            <form id="book-form" class="mb-5"><a href="/registerBuyingBook"
                                                 class="addBook text-decoration-none btn-primary p-2">요청
                등록</a></form>

            <!-- 각 게시물 -->
            <c:forEach var="book" items="${books}">
                <div class="postingList border p-5"
                     onclick="location.href='/buy/${book.id}'">
                    <div class="pb-3 border-bottom">
                        <div class="d-sm-flex justify-content-between align-items-center">
                            <h1 class="postingTitle h3 fw-bold">${book.postMessage}</h1>
                            <a>${book.createdAt}</a>
                        </div>
                            <%--                      <p class="mt-3">{{book.usernick}}</p>--%>
                    </div>
                    <p class="postingBody pt-3">${book.about}</p>
                </div>
            </c:forEach>
        </div>

        <!-- 페이징 -->
        {% set pageBlock = 2 %}
        <div class="pagingWrap">
            <ul id="Postpages" class="pagination">
                <li class="page-item {% if currentPage <= 1%}disabled{% endif %}">
                    <a class="page-link" href="/pages/bookRequest?page={{currentPage - 1}}"
                       aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                </li>
                {% for i in maxPage%} <!-- for문으로 페이지 번호 추가-->
                {% if i==0 or i+1==maxPage|length or (i+1>=currentPage-pageBlock and
                i+1<=currentPage|int+pageBlock) %}
                {% if currentPage-1 == i %}
                <li class="page-item active"><a class="page-link"
                                                href="/pages/bookRequest?page={{ i + 1 }}">{{ i + 1
                    }}</a></li>
                {% else %}
                <li class="page-item"><a class="page-link"
                                         href="/pages/bookRequest?page={{ i + 1 }}">{{ i + 1 }}</a>
                </li>
                {% endif %}
                {% elif i==1 or i+1==maxPage|length-2%}
                <li class="page-item"><a class="page-link">..</a></li>
                {% endif %}
                {% endfor %}
                <li class="page-item {% if currentPage >= maxPage | length %}disabled{% endif %}">
                    <a class="page-link" href="/pages/bookRequest?page={{ currentPage | int + 1 }}"
                       aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
                </li>
            </ul>
        </div>
        <div class="movePage">
            <form action="javascript:movePagesRequest()" class="d-flex">
                <input class="form-control" id="inputPage" type="number" placeholder="move page">
                <input id="maxPage" type="number" value="{{maxPage|length}}" hidden>
                <input type="submit" class="btn-primary border-0" value="이동">
            </form>
        </div>
    </main>

    <!-- footer -->
    <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
</div>

<script src="/js/topNav.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/movePage.js"></script>
</body>
</html>