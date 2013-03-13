/*
积分商城DDL
*/
CREATE DATABASE IF NOT EXISTS point_shop DEFAULT CHARACTER SET 'utf8';
USE point_shop;
DROP TABLE IF EXISTS tb_goods_code;
DROP TABLE IF EXISTS tb_goods;

-- ----------------------------
-- Table structure for 商品表
-- ----------------------------
CREATE TABLE tb_goods ( 
  id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  name varchar(100) NOT NULL COMMENT '商品名称',
  description varchar(100) NOT NULL COMMENT '商品简介',
  original_point int(10) unsigned NOT NULL  COMMENT '原需积分',
  now_point int(10) unsigned NOT NULL  COMMENT '现需积分',
  published bool NOT NULL  COMMENT '是否发布',
  is_delete bool NOT NULL DEFAULT false COMMENT '是否删除',
  version int(10) unsigned NOT NULL DEFAULT 0 COMMENT '版本',
  PRIMARY KEY (id),
  INDEX(name),
  INDEX(published)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for 商品兑换码表
-- ----------------------------
CREATE TABLE tb_goods_code (
  id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  username varchar(100) COMMENT '兑换用户',
  goods_id int(10) unsigned NOT NULL COMMENT '所属商品id',
  code varchar(100)  NOT NULL COMMENT '积分',
  exchange_time datetime  COMMENT '购买时间',
  exchanged bool DEFAULT false COMMENT '是否已经兑换',
  version int(10) unsigned NOT NULL DEFAULT 0 COMMENT '版本',
  PRIMARY KEY (id),
  FOREIGN KEY (goods_id) REFERENCES tb_goods (id) ON DELETE CASCADE
  )ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT='商品兑换码表';
  
