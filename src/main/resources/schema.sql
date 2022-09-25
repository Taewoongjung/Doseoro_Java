create table if not exists t_identity
(
    seq bigint generated by default as identity,
    id varchar(64) not null,
    email varchar(200) not null,
    password varchar(200) not null,
    name varchar(20) not null,
    nick_name varchar(25) not null,
    phone varchar(14) not null,
    forgot_pw_question varchar(100) not null,
    forgot_pw_answer varchar(100) not null,
    location varchar(100) null,
    dong varchar(10) null,
    si varchar(10) null,
    dou varchar(10) null,
    provider varchar(100) null,
    sns_id varchar(50) null
);

create table if not exists t_book
(
    seq bigint generated by default as identity,
    id varchar(64) not null,
    post_message varchar(100) not null,
    title varchar(100) not null,
    price varchar(200) null,
    author varchar(100) null,
    publisher varchar(100) null,
    category JSON null,
    state JSON null,
    trade_method varchar(100) null,
    img JSON null,
    sold varchar(1) null,
    about varchar(100) null,
    owner_id varchar(64) null
);

create table if not exists t_book_like
(
    seq bigint generated by default as identity,
    id varchar(64) not null,
    identity_id varchar(64) not null,
    book_id varchar(64) not null
);