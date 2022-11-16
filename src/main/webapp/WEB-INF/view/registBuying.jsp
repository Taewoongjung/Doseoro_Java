<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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

  <title>책 등록</title>
</head>

<body>
<div class="flex w-100">
  <!-- top -->
  <%@include file="topNavbar.jsp" %>

  <!-- 책 등록 -->
  <main class="registerForm border container-sm overflow-hidden mt-0 mb-0 min-vh-100 pt-3 pb-5">
    <form id="register_book-form" class="regiRequest p-5">
      <div class="input-group">
        <input type="text" class="inputForm form-control p-3" id="postTitle" name="postmessage"
               placeholder="포스팅 제목" required autofocus>
      </div>

      <div class="input-group">
        <label for="book-name">책 이름</label>
        <input type="text" class="inputForm form-control p-3" id="book-name" name="title"
               placeholder="책 이름" required>
      </div>

      <div class="input-group">
        <label for="book-price">가격</label>
        <input type="number" class="inputForm form-control p-3" id="book-price" name="price"
               placeholder="구매 희망 가격" required>
      </div>

      <div class="input-group">
        <label for="book-author">저자</label>
        <input type="text" class="inputForm form-control p-3" id="book-author" name="author"
               placeholder="저자">
      </div>

      <div class="input-group">
        <label for="book-publisher">출판사</label>
        <input type="text" class="inputForm form-control p-3" id="book-publisher" name="publisher"
               placeholder="출판사">
      </div>

      <h1 class="h4 mt-3">카테고리</h1>
      <div class="categoryBox input-group align-items-center p-3 bg-white border"
           id="categoryCheck">
        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category1"
                                   name="checkCategory" value="경영/경제">
          <label for="book-category1" style="display: block;">경영/경제</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category2"
                                   name="checkCategory" value="학습/참고서">
          <label for="book-category2" style="display: block;">학습/참고서</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category3"
                                   name="checkCategory" value="만화">
          <label for="book-category3" style="display: block;">만화</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category4"
                                   name="checkCategory" value="과학/컴퓨터">
          <label for="book-category4" style="display: block;">과학/컴퓨터</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category5"
                                   name="checkCategory" value="외국서적">
          <label for="book-category5" style="display: block;">외국서적</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category6"
                                   name="checkCategory" value="정치/사회">
          <label for="book-category6" style="display: block;">정치/사회</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category7"
                                   name="checkCategory" value="아동">
          <label for="book-category7" style="display: block;">아동</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category8"
                                   name="checkCategory" value="인문/시/소설">
          <label for="book-category8" style="display: block;">인문/시/소설</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category9"
                                   name="checkCategory" value="여행/취미">
          <label for="book-category9" style="display: block;">여행/취미</label></div>

        <div class="d-flex"><input type="checkbox" onclick="ckLimit(this)"
                                   class="cateBox form-check-input" id="book-category11"
                                   name="checkCategory" value="기타" checked>
          <label for="book-category11" style="display: block;">기타</label></div>
      </div>

      <h1 class="h4 mt-3">거래방법</h1>
      <div>
        <a class="fw-bold h5 text-black-50 text-decoration-none" id="postMyLocation">내 위치</a>
        <select class="form-select mb-1 p-2" id="dealMethod" name="dealRoot">
          <option name="dealRoot" value="직거래, 택배" selected>직거래, 택배</option>
          <option name="dealRoot" value="직거래">직거래</option>
          <option name="dealRoot" value="택배">택배</option>
        </select>
      </div>

      <div class="usreLocation">
        {% if user.location %}
        <a><img src="/img/marker.png" width="25px" height="25px"></a>
        <a class="fw-bold h5 text-black-50 text-decoration-none" id="postLocation">{{ user.location
          }}</a>
        {% else %}
        <div id="popGuide" onmouseout="popupGuide(false)" onmouseover="popupGuide(true)"
             class="fw-bold align-items-center d-flex mb-2">
          <p><img src="/img/locationGuide.png" alt="guide" width="25px"></p>
          <a>&nbsp&nbsp위치를 등록해주세요</a>
          <a id="postLocation">{{ user.location }}</a>
        </div>
        <div id="popupBox" style="display:none;"><a>마이페이지 → "위치" 클릭</a></div>
        {% endif %}
      </div>

      <div class="input-group">
        <label for="book-about">상품설명</label>
        <textarea type="text" class="form-control p-3 mb-4" id="book-about" name="about"
                  placeholder="내용" rows="10"></textarea>
      </div>

      <button class="btn btn-lg btn-primary w-100" class="btn" type="submit" onclick="one()">상품 등록
      </button>
    </form>
  </main>

</div>

<!-- footer -->
<nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>

<script>
  function one() {
    const request = document.getElementById('register_book-form');
    request.setAttribute('action', '/wannabuy/thisbook');
    request.setAttribute('method', 'POST');
  }
</script>
<script src="/js/ckboxLimit.js"></script>
<script src="/js/topNav.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/popGuide.js"></script>
</body>

</html>