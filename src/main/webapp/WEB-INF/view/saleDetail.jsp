<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="css/style.css">

    <title>책 구경📖 ${title}</title>
</head>

<body>
    <div class="flex w-100">
        <!-- 상단 바 -->
        <%@include file="topNavbar.jsp"%>

        <!-- 컨텐츠 -->
        <main class="saleDetail border container-sm overflow-hidden mt-0 mb-0 min-vh-100 pt-3 pb-5">
            <!-- 검색, 메뉴이동 기능 -->
            <%@include file="searchBox.jsp"%>

            <div class="w-75 ms-auto me-auto">
                <!-- 제목 -->
                <div class="w-100 pb-2 mb-4 border-bottom">
                    <div class="d-sm-flex align-items-center justify-content-between">
                        <h1 class="h2 fw-bold" id="getPostingTitle">${book.postMessage}</h1>
                        <p class="">조회수 : {{book.hits}}</p>
                    </div>
                    <div class="d-lg-flex align-items-center justify-content-between">
                        <div class="d-flex align-items-center mb-2">
                            <p class="me-2 mt-2 fw-bold">${user.nickName}</p>
<%--                            이거는 위치 정보. 카카오 api 붙이고 연결할 예정--%>
<%--                            {% if this_book_location %} --%>
<%--                            <p><a><img src="images/marker.png" width="20px"></a>{{this_book_location}}</p>--%>
<%--                            {% else %}--%>
<%--                            <p><a><img src="images/marker.png" width="20px"></a>미등록</p>--%>
<%--                            {% endif %} --%>
                        </div>
                        <a class="text-decoration-none text-dark text-end" id="getPostingDate"></a>
                        <input id="postingTime" type="hidden" value="{{createdAt}}">
                    </div>
                </div>

                <!-- 책 정보 -->
                <div class="wrapBookInfo d-lg-flex align-items-center ">
                    <!-- 이미지 슬라이드 -->
                    <div id="carouselExampleControls" class="carousel slide slideBox" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <c:set var="book" value="${book}"/>
                            <c:if test="${book.images[0] ne null}">
                                <div class="carousel-item active">
                                    <img class="" src="uploads/imgs${book.images[0]}" style="border-radius:21px;" width="320px"
                                        height="400px" alt="bookImg">
                                </div>
                            </c:if>
                            <c:if test="${book.images[1] ne null}">
                                <div class="carousel-item">
                                    <img class="" src="uploads/imgs${book.images[1]}" style="border-radius:21px" width="320px"
                                        height="400px" alt="bookImg">
                                </div>
                            </c:if>
                            <c:if test="${book.images[2] ne null}">
                                <div class="carousel-item">
                                    <img class="" src="uploads/imgs${book.images[2]}" style="border-radius:21px" width="320px"
                                        height="400px" alt="bookImg">
                                </div>
                            </c:if>
                            <c:if test="${book.images[3] ne null}">
                                <div class="carousel-item">
                                    <img class="" src="uploads/imgs${book.images[3]}" style="border-radius:21px" width="320px"
                                        height="400px" alt="bookImg">
                                </div>
                            </c:if>
                            <c:if test="${book.images[4] ne null}">
                                <div class="carousel-item">
                                    <img class="" src="uploads/imgs${book.images[4]}" style="border-radius:21px" width="320px"
                                        height="400px" alt="bookImg">
                                </div>
                            </c:if>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>

                    <div class="bookInfo w-75 me-0 ms-sm-5 align-content-between">
                        <div class="d-flex mb-3 align-items-center w-100 justify-content-between">
                            <div class="saleCheck d-flex border-0 p-2 me-2 align-items-center"
                                style="border-radius: 10px">
                                <c:set var="book" value="${book}"/>
                                <c:if test="${book.price eq null}">
                                    <c:if test="${book.sold eq '1'}">
                                            <a class="h5 mb-0 text-decoration-none fw-bold">나눔완료</a>
                                    </c:if>
                                        <a class="h5 mb-0 text-decoration-none fw-bold">무료나눔</a>
                                </c:if>
                                <c:if test="${book.price ne null}">
                                    <c:if test="${book.sold eq '1'}">
                                        <a class="h5 mb-0 text-decoration-none fw-bold">판매완료</a>
                                    </c:if>
                                        <a class="h5 mb-0 text-decoration-none fw-bold">판매</a>
                                </c:if>
                                <div class="">
                                    <form id="book_like-form">
                                        <div class="saleCheck border-0 p-2 d-flex" style="border-radius: 10px">
                                            <!-- 책 올린 사람 찾기 위함 -->
                                            <input type="hidden" name="createdat" value="{{book.createdAt}}">
                                            <!-- OwnerId -->
                                            <input type="hidden" name="userId" value="${sessionScope.ACCESS_USER}">
                                            <!-- BookId -->
                                            <input type="hidden" name="bookId" value="${book.id}">
<%--                                            {% if book.sold == 1 %}--%>
<%--                                            {% else %}--%>
                                                <button class="btn  btn-outline-primary" class="btn" type="submit"
                                                    onclick="like()" style="border: 0px">❤️</button>

                                                    <!-- 좋아요 눌린 갯수 -->
                                                <div class="saleCheck border-0 pt-1" style="border-radius: 10px">
                                                    <a class="h5 text-decoration-none fw-bold">+ {{book.likecount}}</a>
                                                </div>
<%--                                            {% endif %}--%>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div>
                                <form id="sell_item-ED-form-{{book.id}}">
                                    <input type="hidden" id="delete_it-{{book.id}}" name="this_item_id"
                                        value="{{book.id}}">
                                    <input type="hidden" id="delete_it-{{book.id}}" name="this_item_OwnerId"
                                        value="{{book.OwnerId}}">
                                    <input type="hidden" id="delete_it-{{book.id}}" name="this_item_createdAt"
                                        value="{{book.createdAt}}">
                                    <div class="dropdown">
                                        <a class="btn kebobMenu" href="#" data-bs-toggle="dropdown"
                                            aria-expanded="true"><img src="images/kebob.png" alt="dropdownMenu"
                                                width="15px"></a>
                                        <ul class="dropdown-menu" aria-labelledby="dropdown1">
                                            <!-- 무료나눔 or 판매 -->
                                            {% if free_books | length %}
                                            <li><button id="item-edit-btn-{{book.id}}" class="dropdown-item"
                                                    role="menuitem" tabindex="-1" type="submit" class="btn"
                                                    onclick="sell_item_edit2('{{book.id}}')">수정</button></li>
                                            {% else %}
                                            <li><button id="item-edit-btn-{{book.id}}" class="dropdown-item"
                                                    role="menuitem" tabindex="-1" type="submit" class="btn"
                                                    onclick="sell_item_edit('{{book.id}}')">수정</button></li>
                                            {% endif %}
                                            <li><button id="item-delete-btn-{{book.id}}" class="dropdown-item"
                                                    role="menuitem" tabindex="-1" type="submit" class="btn"
                                                    onclick="sell_item_delete('{{book.id}}')">삭제</button></li>
                                        </ul>
                                    </div>
                                </form>
                            </div>

                        </div>
                        <div class="bookTitle d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">책 제목</h4>
                            <a class="text-body text-decoration-none" id="getBookTitle">${book.title}</a>
                        </div>

                        {% if free_books | length %}
                        <div></div>
                        {% else %}
                        <div class="bookTitle d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">가격</h4>
                            <a class="text-body text-decoration-none" id="getBookPrice">${book.price}원</a>
                        </div>
                        {% endif %}

                        <div class="auther d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">저자</h4>
                            <a class="text-body text-decoration-none" id="getAuther">${book.author}</a>
                        </div>
                        <div class="publisher d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">출판사</h4>
                            <a class="text-body text-decoration-none" id="getPublisher">${book.publisher}</a>
                        </div>
                        <div class="category d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">카테고리</h4>
                            <a class="text-body text-decoration-none" id="getCategory">${book.category}</a>
                        </div>
                        <div class="category d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">외관손상</h4>
                                <a class="text-body text-decoration-none" id="getAppearanceInfoA">${book.state[0]}</a>
                        </div>
                        <div class="category d-flex align-items-center mt-2 mb-2">
                            <h4 class="h4 fw-bold w-50">거래방법</h4>
                            <a class="text-body text-decoration-none" id="getAppearanceInfoB">${book.tradeMethod}</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 게시물 내용 -->
            <div class="mt-3 border-top w-75 ms-auto me-auto mb-5 pt-4">
                <div class="mt-3"><a id="getPostingContents">{{book.tags}}</a></div>
                <div class="mt-3"><a id="getPostingContents" style="white-space: pre-line;">${book.about}</a></div>
            </div>

            <!-- 댓글 달기 -->
            {% if users and users.id %}
            <form id="comment-form" class="mt-5 w-75 ms-auto me-auto">
                <div class="input-group">
                    <input id="comment" class="form-control p-2" name="comment">
                    <input type="hidden" name="bookId" value="{{bookId}}">
                    <button id="comment-btn" type="submit" class="btn btn-primary" onclick="postComment()"
                        value="Click">댓글달기</button>
                </div>
            </form>
            {% endif %}
            <div id="comments-collection" class="w-75 ms-auto me-auto">
                {% for comment in comments %}
                <table>
                    <!-- OwnerId -->
                    <input type="hidden" name="OwnerId" value="{{user}}">
                    {% if users and users.id %}
                    <form id="comment-ED-form-{{comment.id}}">
                        <!-- 댓글 -->
                        <div>
                            <input type="hidden" name="bookId" value="{{bookId}}">
                            <input type="hidden" name="UserId" value="{{comment.UserId}}">
                            <input type="hidden" name="commentId" value="{{comment.id}}">
                            <input type="hidden" name="comment_createdAt" value="{{comment.createdAt}}">

                            <!-- 댓글본문 -->
                            <div class="commentList">
                                <div class="d-sm-flex commentListInner">
                                    <!-- 유저닉네임 받아오기 -->
                                    <div class="comment-nick fw-bold">{{comment.commentingNick}}</div>
                                    <input hidden id="comment-nick-{{comment.id}}" value="{{comment.commentingNick}}">

                                    <div class="d-flex align-items-center">
                                        <div class="comment-content">{{comment.createdAt}}</div>
                                        <div class="dropdown">
                                            <a class="dropdown-toggle btn" href="#" data-bs-toggle="dropdown"
                                                aria-expanded="true"></a>
                                            <ul class="dropdown-menu" aria-labelledby="dropdown1">
                                                <li><a id="comment-edit-btn-{{comment.id}}" class="dropdown-item"
                                                        role="menuitem" tabindex="-1" type="submit" class="btn"
                                                        onclick="re_comment('{{comment.id}}')">댓글</a></li>
                                                <li><button id="comment-edit-btn-{{comment.id}}" class="dropdown-item"
                                                        role="menuitem" tabindex="-1" type="submit" class="btn"
                                                        onclick="comment_edit('{{comment.id}}')">수정</button></li>
                                                <li><button id="comment-delete-btn-{{comment.id}}" class="dropdown-item"
                                                        role="menuitem" tabindex="-1" type="submit" class="btn"
                                                        onclick="comment_delete('{{comment.id}}')">삭제</button></li>
                                                {% if users.nick == book.usernick %}
                                                <li><button id="comment-delete-btn-{{comment.id}}" class="dropdown-item"
                                                        role="menuitem" tabindex="-1" type="submit" class="btn"
                                                        onclick="comment_trade_complete('{{comment.id}}')">거래완료</button>
                                                </li>
                                                {% endif %}
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="comment-content"><a>{{comment.content}}</a></div>
                            </div>

                            <input type="hidden" id="edit_it-{{comment.id}}" name="edited_comment"
                                value="{{comment.id}}">
                            <input type="hidden" id="userid_it-{{comment.id}}" name="UserId_comment"
                                value="{{comment.UserId}}">
                            <input type="hidden" id="commentid_it-{{comment.id}}" name="commentId"
                                value="{{comment.id}}">
                        </div>
                    </form>
                    <!-- 답글입력 -->
                    <div id="inputReComment-{{comment.id}}" class="w-100"></div>
                    <!-- 로그인 대댓글 -->
                    {% for re_comment in re_comments %}
                    <form id="re_comment-ED-form-{{comment.id}}-{{re_comment.id}}">
                        {% if re_comment.reCommentingId == comment.id %}
                        <input type="hidden" name="recomment_reCommentedId" value="{{re_comment.reCommentedId}}">
                        <input type="hidden" name="recomment_UserId" value="{{re_comment.UserId}}">
                        <input type="hidden" name="re_bookId" value="{{bookId}}">
                        <input type="hidden" name="re_commentId" value="{{re_comment.id}}">
                        <input type="hidden" name="re_comment_createdAt" value="{{re_comment.createdAt}}">

                        <div class="reCommentList">
                            <div class="reCommentListInner d-sm-flex">
                                <div class="d-flex align-items-center">
                                    <div class="p-2"><img src="images/reply.png" style="opacity: 0.5;" width="15px"></div>

                                    <!-- 유저닉네임 받아오기 -->
                                    <div class="comment-nick fw-bold">{{re_comment.reCommentNick}}</div>
                                    <input hidden id="reCom_nick-{{comment.id}}-{{re_comment.id}}"
                                        value="{{re_comment.reCommentNick}}">
                                </div>
                                <div class="d-flex align-items-center">
                                    <div class="comment-content">{{re_comment.createdAt}}</div>
                                    <div class="dropdown">
                                        <a class="dropdown-toggle btn" href="#" data-bs-toggle="dropdown"
                                            aria-expanded="true"></a>
                                        <ul class="dropdown-menu" aria-labelledby="dropdown1">
                                            <li><button id="re_comment-edit-btn-{{re_comment.id}}" class="dropdown-item"
                                                    role="menuitem" tabindex="-1" type="submit" class="btn"
                                                    onclick="re_comment_edit('{{comment.id}}','{{re_comment.id}}')">
                                                    수정</button>
                                            </li>
                                            <li><button id="re_comment-delete-btn-{{re_comment.id}}"
                                                    class="dropdown-item" role="menuitem" tabindex="-1" type="submit"
                                                    class="btn"
                                                    onclick="re_comment_delete('{{comment.id}}','{{re_comment.id}}')">
                                                    삭제</button>
                                            </li>
                                            {% if users.nick == book.usernick %}
                                            <li id="finTrade"><button id="re_comment-delete-btn-{{re_comment.id}}"
                                                    class="dropdown-item" role="menuitem" tabindex="-1" type="submit"
                                                    class="btn"
                                                    onclick="re_comment_trade_complete('{{comment.id}}','{{re_comment.id}}')">
                                                    거래완료</button>
                                            </li>
                                            {% endif %}
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="comment-content ms-sm-2"><a>{{re_comment.content}}</a></div>
                            <input type="hidden" id="reCom_id-{{re_comment.id}}" name="reCom_edited_comment"
                                value="{{re_comment.content}}">
                        </div>
                        {% endif %}
                    </form>
                    {% endfor %}
            </div>

            <!-- 비로그인 댓글 -->
            {% else %}
            <div class="commentList">
                <div class="d-sm-flex commentListInner">
                    <div class="comment-nick fw-bold">{{comment.commentingNick}}</div>
                    <div class="comment-content">{{comment.createdAt}}</div>
                </div>
                <div class="comment-content"><a>{{comment.content}}</a></div>
            </div>

            <!-- 비로그인 대댓글 -->
            {% for re_comment in re_comments %}
            {% if re_comment.reCommentingId == comment.id %}
            <div class="reCommentList">
                <div class="reCommentListInner d-sm-flex">
                    <div class="d-flex align-items-center">
                        <div class="p-2"><img src="images/reply.png" style="opacity: 0.5;" width="15px"></div>
                        <div class="comment-nick fw-bold">{{re_comment.reCommentNick}}</div>
                    </div>
                    <div class="comment-content">{{re_comment.createdAt}}</div>
                </div>
                <div class="comment-content ms-sm-2"><a>{{re_comment.content}}</a></div>
            </div>
            {% endif %}
            {% endfor %}
            {% endif %}
            </table>
            {% endfor %}
        </main>
        <!-- footer -->
        <nav class="navbar navbar-expand-md bg-dark border-1" id="footerNav"></nav>
    </div>
    <script>

        function like() {
            const request = document.getElementById('book_like-form');
            request.setAttribute('action', '/like');
            request.setAttribute('method', 'POST');
        }

        function postComment() {
            const request = document.getElementById('comment-form');

            let comment = document.getElementById('comment').value.replace(/\s|　/gi, '');

            if (comment == '') {
                alert("내용을 입력하세요!");
            } else {
                request.setAttribute('action', '/book/{{bookId}}/comment');
                request.setAttribute('method', 'POST');
            }
        }

        // 대댓글
        function re_comment(id) {
            console.log("대댓글 클릭됨");
            const request = document.getElementById(`comment-ED-form-${id}`);

            const userId = document.getElementById(`userid_it-${id}`).value;
            const commentId = document.getElementById(`commentid_it-${id}`).value;
            console.log("@@ = ", commentId);
            const inputRe = document.getElementById(`inputReComment-${id}`);
            inputRe.innerHTML = '<form action="/recomment" method="POST"><div class="input-group"><input type="text" id="comment" class="reComment inputForm w-50 p-2" name="comment"><input type="hidden" name="bookId" value="{{bookId}}"><input type="hidden" id="commentId" name="commentId" value="{{comment.id}}"><input type="hidden" id="userId" name="UserId" value="{{userId}}"><button id="comment-btn" type="submit" class="btn btn-primary" onclick="postReComment()"value="Click">답글등록</button></div></form>';
            document.getElementById(`userId`).value = userId;
            document.getElementById(`commentId`).value = commentId;
        }

        // 대댓글 수정/삭제
        function re_comment_edit(cid, id) {
            var Com = prompt('수정 할 문구를 적어주세요');
            document.getElementById(`reCom_id-${id}`).value = `${Com}`;
            const request = document.getElementById(`re_comment-ED-form-${cid}-${id}`);

            let ckCom = Com.replace(/\s|  /gi, '');
            if (ckCom == '') {
                alert("내용을 입력하세요");
            } else {
                request.setAttribute('action', `/comment/reCommentEdit`);
                request.setAttribute('method', 'GET');
            }
        }

        function re_comment_delete(cid, id) {
            const request = document.getElementById(`re_comment-ED-form-${cid}-${id}`);
            request.setAttribute('action', '/comment/reCommentDelete');
            request.setAttribute('method', 'GET');
        }

        // 댓글 거래 완료
        function comment_trade_complete(id) {
            const name = document.getElementById(`comment-nick-${id}`).value
            console.log(name);
            const request = document.getElementById(`comment-ED-form-${id}`);
            // confirm에서 선택에 따라 이벤트 발생
            if (confirm('"' + name + '"' + "님과 거래를 마쳤습니까?")) {
                request.setAttribute('action', '/trade/commentTrade_sale');
                request.setAttribute('method', 'POST');
            } else
                alert("거래 취소");
        }

        // 대댓글 거래 완료
        function re_comment_trade_complete(cid, id) {
            const reName = document.getElementById(`reCom_nick-${cid}-${id}`).value
            console.log(reName);
            const request = document.getElementById(`re_comment-ED-form-${cid}-${id}`);
            // confirm에서 선택에 따라 이벤트 발생
            if (confirm('"' + reName + '"' + "님과 거래를 마쳤습니까?")) {
                request.setAttribute('action', '/trade/reCommentTrade_sale');
                request.setAttribute('method', 'POST');
            } else
                alert("거래 취소");
        }

    </script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/topNav.js"></script>
    <script src="js/timestamp.js"></script>
    <script src="js/postUD.js"></script>
    <script src="js/commentEvent.js"></script>
</body>

</html>