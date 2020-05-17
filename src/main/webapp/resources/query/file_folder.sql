select * from file_folder
delete from file_folder where folderIdx = 7

update file_folder set folderName = 'imageBoard' where folderIdx = 5

drop table file_folder

--���� ���� ���̺�
create table file_folder(
    folderIdx int not null auto_increment comment '����IDX',
    folderSeq int not null comment '��������',
    folderName varchar(100) not null comment '������',
    id varchar(45) NOT NULL  comment '����� ID',
    upperFolder varchar(100) comment '����������',
	folderDepth int comment '��������',
	del_flag varchar(1) comment '��������',
    ins_dt date comment '�Է���',    
    upt_dt date comment '������',
    PRIMARY KEY(folderIdx)
);