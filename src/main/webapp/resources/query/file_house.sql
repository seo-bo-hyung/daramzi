ALTER TABLE file_house ADD COLUMN contentIdx varchar(32) NOT NULL;

select * from file_house
delete from file_house



--���� ���̺� �۾�
drop table file_recommend;
drop table file_house;
drop table file_house_log;

SHOW TRIGGERS;

DROP TRIGGERS after_file_house_insert;
DROP TRIGGERS after_file_house_delete;
DROP TRIGGERS after_file_house_update;

create table file_house (
    fileIdx int not null auto_increment  comment '����IDX',
    fileSeq int not null comment '���ϼ���',
    fileName varchar(100) not null comment '���ϸ�',
	fileExtension varchar(10) not null comment '����Ȯ���ڸ�',
    fileRealName varchar(512) not null comment '���Ͽ�����',
    fileSize int comment '����ũ��',
    categoryCode varchar(20) comment '�Խ���ī�װ�',
    boardIdx int comment '�Խñ�IDX',
    id varchar(45) NOT NULL  comment '����� ID',
    folderPath varchar(200) comment '�������',    
    del_yn varchar(1) DEFAULT 'Y' comment '����YN',
	open_yn varchar(1) DEFAULT 'Y' comment '����YN',
	down_yn varchar(1) DEFAULT 'Y'comment '�ٿ�YN',
    fileDescription varchar(300) comment '���ϼ���',
    ins_dt timestamp comment '�Է���',
    upt_dt timestamp comment '������',
    PRIMARY KEY(fileIdx)
);


--���� �α� ���̺� ����
create table file_house_log (
	actionType varchar(10) comment '�Է»���',
    fileIdx int comment '����IDX',
    fileSeq int comment '���ϼ���',
    fileName varchar(100) comment '���ϸ�',
	fileExtension varchar(10) comment '����Ȯ���ڸ�',
    fileRealName varchar(512) comment '���Ͽ�����',
    fileSize int comment '����ũ��',
    categoryCode varchar(20) comment '�Խ���ī�װ���',
    boardIdx int comment '�Խñ�IDX',
    id varchar(45) comment '����� ID',
    folderPath varchar(200) comment '�������',  
    del_yn varchar(1) DEFAULT 'Y' comment '����YN',
	open_yn varchar(1) DEFAULT 'Y' comment '����YN',
	down_yn varchar(1) DEFAULT 'Y'comment '�ٿ�YN',
    fileDescription varchar(300) comment '���ϼ���',
    ins_dt timestamp comment '�Է���'
);


CREATE TRIGGER after_file_house_insert
AFTER INSERT ON file_house
FOR EACH ROW
BEGIN

INSERT INTO file_house_log
SET
actionType = 'INSERT',
fileIdx = NEW.fileIdx ,
fileSeq = NEW.fileSeq ,
fileName = NEW.fileName ,
fileExtension = NEW.fileExtension ,
fileRealName = NEW.fileRealName ,
fileSize = NEW.fileSize ,
categoryCode = NEW.categoryCode ,
boardIdx = NEW.boardIdx ,
id = NEW.id ,
folderPath = NEW.folderPath ,
del_yn = NEW.del_yn,
open_yn = NEW.open_yn,
down_yn = NEW.down_yn,
fileDescription = NEW.fileDescription,
ins_dt = sysdate()
;
END;


CREATE TRIGGER after_file_house_update
AFTER UPDATE ON file_house
FOR EACH ROW
BEGIN

INSERT INTO file_house_log
SET
actionType = 'UPDATE',
fileIdx = NEW.fileIdx ,
fileSeq = NEW.fileSeq ,
fileName = NEW.fileName ,
fileExtension = NEW.fileExtension ,
fileRealName = NEW.fileRealName ,
fileSize = NEW.fileSize ,
categoryCode = NEW.categoryCode ,
boardIdx = NEW.boardIdx ,
id = NEW.id ,
folderPath = NEW.folderPath ,
del_yn = NEW.del_yn,
open_yn = NEW.open_yn,
down_yn = NEW.down_yn,
fileDescription = NEW.fileDescription,
ins_dt = sysdate()
;
END  ;


CREATE TRIGGER after_file_house_delete
AFTER DELETE ON file_house
FOR EACH ROW
BEGIN

INSERT INTO file_house_log
SET
actionType = 'DELETE',
fileIdx = OLD.fileIdx ,
fileSeq = OLD.fileSeq ,
fileName = OLD.fileName ,
fileExtension = OLD.fileExtension ,
fileRealName = OLD.fileRealName ,
fileSize = OLD.fileSize ,
categoryCode = OLD.categoryCode ,
boardIdx = OLD.boardIdx ,
id = OLD.id ,
folderPath = OLD.folderPath ,
del_yn = OLD.del_yn,
open_yn = OLD.open_yn,
down_yn = OLD.down_yn,
fileDescription = OLD.fileDescription,
ins_dt = sysdate()
;
END ;
