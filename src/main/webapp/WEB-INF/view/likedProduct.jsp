<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/style.css">
    <title>도서로 - 관심상품</title>
</head>

<body>
    <div class="flex w-100">
        <!-- 상단 바 -->
        <%@include file="topNavbar.jsp"%>

        <!-- main -->
        <main class="container-sm mt-0 mb-0 min-vh-100 border">
            <div class="p-5">
                <h1 class="h4 fw-bold mb-5">관심상품</h1>
                <div class="mb-5">
                    <h1 class="h4 fw-bold">판매</h1>
                    <c:forEach var="book" items="${books}">
                        {% for book in books %}
                        <div class="likeList w-100 mt-3 mb-3 border d-flex flex-wrap" onclick="location.href='/${book.id}'">
                            <img src="/images/img${book.images[0]}" class="" width="150px" height="200px">
                            <div class="ms-4">
                                <h1 class="h2 m-1 mb-3  fw-bold">${book.title}</h1>
                                <h4 class="h5 m-1">${book.price} 원</h4>
                            </div>
                        </div>
                        {% endfor %}
                    </c:forEach>
                </div>
                <div>
                    <h1 class="h4 fw-bold">무료나눔</h1>
                    {% for book in free_books %}
                    <div class="likeList w-100 mt-3 mb-3 border d-flex flex-wrap" onclick="location.href='/book/{{book.thisbook}}'">
                        <img src="/images/{{book.img[0]}}" class="" width="150px" height="200px">
                        <div class="ms-4">
                            <h1 class="h2 m-1 mb-3  fw-bold">{{book.posttitle}}</h1>
                        </div>
                    </div>
                {% endfor %}
                </div>
            </div>
        </main>

        <!-- footer -->
        <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
    </div>

    <script src="/js/topNav.js"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
