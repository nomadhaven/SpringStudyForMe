-- select now(); -- 현재시간을 출력한다.
INSERT INTO  user_info values ('qwer2','1234','김태형','aaa@aaa.com','1995-12-30','fb',now());
INSERT INTO  user_info values ('asdf2','1234','김태형','aaa@aaa.com','1995-12-30','fb',now());

select * from user_info;

update user_info set pwd = '8888', email='ccc@bbb.com' where id='asdf1';

--  Auto Commit 명령을 수행할때마다 commit
-- Commit 작업 내용을 DB에 반영
-- rollback 작업 내용을 되돌리는 것. 이전 커밋 상태로 undo
--  delete from user_info; -- 행단위로 데이터를 삭제