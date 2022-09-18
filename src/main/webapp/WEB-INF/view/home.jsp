<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="stylesheet" href="resources/static/css/style.css">
    <title>도서로</title>
</head>

<body>
<div class="flex w-100">
    <!-- 상단 바 -->
    <%@include file="topNavbar.jsp"%>

    <!-- main -->
    <main class="container-sm min-vh-100 contentInner">
        <!-- 검색, 메뉴이동 기능 -->
        <!-- 로그인 하면 지역필터 나옴 -->
        <c:choose>
            <c:when test="${obj}">
                <%@include file="searchBoxLoggedIn.jsp"%>
            </c:when>
            <c:when test="${!obj}">
                <%@include file="searchBox.jsp"%>
            </c:when>
        </c:choose>
        <!-- 배너 -->
        <div class="bd-example">
            <div id="bannerList" class="carousel slide carousel-dark" data-bs-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-bs-target="#bannerList" data-bs-slide-to="0" class="active"></li>
                    <li data-bs-target="#bannerList" data-bs-slide-to="1"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item">
                        <div class="justify-content-center text-center pt-4" style="min-height: 500px; max-height: 500px;" focusable="false">
                            <h1 class="h3">지금 인기있는 책</h1>
                            <div class="d-flex justify-content-center">
                                {% if rankedBooks == 0 %}
                                <img class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400"
                                     xmlns="http://www.w3.org/2000/svg" role="img" focusable="false">
                                {% else %}
                                {% for book in rankedBooks %}
                                <div class="saleCard card m-2" style="max-width: 210px;" onclick="location.href='/book/{{book.id}}'">
                                    <img src="resources/img/{{book.img[0]}}" class="card-img-top" width="100%" height="280px">
                                    <div class="card-body text-center">
                                        <p class="postTitle card-title fw-bold mb-3">{{book.postmessage}}</p>
                                        {% if book.price == -1 %}
                                        <a>무료나눔</a>
                                        {% else %}
                                        <a>{{book.price}} 원</a>
                                        {% endif %}
                                    </div>
                                </div>
                                {% endfor %}
                                {% endif %}
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item active">
                        <div class="slide2Inner carousel-inner" focusable="false" style="min-height: 500px; max-height: 500px;">
                            <div class="slide2 text-center mb-4" focusable="false">
                                <p class="slideTitle">도서로</p><br>
                                <p class="slideSubTitle">중고 도서 거래 플랫폼</p>
                                <a class="slideGuide" onclick="popUpPage()">이용방법</a>
                            </div>
                        </div>
                    </div>

                    <a class="carousel-control-prev" href="#bannerList" role="button" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#bannerList" role="button" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <!-- 판매리스트 -->
        <div class="saleList pt-5 mt-5 border-top">
            <div class="d-flex align-items-center">
                <h2 class="h3 fw-bold">최근 판매 목록</h2>
                <a class="ms-3 mb-2 fw-bold text-decoration-none" href="/saleBoard">더보기</a>
            </div>
            <div class="d-flex flex-wrap justify-content-center">
                <c:forEach var="book" items="${books}">
                    <div class="saleCard card mt-4 m-2" style="max-width: 210px;" onclick="location.href='/book/{{book.id}}'">
                        <img src="resources/uploads/imgs${book.images[0]}" class="card-img-top" width="100%" height="280px">
                        <div class="card-body text-center">
                            <p class="postTitle card-title fw-bold mb-3">${book.title}</p>
                            <a>${book.price} 원</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!-- 무료나눔 -->
        <div class="saleList pt-5 mt-5 border-top">
            <div class="d-flex align-items-center">
                <h2 class="h3 fw-bold">무료나눔</h2>
                <a class="ms-3 mb-2 fw-bold text-decoration-none" href="/pages/donationBoard">더보기</a>
            </div>
            <div class="d-flex flex-wrap justify-content-center">
                {% for book in freeBooksIndex %}
                <div class="saleCard card mt-4 m-2" style="max-width: 210px;" onclick="location.href='/book/{{book.id}}'">
                    <img src="/img/{{book.img[0]}}" class="card-img-top" width="100%" height="280px">
                    <div class="card-body text-center">
                        <p class="postTitle card-title fw-bold mb-3">{{book.postmessage}}</p>
                        <a>{{book.usernick}}</a>
                    </div>
                </div>
                {% endfor %}
            </div>
        </div>

        <!-- 삽니다 -->
        <div class="saleList pt-5 mt-5 border-top">
            <div class="d-flex align-items-center">
                <h2 class="h3 fw-bold">구매희망</h2>
                <a class="ms-3 mb-2 fw-bold text-decoration-none" href="/pages/bookRequest">더보기</a>
            </div>
            <div class="d-flex flex-wrap justify-content-center">
                {% for book in wannabuyBooksIndex %}
                <div class="buycard card ms-2 me-3 mb-3" style="width: 18rem;"
                     onclick="location.href='/wannabuy/buybook/{{book.id}}'">
                    <div class="postTitle card-header fw-bold p-3">{{book.postmessage}}</div>
                    <div class="card-body text-secondary pt-4 pb-4">
                        <h5 class="card-title postTitle fw-bold">{{book.usernick}}</h5>
                        <br>
                        <p class="card-text postMsg">{{book.about}}</p>
                    </div>
                </div>
                {% endfor %}
            </div>
        </div>
    </main>

    <!-- footer -->
    <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
</div>
<script>
    function one() {
        const request = document.getElementById('search-form');
        request.setAttribute('action', '/search{{searchWord}}');
        request.setAttribute('method', 'GET');
    }
</script>
<script src="resources/js/topNav.js"></script>
<script src="resources/css/bootstrap.min.css"></script>
<script src="resources/js/popGuide.js"></script>

</body>

</html>
