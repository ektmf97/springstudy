DROP TABLE GOOD_T;
DROP TABLE COMMENT_T;
DROP TABLE SUMMERNOTE_IMAGE_T;
DROP TABLE BLOG_T;
DROP TABLE MEMBER_T;


-- 사용자
CREATE TABLE MEMBER_T (
    MEMBER_NO NUMBER NOT NULL,
    ID        VARCHAR2(30 BYTE) NOT NULL UNIQUE,
    PW        VARCHAR2(30 BYTE) NOT NULL,
    NAME      VARCHAR2(30 BYTE)
);

-- 블로그
CREATE TABLE BLOG_T (
    BLOG_NO     NUMBER NOT NULL,
    TITLE       VARCHAR2(100 BYTE) NOT NULL,
    CONTENT     CLOB,
    HIT         NUMBER NOT NULL,
    CREATED_AT  DATE,
    MODIFIED_AT DATE,
    MEMBER_NO   NUMBER
);

-- 블로그 본문 작성 에디터 SUMMERNOTE에서 사용한 이미지의 목록
CREATE TABLE SUMMERNOTE_IMAGE_T (
    FILESYSTEM_NAME VARCHAR2(50 BYTE),   -- 원래이름은 다운로드 받지 않을거라 필요없고 저장되는 이름만 필요
    BLOG_NO NUMBER -- 어떤 블로그에 달린건지 블로그가 1: 써머노트가 다:
);


-- 댓글 (1단 계층형, 대댓글 불가한 형태)
CREATE TABLE COMMENT_T (
    COMMENT_NO NUMBER NOT NULL,
    CONTENT    VARCHAR2(4000 BYTE) NOT NULL,
    STATE      NUMBER, -- 정상 1, 삭제 -1
    DEPTH      NUMBER, -- 댓글 0, 댓글에 달린 댓글 1
    GROUP_NO   NUMBER, -- 댓글과 댓글에 달린 댓글은 같은 그룹처리
    CREATED_AT DATE,   -- 작성일 / 수정은 못하는걸로 
    BLOG_NO    NUMBER,
    MEMBER_NO  NUMBER
);


-- 좋아요 
CREATE TABLE GOOT_T (
    MEMBER_NO NUMBER, -- 누가
    BLOG_NO   NUMBER, -- 어디에
    MARKED_AT DATE    -- 언제 달았는지
);