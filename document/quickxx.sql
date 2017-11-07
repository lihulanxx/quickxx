/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/1 12:35:25                            */
/*==============================================================*/


drop table if exists shop_ad;

/*==============================================================*/
/* Table: shop_ad                                                    */
/*==============================================================*/
create table shop_ad
(
   id                   bigint(20) not null comment 'id',
   create_date          datetime not null comment '创建日期',
   modify_date          datetime not null comment '修改日期',
   orders               int comment '排序',
   begin_date           datetime comment '起始日期',
   content              longtext comment '内容',
   end_date             datetime comment '结束日期',
   path                 varchar(255) comment '路径',
   title                varchar(255) not null comment '标题',
   type                 int not null comment '类型',
   url                  varchar(255) comment '链接地址',
   ad_position          bigint(20) not null comment '广告位',
   primary key (id)
);

