function setInnerHTML() {    
    const footerInner = document.getElementById('footerNav');
    footerInner.innerHTML = '<div class="w-50 ms-auto me-auto mt-2 text-center"><a class="navbar-brand fw-bold ms-auto me-auto" href="">도서로</a><div class="mt-4"><ul class="navbar-nav justify-content-center"><li class="nav-item ms-1 me-1"><a class="nav-link active" aria-current="page" href="/">홈</a></li><li class="nav-item ms-1 me-1"><a class="nav-link" href="/pages/csList">고객문의</a></li><li class="nav-item dropup ms-1 me-1"><a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">개발자</a><li><a class="dropdown-item m-1" href="https://github.com/Taewoongjung" target="_blank">정태웅</a></li></div></div>';
}
setInnerHTML()