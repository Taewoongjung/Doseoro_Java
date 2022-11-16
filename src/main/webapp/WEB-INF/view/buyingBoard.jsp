<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">

    <link rel="stylesheet" href="/css/style.css">
    <title>도서로 - 구매내역</title>
</head>

<body>
<div class="flex w-100">
    <!-- 상단 바 -->
    <%@include file="topNavbar.jsp" %>

    <!-- 검색, 메뉴이동 기능 -->
    <c:choose>
        <c:when test="${obj}">
            <%@include file="searchBoxLoggedIn.jsp" %>
        </c:when>
        <c:when test="${!obj}">
            <%@include file="searchBox.jsp" %>
        </c:when>
    </c:choose>

    <!-- main -->
    <main class="container-sm mt-0 mb-0 min-vh-100 border">
        <div class="p-5">
            <h1 class="h4 fw-bold">구매 목록</h1>
            {% for book in books %}
            <div class="likeList w-100 mt-3 mb-3 border d-flex flex-wrap"
                 onclick="location.href='/wannabuy/buybook/{{book.id}}'">

                <div class="d-flex w-75 justify-content-between mt-2">
                    <div class="ms-sm-4">
                        <h1 class="h2 m-1 fw-bold mb-3">{{book.title}}</h1>
                        <h4 class="h5 m-1 mb-2">가격: {{book.price}} 원</h4>
                        <h4 class="h5 m-1 mb-2">카테고리: {{book.category}}</h4>
                        <h4 class="h5 m-1 mb-2">거래 방법: {{book.tradingmethod}}</h4>
                    </div>
                    <div>
                        <form id="item-ED-form-{{book.id}}">
                            <input type="hidden" id="delete_it-{{book.id}}" name="this_item_id"
                                   value="{{book.id}}">
                            <input type="hidden" id="delete_it-{{book.id}}" name="this_item_OwnerId"
                                   value="{{book.OwnerId}}">
                            <input type="hidden" id="delete_it-{{book.id}}"
                                   name="this_item_createdAt" value="{{book.createdAt}}">
                            <div class="dropdown">
                                <a class="btn" href="#" data-bs-toggle="dropdown"
                                   aria-expanded="true">⁝</a>
                                <ul class="dropdown-menu" aria-labelledby="dropdown1">
                                    <li>
                                        <button id="item-edit-btn-{{book.id}}" class="dropdown-item"
                                                role="menuitem" tabindex="-1" type="submit"
                                                class="btn"
                                                onclick="item_edit('{{book.id}}')">수정
                                        </button>
                                    </li>
                                    <li>
                                        <button id="item-delete-btn-{{book.id}}"
                                                class="dropdown-item"
                                                role="menuitem" tabindex="-1" type="submit"
                                                class="btn"
                                                onclick="item_delete('{{book.id}}')">삭제
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            {% endfor %}
        </div>
    </main>

    <!-- footer -->
    <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
</div>
<script>
  function item_edit(id) {
    const request = document.getElementById(`item-ED-form-${id}`);
    request.setAttribute('action', '/wannabuy/editIt');
    request.setAttribute('method', 'POST');
  }

  function item_delete(id) {
    const request = document.getElementById(`item-ED-form-${id}`);
    request.setAttribute('action', '/wannabuy/delete');
    request.setAttribute('method', 'GET');
  }
</script>
<script src="/js/topNav.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>