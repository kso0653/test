SET search_path TO boarduk;

CREATE TABLE boarduk.b_user (
    user_no bigint default 0,
    user_name character varying(128),
    insert_timestamp timestamp without time zone NOT NULL DEFAULT now(), -- 생성날짜
    updated_timestamp timestamp without time zone, -- 수정날짜
    is_deleted character(1) NOT NULL DEFAULT 'F'::bpchar, -- 삭제여부
    user_contact character varying(32), -- 사용자 대표 연락처
    user_email character varying(128), -- 사용자 보조 이메일
    portal_id character varying(50), -- 포털계정
    ci character varying(128), -- 본인확인서비스 CI
    user_state smallint DEFAULT 0, -- 유저상태(0:사용, 1:중지, 2:탈퇴)
    CONSTRAINT pk_user PRIMARY KEY (user_no)
);

CREATE TABLE boarduk.company (
    id SERIAL primary key,
    company_name VARCHAR(128),
    company_address VARCHAR(128)
);

create table boarduk.employee (
    id SERIAL primary key,
    company_id INTEGER,
    employee_name VARCHAR(128),
    employee_address VARCHAR(128),
    CONSTRAINT fk_company_id foreign key (company_id) references boarduk.company(id) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE b_user ADD CONSTRAINT constraintname UNIQUE (portal_id);

CREATE TABLE boarduk.board (
    board_no SERIAL primary key,
    board_title VARCHAR(128),
    board_writer VARCHAR(128),
    board_contents VARCHAR(300),
    board_views INTEGER,
    foreign key (board_writer) references b_user(portal_id)
);

CREATE TABLE boarduk.b_board (
    board_no bigint NOT NULL DEFAULT nextval('seq_b_board'::regclass),
    board_title CHARACTER VARYING(300) NOT NULL,
    board_contents CHARACTER VARYING,
    board_views SMALLINT NOT NULL DEFAULT 0,
    insert_timestamp timestamp without time zone NOT NULL DEFAULT now(), -- 생성날짜
    updated_timestamp timestamp without time zone,
    board_writer CHARACTER VARYING(50) NOT NULL,
    board_editor CHARACTER VARYING(50) NOT NULL,
    is_deleted character(1) NOT NULL DEFAULT 'F'::bpchar,
    CONSTRAINT pk_board PRIMARY KEY (board_no),
    foreign key (board_writer) references b_user(portal_id)
);

COMMENT ON COLUMN "b_board"."board_title" IS '제목';

CREATE SEQUENCE seq_b_board START 1;

