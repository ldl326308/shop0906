drop database shopdb;
create database if not exists shopdb;
use shopdb;


#用户表
create table if not exists `User`
(
	`u_id` int primary key auto_increment comment"用户id",
    `user_id` varchar(20) unique not null comment"登入账号",
    `user_pwd` varchar(20) not null comment"登入密码",
    `user_phone` varchar(11) unique not null  comment"联系电话",
    `user_email` varchar(20) unique not null comment"用户邮箱"
)engine=innodb default charset=utf8;

insert into `User`(user_id,user_pwd,user_phone,user_email) values ('oudaxian','oudaxian123','13676869098','32699833@qq.com');
insert into `User`(user_id,user_pwd,user_phone,user_email) values ('liudaxian','liudaxian123','13634869098','32434833@qq.com');
insert into `User`(user_id,user_pwd,user_phone,user_email) values ('zhangdaxian','zhangdaxian123','13679656098','326242833@qq.com');
insert into `User`(user_id,user_pwd,user_phone,user_email) values ('tangdaxian','tangdaxian123','13678775098','326252533@qq.com');
insert into `User`(user_id,user_pwd,user_phone,user_email) values ('ldl','123','123455556','32625552533@qq.com');




#select * from `User` where `user_id`='oudaxian' and `user_pwd` = 'oudaxian12993'  or `user_phone`='13676869098' and `user_pwd` = 'oudaxian1293'  or `user_email`='32699833@qq.com' and `user_pwd` = 'oudaxian9123' ;
#select * from `User`;

#类型表
create table if not exists `Type`
(
	`t_id` int primary key auto_increment comment'类型id',
    `t_name` varchar(15) not null comment'类型名称'
)engine=innodb default charset=utf8;

insert into `Type`(t_name) values ('电脑');
insert into `Type`(t_name) values ('手机');
insert into `Type`(t_name) values ('家电');
insert into `Type`(t_name) values ('家具');
insert into `Type`(t_name) values ('运动');
insert into `Type`(t_name) values ('食品');
insert into `Type`(t_name) values ('办公');
insert into `Type`(t_name) values ('汽车');
insert into `Type`(t_name) values ('珠宝');
insert into `Type`(t_name) values ('玩具');
insert into `Type`(t_name) values ('服装');

#select * from `Type`;
#select * from `Type` where `t_name` like '%具%';


#商品表
create table if not exists `Product`
(
	`p_id` int primary key auto_increment comment'商品id',
    `p_t_id` int not null comment'商品类型',
    `p_name` varchar(700) comment'商品名称',
    `p_price` decimal(10,2) not null comment'商品价格',
    `p_photo` varchar(1000) comment'图片路径',
    `p_state` int default 0 comment '状态',  # 0 上架 1 下架
    constraint `FK_product_type` foreign key (`p_t_id`) references `Type`(`t_id`)
)engine=innodb default charset=utf8;

select * from `Type`;

insert into `product`(p_t_id,p_name,p_price,p_photo) values (1,'联想(Lenovo)330C15.6英寸商务娱乐影音笔记本电脑(i7-8550U 4G 1T+128G MX110 2G FHD Office2016)黑',4999.00,'images/2b5a7b43-b18d-43b6-a690-ae9f6dcae1e6.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (1,'小米(MI)Air 13.3英寸全金属超轻薄笔记本电脑(i5-8250U 8G 256GSSD 集显 预装Office 指纹版)银',4999.00,'images/a6424b9d-e67a-4e41-a3b3-4e7c8a8ad690.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (1,'荣耀MagicBook 14英寸轻薄窄边框笔记本电脑（i7-8550U 8G 256G MX150 2G独显 FHD IPS 正版Office）冰河银',5999.00,'images/6a930885-e8fa-4e93-8e47-766bb7aa44cc.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (2,'荣耀9i 4GB+64GB 幻夜黑 移动联通电信4G全面屏手机 双卡双待',1499.00,'images/cdc81e9a-102e-4940-81ed-5b555ef854d5.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (2,'一加手机6 8GB+128GB 琥珀红 全面屏双摄游戏手机 全网通4G 双卡双待',3599.00,'images/a6806753-059e-4d51-a1c0-7f26b9f5a685.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (2,'Apple iPhone 8 (A1863) 256GB 银色 移动联通电信4G手机',5999.00,'images/1c150088-52b0-4504-b388-7cdf4960d7b7.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (3,'利仁（Liven）多用途锅多功能家用电火锅 不粘电炒锅电热锅电煮锅 京东自营小家电DHG-40FK',109.00,'images/d33f0021-0d92-4b04-9312-b925e1831010.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (3,'LG 7公斤DD变频直驱全自动滚筒洗衣机 450mm纤薄机身 智能手洗 静音 奢华白 WD-L51HNG20',2549.00,'images/e1aa4475-1e80-43bb-82e1-c4d26af93cbe.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (3,'LG 55LG63CJ-CA 55英寸超高清4K IPS硬屏主动式HDR 智能平板液晶电视机（黑色）',3688.00,'images/8e971819-1f7c-48ce-b118-78a8a381c62e.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (3,'TCL 65A860U 65英寸32核人工智能 超智慧 超薄4K 超高清电视机（银色）',4999.00,'images/0a231feb-ae0b-4c57-91a6-6f2bf6826633.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,'TEEK长袖T恤男2018秋冬新品 休闲衣服体恤男装加绒上衣打底衫 【不加绒】T708浅蓝色 175/96(L码)',89.00,'images/00dfcdb5-1a5f-4ef9-8684-0ffeec5c8057.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,'唐狮纯色短袖t恤男圆领夏季体恤纯棉半袖花纱衣服韩版男装打底衫 深麻灰（B款/棉汗布） M',69.00,'images/aaf85d0d-f380-44ac-9efc-dd8bfb176d61.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,'UYUK短袖T恤男士卫衣2018夏季冰爽新款帅气韩版五分连帽半袖韩版修身时尚休闲打底衫中袖大码男装 81灰色 L',88.00,'images/1c1ba6ba-88ec-4a61-b9a7-22bc21557b3e.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,'子牧棉麻2018夏季新款 女新品 民族风女装印花宽松长款短袖复古盘扣连衣裙3008 蓝黄花 L建议（130斤以内）',159.00,'images/fc39af9e-8384-4041-87e1-b82075a2af9f.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,'婪澈长袖连衣裙2018秋季新款两件套套装裙时尚套装女春针织大码女装韩版雪纺女沙滩裙子 白衣+黑背心 L',149.00,'images/93725a60-e7d0-4df1-9072-3d9393a14aba.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (11,' 夏季连衣裙短袖2018套装裙套装女春真丝性感大码女装韩版雪纺夏季新款女沙滩裙子',124.20,'images/001c5b18-aaf9-41ad-8d7e-aebf98cda368.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (6,'乐事（Lay’s）无限薯片 休闲零食 104g*3组合装（原味+烤肉+番茄）百事食品',19.90,'images/38544c08-a6ea-453a-87c9-aed3e0722d6b.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (6,'奥利奥Oreo早餐休闲零食蛋糕糕点缤纷双果味夹心饼干蓝莓味+树莓味388g',22.90,'images/b345b941-f8a6-4681-b5be-9f2572a9c00a.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (6,'三只松鼠休闲零食网红食品黄山特产梅干菜扣肉酥烧饼蟹壳黄烧饼150g',16.90,'images/82ab6d30-3190-411a-a4ba-a38aa0eb8e83.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (6,'良品铺子 鹌鹑蛋 卤蛋 香卤蛋 零食小吃 卤味熟食真空128g',16.90,'images/86232f55-4a02-4095-817e-0ad6de848d1b.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (1,'戴尔DELL游匣G3烈焰版 15.6英寸游戏笔记本电脑(i5-8300H 8G 128GSSD 1T GTX1050Ti 4G独显 IPS)',5999.00,'images/8bcca82e-1554-4b5a-bf1b-c65c16cd7031.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (7,'可得优（KW-triO） 桌面办公文件筐三联文件框三列杂志框办公文件架资料架',31.70,'images/4575cf63-6b11-4642-95d3-94d03a363113.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (7,'广博(GuangBo)稳固型四联文件栏/文件筐/文件架办公用品 蓝WJK9399',9.90,'images/983de259-879a-446b-8025-2d68718e2049.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (7,'得力(deli)金属网纹圆形笔筒 简约创意桌面收纳 黑色9172',6.50,'images/62299d9a-cef6-4cd5-a28f-3ff3e5246061.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (5,'特步（XTEP） 特步男鞋跑步鞋轻便耐磨运动鞋男士休闲皮鞋透气鞋子夏季款减震慢跑鞋 黑桔/飞织 43',169.00,'images/76bafa7b-f651-4500-a0ee-15daea15c060.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (5,'【赞商品】李宁 LI-NING 耐磨PU材质篮球室内外兼用CBA联赛官方比赛蓝球lanqiu 443-1',79.00,'images/1971e5fd-8b72-42a4-8aa3-f304cddb7ad3.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (5,'【买一送五】中国李宁篮球水泥地耐磨PU室内外篮球 训练比赛7号成人蓝球韦德之道纪念版DWADE篮球 韦德之道纪念版篮球（黑色）',159.00,'images/265e3df7-39c2-461e-8954-a5dac90b3fcd.jpg');
insert into `product`(p_t_id,p_name,p_price,p_photo) values (6,'良品铺子酥脆薄饼薄脆海苔咸饼干 盒装咸味零食小吃早餐休闲食品300g',9.90,'images/3c9cff8c-f874-41ad-a222-9c82df60a847.jpg');



#select * from `product`;



#收货地址信息表
create table if not exists `Address`
(
	`a_id` int primary key auto_increment comment'id',
    `a_u_id` int not null comment'用户id',
    `a_name` varchar(20) not null comment'收货人姓名',
    `a_phone` varchar(11) not null comment'收货人联系电话',
    `a_address` varchar(50) not null comment'收货地址',
    constraint `FK_Address_User` foreign key (`a_u_id`) references `User`(`u_id`)
);



insert into `Address`(a_u_id,a_name,a_phone,a_address) values(1,'刘大仙','13718071824','广东珠海斗门白蕉镇南路29号');
insert into `Address`(a_u_id,a_name,a_phone,a_address) values(1,'张大仙','13789371824','湖南长沙朝阳区千里路20号');
insert into `Address`(a_u_id,a_name,a_phone,a_address) values(1,'RngUZI','13345071824','江西赣州于都100中');


#select * from `Address`;


#订单信息表
create table if not exists `Order`
(
	`o_id` varchar(150) primary key comment'订单id',  #UUID 生成
    `o_a_id` int comment'收货地址id',
    `o_time` datetime default NOW() comment'订单时间',
    constraint `FK_Order_Address` foreign key (`o_a_id`) references `Address`(`a_id`)
);

#insert into `Order`(o_id,o_a_id) values('CDKSLK_KDJKKSJKK897787KKK',1);


#select * from `Order`;


#购物车
create table if not exists `ShoppingCart`
(
	`c_id` int primary key auto_increment comment'购物车id',
    `c_u_id` int not null comment'用户id',
    `c_p_id` int not null comment'商品id(唯一约束)',
    `c_o_id` varchar(150) default null comment'订单id',
    `c_count` int not null comment'数量',
    `c_state` int default 0 comment'状态', #0  未提价订单，1 已提交订单
    constraint `FK_ShoppingCart_User` foreign key (`c_u_id`) references `User`(`u_id`),
    constraint `FK_ShoppingCart_Product` foreign key(`c_p_id`) references `Product`(`p_id`),
    constraint `FK_ShoppingCart_Order` foreign key(`c_o_id`) references `Order`(`o_id`)
	
);



#  c_u_id c_p_id c_o_id c_count c_buy_num 

#insert into `ShoppingCart`(c_u_id,c_p_id,c_count,c_state) values(5,1,5,1);



#select * from `ShoppingCart` c inner join `Product` p on c.c_p_id = p.p_id;
# c_id c_u_id c_p_id c_o_id c_count c_buy_num c_state

#select * from `ShoppingCart`;


select * from `User`;
select * from `Type`;
select * from `Product`;
select * from `ShoppingCart`;
select * from `Address`;
select * from `Order`;



#订单显示：订单号、商品名，单价、数量、金额（数量*单价）、下单时间、地址、总金额  where o_id = f4a8932b-689f-43cb-abf9-974982362b87

#select * from `Product` p inner join `ShoppingCart` c on c.c_p_id = p.p_id inner join `Order` o on o.o_id = c.c_o_id inner join `Address` a on a.a_id = o.o_a_id where `o_id` = 'f4a8932b-689f-43cb-abf9-974982362b87'; 


# 图片路径 简介  价格 数量 价格总和 购物车id
#select `c_id`,`p_name`,`p_price`,`p_photo`,`c_count` from `ShoppingCart` c inner join `Product` p on c.c_p_id = p.p_id;


#select `c_id`,`p_name`,`p_price`,`p_photo`,`c_count` from `ShoppingCart` c inner join `Product` p on c.c_p_id = p.p_id where c_u_id = 5 and `c_state`=0;


#select * from `Product` p inner join `ShoppingCart` c on p.p_id = c.c_p_id where `c_id` in (3,5) and `c_u_id` =5;

#select * from `Product` p inner join `ShoppingCart` c on p.p_id = c.c_p_id where `c_id` in (3,5) ;

#update `ShoppingCart` set `c_state` = 1,`c_o_id`='CDKSLK_KDJKKSJKK897787KKK' where `c_id` in (4,5,7);

select * from `Type`;

#指定字段追加内容  concat
# update `Type` set `t_name` = concat(`t_name`,'(类)') where t_id = 1;




















