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