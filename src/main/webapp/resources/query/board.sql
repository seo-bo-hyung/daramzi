drop table tbl_board

select * from board




CREATE TABLE board (
    boardIdx   int not null auto_increment comment '�Խ���IDX',
    id       VARCHAR(20) DEFAULT NULL comment '���̵�',
    title      VARCHAR(50) DEFAULT NULL comment '����',
    content    VARCHAR(4000) DEFAULT NULL comment '����',
    hitCnt      INT DEFAULT NULL comment '��ȸ��',
    ip         VARCHAR(50) DEFAULT NULL comment '������',
    ins_dt timestamp comment '�Է���',
    upt_dt timestamp comment '������',
    PRIMARY KEY ( boardIdx )
);

CREATE TABLE board_log (
    actionType varchar(10) comment '�Է»���',
    boardIdx   int comment '�Խ���IDX',
    id       VARCHAR(20) comment '���̵�',
    title      VARCHAR(50) comment '����',
    content    VARCHAR(4000) comment '����',
    hitCnt      INT comment '��ȸ��',
    ip         VARCHAR(50) comment '������',
    ins_dt timestamp comment '�Է���'
);


CREATE TRIGGER after_board_insert
AFTER INSERT ON board
FOR EACH ROW
BEGIN

INSERT INTO board_log
SET
actionType = 'INSERT',
boardIdx = NEW.boardIdx,
id = NEW.id,
title = NEW.title,
content = NEW.content,
hitCnt = NEW.hitCnt,
ip = NEW.ip,
ins_dt = sysdate()
;
END;


CREATE TRIGGER after_board_update
AFTER UPDATE ON board
FOR EACH ROW
BEGIN

INSERT INTO board_log
SET
actionType = 'UPDATE',
boardIdx = NEW.boardIdx,
id = NEW.id,
title = NEW.title,
content = NEW.content,
hitCnt = NEW.hitCnt,
ip = NEW.ip,
ins_dt = sysdate()
;
END  ;


CREATE TRIGGER after_board_delete
AFTER DELETE ON board
FOR EACH ROW
BEGIN

INSERT INTO board_log
SET
actionType = 'DELETE',
boardIdx = OLD.boardIdx,
id = OLD.id,
title = OLD.title,
content = OLD.content,
hitCnt = OLD.hitCnt,
ip = OLD.ip,
ins_dt = sysdate()
;
END ;
