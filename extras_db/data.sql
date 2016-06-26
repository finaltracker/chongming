prompt PL/SQL Developer import file
prompt Created on 2016年6月6日 by Administrator
set feedback off
set define off
prompt Loading CM_COUNTRY...
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (25, 0, 1, 'test', '1', '1', 1464259143, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (14, 0, 5, '建设镇', 'huge', '112358', 1462764637, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (11, 0, 2, '陈家镇', 'huge', '7758521', 1462764136, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (12, 0, 3, '向化镇', 'huge', '1111', 1462764330, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (10, 0, 1, '中兴镇', 'hu', '11', 1462764086, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (13, 0, 4, '新河镇', 'huge', '111111', 1462764368, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (16, 10, 1, '爱国村', 'hu123', '111', 1462775718, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (17, 10, 1, '胜利村', 'hu', '1111', 1462775778, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (18, 10, 1, '永隆村', 'hu', '111', 1462775797, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (20, 10, 1, '富圩村', 'hu', '1111', 1462775844, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (21, 10, 1, '开港村', 'hu', '1111', 1462775858, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (22, 0, 1, '港西镇', 'huge', '112358', 1462862886, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (23, 10, 1, '北兴村', 'huge', '11221', 1462865375, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (26, 14, 0, '新村', '张小燕', '111111', 1464573934, 'admin');
insert into CM_COUNTRY (ID, PARENTID, DISPLAY_ORDER, NAME, CONTACT, PHONE, PUBDATE, AUTHOR)
values (27, 14, 2, '建设村', '111', '111', 1464591023, 'admin');
commit;
prompt 15 records loaded
prompt Loading CM_LEVEL...
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (7, '1000', 'A', 'admin', 1462682749);
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (8, '1200', 'AA', 'admin', 1462682931);
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (11, '1400', 'AAA', 'cm', 1463626283);
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (12, '1600', 'AAAA', 'cm', 1463626299);
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (13, '1800', 'AAAAA', 'cm', 1463626308);
insert into CM_LEVEL (ID, LEVEL_SCORE, LEVEL_NAME, AUTHOR, PUBDATE)
values (14, '-9999', 'B', 'cm', 1463918343);
commit;
prompt 6 records loaded
prompt Loading CM_LOG...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (211, 'cm 登陆系统', 1462843336, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (417, '提交考核ID为(33)', 1462866852, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (452, '编辑 人员 张三丰', 1462888310, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (453, '提交人员信息ID为(28)', 1462888312, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (454, '提交人员信息ID为(28)', 1462888314, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (455, '录入 人员 李四海', 1462888480, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (456, '提交人员信息ID为(1)', 1462888483, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (457, '编辑 人员 李四海', 1462888589, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (458, '提交人员信息ID为(29)', 1462888591, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (459, '录入 人员 黄药师', 1462888627, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (460, '提交人员信息ID为(1)', 1462888629, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (461, '录入 人员 张果老', 1462888676, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (462, '提交人员信息ID为(1)', 1462888684, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (463, '录入 人员 黄剑2', 1462888928, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (464, '提交人员信息ID为(1)', 1462888932, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (465, '录入 人员 黄剑2', 1462889107, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (466, '录入 人员 test', 1462889688, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (467, '提交人员信息ID为(34)', 1462889702, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (468, 'cm 登陆系统', 1462889769, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (469, '人员 ID(33)', 1462889806, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (470, '人员 ID(32)', 1462889811, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (471, '增加 考核记录 34::9', 1462889824, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (472, '人员 ID(34)', 1462889835, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (473, '增加 考核记录 15::9', 1462890354, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (474, '增加 考核记录 15::11', 1462921434, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (475, 'cm 登陆系统', 1462926998, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (476, 'cm 登陆系统', 1462927704, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (477, 'cunming1 登陆系统', 1462928333, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (478, '编辑 人员 黄药师', 1462928360, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (479, '提交人员信息ID为(30)', 1462928362, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (480, 'zhongxin 登陆系统', 1462928406, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (481, '编辑 人员 张果老', 1462928423, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (482, '提交人员信息ID为(31)', 1462928425, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (483, '编辑 人员 张果老', 1462928434, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (484, '编辑 人员 张果老', 1462928492, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (485, '提交人员信息ID为(31)', 1462928494, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (486, '编辑 人员 张果老', 1462928577, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (487, 'cm 登陆系统', 1462928722, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (488, 'cunming2 登陆系统', 1462928795, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (489, 'cm 登陆系统', 1462929306, 'cm', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (490, 'zhongxin 登陆系统', 1462929323, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (491, 'cunming1 登陆系统', 1462929344, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (492, 'zhongxin 登陆系统', 1462929458, 'zhongxin', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (493, '编辑 人员 张果老', 1462929528, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (494, '提交人员信息ID为(31)', 1462929530, 'cunming1', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (495, '编辑 人员 张果老', 1462929599, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (496, 'cunming1 登陆系统', 1462929621, 'cunming1', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (497, '编辑 人员 张果老', 1462929675, 'cunming1', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (498, '提交人员信息ID为(31)', 1462929677, 'cunming1', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (499, 'cm 登陆系统', 1462929763, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (500, '录入 人员 张无忌', 1462929900, 'cunming1', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (501, '编辑 人员 张无忌', 1462929918, 'zhongxin', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (502, '提交人员信息ID为(35)', 1462929920, 'zhongxin', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (503, '删除村镇 ID(15)', 1462930017, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (504, 'cm 登陆系统', 1462930246, 'cm', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (505, 'cunming2 登陆系统', 1462930254, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (506, '编辑 人员 赫磊', 1462930260, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (507, '提交人员信息ID为(26)', 1462930262, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (508, '编辑 人员 张三', 1462930267, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (509, '提交人员信息ID为(25)', 1462930268, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (510, '录入 人员 一', 1462930358, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (511, '提交人员信息ID为(36)', 1462930359, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (512, '录入 人员 二', 1462930503, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (513, '提交人员信息ID为(37)', 1462930505, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (514, '录入 人员 三', 1462930546, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (515, '提交人员信息ID为(38)', 1462930548, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (516, '录入 人员 四', 1462930649, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (517, '提交人员信息ID为(39)', 1462930651, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (518, '录入 人员 五', 1462930700, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (519, '提交人员信息ID为(40)', 1462930702, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (521, 'hu 登陆系统', 1462930809, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (522, '增加 考核记录 39::16', 1462930821, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (523, '提交考核ID为(40)', 1462930822, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (524, '增加 考核记录 38::17', 1462930839, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (525, '提交考核ID为(41)', 1462930840, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (526, '提交考核ID为(38)', 1462930926, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (527, '提交考核ID为(38)', 1462930926, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (528, '提交考核ID为(39)', 1462930931, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (529, '提交考核ID为(39)', 1462930931, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (530, '删除考核目标 ID(16)', 1462930944, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (532, '删除考核目标 ID(9)', 1462931357, 'cm', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (533, '增加 考核记录 24::12', 1462931628, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (534, '提交考核ID为(42)', 1462931629, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (535, '部门 ID(10)', 1462934503, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (536, '删除考核目标 ID(13)', 1462934589, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (538, '部门 ID(11)', 1462934629, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (539, 'hu 登陆系统', 1462934837, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (540, '增加 部门 崇明公安', 1462934884, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (541, 'keji 登陆系统', 1462934948, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (542, 'hu 登陆系统', 1462934978, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (543, '增加 考核目标抢动', 1462935018, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (544, 'cm 登陆系统', 1462953161, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (545, '编辑 考核目标大赛拿奖', 1462974066, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (546, '编辑 考核目标见义勇为', 1462974079, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (547, '编辑 考核目标信用卡延期', 1462974090, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (548, '编辑 考核目标抢劫', 1462974113, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (549, 'cm 登陆系统', 1463019444, 'cm', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (550, 'cm 登陆系统', 1463019447, 'cm', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (551, 'cm 登陆系统', 1463019886, 'cm', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (552, 'cm 登陆系统', 1463019886, 'cm', '61.172.176.245');
commit;
prompt 100 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (553, 'hu 登陆系统', 1463020078, 'hu', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (554, 'cm 登陆系统', 1463020148, 'cm', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (555, 'hu 登陆系统', 1463020164, 'hu', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (556, 'cunming2 登陆系统', 1463020213, 'cunming2', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (557, 'cm 登陆系统', 1463021201, 'cm', '61.172.176.245');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (558, 'cm 登陆系统', 1463106090, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (559, 'cm 登陆系统', 1463359222, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (560, 'cm 登陆系统', 1463359224, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (561, 'admin 登陆系统', 1463453697, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (562, 'cm 登陆系统', 1463453703, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (563, '增加 考核目标222', 1463453780, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (564, '删除考核目标 ID(24)', 1463453791, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (565, '编辑 村镇中兴镇', 1463453811, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (566, '编辑 考核目标抢劫', 1463453857, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (567, 'cm 登陆系统', 1463453942, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (568, '编辑 村镇爱国村', 1463453949, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (569, '编辑 村镇爱国村', 1463453986, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (570, 'cm 登陆系统', 1463454295, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (571, '增加 考核目标1', 1463454380, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (572, 'admin 登陆系统', 1463454419, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (573, '增加 考核目标23', 1463454434, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (574, '编辑 考核目标23232323', 1463454442, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (575, '编辑 考核目标12', 1463454455, 'admin', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (576, '编辑 考核目标信用卡延期', 1463454482, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (577, '增加 部门 社会', 1463473526, 'cm', '61.175.197.202');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (578, 'cm 登陆系统', 1463473602, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (579, 'cm 登陆系统', 1463473627, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (580, '增加 部门 222', 1463473654, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (581, '部门 ID(20)', 1463473662, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (582, '增加 部门 222', 1463473687, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (583, '部门 ID(21)', 1463473691, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (584, '增加 村镇21', 1463473814, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (585, '删除村镇 ID(24)', 1463473821, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (586, '增加 考核目标11', 1463473857, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (587, '删除考核目标 ID(25)', 1463473864, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (588, '删除考核目标 ID(26)', 1463473867, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (589, '删除考核目标 ID(27)', 1463473886, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (590, 'cm 登陆系统', 1463488180, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (19, 'admin2 登陆系统', 1462684716, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (26, '增加 村镇镇城镇', 1462704209, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (27, '增加 村镇城桥村', 1462704240, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (28, '增加 村镇城桥村', 1462704243, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (29, '删除村镇 ID(7)', 1462704256, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (30, '增加 部门 卫生局', 1462704282, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (31, '增加 部门 公安局', 1462704312, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (32, '增加 部门 环保局', 1462704330, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (33, '录入 人员 张三', 1462704434, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (34, '增加 考核记录 4::6', 1462704461, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (88, '增加 村镇新村乡', 1462764638, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (99, '增加 考核目标扶老人过街', 1462765249, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (133, '录入 人员 hu', 1462775950, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (134, '提交人员信息ID为(1)', 1462775954, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (153, '提交考核ID为(1)', 1462780235, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (154, '提交考核ID为(15)', 1462780239, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (155, '提交考核ID为(15)', 1462780240, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (160, '录入 人员 丁宏', 1462781463, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (183, '增加 考核目标救人', 1462782407, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (520, '人员 ID(40)', 1462930736, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (531, 'weisheng 登陆系统', 1462930991, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (537, '部门 ID(17)', 1462934619, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (591, '导出 人员列表', 1463488184, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (592, 'cm 登陆系统', 1463623922, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (593, 'sifa 登陆系统', 1463624183, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (594, 'cm 登陆系统', 1463624293, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (595, 'cm 登陆系统', 1463625832, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (596, '考核等级 ID(10)', 1463626243, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (597, '编辑 考核等级 A', 1463626267, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (598, '编辑 考核等级 AA', 1463626276, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (599, '增加 考核等级 AAA', 1463626283, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (600, '增加 考核等级 AAAA', 1463626299, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (601, '增加 考核等级 AAAAA', 1463626308, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (602, 'cm 登陆系统', 1463666535, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (603, '编辑 人员 学士', 1463666551, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (604, '编辑 人员 学士', 1463666575, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (605, '编辑 部门 环保局', 1463666613, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (606, '编辑 人员 学士', 1463667521, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (607, '编辑 人员 学士', 1463667570, 'cm', '61.184.128.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (608, '增加 考核记录 22::18', 1463667594, 'cm', '61.184.128.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (609, '编辑 考核目标抢劫', 1463667764, 'cm', '61.184.128.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (610, 'cm 登陆系统', 1463918165, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (611, '编辑 考核等级 B', 1463918303, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (612, '编辑 考核等级 A', 1463918327, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (613, '编辑 考核等级 A', 1463918336, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (614, '增加 考核等级 B', 1463918343, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (615, '编辑 部门 乡镇', 1463918411, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (616, '编辑 部门 县综治委', 1463918435, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (617, '编辑 部门 县卫计委', 1463918445, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (618, '编辑 部门 县联席办', 1463918455, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (619, '编辑 部门 司法机关', 1463918464, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (620, '编辑 部门 行政部门', 1463918474, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (621, '增加 部门 县规土局 城管执法局', 1463918484, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (622, '编辑 部门 县规土局城管执法局', 1463918496, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (623, '增加 部门 县信访办', 1463918505, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (624, '增加 部门 县市监局', 1463918512, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (625, '编辑 部门 村', 1463918538, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (626, '增加 部门 县综治委', 1463918554, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (627, '编辑 考核目标获乡镇、县、市和国家级荣誉称号，每等级增加50分', 1463918625, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (628, '编辑 考核目标见义勇为', 1463918645, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (629, '编辑 考核目标义务献血', 1463918671, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (630, '编辑 考核目标志愿服务', 1463918688, 'cm', '58.216.100.13');
commit;
prompt 200 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (631, '编辑 考核目标慈善捐助', 1463918704, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (632, '编辑 考核目标其它承担社会责任、保护生态环境的行为', 1463918726, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (633, '编辑 考核目标受到各类刑事处罚', 1463918752, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (634, '编辑 考核目标受到各类行政处罚', 1463918767, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (635, '编辑 考核目标新增违法用地、违法建筑', 1463918785, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (636, '增加 考核目标非正常上访、非正常集访', 1463918804, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (637, '增加 考核目标食品安全事故责任', 1463918827, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (638, '增加 考核目标其它违反综合管理规定的行为', 1463918852, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (639, '增加 考核目标电、毒、炸等非法捕捞', 1463918869, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (640, '增加 考核目标违禁使用农药', 1463918883, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (641, '增加 考核目标不规范养猪场', 1463918896, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (642, '增加 考核目标其他损害生态环境行为', 1463918915, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (643, '增加 考核目标秸秆及其它垃圾焚烧', 1463918927, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (644, '增加 考核目标丧家骨灰乱埋乱葬', 1463918942, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (645, '增加 考核目标乱堆杂物、乱倒垃圾', 1463918953, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (646, '增加 考核目标其他违反社会公德的行为', 1463918963, 'cm', '58.216.100.13');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (647, 'cm 登陆系统', 1464148604, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (648, '增加 部门 县科委', 1464148931, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (649, 'cm 登陆系统', 1464180836, 'cm', '218.77.90.17');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (650, 'cm 登陆系统', 1464228757, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (651, '导出 人员列表', 1464247119, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (652, '导出 人员列表', 1464247119, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (653, '导出 人员列表', 1464247270, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (654, '导出 人员列表', 1464247271, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (655, 'zhongxin 登陆系统', 1464249401, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (656, '录入 人员 小张', 1464249868, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (657, '编辑 人员 小张', 1464249929, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (658, '编辑 人员 小张', 1464250029, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (659, '编辑 人员 小张', 1464250061, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (660, '录入 人员 小万', 1464250416, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (661, 'cm 登陆系统', 1464251038, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (662, 'zhongxin 登陆系统', 1464252483, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (663, 'cm 登陆系统', 1464253219, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (664, 'cunming2 登陆系统', 1464253619, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (665, '录入 人员 小兴', 1464253999, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (666, '提交人员信息ID为(43)', 1464254007, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (667, 'cm 登陆系统', 1464254198, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (668, 'huangbao 登陆系统', 1464254337, 'huangbao', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (669, 'cm 登陆系统', 1464254712, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (670, 'zhongxin 登陆系统', 1464254776, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (671, 'huangbao 登陆系统', 1464257216, 'huangbao', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (672, 'cm 登陆系统', 1464257268, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (673, '增加 考核记录 18::11', 1464257344, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (674, 'huangbao 登陆系统', 1464257437, 'huangbao', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (675, 'hu 登陆系统', 1464257572, 'hu', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (676, 'cm 登陆系统', 1464257669, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (677, 'huangbao 登陆系统', 1464257754, 'huangbao', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (678, 'cm 登陆系统', 1464257967, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (679, '编辑 村镇爱国村', 1464258462, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (680, '编辑 村镇爱国村', 1464258470, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (681, '编辑 村镇爱国村', 1464259080, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (682, '增加 村镇test', 1464259143, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (683, '编辑 村镇test', 1464259167, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (684, '编辑 村镇test', 1464259367, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (685, '编辑 村镇test', 1464259440, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (686, '编辑 村镇test', 1464259563, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (687, '编辑 村镇test', 1464259591, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (688, '编辑 村镇test', 1464259644, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (689, 'cm 登陆系统', 1464259757, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (690, '编辑 村镇爱国村', 1464259773, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (691, '编辑 村镇爱国村', 1464259779, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (692, 'huangbao 登陆系统', 1464259842, 'huangbao', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (693, 'cm 登陆系统', 1464259874, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (694, 'shenglicun 登陆系统', 1464260494, 'shenglicun', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (695, 'cm 登陆系统', 1464260837, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (696, 'cunming2 登陆系统', 1464261700, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (697, 'cm 登陆系统', 1464261768, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (698, 'cunming2 登陆系统', 1464265637, 'cunming2', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (699, 'cunming2 登陆系统', 1464265640, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (700, 'cm 登陆系统', 1464265703, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (701, '编辑 部门 县司法局', 1464265988, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (702, 'sifa 登陆系统', 1464266000, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (703, '增加 考核记录 25::35', 1464266092, 'cunming2', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (704, 'cunming2 登陆系统', 1464266236, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (35, '编辑 考核等级 AA', 1462704905, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (36, 'admin2 登陆系统', 1462705897, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (37, '编辑 村镇城桥村', 1462706623, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (38, '编辑 考核等级 A', 1462706656, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (39, 'cm 登陆系统', 1462708377, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (40, '编辑 村镇镇城镇1', 1462708399, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (41, '编辑 村镇城桥村1', 1462708408, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (42, '增加 村镇镇城镇2', 1462708428, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (43, '增加 村镇镇城村1', 1462708488, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (44, 'cun 登陆系统', 1462708690, 'cun', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (45, '录入 人员 aaa', 1462708732, 'cun', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (46, '编辑 人员 aaa', 1462708748, 'cun', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (47, '提交人员信息ID为(5)', 1462708751, 'cun', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (48, '增加 考核记录 5::3', 1462708788, 'cun', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (49, 'ga 登陆系统', 1462708821, 'ga', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (50, '导出 人员列表', 1462708837, 'ga', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (51, 'cqz 登陆系统', 1462708911, 'cqz', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (52, '录入 人员 ddd', 1462708975, 'cqz', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (53, 'cm 登陆系统', 1462709174, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (54, '编辑 考核目标ajian', 1462709493, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (55, '编辑 考核目标A', 1462709507, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (56, '编辑 考核目标A', 1462709507, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (57, '增加 考核目标xianxue', 1462709578, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (58, '删除考核目标 ID(4)', 1462709746, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (59, '删除考核目标 ID(5)', 1462709750, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (60, '删除考核目标 ID(5)', 1462709751, 'cm', '106.5.196.34');
commit;
prompt 300 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (61, '删除考核目标 ID(5)', 1462709751, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (62, 'ga 登陆系统', 1462709773, 'ga', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (63, '增加 考核记录 6::7', 1462709890, 'ga', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (64, 'cm 登陆系统', 1462710792, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (65, 'admin2 登陆系统', 1462711573, 'admin2', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (66, 'zheng 登陆系统', 1462755321, 'zheng', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (67, '导出 人员列表', 1462755326, 'zheng', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (68, '导出 人员列表', 1462755327, 'zheng', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (69, 'cun 登陆系统', 1462755349, 'cun', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (70, 'cm 登陆系统', 1462756042, 'cm', '115.236.91.18');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (71, 'cm 登陆系统', 1462760608, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (72, 'xiang 登陆系统', 1462762115, 'xiang', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (73, 'hu 登陆系统', 1462762415, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (74, 'yu 登陆系统', 1462762524, 'yu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (75, 'hu 登陆系统', 1462762929, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (76, '编辑 人员 ddd', 1462763142, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (77, '编辑 人员 ddd', 1462763157, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (78, '导出 人员列表', 1462763258, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (79, '导出 人员列表', 1462763338, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (80, '删除村镇 ID(5)', 1462763927, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (81, '删除村镇 ID(6)', 1462763948, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (82, '删除村镇 ID(8)', 1462763951, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (83, '删除村镇 ID(9)', 1462763954, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (84, '增加 村镇中兴镇', 1462764086, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (85, '增加 村镇陈家镇', 1462764136, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (86, '增加 村镇向化镇', 1462764330, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (87, '增加 村镇新河镇', 1462764368, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (89, '编辑 村镇中兴镇', 1462764741, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (90, '编辑 村镇建设镇', 1462764809, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (91, '编辑 村镇中兴镇', 1462764850, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (92, '删除考核目标 ID(3)', 1462764972, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (93, '删除考核目标 ID(6)', 1462764977, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (94, '删除考核目标 ID(7)', 1462764980, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (95, '删除考核目标 ID(8)', 1462764984, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (96, '增加 考核目标长的帅', 1462765038, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (97, '增加 考核目标抢劫', 1462765110, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (98, '增加 考核目标信用卡延期', 1462765218, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (100, '增加 考核目标献血', 1462765659, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (101, '增加 村镇四滧村', 1462769090, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (102, '增加 考核等级 S', 1462769592, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (103, '考核等级 ID(9)', 1462769708, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (104, '增加 考核等级 S', 1462769717, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (105, '增加 部门 县司法局', 1462769853, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (106, 'hu 登陆系统', 1462770247, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (107, '编辑 部门 崇明公安', 1462770262, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (108, '导出 人员列表', 1462770370, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (109, '录入 人员 胡', 1462770431, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (110, '提交人员信息ID为(1)', 1462770433, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (111, '导出 人员列表', 1462770448, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (112, '增加 考核记录 7::9', 1462770705, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (113, '提交考核ID为(1)', 1462770706, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (114, '提交考核ID为(11)', 1462770716, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (115, '提交考核ID为(11)', 1462770716, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (116, '导出 人员列表', 1462770799, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (117, '增加 考核记录 4::10', 1462770819, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (118, '提交考核ID为(1)', 1462770821, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (119, '提交考核ID为(12)', 1462770914, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (120, '提交考核ID为(12)', 1462770914, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (121, '增加 考核记录 6::11', 1462770952, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (122, '提交考核ID为(1)', 1462770954, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (123, '提交考核ID为(13)', 1462771169, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (124, '提交考核ID为(13)', 1462771169, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (125, 'cm 登陆系统', 1462774916, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (126, 'hu 登陆系统', 1462774929, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (127, '增加 村镇爱国村', 1462775718, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (128, '增加 村镇胜利村', 1462775778, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (129, '增加 村镇永隆村', 1462775797, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (130, '增加 村镇北兴村', 1462775817, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (131, '增加 村镇富圩村', 1462775844, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (132, '增加 村镇开港村', 1462775858, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (135, '编辑 人员 胡', 1462775970, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (136, '提交人员信息ID为(7)', 1462775972, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (137, '导出 人员列表', 1462776023, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (138, '人员 ID(8)', 1462776138, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (139, '人员 ID(6)', 1462776145, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (140, '录入 人员 hu', 1462776181, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (141, 'cm 登陆系统', 1462776208, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (142, 'cm 登陆系统', 1462776601, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (143, 'cm 登陆系统', 1462777193, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (144, 'cm 登陆系统', 1462778906, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (145, 'zhongxin 登陆系统', 1462779858, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (146, '增加 考核记录 9::9', 1462779900, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (147, '提交考核ID为(1)', 1462779902, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (148, '提交考核ID为(14)', 1462779910, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (149, '提交考核ID为(14)', 1462779910, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (150, '编辑 人员 hu', 1462780023, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (151, '提交人员信息ID为(9)', 1462780025, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (152, '增加 考核记录 7::12', 1462780234, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (156, 'hu 登陆系统', 1462780441, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (157, '导出 人员列表', 1462780733, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (158, 'cm 登陆系统', 1462781306, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (159, 'cunming2 登陆系统', 1462781336, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (161, '提交人员信息ID为(1)', 1462781466, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (162, '录入 人员 销售', 1462781509, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (163, '提交人员信息ID为(1)', 1462781511, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (164, '录入 人员 增补', 1462781550, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (165, '提交人员信息ID为(1)', 1462781550, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (166, '增加 考核记录 10::12', 1462781574, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (167, '提交考核ID为(1)', 1462781576, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (168, '增加 考核记录 11::9', 1462781585, 'cunming2', '61.152.234.186');
commit;
prompt 400 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (169, '提交考核ID为(1)', 1462781586, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (170, '增加 考核记录 12::12', 1462781594, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (171, '提交考核ID为(1)', 1462781596, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (172, 'cm 登陆系统', 1462781629, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (173, '增加 部门 村民', 1462781702, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (174, '增加 考核目标救人', 1462781776, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (175, '增加 考核目标好人一生', 1462781792, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (176, 'cunming2 登陆系统', 1462782145, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (177, '录入 人员 经理', 1462782184, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (178, '提交人员信息ID为(1)', 1462782185, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (179, '增加 考核记录 13::12', 1462782222, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (180, '提交考核ID为(1)', 1462782223, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (181, 'cm 登陆系统', 1462782243, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (182, '部门 ID(14)', 1462782358, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (184, '增加 考核目标见义勇为', 1462782507, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (185, 'hu 登陆系统', 1462782991, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (186, '增加 考核记录 10::17', 1462783040, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (187, '提交考核ID为(1)', 1462783041, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (188, '增加 考核记录 12::16', 1462783051, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (189, '提交考核ID为(1)', 1462783052, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (190, 'cunming3 登陆系统', 1462783410, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (191, '导出 人员列表', 1462783431, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (192, '编辑 人员 增补', 1462783618, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (193, '编辑 人员 增补', 1462783626, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (194, '提交人员信息ID为(12)', 1462783627, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (195, '编辑 人员 销售', 1462783642, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (196, '编辑 人员 丁宏', 1462783662, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (197, '提交人员信息ID为(10)', 1462783669, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (198, 'cm 登陆系统', 1462783717, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (199, '导出 人员列表', 1462783732, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (200, 'cm 登陆系统', 1462801624, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (201, '增加 考核记录 4::9', 1462801791, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (202, '录入 人员 王五', 1462801849, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (205, 'cm 登陆系统', 1462842036, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (206, '删除考核目标 ID(14)', 1462842275, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (207, '删除考核目标 ID(15)', 1462842280, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (208, 'hu 登陆系统', 1462842329, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (209, 'cm 登陆系统', 1462842345, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (210, 'cm 登陆系统', 1462843336, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (212, '导出 人员列表', 1462843351, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (213, '导出 人员列表', 1462843354, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (214, '增加 考核记录 5::12', 1462843523, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (215, '增加 部门 崇明水务局', 1462843894, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (216, '增加 部门 崇明科技', 1462844445, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (218, '增加 考核目标发明专利', 1462847630, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (219, '增加 考核目标大赛拿奖', 1462847664, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (220, '增加 考核目标污水处理', 1462847697, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (221, 'keji 登陆系统', 1462847794, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (222, '提交考核ID为(18)', 1462847861, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (223, '提交考核ID为(18)', 1462847861, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (226, '增加 考核记录 15::18', 1462847968, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (227, '提交考核ID为(1)', 1462847970, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (230, 'cm 登陆系统', 1462848304, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (231, 'keji 登陆系统', 1462848354, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (232, 'cm 登陆系统', 1462848515, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (233, 'keji 登陆系统', 1462848605, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (234, 'hu 登陆系统', 1462848660, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (235, 'keji 登陆系统', 1462848683, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (236, 'hu 登陆系统', 1462848947, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (237, 'hu 登陆系统', 1462849541, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (238, 'weisheng 登陆系统', 1462849583, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (239, '提交考核ID为(17)', 1462849591, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (240, '提交考核ID为(17)', 1462849591, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (241, '提交考核ID为(19)', 1462849595, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (242, '提交考核ID为(19)', 1462849595, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (243, '提交考核ID为(22)', 1462849598, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (244, '提交考核ID为(22)', 1462849598, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (245, '提交考核ID为(23)', 1462849601, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (246, '提交考核ID为(23)', 1462849601, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (247, '提交考核ID为(17)', 1462849611, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (248, '提交考核ID为(17)', 1462849611, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (249, 'cunming3 登陆系统', 1462849657, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (250, '录入 人员 博士', 1462849739, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (251, '提交人员信息ID为(1)', 1462849742, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (252, 'weisheng 登陆系统', 1462849778, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (253, 'cm 登陆系统', 1462849792, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (254, '增加 考核目标空着干净', 1462849862, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (255, 'hu 登陆系统', 1462849902, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (256, 'cm 登陆系统', 1462849958, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (257, 'weisheng 登陆系统', 1462849981, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (258, '增加 考核记录 16::21', 1462850053, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (259, '提交考核ID为(1)', 1462850055, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (260, 'hu 登陆系统', 1462850078, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (261, '提交考核ID为(20)', 1462850120, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (262, '提交考核ID为(20)', 1462850120, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (263, '提交考核ID为(21)', 1462850124, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (264, '提交考核ID为(21)', 1462850124, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (265, 'cm 登陆系统', 1462850197, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (266, 'hu 登陆系统', 1462850214, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (267, 'cunming2 登陆系统', 1462850227, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (268, 'cm 登陆系统', 1462850267, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (269, 'zhongxin 登陆系统', 1462850296, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (270, '编辑 人员 学士', 1462850306, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (271, '提交人员信息ID为(15)', 1462850311, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (272, 'cunming2 登陆系统', 1462850323, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (273, '编辑 人员 博士', 1462850345, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (274, '提交人员信息ID为(16)', 1462850347, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (275, '编辑 人员 博士', 1462850365, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (276, 'cm 登陆系统', 1462850451, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (277, '编辑 人员 博士', 1462850668, 'cm', '61.152.234.186');
commit;
prompt 500 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (278, 'zhongxin 登陆系统', 1462850674, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (279, '编辑 人员 博士', 1462850827, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (280, 'cm 登陆系统', 1462854265, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (281, '提交考核ID为(25)', 1462854276, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (282, '提交考核ID为(25)', 1462854276, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (283, 'zhongxin 登陆系统', 1462854347, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (284, '编辑 人员 博士', 1462854353, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (285, '提交人员信息ID为(16)', 1462854355, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (286, '编辑 人员 经理', 1462854391, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (287, '提交人员信息ID为(13)', 1462854392, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (288, '编辑 人员 销售', 1462854406, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (289, '提交人员信息ID为(11)', 1462854407, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (290, 'cunming2 登陆系统', 1462854420, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (291, 'cunming3 登陆系统', 1462854431, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (292, 'cunming2 登陆系统', 1462854443, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (293, 'cunming3 登陆系统', 1462854654, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (294, 'cunming2 登陆系统', 1462854659, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (295, '导出 人员列表', 1462854752, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (296, 'cunming3 登陆系统', 1462854932, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (297, '录入 人员 硕士', 1462855049, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (298, '提交人员信息ID为(1)', 1462855054, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (299, '人员 ID(17)', 1462855061, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (302, '编辑 人员 硕士', 1462855494, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (303, '提交人员信息ID为(18)', 1462855496, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (304, '编辑 人员 硕士', 1462855508, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (305, '编辑 人员 硕士', 1462855521, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (306, '提交人员信息ID为(18)', 1462855522, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (307, '编辑 人员 硕士', 1462855540, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (308, '编辑 人员 硕士', 1462855552, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (309, '提交人员信息ID为(18)', 1462855553, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (310, 'keji 登陆系统', 1462855633, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (311, '增加 考核记录 15::18', 1462855647, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (312, '提交考核ID为(1)', 1462855648, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (313, 'hu 登陆系统', 1462855686, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (314, 'cm 登陆系统', 1462855694, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (315, '提交考核ID为(26)', 1462855730, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (316, '提交考核ID为(26)', 1462855730, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (317, 'keji 登陆系统', 1462855738, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (318, 'cm 登陆系统', 1462855747, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (319, '编辑 考核目标空着干净', 1462856141, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (320, '编辑 人员 学士', 1462856162, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (321, '编辑 人员 硕士', 1462856184, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (322, 'hu 登陆系统', 1462856948, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (323, 'cunming2 登陆系统', 1462857027, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (324, 'zhongxin 登陆系统', 1462857055, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (325, '录入 人员 yuzi', 1462857170, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (326, '提交人员信息ID为(1)', 1462857171, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (327, '编辑 人员 yuzi', 1462857195, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (328, '提交人员信息ID为(19)', 1462857197, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (329, '编辑 人员 yuzi', 1462857210, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (330, '编辑 人员 yuzi', 1462857339, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (331, '提交人员信息ID为(19)', 1462857340, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (332, '编辑 人员 yuzi', 1462857434, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (18, '增加 考核目标aa', 1462684420, 'admin2', '127.0.0.1');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (20, 'admin2 登陆系统', 1462684834, 'admin2', '106.120.160.109');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (21, 'admin2 登陆系统', 1462684853, 'admin2', '101.199.112.49');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (22, 'admin2 登陆系统', 1462685543, 'admin2', '106.120.160.109');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (23, 'admin2 登陆系统', 1462685586, 'admin2', '171.8.167.64');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (24, '导出 人员列表', 1462686200, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (25, '导出 人员列表', 1462686201, 'admin2', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (203, 'cm 登陆系统', 1462804822, 'cm', '106.120.160.109');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (204, 'cm 登陆系统', 1462804840, 'cm', '101.199.108.59');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (217, '增加 部门 崇明体育', 1462844520, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (224, '录入 人员 学士', 1462847945, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (225, '提交人员信息ID为(1)', 1462847946, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (228, '提交考核ID为(16)', 1462848132, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (229, '提交考核ID为(16)', 1462848132, 'keji', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (300, '录入 人员 硕士', 1462855130, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (301, '提交人员信息ID为(1)', 1462855131, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (333, '人员 ID(19)', 1462857603, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (334, '录入 人员 yuzi', 1462857769, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (335, '提交人员信息ID为(1)', 1462857778, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (336, '编辑 人员 yuzi', 1462857796, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (337, '提交人员信息ID为(20)', 1462857798, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (338, 'cm 登陆系统', 1462861686, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (339, '录入 人员 李四', 1462861930, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (340, '提交人员信息ID为(1)', 1462861932, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (341, '编辑 人员 李四', 1462861943, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (342, '提交人员信息ID为(21)', 1462861944, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (343, '录入 人员 王五', 1462862018, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (344, '提交人员信息ID为(1)', 1462862020, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (345, '编辑 人员 王五', 1462862099, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (346, '提交人员信息ID为(22)', 1462862101, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (347, '录入 人员 狗二', 1462862166, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (348, '提交人员信息ID为(1)', 1462862168, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (349, '编辑 人员 狗二', 1462862174, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (350, '提交人员信息ID为(23)', 1462862175, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (351, 'hu 登陆系统', 1462862342, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (352, '增加 考核记录 21::17', 1462862408, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (353, '提交考核ID为(1)', 1462862409, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (354, '提交考核ID为(27)', 1462862418, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (355, '提交考核ID为(27)', 1462862418, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (356, '增加 考核记录 22::17', 1462862431, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (357, '提交考核ID为(1)', 1462862433, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (358, '提交考核ID为(28)', 1462862442, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (359, '提交考核ID为(28)', 1462862442, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (360, 'weisheng 登陆系统', 1462862470, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (361, '增加 考核记录 15::13', 1462862489, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (362, '提交考核ID为(1)', 1462862490, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (363, '提交考核ID为(29)', 1462862504, 'weisheng', '61.152.234.186');
commit;
prompt 600 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (364, '提交考核ID为(29)', 1462862504, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (365, '增加 考核记录 18::21', 1462862515, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (366, '提交考核ID为(1)', 1462862517, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (367, '提交考核ID为(30)', 1462862528, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (368, '提交考核ID为(30)', 1462862528, 'weisheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (369, '编辑 人员 狗二', 1462862639, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (370, 'zhongxin 登陆系统', 1462862664, 'zhongxin', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (371, '编辑 人员 狗二', 1462862671, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (372, '删除考核目标 ID(21)', 1462862778, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (373, '增加 村镇港西镇', 1462862886, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (374, 'cunming 登陆系统', 1462863006, 'cunming', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (375, 'aiguo 登陆系统', 1462863360, 'aiguo', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (376, '录入 人员 胡哥', 1462863594, 'aiguo', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (377, '提交人员信息ID为(1)', 1462863596, 'aiguo', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (378, '编辑 人员 胡哥', 1462863611, 'aiguo', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (379, '提交人员信息ID为(24)', 1462863614, 'aiguo', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (380, 'shuiwu 登陆系统', 1462863644, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (381, '增加 考核目标清理水渠', 1462863712, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (382, '增加 考核记录 23::22', 1462863743, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (383, '提交考核ID为(1)', 1462863745, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (384, '提交考核ID为(31)', 1462863750, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (385, '提交考核ID为(31)', 1462863750, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (386, '增加 考核记录 23::20', 1462863771, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (387, '提交考核ID为(1)', 1462863772, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (388, '提交考核ID为(32)', 1462863777, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (389, '提交考核ID为(32)', 1462863777, 'shuiwu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (390, '人员 ID(5)', 1462864150, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (391, '人员 ID(4)', 1462864156, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (392, '人员 ID(14)', 1462864216, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (393, '人员 ID(7)', 1462864236, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (394, '人员 ID(9)', 1462864239, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (395, '人员 ID(10)', 1462864241, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (396, '人员 ID(11)', 1462864244, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (397, '人员 ID(12)', 1462864250, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (398, '人员 ID(13)', 1462864254, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (399, '删除村镇 ID(19)', 1462864997, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (400, 'cunming2 登陆系统', 1462865044, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (401, '增加 村镇北兴村', 1462865375, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (402, 'cunming3 登陆系统', 1462865459, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (403, '录入 人员 张三', 1462866002, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (404, '提交人员信息ID为(1)', 1462866004, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (405, '录入 人员 赫磊', 1462866118, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (406, '提交人员信息ID为(1)', 1462866119, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (407, '录入 人员 文采', 1462866328, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (408, '提交人员信息ID为(1)', 1462866330, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (409, 'hu 登陆系统', 1462866806, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (410, '增加 考核记录 27::9', 1462866820, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (411, '提交考核ID为(1)', 1462866821, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (412, '增加 考核记录 26::9', 1462866833, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (413, '提交考核ID为(1)', 1462866834, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (414, '增加 考核记录 25::10', 1462866844, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (415, '提交考核ID为(1)', 1462866845, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (416, '提交考核ID为(33)', 1462866852, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (418, '提交考核ID为(34)', 1462866855, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (419, '提交考核ID为(34)', 1462866855, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (420, '提交考核ID为(35)', 1462866859, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (421, '提交考核ID为(35)', 1462866859, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (422, 'cm 登陆系统', 1462866968, 'cm', '220.181.132.216');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (423, 'cm 登陆系统', 1462867807, 'cm', '101.199.108.118');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (424, '增加 考核记录 23::12', 1462867950, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (425, '提交考核ID为(1)', 1462867952, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (426, '提交考核ID为(36)', 1462870897, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (427, '提交考核ID为(36)', 1462870897, 'hu', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (428, 'cunming2 登陆系统', 1462871177, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (429, '编辑 人员 文采', 1462871183, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (430, '提交人员信息ID为(27)', 1462871184, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (431, '编辑 人员 文采', 1462871195, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (432, 'cunming3 登陆系统', 1462871245, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (433, '编辑 人员 赫磊', 1462871250, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (434, '编辑 人员 赫磊', 1462871259, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (435, '提交人员信息ID为(26)', 1462871260, 'cunming2', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (436, '编辑 人员 赫磊', 1462871274, 'cunming3', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (437, 'cm 登陆系统', 1462886772, 'cm', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (438, 'cunming1 登陆系统', 1462888217, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (439, '录入 人员 张三丰', 1462888284, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (440, '提交人员信息ID为(1)', 1462888295, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (441, '提交人员信息ID为(1)', 1462888296, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (442, '提交人员信息ID为(1)', 1462888297, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (443, '提交人员信息ID为(1)', 1462888297, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (444, '提交人员信息ID为(1)', 1462888297, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (445, '提交人员信息ID为(1)', 1462888297, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (446, '提交人员信息ID为(1)', 1462888297, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (447, '提交人员信息ID为(1)', 1462888298, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (448, '提交人员信息ID为(1)', 1462888300, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (449, '提交人员信息ID为(1)', 1462888300, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (450, '提交人员信息ID为(1)', 1462888301, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (451, '提交人员信息ID为(1)', 1462888301, 'cunming1', '106.5.196.34');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (789, 'cm 登陆系统', 1464759848, 'cm', '117.135.159.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (705, 'cm 登陆系统', 1464266249, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (706, 'xzzheng 登陆系统', 1464266517, 'xzzheng', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (707, '增加 考核记录 24::10', 1464266673, 'xzzheng', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (709, 'sifa 登陆系统', 1464266774, 'sifa', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (790, 'cm 登陆系统', 1464759848, 'cm', '117.135.159.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (710, 'sifa 登陆系统', 1464267395, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (711, 'cm 登陆系统', 1464267407, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (712, 'sifa 登陆系统', 1464267441, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (713, '增加 考核记录 16::20', 1464267488, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (714, '提交考核ID为(47)', 1464267490, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (715, 'cm 登陆系统', 1464267508, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (716, 'zhongxin 登陆系统', 1464267525, 'zhongxin', '218.94.115.134');
commit;
prompt 700 records committed...
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (717, 'cm 登陆系统', 1464267585, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (791, 'cm 登陆系统', 1464759849, 'cm', '117.135.159.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (708, 'xzzheng 登陆系统', 1464266721, 'xzzheng', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (718, 'xzzheng 登陆系统', 1464267767, 'xzzheng', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (721, '增加 考核记录 27::35', 1464268266, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (722, 'xzzheng 登陆系统', 1464268436, 'xzzheng', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (723, '增加 考核记录 28::10', 1464268500, 'xzzheng', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (724, 'sifa 登陆系统', 1464268638, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (725, '编辑 人员 博士', 1464268732, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (726, '编辑 人员 硕士', 1464268750, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (727, '人员 ID(23)', 1464268757, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (728, '人员 ID(22)', 1464268760, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (729, '人员 ID(21)', 1464268763, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (730, '人员 ID(20)', 1464268767, 'cm', '117.41.232.76');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (731, '增加 考核记录 37::20', 1464268804, 'sifa', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (732, 'cm 登陆系统', 1464268898, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (719, 'zhongxin 登陆系统', 1464268001, 'zhongxin', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (720, 'cunming2 登陆系统', 1464268068, 'cunming2', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (748, 'cm 登陆系统', 1464333774, 'cm', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (749, 'xzzheng 登陆系统', 1464333869, 'xzzheng', '101.231.89.54');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (751, 'cm 登陆系统', 1464573218, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (752, '编辑 人员 张无忌', 1464573651, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (753, '编辑 人员 张无忌', 1464573679, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (754, '编辑 人员 学士', 1464573739, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (755, '导出 人员列表', 1464573783, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (756, '增加 村镇新村', 1464573934, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (757, '编辑 村镇新村', 1464574001, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (758, 'cm 登陆系统', 1464574824, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (759, '增加 考核记录 18::18', 1464575086, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (760, 'sifa 登陆系统', 1464575210, 'sifa', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (761, 'cm 登陆系统', 1464575280, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (762, 'xzzheng 登陆系统', 1464575353, 'xzzheng', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (763, 'jian 登陆系统', 1464575404, 'jian', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (765, 'cm 登陆系统', 1464586526, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (766, '导出 人员列表', 1464588888, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (767, '导出 人员列表', 1464588898, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (768, 'jian 登陆系统', 1464590375, 'jian', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (769, 'cm 登陆系统', 1464590408, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (770, 'sifa 登陆系统', 1464590507, 'sifa', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (771, '增加 考核记录 24::20', 1464590532, 'sifa', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (772, '提交考核ID为(54)', 1464590533, 'sifa', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (773, 'jian 登陆系统', 1464590557, 'jian', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (774, 'cm 登陆系统', 1464590673, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (775, 'jian 登陆系统', 1464590694, 'jian', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (776, 'cm 登陆系统', 1464590989, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (777, '增加 村镇建设村', 1464591023, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (778, 'cun 登陆系统', 1464591051, 'cun', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (779, '录入 人员 11', 1464591175, 'cun', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (783, 'jian 登陆系统', 1464591230, 'jian', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (784, 'cm 登陆系统', 1464591365, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (785, 'cm 登陆系统', 1464601014, 'cm', '218.94.115.134');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (786, 'cm 登陆系统', 1464759846, 'cm', '117.135.159.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (792, 'cm 登陆系统', 1464847879, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (733, 'sifa 登陆系统', 1464273360, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (734, 'cm 登陆系统', 1464273382, 'cm', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (735, 'sifa 登陆系统', 1464274248, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (736, '增加 考核记录 25::20', 1464274299, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (737, '提交考核ID为(51)', 1464274301, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (738, '提交考核ID为(50)', 1464274310, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (739, '提交考核ID为(50)', 1464274310, 'sifa', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (740, 'xzzheng 登陆系统', 1464274347, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (741, '增加 考核记录 24::33', 1464274396, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (742, '提交考核ID为(52)', 1464274398, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (743, '提交考核ID为(46)', 1464274412, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (744, '提交考核ID为(46)', 1464274412, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (745, '提交考核ID为(49)', 1464274418, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (746, '提交考核ID为(49)', 1464274418, 'xzzheng', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (787, 'cm 登陆系统', 1464759847, 'cm', '117.135.159.4');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (747, 'cm 登陆系统', 1464274565, 'cm', '223.166.74.51');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (750, 'cm 登陆系统', 1464572576, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (764, 'cm 登陆系统', 1464583985, 'cm', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (780, '提交人员信息ID为(44)', 1464591177, 'cun', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (781, '导出 人员列表', 1464591183, 'cun', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (782, '导出 人员列表', 1464591194, 'cun', '61.152.234.186');
insert into CM_LOG (ID, INFO, PUBDATE, AUTHOR, IP)
values (788, 'cm 登陆系统', 1464759847, 'cm', '117.135.159.4');
commit;
prompt 775 records loaded
prompt Loading CM_PART...
insert into CM_PART (ID, PART_NAME)
values (19, '行政部门');
insert into CM_PART (ID, PART_NAME)
values (22, '县规土局城管执法局');
insert into CM_PART (ID, PART_NAME)
values (25, '县综治委');
insert into CM_PART (ID, PART_NAME)
values (12, '乡镇');
insert into CM_PART (ID, PART_NAME)
values (13, '村');
insert into CM_PART (ID, PART_NAME)
values (23, '县信访办');
insert into CM_PART (ID, PART_NAME)
values (15, '县卫计委');
insert into CM_PART (ID, PART_NAME)
values (16, '县联席办');
insert into CM_PART (ID, PART_NAME)
values (24, '县市监局');
insert into CM_PART (ID, PART_NAME)
values (26, '县科委');
insert into CM_PART (ID, PART_NAME)
values (18, '县司法局');
commit;
prompt 11 records loaded
prompt Loading CM_PERSON...
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (25, '张三', '330724199405245098', '男', '团员', '大学', 23, '123473381313', '2016-05-04', '浙江东阳', 1000, 1462866002, 'cunming3', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (26, '赫磊', '1111111111122223', '男', '中国人', '大学', 23, '123212341331', '2016-05-18', '浙江', 1000, 1462866118, 'cunming3', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (27, '文采', '2112121212121332', '男', '团员', '大学', 23, '13244323212', '2016-05-11', '浙江东阳', 1000, 1462866328, 'cunming3', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (30, '黄药师', '3320123003213213', '男', '团员', '大学本科', 17, '138606506851', '1899-12-07', '浙江杭州', 1000, 1462888627, 'cunming1', 1, '地', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (41, '小张', '320105789804525', '女', '党员', '大专', 17, '13956561002', '2016-05-11', '中兴镇大大乡', 1000, 1464249868, 'zhongxin', 0, '刚才外地回来', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (42, '小万', '365150222225685', '女', '群众', '高中', 23, '12312313413', '2016-05-12', '北兴村', 1000, 1464250416, 'zhongxin', 0, '海归', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (43, '小兴', '325542522565542', '男', '群众', '本科', 23, '11231231321', '2016-05-12', '北兴村', 1000, 1464253999, 'cunming2', 1, '好啊红啊啊', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (16, '博士', '411423199309165087', '男', '党员', '博士', 16, '13800571505', '1899-12-31', '浙江东阳', 1000, 1462849739, 'cunming3', 1, '东阳', 0);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (24, '胡哥', '330724199405245812', '男', '团员', '大学', 16, '134523423132', '2016-05-12', '浙江东阳', 1000, 1462863594, 'aiguo', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (15, '学士', '331082198402147871', '男', '2222313343', 'daf', 21, '13800571505', '2016-05-17', '浙江', 1000, 1462847945, 'keji', 1, '好人', 0);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (18, '硕士', '330724199405245814', '男', '大学', '大学', 16, '13800571505', '2016-05-12', '浙江东阳', 1000, 1462855130, 'cunming3', 1, '好人', 0);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (44, '11', '342363654863484674', '男', '团员', '高中', 27, '13033303222', '2016-04-27', '安徽', 1000, 1464591175, 'cun', 1, null, 13);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (28, '张三丰', '331082198402147871', '男', '党员', '大科', 17, '13800571505', '2008-04-16', '浙江', 1000, 1462888284, 'cunming1', 1, '无', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (29, '李四海', '331082198402147871', '男', '团员', '大学本科', 17, '13800571505', '1899-12-07', '浙江杭州', 1000, 1462888480, 'cunming1', 1, '无', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (31, '张果老', '3320123003213211', '男', '团员', '大学本科', 17, '18606506851', '1899-12-07', '浙江杭州', 1000, 1462888676, 'cunming1', 1, '无', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (35, '张无忌', '331082198402141212', '男', '团员', '文盲', 18, '13808987688', '2012-05-11', '无', 1000, 1462929900, 'cunming1', 1, '无', 0);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (36, '一', '41142199309165087', '男', '团员', '大学', 23, '13245674356', '2016-05-06', '浙江东阳', 1000, 1462930358, 'cunming2', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (37, '二', '411423199309165087', '女', '团员', '大学', 23, '134572429857', '2016-05-17', '浙江东阳', 1000, 1462930503, 'cunming2', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (38, '三', '411423199309165087', '女', '团员', '大学', 23, '15432654372', '2016-05-05', '浙江', 1000, 1462930546, 'cunming2', 1, '好人', null);
insert into CM_PERSON (ID, TRUENAME, SSID, SEX, ZZMM, WHCD, COUNTRY_ID, PHONE, BIRTHDAY, ADDRESS, SCORE, PUBDATE, AUTHOR, STAT, REMARK, PART_ID)
values (39, '四', '411423199309165087', '男', '团员', '大学', 23, '173616310348134', '2016-05-02', '浙江东阳', 1000, 1462930649, 'cunming2', 1, '好人', null);
commit;
prompt 20 records loaded
prompt Loading CM_RECORD...
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (51, 25, 20, -9999, 'sifa', 1464274299, 1, 1472914299, 18);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (52, 24, 33, -150, 'xzzheng', 1464274396, 1, 1464274396, 12);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (46, 24, 10, 50, 'xzzheng', 1464266673, 1, 1550666673, 12);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (45, 25, 35, -100, 'cunming2', 1464266092, 0, 1464266092, 13);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (47, 16, 20, -100, 'sifa', 1464267488, 1, 1472907488, 18);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (48, 27, 35, -103, 'cunming2', 1464268266, 0, 1464268266, 13);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (49, 28, 10, 50, 'xzzheng', 1464268500, 1, 1550668500, 12);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (50, 37, 20, -910, 'sifa', 1464268803, 1, 1472908803, 18);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (53, 18, 18, 50, 'cm', 1464575086, 0, 1550975086, 0);
insert into CM_RECORD (ID, PERSON_ID, TARGET_ID, SCORE, AUTHOR, PUBDATE, STAT, DATELINE, PART_ID)
values (54, 24, 20, -9999, 'sifa', 1464590532, 1, 1473230532, 18);
commit;
prompt 10 records loaded
prompt Loading CM_ROLE...
prompt Table is empty
prompt Loading CM_TARGET...
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (28, '非正常上访、非正常集访', -200, 'cm', 1463918804, 10000, 23);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (31, '电、毒、炸等非法捕捞', -150, 'cm', 1463918869, 0, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (29, '食品安全事故责任', -200, 'cm', 1463918827, 1000, 24);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (32, '违禁使用农药', -150, 'cm', 1463918883, 0, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (33, '不规范养猪场', -150, 'cm', 1463918896, 0, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (34, '其他损害生态环境行为', -150, 'cm', 1463918915, 0, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (35, '秸秆及其它垃圾焚烧', -100, 'cm', 1463918927, 0, 13);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (36, '丧家骨灰乱埋乱葬', -100, 'cm', 1463918942, 0, 13);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (37, '乱堆杂物、乱倒垃圾', -10, 'cm', 1463918953, 0, 13);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (38, '其他违反社会公德的行为', -100, 'cm', 1463918963, 0, 13);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (12, '义务献血', 100, 'admin', 1462765249, 1000, 15);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (10, '获乡镇、县、市和国家级荣誉称号，每等级增加50分', 50, 'admin', 1462765110, 1000, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (11, '见义勇为', 200, 'admin', 1462765218, 1000, 25);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (30, '其它违反综合管理规定的行为', -200, 'cm', 1463918852, 1000, 16);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (18, '慈善捐助', 50, 'admin', 1462847630, 1000, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (20, '受到各类刑事处罚', -9999, 'admin', 1462847697, 100, 18);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (17, '志愿服务', 50, 'admin', 1462782507, 1000, 12);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (19, '其它承担社会责任、保护生态环境的行为', 50, 'admin', 1462847664, 200, 16);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (22, '受到各类行政处罚', -200, 'admin', 1462863712, 190, 19);
insert into CM_TARGET (ID, TARGET_NAME, TARGET_SCORE, AUTHOR, PUBDATE, DATELINE, PART_ID)
values (23, '新增违法用地、违法建筑', -200, 'cm', 1462935018, 1000, 22);
commit;
prompt 20 records loaded
prompt Loading LADP_APPLICATION...
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160501', '崇明信用', '功能权限', '诚信考核', '报表结构', 'http://127.0.0.1:8081/Home/Index', null, 'admin', null, 46);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20150327', '崇明信用', '功能权限', '绩效考核', '模块定制', null, null, 'admin', to_date('16-03-2015', 'dd-mm-yyyy'), 31);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20141231', '崇明信用', '功能权限', '信用配置工具管理', '业务类别', null, null, 'admin', to_date('24-12-2014', 'dd-mm-yyyy'), 19);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20141209', '崇明信用', '功能权限', '信用数据查询', '企业信用档案查询', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 1);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012101', '崇明信用', '功能权限', '信用数据查询', '个人信用档案查询', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 2);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012102', '崇明信用', '功能权限', '信用数据查询', '专项查询', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 3);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012100', '崇明信用', '功能权限', '信用配置工具管理', '数据权限配置', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 17);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012023', '崇明信用', '功能权限', '信用配置工具管理', '元数据管理', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 18);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012005', '崇明信用', '功能权限', '信用数据管理', '数据监控', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 10);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012006', '崇明信用', '功能权限', '信用数据管理', '数据上传统计', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 11);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012012', '崇明信用', '功能权限', '信用数据管理', '信用数据导入', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 9);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012018', '崇明信用', '功能权限', '系统管理', '用户管理', '/web/pmi/orgmgt/doFullOrgFindAllAction.do?dispatch=toOrg', null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 21);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012019', '崇明信用', '功能权限', '系统管理', '权限管理', '/web/pmi/orgmgt/doFullOrgFindAllAction.do?dispatch=toAuthor', null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 22);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012020', '崇明信用', '功能权限', '系统管理', '操作日志', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 23);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_2012026', '崇明信用', '功能权限', '信用数据查询', '信息资源目录', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 8);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20150319', '崇明信用', '功能权限', '系统管理', '市接口日志', null, null, 'admin', to_date('04-06-2012', 'dd-mm-yyyy'), 24);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20150324', '崇明信用', '功能权限', '绩效考核', '绩效明细', null, null, 'admin', to_date('16-03-2015', 'dd-mm-yyyy'), 30);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20150326', '崇明信用', '功能权限', '绩效考核', '绩效统计', '/web/detailPerAction.do?dispatch=queryDetailAllForm', null, 'admin', to_date('16-03-2015', 'dd-mm-yyyy'), 31);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160406', '崇明信用', '功能权限', '诚信考核', '考核指标', '/web/homt/target.do', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 39);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160400', '崇明信用', '功能权限', '诚信考核', '村镇管理', '/web/home/country.do?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 40);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160401', '崇明信用', '功能权限', '诚信考核', '等级管理', 'http://127.0.0.1:8081/Home/Level?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 41);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160402', '崇明信用', '功能权限', '诚信考核', '考核部门', 'http://127.0.0.1:8081/Home/Part?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 42);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160403', '崇明信用', '功能权限', '诚信考核', '人员管理', 'http://127.0.0.1:8081/Home/Person?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 43);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160404', '崇明信用', '功能权限', '诚信考核', '考核管理', 'http://127.0.0.1:8081/Home/Record?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 44);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160405', '崇明信用', '功能权限', '诚信考核', '诚信统计', 'http://127.0.0.1:8081/Home/Statistics?1=1', null, 'admin', to_date('04-06-2016', 'dd-mm-yyyy'), 45);
insert into LADP_APPLICATION (APPLICATION_ID, APPLICATIONNAME, SUBSYSTEMNAME, WORKFLOWNAME, STEPNAME, STEPPAGE, STEPDESC, CREATEBY, CREATEDATE, ORDER_ID)
values ('_App_pdcx_20160502', '崇明信用', '功能权限', '诚信考核', '日志', 'http://127.0.0.1:8081/Home/Log', null, 'admin', to_date('05-01-2016', 'dd-mm-yyyy'), 48);
commit;
prompt 26 records loaded
prompt Loading MODEL_INDEX_INFO...
insert into MODEL_INDEX_INFO (MODEL_INDEX_ID, MODEL_ID, INDEX_ID, WEIGHT, MAX_VALUE, MIN_VALUE, IS_FOUJUE, SX)
values ('C433F6BFC0A8043801FBB2D675569CA5', 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', 3, null, null, null, 1);
insert into MODEL_INDEX_INFO (MODEL_INDEX_ID, MODEL_ID, INDEX_ID, WEIGHT, MAX_VALUE, MIN_VALUE, IS_FOUJUE, SX)
values ('C433F6DEC0A8043801FBB2D683EB561E', 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', 3, null, null, null, 2);
insert into MODEL_INDEX_INFO (MODEL_INDEX_ID, MODEL_ID, INDEX_ID, WEIGHT, MAX_VALUE, MIN_VALUE, IS_FOUJUE, SX)
values ('C433F6DEC0A8043801FBB2D6D4FAE09A', 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719115372308', 3, null, null, null, 3);
insert into MODEL_INDEX_INFO (MODEL_INDEX_ID, MODEL_ID, INDEX_ID, WEIGHT, MAX_VALUE, MIN_VALUE, IS_FOUJUE, SX)
values ('613C32B9C0A8043801AE9B8B469257C8', '613C2DD4C0A8043801AE9B8BCEF38C22', '2014121215572597111', 10, null, null, null, 1);
commit;
prompt 4 records loaded
prompt Loading MODEL_INFO...
insert into MODEL_INFO (MODEL_ID, MODEL_NAME, MODEL_RESULT_TABLE, MODEL_SEQUENCE, MODEL_LEVEL_ID, NEW_RESULT, NEW_CREATE_TIME, CREATE_TIME, CREATE_USER, REMARK, MODEL_RESULT_MX_TABLE, MODEL_MX_SEQUENCE)
values ('C433F4C4C0A8043801FBB2D6B67F7775', '通用分级', 'MODEL_RESULT_21', 'S_MODEL_RESULT_21', '3F2064DDC0A80B4800A00DB683E9949E', 232063, to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_date('07-01-2015 19:42:27', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'MODEL_RESULT_MX_21', 'S_MODEL_RESULT_MX_21');
commit;
prompt 1 records loaded
prompt Loading MODEL_RESULT_MX_21...
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (97, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF602546D6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (98, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF6021CB16040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (99, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600F7B26040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (100, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601A42C6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (101, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60069876040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (102, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600E6E06040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (103, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601B8D96040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (104, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60107076040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (105, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF60077476040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (106, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600557C6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (107, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF60213E56040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (108, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600A4376040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (109, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF6015EE76040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (110, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600D4766040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (111, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF6025F346040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (112, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60221646040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (113, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF60049BA6040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (114, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF60088676040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (115, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600E93E6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (116, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60086D96040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (117, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60082B46040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (118, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601ED426040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (119, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF601FD006040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (120, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF60244D56040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (121, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600EE0C6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (122, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60071296040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (123, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF602635E6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (124, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', 'A281ED953384502CE043AC10660C502C', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (125, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', 'A281ED9585A6502CE043AC10660C502C', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (126, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', 'B8482F3639C26098E043AC10660C6098', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (81, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60073F46040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (82, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60190856040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (83, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600D2636040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (84, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600B9436040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (85, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF6027C986040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (86, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60116FC6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (87, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60284406040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (88, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601CA036040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (89, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60175686040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (90, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600F87E6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (91, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601B0AD6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (92, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF600DA086040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (93, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF601C16B6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (94, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF6018DEC6040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (95, 'C433F4C4C0A8043801FBB2D6B67F7775', '2015010719105070246', '767DF6024E9F6040E0437F0000016040', -10, '近三年内共1条', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into MODEL_RESULT_MX_21 (MODEL_RESULT_MX_ID, MODEL_ID, INDEX_ID, ENTERPRISE_ID, INDEX_DATA, RESULT, CREATE_DATE)
values (96, 'C433F4C4C0A8043801FBB2D6B67F7775', '2014122617242384000', '767DF60224456040E0437F0000016040', 10, '共1条记录', to_timestamp('07-01-2015 21:21:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 46 records loaded
prompt Loading PERFORM_INFO...
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('560', '建设镇', 'jian', '0', 2, to_date('30-05-2016 10:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:35:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('562', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 13:35:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 13:35:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 13:40:20', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('563', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 13:59:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 13:59:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:04:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('564', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 14:07:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:07:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:12:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('565', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 14:37:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:37:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:42:16', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('567', '县司法局', 'sifa', '0', 2, to_date('30-05-2016 14:41:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:41:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:46:44', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('570', '建设村', 'cun', '0', 2, to_date('30-05-2016 14:50:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:50:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:55:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('574', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 17:36:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 17:36:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 17:41:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('576', '系统管理部', 'cm', '0', 2, to_date('01-06-2016 11:15:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 11:15:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 11:20:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('577', '系统管理部', 'cm', '0', 2, to_date('01-06-2016 13:42:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 13:42:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 13:47:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('578', '系统管理部', 'cm', '0', 2, to_date('01-06-2016 13:51:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 13:51:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 13:56:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('579', '系统管理部', 'cm', '0', 2, to_date('02-06-2016 14:10:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-06-2016 14:10:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-06-2016 14:15:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('556', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 10:14:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:14:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:19:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('557', '县司法局', 'sifa', '0', 2, to_date('30-05-2016 10:26:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:26:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:31:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('329', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 16:09:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:09:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:14:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('332', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 17:00:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:00:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:05:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('333', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 17:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:28:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('338', '城桥村', 'cqcadmin', '0', 2, to_date('06-05-2016 18:45:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 18:45:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 18:50:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('340', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 12:46:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 12:46:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 12:51:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('343', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 13:36:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:36:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:41:33', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('344', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 18:42:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 18:42:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 18:47:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('328', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 15:38:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 15:38:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 15:43:53', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('347', '系统管理部', 'cm', '0', 2, to_date('08-05-2016 19:57:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:57:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:02:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('348', '城桥村1', 'cun', '0', 2, to_date('08-05-2016 19:58:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:58:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:03:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('349', '公安局', 'ga', '0', 2, to_date('08-05-2016 20:00:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:00:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:05:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('350', '城桥镇1', 'cqz', '0', 2, to_date('08-05-2016 20:01:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:01:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:06:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('351', '系统管理部', 'cm', '0', 2, to_date('08-05-2016 20:04:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:04:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:09:19', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('352', '公安局', 'ga', '0', 2, to_date('08-05-2016 20:16:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:16:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:21:09', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('353', '系统管理部', 'cm', '0', 2, to_date('08-05-2016 20:32:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:32:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 20:37:45', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('354', '城桥镇', 'zheng', '0', 2, to_date('09-05-2016 08:55:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 08:55:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 09:00:08', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('355', '城桥村1', 'cun', '0', 2, to_date('09-05-2016 08:55:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 08:55:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 09:00:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('356', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 08:58:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 08:58:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 09:03:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('357', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 09:04:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 09:04:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 09:09:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('358', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 10:43:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:43:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:48:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('359', '崇明公安', 'yu', '0', 2, to_date('09-05-2016 10:48:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:48:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:53:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('360', '崇明公安', 'xiang', '0', 2, to_date('09-05-2016 10:48:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:48:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:53:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('364', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 10:53:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:53:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:58:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('365', '崇明公安', 'yu', '0', 2, to_date('09-05-2016 10:54:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:54:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:59:03', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('368', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 11:02:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 11:02:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 11:07:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('370', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 13:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 13:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 13:09:00', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('371', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 13:31:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 13:31:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 13:36:06', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('372', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 14:22:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:22:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:27:04', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('373', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 14:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:35:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('376', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 14:50:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:50:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:55:19', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('377', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 14:59:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:59:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:04:47', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('378', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 15:15:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:15:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:20:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('384', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 15:53:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:53:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:58:58', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('386', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 16:02:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:02:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:07:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('387', '北兴村', 'cunming2', '0', 2, to_date('09-05-2016 16:08:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:08:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:13:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('388', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 16:13:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:13:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:18:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('392', '北兴村', 'cunming3', '0', 2, to_date('09-05-2016 16:43:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:43:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:48:27', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('393', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 16:48:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:48:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:53:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('394', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 21:46:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 21:46:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 21:51:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('395', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 09:00:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:00:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:05:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('396', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 09:05:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:05:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:10:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('397', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 09:05:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:05:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 09:10:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('402', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 10:50:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:50:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:55:44', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('403', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 10:50:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:50:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:55:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('404', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 10:58:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:58:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:03:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('405', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 11:05:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:05:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:10:24', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('406', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 11:05:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:05:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:10:38', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('411', '中兴镇', 'zhongxin', '0', 2, to_date('10-05-2016 11:18:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:18:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:23:13', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('412', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 12:24:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:24:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:29:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('413', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 12:25:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:25:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:30:03', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('416', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 12:25:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:25:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:30:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('418', '崇明科技', 'keji', '0', 2, to_date('10-05-2016 12:47:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:47:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:52:10', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('419', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 13:08:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:08:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:13:34', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('422', '中兴镇', 'zhongxin', '0', 2, to_date('10-05-2016 13:10:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:10:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:15:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('423', '中兴镇', 'zhongxin', '0', 2, to_date('10-05-2016 14:27:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:27:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:32:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('425', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 14:38:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:38:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:43:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('426', '卫生局', 'weisheng', '0', 2, to_date('10-05-2016 14:41:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:41:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:46:07', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('427', '中兴镇', 'zhongxin', '0', 2, to_date('10-05-2016 14:44:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:44:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:49:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('428', '爱国村', 'cunming', '0', 2, to_date('10-05-2016 14:49:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:49:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:54:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('430', '崇明水务局', 'shuiwu', '0', 2, to_date('10-05-2016 15:00:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:00:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:05:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('433', '北兴村', 'cunming3', '0', 2, to_date('10-05-2016 15:30:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:30:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:35:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('434', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 15:53:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:53:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:58:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('437', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 17:06:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:06:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:11:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('439', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 21:26:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 21:26:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 21:31:06', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('440', '胜利村', 'cunming1', '0', 2, to_date('10-05-2016 21:50:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 21:50:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 21:55:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('441', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 22:16:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 22:16:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 22:21:03', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('442', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 06:56:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 06:56:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 07:01:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('443', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 08:36:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 08:36:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 08:41:19', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('444', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 08:48:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 08:48:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 08:53:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('445', '胜利村', 'cunming1', '0', 2, to_date('11-05-2016 08:58:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 08:58:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:03:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('450', '中兴镇', 'zhongxin', '0', 2, to_date('11-05-2016 09:15:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:15:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:20:20', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('451', '胜利村', 'cunming1', '0', 2, to_date('11-05-2016 09:15:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:15:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:20:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('452', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 09:22:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:22:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:27:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('453', '向化镇', 'xianghua', '0', 2, to_date('11-05-2016 09:25:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:25:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:30:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('454', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 09:30:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:30:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:35:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('458', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 10:39:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:39:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:44:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('460', '崇明公安', 'hu', '0', 2, to_date('11-05-2016 10:47:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:47:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:52:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('461', '崇明科技', 'keji', '0', 2, to_date('11-05-2016 10:49:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:49:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:54:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('462', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 15:52:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 15:52:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 15:57:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('463', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 21:40:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 21:40:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 21:45:49', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('464', '系统管理部', 'cm', '0', 2, to_date('12-05-2016 10:14:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:14:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:19:38', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('467', '系统管理部', 'cm', '0', 2, to_date('12-05-2016 10:53:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:53:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:58:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('469', '系统管理部', 'cm', '0', 2, to_date('16-05-2016 08:40:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-05-2016 08:40:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-05-2016 08:45:19', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('470', '系统管理部', 'admin', '0', 2, to_date('17-05-2016 10:49:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 10:49:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 10:54:47', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('471', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 10:54:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 10:54:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 10:59:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('472', '系统管理部', 'admin', '0', 2, to_date('17-05-2016 10:55:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 10:55:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:00:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
commit;
prompt 100 records committed...
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('473', '崇明公安', 'hu', '0', 2, to_date('17-05-2016 11:04:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:04:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:09:38', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('474', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 11:04:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:04:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:09:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('479', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 17:43:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 17:43:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 17:48:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('486', '系统管理部', 'cm', '0', 2, to_date('19-05-2016 10:43:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:43:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:48:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('487', '系统管理部', 'cm', '0', 2, to_date('19-05-2016 22:02:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 22:02:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 22:07:11', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('488', '系统管理部', 'cm', '0', 2, to_date('22-05-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-05-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-05-2016 20:01:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('491', '系统管理部', 'cm', '0', 2, to_date('25-05-2016 21:08:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 21:08:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 21:13:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('492', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 09:53:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 09:53:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 09:58:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('493', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 11:06:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 11:06:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 11:11:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('495', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 13:53:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 13:53:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 13:58:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('498', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 16:21:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:21:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:26:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('499', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 16:22:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:22:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:27:03', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('503', '北兴村', 'cunming2', '0', 2, to_date('26-05-2016 17:06:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:06:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:11:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('511', '崇明公安', 'hu', '0', 2, to_date('26-05-2016 18:12:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:12:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:17:49', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('512', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 18:13:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:13:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:18:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('513', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 18:15:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:15:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:20:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('518', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 19:09:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:09:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:14:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('519', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 19:14:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:14:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:19:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('523', '崇明水务局', 'shuiwu', '0', 2, to_date('26-05-2016 20:22:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:22:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:27:11', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('524', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 20:25:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:25:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:30:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('526', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 20:27:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:27:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:32:58', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('528', '北兴村', 'cunming2', '0', 2, to_date('26-05-2016 20:36:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:36:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:41:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('531', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 20:46:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:46:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:51:12', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('536', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 21:03:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:03:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:08:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('539', '中兴镇', 'xzzheng', '0', 2, to_date('26-05-2016 21:13:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:13:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:18:53', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('540', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 21:17:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:17:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:22:04', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('543', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 22:30:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:30:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:35:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('544', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 22:35:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:35:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:40:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('545', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 22:36:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:36:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:41:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('547', '中兴镇', 'xzzheng', '0', 2, to_date('26-05-2016 22:52:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:52:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:57:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('551', '系统管理部', 'cm', '0', 2, to_date('27-05-2016 17:04:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 17:04:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 17:09:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('552', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 09:41:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:41:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:46:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('553', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 09:50:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:50:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:55:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('554', '中兴镇', 'xzzheng', '0', 2, to_date('30-05-2016 09:53:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:53:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:58:09', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('555', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 09:55:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 09:55:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:00:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('558', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 10:27:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:27:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:32:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('559', '中兴镇', 'xzzheng', '0', 2, to_date('30-05-2016 10:28:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:28:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 10:33:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('561', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 12:53:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 12:53:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 12:58:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('566', '建设镇', 'jian', '0', 2, to_date('30-05-2016 14:39:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:39:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:44:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('568', '建设镇', 'jian', '0', 2, to_date('30-05-2016 14:46:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:46:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:51:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('264', '系统管理部', 'root', '0', 2, to_date('27-05-2015 13:34:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:34:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:39:17', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('265', '系统管理部', 'root', '2', 2, to_date('27-05-2015 13:34:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:34:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:39:58', 'dd-mm-yyyy hh24:mi:ss'), '1', '张庆生-31011019860327325X', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('266', '系统管理部', 'root', '1', 2, to_date('27-05-2015 13:36:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:36:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:41:55', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海市崇明县太干净洗涤服务部-L4404459-3', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('267', '系统管理部', 'root', '0', 2, to_date('27-05-2015 18:31:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 18:31:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 18:36:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('268', '系统管理部', 'root', '0', 2, to_date('28-07-2015 11:21:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:21:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:26:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('269', '系统管理部', 'root', '2', 2, to_date('28-07-2015 11:24:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:24:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:29:10', 'dd-mm-yyyy hh24:mi:ss'), '1', '黄正球-310230196310175164', '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('271', '系统管理部', 'root', '0', 2, to_date('05-08-2015 16:26:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-08-2015 16:26:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-08-2015 16:31:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('272', '系统管理部', 'root', '1', 2, to_date('05-08-2015 16:27:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-08-2015 16:27:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-08-2015 16:32:44', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海安释信息咨询有限公司', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('273', '系统管理部', 'root', '0', 2, to_date('10-08-2015 13:54:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-08-2015 13:54:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-08-2015 13:59:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('274', '系统管理部', 'root', '1', 2, to_date('10-08-2015 13:55:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-08-2015 13:55:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-08-2015 14:00:21', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海天和制药机械有限公司', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('275', '系统管理部', 'root', '0', 2, to_date('19-08-2015 12:28:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:28:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:33:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('276', '系统管理部', 'root', '0', 2, to_date('19-08-2015 12:38:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:38:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:43:10', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('277', '系统管理部', 'root', '1', 6, to_date('19-08-2015 12:39:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:39:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 12:44:07', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海安步建设工程有限公司-550062620', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('245', '环保局', 'huanbj', '0', 2, to_date('24-04-2015 13:52:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:52:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:57:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('246', '系统管理部', 'admin', '0', 2, to_date('24-04-2015 14:10:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:10:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:15:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('241', '系统管理部', 'admin', '0', 2, to_date('24-04-2015 13:36:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:36:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:41:47', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('242', '系统管理部', 'root', '0', 2, to_date('24-04-2015 13:38:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:38:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:43:45', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('247', '系统管理部', 'admin', '2', 4, to_date('24-04-2015 14:16:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:16:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:21:45', 'dd-mm-yyyy hh24:mi:ss'), '1', '黄诚-310230198112191496', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('248', '系统管理部', 'root', '0', 2, to_date('24-04-2015 14:50:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:50:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 14:55:06', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('249', '系统管理部', 'root', '0', 2, to_date('11-05-2015 16:26:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2015 16:26:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2015 16:31:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('250', '系统管理部', 'root', '0', 2, to_date('15-05-2015 12:36:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 12:36:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 12:41:08', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('251', '系统管理部', 'root', '0', 2, to_date('15-05-2015 13:56:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 13:56:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:01:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('260', '系统管理部', 'admin', '0', 2, to_date('27-05-2015 12:25:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:25:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:30:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('262', '系统管理部', 'admin', '2', 2, to_date('27-05-2015 12:28:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:28:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:33:57', 'dd-mm-yyyy hh24:mi:ss'), '1', '张庆生-31011019860327325X', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('263', '系统管理部', 'admin', '0', 2, to_date('27-05-2015 13:33:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:33:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 13:38:37', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('278', '系统管理部', 'root', '0', 2, to_date('19-08-2015 14:44:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 14:44:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-08-2015 14:49:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('243', '系统管理部', 'admin', '1', 2, to_date('24-04-2015 13:43:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:43:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:48:50', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海三零卫士信息安全有限公司', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('244', '系统管理部', 'admin', '2', 2, to_date('24-04-2015 13:45:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:45:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2015 13:50:18', 'dd-mm-yyyy hh24:mi:ss'), '1', '张庆生-31011019860327325X', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('252', '系统管理部', 'root', '1', 2, to_date('15-05-2015 14:00:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:00:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:05:14', 'dd-mm-yyyy hh24:mi:ss'), '1', '崇明县科学技术委员会-002478999', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('253', '系统管理部', 'root', '1', 2, to_date('15-05-2015 14:00:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:00:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:05:14', 'dd-mm-yyyy hh24:mi:ss'), '1', '崇明县科学技术委员会-002478999', '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('254', '系统管理部', 'root', '0', 2, to_date('15-05-2015 14:01:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:01:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:06:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('255', '系统管理部', 'root', '2', 2, to_date('15-05-2015 14:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:06:54', 'dd-mm-yyyy hh24:mi:ss'), '1', '吴丹-310230197211292124', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('256', '系统管理部', 'root', '2', 2, to_date('15-05-2015 14:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-05-2015 14:06:54', 'dd-mm-yyyy hh24:mi:ss'), '1', '吴丹-310230197211292124', '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('257', '系统管理部', 'root', '0', 2, to_date('19-05-2015 14:08:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2015 14:08:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2015 14:13:04', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('258', '系统管理部', 'root', '1', 6, to_date('19-05-2015 14:25:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2015 14:25:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2015 14:30:20', 'dd-mm-yyyy hh24:mi:ss'), '1', '上海建科企业信用征信有限公司', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('259', '系统管理部', 'admin', '0', 2, to_date('27-05-2015 12:10:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:10:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:15:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('261', '系统管理部', 'admin', '2', 2, to_date('27-05-2015 12:28:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:28:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2015 12:33:56', 'dd-mm-yyyy hh24:mi:ss'), '1', '张庆生-31011019860327325X', '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('270', '系统管理部', 'root', '2', 2, to_date('28-07-2015 11:24:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:24:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-07-2015 11:29:10', 'dd-mm-yyyy hh24:mi:ss'), '1', '黄正球-310230196310175164', '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('282', '系统管理部', 'admin', '0', 2, to_date('09-12-2015 09:40:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 09:40:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 09:45:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('284', '系统管理部', 'admin', '0', 2, to_date('09-12-2015 09:58:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 09:58:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 10:03:24', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('285', '系统管理部', 'admin', '0', 2, to_date('09-12-2015 10:08:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 10:08:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 10:13:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('286', '系统管理部', 'admin', '0', 2, to_date('09-12-2015 10:21:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 10:21:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 10:26:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('281', '系统管理部', 'admin', '0', 2, to_date('08-12-2015 17:00:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 17:00:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 17:05:07', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('283', '系统管理部', 'admin', '0', 2, to_date('09-12-2015 09:46:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 09:46:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-12-2015 09:51:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('279', '系统管理部', 'admin', '0', 2, to_date('08-12-2015 15:08:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 15:08:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 15:13:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('280', '系统管理部', 'admin', '0', 2, to_date('08-12-2015 15:56:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 15:56:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2015 16:01:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('287', '系统管理部', 'admin', '0', 2, to_date('07-04-2016 11:05:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2016 11:05:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2016 11:10:30', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('288', '系统管理部', 'admin', '0', 2, to_date('07-04-2016 11:29:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2016 11:29:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2016 11:34:17', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('289', '系统管理部', 'admin', '0', 2, to_date('23-04-2016 18:55:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-04-2016 18:55:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-04-2016 19:00:10', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('290', '系统管理部', 'admin', '0', 2, to_date('23-04-2016 20:28:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-04-2016 20:28:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-04-2016 20:33:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('291', '系统管理部', 'admin', '0', 2, to_date('24-04-2016 19:05:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2016 19:05:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-04-2016 19:10:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('292', '系统管理部', 'admin', '0', 2, to_date('25-04-2016 07:27:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 07:27:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 07:32:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('293', '系统管理部', 'admin', '0', 2, to_date('25-04-2016 07:50:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 07:50:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 07:55:45', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('294', '系统管理部', 'admin', '0', 2, to_date('25-04-2016 08:21:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 08:21:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 08:26:49', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('295', '系统管理部', 'admin', '0', 2, to_date('25-04-2016 10:34:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 10:34:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-04-2016 10:39:13', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('296', '系统管理部', 'admin', '0', 2, to_date('26-04-2016 19:40:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-04-2016 19:40:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-04-2016 19:45:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('309', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 12:13:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:13:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:18:16', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('311', '城桥村', 'cqcadmin', '0', 2, to_date('29-04-2016 12:19:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:19:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:24:27', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('316', '城桥村', 'cqcadmin', '0', 2, to_date('29-04-2016 12:31:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:31:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:36:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('317', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 13:34:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 13:34:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 13:39:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
commit;
prompt 200 records committed...
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('298', '系统管理部', 'admin', '0', 2, to_date('28-04-2016 15:02:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:02:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:07:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('299', '系统管理部', 'admin2', '0', 2, to_date('28-04-2016 15:18:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:18:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:23:24', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('301', '城桥镇', 'zheng', '0', 2, to_date('28-04-2016 15:24:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:24:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:29:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('304', '系统管理部', 'admin', '0', 2, to_date('29-04-2016 09:08:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 09:08:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 09:13:00', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('305', '系统管理部', 'admin', '0', 2, to_date('29-04-2016 10:42:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 10:42:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 10:47:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('306', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 11:58:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 11:58:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:03:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('307', '城桥镇', 'zheng', '0', 2, to_date('29-04-2016 12:12:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:12:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:17:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('308', '城桥村', 'cqcadmin', '0', 2, to_date('29-04-2016 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:17:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('310', '城桥镇', 'zheng', '0', 2, to_date('29-04-2016 12:18:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:18:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:23:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('312', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 12:19:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:19:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:24:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('313', '卫生院', 'yuan', '0', 2, to_date('29-04-2016 12:26:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:26:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:31:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('314', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 12:30:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:30:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:35:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('315', '城桥镇', 'zheng', '0', 2, to_date('29-04-2016 12:31:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:31:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 12:36:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('297', '系统管理部', 'admin', '0', 2, to_date('28-04-2016 14:07:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 14:07:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 14:12:16', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('300', '系统管理部', 'admin', '0', 2, to_date('28-04-2016 15:23:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:23:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 15:28:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('302', '系统管理部', 'admin', '0', 2, to_date('28-04-2016 16:37:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 16:37:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 16:42:17', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('303', '系统管理部', 'admin2', '0', 2, to_date('28-04-2016 16:42:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 16:42:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-04-2016 16:47:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('318', '城桥镇', 'zheng', '0', 2, to_date('29-04-2016 13:55:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 13:55:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 14:00:30', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('319', '系统管理部', 'admin2', '0', 2, to_date('29-04-2016 13:57:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 13:57:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-04-2016 14:02:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('326', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 13:22:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 13:22:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 13:27:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('327', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 15:32:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 15:32:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 15:37:53', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('330', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 16:36:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:36:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:41:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('331', '系统管理部', 'admin2', '0', 2, to_date('06-05-2016 16:49:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:49:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 16:54:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('334', '卫生院', 'yuan', '0', 2, to_date('06-05-2016 17:31:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:31:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:36:06', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('335', '城桥村', 'cqcadmin', '0', 2, to_date('06-05-2016 17:33:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:33:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:38:17', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('336', '城桥村', 'cqcadmin', '0', 2, to_date('06-05-2016 17:56:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 17:56:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 18:01:37', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('337', '城桥村', 'cqcadmin', '0', 2, to_date('06-05-2016 18:17:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 18:17:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2016 18:22:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('339', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 12:24:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 12:24:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 12:29:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('341', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 13:04:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:04:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:09:08', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('342', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 13:18:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:18:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 13:23:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('345', '系统管理部', 'admin2', '0', 2, to_date('08-05-2016 19:11:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:11:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:16:33', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('346', '系统管理部', 'cm', '0', 2, to_date('08-05-2016 19:51:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:51:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-05-2016 19:56:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('361', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 10:49:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:49:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:54:03', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('362', '崇明公安', 'li', '0', 2, to_date('09-05-2016 10:51:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:51:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:56:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('363', '崇明公安', 'hao', '0', 2, to_date('09-05-2016 10:51:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:51:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:56:27', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('366', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 10:55:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 10:55:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 11:00:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('367', '崇明公安', 'yu', '0', 2, to_date('09-05-2016 11:01:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 11:01:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 11:06:38', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('369', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 12:38:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 12:38:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 12:43:25', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('374', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 14:43:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:43:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:48:24', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('375', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 14:50:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:50:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 14:55:09', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('379', '红星村', 'cunming2', '0', 2, to_date('09-05-2016 15:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:35:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('380', '中兴镇', 'zhongxin', '0', 2, to_date('09-05-2016 15:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:35:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('381', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 15:31:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:31:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:36:18', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('382', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 15:43:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:43:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:48:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('383', '中兴镇', 'zhongxin', '0', 2, to_date('09-05-2016 15:44:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:44:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:49:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('385', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 15:54:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:54:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 15:59:07', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('389', '北兴村', 'cunming2', '0', 2, to_date('09-05-2016 16:22:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:22:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:27:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('390', '系统管理部', 'cm', '0', 2, to_date('09-05-2016 16:23:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:23:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:28:58', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('391', '崇明公安', 'hu', '0', 2, to_date('09-05-2016 16:36:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:36:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2016 16:41:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('398', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 10:33:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:33:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:38:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('399', '崇明科技', 'keji', '0', 2, to_date('10-05-2016 10:36:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:36:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:41:30', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('400', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 10:45:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:45:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:50:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('401', '崇明科技', 'keji', '0', 2, to_date('10-05-2016 10:45:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:45:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 10:50:51', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('407', '卫生局', 'weisheng', '0', 2, to_date('10-05-2016 11:06:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:06:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:11:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('408', '北兴村', 'cunming3', '0', 2, to_date('10-05-2016 11:07:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:07:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:12:34', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('414', '卫生局', 'weisheng', '0', 2, to_date('10-05-2016 12:25:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:25:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:30:09', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('415', '北兴村', 'cunming3', '0', 2, to_date('10-05-2016 12:25:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:25:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:30:24', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('417', '中兴镇', 'zhongxin', '0', 2, to_date('10-05-2016 12:25:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:25:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 12:30:44', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('420', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 13:09:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:09:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:14:06', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('421', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 13:10:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:10:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 13:15:23', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('424', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 14:28:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:28:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:33:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('409', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 11:15:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:15:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:20:02', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('410', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 11:17:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:17:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 11:22:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('429', '爱国村', 'aiguo', '0', 2, to_date('10-05-2016 14:55:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 14:55:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:00:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('431', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 15:24:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:24:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:29:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('432', '北兴村', 'cunming2', '0', 2, to_date('10-05-2016 15:30:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:30:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 15:35:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('435', '系统管理部', 'cm', '0', 2, to_date('10-05-2016 17:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:01:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:06:54', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('436', '崇明公安', 'hu', '0', 2, to_date('10-05-2016 17:04:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:04:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:09:12', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('438', '北兴村', 'cunming3', '0', 2, to_date('10-05-2016 17:07:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:07:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2016 17:12:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('446', '中兴镇', 'zhongxin', '0', 2, to_date('11-05-2016 09:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:05:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('447', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 09:05:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:05:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:10:16', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('448', '北兴村', 'cunming2', '0', 2, to_date('11-05-2016 09:06:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:06:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:11:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('449', '系统管理部', 'cm', '0', 2, to_date('11-05-2016 09:14:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:14:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:19:40', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('455', '北兴村', 'cunming2', '0', 2, to_date('11-05-2016 09:30:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:30:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:35:50', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('456', '崇明公安', 'hu', '0', 2, to_date('11-05-2016 09:40:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:40:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:45:07', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('457', '卫生局', 'weisheng', '0', 2, to_date('11-05-2016 09:43:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:43:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 09:48:08', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('459', '卫生局', 'weisheng', '0', 2, to_date('11-05-2016 10:42:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:42:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-05-2016 10:47:21', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('465', '崇明公安', 'hu', '0', 2, to_date('12-05-2016 10:27:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:27:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:32:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('466', '北兴村', 'cunming2', '0', 2, to_date('12-05-2016 10:30:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:30:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2016 10:35:11', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('468', '系统管理部', 'cm', '0', 2, to_date('13-05-2016 10:21:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-05-2016 10:21:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-05-2016 10:26:26', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('475', '系统管理部', 'admin', '0', 2, to_date('17-05-2016 11:06:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:06:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:11:56', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('476', '系统管理部', 'admin', '0', 2, to_date('17-05-2016 11:15:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:15:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 11:20:28', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('477', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 16:24:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 16:24:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 16:29:11', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('478', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 16:29:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 16:29:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 16:34:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('480', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 20:29:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 20:29:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 20:34:36', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('481', '系统管理部', 'cm', '0', 2, to_date('17-05-2016 21:22:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 21:22:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-05-2016 21:27:01', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('482', '系统管理部', 'cm', '0', 2, to_date('19-05-2016 10:11:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:11:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:16:57', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('483', '县司法局', 'sifa', '0', 2, to_date('19-05-2016 10:14:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:14:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:19:59', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('484', '系统管理部', 'cm', '0', 2, to_date('19-05-2016 10:18:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:18:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:23:09', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('485', '县司法局', 'sifa', '0', 2, to_date('19-05-2016 10:40:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:40:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-05-2016 10:45:00', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('489', '系统管理部', 'cm', '0', 2, to_date('25-05-2016 11:56:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 11:56:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 12:01:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('490', '系统管理部', 'cm', '0', 2, to_date('25-05-2016 20:53:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 20:53:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-05-2016 20:58:52', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('494', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 13:28:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 13:28:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 13:33:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('496', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 15:56:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 15:56:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:01:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('497', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 15:57:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 15:57:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:02:19', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('500', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 16:47:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:47:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:52:58', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('501', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 16:53:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:53:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 16:58:13', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('502', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 17:00:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:00:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:05:12', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('504', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 17:15:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:15:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:20:07', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('505', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 17:15:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:15:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:20:29', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
commit;
prompt 300 records committed...
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('506', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 17:18:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:18:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:23:38', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('507', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 17:25:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:25:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:30:08', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('508', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 17:26:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:26:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 17:31:13', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('509', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 18:06:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:06:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:11:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('510', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 18:07:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:07:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:12:45', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('514', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 18:49:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:49:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:54:14', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('515', '环保局', 'huangbao', '0', 2, to_date('26-05-2016 18:50:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:50:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 18:55:17', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('516', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 19:01:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:01:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:06:10', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('517', '胜利村', 'shenglicun', '0', 2, to_date('26-05-2016 19:01:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:01:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:06:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('520', '北兴村', 'cunming2', '0', 2, to_date('26-05-2016 19:21:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:21:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:26:37', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('521', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 19:22:43', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:22:43', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 19:27:43', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('522', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 20:21:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:21:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:26:55', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('525', '北兴村', 'cunming2', '0', 2, to_date('26-05-2016 20:27:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:27:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:32:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('527', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 20:31:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:31:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:36:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('529', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 20:37:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:37:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:42:26', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('530', '中兴镇', 'xzzheng', '0', 2, to_date('26-05-2016 20:41:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:41:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:46:31', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('532', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 20:56:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:56:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:01:32', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('533', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 20:56:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:56:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:01:44', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('534', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 20:58:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 20:58:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:03:42', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('535', '中兴镇', 'xzzheng', '0', 2, to_date('26-05-2016 21:02:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:02:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:07:44', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('537', '中兴镇', 'zhongxin', '0', 2, to_date('26-05-2016 21:06:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:06:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:11:39', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('538', '北兴村', 'cunming2', '0', 2, to_date('26-05-2016 21:07:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:07:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:12:46', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('541', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 21:21:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:21:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 21:26:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('542', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 22:03:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:03:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:08:16', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('546', '县司法局', 'sifa', '0', 2, to_date('26-05-2016 22:50:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:50:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:55:41', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('548', '系统管理部', 'cm', '0', 2, to_date('26-05-2016 22:54:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:54:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-05-2016 22:59:11', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('549', '系统管理部', 'cm', '0', 2, to_date('27-05-2016 15:18:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 15:18:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 15:23:35', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('550', '中兴镇', 'xzzheng', '0', 2, to_date('27-05-2016 15:24:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 15:24:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-05-2016 15:29:22', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('569', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 14:46:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:46:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:51:48', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('571', '建设镇', 'jian', '0', 2, to_date('30-05-2016 14:53:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:53:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:58:47', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('572', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 14:56:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 14:56:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 15:01:00', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('573', '系统管理部', 'cm', '0', 2, to_date('30-05-2016 15:39:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 15:39:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-05-2016 15:44:05', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('575', '系统管理部', 'cm', '0', 2, to_date('01-06-2016 10:48:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 10:48:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-06-2016 10:53:15', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('580', '系统管理部', 'cm', '0', 2, to_date('04-06-2016 21:47:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('04-06-2016 21:47:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('04-06-2016 21:52:53', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '0');
insert into PERFORM_INFO (PID, P_DAPART, P_USERNAMER, P_UPTYPE, P_POINTALL, P_DATE, P_STARTDATE, P_ENDDATE, P_POINTTYPE, P_CONTSTAT, P_EX_3)
values ('581', '系统管理部', 'cm', '0', 2, to_date('05-06-2016 07:58:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-06-2016 07:58:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-06-2016 08:03:30', 'dd-mm-yyyy hh24:mi:ss'), '1', null, '1');
commit;
prompt 335 records loaded
prompt Loading SYS_APPAUTHORIZE...
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530101843523', '_App_pdcx_20160404', 'jian', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530101913704', '_App_pdcx_20160404', 'xin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530144936669', '_App_pdcx_20160403', 'jian', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508200134233', '_App_pdcx_20160405', 'cqz', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508200135511', '_App_pdcx_20160404', 'cqz', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508200136733', '_App_pdcx_20160403', 'cqz', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508200138006', '_App_pdcx_20160501', 'cqz', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508195610860', '_App_pdcx_20160404', 'ga', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508195746199', '_App_pdcx_2012020', 'zhen1', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510105901898', '_App_pdcx_20160403', 'cunming1', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509103750299', '_App_pdcx_20160404', 'hu', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160511065941323', '_App_pdcx_20160502', 'cm', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160526162150940', '_App_pdcx_20160404', 'zhongxin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509104730958', '_App_pdcx_20160406', 'yu', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509104731359', '_App_pdcx_20160400', 'yu', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509104732759', '_App_pdcx_20160402', 'yu', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509104733619', '_App_pdcx_20160401', 'yu', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509160813497', '_App_pdcx_20160403', 'cunming3', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509154134876', '_App_pdcx_20160403', 'cunming2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160526190348050', '_App_pdcx_20160404', 'shenglicun', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530095048554', '_App_pdcx_20150319', 'cm', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530095051034', '_App_pdcx_2012023', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530095055295', '_App_pdcx_20150326', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160530101727969', '_App_pdcx_20160403', 'xin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153619990', '_App_pdcx_2012019', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153621345', '_App_pdcx_2012020', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319161605912', '_App_pdcx_20150319', 'root', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150403155754859', '_App_pdcx_20150324', 'root', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150403155755383', '_App_pdcx_20150326', 'root', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150411141626281', '_App_pdcx_20150327', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20151209102238764', '_App_pdcx_20150319', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428150456268', '_App_pdcx_20160401', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160429122342331', '_App_pdcx_20160406', 'admin2', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428150501091', '_App_pdcx_20160403', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428150506225', '_App_pdcx_20160402', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151159683', '_App_pdcx_20160405', 'test', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151200363', '_App_pdcx_20160404', 'test', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151200962', '_App_pdcx_20160403', 'test', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151201561', '_App_pdcx_20160402', 'test', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151202408', '_App_pdcx_20160401', 'test', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151203394', '_App_pdcx_20160400', 'test', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151323895', '_App_pdcx_20160400', 'admin2', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151324270', '_App_pdcx_20160401', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151324725', '_App_pdcx_20160402', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151325574', '_App_pdcx_20160404', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151326099', '_App_pdcx_20160405', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151326900', '_App_pdcx_20160403', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151328883', '_App_pdcx_20150324', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151329294', '_App_pdcx_20150327', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151331283', '_App_pdcx_2012018', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151332188', '_App_pdcx_2012020', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151332562', '_App_pdcx_2012019', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151333229', '_App_pdcx_20150319', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151335249', '_App_pdcx_2012100', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151335724', '_App_pdcx_2012023', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151338451', '_App_pdcx_2012012', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151339172', '_App_pdcx_2012006', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151339673', '_App_pdcx_2012005', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151341201', '_App_pdcx_20141209', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151341957', '_App_pdcx_2012102', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151342463', '_App_pdcx_2012026', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135125086', '_App_pdcx_20141209', 'huanbj', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135127086', '_App_pdcx_2012101', 'huanbj', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135129102', '_App_pdcx_2012102', 'huanbj', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135134024', '_App_pdcx_2012012', 'huanbj', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135137602', '_App_pdcx_2012006', 'huanbj', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424135139164', '_App_pdcx_2012005', 'huanbj', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150424144501930', '_App_pdcx_20150327', 'root', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150324093101060', '_App_pdcx_20150324', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150324093101291', '_App_pdcx_20150326', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150311110451414', '_App_pdcx_20141209', 'tongyongban', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150311110456048', '_App_pdcx_2012101', 'tongyongban', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150204133213420', '_App_pdcx_2012102', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150107154528628', '_App_pdcx_20141231', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20141209104711309', '_App_pdcx_20141209', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131226183647570', '_App_pdcx_2012020', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20130531121740931', '_App_pdcx_2012019', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131009102316724', '_App_pdcx_2012026', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131009102326506', '_App_pdcx_2012023', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131009102520138', '_App_pdcx_2012018', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131009102554763', '_App_pdcx_2012012', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20131009102558071', '_App_pdcx_2012005', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150204111002549', '_App_pdcx_2012101', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153517266', '_App_pdcx_20141209', 'root', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153518447', '_App_pdcx_2012026', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153519500', '_App_pdcx_2012101', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153519954', '_App_pdcx_2012102', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153534545', '_App_pdcx_2012102', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153538935', '_App_pdcx_2012012', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153543639', '_App_pdcx_2012100', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153546713', '_App_pdcx_2012005', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153547789', '_App_pdcx_2012006', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153624774', '_App_pdcx_2012006', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20150319153617967', '_App_pdcx_2012018', 'root', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151342985', '_App_pdcx_2012101', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151345385', '_App_pdcx_20150326', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428151349066', '_App_pdcx_20141231', 'admin2', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160429112345007', '_App_pdcx_20160404', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160429112348499', '_App_pdcx_2012100', 'admin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160429112350848', '_App_pdcx_20160405', 'admin', null);
commit;
prompt 100 records committed...
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160429122348224', '_App_pdcx_20160406', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428150456015', '_App_pdcx_20160400', 'admin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152249201', '_App_pdcx_20160403', 'zheng', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152249836', '_App_pdcx_20160404', 'zheng', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152250999', '_App_pdcx_20160405', 'zheng', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152303650', '_App_pdcx_20160404', 'cqcadmin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152304143', '_App_pdcx_20160403', 'cqcadmin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152305706', '_App_pdcx_20160405', 'cqcadmin', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152312451', '_App_pdcx_20160405', 'yuan', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160428152315697', '_App_pdcx_20160404', 'yuan', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508185422156', '_App_pdcx_20160501', 'admin2', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193948162', '_App_pdcx_20160406', 'cm', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193749631', '_App_pdcx_20160403', 'zhen1', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193758152', '_App_pdcx_20160501', 'zhen1', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193819317', '_App_pdcx_20160404', 'zhen1', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193949264', '_App_pdcx_20160400', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193950186', '_App_pdcx_20160401', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193952257', '_App_pdcx_20160403', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193953242', '_App_pdcx_20160402', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193953794', '_App_pdcx_20160404', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193954503', '_App_pdcx_20160405', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508193955651', '_App_pdcx_20160501', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508194000850', '_App_pdcx_2012018', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508194008528', '_App_pdcx_2012019', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508195013729', '_App_pdcx_20160403', 'cun', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160508195015576', '_App_pdcx_20160404', 'cun', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510145554383', '_App_pdcx_20160403', 'aiguo', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509163232088', '_App_pdcx_20160404', 'weisheng', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510110222010', '_App_pdcx_20160403', 'xianghua', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160512103043648', '_App_pdcx_20160404', 'cunming2', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152143457', '_App_pdcx_20141209', 'cm', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160525210923032', '_App_pdcx_20160403', 'shenglicun', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160526204150156', '_App_pdcx_20160404', 'xzzheng', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160526202700590', '_App_pdcx_20160404', 'cunming3', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509154307364', '_App_pdcx_20160403', 'cunming', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509154319495', '_App_pdcx_20160403', 'zhongxin', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510110321241', '_App_pdcx_20160403', 'guangxi', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160526204148838', '_App_pdcx_20160403', 'xzzheng', 0);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152147865', '_App_pdcx_2012102', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152144900', '_App_pdcx_2012101', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509163242246', '_App_pdcx_20160404', 'huangbao', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152150728', '_App_pdcx_2012026', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152153684', '_App_pdcx_2012012', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152201169', '_App_pdcx_2012005', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152203823', '_App_pdcx_2012006', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160509163252553', '_App_pdcx_20160404', 'sifa', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152212416', '_App_pdcx_20150324', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152223472', '_App_pdcx_2012020', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152229098', '_App_pdcx_20150327', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510094404859', '_App_pdcx_20160404', 'keji', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160527152234937', '_App_pdcx_2012100', 'cm', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510094421105', '_App_pdcx_20160404', 'shuiwu', null);
insert into SYS_APPAUTHORIZE (APPAUTH_ID, APPLICATION_ID, AUTHTO_ID, AUTHTOTYPE)
values ('AppA20160510094556634', '_App_pdcx_20160404', 'tiyu', null);
commit;
prompt 153 records loaded
prompt Loading SYS_CERTUSER...
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('155969ACAC106E0A00E6A73D40292937', '6C220049A97A508B', 'qilj', to_date('15-03-2012 15:54:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-03-2012 15:54:03', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AABBA672AC10670F01B06322133E7B38', '6679C9FB59ACF038', 'Wangxy', to_date('12-10-2013 11:35:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-10-2013 11:35:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('86874331AC106E0A00678C5B01DF3A941', '263e600a35109352', 'admin', to_date('11-04-2014 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-04-2014 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E847A30AC10671F0072C299326C2706', '44a067fec08853e1', 'liuw', to_date('16-09-2014 20:51:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:51:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E8520A8AC10671F0072C29985D43FAB', '4a17aecece452f61', 'wanbl', to_date('16-09-2014 20:52:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:52:06', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E8546FAAC10671F0072C29952F515F8', '5bd4d0fdcd063907', 'dongw', to_date('16-09-2014 20:52:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:52:16', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A26FCBC0A823010052881965F85C35', '6e4b7359887865b9', 'jiajt', to_date('21-10-2014 15:36:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:36:09', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('068D404AAC106E0A0036EA729F395DE0', '458AA66A96D23CA7', 'maoh', to_date('18-11-2009 17:08:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-11-2009 17:08:58', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('06906BB5AC106E0A0036EA726C4AE1CB', '19EBA567069E3F2E', 'panyf', to_date('18-11-2009 17:12:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-11-2009 17:12:25', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('6781167AAC106E0A00BB473B8F6D9CDA', '18A24D0E5F4874E3', 'wangw', to_date('16-03-2010 23:04:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-03-2010 23:04:25', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('79B1412FAC106E0A00AF1CF674888334', '7DC8647E877898B9', 'cheny', to_date('12-01-2011 18:06:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2011 18:06:55', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('73435850AC106E0A002724546D58E41D', '297D9450BE5A18F2', 'jixy', to_date('20-04-2011 22:14:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-04-2011 22:14:44', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7346AFBEAC106E0A002724542B29BF78', '6C66037AF2EA49FB', 'chenj', to_date('20-04-2011 22:18:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-04-2011 22:18:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('734E06C9AC106E0A002724542DB59D92', '55A55CC0A316CEA0', 'songz', to_date('20-04-2011 22:26:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-04-2011 22:26:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('8683C61CAC106E0A00678C5BD5C04A8F', '46B36DE1B7F31D0D', 'qiuph', to_date('09-11-2011 12:09:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:09:02', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('8B6C2F8CAC106E0A009849067563C89F', '7ADBD646E533B60A', 'yaoy', to_date('10-11-2011 11:01:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-11-2011 11:01:22', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('9CC95E5EAC10670F01703457920230D1', '34F83467CB27F0A2', 'Yangxy', to_date('13-05-2013 15:27:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-05-2013 15:27:22', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7DFE36C4AC10671D010BBCDAD9989FCE', '5bbd036237e7b4e0', 'wangc', to_date('16-09-2014 18:25:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 18:24:59', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E850821AC10671F0072C2994D58C270', '66c817b49c6d5616', 'jiay', to_date('16-09-2014 20:52:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:52:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A17AC0C0A82301005288195440F700', '203c4cd42188da85', 'yangh', to_date('21-10-2014 15:35:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:35:06', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A1AC2BC0A823010052881986DBCAB5', '1b21222bcceb0e80', 'youby', to_date('21-10-2014 15:35:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:35:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('B3A86FE8AC106E0A0087AEEF7EAA1B57', '3EE818074368B8D8', 'feilm', to_date('31-03-2010 17:58:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2010 17:58:32', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('B4B468F0AC106E0A0087AEEF8DE4F8EE', '678F1369FDA2A41C', 'wanghq', to_date('31-03-2010 22:51:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2010 22:51:14', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('3AABFD1DAC106E0A00718C9CB88C74C5', '57030543D1B69147', 'zhouyin', to_date('05-05-2010 18:04:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-04-2010 23:11:09', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('3B2A1632AC106E0A00718C9C3BD8C803', '150362577336C0F5', 'peiyun', to_date('05-05-2010 18:05:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-04-2010 01:28:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('79AD80ADAC106E0A00AF1CF63900E20C', '566E2C9F9B3ABD73', 'yanhy', to_date('12-01-2011 18:02:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2011 18:02:49', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('DA40E9F3AC106E0A002724544F826DEC', '4C8D52094A331F61', 'baojg', to_date('10-05-2011 22:12:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-05-2011 22:12:57', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('5DE86D49AC106E0A00678C5B74E31894', '5B00176D953150D0', 'wangw1', to_date('01-11-2011 14:54:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-11-2011 14:54:33', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('68454732AC10670F00956344E97C716B', '7061320652F9F1E3', 'test1', to_date('25-02-2014 16:59:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-02-2014 16:59:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E84B5ADAC10671F0072C299CECD3E90', '1e9d46c299bff405', 'qiumy', to_date('16-09-2014 20:51:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:51:39', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E84D451AC10671F0072C2998138CB23', '1d182f2910278273', 'guoyh', to_date('16-09-2014 20:51:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:51:47', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('319EDB62C0A8230100528819AF80BAAA', '30d776493e89a92f', 'zhoumt', to_date('21-10-2014 15:32:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:32:15', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A03CFFC0A8230100528819F66A8383', '1b33a886718a3487', 'xuj', to_date('21-10-2014 15:33:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:33:45', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A086A1C0A82301005288192C175620', '342986d027cc84c0', 'lib', to_date('21-10-2014 15:34:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:34:04', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A0D2B3C0A82301005288192748FC10', '59622a8020bf1d83', 'fanhb', to_date('21-10-2014 15:34:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:34:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A10C83C0A8230100528819868E7E4D', '3ab3c6637beb6d0a', 'liaol', to_date('21-10-2014 15:34:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:34:38', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A1470BC0A8230100528819630DAC29', '1c2843fb9b3cb745', 'zhouw', to_date('21-10-2014 15:34:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:34:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A2E2F3C0A82301005288196537C648', '480caf0841ba6f35', 'feixj', to_date('21-10-2014 15:36:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:36:38', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A31C0FC0A8230100528819B68C2451', '12d42175ae24bea9', 'guosp', to_date('21-10-2014 15:36:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:36:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0693AA77AC106E0A0036EA723F72E948', '664B7F4EC8DB9E73', 'xuxj', to_date('18-11-2009 17:15:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-11-2009 17:15:58', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('B3A94C96AC106E0A0087AEEF8B62E13E', '557DF683ADC43607', 'guozl', to_date('31-03-2010 17:59:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2010 17:59:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('79FC4439AC106E0A00AF1CF6D291529E', '40C32E1F9EB43C1E', 'cail', to_date('12-01-2011 19:28:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2011 19:28:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A31AF4FFAC106E0A00AF1CF6F6CA9475', '2F34FF80732199AB', 'yuws', to_date('20-01-2011 19:06:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-01-2011 19:06:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('C5CCDCA4AC106E0A00272454464A4EF3', '3D89BECE5F756380', 'tangz', to_date('06-05-2011 22:53:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-05-2011 22:53:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('D480CF5FAC106E0A0027245412D41C66', '1F1B6A8548EBEB68', 'shizq', to_date('09-05-2011 19:25:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-05-2011 19:25:02', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('86874331AC106E0A00678C5B01DF3A94', '7CD3502E8DB3D9F6', 'chenqq', to_date('09-11-2011 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:12:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7C37273DC0A801680013879E23CF8DF0', 'rewrerew', 'user1', to_date('05-11-2014 03:20:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-11-2014 03:10:29', 'dd-mm-yyyy hh24:mi:ss'), 'user1', null, null, '323', '444', '65', '75');
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('ABF35B04AC10670F0174D49CF57C14D1', '78df83490f72e914', '420106196404214873', to_date('14-11-2014 09:38:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 09:38:12', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '卓信宁', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('291DE041AC10670F004D396A4E27BD35', '31f0995a84d488a8', '330104197003093011', to_date('06-01-2015 11:27:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2014 16:57:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '杭州市农村商业银行股份有限公司', '卫强', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('ACBD189DAC10670F0174D49C5575BA10', '242302972b08a419', '330482198211092128', to_date('14-11-2014 13:18:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 13:18:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '交通警察局', '冯蕾', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC1CDC09AC10670F0174D49C900CDF0C', '45d4f4099bf37d52', '330719197606180015', to_date('14-11-2014 10:23:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:23:32', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '金炫', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC1F03B4AC10670F0174D49CBB97E256', '134cd5bb5274f1af', '320500196806289819', to_date('14-11-2014 10:25:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:25:54', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '朱剑明', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC21243EAC10670F0174D49CA8083622', '5CAE446D3077DAE1', '340802198311240046', to_date('14-11-2014 16:33:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:28:13', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '秦洁', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC251E35AC10670F0174D49C82630555', '702EE8B6FC730EB5', '142424197811277415', to_date('14-11-2014 16:35:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:32:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '杨保福', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC2D23DDAC10670F0174D49C32296F93', '7a464b98b01725f2', 'liuhg', to_date('14-11-2014 10:41:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:41:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '安监局', '刘辉光', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC911253AC10670F0174D49CD5EFD7F2', '25f91e52b8056ec9', '330184198207284115', to_date('14-11-2014 12:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 12:30:28', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '民政局', '叶颖', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('ACD08EA1AC10670F0174D49C10E03598', '147ff7d2d4824584', '330102196205160633', to_date('14-11-2014 13:39:49', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 13:39:49', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '交通警察局', '郑小伟', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('CC625BC5AC10670F0174D49C9C6C3289', '263340fe612c70e6bf48efba', '330122197711231510', to_date('20-11-2014 16:53:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-11-2014 16:47:18', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '桐庐发改局', '余勇刚', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('03D8AB08AC10670F00AD9BF44C0E1C8C', '30BD5F8A3FFD920DA41CFEF4', '330127198110270043', to_date('01-12-2014 11:15:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2014 11:15:38', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '杭州市公安消防局', '卢君', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A88EFFC8AC10670F0174D49CA28015C0', '6e48cd09f7dc22f5', '330104196403201611', to_date('13-11-2014 17:49:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-11-2014 17:49:44', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '农业局', '陈品南', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A897A5C5AC10670F0174D49CB2FE9062', '5deca46fc054df77', '330107198202114413', to_date('13-11-2014 17:59:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-11-2014 17:59:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '农业局', '应军良', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC0FE9C3AC10670F0174D49CE133D3C5', '1fbad2229625a023', '330103195610010032', to_date('14-11-2014 10:09:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:09:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '马立达', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC16AEF3AC10670F0174D49C0B833DE3', '2dd033f93b5b8a36', '330206197304303121', to_date('14-11-2014 10:16:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:16:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '金迪飞', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('AC19B172AC10670F0174D49CCBAAF60E', '6406e3e10fa948d9', '330184198309164325', to_date('14-11-2014 10:20:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 10:20:05', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '市旅委', '薄文敢', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('ACC1E27FAC10670F0174D49C731FBD26', '5b07e977940bf0d2', '330121196901020027', to_date('14-11-2014 13:28:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 13:23:47', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '交通警察局', '金澄宇', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('ACCCD783AC10670F0174D49CEFB3056C', '53c93a5bcbe9fc6f', '330102197410150615', to_date('14-11-2014 13:35:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-11-2014 13:35:46', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '交通警察局', '骆海峰', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('03DB6698AC10670F00AD9BF45486104B', '48F01C3891D4EBF7C15814EA', '330382198405280025', to_date('01-12-2014 11:18:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2014 11:18:38', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '杭州市公安消防局', '章文瑜', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('711AF280AC10670F01D7D6F44CFEF433', '067ebe34f455384847d44310', '330106198407190421', to_date('22-12-2014 16:26:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2014 16:26:39', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20081217174004453', '周媛媛521219', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('94EDBD13AC10670F0179D4FB29B82426', '7d35c2b9770c31bb', '330722197911190015', to_date('29-12-2014 15:23:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-12-2014 15:23:36', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20081217174004453', '翁文礼', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB77A33FAC10670F008D5F584097A5A9', '296f767dd63be702', '362334197806160038', to_date('15-01-2015 11:06:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:41:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20110105104020387', '94DA0902-DCE5-474C-844E-1962A2FD3493', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB85BBBAAC10670F008D5F5806EEB5B7', '709dcea4775c3b10', '33010319751220131X', to_date('15-01-2015 10:56:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:56:57', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20110105104020387', '吴洽灏', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0A824979AC10678D003069CB3F8E713B', '263e603434343', 'yunwei', to_date('21-01-2015 11:21:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-01-2015 11:21:25', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20070529174221891', '运维人员', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('4E50D6B6AC10670F008CDA4BF6A73417', '1fda11fbfc15357a', '330106196411071119', to_date('03-02-2015 15:21:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2015 15:21:35', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20090930175130427', '张德辉', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('DD98277FAC10670F01186FFF933ACE8D', '654654687478', 'albb', to_date('03-03-2015 11:05:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-03-2015 11:05:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20150303105517027', '接口服务', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('56913BB1AC10670F01D7D6F430F3ADF6', '632b5f6f83a4ee30f6950bfa', '330724197801114532', to_date('17-12-2014 12:46:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-12-2014 12:46:06', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20141114125842455', '程洪孝394372', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB80A520AC10670F008D5F58E2DE011A', '4b6b9b1c03947d1b', '33010319680218041X', to_date('15-01-2015 10:51:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:51:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '徐正荣', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0A80A2FCAC10678D003069CB889E70ED', '223232323232', '172181285', to_date('21-01-2015 11:19:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-01-2015 11:19:37', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20070529174221891', 'yunwei', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB81772DAC10670F008D5F588491950A', '6ff2a43c97b503e9', '330102196111100613', to_date('15-01-2015 10:52:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:52:18', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '祝平', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0BDB89DFAC10678D003069CB9BE835FB', '343242342342', 'smkuser', to_date('21-01-2015 17:38:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-01-2015 17:38:32', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20140915191738765', '市民卡测试', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB820049AC10670F008D5F5894C2C74F', '55cf595b88be7371', '330103196902081646', to_date('15-01-2015 10:52:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:52:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '虞宏', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB827B23AC10670F008D5F58A02F3F2F', '72fe0d4797256b85', '330106196605251513', to_date('15-01-2015 10:53:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:53:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '方德新', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB82EC1DAC10670F008D5F5889866123', '1396faee5cebdd64', '330125196406092918', to_date('15-01-2015 10:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:53:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '陈祥荣', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('EB835126AC10670F008D5F58F63401FE', '4933a42d12eefcaa', '340322197208080025', to_date('15-01-2015 10:54:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2015 10:54:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20061009231216893', '杨莉', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('DD90931EAC10670F01186FFFC69E8AE1', '32684uygkjh656', '386541287954125865', to_date('03-03-2015 10:56:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-03-2015 10:56:54', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 'OuLi20150303105517027', 'albb', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('2922D6AEAC10670F004D396ACC07A71D', '687E1D1397F5ADF1EA7A9B84', '330903198503050925', to_date('08-12-2014 17:02:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-12-2014 17:02:36', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, '杭州银行', '俞晓', null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('82894433AC10670C00EA2352CFE54BC5', '2142B17C73FD5CE6', 'yeyp', to_date('16-07-2009 15:49:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-07-2009 15:49:09', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('3486E116AC10670C00594D1DB8E36A75', '2EB2A8CDE11BAA1A', 'shifeng', to_date('12-05-2009 19:13:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-05-2009 19:13:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('16070797AC10670C00430AF2FFB39932', '5AC6E64039773607', 'shihx', to_date('25-06-2009 14:07:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-06-2009 14:07:55', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('2FDFC8AFAC10670C019C85512B1073E2', '74B88340FF4F2CF5', 'zhul', to_date('30-06-2009 14:35:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-06-2009 14:35:10', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('12BC22C1AC10670C00CD0C52D4B38995', '50B10F8E210AEFAF', 'hej', to_date('24-06-2009 22:47:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-06-2009 22:47:15', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('3A4A26F6AC10670C00BCE3D7CC120AD4', '3DC12E3450CA2B86', 'tongzg', to_date('02-07-2009 15:07:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-07-2009 15:07:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('59627D73AC10670C01CECE516BD523AA', '3876726A9460B4DB', 'chenjz', to_date('08-07-2009 16:02:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-07-2009 16:02:22', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('596C04E4AC10670C01CECE51FFE52493', '31DE8058BDA10485', 'luyb', to_date('08-07-2009 16:12:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-07-2009 16:12:47', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('B9EDE504AC106E0A0134D80194DCE03F', '21757C50C2B567C5', 'yecg', to_date('27-07-2009 09:58:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-07-2009 09:58:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0A62D0AF7F00000200A85972F721451D', '1FDA11FBFC15357A', 'zhangdh', to_date('30-09-2009 17:58:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2009 17:58:18', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('119DC1FFAC10670C0135D392867BC9A9', '67824C6CA475F49A', 'admin', to_date('25-02-2014 17:22:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('24-06-2009 17:34:27', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('397DA374AC10670C0046192C2DEBECD2', '4F3419CB2FD22C61', 'zhengyh', to_date('02-07-2009 11:24:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-07-2009 11:24:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('596A648CAC10670C01CECE51F9B29E1E', '72ABA40E34ACC68E', 'hulj', to_date('08-07-2009 16:11:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-07-2009 16:11:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A0256647AC10670C01135D340BC4B770', '600719DF0A9A10AE', 'zhangdx', to_date('22-07-2009 09:48:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-07-2009 09:48:41', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('0AA2EC877F00000200A859729123F7B1', '5542C906F2501DA4', 'LIL', to_date('30-09-2009 19:08:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2009 19:08:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
commit;
prompt 100 records committed...
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('396CF048AC10670C0046192C0B65CA92', '562C62CB56CEF591', 'wangxd', to_date('02-07-2009 11:05:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-07-2009 11:05:56', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('9B318F67AC10670C00007142B15DEC54', '6C2B9DC328DF06FF', 'test', to_date('21-07-2009 10:43:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-07-2009 10:43:52', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('8D90EC6EAC106E0A001DDC897307A486', '4F91658BCD8F1A06', 'ycl', to_date('14-12-2009 22:21:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-12-2009 22:21:42', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('2663BE94AC106E0A009999F133B24329', '24F11CB471416746', 'huangb', to_date('13-01-2010 14:34:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-01-2010 14:34:16', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('2315FA79AC106E0A0030FB71FB56B274', '759679F064D113CA', 'wangsh', to_date('03-03-2010 16:13:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-03-2010 16:13:15', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A315806BAC106E0A00AF1CF6F8CE626A', '3C6C9E28D2B092B4', 'chuyb', to_date('20-01-2011 19:00:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-01-2011 19:00:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('5DE9CDD1AC106E0A00678C5BA1A215D1', '1F67D235551A2BD0', 'baoxy', to_date('01-11-2011 14:56:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-11-2011 14:56:03', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('5DEAC9C7AC106E0A00678C5BEDC08700', '6E12B4DFEA767855', 'zhouy1', to_date('01-11-2011 14:57:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-11-2011 14:57:08', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('868598F9AC106E0A00678C5BCA504AC0', '2D1F2B782815E9E2', 'qiany', to_date('09-11-2011 12:11:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:11:02', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E841892AC10671F0072C29976BA0035', '1d6c2f8d493c5069', 'dongyl', to_date('16-09-2014 20:50:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:50:59', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('7E84EFC4AC10671F0072C299745D6500', '769f6cb86b485b6e', 'chenyc', to_date('16-09-2014 20:51:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-09-2014 20:51:54', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('31A1E3A9C0A823010052881992192235', '443b245023250c62', 'dingld', to_date('21-10-2014 15:35:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-10-2014 15:35:33', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('06F0CDD9AC106E0A01B0B7B8F6CA46BE', '13F2692C4DFF226F', 'wangsh', to_date('09-03-2010 10:31:41', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-11-2009 18:57:42', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('30186B54AC106E0A00DB89C20BA893CA', '13f2692c4dff226f', 'admin2', to_date('27-11-2009 17:44:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-11-2009 18:45:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('265F2688AC106E0A009999F1E5329588', '529733A55CB6C812', 'weiyg', to_date('13-01-2010 14:29:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-01-2010 14:29:15', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('B3A79501AC106E0A0087AEEFE692FCDA', '2F07A1570F5F14FD', 'zhangxf', to_date('31-03-2010 17:57:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2010 17:57:36', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('3B29223CAC106E0A00718C9C7617DF2A', '37013F339AEDF480', 'xufen', to_date('05-05-2010 18:03:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-04-2010 01:27:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('79AA70A5AC106E0A00AF1CF6D21284DC', '707A92CD359DDE2E', 'huangh', to_date('12-01-2011 17:59:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2011 17:59:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('79AEEC97AC106E0A00AF1CF6C63C265A', '115DADD357AA6E1A', 'dongtl', to_date('12-01-2011 18:04:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2011 18:04:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A3132B03AC106E0A00AF1CF6C2FB9358', '192D59BDF2F32F25', 'shiz', to_date('20-01-2011 18:58:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-01-2011 18:58:18', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A3175C0CAC106E0A00AF1CF60DF0BEE5', '5C7FE8245DCCAE20', 'wangjh', to_date('20-01-2011 19:02:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-01-2011 19:02:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('A31828D0AC106E0A00AF1CF6775B20C8', '5F5C84E71853696D', 'liuzj', to_date('20-01-2011 19:03:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-01-2011 19:03:45', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('867BBEE5AC106E0A00678C5B82446B32', '28DDEDC163D67478', 'wuwm', to_date('09-11-2011 12:00:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:00:16', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('8680504CAC106E0A00678C5B1BA3816D', '235689CBDFBC5E72', 'zhongz', to_date('09-11-2011 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('86819755AC106E0A00678C5B7466E5C3', '7BB867BDA1320E7C', 'zhujm', to_date('09-11-2011 12:06:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:06:39', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
insert into SYS_CERTUSER (ID, CERTSN, USERID, UPDATETIME, REGISTERTIME, POP1, POP2, POP3, DWMC, NAME, LXDH, CSZW)
values ('8688A9D9AC106E0A00678C5BA6613D88', '4311B2D690148E20', 'huangcn', to_date('09-11-2011 12:14:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-11-2011 12:14:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null);
commit;
prompt 126 records loaded
prompt Loading SYS_DOMAIN...
prompt Table is empty
prompt Loading SYS_DOMAINAPPLICATION...
prompt Table is empty
prompt Loading SYS_FLDJ...
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031309024502405904', '2015031115455093967', 'B', '0.2', '0.2', '1', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031309024504974599', '2015031115455093967', 'C', '0', '0', '2', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070980395809', '2015031616063538422', 'A', '0.4', '0.4', '0', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070909391792', '2015031616063538422', 'B', '0.3', '0.3', '1', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031309024552442756', '2015031115455093967', 'A', '0.4', '0.4', '0', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070999780269', '2015031616063538422', 'C', '0.2', '0.2', '2', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070963347227', '2015031616063538422', 'D', '0.1', '0.1', '3', null, null, null, null, null);
insert into SYS_FLDJ (FLDJID, MXID, DJBZ, TOPZ, ENDZ, XH, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070951953745', '2015031616063538422', 'E', '0', '0', '4', null, null, null, null, null);
commit;
prompt 8 records loaded
prompt Loading SYS_GROUP...
insert into SYS_GROUP (GROUP_ID, GROUPNAME, GROUPDESC, GROUPLEVEL, GROUPUSETYPE, PARENTGROUP_ID, GROUPSTATUS, OUID, CREATEBY, CREATEDATE)
values ('GROU20061109095029140', '管理组', null, 0, 1, 'GROU20061109095029140', 1, 'OuLi20050823145928841', 'admin', to_date('09-11-2006 09:50:29', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 1 records loaded
prompt Loading SYS_GROUPMEMBER...
insert into SYS_GROUPMEMBER (GROUPMEMBER_ID, GROUP_ID, MEMBER_ID, MEMBERTYPE)
values ('Grou20061109095029234', 'GROU20061109095029140', 'OuLi20050823145928841', 1);
insert into SYS_GROUPMEMBER (GROUPMEMBER_ID, GROUP_ID, MEMBER_ID, MEMBERTYPE)
values ('Grou20061109095029265', 'GROU20061109095029140', 'OuLi20061010093704622', 1);
insert into SYS_GROUPMEMBER (GROUPMEMBER_ID, GROUP_ID, MEMBER_ID, MEMBERTYPE)
values ('公共用户', 'GROU20050906153546074', '公共用户', 0);
commit;
prompt 3 records loaded
prompt Loading SYS_MXJS...
insert into SYS_MXJS (MXJSID, MXZBID, DEPID, TABLEID, FIEDID, VALZHI, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031711544369953239', '2015031711543457231', 'OuLi20141118153001499', '2015021114374483515', null, null, '2015-03-17 11:54:43', '2015031711544319688252', '00', null, null, null);
insert into SYS_MXJS (MXJSID, MXZBID, DEPID, TABLEID, FIEDID, VALZHI, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031309024565300519', '2015031115455093967', 'OuLi20141118153001499', '2015020310415176625', null, null, '2015-03-13 09:02:45', '2015031309024534526928', '00', null, null, null);
insert into SYS_MXJS (MXJSID, MXZBID, DEPID, TABLEID, FIEDID, VALZHI, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5)
values ('2015031616070798086347', '2015031616063538422', 'OuLi20141118153001499', '2015020310415176625', null, null, '2015-03-16 16:07:07', '2015031616070741588394', '00', null, null, null);
commit;
prompt 3 records loaded
prompt Loading SYS_MXZB...
insert into SYS_MXZB (MXZBID, MXNAME, ZFFDX, SHUOM, DJ, ZHZXSJ, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5, PARAMT6, PARAMT7)
values ('2015031711543457231', '通用模型计算', null, '通用模型计算', null, null, '2015-03-17 11:54:34', '1', 'OuLi20070529174221891', null, null, null, null, null);
insert into SYS_MXZB (MXZBID, MXNAME, ZFFDX, SHUOM, DJ, ZHZXSJ, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5, PARAMT6, PARAMT7)
values ('2015031115455093967', '模型名称1', null, '模型名称模型名称模型名称', null, null, '2015-03-11 15:45:50', '1', 'OuLi20070529174221891', null, null, null, null, null);
insert into SYS_MXZB (MXZBID, MXNAME, ZFFDX, SHUOM, DJ, ZHZXSJ, TJSJ, PARAMT1, PARAMT2, PARAMT3, PARAMT4, PARAMT5, PARAMT6, PARAMT7)
values ('2015031616063538422', '模型评级', null, '模型评级', null, null, '2015-03-16 16:06:35', '1', 'OuLi20070529174221891', null, null, null, null, null);
commit;
prompt 3 records loaded
prompt Loading SYS_MXZB_ZBQZ...
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543476714537', '2015031111524764084', '2015031711543457231', '1', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543574596390', '2015031111551700245', '2015031711543457231', '2', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543558026126', '2015031111565505160', '2015031711543457231', '3', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543508272790', '2015031111593716915', '2015031711543457231', '4', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543515586648', '2015031112013421735', '2015031711543457231', '5', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543520580593', '2015031711184581869', '2015031711543457231', '6', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543523842330', '2015031711321106017', '2015031711543457231', '7', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543528548927', '2015031711493125620', '2015031711543457231', '8', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543500755285', '2015031711533549449', '2015031711543457231', '9', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711543426419734', '2015031111482943135', '2015031711543457231', '0', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031710590631369524', '2015031111551700245', '2015031115455093967', '2', null, null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031710590600368715', '2015031111482943135', '2015031115455093967', '0', null, null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031710590602593274', '2015031111524764084', '2015031115455093967', '1', '0.2', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191297155866', '2015031111565505160', '2015031616063538422', '3', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191208364502', '2015031111593716915', '2015031616063538422', '4', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191212349788', '2015031112013421735', '2015031616063538422', '5', '0.5', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191297719731', '2015031111482943135', '2015031616063538422', '0', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191202321389', '2015031111524764084', '2015031616063538422', '1', '0.1', null, null);
insert into SYS_MXZB_ZBQZ (ZBQZID, INDEXID, MXZBID, XH, PARAMT1, PARAMT2, PARAMT3)
values ('2015031711191256360085', '2015031111551700245', '2015031616063538422', '2', '0.1', null, null);
commit;
prompt 19 records loaded
prompt Loading SYS_ORGLIST...
insert into SYS_ORGLIST (ORGID, ORGNAME, STATUS, TEL, FAX, ADDRESS, WEB, MAIL, DES, DISPLAYORDER, CREATEDATE)
values ('OrgL20160525205916510', '中兴镇', 1, null, null, null, null, null, '中兴镇', 21, null);
insert into SYS_ORGLIST (ORGID, ORGNAME, STATUS, TEL, FAX, ADDRESS, WEB, MAIL, DES, DISPLAYORDER, CREATEDATE)
values ('1', '崇明县', 1, null, null, null, null, null, '崇明县', 1, null);
insert into SYS_ORGLIST (ORGID, ORGNAME, STATUS, TEL, FAX, ADDRESS, WEB, MAIL, DES, DISPLAYORDER, CREATEDATE)
values ('OrgL20160509094607551', '诚信NO1', 1, null, null, null, null, null, null, 4, null);
commit;
prompt 3 records loaded
prompt Loading SYS_ORGTABLE...
insert into SYS_ORGTABLE (DEPTARTMENT_ID, SQL_ID, ORDER_ID)
values ('OuLi20150209151954016', '2015020915202395938', 'OuLi20150209151954016');
commit;
prompt 1 records loaded
prompt Loading SYS_OULIST...
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160530101520318', '建设镇', 'OrgL20160509094607551', 'OuLi20160530101520318', 1, '建设镇', '建设镇', 2, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160530144733976', '建设村', 'OrgL20160509094607551', 'OuLi20160530144733976', 1, '建设村', null, 3, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160525210533038', '胜利村', 'OrgL20160525205916510', 'OuLi20160525210533038', 1, '胜利村', '胜利村', 1, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160526204107395', '中兴镇', 'OrgL20160525205916510', 'OuLi20160526204107395', 1, '中兴镇', '中兴镇', 2, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20070529174221891', '系统管理部', '1', null, 1, '系统管理部', 'xtglb', 1, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20151208155004601', '麦信测试', '1', 'OuLi20151208155004601', 1, '麦信测试', 'mxcs', 2, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160425082236714', 'test', '1', 'OuLi20160425082236714', 1, 'test', 'test', 3, null);
insert into SYS_OULIST (OUID, OUNAME, ORGID, PARENTOUID, STATUS, OUCHARGER, SYSCHARGER, DISPLAYORDER, CREATEDATE)
values ('OuLi20160509095934100', '县司法局', 'OrgL20160509094607551', 'OuLi20160509095934100', 1, '县司法局', '县司法局', 6, null);
commit;
prompt 8 records loaded
prompt Loading SYS_USER...
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('jian', 'jian', 'OrgL20160509094607551', 'OuLi20160530101520318', null, null, 1, 'E88C7EFD1DE2FF8E1D210F00F52A15AC', 0, null, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('cunming3', 'cunming3', 'OrgL20160509094607551', 'OuLi20160509152916080', null, null, 1, 'A4B2D1C9EFCBA0C0C7F6E99CF19A4FEE', 0, 2, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('hu', 'hu', 'OrgL20160509094607551', 'OuLi20160509095725817', null, null, 1, 'F41FC31F50F08998DC69CA3AB872A71F', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('zhongxin', 'zhongxin', 'OrgL20160509094607551', 'OuLi20160509151616667', null, null, 1, 'A757D41CDB024852ED27B8EA25EFA28F', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('cunming2', 'cunming2', 'OrgL20160509094607551', 'OuLi20160509152916080', null, null, 1, '12DEB224342FC77BBD4D9FDE528344A1', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('tiyu', 'tiyu', 'OrgL20160509094607551', 'OuLi20160509163434743', null, null, 1, 'FCB90953F87F2A7E2B7298ABBA6A61AB', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('shenglicun', '胜利村', 'OrgL20160525205916510', 'OuLi20160525210533038', null, null, 1, '8EF6E5C44CEDC8CB9B2533AA8332315A', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('cun', 'cun', 'OrgL20160509094607551', 'OuLi20160530144733976', null, null, 1, '6B68B5AAD1A133352E17B4ADD847A8E9', 0, 4, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('cm', 'cm', '1', 'OuLi20070529174221891', null, null, 1, '0BFB8215888E1DFF55D2DDE91D8E7E60', 0, 11, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('huangbao', 'huangbao', 'OrgL20160509094607551', 'OuLi20160509162953713', null, null, 1, 'C51C41088E5487099ACA4E6E8DFA81CA', 0, 3, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('admin', '系统管理部', '1', 'OuLi20070529174221891', null, null, 1, 'C2A3C00B630CD5DAE3C5D1E88A68D868', null, 1, null, '5');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('test', '测试人员', '1', 'OuLi20151208155004601', null, null, 1, '48128276101637F970F4D46A45A63A73', null, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('test2', 'test', '1', 'OuLi20160425082236714', null, null, 1, '37EB75E9E8C86BCEA56060A48F3116BF', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('weisheng', 'weisheng', 'OrgL20160509094607551', 'OuLi20160509162928538', null, null, 1, '6B90BC1001D862BAF2A58C1BC9F2944B', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('xzzheng', 'xzzheng', 'OrgL20160525205916510', 'OuLi20160526204107395', null, null, 1, '38177E69952CBAD73E7BAD127F61BFEB', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('sifa', 'sifa', 'OrgL20160509094607551', 'OuLi20160509095934100', null, null, 1, '1AC92D5B62DADF653166DEA1D81195DC', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('keji', 'keji', 'OrgL20160509094607551', 'OuLi20160510090732708', null, null, 1, '265693C6E55682755CAB12A41E2369F4', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('shuiwu', 'shuiwu', 'OrgL20160509094607551', 'OuLi20160510091000547', null, null, 1, '4154FFCE63C8A8829E17538B23CA657A', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('xianghua', 'xianghua', 'OrgL20160509094607551', 'OuLi20160509095843689', null, null, 1, '2BD32AEE0DF96F0CC30DBCBBA29CC6CD', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('guangxi', 'guangxi', 'OrgL20160509094607551', 'OuLi20160509095907350', null, null, 1, '47205048FEFE452F0B307A31802F3B0B', 0, 1, null, '1');
insert into SYS_USER (CN, SN, O, OU, EMAIL, PUBLICKEY, USER_STATUS, PWD, CREATEPOSITION, DISPLAYORDER, CREATEDATE, USERJB)
values ('aiguo', 'aiguo', 'OrgL20160509094607551', 'OuLi20160509152128166', null, null, 1, '5577A79869FA7AFD5BCD26F1F7E0E909', 0, null, null, '1');
commit;
prompt 21 records loaded
prompt Loading SYS_YPFJZBVAL...
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031019565213641', '2015020511161105102', 'time_3', null, null, '2015020615053835502', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031019583385021', '2015021217280644896', 'time_3', null, null, '2015021216462387102', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031019573796544', '2015020510132363934', 'time_3', null, null, '2015020613125468656', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031019581026587', '2015020417231471206', 'string', 'jq', '条', '2015021017285338156', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031616013284924', '2015021215494021701', 'number', '100000', null, '2015031615582235753274', '1', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031616013202317', '2015020315495132631', 'time_3', null, null, '2015031615582214439960', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342112137', null, 'time_>=', '1', null, '2015021115342179787', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342193205', null, null, null, null, '2015021115342155875', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342155830', '2015020315495132631', 'time_3', null, null, '2015021115342114792', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342186058', '2015020316052665633', 'code', 'hbdj', '''红色'',''黑色''', '2015021115342134254', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342103585', '2015020315115042095', null, null, null, '2015021115342189568', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015021115342179487', null, null, null, null, '2015021115342123937', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031616013235132', '2015020316052665633', 'code', 'hbdj', '''红色'',''黑色''', '2015031615582144747174', '0', null, null, null);
insert into SYS_YPFJZBVAL (YPFJZBVALID, FIEDID, CONTSTYLE, VAL_1, VAL_2, YULIU1, YULIU2, YULIU3, YULIU4, YULIU5)
values ('2015031616013207151', '2015020315115042095', 'time_3', null, null, '2015031615582235753274', '0', null, null, null);
commit;
prompt 14 records loaded
prompt Loading SYS_ZSGL...
insert into SYS_ZSGL (ZSGLID, ZSNAME, STATER, REMARK, ZHI, FENSHU, CREATTIME, YUL1, YUL2)
values ('2014121214203791256', '4', '1', '4', '50', '30-40', null, null, null);
commit;
prompt 1 records loaded
prompt Loading T_LEVEL_INFO...
insert into T_LEVEL_INFO (LEVEL_ID, LEVEL_NAME, REMARK)
values ('574FC24FAC10C91F00A1A602C90F429D', '省评级标准', '（一）A类，表示该企业有荣誉信息，且无失信信息；' || chr(13) || '' || chr(10) || '　　（二）B类，表示该企业无荣誉信息，且无失信信息；' || chr(13) || '' || chr(10) || '　　（三）C类，表示该企业有二条以内失信信息；' || chr(13) || '' || chr(10) || '（四）D类，表示该企业有三条（含）以上失信信息或有严重失信行为造成严重社会影响的。');
insert into T_LEVEL_INFO (LEVEL_ID, LEVEL_NAME, REMARK)
values ('3F2064DDC0A80B4800A00DB683E9949E', '通用信用评价等级', '通用信用评价等级');
commit;
prompt 2 records loaded
prompt Loading T_LEVEL_INFO_MX...
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('575065E2AC10C91F00A1A602BAB694EC', '574FC24FAC10C91F00A1A602C90F429D', 'A', 90, 110, 1);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('5750CDD4AC10C91F00A1A602CF0C7E7E', '574FC24FAC10C91F00A1A602C90F429D', 'B', 70, 85, 2);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('5751202AAC10C91F00A1A6024BEB5608', '574FC24FAC10C91F00A1A602C90F429D', 'C', 55, 65, 3);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('5751A7C9AC10C91F00A1A602BDB1E533', '574FC24FAC10C91F00A1A602C90F429D', 'D', 0, 45, 4);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('587FCF86C0A80B4801BBE71D2195475B', '3F2064DDC0A80B4800A00DB683E9949E', 'A', -100, -1, 3);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('587A074CC0A80B4801BBE71D2088B439', '3F2064DDC0A80B4800A00DB683E9949E', 'AA', -1, 0, 2);
insert into T_LEVEL_INFO_MX (MX_ID, LEVEL_ID, LEVEL_IDENTIFICATION, BEGIN_VALUE, END_VALUE, SX)
values ('58795F54C0A80B4801BBE71DD8193E5F', '3F2064DDC0A80B4800A00DB683E9949E', 'AAA', 1, 100, 1);
commit;
prompt 7 records loaded
prompt Loading T_MKDZ_INFO...
insert into T_MKDZ_INFO (MK_ID, MK_NAME, JFLX, JFSC, JF, ZT, JFSCLX, MK_TYPE)
values ('B1BC9ACDC0A80413005147713F645A6A', '登录', '1', 5, 2, '1', 'minute', '0');
insert into T_MKDZ_INFO (MK_ID, MK_NAME, JFLX, JFSC, JF, ZT, JFSCLX, MK_TYPE)
values ('B1BBD59BC0A804130051477104466FE2', '法人接口查询', '1', 5, 2, '1', 'minute', '1');
insert into T_MKDZ_INFO (MK_ID, MK_NAME, JFLX, JFSC, JF, ZT, JFSCLX, MK_TYPE)
values ('B1BC3B10C0A80413005147712555BFA3', '自然人接口查询', '1', 5, 2, '1', 'minute', '2');
insert into T_MKDZ_INFO (MK_ID, MK_NAME, JFLX, JFSC, JF, ZT, JFSCLX, MK_TYPE)
values ('B1BD8671C0A8041300514771758A4989', '数据导入', '1', 12, 5, '1', 'minute', '3');
commit;
prompt 4 records loaded
prompt Loading T_OPT_LOG...
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('E9F670730AF4FA160122E8C9B1E6A07C', 'admin', '10.244.9.148', to_date('24-04-2015 13:46:24', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('E9F774270AF4FA160122E8C90B04D260', 'admin', '10.244.9.148', to_date('24-04-2015 13:47:30', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('EA0BD2150AF4FA160122E8C968B84B33', 'huanbj', '10.244.9.148', to_date('24-04-2015 14:09:45', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('EA158B660AF4FA160122E8C93E81A973', 'admin', '10.244.9.148', to_date('24-04-2015 14:20:22', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '环保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('EA1C7C510AF4FA160122E8C97DC8C7E4', 'admin', '10.244.9.148', to_date('24-04-2015 14:27:57', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '环保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('55DC1CA40AF4FA160122E8C974C03C6F', 'root', '10.244.9.8', to_date('15-05-2015 12:36:38', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('55DCBB650AF4FA160122E8C920CA4149', 'root', '10.244.9.8', to_date('15-05-2015 12:37:18', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('55DCD9CA0AF4FA160122E8C920E40690', 'root', '10.244.9.8', to_date('15-05-2015 12:37:26', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '人保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('55DD74060AF4FA160122E8C9898762C2', 'root', '10.244.9.8', to_date('15-05-2015 12:38:06', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '经信委监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('56262BA00AF4FA160122E8C947A8F2C0', 'root', '10.244.9.144', to_date('15-05-2015 13:57:31', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('562651780AF4FA160122E8C98FB16D7E', 'root', '10.244.9.144', to_date('15-05-2015 13:57:41', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '环保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('93DE93210AF4FA1600837311719422AF', 'root', '10.244.9.148', to_date('27-05-2015 13:35:46', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '人保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('93DED1340AF4FA160083731189D00116', 'root', '10.244.9.148', to_date('27-05-2015 13:36:02', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '环保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('443ABF010AF4FA1600837311AA26132F', 'root', '10.244.9.8', to_date('19-08-2015 12:32:24', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('443B33B40AF4FA1600837311C28FD05A', 'root', '10.244.9.8', to_date('19-08-2015 12:32:54', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('443C4DDF0AF4FA1600837311A6C49E3F', 'root', '10.244.9.8', to_date('19-08-2015 12:34:06', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第2页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('443C6BB70AF4FA1600837311F377AA15', 'root', '10.244.9.8', to_date('19-08-2015 12:34:14', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第3页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('E9F010FA0AF4FA160122E8C9626F2300', 'root', '10.244.9.42', to_date('24-04-2015 13:39:26', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '环保局监管信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('6AD784D70AF4FA160122E8C9FAC667ED', 'root', '10.244.9.144', to_date('19-05-2015 14:23:38', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '资质类信息；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('93A1BA880AF4FA16015034E0E3C51214', 'admin', '10.244.0.222', to_date('27-05-2015 12:29:19', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('E9EFE76A0AF4FA160122E8C91E5701AD', 'admin', '10.244.9.148', to_date('24-04-2015 13:39:15', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('E9EFEFF50AF4FA160122E8C99393A0DE', 'root', '10.244.9.42', to_date('24-04-2015 13:39:18', 'dd-mm-yyyy hh24:mi:ss'), '信用信息查询', '建筑建材企业备案；查询条件：无；第1页，每页10条；');
insert into T_OPT_LOG (LOG_ID, USER_ID, IP_ADDRESS, OPT_TIME, OPT_MENU, OPT_CONTENT)
values ('8071956DC0A804A900629AFF4F746CDC', 'admin', '0:0:0:0:0:0:0:1', to_date('08-12-2015 15:15:06', 'dd-mm-yyyy hh24:mi:ss'), '数据上传统计', '查询条件：无；');
commit;
prompt 23 records loaded
prompt Loading T_UPLOAD_LOGS...
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C1AECF13C0A804160151C9A016F0282A', 'admin', to_date('16-04-2015 18:03:21', 'dd-mm-yyyy hh24:mi:ss'), '2015020915202395938', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>营业执照注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法定代表人或负责人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>行政命令种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚时间</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚依据</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>整改情况</font>&nbsp;&nbsp;<br/>', 
        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C510506BC0A80416013787BAE902C6F4', 'admin', to_date('17-04-2015 09:48:42', 'dd-mm-yyyy hh24:mi:ss'), '2015020915393850718', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>工商注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚日期</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>责任人姓名</font>&nbsp;&nbsp;<br/>', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C513743CC0A8041600EB706D73A459A2', 'admin', to_date('17-04-2015 09:52:08', 'dd-mm-yyyy hh24:mi:ss'), '2015020914594270019', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法人代表</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法定代表人身份证号</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>注册地址</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>生产地址</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>产品执行标准</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>负责人信息</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>产品检测报告</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>起止日期或证件有效期</font><br/>', '&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font><br/>&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font><br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D28B57DC0A8043800140BBFAFCAA454', 'admin', to_date('09-02-2015 15:05:59', 'dd-mm-yyyy hh24:mi:ss'), '2015020914594270019', 81, 0, 81, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共81行，其中<br>重复数据0行<br>共需导入81条数据<br>其中导入成功81条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D33234AC0A8043800140BBFBB5A4E5C', 'admin', to_date('09-02-2015 15:17:22', 'dd-mm-yyyy hh24:mi:ss'), '2015020915090616228', 1749, 0, 1749, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共1749行，其中<br>重复数据0行<br>共需导入1749条数据<br>其中导入成功1749条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D407D67C0A8043800140BBFF2958FF0', 'admin', to_date('09-02-2015 15:31:57', 'dd-mm-yyyy hh24:mi:ss'), '2015020915202395938', 23, 0, 23, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共23行，其中<br>重复数据0行<br>共需导入23条数据<br>其中导入成功23条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D4F47F9C0A8043800140BBF309BD28E', 'admin', to_date('09-02-2015 15:48:07', 'dd-mm-yyyy hh24:mi:ss'), '2015020915393850718', 1, 0, 1, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共1行，其中<br>重复数据0行<br>共需导入1条数据<br>其中导入成功1条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D679020C0A8043800140BBFA2205552', 'admin', to_date('09-02-2015 16:14:38', 'dd-mm-yyyy hh24:mi:ss'), '2015020916070561664', 38, 0, 38, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共38行，其中<br>重复数据0行<br>共需导入38条数据<br>其中导入成功38条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C1A5EA13C0A80416018C2354CF19A886', 'admin', to_date('16-04-2015 17:53:38', 'dd-mm-yyyy hh24:mi:ss'), '2015020915202395938', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>营业执照注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法定代表人或负责人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>行政命令种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚时间</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚依据</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>整改情况</font>&nbsp;&nbsp;<br/>', 
        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C1AB9162C0A804160151C9A08A2E1D31', 'admin', to_date('16-04-2015 17:59:48', 'dd-mm-yyyy hh24:mi:ss'), '2015020915202395938', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>营业执照注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法定代表人或负责人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>行政命令种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚时间</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚依据</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>整改情况</font>&nbsp;&nbsp;<br/>', 
        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('6D8C87FCC0A8043800140BBF331AE4F0', 'admin', to_date('09-02-2015 16:55:01', 'dd-mm-yyyy hh24:mi:ss'), '2015020916505211956', 6, 0, 6, 0, '1', '<b>数据导入完成</b>：<br>Excel文件共6行，其中<br>重复数据0行<br>共需导入6条数据<br>其中导入成功6条<br>导入失败0条！' || chr(10) || '', null, 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C1AC710DC0A804160151C9A0A8F4B937', 'admin', to_date('16-04-2015 18:00:46', 'dd-mm-yyyy hh24:mi:ss'), '2015020915393850718', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>工商注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚日期</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>责任人姓名</font>&nbsp;&nbsp;<br/>', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
insert into T_UPLOAD_LOGS (LOG_ID, LOG_USER, LOG_TIME, LOG_TABLEID, LOG_SUN_SIZE, LOG_REPLAY_SIZE, LOG_UPLOAD_SIZE, LOG_FAIL_SIZE, LOG_STATES, REMARK, REMARK2, BDCGS, BDSBS, GJQYSL, GJGRSL)
values ('C1AD9FB7C0A804160151C9A06613C86F', 'admin', to_date('16-04-2015 18:02:03', 'dd-mm-yyyy hh24:mi:ss'), '2015020915202395938', 0, 0, 0, 0, '5', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>信息事项名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>营业执照注册号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>组织机构代码</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>企业名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>法定代表人或负责人姓名</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚文号</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>行政命令种类</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚时间</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚事由</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚内容</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚依据</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>处罚执行情况</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>整改情况</font>&nbsp;&nbsp;<br/>', 
        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>项目名称</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第一期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第二期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第三期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>第四期款项</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>合同金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>开票总金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>实收金额</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>差异</font>&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=''blue''>定审价格</font>&nbsp;&nbsp;<br/>', 0, 0, null, null);
commit;
prompt 13 records loaded
prompt Loading WARN_RESULT_61...
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (1, '219C1D11AC10670F0112CA62EEC14567', '20C6914D6074337C4819F5077970A2F5', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (2, '219C1D11AC10670F0112CA62EEC14567', '6DB25D69C5B71E81D5D4A626326408CA', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (3, '219C1D11AC10670F0112CA62EEC14567', '488AAFC28BD4B9F3D23D285BBC01C1F1', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (4, '219C1D11AC10670F0112CA62EEC14567', 'C20588186168C511D0527A6B1984017C', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (5, '219C1D11AC10670F0112CA62EEC14567', '767E059670872A224E9ABD43A0BC4FB6', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (6, '219C1D11AC10670F0112CA62EEC14567', 'E9B36862E2BB912690EF479C06886145', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (7, '219C1D11AC10670F0112CA62EEC14567', '5B446AB4CCDB12368B98B3CED717E5B2', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (8, '219C1D11AC10670F0112CA62EEC14567', '8649DF3A0EB1F96F8123736A6CF5DFC0', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (9, '219C1D11AC10670F0112CA62EEC14567', '8455FE58F11E46E5D9A215568B4E7CEF', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (10, '219C1D11AC10670F0112CA62EEC14567', '46F47FA30D40D57408EDEB30C53AA525', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (11, '219C1D11AC10670F0112CA62EEC14567', '42A542B6D2959184C157DDD89C453E95', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (12, '219C1D11AC10670F0112CA62EEC14567', '3FCF8010A8311F979DAD17BFDED2DB57', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (13, '219C1D11AC10670F0112CA62EEC14567', '44AA8232EDC02949DDCA56913ACFD111', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (14, '219C1D11AC10670F0112CA62EEC14567', '67EF8118257263B899384CB6D7130162', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (15, '219C1D11AC10670F0112CA62EEC14567', 'A5B52492FC138D8458A682263100C6C2', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (16, '219C1D11AC10670F0112CA62EEC14567', '4948051F95FBE5E1B42C551E89ECC96E', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (17, '219C1D11AC10670F0112CA62EEC14567', 'B1D47CA02CD7E110958B2034D0939D3F', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into WARN_RESULT_61 (WARN_RESULT_ID, WARN_ID, ENTERPRISE_ID, INDEX_DATA, GRADE, CREATE_DATE)
values (18, '219C1D11AC10670F0112CA62EEC14567', '45C99F6DC46FD51736E9A8E633D73D3F', 1, null, to_timestamp('16-03-2015 15:40:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 18 records loaded
prompt Loading WARN_SUBSCRIBE...
insert into WARN_SUBSCRIBE (SUB_ID, DEPT_ID, WARN_ID)
values ('219C5E65AC10670F0112CA6214A283E9', 'OuLi20070529174221891', '219C1D11AC10670F0112CA62EEC14567');
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
