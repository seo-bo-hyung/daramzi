-- mysql Ȱ�� ���� ���� --

-- Ʈ���� ������
SET Global log_bin_trust_function_creators='ON';

-- ���̺� alter
ALTER TABLE file_house CHANGE `categoryCode` `categoryCode` varchar(20) comment '�Խ���ī�װ�';
ALTER TABLE file_house_log CHANGE `categoryCode` `categoryCode` varchar(20) comment '�Խ���ī�װ�';

--���̺� ���� ���� ����
show create table tbl_board;

-- ���̺� �÷� Ȯ��
SHOW FULL COLUMNS FROM file_house; 


* �÷� ���� ��ȸ
SELECT
    table_name,
    column_name,
    column_comment,
    ordinal_position
FROM
    information_schema.columns
WHERE
    table_schema = 'daramzi_db'
    AND table_name = 'reply'
    order by ordinal_position
    ;
    
    
SELECT
*
FROM
    information_schema.columns
WHERE
    table_schema = 'daramzi_db'
    AND table_name = 'tbl_board'
    order by ordinal_position
    ;    
