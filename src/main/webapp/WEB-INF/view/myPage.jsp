<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--마이페이지--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>내 정보</title>
</head>

<body>
    <div class="flex w-100">
        <!-- top -->
        <%@include file="topNavbar.jsp"%>

        <!-- 마이페이지 -->
        <main class="myPage min-vh-100 container-sm border p-5">
            <div class="profile d-flex flex-wrap align-items-center pb-5">
                <img src="/images/profileImg.png" class="rounded-circle w-25" alt="profile">
                <div class="ms-5">
                    <h1 class="h3 fw-bold">${user.nickName}</h1>
                    <c:set var="user" value="${user}"/>
                    <c:if test="${user.location}">
                        <div id="myAddr" class="mt-1 mb-3 fw-bold">나의 위치 : {{user.location}}</div>
                    </c:if>
                    <div id="myAddr" class="mt-1 mb-3 fw-bold">위치를 등록해주세요</div>
                    <div class="gelocationBtn d-flex">
                        <button class="btn btn-primary me-3" type="submit" onclick="getLocation()">위치</button>

                        <input id="getMyAddr" name="address" style="display: none;">
                        <form id="regions">
                            <input type="hidden" name="region1" id="getFirstAddr" value="">
                            <input type="hidden" name="region2" id="getSecondAddr" value="">
                            <input type="hidden" name="region3" id="getThirdAddr" value="">
                            <input type="hidden" name="wholeRegion" id="getAllAddr" value="">
                            <button id="submitBtn" style="display: none;" class="btn btn-primary" type="submit" onclick="fixAddr()">위치설정하기</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- 카카오맵 -->
            <div class="mb-3">
                <div id="kakao_map" class="w-50 flex-wrap ms-0 mb-0"
                    style="min-width:350px; min-height:350px; border-radius: 15px; display: none;"></div>
            </div>

            <div class="myPageList text-center d-flex flex-wrap justify-content-center">
                <a class="m-sm-4" href="/pages/like">
                    <img src="/images/bookmark.png" alt="관심상품">
                    <p class="text-decoration-none">관심상품</p>
                </a>
                <a class="m-sm-4" href="/pages/myPostingList">
                    <img src="/images/postingList.png" alt="내가 쓴 글">
                    <p>내가 쓴 글</p>
                </a>

                <!-- 거래내역추가 -->
                <a class="m-sm-4" href="/tradeHistory">
                    <img src="/images/purchaseList.png" alt=" 거래내역">
                    <p>거래내역</p>
                </a>

                <a class="m-sm-4" href="/pages/csList">
                    <img src="/images/qna.png" alt="고객문의">
                    <p>고객문의</p>
                </a>
            </div>
        </main>
        <!-- footer -->
        <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
    </div>
    <!-- kakao maps API의 service 라이브러리 -->
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0557dfefeb3b6dfb23b5c3e62231657b&libraries=services"></script>

    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0557dfefeb3b6dfb23b5c3e62231657b"></script>
    <script src="js/userLocation.js"></script>
    <script src="js/topNav.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script>
        function fixAddr(){
            const request = document.getElementById('regions');
            alert("위치등록을 완료했습니다");

            request.setAttribute('action', 'mpfunc/location');
            request.setAttribute('method', 'GET');
        }
    </script>
</body>

</html>