<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

  <link rel="stylesheet" href="resources/css/style.css">

  <title>팝니다</title>
</head>

<body>
  <div class="flex w-100">
    <!-- 상단 바 -->
      <%@include file="topNavbar.jsp"%>

    <!-- main -->
    <main class="container-sm min-vh-100 contentInner">
      <!-- 검색, 메뉴이동 기능 -->
        <c:choose>
            <c:when test="${obj}">
                <%@include file="searchBoxLoggedIn.jsp"%>
            </c:when>
            <c:when test="${!obj}">
                <%@include file="searchBox.jsp"%>
            </c:when>
        </c:choose>

      <!-- 판매리스트 -->
      <div class="saleList pt-5 mt-5 border-top">
        <h1 class="h2 fw-bold">판매중인 책</h1><br>
        <form id="book-form"><a href="/pages/registerBook" class="addBook text-decoration-none btn-primary p-2">상품 등록</a>
        </form>

        <div class="d-flex justify-content-center flex-wrap mt-5">
          {% for book in books %}
          {% if book.price > 0 %}
          <div class="saleCard card m-sm-5 mt-4 m-2" style="max-width: 210px;"
            onclick="location.href='/book/{{book.id}}'">
            <img src="resources/img/{{book.img[0]}}" class="card-img-top" width="100%" height="280px">
            <div class="card-body text-center">
              <p class="postTitle card-title fw-bold mb-3">{{book.postmessage}}</p>
              <p>{{book.price}} 원</p>
            </div>
          </div>
          {% endif %}
          {% endfor %}
        </div>

        <!-- 페이징 -->
        {% set pageBlock = 2 %}
        <div class="pagingWrap">
            <ul id="Postpages"class="pagination">
                <li class="page-item {% if currentPage <= 1%}disabled{% endif %}">
                    <a class="page-link" href="/pages/saleBoard?page={{currentPage - 1}}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                </li>
                {% for i in maxPage%} <!-- for문으로 페이지 번호 추가-->
                    {% if i==0 or i+1==maxPage|length or (i+1>=currentPage-pageBlock and i+1<=currentPage|int+pageBlock) %}
                      {% if currentPage-1 == i %}
                      <li class="page-item active"><a class="page-link" href="/pages/saleBoard?page={{ i + 1 }}">{{ i + 1 }}</a></li>
                      {% else %}
                      <li class="page-item"><a class="page-link" href="/pages/saleBoard?page={{ i + 1 }}">{{ i + 1 }}</a></li>
                      {% endif %}
                    {% elif i==1 or i+1==maxPage|length-2%}
                    <li class="page-item"><a class="page-link">..</a></li>
                    {% endif %}
                {% endfor %}
                <li class="page-item {% if currentPage >= maxPage | length %}disabled{% endif %}">
                    <a class="page-link" href="/pages/saleBoard?page={{ currentPage | int + 1 }}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
                </li>
            </ul>
        </div>
        <div class="movePage">
            <form action="javascript:movePagesSale()" class="d-flex">
                <input class="form-control" id="inputPage" type="number" placeholder="move page">
                <input id="maxPage" type="number" value="{{maxPage|length}}" hidden>
                <input type="submit" class="btn-primary border-0" value="이동">
            </form>
        </div>
    </main>

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
  <script src="resources/js/bootstrap.bundle.min.js"></script>
  <script src="resources/js/movePage.js"></script>
</body>

</html>