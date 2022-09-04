<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/loginStyle.css">
    <title>로그인</title>
</head>

<body>
    <div class="flex w-100">
        <!-- 상단 바 -->
        <%@include file="topNavbar.jsp"%>

        <!-- 로그인 영역 -->
        <main class="form-signin container-sm mt-5 vh-100">
            <form id="login-form">
                <div class="loginLogo">
                    <img class="" src="resources/images/logo3.png" width="250px" height="100px">
                    <h1 class="h3 mt-3 mb-3">로그인</h1>
                </div>
                <input type="email" name="email" class="form-control" placeholder="이메일" autofocus>
                <input type="password" name="password" class="form-control" placeholder="비밀번호">
                <ul class="row">
                    <li class="col">
                        <a class="" href="/signup">회원가입</a>
                    </li>
                    <li class="col">
                        <a class="" href="/pages/findID">아이디 찾기</a>
                    </li>
                    <li class="col">
                        <a class="" href="/pages/findPW">비밀번호 찾기</a>
                    </li>
                </ul>
                <button class="btn btn-lg btn-primary mb-3 w-100" id="login" type="submit">로그인</button>
                <a class="kakaoLogin" id="kakao" href="/auth/kakao"><img src="resources/images/kakaoLogin.png" class="w-100 mb-2 p-0"></a>
                <a class="googleLogin" id="google" href="/auth/google"><img src="resources/images/googleLogin.png" height="67" class="w-100"></a>
            </form>
        </main>

        <!-- footer -->
        <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
    </div>
    <script src="resources/js/login-cli.js"></script>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <script src="resources/js/login-cli.js"></script>
    <script src="resources/js/topNav.js"></script>
  </body>

</html>