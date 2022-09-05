<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="search-form" action="/search/it" class="searchForm container pt-2">
        <div class="d-flex align-it">
                <select class="form-select w-25" name="searchFilter">
                        <option value="All">전체</option>
                        <option value="postTitle">게시물</option>
                        <option value="bookTitle">책</option>
                        <option value="bookAuther">저자</option>
                        <option value="bookPublisher">출판사</option>
                        <option value="community">커뮤니티</option>
                </select>
                <input type="text" class="form-control ps-3" id="book-publisher" name="searchWord" placeholder="검색" onkeyup="checkText()">
                <button id="submitBtn" class="btn btn-primary" type="submit" disabled="true"><img src="/img/pngegg.png" width="35" height="25"
                                class="mt-1"></button>
        </div>
</form>

<!-- 메뉴이동 -->
<div class="menuForm container mt-2 mb-2 justify-content-center d-flex" role="group">
        <div class="menuBtn"><button type="button" class="btn fw-bold"
                        onclick="location.href='/pages/saleBoard'">팝니다</button></div>
        <div class="menuBtn"><button type="button" class="btn fw-bold"
                        onclick="location.href='/pages/bookRequest'">삽니다</button></div>
        <div class="menuBtn"><button type="button" class="btn fw-bold"
                        onclick="location.href='/pages/donationBoard'">무료나눔</button></div>
        <div class="menuBtn"><button type="button" class="btn fw-bold"
                        onclick="location.href='/pages/community'">커뮤니티</button></div>
</div>

<script src="resources/js/checkFormat.js"></script>