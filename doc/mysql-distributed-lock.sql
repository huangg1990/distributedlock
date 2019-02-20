CREATE TABLE tb_lock(
`id` int(11) PRIMARY KEY not null COMMENT '主键'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='锁定中的方法';

select * from tb_lock;

delete from tb_lock where id=1;