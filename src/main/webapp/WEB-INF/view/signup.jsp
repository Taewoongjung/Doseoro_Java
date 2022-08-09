<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/loginStyle.css">
    
    <title>회원가입</title>
</head>

<body>
    <div class="flex w-100">
        <!-- 상단 바 -->
        {% include "topNavbar.html" %}

        <!-- 회원가입 영역 -->
        <main class="container-sm form-signin mt-5 mb-0 min-vh-100">
            <form id="signup-form">
                <div class="loginLogo">
                    <img class="" src="/images/logo3.png" width="250px" height="100px">
                    <h1 class="h3 mt-3 mb-3">회원가입</h1>
                </div>
                
                <label for="inputName">이름</label>
                <input type="text" name="name" id="inputName" class="form-control" placeholder="이름" required autofocus>
                
                <label for="inputPhone">핸드폰</label>
                <input type="tel" name="phoneNumber" id="inputPhone" class="form-control" onkeyup="telFormat(this)"
                    pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="11" placeholder="휴대전화" required>

                <label for="inputNickname">닉네임</label>
                <input type="text" name="nickName" id="inputNickname" class="form-control" placeholder="닉네임" required>
                
                <label for="inputId">이메일</label>
                <input type="email" name="email" id="inputId" class="form-control" placeholder="ex) abc@abc" required>
                
                <label for="userPassword">비밀번호</label>
                <input type="password" name="password" id="userPassword" class="form-control" onkeyup="checkPwd()" placeholder="비밀번호" required>
                <input type="password" name="re_password" id="userPasswordCheck" class="form-control" onkeyup="checkPwd()" placeholder="비밀번호 재입력" required>
                <div class="text-danger mb-2"id="pwdCheck"></div>

                <label for="">비밀번호 찾기 질문</label>
                <select class="form-select mb-1" id="inputHint" name="question">
                  <option selected>비밀번호 힌트를 선택하세요.</option>
                  <option value="내가 감명깊게 읽었던 책 제목은?">내가 감명깊게 읽었던 책 제목은?</option>
                  <option value="내가 제일 좋아하는 동물은?">내가 제일 좋아하는 동물은?</option>
                  <option value="내가 가장 좋아하는 가수는?">내가 가장 좋아하는 가수는?</option>
                  <option value="내가 졸업한 초등학교 이름은?">내가 졸업한 초등학교 이름은?</option>
                  <option value="어머니(아버지)의 성함은?">어머니(아버지)의 성함은?</option>
                  <option value="나의 고향은?">나의 고향은?</option>
                  <option value="내가 좋아하는 색깔은?">내가 좋아하는 색깔은?</option>
                  <option value="나의 대학교는?">나의 대학교는?</option>
                </select>
                <input type="text" name="answerForQuestion" id="" class="form-control mb-3" placeholder="힌트의 답" required>
                <input id="signup" class="btn btn-lg btn-primary w-100" type="submit" value="회원가입"/>
                <input type="hidden" name="_csrf" value="csrfToken">
            </form>
        </main>

        <!-- footer -->
        <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
    </div>
    
    <script src="/js/checkFormat.js"></script>
    <script src="/js/signup-cli.js"></script>
    <script src="/js/topNav.js"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
</body>

</html>
