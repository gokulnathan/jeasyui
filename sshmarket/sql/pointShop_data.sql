use point_shop;
#在中文windows通过mysql命令进行数据库操作需要更改字符集为gbk
set  character_set_server=utf8;
set  character_set_client=utf8;
set  character_set_results=utf8;
set  character_set_connection=utf8;
set  character_set_filesystem=utf8;
insert into tb_goods(name, description, original_point, now_point, published, is_delete)    values('研磨设计模式', '一本值得反复阅读的书', '200', '100', true, false );