/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : sts

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-10-22 13:47:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for iot_index_info
-- ----------------------------
DROP TABLE IF EXISTS `iot_index_info`;
CREATE TABLE `iot_index_info` (
  `ID` varchar(32) NOT NULL,
  `PAGE_ID` varchar(32) NOT NULL,
  `POSITION_X` int(11) DEFAULT NULL,
  `POSITION_Y` int(11) DEFAULT NULL,
  `WIDTH` int(11) DEFAULT NULL,
  `HEIGHT` int(11) DEFAULT NULL,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `STANDBY1` varchar(50) DEFAULT NULL,
  `STANDBY2` varchar(50) DEFAULT NULL,
  `STANDBY3` varchar(50) DEFAULT NULL,
  `CONTENT` text,
  `COLUMN1` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_index_info
-- ----------------------------
INSERT INTO `iot_index_info` VALUES ('016C4C635A82470D971CBFF03DDA1CEB', '956c909709a24874a4869c0d3987f39b', '6', '5', '6', '3', '2019-10-21 15:19:33', null, null, null, '<divclass=\"layui-row\">\r\n					<divclass=\"layui-rowblock-title\">\r\n						<divclass=\"layui-col-xs12layui-col-sm12layui-col-md12block-title-contentalign-fa\">\r\n							<pclass=\"align-chblock-title-word\">问题发现及解决情况</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-rowblock-content\"></div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('023704717C5F4CB68D4523CF7745DDBA', '956c909709a24874a4869c0d3987f39b', '6', '0', '2', '1', '2019-10-21 15:19:34', null, null, null, '<divclass=\"height-fullabnormallink_block\"data-url=\"deviceExceptionDetails.html\"data-id=\"deviceExceptionDetails\"data-text=\"设备异常\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5height-fullalign-fa\"style=\"background-color:#2C8DB0;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-calendar\"></i>\r\n							<p>设备异常</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7dataheight-fullalign-fa\"style=\"background-color:#2E96BB;\">\r\n						<pclass=\"align-ch\"id=\"total_PROBLEM\">0</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('02CFF18EA85E4EC1BA7FE4282820C96C', '50ad004a1c434b7287d0a10011d6d777', '4', '0', '2', '1', '2019-10-21 15:19:34', null, null, null, '<div class=\"height-full danger link_block data-block\" data-url=\"question_traking.html?type=warn\" data-id=\"question_traking\" data-text=\"隐患问题\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-warning\" style=\"color: #94E0E1;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #94E0E1;\">隐患问题</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEM_WARN\" style=\"color: #94E0E1;\">0</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('11D1E8A1392F4BA094A60DB2B15A3712', '956c909709a24874a4869c0d3987f39b', '10', '1', '2', '1', '2019-10-21 15:19:33', null, null, null, '<divclass=\"height-fullproblem_ratelink_block\"data-url=\"index.action?type=3&amp;column=problembi\"data-id=\"problem_rate\"data-text=\"问题整改率\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5align-faheight-full\"style=\"background-color:#50AD80;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-hourglass-o\"></i>\r\n							<pclass=\"align-ch\">问题整改率</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7height-fulldataalign-fa\"style=\"background-color:#53B687;\">\r\n						<pclass=\"align-ch\"id=\"total_PROBLEMRECTIFYRATE\">0.00%</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('383FA3530A184CD9A3C633E9B1EBB03D', '50ad004a1c434b7287d0a10011d6d777', '2', '1', '2', '1', '2019-10-21 15:19:33', null, null, null, '<div class=\"height-full need link_block data-block\" data-url=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\" data-id=\"need\" data-text=\"待办数量\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-calendar-check-o\" style=\"color: #6C9996;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #6C9996;\">待办数量</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_TODO\" style=\"color: #6C9996;\">8</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('3DB8E5152B71459BAAED7E5B21A905DF', '50ad004a1c434b7287d0a10011d6d777', '4', '1', '2', '1', '2019-10-21 15:19:34', null, null, null, '<div class=\"height-full problem_rate link_block data-block\" data-url=\"index.action?type=3&amp;column=problembi\" data-id=\"problem_rate\" data-text=\"问题整改率\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-hourglass-o\" style=\"color: #FFBFA7;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #FFBFA7;\">问题整改率</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEMRECTIFYRATE\" style=\"color: #FFBFA7;\">0.00%</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('50AD6ACF7C79436E8DEF0DB5E312C4F3', '956c909709a24874a4869c0d3987f39b', '6', '1', '2', '1', '2019-10-21 15:19:34', null, null, null, '<divclass=\"height-fullneedlink_block\"data-url=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"data-id=\"need\"data-text=\"待办数量\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5align-faheight-full\"style=\"background-color:#92A4A6;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-calendar-check-o\"></i>\r\n							<pclass=\"align-ch\">待办数量</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7height-fulldataalign-fa\"style=\"background-color:#9BADB1;\">\r\n						<pclass=\"align-ch\"id=\"total_TODO\">0</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('674E68A906C44941857BA7897C68D88D', '956c909709a24874a4869c0d3987f39b', '0', '5', '6', '3', '2019-10-21 15:19:33', null, null, null, '<divclass=\"layui-row\">\r\n					<divclass=\"layui-rowblock-title\">\r\n						<divclass=\"layui-col-xs12layui-col-sm12layui-col-md12block-title-contentalign-fa\">\r\n							<pclass=\"align-chblock-title-word\">任务完成情况</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-rowblock-content\"></div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('81F6A90ACBE64A6080C69B3340A49FD2', '956c909709a24874a4869c0d3987f39b', '8', '0', '2', '1', '2019-10-21 15:19:34', null, null, null, '<divclass=\"height-fullcompletionlink_block\"data-url=\"index.action?type=3&amp;column=taskbi\"data-id=\"task_finish_rate\"data-text=\"任务完成率\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5align-faheight-full\"style=\"background-color:#50AD80;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-pencil-square-o\"></i>\r\n							<pclass=\"align-ch\">任务完成率</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7height-fulldataalign-fa\"style=\"background-color:#53B687;\">\r\n						<pclass=\"align-ch\"id=\"total_TASK_RATE\">0.00%</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('985F1F2DF1A14242B0511439046FAD87', '50ad004a1c434b7287d0a10011d6d777', '6', '5', '6', '3', '2019-10-21 15:19:33', null, null, null, '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div class=\"layui-col-xs12 layui-col-sm12 layui-col-md12 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">问题发现及解决情况</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\"></div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('A252931C09664A23A0D5A8FBACE825E4', '50ad004a1c434b7287d0a10011d6d777', '0', '0', '2', '1', '2019-10-21 15:19:33', null, null, null, '<div class=\"height-full abnormal link_block data-block\" data-url=\"deviceExceptionDetails.html\" data-id=\"deviceExceptionDetails\" data-text=\"设备异常\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-calendar\" style=\"color: #F8BB74;\"></i>\r\n							<p style=\"color: #F8BB74;\">设备异常</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7  data height-full align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEM\">0</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('A891D58505574091A23739B6008F2F7E', '50ad004a1c434b7287d0a10011d6d777', '0', '1', '2', '1', '2019-10-21 15:19:34', null, null, null, '<div class=\"height-full completion link_block data-block\" data-url=\"index.action?type=3&amp;column=taskbi\" data-id=\"task_finish_rate\" data-text=\"任务完成率\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-pencil-square-o\" style=\"color: #53B687;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #53B687;\">任务完成率</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_TASK_RATE\" style=\"color: #53B687;\">0.00%</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('A8E5E9291AE64E09974645C841B73156', '50ad004a1c434b7287d0a10011d6d777', '2', '0', '2', '1', '2019-10-21 15:19:34', null, null, null, '<div class=\"height-full alarm link_block data-block\" data-url=\"noticeWarn.html\" data-id=\"noticeWarn\" data-text=\"预警\">\r\n					<div class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-bell\" style=\"color: #86D2EE;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #86D2EE;\">预警</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_WARN\" style=\"color: #86D2EE;\">950</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('BB84DBBDF80B45A29D3BE3B4846DC3F7', '50ad004a1c434b7287d0a10011d6d777', '0', '2', '6', '3', '2019-10-21 15:19:34', null, null, null, '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div class=\"layui-col-xs8 layui-col-sm8 layui-col-md8 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">待办任务</p>\r\n						</div>\r\n						<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 block-title-link more align-fa\">\r\n							<a class=\"align-ch block-title-more\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\" title=\"更多待办任务\">更多&gt;&gt;</a>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\">\r\n						<table id=\"todo_task\" lay-filter=\"test\"></table><div class=\"layui-form layui-border-box layui-table-view\" lay-filter=\"LAY-table-1\" lay-id=\"todo_task\" style=\" height:209.95px;\"><div class=\"layui-table-box\"><div class=\"layui-table-header\"><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"layui-table\" lay-skin=\"line\" lay-size=\"sm\" lay-even=\"\"><thead><tr><th data-field=\"0\" data-key=\"1-0-0\" data-unresize=\"true\" class=\" layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\" align=\"center\"><span>序号</span></div></th><th data-field=\"taskInstName\" data-key=\"1-0-1\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\" align=\"center\"><span>任务名</span></div></th><th data-field=\"starter\" data-key=\"1-0-2\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\" align=\"center\"><span>发起者</span></div></th><th data-field=\"arriveDate\" data-key=\"1-0-3\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\" align=\"center\"><span>任务到达时间</span></div></th><th data-field=\"taskState\" data-key=\"1-0-4\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\" align=\"center\"><span>紧急度</span></div></th><th data-field=\"5\" data-key=\"1-0-5\" class=\" layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\" align=\"center\"><span>处理</span></div></th></tr></thead></table></div><div class=\"layui-table-body layui-table-main\" style=\"height: 176.95px;\"><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"layui-table\" lay-skin=\"line\" lay-size=\"sm\" lay-even=\"\"><tbody><tr data-index=\"0\" class=\"\"><td data-field=\"0\" data-key=\"1-0-0\" align=\"center\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\">1</div></td><td data-field=\"taskInstName\" data-key=\"1-0-1\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\">问题上报</div></td><td data-field=\"starter\" data-key=\"1-0-2\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\">admin</div></td><td data-field=\"arriveDate\" data-key=\"1-0-3\" align=\"center\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\">2019-06-05 17:28:34.066</div></td><td data-field=\"taskState\" data-key=\"1-0-4\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\">一般</div></td><td data-field=\"5\" data-key=\"1-0-5\" align=\"center\" data-off=\"true\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\"> <a style=\"color: #3B8FAE;\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=TaskDispose&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\" data-click-href=\"rest/process/claimTask?userID=${sessionScope.userID}&amp;userPwd=123456&amp;task_owner=${sessionScope.userID}&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\"> <i class=\"fa fa-pencil-square-o\"></i> 处理 </a> </div></td></tr><tr data-index=\"1\" class=\"\"><td data-field=\"0\" data-key=\"1-0-0\" align=\"center\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\">2</div></td><td data-field=\"taskInstName\" data-key=\"1-0-1\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\">问题上报</div></td><td data-field=\"starter\" data-key=\"1-0-2\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\">admin</div></td><td data-field=\"arriveDate\" data-key=\"1-0-3\" align=\"center\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\">2019-05-09 16:08:02.828</div></td><td data-field=\"taskState\" data-key=\"1-0-4\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\">一般</div></td><td data-field=\"5\" data-key=\"1-0-5\" align=\"center\" data-off=\"true\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\"> <a style=\"color: #3B8FAE;\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=TaskDispose&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\" data-click-href=\"rest/process/claimTask?userID=${sessionScope.userID}&amp;userPwd=123456&amp;task_owner=${sessionScope.userID}&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\"> <i class=\"fa fa-pencil-square-o\"></i> 处理 </a> </div></td></tr><tr data-index=\"2\" class=\"\"><td data-field=\"0\" data-key=\"1-0-0\" align=\"center\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\">3</div></td><td data-field=\"taskInstName\" data-key=\"1-0-1\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\">问题上报</div></td><td data-field=\"starter\" data-key=\"1-0-2\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\">admin</div></td><td data-field=\"arriveDate\" data-key=\"1-0-3\" align=\"center\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\">2019-01-31 11:12:48.39</div></td><td data-field=\"taskState\" data-key=\"1-0-4\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\">一般</div></td><td data-field=\"5\" data-key=\"1-0-5\" align=\"center\" data-off=\"true\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\"> <a style=\"color: #3B8FAE;\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=TaskDispose&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\" data-click-href=\"rest/process/claimTask?userID=${sessionScope.userID}&amp;userPwd=123456&amp;task_owner=${sessionScope.userID}&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\"> <i class=\"fa fa-pencil-square-o\"></i> 处理 </a> </div></td></tr><tr data-index=\"3\" class=\"\"><td data-field=\"0\" data-key=\"1-0-0\" align=\"center\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\">4</div></td><td data-field=\"taskInstName\" data-key=\"1-0-1\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\">问题上报</div></td><td data-field=\"starter\" data-key=\"1-0-2\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\">admin</div></td><td data-field=\"arriveDate\" data-key=\"1-0-3\" align=\"center\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\">2019-01-04 11:31:46.546</div></td><td data-field=\"taskState\" data-key=\"1-0-4\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\">一般</div></td><td data-field=\"5\" data-key=\"1-0-5\" align=\"center\" data-off=\"true\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\"> <a style=\"color: #3B8FAE;\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=TaskDispose&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\" data-click-href=\"rest/process/claimTask?userID=${sessionScope.userID}&amp;userPwd=123456&amp;task_owner=${sessionScope.userID}&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\"> <i class=\"fa fa-pencil-square-o\"></i> 处理 </a> </div></td></tr><tr data-index=\"4\" class=\"\"><td data-field=\"0\" data-key=\"1-0-0\" align=\"center\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-0 laytable-cell-numbers\">5</div></td><td data-field=\"taskInstName\" data-key=\"1-0-1\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-1\">问题上报</div></td><td data-field=\"starter\" data-key=\"1-0-2\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-2\">admin</div></td><td data-field=\"arriveDate\" data-key=\"1-0-3\" align=\"center\" data-minwidth=\"180\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-3\">2019-01-04 10:22:36.75</div></td><td data-field=\"taskState\" data-key=\"1-0-4\" align=\"center\" class=\"\"><div class=\"layui-table-cell laytable-cell-1-0-4\">一般</div></td><td data-field=\"5\" data-key=\"1-0-5\" align=\"center\" data-off=\"true\" class=\"layui-table-col-special\"><div class=\"layui-table-cell laytable-cell-1-0-5\"> <a style=\"color: #3B8FAE;\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=TaskDispose&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\" data-click-href=\"rest/process/claimTask?userID=${sessionScope.userID}&amp;userPwd=123456&amp;task_owner=${sessionScope.userID}&amp;PIID=${map.PRO_INST_ID }&amp;TIID=${map.TASK_INST_ID }\"> <i class=\"fa fa-pencil-square-o\"></i> 处理 </a> </div></td></tr></tbody></table></div></div><style>.laytable-cell-1-0-0{ width: 40px; }.laytable-cell-1-0-1{  }.laytable-cell-1-0-2{  }.laytable-cell-1-0-3{  }.laytable-cell-1-0-4{  }.laytable-cell-1-0-5{  }</style></div>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('BFEF310550D04BF3808FD427FEC16EE8', '956c909709a24874a4869c0d3987f39b', '6', '2', '6', '3', '2019-10-21 15:19:33', null, null, null, '<divclass=\"layui-row\">\r\n					<divclass=\"layui-rowblock-title\">\r\n						<divclass=\"layui-col-xs8layui-col-sm8layui-col-md8block-title-contentalign-fa\">\r\n							<pclass=\"align-chblock-title-word\">消息提醒</p>\r\n						</div>\r\n						<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4block-title-linkmorealign-fa\">\r\n							<aclass=\"align-chblock-title-more\"href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"title=\"更多消息提醒\">更多&gt;&gt;</a>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-rowblock-content\"id=\"notice\"><marqueestyle=\"margin:00;height:98%\"direction=\"up\"behavior=\"scroll\"scrollamount=\"3\"scrolldelay=\"0\"loop=\"-1\"hspace=\"10\"vspace=\"10\"onmouseover=\"this.stop()\"onmouseout=\"this.start()\"><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><iclass=\"fafa-bell-o\"></i><spanclass=\"details\"onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p></marquee></div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('D2F97C477C044FDD93876559B78F0CB7', '50ad004a1c434b7287d0a10011d6d777', '6', '2', '6', '3', '2019-10-21 15:19:34', null, null, null, '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div class=\"layui-col-xs8 layui-col-sm8 layui-col-md8 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">消息提醒</p>\r\n						</div>\r\n						<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 block-title-link more align-fa\">\r\n							<a class=\"align-ch block-title-more\" href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\" title=\"更多消息提醒\">更多&gt;&gt;</a>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\" id=\"notice\"><marquee style=\"margin: 0 0;height: 98%\" direction=\"up\" behavior=\"scroll\" scrollamount=\"3\" scrolldelay=\"0\" loop=\"-1\" hspace=\"10\" vspace=\"10\" onmouseover=\"this.stop()\" onmouseout=\"this.start()\"><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p><p><i class=\"fa fa-bell-o\"></i><span class=\"details\" onclick=\"showDetails(this)\">问题上报--已超期5天!!!</span></p></marquee></div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('D3C2D52CD69A40AC862F626E29E79D80', '956c909709a24874a4869c0d3987f39b', '0', '0', '6', '2', '2019-10-21 15:19:33', null, null, null, '<divclass=\"layui-row\">\r\n					<divclass=\"layui-col-xs2layui-col-sm2layui-col-md2height-full\">\r\n						<divclass=\"height-fullquick-navigation-titlealign-fa\">\r\n							<divclass=\"align-ch\">\r\n								<iclass=\"fafa-hand-o-right\"></i>\r\n								<p>快捷导航</p>\r\n							</div>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs10layui-col-sm10layui-col-md10height-fullquick-navigation-items\">\r\n						<divclass=\"layui-rowheight-half\">\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"闭环管理\"data-text=\"闭环管理\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-calendar\"></i>\r\n										<p>闭环管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"生产报表\"data-text=\"生产报表\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-flask\"></i>\r\n										<p>生产报表</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"辅助决策\"data-text=\"辅助决策\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-podcast\"></i>\r\n										<p>辅助决策</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<divclass=\"layui-rowheight-half\">\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"任务管理\"data-text=\"任务管理\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-bar-chart\"></i>\r\n										<p>任务管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"任务跟踪\"data-text=\"任务跟踪\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-line-chart\"></i>\r\n										<p>任务跟踪</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4height-fulllink_block\"data-url=\"https://www.baidu.com\"data-id=\"应知应会\"data-text=\"应知应会\">\r\n								<divclass=\"height-fullquick-navigation-itemalign-fa\">\r\n									<divclass=\"align-ch\">\r\n										<iclass=\"fafa-search\"></i>\r\n										<p>应知应会</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('D5D7F365849C488195D4BA89F22EC69C', '956c909709a24874a4869c0d3987f39b', '10', '0', '2', '1', '2019-10-21 15:19:34', null, null, null, '<divclass=\"height-fullalarmlink_block\"data-url=\"noticeWarn.html\"data-id=\"noticeWarn\"data-text=\"预警\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5height-fullalign-fa\"style=\"background-color:#66908E;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-bell\"></i>\r\n							<pclass=\"align-ch\">预警</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7height-fulldataalign-fa\"style=\"background-color:#6C9996;\">\r\n						<pclass=\"align-ch\"id=\"total_WARN\">920</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('DA01B4B0E87E40CB906A5E441A069A1E', '956c909709a24874a4869c0d3987f39b', '0', '2', '6', '3', '2019-10-21 15:19:33', null, null, null, '<divclass=\"layui-row\">\r\n					<divclass=\"layui-rowblock-title\">\r\n						<divclass=\"layui-col-xs8layui-col-sm8layui-col-md8block-title-contentalign-fa\">\r\n							<pclass=\"align-chblock-title-word\">待办任务</p>\r\n						</div>\r\n						<divclass=\"layui-col-xs4layui-col-sm4layui-col-md4block-title-linkmorealign-fa\">\r\n							<aclass=\"align-chblock-title-more\"href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"title=\"更多待办任务\">更多&gt;&gt;</a>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-rowblock-content\">\r\n						<tableid=\"todo_task\"lay-filter=\"test\"></table><divclass=\"layui-formlayui-border-boxlayui-table-view\"lay-filter=\"LAY-table-1\"lay-id=\"todo_task\"style=\"height:209.95px;\"><divclass=\"layui-table-box\"><divclass=\"layui-table-header\"><tablecellspacing=\"0\"cellpadding=\"0\"border=\"0\"class=\"layui-table\"lay-skin=\"line\"lay-size=\"sm\"lay-even=\"\"><thead><tr><thdata-field=\"0\"data-key=\"1-0-0\"data-unresize=\"true\"class=\"layui-table-col-special\"><divclass=\"layui-table-celllaytable-cell-1-0-0laytable-cell-numbers\"align=\"center\"><span>序号</span></div></th><thdata-field=\"taskInstName\"data-key=\"1-0-1\"class=\"\"><divclass=\"layui-table-celllaytable-cell-1-0-1\"align=\"center\"><span>任务名</span></div></th><thdata-field=\"starter\"data-key=\"1-0-2\"class=\"\"><divclass=\"layui-table-celllaytable-cell-1-0-2\"align=\"center\"><span>发起者</span></div></th><thdata-field=\"arriveDate\"data-key=\"1-0-3\"data-minwidth=\"180\"class=\"\"><divclass=\"layui-table-celllaytable-cell-1-0-3\"align=\"center\"><span>任务到达时间</span></div></th><thdata-field=\"taskState\"data-key=\"1-0-4\"class=\"\"><divclass=\"layui-table-celllaytable-cell-1-0-4\"align=\"center\"><span>紧急度</span></div></th><thdata-field=\"5\"data-key=\"1-0-5\"class=\"layui-table-col-special\"><divclass=\"layui-table-celllaytable-cell-1-0-5\"align=\"center\"><span>处理</span></div></th></tr></thead></table></div><divclass=\"layui-table-bodylayui-table-main\"style=\"height:179.95px;\"><tablecellspacing=\"0\"cellpadding=\"0\"border=\"0\"class=\"layui-table\"lay-skin=\"line\"lay-size=\"sm\"lay-even=\"\"><tbody></tbody></table><divclass=\"layui-none\">无数据</div></div></div><style>.laytable-cell-1-0-0{width:40px;}.laytable-cell-1-0-1{}.laytable-cell-1-0-2{}.laytable-cell-1-0-3{}.laytable-cell-1-0-4{}.laytable-cell-1-0-5{}</style></div>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('DDF99C46AF964E78BACB8CB8E8A2936D', '956c909709a24874a4869c0d3987f39b', '8', '1', '2', '1', '2019-10-21 15:19:34', null, null, null, '<divclass=\"height-fulldangerlink_block\"data-url=\"question_traking.html?type=warn\"data-id=\"question_traking\"data-text=\"隐患问题\">\r\n					<divclass=\"layui-col-xs5layui-col-sm5layui-col-md5height-fullalign-fa\"style=\"background-color:#2C8DB0;\">\r\n						<divclass=\"align-ch\">\r\n							<iclass=\"fafa-warning\"></i>\r\n							<pclass=\"align-ch\">隐患问题</p>\r\n						</div>\r\n					</div>\r\n					<divclass=\"layui-col-xs7layui-col-sm7layui-col-md7height-fulldataalign-fa\"style=\"background-color:#2E96BB;\">\r\n						<pclass=\"align-ch\"id=\"total_PROBLEM_WARN\">0</p>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('E759866110744C3987F26A24A0061090', '50ad004a1c434b7287d0a10011d6d777', '6', '0', '6', '2', '2019-10-21 15:19:34', null, null, null, '<div class=\"layui-row\">\r\n					<div class=\"layui-col-xs2 layui-col-sm2 layui-col-md2 height-full\">\r\n						<div class=\"height-full quick-navigation-title align-fa\">\r\n							<div class=\"align-ch\">\r\n								<i class=\"fa fa-hand-o-right\"></i>\r\n								<p>快捷导航</p>\r\n							</div>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-col-xs10 layui-col-sm10 layui-col-md10 height-full quick-navigation-items\">\r\n						<div class=\"layui-row height-half\">\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"闭环管理\" data-text=\"闭环管理\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-calendar\"></i>\r\n										<p>闭环管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"生产报表\" data-text=\"生产报表\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-flask\"></i>\r\n										<p>生产报表</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"辅助决策\" data-text=\"辅助决策\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-podcast\"></i>\r\n										<p>辅助决策</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"layui-row height-half\">\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"任务管理\" data-text=\"任务管理\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-bar-chart\"></i>\r\n										<p>任务管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"任务跟踪\" data-text=\"任务跟踪\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-line-chart\"></i>\r\n										<p>任务跟踪</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\" data-url=\"https://www.baidu.com\" data-id=\"应知应会\" data-text=\"应知应会\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-search\"></i>\r\n										<p>应知应会</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n					</div>\r\n				</div>', null);
INSERT INTO `iot_index_info` VALUES ('FAFB34AB02EA46BBB4C9EA4FBF47C1D6', '50ad004a1c434b7287d0a10011d6d777', '0', '5', '6', '3', '2019-10-21 15:19:33', null, null, null, '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div class=\"layui-col-xs12 layui-col-sm12 layui-col-md12 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">任务完成情况</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\"></div>\r\n				</div>', null);

-- ----------------------------
-- Table structure for iot_index_info_role
-- ----------------------------
DROP TABLE IF EXISTS `iot_index_info_role`;
CREATE TABLE `iot_index_info_role` (
  `ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `PAGE_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_index_info_role
-- ----------------------------
INSERT INTO `iot_index_info_role` VALUES ('641D2CAC6A124E98BC06F3DA124534E5', '2ba62c1a1414d7491eb05338d14c1c3', '956c909709a24874a4869c0d3987f39b');
INSERT INTO `iot_index_info_role` VALUES ('7EB282E665104A43BF8B005EB6AAC990', 'A291958C761347159F28FBDF70ADC12D', '50ad004a1c434b7287d0a10011d6d777');
INSERT INTO `iot_index_info_role` VALUES ('E3EE6F378D244BA28C3B9ED19D73023B', '26674768CDA449FA9F677F9B9F4FF0D2', 'c6250433da294ba886118e8a96ad7b2d');

-- ----------------------------
-- Table structure for iot_index_temp_info
-- ----------------------------
DROP TABLE IF EXISTS `iot_index_temp_info`;
CREATE TABLE `iot_index_temp_info` (
  `ID` varchar(32) NOT NULL,
  `TEMP_NAME` varchar(40) DEFAULT NULL,
  `TEMP_COMTENT` text,
  `STANDBY1` varchar(50) DEFAULT NULL,
  `STANDBY2` varchar(50) DEFAULT NULL,
  `STANDBY3` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_index_temp_info
-- ----------------------------
INSERT INTO `iot_index_temp_info` VALUES ('02C7D2425B0C44E1AC5BC7EEA1F56576', '设备异常数据块', '<div class=\"height-full abnormal link_block data-block\"\r\n					data-url=\"deviceExceptionDetails.html\"\r\n					data-id=\"deviceExceptionDetails\" data-text=\"设备异常\">\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-calendar\" style=\"color: #F8BB74;\"></i>\r\n							<p style=\"color: #F8BB74;\">设备异常</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7  data height-full align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEM\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('067D6AF873BD4CE59121E78015E5536F', '隐患问题数据块', '<div class=\"height-full danger link_block data-block\"\r\n					data-url=\"question_traking.html?type=warn\"\r\n					data-id=\"question_traking\" data-text=\'隐患问题\'>\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-warning\" style=\"color: #94E0E1;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #94E0E1;\">隐患问题</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEM_WARN\"\r\n							style=\"color: #94E0E1;\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('0FA9B4B1E95C491B80B84521776C4BBD', '消息提醒滚动块', '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div\r\n							class=\"layui-col-xs8 layui-col-sm8 layui-col-md8 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">消息提醒</p>\r\n						</div>\r\n						<div\r\n							class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 block-title-link more align-fa\">\r\n							<a class=\"align-ch block-title-more\"\r\n								href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"\r\n								title=\"更多消息提醒\">更多>></a>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\" id=\"notice\"></div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('14D10BCDFFD24E27B0A0D373D5B6F135', '预警数据块', '<div class=\"height-full alarm link_block data-block\"\r\n					data-url=\"noticeWarn.html\" data-id=\"noticeWarn\" data-text=\"预警\">\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 height-full align-fa\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-bell\" style=\"color: #86D2EE;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #86D2EE;\">预警</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_WARN\" style=\"color: #86D2EE;\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('2EBB831CFEF04DC5AFF3851846A4878D', '问题发现及解决情况报表块', '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div\r\n							class=\"layui-col-xs12 layui-col-sm12 layui-col-md12 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">问题发现及解决情况</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\"></div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('38AB73D5202B448594B578FC4ED208EE', '问题整改率数据块', '<div class=\"height-full problem_rate link_block data-block\"\r\n					data-url=\"index.action?type=3&column=problembi\"\r\n					data-id=\"problem_rate\" data-text=\"问题整改率\">\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-hourglass-o\" style=\"color: #FFBFA7;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #FFBFA7;\">问题整改率</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_PROBLEMRECTIFYRATE\"\r\n							style=\"color: #FFBFA7;\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('69FBF959BA684A83AE58764098B46B2D', '待办数量数据块', '<div class=\"height-full need link_block data-block\"\r\n					data-url=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"\r\n					data-id=\"need\" data-text=\"待办数量\">\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-calendar-check-o\" style=\"color: #6C9996;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #6C9996;\">待办数量</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_TODO\" style=\"color: #6C9996;\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('AE32577D80F6461AA9FC398447933A5E', '快捷导航块', '<div class=\"layui-row\">\r\n					<div class=\"layui-col-xs2 layui-col-sm2 layui-col-md2 height-full\">\r\n						<div class=\"height-full quick-navigation-title align-fa\">\r\n							<div class=\"align-ch\">\r\n								<i class=\"fa fa-hand-o-right\"></i>\r\n								<p>快捷导航</p>\r\n							</div>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs10 layui-col-sm10 layui-col-md10 height-full quick-navigation-items\">\r\n						<div class=\"layui-row height-half\">\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"闭环管理\" data-text=\"闭环管理\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-calendar\"></i>\r\n										<p>闭环管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"生产报表\" data-text=\"生产报表\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-flask\"></i>\r\n										<p>生产报表</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"辅助决策\" data-text=\"辅助决策\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-podcast\"></i>\r\n										<p>辅助决策</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"layui-row height-half\">\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"任务管理\" data-text=\"任务管理\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-bar-chart\"></i>\r\n										<p>任务管理</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"任务跟踪\" data-text=\"任务跟踪\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-line-chart\"></i>\r\n										<p>任务跟踪</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n							<div\r\n								class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 height-full link_block\"\r\n								data-url=\'https://www.baidu.com\' data-id=\"应知应会\" data-text=\"应知应会\">\r\n								<div class=\"height-full quick-navigation-item align-fa\">\r\n									<div class=\"align-ch\">\r\n										<i class=\"fa fa-search\"></i>\r\n										<p>应知应会</p>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('BA6CCA082C334417BF71ACA612B4A122', '任务完成情况报表块', '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div\r\n							class=\"layui-col-xs12 layui-col-sm12 layui-col-md12 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">任务完成情况</p>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\"></div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('D1F5AAB98663475AA611FA54445D0F36', '任务完成率数据块', '<div class=\"height-full completion link_block data-block\"\r\n					data-url=\"index.action?type=3&column=taskbi\"\r\n					data-id=\"task_finish_rate\" data-text=\"任务完成率\">\r\n					<div\r\n						class=\"layui-col-xs5 layui-col-sm5 layui-col-md5 align-fa height-full\">\r\n						<div class=\"align-ch\">\r\n							<i class=\"fa fa-pencil-square-o\" style=\"color: #53B687;\"></i>\r\n							<p class=\"align-ch\" style=\"color: #53B687;\">任务完成率</p>\r\n						</div>\r\n					</div>\r\n					<div\r\n						class=\"layui-col-xs7 layui-col-sm7 layui-col-md7 height-full data align-fa\">\r\n						<p class=\"align-ch\" id=\"total_TASK_RATE\" style=\"color: #53B687;\"></p>\r\n					</div>\r\n				</div>', null, null, null);
INSERT INTO `iot_index_temp_info` VALUES ('E7DD973EA1D649F490948F3C945F1F55', '待办任务列表块', '<div class=\"layui-row\">\r\n					<div class=\"layui-row block-title\">\r\n						<div\r\n							class=\"layui-col-xs8 layui-col-sm8 layui-col-md8 block-title-content align-fa\">\r\n							<p class=\"align-ch block-title-word\">待办任务</p>\r\n						</div>\r\n						<div\r\n							class=\"layui-col-xs4 layui-col-sm4 layui-col-md4 block-title-link more align-fa\">\r\n							<a class=\"align-ch block-title-more\"\r\n								href=\"http://192.168.18.22:10239/BPMOperationCenter/?UIID=Gtask\"\r\n								title=\"更多待办任务\">更多>></a>\r\n						</div>\r\n					</div>\r\n					<div class=\"layui-row block-content\">\r\n						<table id=\"todo_task\" lay-filter=\"test\"></table>\r\n					</div>\r\n				</div>', null, null, null);

-- ----------------------------
-- Table structure for iot_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_authority`;
CREATE TABLE `iot_user_authority` (
  `AUTID` varchar(32) COLLATE utf8_bin NOT NULL,
  `RESOURCEID` varchar(32) COLLATE utf8_bin NOT NULL,
  `TYPE` int(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `NOTE` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REMARK1` int(6) DEFAULT '0',
  PRIMARY KEY (`AUTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of iot_user_authority
-- ----------------------------
INSERT INTO `iot_user_authority` VALUES ('17860DB8B2104ACF8841C5F8F50C63AF', 'E91D33C0DF774C44A5A29DBC84284E9B', '1', '标准制度权限', '标准制度权限', '0');
INSERT INTO `iot_user_authority` VALUES ('1F57A2A664A44B6C8E4F83BF9F4A69A8', '9F54726210C34817AB0F9C65FC06633B', '1', '净化巡检记录权限', '净化巡检记录权限', '0');
INSERT INTO `iot_user_authority` VALUES ('2CBCEDCFEAD141FBA5ABEA191542BCF4', 'FF4F4BDD78BC47E89E8AC9B209BD17F5', '0', '物资管理权限', '物资管理权限', null);
INSERT INTO `iot_user_authority` VALUES ('2E1E4988F0134CAF97A7661A8D69B441', '3FC3390E83164920A6A13F0605472C01', '1', '工厂概况权限', '工厂概况权限', '0');
INSERT INTO `iot_user_authority` VALUES ('3881195AC75A45CE9C19B91DDC33A46B', '91D15A63917A40D5BCF8C54DDD26D7D1', '1', '可编辑主页权限', '可编辑主页权限', '0');
INSERT INTO `iot_user_authority` VALUES ('3A237E23E84C4EE2BBFA61A6294EB91B', 'AEE92EC28925440CA2A54B5E7AE050BF', '1', '物资台帐权限', '物资台帐权限', '0');
INSERT INTO `iot_user_authority` VALUES ('3BF679B48DDA4E0685A9AFE95EB1B5A1', 'AADAC4B985564F88BE582563D6A9CAFA', '1', '闭环管理权限', '闭环管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('3C4BE8D4F53146F08967AAC2B958F368', '56B746DEA0E64E9099F423DE84F05631', '1', '例行作业查看权限', '例行作业查看权限', '0');
INSERT INTO `iot_user_authority` VALUES ('4519C01351774685A31AF3C1E68075AD', '17413252328C4B478D929B173C6083E1', '1', '维修巡检跟踪权限', '维修巡检跟踪权限', '0');
INSERT INTO `iot_user_authority` VALUES ('45C44F5E60E743708102975D347BF3AB', 'F09DCF032B91414B9BF6C95DC9551C21', '1', '工厂设计权限', '工厂设计权限', '0');
INSERT INTO `iot_user_authority` VALUES ('519E1128561E4DDD8729336CFB1DCDDD', '959CB4F21D9F4114A56DE132BC45CCCF', '1', '巡检项目管理权限', '巡检项目管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('556521B20CC34288AFA035830B40C585', '3DAC250EADB145678AE7E194C081EBDE', '0', '巡检管理权限', '巡检管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('55CB8A259F8746C0BE0EB62A9C371695', '152850932ACC4684850547A98ABD75FA', '0', '巡检跟踪权限', '巡检跟踪权限', '0');
INSERT INTO `iot_user_authority` VALUES ('5874479DE37B404B8A17DEB0E77C7334', 'BE927FDB323446669B7B8D7AC6C2FB76', '1', '电子巡检权限', '电子巡检权限', '0');
INSERT INTO `iot_user_authority` VALUES ('5899DDE9F0F24235AC4C6440DF1C0305', '514BB32D98524838A29B1442CE5534BF', '0', '日常工作权限', '日常工作权限', '0');
INSERT INTO `iot_user_authority` VALUES ('5E12A0E28A7644EBA9096FAFCA0C4753', '050737172BAD40448C6DAD27C3ED68F1', '1', '基础管理权限', '基础管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('5FA71EF0D9614B8F87169A419223267F', 'B90A831896C8431DA05AA7518FCB34CF', '1', '系统通知权限', '系统通知权限', '0');
INSERT INTO `iot_user_authority` VALUES ('633C1A63DBF4440BBF72308C3EBAB9C0', '4A170539865547C1A08A5393D74DD710', '1', '角色管理权限', '角色管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('6CCAEEC9592D450FB419C60244DB0805', '0782BD45F8C44324A1650E25F4D9F3B8', '1', '问题上报权限', '问题上报权限', '0');
INSERT INTO `iot_user_authority` VALUES ('6E322F20C349488BB2F3F8094615C593', '6BC47537062B45FD922A2ED47862F15B', '1', '能耗分析权限', '能耗分析权限', '0');
INSERT INTO `iot_user_authority` VALUES ('6E5D5C4FDDBE449391F01CFA3A5D8ECE', '2E6AA441D0AD4C208EF8C4EECF050599', '1', '技术改造权限', '技术改造权限', '0');
INSERT INTO `iot_user_authority` VALUES ('7232128C04DE4A7BAEE939D17FD55968', 'DEFB6A4DAAE34937A72189CAD24CDED2', '0', '日常任务管理权限', '日常任务管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('7CBEC12EA2014DBD980DA76579BE5131', 'FCCEE87401AE477097D5A389030AF796', '1', '物资出库管理权限', '物资出库管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('90C5C82503F94F2CA5FF5CF95BD0B3A5', '8370370C4CEB407C96E698A6EECF8E38', '1', '用户管理权限', '用户管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('9164CF7AEFEC4A98A898367611665BF9', '0658057EA1FA45008627DD36A3F3E5AC', '1', '巡检计划管理权限', '巡检计划管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('96FDE28CDE3847419E99BEF69B3A7201', 'E0C7DE45F44546998392D54762235A42', '1', '模块菜单管理权限', '模块菜单管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('A490BC5F3D2245CCBB77722FC96C5B6B', '4FAB43D6B15A490780F74B7FD5740D33', '1', '临时任务查看权限', '临时任务查看权限', '0');
INSERT INTO `iot_user_authority` VALUES ('A89E73010B5B4D4F8601B4E871BAA482', '3F3FFD75CC3449F19605D6D90186050E', '0', '系统管理权限', '系统管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('B121EE0BEA804DB29687458B6E4AA122', 'EF9C8CDEAF1342969AF6CEB6E5DE471F', '1', '巡检点管理权限', '巡检点管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('B15A985E1B684635BDDA643B77F6AD31', 'D32B4E59F72F4B4C94F127C7D3449663', '1', '主页权限', '主页权限', '0');
INSERT INTO `iot_user_authority` VALUES ('B6E122E8C4F44A5187307662C52BA9A3', '70562CD60E8243BAAA1FDAB12CCFA0A6', '1', '事故事件权限', '事故事件权限', '0');
INSERT INTO `iot_user_authority` VALUES ('B8CE4CE2F7014D0CB5E7A2EC49978992', '4B1AEF7A79B5463388F450CCE432D088', '1', '设备台帐权限', '设备台帐权限', '0');
INSERT INTO `iot_user_authority` VALUES ('BDCD2E0BCBDA4C1E9CFFDD42C2A8EDF6', '137EF2537F574885B9FBFFC4A587F6EE', '1', '维修巡检记录权限', '维修巡检记录权限', '0');
INSERT INTO `iot_user_authority` VALUES ('CC32DD5ECE23438783EA710CCFFD1F7B', 'F7369BBF670146D3A00EA75C68BC676D', '1', '操作卡管理权限', '操作卡管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('CEF98E00485A4115965378E484D1AB08', '839871C32F6246CF870E429868AD336C', '1', '权限管理权限', '权限管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('D0DC8FD88A2E42519FA8AF159211517A', '013D025F2EC64DC58AC1EA478D0A370E', '1', '净化巡检跟踪权限', '净化巡检跟踪权限', '0');
INSERT INTO `iot_user_authority` VALUES ('E6155B9B62C54A988F14ECF18014575C', '389B908727F0492D934F1F6B0A13C2FB', '0', '巡检记录权限', '巡检记录权限', '0');
INSERT INTO `iot_user_authority` VALUES ('E72E0471CB7E45F0A2D100126A2889AA', '31A3B50A946C484CA1CC45AD11981842', '1', '问题跟踪权限', '问题跟踪权限', '0');
INSERT INTO `iot_user_authority` VALUES ('EBA8565379D34B0EA021660B1DB8F32F', '617222526C6042ABA6F901C7202F2703', '1', '组织管理权限', '组织管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('F2A1B1FEDFA740E2A9F58D2CDBFB6695', '289B42A6A3BF4348BD038DB2B8394E09', '1', '临时任务管理权限', '临时任务管理权限', '0');
INSERT INTO `iot_user_authority` VALUES ('F8F90671DEF54CB49F0AF3A4777BF5E1', 'AFD45F6A346347C4815ABDD23C4FFCE0', '1', '巡检方案管理权限', '巡检方案管理权限', '0');

-- ----------------------------
-- Table structure for iot_user_info
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_info`;
CREATE TABLE `iot_user_info` (
  `USERNUM` varchar(32) NOT NULL,
  `NNAME` varchar(16) NOT NULL DEFAULT ' ',
  `AGE` int(3) NOT NULL DEFAULT '0',
  `SEX` int(1) NOT NULL DEFAULT '0',
  `ADDRESS` varchar(256) NOT NULL DEFAULT ' ',
  `TELEPHONE` varchar(11) NOT NULL DEFAULT '0',
  `EMAIL` varchar(50) NOT NULL DEFAULT ' ',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NOTE` varchar(20) NOT NULL DEFAULT ' ',
  `REMARK1` int(6) DEFAULT NULL,
  `REMARK2` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`USERNUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_info
-- ----------------------------
INSERT INTO `iot_user_info` VALUES ('13', '孙尚香', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('234235', '净化一班', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('41', '亚瑟', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('42', '程咬金', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('5', '净化工段', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('51', '贾勇', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('6', '维修工段', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('8888888', 'test', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);
INSERT INTO `iot_user_info` VALUES ('请输入用户唯一编号', '净化一班', '0', '0', ' ', '0', ' ', '2019-10-21 13:40:24', '2019-10-21 13:40:24', ' ', null, null);

-- ----------------------------
-- Table structure for iot_user_module_resource
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_module_resource`;
CREATE TABLE `iot_user_module_resource` (
  `MODID` varchar(32) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `RESOURCE_DESCRIBE` varchar(255) NOT NULL DEFAULT '',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `REMARK1` varchar(8) DEFAULT NULL,
  `PARENT_ID` varchar(32) NOT NULL DEFAULT '-1',
  `IS_PARENT` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`MODID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_module_resource
-- ----------------------------
INSERT INTO `iot_user_module_resource` VALUES ('013D025F2EC64DC58AC1EA478D0A370E', '净化巡检跟踪', 'http://www.baidu.com', '净化巡检跟踪', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '311', '152850932ACC4684850547A98ABD75FA', '1');
INSERT INTO `iot_user_module_resource` VALUES ('050737172BAD40448C6DAD27C3ED68F1', '基础管理', ' ', '基础管理', '2019-10-21 13:38:32', '2019-10-21 13:38:32', '83', '3F3FFD75CC3449F19605D6D90186050E', '0');
INSERT INTO `iot_user_module_resource` VALUES ('0658057EA1FA45008627DD36A3F3E5AC', '巡检计划管理', 'http://192.168.18.22:10039/dynamicui/?UIID=07EA648E7983427CB30CFA075AA826B0', '巡检计划管理', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '814', '3DAC250EADB145678AE7E194C081EBDE', '1');
INSERT INTO `iot_user_module_resource` VALUES ('0782BD45F8C44324A1650E25F4D9F3B8', '问题上报', 'http://192.168.3.11:10238/iot_process/html/report.html', '问题上报', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '41', 'AADAC4B985564F88BE582563D6A9CAFA', '1');
INSERT INTO `iot_user_module_resource` VALUES ('137EF2537F574885B9FBFFC4A587F6EE', '维修巡检记录', 'http://www.baidu.com', '维修巡检记录', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '322', '389B908727F0492D934F1F6B0A13C2FB', '1');
INSERT INTO `iot_user_module_resource` VALUES ('152850932ACC4684850547A98ABD75FA', '巡检跟踪', null, '巡检跟踪', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '31', 'BE927FDB323446669B7B8D7AC6C2FB76', '0');
INSERT INTO `iot_user_module_resource` VALUES ('17413252328C4B478D929B173C6083E1', '维修巡检跟踪', 'http://www.baidu.com', '维修巡检跟踪', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '312', '152850932ACC4684850547A98ABD75FA', '1');
INSERT INTO `iot_user_module_resource` VALUES ('289B42A6A3BF4348BD038DB2B8394E09', '临时任务管理', 'http://192.168.18.22:10039/dynamicui/?UIID=86A3DB81316D43D6BD48F6CF5514B394', '临时任务管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '822', 'DEFB6A4DAAE34937A72189CAD24CDED2', '0');
INSERT INTO `iot_user_module_resource` VALUES ('2E6AA441D0AD4C208EF8C4EECF050599', '技术改造', 'http://192.168.18.22:10039/dynamicui/?UIID=3EC5DF0FCCF4467C99AAF6A3D1299129', '技术改造', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '13', '35A0815EA52949A79EAF3176E077A854', '1');
INSERT INTO `iot_user_module_resource` VALUES ('31A3B50A946C484CA1CC45AD11981842', '问题跟踪', 'http://192.168.3.11:10039/CZ_PIOTMS/question_traking.html', '问题跟踪', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '42', 'AADAC4B985564F88BE582563D6A9CAFA', '1');
INSERT INTO `iot_user_module_resource` VALUES ('32F910FEE23B4AC79FDA425F71947406', '例行作业任务管理', 'http://192.168.18.22:10039/dynamicui/?UIID=F34307DF776F42B18511691C9DD95BE2', '例行作业任务管理', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '823', 'DEFB6A4DAAE34937A72189CAD24CDED2', '1');
INSERT INTO `iot_user_module_resource` VALUES ('35A0815EA52949A79EAF3176E077A854', '工厂概况', null, '工厂概况', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '1', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('389B908727F0492D934F1F6B0A13C2FB', '巡检记录', null, '巡检记录', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '32', 'BE927FDB323446669B7B8D7AC6C2FB76', '0');
INSERT INTO `iot_user_module_resource` VALUES ('3DAC250EADB145678AE7E194C081EBDE', '巡检管理', null, '巡检管理', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '81', '3F3FFD75CC3449F19605D6D90186050E', '0');
INSERT INTO `iot_user_module_resource` VALUES ('3F3FFD75CC3449F19605D6D90186050E', '系统管理', null, '系统管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '8', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('3FC3390E83164920A6A13F0605472C01', '工厂概况', 'http://192.168.18.22:10039/CZ_PIOTMS/test01.html', '工厂概况', '2019-10-21 13:38:32', '2019-10-21 13:38:32', '12', '35A0815EA52949A79EAF3176E077A854', '1');
INSERT INTO `iot_user_module_resource` VALUES ('4A170539865547C1A08A5393D74DD710', '角色管理', '/iot_usermanager/html/userCenter/user_role.html', '角色管理', '2019-10-21 13:38:31', '2019-10-21 13:38:31', '833', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('4B1AEF7A79B5463388F450CCE432D088', '设备台帐', 'http://192.168.18.22:10039/CZ_PIOTMS/equipmentManage.html', '设备台帐', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '2', '-1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('4FAB43D6B15A490780F74B7FD5740D33', '临时任务查看', 'http://www.baidu.com', '临时任务查看', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '51', '514BB32D98524838A29B1442CE5534BF', '1');
INSERT INTO `iot_user_module_resource` VALUES ('514BB32D98524838A29B1442CE5534BF', '日常工作', null, '日常工作', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '5', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('56B746DEA0E64E9099F423DE84F05631', '例行作业查看', 'http://www.baidu.com', '例行作业查看', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '52', '514BB32D98524838A29B1442CE5534BF', '1');
INSERT INTO `iot_user_module_resource` VALUES ('617222526C6042ABA6F901C7202F2703', '组织管理', '/iot_usermanager/html/userCenter/organManager.html', '用户组织管理', '2019-10-21 13:38:31', '2019-10-21 13:38:31', '831', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('6BC47537062B45FD922A2ED47862F15B', '能耗分析', 'https://www.baidu.com', '能耗分析', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '7', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('70562CD60E8243BAAA1FDAB12CCFA0A6', '事故事件', 'http://192.168.3.11:10238/iot_usermanager/html/userCenter/test.html', '事故事件', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '43', 'AADAC4B985564F88BE582563D6A9CAFA', '1');
INSERT INTO `iot_user_module_resource` VALUES ('8370370C4CEB407C96E698A6EECF8E38', '用户管理', '/iot_usermanager/html/userCenter/userManager.html', '用户管理', '2019-10-21 13:38:32', '2019-10-21 13:38:32', '836', '050737172BAD40448C6DAD27C3ED68F1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('839871C32F6246CF870E429868AD336C', '权限管理', '/iot_usermanager/html/userCenter/authority_list.html', '权限管理', '2019-10-21 13:38:31', '2019-10-21 13:38:31', '834', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('91D15A63917A40D5BCF8C54DDD26D7D1', '可编辑主页', '/iot_usermanager/index/index_edit.html', '可编辑首页', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '837', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('959CB4F21D9F4114A56DE132BC45CCCF', '巡检项目管理', 'http://192.168.18.22:10039/dynamicui/?UIID=6DA00BE280514F26BD0308EFAF48D51B', '巡检项目管理', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '811', '3DAC250EADB145678AE7E194C081EBDE', '0');
INSERT INTO `iot_user_module_resource` VALUES ('9F54726210C34817AB0F9C65FC06633B', '净化巡检记录', 'http://www.baidu.com', '净化巡检记录', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '321', '389B908727F0492D934F1F6B0A13C2FB', '1');
INSERT INTO `iot_user_module_resource` VALUES ('AADAC4B985564F88BE582563D6A9CAFA', '闭环管理', '闭环管理', '闭环管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '4', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('AEE92EC28925440CA2A54B5E7AE050BF', '物资台帐', 'http://www.baidu.com', '物资台帐', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '61', 'FF4F4BDD78BC47E89E8AC9B209BD17F5', '1');
INSERT INTO `iot_user_module_resource` VALUES ('AFD45F6A346347C4815ABDD23C4FFCE0', '巡检方案管理', 'http://192.168.18.22:10039/dynamicui/?UIID=scheme_point', '巡检方案管理', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '813', '3DAC250EADB145678AE7E194C081EBDE', '1');
INSERT INTO `iot_user_module_resource` VALUES ('B90A831896C8431DA05AA7518FCB34CF', '系统通知', '/iot_usermanager/html/userCenter/notice.html', '系统通知', '2019-10-21 13:38:32', '2019-10-21 13:38:32', '835', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('BE927FDB323446669B7B8D7AC6C2FB76', '电子巡检', ' ', '电子巡检', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '3', '-1', '0');
INSERT INTO `iot_user_module_resource` VALUES ('D32B4E59F72F4B4C94F127C7D3449663', '主页', 'http://localhost:10238/iot_usermanager/index/index.html', '主页', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '0', '-1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('DEFB6A4DAAE34937A72189CAD24CDED2', '日常任务管理', null, '日常任务管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '82', '3F3FFD75CC3449F19605D6D90186050E', '0');
INSERT INTO `iot_user_module_resource` VALUES ('E0C7DE45F44546998392D54762235A42', '模块菜单管理', '/iot_usermanager/html/userCenter/resource_list.html', '模块菜单管理', '2019-10-21 13:38:31', '2019-10-21 13:38:31', '832', '050737172BAD40448C6DAD27C3ED68F1', '1');
INSERT INTO `iot_user_module_resource` VALUES ('E91D33C0DF774C44A5A29DBC84284E9B', '标准制度', 'http://www.baidu.com', '标准制度', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '14', '35A0815EA52949A79EAF3176E077A854', '1');
INSERT INTO `iot_user_module_resource` VALUES ('EAFD780C2E62419A9058B35FC0B18CD6', '例行作业计划管理', 'http://192.168.18.22:10039/dynamicui/?UIID=AF4A96BC58CA4852A039C7654BFA95BC', '例行作业计划管理', '2019-10-21 13:37:21', '2019-10-21 13:37:21', '824', 'DEFB6A4DAAE34937A72189CAD24CDED2', '1');
INSERT INTO `iot_user_module_resource` VALUES ('EF9C8CDEAF1342969AF6CEB6E5DE471F', '巡检点管理', 'http://192.168.18.22:10039/dynamicui/?UIID=points_contents', '巡检点管理', '2019-10-21 13:37:23', '2019-10-21 13:37:23', '812', '3DAC250EADB145678AE7E194C081EBDE', '1');
INSERT INTO `iot_user_module_resource` VALUES ('F09DCF032B91414B9BF6C95DC9551C21', '工厂设计', 'http://192.168.18.22:10039/dynamicui/?UIID=3EC5DF0FCCF4467C99AAF6A3D1299129', '工厂设计', '2019-10-21 13:38:32', '2019-10-21 13:38:32', '11', '35A0815EA52949A79EAF3176E077A854', '1');
INSERT INTO `iot_user_module_resource` VALUES ('F7369BBF670146D3A00EA75C68BC676D', '操作卡管理', 'http://192.168.18.22:10039/dynamicui/?UIID=98198038FCAB4B96991D11D9565CE771', '操作卡管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '821', 'DEFB6A4DAAE34937A72189CAD24CDED2', '0');
INSERT INTO `iot_user_module_resource` VALUES ('FCCEE87401AE477097D5A389030AF796', '物资出库管理', 'https://www.baidu.com', '物资出库管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '62', 'FF4F4BDD78BC47E89E8AC9B209BD17F5', '1');
INSERT INTO `iot_user_module_resource` VALUES ('FF4F4BDD78BC47E89E8AC9B209BD17F5', '物资管理', null, '物资管理', '2019-10-21 13:37:22', '2019-10-21 13:37:22', '6', '-1', '0');

-- ----------------------------
-- Table structure for iot_user_operation_resource
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_operation_resource`;
CREATE TABLE `iot_user_operation_resource` (
  `OPE_ID` varchar(32) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `RESOURCE_DESCRIBE` varchar(100) NOT NULL DEFAULT '',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `REMARK1` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`OPE_ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_operation_resource
-- ----------------------------

-- ----------------------------
-- Table structure for iot_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_organization`;
CREATE TABLE `iot_user_organization` (
  `ORGID` varchar(32) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL,
  `USERNUM` varchar(32) NOT NULL,
  `USER_PASSWORD` varchar(18) NOT NULL DEFAULT '123',
  `STATE` int(1) NOT NULL DEFAULT '0',
  `IS_PARENT` int(1) NOT NULL DEFAULT '0',
  `NOTE` varchar(100) NOT NULL DEFAULT ' ',
  `REMARK1` int(6) DEFAULT '0',
  `REMARK2` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ORGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_organization
-- ----------------------------
INSERT INTO `iot_user_organization` VALUES ('0158831AB7914A8F8021B14015238A25', '严莉', '净化2班', '严莉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('01E8CBF167E44240944AB028E60594D1', '江婷婷', '净化2班', '江婷婷', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('022D59663E0943A0A1E6EDF397C7F5B0', '刘进', '维修工段', '刘进', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('039B5FC430324E9C874F26886720E075', '杨帆', '行政班', '杨帆', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('05D6EB8B9BDA41389893788E36ABFBE0', '欧雪松', '净化1班', '欧雪松', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0693914CA30A4A9DA20E4F42EB660138', '周翔', '厂领导', '周翔', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('082FDE3CCA6D4508969F2ACBB3FA3F08', '黄春强', '净化4班', '黄春强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('085644779AE1497A80924B8394BBEAFB', '宋永武', '净化3班', '宋永武', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('089E8E4C153543FAAD769DFDC558E8EE', '维修班', '维修工段', '维修班', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('08B050FA5E2E439286BA5F8BF7734EF8', '郑植', '净化3班', '郑植', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('08F77A145AE34B899EA9423CF553C4A2', '厂领导', '办公室', '厂领导', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('090C160AAAF54840AF3F7702A7AF52F1', '李化', '净化2班', '李化', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0957F5F5A3124588A66817F63E3FDBD2', '财务经营办', '龙王庙天然气净化厂', '财务经营办', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0A8FBB98D1C04FD0AD9DF16379E6230D', '杨正刚', '维修工段', '杨正刚', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0AF47BCFB26845AEB09BBE7FAE1484EE', '杨添吉', '分析班', '杨添吉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0DA6724A6244418DBFF5379A60E52534', '袁聪', '净化2班', '袁聪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0E496A28A5554B55ACD9EC50BC5DE2CC', '谭仪川', '钳工班', '谭仪川', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('0FE347ED622C42418D1AD01459546784', '冯剑', '净化2班', '冯剑', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1', '张云光', '设备办公室', '张云光', '123456', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('107CF7E03FE040BBB0F6857BF85C3EA1', '刘建', '净化2班', '刘建', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('11111111111111111111', '综合办', '龙王庙天然气净化厂', '综合办', '123456', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1111111111111111111111', '龙王庙天然气净化厂', null, '龙王庙天然气净化厂', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('119DEAB7F4934436823F4916EE7BF123', '汪茂宇', '净化1班', '汪茂宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('123F51161AAC4E868F257AF9468CF583', '班寒梅', '厂领导', '班寒梅', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('131609286EF34D51B491BDA00E79CE50', '李亚', '综合办', '李亚', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1366E0CCBB4A4C999F635D6B87D6E95B', '办公室', '龙王庙天然气净化厂', '办公室', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1445188D298142228CAD18F11C282537', '叶华伦', '厂领导', '叶华伦', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1454DC28F3184E979C6DC154084DA17A', '李娟', '分析班', '李娟', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('14C5EFE2A40C4F558EAC2E299306E419', '江梦菲', '财务经营办', '江梦菲', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('163214D2D4DB4BE1A5B330E39EB67279', '谭治文', '电站', '谭治文', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('176D19B5AD0F48E0953CBF662372E757', '吕琳', '生产办公室', '吕琳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('193724D9BCAF46CCA44253BC56DB67EE', '王雪郦', '净化2班', '王雪郦', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1B0A8E1BC04C4F4FB035BE27797D4044', '鲜琪', '净化2班', '鲜琪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1D4E0D2E624E4D1F8302DD40719CFE3D', '邵强', '综合办', '邵强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('1E5A7F29052242709944B1B81119162F', '赖津剑', '净化1班', '赖津剑', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('20D64A1AB0194E64B9DD0135CBD3E105', '邓欣', '行政班', '邓欣', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('20DD79A3A44E41C6A6374B2DFE9DEAF0', '仪表班', '维修工段', '仪表班', '123', '0', '0', '组织', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2199DDC2F2BA4AF3B4EED71EC7328569', '曾文革', '厂领导', '曾文革', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('21BDAFC9076A4E5EB73177E0CC1FF9D1', '黄昱恺', '仪表班', '黄昱恺', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('22A05C3CC6344286A7756151B2BACC44', '杜成丽', '行政班', '杜成丽', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('22A8BD84DAAF4CC0957303C14DDFC604', '杨斌', '仪表班', '杨斌', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2418E364A6604E3F8F2037C1B6DBA8F1', '杨洋', '净化3班', '杨洋', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('25424D3B88EB4E61B26FC6B46D079CBF', '张番', '净化3班', '张番', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('25D73A64042F48039514B69397B8187C', '陈文武', '钳工班', '陈文武', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('260824CE2D59454E85A985E04DF21A20', '刘川', '净化3班', '刘川', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('267AD149D992445E997A3F77228E9B2D', '胡江龙', '管焊班', '胡江龙', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('272E62A1D73F41FC94CC1379277378AF', '蔡莉', '净化2班', '蔡莉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('27CFCE5BF0C144F4973100E34381A7FD', '周珂', '财务经营办', '周珂', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('292077AD8C994DC2A2ECE02358A93F93', '黄春霖', '净化1班', '黄春霖', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('297793FAFF494E378C22C2785DF5FCDF', 'HSE办公室', '龙王庙天然气净化厂', 'HSE办公室', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2A62ADA4B6BD4095B3C7D0D13957D5BA', '刘丽', '分析班', '刘丽', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2B2B35558C134DEB9A43B64656D8FCDC', '贾涌泉', '净化4班', '贾涌泉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2B32F08DCCDD44B9A4366F564D518B13', '石崇磊', '净化1班', '石崇磊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2B709E1BA03446149768F1CC47D941D1', '伍勇', '维修班', '伍勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2C178F9615284FCEBD5D9F7BAE19FC44', '李渝', '厂领导', '李渝', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2DCBB40608F747958C4598971447FEE1', '陈波', '维修班', '陈波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2E83DAC378294C46984CE78ED91AC223', '邓宝琴', '净化1班', '邓宝琴', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2F06EE0387D3457DA528CCEBB6FE5880', '蒋波', '净化4班', '蒋波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2F2E7B3B2D144FCD81DE892B15857AA6', '李婧逸', '净化2班', '李婧逸', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('2FC3B1E39FA5418CAA0B5FBD596E9E09', '刘俊烨', '净化1班', '刘俊烨', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('310FDCE825B644E3BDEED3F7E6E8950C', '许小飞', '净化4班', '许小飞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3210F11D519A4BB2BECBF101A3EF1091', '田媛', '净化2班', '田媛', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('323E8920EFA94211A768EAA38ED309F8', '黄世伟', '设备办公室', '黄世伟', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('32C39BEA9F3945B69C4B457ECABBCD02', '陈强', '综合办', '陈强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('32EC41FC97BE4C8A975B9E339DF61D09', '田佳巧', '净化1班', '田佳巧', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3332AEBBEF954937801C9B439A1C7CF4', '邓磊', '净化1班', '邓磊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('336BB2961B304061BF780B34CA70B4F4', '黄蓉', '生产办公室', '黄蓉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('34CD8FD485AD46AAA5664E82C87FEEEE', '谈艺', '净化3班', '谈艺', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('363156BF5ACB4F4D8099E08C1ACEE2B9', '唐晓友', '电站', '唐晓友', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('364E5AE343F7477084B7AB2E44B6814A', '刘顺吉', '净化2班', '刘顺吉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('36B44ECEB05A4A1C9E15BD1CD4C1D1B4', '李治平', '净化3班', '李治平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('36FEE83EF989442C85BDC700FFAB0CF8', '代庆松', '净化1班', '代庆松', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('378B9BAEF1194B03B206A39A9ECAA87A', '杨勇', '电站', '杨勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('37FD951F5B784751B9FD5B99EF16D252', '邓娟', '净化4班', '邓娟', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('38E2BC8B12AC4CB492C575F7053BD0AF', '孙超', '净化4班', '孙超', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('398A967FEAE74620B217E352009CAEF2', '唐敏', '净化1班', '唐敏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('39F10FCEAD7648A484194EC79E9CBAA5', '刘儒成', '净化3班', '刘儒成', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3A2087F2E40849C39F9530B45149C849', '钟媚', '净化2班', '钟媚', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3A7965270769460B8F4B890F0DB087D3', '林筱', '分析班', '林筱', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3AA44DA680994B8CA463ED688DCF708A', '张勇', '净化2班', '张勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3AF702E1868A4EDC923624970328B894', '王敏', '行政班', '王敏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3B868F1F7DD54939A9A2C6DC0F54F843', '王洪东', '仪表班', '王洪东', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3C8D39B088F94633ABC6B904B9874D00', '王波', '净化3班', '王波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3D4D6E6F3F5A4656835EA842043F3156', '周蕙云', '财务经营办', '周蕙云', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3E0CB9E083174BDABC1188C0E1240CF1', '王琪', '仪表班', '王琪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3E17BA2F2ECD413A8DD5127E298D9899', '罗英', '净化4班', '罗英', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3E97D600E1C24AC787A67F23E53FCBD0', '王晨', '净化2班', '王晨', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3F3F5CB79DAC4FF39450AD6489818F23', '周鸣', '综合办', '周鸣', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3FC6893E29AE40B5A9F2207C5CEEC883', '罗均', '净化4班', '罗均', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('3FE3169F46024BAD92DD4FF2BA30207E', '吕琳', '设备办公室', '吕琳', '123456', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('407118FDE41845F0B79225E12057DDA0', '杨松', '净化3班', '杨松', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('411D1B460C934BC782C9ABD9CE60AA6F', '祝小淞', '净化1班', '祝小淞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('412BC813207E4A36B4B8C5D417F72C17', '冯志伟', '净化4班', '冯志伟', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('41947E6D15D54E498F14A1CFFDA93F2C', '余虹钢', '行政班', '余虹钢', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('41E9FCCB31B54E14A61AC0A793E66C7A', '李春林', '净化4班', '李春林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('43ABBA15747D401FAADC465F4AA351FF', '赵俊宸', '净化2班', '赵俊宸', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('43E2F72B012C4DC998C91A401B6DD638', '何军', '综合办', '何军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4418B922DACE41E98A69EE524D60414D', '曹雪梨', '分析班', '曹雪梨', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4474143B4BEE42A9A7935DEFCD6D335F', '曾祥胜', '净化2班', '曾祥胜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('448D0822577D4CB3897BD0124E125063', '颜萍', '财务经营办', '颜萍', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4547AFA1C23144EDBF283F78A07B1C79', '魏晓燕', '仪表班', '魏晓燕', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('45940588646F4B73B846BB26B100463F', '周超', '净化1班', '周超', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('466634175FDB4A7287F39ACD1A7070A4', '杨柳', '净化4班', '杨柳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('46CB69639DE54548A1681061DBD9011F', '吴思静', '净化4班', '吴思静', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('47389544F0534F8FAC5FCC29FB29E15F', '刘倩', '净化1班', '刘倩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('48A41E1F4D0A43AF88692B7C8EEBBB9A', '易俊希', '净化1班', '易俊希', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4B1ADAC46D5344F7BA43E181BAF34FD9', '周景', '行政班', '周景', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4BA72D6EB23E4EDEAA14C71CD0361817', '杨铁林', '厂领导', '杨铁林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4BCF823405244311B12BA3E7AE7B94E7', '查先德', '净化4班', '查先德', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4CAC7CA6F5074CA082FBEF4A0BA644BD', '张旭', '净化4班', '张旭', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4D632D85A48E40C595E9F056FF50C6C9', '陈辅佳', '净化2班', '陈辅佳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4D8889A333E845F39CAD3AA0F41C0143', '傅澜珊', '分析班', '傅澜珊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4E7CC5D06DBE4F6F8B897FC28340BCD1', '金志明', '钳工班', '金志明', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('4FB5D3B86B47401BAF9D95480D12518D', '龙海涛', '净化3班', '龙海涛', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('510BE1662D4F46F7AA473317B0D456F7', '王海艳', '电站', '王海艳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('512DF424A91B4251A9BFF878053E76F7', '胡洋', '净化4班', '胡洋', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5197EEF481934C23A41C3F576189BD4F', '曾玉', '行政班', '曾玉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5204F4EE06C94A9E9C3BC3E4FD708D67', '杨旭帆', '净化2班', '杨旭帆', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('521922A4D6BD448CB543CE472806FBA3', '向锋', '净化1班', '向锋', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('52AD36B9F4074254B8CEBD606DA1C513', '肖舒芳', '净化4班', '肖舒芳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('536E1107F3C74D7FBDAE1C9DCB960582', '钟艾明', '电站', '钟艾明', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('53758955A2344B2F9BB2B9431DB5B4F0', '吴楠', '净化4班', '吴楠', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5550193525554149909856AECC18A580', '汪俊峰', '净化2班', '汪俊峰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('56463994060C4FC5A7C26FE0B3714DE4', '李云志', '净化4班', '李云志', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('56ABB26A4F5342A086033125E0AF1127', '杨玉平', '净化3班', '杨玉平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('57B763AB9DF24D55BA81C344AEE0022D', '李长治', '净化3班', '李长治', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('57E1B0379F284E1AB507FAA00DA8A2BE', '谢跃军', '净化1班', '谢跃军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5851EBD4D04740D7BD75BA478CB9BA7D', '张成武', '净化1班', '张成武', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('59291157A14341BE831CEB97834D0ED3', '王成宇', '净化1班', '王成宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('596652E1A4084D4D9B569D7C72C5E804', '曹杰', '生产办公室', '曹杰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('59673E26CB53482B92F1757AB62D28C7', '赵宇', '综合办', '赵宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('59AA007095B34EC49C67185279355835', '周传宇', '净化4班', '周传宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5ACA22D740CF432DB2EDBE863109ED75', '苟列生', 'HSE办公室', '苟列生', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5BBD339EE7C44DC086F10516FAE8903E', '张谢婉', '分析班', '张谢婉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5E0D35E654C14FB4927627167687D05C', '蒋薇遥', '净化1班', '蒋薇遥', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5EA66DAA9ED74A50A16A30AE853DE05B', '李太辉', '仪表班', '李太辉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('5F5F20176436465896746BF4DD98165D', '青龙飞', '净化4班', '青龙飞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6072324E8AC245139407CD0B4BA68BE1', '雷晓辉', '综合办', '雷晓辉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('60DBD982D55D4963955C718F70A444F6', '李健', '分析班', '李健', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('60FA929E483B483D9081627BFD3D6FB4', '秦胡兰', '综合办', '秦胡兰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('64587D1DDB594E519566060707157045', '岳志坚', '维修工段', '岳志坚', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6491551710F143D6B0D638621040BBFC', '田容姝', '净化3班', '田容姝', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6493473CBF7348C8AF5B1B32EF62FB3D', '梁万洪', '净化3班', '梁万洪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('64BA314247BD44BCACC90E859C33917C', '许峰', '净化1班', '许峰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6559852A52FB4A75B8BB868CB93CF78E', '周从兵', '分析班', '周从兵', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6726A97743074801B4F62C45F079C423', '张茂文', '电站', '张茂文', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6738FC9E4367455989E671952B2D4396', '余鑫浩', '净化2班', '余鑫浩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('687CA8E4E54B4FEA907D8D32612FE5FE', '熊丽莎', '电站', '熊丽莎', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('697936D296C740BDADD3273DF920881C', '吴静', '分析班', '吴静', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('69ED150048F94070AB7F9C19C21F8F92', '黄勇', '仪表班', '黄勇', '123456', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6B8114C43C1746509CEEB354BCF87F5B', '刘金欣', '净化1班', '刘金欣', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6BCBEBB1E48A404B8E63E790C731A0CB', '钟琴', '行政班', '钟琴', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6C22A199885C4206A55D58BEDEE25CA7', '黄世伟', '生产办公室', '黄世伟', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6C9185023C4643C5A3C0B07610DD5F17', '陈宁霞', '净化1班', '陈宁霞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6D3EE7912CF14FD3BC2DACE168504349', '张冯林', '仪表班', '张冯林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6EE5961054F24850ADDCA62DB7E4A3E4', '范彬', '净化1班', '范彬', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6F485D90FF164945B2DE8040ABE8600E', '李光华', '净化3班', '李光华', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('6F6A2550A00B483798E24139362F7422', '彭富强', '管焊班', '彭富强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('70741933106B47BCA9BE95A3689471AD', '段练', '厂领导', '段练', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('70761DE81F2D4A028C9E8960732FB43F', '李红芳', 'HSE办公室', '李红芳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7169B2E835064C499583C300DF832136', '申念东', '综合办', '申念东', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('727331B881E34D4E8D71AEC20937EFAB', '净化工段', '龙王庙天然气净化厂', '净化工段', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('733BAE0077E34CD5A7B66081FB0EFC87', '陈万均', '电站', '陈万均', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('73CD8517E1BA45B7BA70813DE057DF31', '伍治源', '行政班', '伍治源', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('74D5E76697E040C4A3644FEEEE41D9A8', '蒲发勇', '财务经营办', '蒲发勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7563A157994C4760A772E7A363CAC07A', '陈晏羽', '净化1班', '陈晏羽', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('75D6040D46514E96B8007D04376B0C39', '杨贤', '行政班', '杨贤', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('783FD6050C3E44FFA4A1938E70F8D86C', '熊柳', '分析班', '熊柳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('784051E63E334009BDE111A8ED499C75', '邓雷', '净化4班', '邓雷', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('79F2374D7FA9419BBAD0C3652F04A163', '蒲军', '净化4班', '蒲军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7A6DFD7D31454FFAA7BD298B0BBC3207', '李跃平', '厂领导', '李跃平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7B0870B7857848E4A984B92391CF5CDB', '维修工段', '龙王庙天然气净化厂', '维修工段', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7B1E398D94C64C3CB3BCEDAB2496C4E0', '李奇聪', '净化4班', '李奇聪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7B73EA69EB7143118BE7E9930BD9DDF7', '梁革', '行政班', '梁革', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7BC7DDABB4294527A12B32BD733F530D', '周琦', '净化3班', '周琦', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7BCE5CD139C14EF29409020BCB5E8B42', '罗娜', '净化4班', '罗娜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7C018F46571640C8AF6D27D4145EA1CF', '曾星', '净化1班', '曾星', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7C646BBA385C49E99A3837FF63A53896', '彭浩洋', '电站', '彭浩洋', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7D66968CDD84400A9B5D649696A1B201', '张雪', '净化4班', '张雪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7DEE2BA038F64FEBB634E86DADCA44FF', '刘海', '净化4班', '刘海', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7F1F33755EC543458426D0B01C5448D4', '张秋林', 'HSE办公室', '张秋林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('7F49BE4A3BE84BFEBFBF34ADF9803907', '分析班', '净化工段', '分析班', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('817046D03ED2421B963030523361ACA4', '曾凡辉', '管焊班', '曾凡辉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('822353E35B224BC4A28E840E0CC5A19F', '邓尚渝', '钳工班', '邓尚渝', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('826E5E8EBB3C43F4AAB4436629FFC24D', '周小林', '净化3班', '周小林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('82A0BC6D97E04E4FB60D170AE4FFB9D2', '余静雯', '净化1班', '余静雯', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('82D0414F0BDA4E2983AE5D45780D5ADA', '余波', '电站', '余波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('839499B8427043C3B54925E3235F6E54', '吴晓勇', '净化3班', '吴晓勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('865B486773A845F09DE03513B29D2246', '胥树泉', '净化4班', '胥树泉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8683AA677A3A48B8B5A2D86BB039A62A', '伍世平', '分析班', '伍世平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('87125ED4B9EC4031BF0425801981BAB7', '廖婉媚', '厂领导', '廖婉媚', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('87D5FAD2D0124C2B91DF5AF017861FBF', '胡宗煜', '净化4班', '胡宗煜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('885AC07AACC84270B0069D4A13DBFA31', '唐滔', '净化4班', '唐滔', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('88EA3A1D954B4D1C99DDCBC1AD6EB9A0', '刘琴1', '净化1班', '刘琴1', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8A510B34B2D148F4B8FA1A199A7DA3A9', '陈涛', '净化3班', '陈涛', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8A6477EEB01B4BBAA16ACDE978A33617', '何世强', '净化2班', '何世强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8C318FF061CA43B4B41169A1ABB4B054', '欧祖君', '综合办', '欧祖君', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8D70451870DE41FC8165E631AC14AAF3', '净化1班', '净化工段', '净化1班', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8E47B31F00534707A1B66DD06C13E3ED', '生产办公室', '龙王庙天然气净化厂', '生产办公室', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('8EBFBDA960CE452DB5053E8A0D84E085', '王志强', '净化2班', '王志强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('908B22FD053846FE9D5462AD20D8EE96', '王霜', '净化4班', '王霜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('932CE47597A441B88C02124E3C1CD99A', '岳梦莹', '分析班', '岳梦莹', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('93BAE78CEA024B1CB6872F3476F193BC', '赵夏云', '净化3班', '赵夏云', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('95A502D68D494359A11116B1DCE03F76', '黄浩', '净化4班', '黄浩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('95A698758A7041D8A48E81A58F61E95D', '杨庆', '维修班', '杨庆', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('963542856CBA445D8F0F4A02A1E590D8', '唐远志', '净化3班', '唐远志', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('96B7721C7D2441F795A5B021EBA1CC1F', '许宏霞', '净化4班', '许宏霞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('973EF97CFDE64AB7B45138EA945F729E', '孙擎天', '净化4班', '孙擎天', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('993EC570507F4DFDB506DE190807D040', '江林玲', '净化3班', '江林玲', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('99D1DCD3040343F4939BA17F141166D8', '王晓艳', '净化3班', '王晓艳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('99D2F2599D9F406D821B3B3BF0308517', '吴雪春', '净化1班', '吴雪春', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9AAE3F42B6B8497EA4D314FEEC1049EF', '游胜', '电站', '游胜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9B4ED9BC0C4A4CA797C3D517C7B56E38', '甘露', '净化3班', '甘露', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9B504242D5FE4389BB8AB8D41A4CA270', '张栩瑶', '净化1班', '张栩瑶', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9BD0AE3651D5428B88CFC35207EBE766', '陈亮', '行政班', '陈亮', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9C026911654B40FBAD805141949443A4', '李镇材', '净化1班', '李镇材', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9C16850E731549E9865BA703F9281CAF', '李宣翔', '净化2班', '李宣翔', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9C303FDC432D403087C8A96C7C217D8F', '李春梅', '净化2班', '李春梅', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9DAF865BE91247F2BB175C76135C5180', '陈文丽', '电站', '陈文丽', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('9DE3C3BBB5D84014920B61675B223A2B', '李沈林', '净化3班', '李沈林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A0719D9622664032A3A48C600F4FCED9', '刘俊良', '净化4班', '刘俊良', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A2AB9133E17A4B89A98659D8AD17D0C6', '吴彦辰', '净化2班', '吴彦辰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A35B9DC443B14AC7B4F663E9B11969E3', '罗丹', '净化1班', '罗丹', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A45A42ECF56B43019BDC3D3F819C03AC', '田爱民', '净化2班', '田爱民', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A487D26F6451498C906E794984C8EA17', '鲜果', '净化1班', '鲜果', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A4E5A8F6FF164BDFBC3F91AE3C1B527F', '钟云', '行政班', '钟云', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A58C42269CD34A32BF9099794060F2BF', '薛泰和', '净化3班', '薛泰和', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A62B9C25B3FD4257AFDCC66FAD9CE24A', '林庆光', '钳工班', '林庆光', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('A6ADD1F6A5434E1A9800FF775C21130C', '陈念华', '管焊班', '陈念华', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AA323523208F491084C48D54B92DF29F', '李武辉', '净化3班', '李武辉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AAC284720FFD4EC5924422CFD9837589', '尹浩然', '净化1班', '尹浩然', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AB1247FD12394F9E82221368E2F8BBFB', '钟章剑', '净化1班', '钟章剑', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AB16EFCE38EE4367BBF2B40DD66D8731', '张海燕', '净化1班', '张海燕', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('ABC1A54264AD4B06B983FBE9A66223F4', '代超', '行政班', '代超', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('ABEB59EFF47244008996CF138A5E3C35', '刘琴', '净化3班', '刘琴', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AC23122FA7DB45FA9BE2ED3769A77137', '周孝胜', '厂领导', '周孝胜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AC5DF53A17B64B958B538F1706C76083', '张智超', '电站', '张智超', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AC6CFB6FB5724307B5D325B4EF0A134E', '黄娅', '行政班', '黄娅', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AD67A08DF4E148919AF213EAE7868449', '张黎', '净化3班', '张黎', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AD7AFEBAED0346D4A58BAF8828936AAD', '行政班', '净化工段', '行政班', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AD7B34ED1F1E42C59E3720FD8163AE61', '罗斌', '电站', '罗斌', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('AFC7E254CE78410A829C30915AF12243', '米夏', '分析班', '米夏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B05E16E5AAF9422A8D9E1181B51E94F7', '杨俊', '净化1班', '杨俊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B13D235E78AC48CB9D42D55279871112', '吴敏', '净化1班', '吴敏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B161F07EC4F54EFCB6EC5945E01E279F', '母小雪', '净化3班', '母小雪', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B2DBC020DD4545D4AF3FA9B566913F69', '张坤博', '净化3班', '张坤博', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B4981FCFFD55465AA8FECF6CAC3BF991', '陈兵', '综合办', '陈兵', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B5AC6855E1754F82AFDFFD4844C9D9DB', '贾勇', '行政班', '贾勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B605A24195CE4EAE8189529AF4C24D5E', '刘小渝', '净化4班', '刘小渝', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B64F0E637C284D908507A7BE0BA411DD', '陈庭', '分析班', '陈庭', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B6F49CD1A7CD4CB29965B83DD283473C', '吴韵秋', '厂领导', '吴韵秋', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B8E178BF990B447D8E799DDA094591C7', '刘勇', '净化3班', '刘勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('B91ECCF077D3442CB806AB0AB336856B', '向茂川', '净化2班', '向茂川', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BA155481728945B1A84DC585DB81C6EA', '尹亮', '电站', '尹亮', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BA29F39995E5472CAF4DCC5BE1048892', '康倩', '净化4班', '康倩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BAD30BBF988742849FF3FB28C3D6CE34', '郑兴', '钳工班', '郑兴', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BBC3ACFF372F4BAC82C7EAD76E2B7168', '杨俊妍', '净化1班', '杨俊妍', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BE8A9A1D492D4DCC8E6429649450771F', '张军', '净化4班', '张军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BF1059B402764544AA88718096AE66E0', '程威', '净化2班', '程威', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('BF5BB9221B6B4B9D85204238F36E6241', '袁胡', '净化1班', '袁胡', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C092F543B1684D6AB4DEAB7F2374AA8A', '程波', '综合办', '程波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C0E09C8234DA4F6DA3E619677F9414FE', '江山', '厂领导', '江山', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C11F69D5D3354E51A721C306DC0DC751', '周筱菁', '净化3班', '周筱菁', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C2828BB4D00D4D1186CAE21A69956CEA', '陈菊花', '净化4班', '陈菊花', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C2C3133A65F8437989224BFA4B115AB3', '李泳锡', '维修工段', '李泳锡', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C3C0B1090C7047A8AD968B22BCC59C1F', '孙钊', '净化3班', '孙钊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C3C1962F37F2437589303BEC75A18AD7', '李光有', '净化4班', '李光有', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C43B331DB64743CE85DC16F560EAA364', '赵沁宇', '厂领导', '赵沁宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C4E47D5458C54C0EB563141F4D671FE4', '吴波', '净化1班', '吴波', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C5B12E3B449644CC99768AD8524E59B4', '蒋婉姣', '净化1班', '蒋婉姣', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C64025BACC8F4D779121D6EBDD7D7116', '庄秀芳', '财务经营办', '庄秀芳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C66415138CBA4AF8B03FF2924A3D47B8', '周广浩', '综合办', '周广浩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C752D9BC2B0049FFAE117C6583BABE89', '张余宇', '净化3班', '张余宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('C83F2A78A846406F9055B2C25070368F', '曾珍', '净化3班', '曾珍', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CA0C7F10B17948A598CA16FAD0372CB9', '许尔明', '行政班', '许尔明', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CA8212701CFD4CD0A06980DE49312D98', '何敏', '净化1班', '何敏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CAB4CA925A9F4D5AA0F2B59006291EED', '程纯东', '净化3班', '程纯东', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CC01A031D7CF44F2A8619923BCD19168', '李俊', '综合办', '李俊', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CD094B255D144C018C5CB9A4EF4D3E32', '罗军', '净化1班', '罗军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CD29706BDA0645568B58176121E4F3F3', '罗鹏翔', '净化1班', '罗鹏翔', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CD39AFB1F45641CE939872C4D3C1629B', '赖仕彬', '净化1班', '赖仕彬', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CE6F348F723A4D3788152ED731B2A106', 'admin', null, 'admin', 'admin', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CF530EE75BD24281879E713B24E713CC', '赵小平', '净化1班', '赵小平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('CF57818732FA463D9A8B7ACBC8A03649', '曾钊伟', '维修工段', '曾钊伟', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D0CF88A4B7A64751B7019C3511A36FBD', '李巍', '管焊班', '李巍', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D11D4B9E2DE74268AC0CCDD182572931', '廖应君', '净化4班', '廖应君', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D1252566F67944E6BBDFAB8142F9D590', '郭莹', '行政班', '郭莹', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D16FBA7C4F3D41C2B78904E70251604F', '李继刚', '净化2班', '李继刚', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D1EB8771630246E9ABC7828BFA1ECA87', '刘桥林', '净化1班', '刘桥林', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D3059125EB9E4E1F9303E706B0BA9502', '毛明敏', '净化4班', '毛明敏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D3DF549ADD0943D3AF6A7A86744E2CA8', '陶芳', '分析班', '陶芳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D53AE8E157C24A5AA01A29EE6D39F12C', '谢嘉', '净化1班', '谢嘉', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D65F277BD86E4744B8EB5DF38AB91F2C', '王乾屹', '净化2班', '王乾屹', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D72CF3F7C8BB4282AEAE3C7FBBC69C58', '蒋吉强', '生产办公室', '蒋吉强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D737A4B50A564AB09B9D56E90271E106', '谌钊民', '净化2班', '谌钊民', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D7816EB0B1024A66A3E20D8DD86E70C5', '周廷键', '净化1班', '周廷键', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('D7F6DE6A648441FBBCB3F9A9C2A78B2A', '李亚', '设备办公室', '李亚', '123456', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('DB6DABD14DE240BC9DE68AFF1211B30C', '杨勇1', 'HSE办公室', '杨勇1', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('DDA12922014446CEB68D0EC944250EF0', '罗元军', '净化1班', '罗元军', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('DE3ACCA94E524F7D82CD730AC0143D78', '罗仁江', '设备办公室', '罗仁江', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('DFCCC6CC99DD45189F45CBE37C54DCEC', '张宏', '净化1班', '张宏', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E007FE24044F41829EE351B41DAF0C67', '吴娇', 'HSE办公室', '吴娇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E07CF499DCC2405F94BE2BED8DEC9EF4', '梁强', '净化2班', '梁强', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E0C3CB3F88AC41448CD1E79F64123422', '设备办公室', '龙王庙天然气净化厂', '设备办公室', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E1797503BF2841A7BAEC8BE812EBC05E', '王雅竹', '净化1班', '王雅竹', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E1BDD683414343DF8E7243B931C47AEF', '黄勇', '仪表班', '黄勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E30A6CEEE0F7491E95F74CFE2082E839', '李瑜', '分析班', '李瑜', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E45D82D435C94338841BA30BCD0173A2', '邬睿', '净化2班', '邬睿', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E6A2B08C66A043409C46E7179A64DD40', '张渝', '综合办', '张渝', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E6C74F07B76C438A88DC46AC49485059', '罗毅', '净化1班', '罗毅', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E73951293C3C410D97E107A7ECA1325A', '董栖君', '行政班', '董栖君', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E750B47308184CAD9BFE4F29B1A012B5', '黄杰', '净化1班', '黄杰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('E8589DF88DDF4CDCACD937D4D373F597', '何璐汐', '净化3班', '何璐汐', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EA741D0721FF4A0DA826A2AB1BB76087', '吕运飞', '净化3班', '吕运飞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EA9966EE3AC94C80868067F7F5A3F82C', '蒋维革', '净化4班', '蒋维革', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EAB7D12DDD3744C284A57D361593A91E', '吴楠1', '净化3班', '吴楠1', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('ECF00CAE083F4967A2F20AAB81568EF4', '陈新诗', '分析班', '陈新诗', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EE4E674E82C34782955AF0EA02A228AC', '赵浩', '维修工段', '赵浩', '123', '0', '1', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EEE1FE1611014ADCB931530B46F9E3F1', '张渝佳', '净化3班', '张渝佳', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('EF86290C1C63482E980EC5E5C1D07FBE', '吕超', '净化1班', '吕超', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F05210185E71437CA1DCDD79B25320B8', '张倩', '行政班', '张倩', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F1E639F86594462E9C18DC2C7CABE77E', '杜金城', '净化4班', '杜金城', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F2C3A30F0A8B4BB0AB699D2402D1B269', '电站班', '维修工段', '电站班', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F3228AFC3B9C4BD3B7C21AB9B315A5BA', '熊刚', '综合办', '熊刚', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F468B45D530D4672BA08A50317032B66', '郑臣兰', '净化3班', '郑臣兰', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F47B607BAA9D4A5B931E0241CF1436F4', '汪娟', '分析班', '汪娟', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F5583C529F5D4E44AC3D692F762D3FFF', '黄征宇', '生产办公室', '黄征宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F56BD06D8A1C4482BC9FD4D22D5E7FE2', '喻霞', '净化3班', '喻霞', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F5EA3CE8040B4B93A95D5A84670C7CEA', '郑婷婷', '综合办', '郑婷婷', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F6A9DAE9205D491E90AEFEA3B50665E6', '王旭', '净化2班', '王旭', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F77EA70D14DD44108D8A480B82A7F09B', '张秋平', '净化2班', '张秋平', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('F9C1830EF2C0440DAA47A7DE90614571', '王智骁', '净化4班', '王智骁', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FA014D7050414AB091E8E72A0ADDCF23', '王明亮', '综合办', '王明亮', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FA093A29DF234CD8BF452439F1CF7EAC', '何萍', '仪表班', '何萍', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FA5A6D4DBBD047179E0EF3E3A05CDA91', '李静', '净化2班', '李静', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FA5C552F71714CC69DFE3D0E18EC0770', '电站', '维修工段', '电站', '123', '0', '0', ' ', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FB43390F1A644541844FFA3E600A83F8', '柯勤梅', '净化2班', '柯勤梅', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FCD820D8A92D4E1BAB5CAF8EFB602C81', '李宇', '净化3班', '李宇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FCE036E53DD241C39994E590EFDB5341', '赵言', '净化1班', '赵言', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FD7FE934DC4C481A8F8BA2B66ED18BD9', '马勇', '净化2班', '马勇', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FEBFFF48512B4E85B1CAA5C17979A4F6', '白玮', '净化2班', '白玮', '123456', '0', '1', '用户', '0', null);
INSERT INTO `iot_user_organization` VALUES ('FF63B4E8713F417F82050E27558207FC', '熊运涛', '厂领导', '熊运涛', '123456', '0', '1', '用户', '0', null);

-- ----------------------------
-- Table structure for iot_user_register_info
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_register_info`;
CREATE TABLE `iot_user_register_info` (
  `REGID` varchar(32) NOT NULL,
  `NUM` varchar(32) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `STATE` int(1) NOT NULL DEFAULT '0',
  `NOTE` varchar(256) NOT NULL,
  `REMARK1` int(6) NOT NULL DEFAULT '0',
  `REMARK2` varchar(26) NOT NULL DEFAULT ' ',
  PRIMARY KEY (`REGID`),
  UNIQUE KEY `NUM` (`NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_register_info
-- ----------------------------
INSERT INTO `iot_user_register_info` VALUES ('DEAEFFE575DB4FA4A32F66D7C019E451', '111111112', '中文', '2019-10-21 11:57:07', '1', '能显示', '0', ' ');

-- ----------------------------
-- Table structure for iot_user_role
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_role`;
CREATE TABLE `iot_user_role` (
  `ROLID` varchar(32) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `STATE` int(1) NOT NULL DEFAULT '1',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NOTE` varchar(38) NOT NULL DEFAULT '',
  `REMARK1` int(6) DEFAULT '0',
  `REMARK2` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ROLID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_role
-- ----------------------------
INSERT INTO `iot_user_role` VALUES ('', 'test', '0', '2019-10-22 10:29:39', '2019-10-22 10:29:39', 'test', '0', null);
INSERT INTO `iot_user_role` VALUES ('1546015664FE4CF99D898FAC7DBE3971', '净化技术干部', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '净化技术干部', '0', null);
INSERT INTO `iot_user_role` VALUES ('26674768CDA449FA9F677F9B9F4FF0D2', '流程_问题评估_部门领导', '0', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '用于流程过滤作业安排的人', '0', null);
INSERT INTO `iot_user_role` VALUES ('2ba62c1a1414d7491eb05338d14c1c3', '主体装置2列', '1', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '主体装置二列', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('3591A0F744F49EFBABA6959917139CE', '主体装置4列', '1', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '主体装置四列', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('3709C53C7AA7467E9866CE2473F32A06', 'HSE办成员', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', 'HSE办成员', '0', null);
INSERT INTO `iot_user_role` VALUES ('3F49C890CB8144698537CD9F8D8FA0B9', '财务经营办主任', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '财务经营办主任', '0', null);
INSERT INTO `iot_user_role` VALUES ('57454B010B9D47499E1094CCB9B8D9CF', '生产办成员', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '生产办成员', '0', null);
INSERT INTO `iot_user_role` VALUES ('5ED0EDF24274C6DA8447DAA8215DD6D', '主体装置5列', '1', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '主体装置五列', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('655630E6C50C4CFFAF76FAF2D21B86BA', '净化巡检员', '0', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '净化巡检员', '0', null);
INSERT INTO `iot_user_role` VALUES ('65C211FDB0DD40A99B7EFDE6C2143411', '维修班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '机械班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('6F46C2325D49450E89D4C1CB38B44FA7', '财务经营办成员', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '财务经营办成员', '0', null);
INSERT INTO `iot_user_role` VALUES ('723BD1BD7414459F9FA499BE28B17FF2', '设备办主任', '0', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '设备办主任', '0', null);
INSERT INTO `iot_user_role` VALUES ('73D21E26D1B542E39865A7AA1CB74A5E', '电工班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '电工班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('78F1FFBE48EE451B88EE619036E9E906', '净化班长', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '净化班组长', '0', null);
INSERT INTO `iot_user_role` VALUES ('7A987B996C744EFAEC54B5855F7C98E', '主体装置1列', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '主体装置一列', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('7FB4D637BB10473AAE6F3CB49366C8B6', '设备办成员', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '设备办成员', '0', null);
INSERT INTO `iot_user_role` VALUES ('8008A6E5656E4381AC2A0C262E3F694E', '生产办主任', '0', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '生产办主任', '0', null);
INSERT INTO `iot_user_role` VALUES ('8569B97F69794AB58214BFF9E8E3442B', '仪表班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '仪表班班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('8819F147F434B81E5177973619FB4', '净化厂一类动设备', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '2号电站10kv', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('9B494FC3182A4288A3FECA4F36785886', '钳工班班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '钳工班班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('9FF5CA9B0E94EA6BBC9CE21F08AF2F0', '装置区1号10KV电站', '0', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '主体装置七列', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('A291958C761347159F28FBDF70ADC12D', '菜单_超级管理员', '0', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '超级管理员', '0', null);
INSERT INTO `iot_user_role` VALUES ('A642FAE80A874BCD8BB145711E76BA1B', '综合办成员', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '综合办成员', '0', null);
INSERT INTO `iot_user_role` VALUES ('A9A1F373D3A0491493A9E2DE991780C3', '综合办主任', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '综合办主任', '0', null);
INSERT INTO `iot_user_role` VALUES ('AEE1D55EE6D14FBB9E7835368075C6B5', '电站班长', '1', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '电站班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('B5A8F0CA608F43819004DD4E0310BCE2', '分析班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '分析班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('B5F0C7F4C4BF482A88F7FB340F92E8A2', '维修技术干部', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '维修技术干部', '0', null);
INSERT INTO `iot_user_role` VALUES ('BAAD1EA0CD594F37A91B50C379D9016D', '管焊班班长', '1', '2019-10-21 13:42:24', '2019-10-21 13:42:24', '管焊班班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('BB8D6DDF91943C4BD15C3DE742147B8', '净化厂二类动设备', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '污水巡检', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('BF383CE2890B4E99AE0D1D41F4E199FC', '维修班组长', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '维修班组长', '0', null);
INSERT INTO `iot_user_role` VALUES ('C2D2B1358C984A62BC0C1FAA3463DEAA', 'HSE办主任', '0', '2019-10-21 13:42:23', '2019-10-21 13:42:23', 'HSE办主任', '0', null);
INSERT INTO `iot_user_role` VALUES ('D332D8E3AA94D0C9AEA287EC18FB31D', '检维修变电站', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '锅炉巡检', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('DF1E1B39EEC48B39DD2E30CC4ED5820', '巡检工段巡检记录静设备', '1', '2019-10-21 13:42:23', '2019-10-21 13:42:23', '1号电站10kv', '0', 'paid');
INSERT INTO `iot_user_role` VALUES ('E06B004A1ECA40BE82915E4C7EED96A1', '机械班长', '1', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '机械班长', '0', null);
INSERT INTO `iot_user_role` VALUES ('F2C4B20414C48F385DBF4F4595AF10F', '装置区2号10KV电站', '0', '2019-10-21 13:42:22', '2019-10-21 13:42:22', '主体装置六列', '0', 'paid');

-- ----------------------------
-- Table structure for iot_user_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_role_auth`;
CREATE TABLE `iot_user_role_auth` (
  `ROL_AUT_ID` varchar(32) NOT NULL,
  `ROLID` varchar(32) NOT NULL,
  `AUTID` varchar(32) NOT NULL,
  PRIMARY KEY (`ROL_AUT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_role_auth
-- ----------------------------
INSERT INTO `iot_user_role_auth` VALUES ('00F292AB13B944A589B99B61F1613758', 'A291958C761347159F28FBDF70ADC12D', '556521B20CC34288AFA035830B40C585');
INSERT INTO `iot_user_role_auth` VALUES ('0B87D5A0B64148E99B4623528321E1BA', 'A291958C761347159F28FBDF70ADC12D', '5874479DE37B404B8A17DEB0E77C7334');
INSERT INTO `iot_user_role_auth` VALUES ('0BF96D2A51FC4F2A9378185A2451C31F', 'A291958C761347159F28FBDF70ADC12D', '2CBCEDCFEAD141FBA5ABEA191542BCF4');
INSERT INTO `iot_user_role_auth` VALUES ('0D845CBA8D2D444393914B0006EACD1D', 'A291958C761347159F28FBDF70ADC12D', 'B8CE4CE2F7014D0CB5E7A2EC49978992');
INSERT INTO `iot_user_role_auth` VALUES ('0E6A6E577EA0492ABD131BB305F44905', 'A291958C761347159F28FBDF70ADC12D', '519E1128561E4DDD8729336CFB1DCDDD');
INSERT INTO `iot_user_role_auth` VALUES ('0E8850A09B1A40909FF5F809542236D9', 'B5F0C7F4C4BF482A88F7FB340F92E8A2', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('0F6C632826F24E448CAA9231DDE3936B', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('144FD6084F7641BF84E659635163C5F7', 'A291958C761347159F28FBDF70ADC12D', '9164CF7AEFEC4A98A898367611665BF9');
INSERT INTO `iot_user_role_auth` VALUES ('14D2B13DE6F34E59A479FA79A10625CB', 'A642FAE80A874BCD8BB145711E76BA1B', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('17F770F107274E52BD075E5525E279E7', 'D332D8E3AA94D0C9AEA287EC18FB31D', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('191AFD7D45E84173A069280201E6A258', 'faf2158720e445fbdbf926846fdeb9a', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('1A986412F9F646F182C1AE5C338452A8', '655630E6C50C4CFFAF76FAF2D21B86BA', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('1BC3F0046D3843F2AD467EAB3A37791F', 'A291958C761347159F28FBDF70ADC12D', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('1E209BE07B5848C08E39F39C41DEB21E', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('1E34E7EA41B54F28B7CE462AE196B624', 'F2C4B20414C48F385DBF4F4595AF10F', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('241B6511DCB64F6C93D64D5C01EE79FC', 'AEE1D55EE6D14FBB9E7835368075C6B5', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('2436CE3E90944D3AAC2BC41115AD5877', 'C2D2B1358C984A62BC0C1FAA3463DEAA', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('24B0403F5AF044EC9676BA2D62C96CED', '65C211FDB0DD40A99B7EFDE6C2143411', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('25A65A42D6654B4BBF53D7745C07703E', 'BF383CE2890B4E99AE0D1D41F4E199FC', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('268A661FAD5740DC9C4EC356DEF49630', 'A291958C761347159F28FBDF70ADC12D', '633C1A63DBF4440BBF72308C3EBAB9C0');
INSERT INTO `iot_user_role_auth` VALUES ('271F072AB3D645BF8DAD2552267A4443', 'A291958C761347159F28FBDF70ADC12D', '3C4BE8D4F53146F08967AAC2B958F368');
INSERT INTO `iot_user_role_auth` VALUES ('27596242BA2549EAAF2E664C8DBE391E', '78F1FFBE48EE451B88EE619036E9E906', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('28841823F65B4EFE900F815A7319176F', 'E06B004A1ECA40BE82915E4C7EED96A1', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('2BEE572666EE4C32A077B31F94C48EA5', 'DF1E1B39EEC48B39DD2E30CC4ED5820', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('2F20CA8E961F4E03BB1534949BD81542', 'BB8D6DDF91943C4BD15C3DE742147B8', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('32B3A9C65B814EB3B53855409E2E218C', '73D21E26D1B542E39865A7AA1CB74A5E', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('33AEC6CA627C4FDBA3B42CDC1BA6647C', '65C211FDB0DD40A99B7EFDE6C2143411', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('33E42CD906E246C5ADC4DD0949701618', 'B5A8F0CA608F43819004DD4E0310BCE2', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('36136472208846399FFC6B99ADA112CF', 'BB8D6DDF91943C4BD15C3DE742147B8', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('3758D4BB113A40C3B24E1FC6EE66D7DC', '7FB4D637BB10473AAE6F3CB49366C8B6', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('3939C46D6BFD44419AD0BFEE350630C4', 'faf2158720e445fbdbf926846fdeb9a', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('3E8961DFFB8B44E09AB90E3A0DE1ABB5', 'A9A1F373D3A0491493A9E2DE991780C3', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('3EA4A9B6260949C4ADD8D4797098F416', 'A291958C761347159F28FBDF70ADC12D', '90C5C82503F94F2CA5FF5CF95BD0B3A5');
INSERT INTO `iot_user_role_auth` VALUES ('3F3924FC95B743DBBD6D7367B79E19A9', '7A987B996C744EFAEC54B5855F7C98E', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('40D0F8E2D210471B92682C2FCDE3AE5C', 'A291958C761347159F28FBDF70ADC12D', '96FDE28CDE3847419E99BEF69B3A7201');
INSERT INTO `iot_user_role_auth` VALUES ('41F06B6504DE4794B69655000AD0B709', 'B5A8F0CA608F43819004DD4E0310BCE2', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('428782D6152D4FF49552D7F6E3B3B913', 'B5F0C7F4C4BF482A88F7FB340F92E8A2', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('43CC1E0985F146E2A1FE64A70760E7DC', '65C211FDB0DD40A99B7EFDE6C2143411', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('465A3EABA4DC46FBA1D3EFA8CBCCD52A', '8819F147F434B81E5177973619FB4', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('46A6D2E415D2427C899DBC2F210A4B07', 'A291958C761347159F28FBDF70ADC12D', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('46ADB38AD93244FF88AC9AF275AF2C32', 'A291958C761347159F28FBDF70ADC12D', '17860DB8B2104ACF8841C5F8F50C63AF');
INSERT INTO `iot_user_role_auth` VALUES ('4887E0555381476B8BD10E69488B290B', 'A291958C761347159F28FBDF70ADC12D', '5E12A0E28A7644EBA9096FAFCA0C4753');
INSERT INTO `iot_user_role_auth` VALUES ('49A73A2794C441CD9E169A625E627E5F', '3F49C890CB8144698537CD9F8D8FA0B9', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('4AE8C1AA266E4FF8AB877CF1D5C52200', '8569B97F69794AB58214BFF9E8E3442B', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('4BABE1C1E64A41B6AB83041CDFFD05B3', '1546015664FE4CF99D898FAC7DBE3971', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('4E03E5FE6656497FA20806B02D7A81D1', 'BF383CE2890B4E99AE0D1D41F4E199FC', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('4E7B36892575444EB3A2CC49204272C6', '6F46C2325D49450E89D4C1CB38B44FA7', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('51305433F0F34BAD98B54CF3FA7C44C7', '73D21E26D1B542E39865A7AA1CB74A5E', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('53C143F15E04490AAD8D7021C6A27AC0', 'A642FAE80A874BCD8BB145711E76BA1B', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('5673C010A0A24847BAAB7263B811EDFD', 'A291958C761347159F28FBDF70ADC12D', '5899DDE9F0F24235AC4C6440DF1C0305');
INSERT INTO `iot_user_role_auth` VALUES ('571F8AA3F6D544BDA40777BC2219504B', 'A291958C761347159F28FBDF70ADC12D', 'B121EE0BEA804DB29687458B6E4AA122');
INSERT INTO `iot_user_role_auth` VALUES ('58289AAD8B984350816F172543BE5285', 'F2C4B20414C48F385DBF4F4595AF10F', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('5F37EA108A854FF6BB8A804EACB6CB14', '5ED0EDF24274C6DA8447DAA8215DD6D', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('5F8772593935470A86CA9EC3FE923B42', 'BB8D6DDF91943C4BD15C3DE742147B8', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('5F9422BEDE3E45DD8A80C0F7319C1A17', 'A291958C761347159F28FBDF70ADC12D', 'F8F90671DEF54CB49F0AF3A4777BF5E1');
INSERT INTO `iot_user_role_auth` VALUES ('5FD9832F7455461E9DF3B990D62C75B8', 'E06B004A1ECA40BE82915E4C7EED96A1', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('5FE9218263434CFF9708A918976D00CF', 'A291958C761347159F28FBDF70ADC12D', 'EBA8565379D34B0EA021660B1DB8F32F');
INSERT INTO `iot_user_role_auth` VALUES ('6026CDB2AF014045A077B5C586630027', 'faf2158720e445fbdbf926846fdeb9a', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('608BF4A1B28144D188549390718AAA92', 'A291958C761347159F28FBDF70ADC12D', '7CBEC12EA2014DBD980DA76579BE5131');
INSERT INTO `iot_user_role_auth` VALUES ('611D8C35CC2F4620A301896DADA47BDF', 'DF1E1B39EEC48B39DD2E30CC4ED5820', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('64ABF75CB33F4C83AA6B253768120365', '26674768CDA449FA9F677F9B9F4FF0D2', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('669161604A794633BFC051BCB0FA8243', '2ba62c1a1414d7491eb05338d14c1c3', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('6811EF8895E947A08E21AA9F9E9AB15E', '1546015664FE4CF99D898FAC7DBE3971', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('69EFB03C68CA45DDBC51F77B99713CA8', 'A291958C761347159F28FBDF70ADC12D', '2E1E4988F0134CAF97A7661A8D69B441');
INSERT INTO `iot_user_role_auth` VALUES ('6D1C791C8693456FAE1C56342E43429D', 'A291958C761347159F28FBDF70ADC12D', '3522DE9EB9D9414CA4FC79224C076F70');
INSERT INTO `iot_user_role_auth` VALUES ('7144E33FB2064CB8AF8574E054E5E97F', '78F1FFBE48EE451B88EE619036E9E906', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('71C8C7FE6DAA4D3796B220264C168FD6', '1546015664FE4CF99D898FAC7DBE3971', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('72805EAB0D6F40C0A43D16BC69ECDD17', 'A291958C761347159F28FBDF70ADC12D', '45C44F5E60E743708102975D347BF3AB');
INSERT INTO `iot_user_role_auth` VALUES ('731ED22F183F40D5A1E4E47FF54C39CD', 'A291958C761347159F28FBDF70ADC12D', '67FE9B90EAF140E99776B24104ECAB99');
INSERT INTO `iot_user_role_auth` VALUES ('75ACA23B5B6B4FA8A12304B5B176D842', '8008A6E5656E4381AC2A0C262E3F694E', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('7EAA6AFFB09F4B4FB98C8E86BE07AE58', '9B494FC3182A4288A3FECA4F36785886', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('7EDF2B25BEE546E79162D6F58D282F16', '9B494FC3182A4288A3FECA4F36785886', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('7EE1FE8BFC49424C8F10F3DE0F24738E', 'E06B004A1ECA40BE82915E4C7EED96A1', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('8096AA599F2A4A58AB3C1D866659A63F', 'A291958C761347159F28FBDF70ADC12D', 'A89E73010B5B4D4F8601B4E871BAA482');
INSERT INTO `iot_user_role_auth` VALUES ('815BA750548844A8B7B4FC69B8921704', 'F2C4B20414C48F385DBF4F4595AF10F', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('83009BA44CAF4171B0E620A62D49067A', 'C2D2B1358C984A62BC0C1FAA3463DEAA', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('843B751C8DB54E7490CECD0995D1D41C', '5ED0EDF24274C6DA8447DAA8215DD6D', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('878BC448E2E64028AA1325EC2E22032C', '3591A0F744F49EFBABA6959917139CE', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('8899B7E155074375B5A6C3F5E55E0464', 'A291958C761347159F28FBDF70ADC12D', '1F57A2A664A44B6C8E4F83BF9F4A69A8');
INSERT INTO `iot_user_role_auth` VALUES ('8BD2B64A905A4A0AA159C60B06C6CDBE', '26674768CDA449FA9F677F9B9F4FF0D2', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('8f1f73e1f48d11e99650448a5bee81ee', '', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f36e557f48d11e99650448a5bee81ee', '1546015664FE4CF99D898FAC7DBE3971', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f3b422ff48d11e99650448a5bee81ee', '26674768CDA449FA9F677F9B9F4FF0D2', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f41a8daf48d11e99650448a5bee81ee', '2ba62c1a1414d7491eb05338d14c1c3', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f47ff74f48d11e99650448a5bee81ee', '3591A0F744F49EFBABA6959917139CE', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f4e79c7f48d11e99650448a5bee81ee', '3709C53C7AA7467E9866CE2473F32A06', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f574ccff48d11e99650448a5bee81ee', '3F49C890CB8144698537CD9F8D8FA0B9', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f5da8e6f48d11e99650448a5bee81ee', '57454B010B9D47499E1094CCB9B8D9CF', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f63fbaff48d11e99650448a5bee81ee', '5ED0EDF24274C6DA8447DAA8215DD6D', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f6af52bf48d11e99650448a5bee81ee', '655630E6C50C4CFFAF76FAF2D21B86BA', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f721983f48d11e99650448a5bee81ee', '65C211FDB0DD40A99B7EFDE6C2143411', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f7846e0f48d11e99650448a5bee81ee', '6F46C2325D49450E89D4C1CB38B44FA7', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f7eac3af48d11e99650448a5bee81ee', '723BD1BD7414459F9FA499BE28B17FF2', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f84ff98f48d11e99650448a5bee81ee', '73D21E26D1B542E39865A7AA1CB74A5E', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8F85CB05B79441309BDB758594A621C0', '6F46C2325D49450E89D4C1CB38B44FA7', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('8f8ded91f48d11e99650448a5bee81ee', '78F1FFBE48EE451B88EE619036E9E906', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f945b85f48d11e99650448a5bee81ee', '7A987B996C744EFAEC54B5855F7C98E', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8f9aa820f48d11e99650448a5bee81ee', '7FB4D637BB10473AAE6F3CB49366C8B6', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fa24d19f48d11e99650448a5bee81ee', '8008A6E5656E4381AC2A0C262E3F694E', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8faae6baf48d11e99650448a5bee81ee', '8569B97F69794AB58214BFF9E8E3442B', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fb314e8f48d11e99650448a5bee81ee', '8819F147F434B81E5177973619FB4', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fb9759af48d11e99650448a5bee81ee', '9B494FC3182A4288A3FECA4F36785886', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fbfd8ccf48d11e99650448a5bee81ee', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fc74adaf48d11e99650448a5bee81ee', 'A291958C761347159F28FBDF70ADC12D', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fcda9fbf48d11e99650448a5bee81ee', 'A642FAE80A874BCD8BB145711E76BA1B', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fd41389f48d11e99650448a5bee81ee', 'A9A1F373D3A0491493A9E2DE991780C3', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fda6de3f48d11e99650448a5bee81ee', 'AEE1D55EE6D14FBB9E7835368075C6B5', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fe38903f48d11e99650448a5bee81ee', 'B5A8F0CA608F43819004DD4E0310BCE2', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fec078ff48d11e99650448a5bee81ee', 'B5F0C7F4C4BF482A88F7FB340F92E8A2', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8ff26635f48d11e99650448a5bee81ee', 'BAAD1EA0CD594F37A91B50C379D9016D', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8ff8f4ccf48d11e99650448a5bee81ee', 'BB8D6DDF91943C4BD15C3DE742147B8', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('8fff5332f48d11e99650448a5bee81ee', 'BF383CE2890B4E99AE0D1D41F4E199FC', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('9006f4bdf48d11e99650448a5bee81ee', 'C2D2B1358C984A62BC0C1FAA3463DEAA', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('900d48b3f48d11e99650448a5bee81ee', 'D332D8E3AA94D0C9AEA287EC18FB31D', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('901bef5ef48d11e99650448a5bee81ee', 'DF1E1B39EEC48B39DD2E30CC4ED5820', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('9022bb86f48d11e99650448a5bee81ee', 'E06B004A1ECA40BE82915E4C7EED96A1', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('902c00fbf48d11e99650448a5bee81ee', 'F2C4B20414C48F385DBF4F4595AF10F', 'B6E122E8C4F44A5187307662C52BA9A3');
INSERT INTO `iot_user_role_auth` VALUES ('9586E54C05F042A39F01CC769CC04103', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('9867CBB9B98D4DF48E19D2BB0CD676D2', '8008A6E5656E4381AC2A0C262E3F694E', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('98B47E64E0D949889BE7DBF429430403', '7A987B996C744EFAEC54B5855F7C98E', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('9A1FB035821A41719BBEC21647B676D0', '73D21E26D1B542E39865A7AA1CB74A5E', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('9BC28EF105EF476CAB844613339A06A6', 'C2D2B1358C984A62BC0C1FAA3463DEAA', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('9CC1CA5B7DAE4F24B99419BB26322EDA', 'A291958C761347159F28FBDF70ADC12D', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('9F9ED45D3A6A4BDBA8B803301A1B7796', 'BAAD1EA0CD594F37A91B50C379D9016D', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('A067BF3382EE45198408977C5258B0BB', '3591A0F744F49EFBABA6959917139CE', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('A0786B5C77E048B9A6CF90C0C2C7DE79', '8819F147F434B81E5177973619FB4', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('A2361D1024C1430AB379EA4018FEC0F3', '3709C53C7AA7467E9866CE2473F32A06', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('A243189B41D648BF88182C0501A96BED', 'A291958C761347159F28FBDF70ADC12D', '5FA71EF0D9614B8F87169A419223267F');
INSERT INTO `iot_user_role_auth` VALUES ('A2851E3598EF4F7BABFCF2823CD3C2C0', 'A642FAE80A874BCD8BB145711E76BA1B', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('A3A53EA777F444FB89AE5706CFBC8855', 'A291958C761347159F28FBDF70ADC12D', '55CB8A259F8746C0BE0EB62A9C371695');
INSERT INTO `iot_user_role_auth` VALUES ('A3F086734B604F44BC132B96E16D12F3', 'A291958C761347159F28FBDF70ADC12D', 'BDCD2E0BCBDA4C1E9CFFDD42C2A8EDF6');
INSERT INTO `iot_user_role_auth` VALUES ('A4C50C56EBFD46648D6AD4E2FDAC2F2C', 'A291958C761347159F28FBDF70ADC12D', 'E6155B9B62C54A988F14ECF18014575C');
INSERT INTO `iot_user_role_auth` VALUES ('A5D020C2B53E46F594FCAEE6B483DEBC', 'BF383CE2890B4E99AE0D1D41F4E199FC', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('A6ABA036BCBE4C53AC1C57081B650F55', 'A291958C761347159F28FBDF70ADC12D', '6E5D5C4FDDBE449391F01CFA3A5D8ECE');
INSERT INTO `iot_user_role_auth` VALUES ('A79C293BD2D740FFAF858C580242E950', 'DF1E1B39EEC48B39DD2E30CC4ED5820', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('A8830A8BA64A49EB84FAAE23145F0CAB', 'D332D8E3AA94D0C9AEA287EC18FB31D', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('AA845611725448CB9196FB3B5D2BF486', 'A291958C761347159F28FBDF70ADC12D', '3881195AC75A45CE9C19B91DDC33A46B');
INSERT INTO `iot_user_role_auth` VALUES ('ABD487FF178D403C8F4DDA6E5D9902F6', 'B5F0C7F4C4BF482A88F7FB340F92E8A2', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('ACB03ED5148A478BA973F8784A9C5388', 'AEE1D55EE6D14FBB9E7835368075C6B5', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('B1B69F09774E46DABCAEEEA168122BA8', '8008A6E5656E4381AC2A0C262E3F694E', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('B243C98B88594CB3821C6DB2F07C4182', '6F46C2325D49450E89D4C1CB38B44FA7', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('B385BCD97D3C4036B5C81E4C8E323561', '7FB4D637BB10473AAE6F3CB49366C8B6', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('B82D7F6B529B4B8C9028100C66651564', 'A291958C761347159F28FBDF70ADC12D', 'F2A1B1FEDFA740E2A9F58D2CDBFB6695');
INSERT INTO `iot_user_role_auth` VALUES ('B98E3AE8674C46B78BA58532900255C5', '3F49C890CB8144698537CD9F8D8FA0B9', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('BF593C3780AA47E78ED34A4F2936E242', 'A291958C761347159F28FBDF70ADC12D', '7232128C04DE4A7BAEE939D17FD55968');
INSERT INTO `iot_user_role_auth` VALUES ('C1B170941F794D2293CB18B5DF0BCFF1', '57454B010B9D47499E1094CCB9B8D9CF', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('C1D281EB7CA249259D5905F4A498C336', '8569B97F69794AB58214BFF9E8E3442B', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('C2CF8FFDF0774D51B131E9884EC2BE9E', 'A291958C761347159F28FBDF70ADC12D', 'BE5C396ABEB847BD963AB5B8EE0FFCD7');
INSERT INTO `iot_user_role_auth` VALUES ('C3A3C38DDE6645E39B68E01A5DD3A41C', 'D332D8E3AA94D0C9AEA287EC18FB31D', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('C3D380F0E004478F979DCA869FAD3570', '2ba62c1a1414d7491eb05338d14c1c3', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('C52B854293554CBEBCA1ADDF618AF535', 'AEE1D55EE6D14FBB9E7835368075C6B5', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('CA692ECD02A54BF481C92E1F161079FC', '3709C53C7AA7467E9866CE2473F32A06', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('CCC83323B40A4707B3E8AE2B89FCD303', '8819F147F434B81E5177973619FB4', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('CE9EEC20167645BA98BAEC6C9AB61385', '9B494FC3182A4288A3FECA4F36785886', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('CEF3C40FD33D454C8D2EB3D1BA096C84', '8569B97F69794AB58214BFF9E8E3442B', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('CF8F53BF0BF4416CB2AC8ADBB1D438D8', 'A291958C761347159F28FBDF70ADC12D', '3A237E23E84C4EE2BBFA61A6294EB91B');
INSERT INTO `iot_user_role_auth` VALUES ('D04BA01B7BCA42C692E1D1324C433025', '57454B010B9D47499E1094CCB9B8D9CF', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('D1A7F36E8F474D51A8EF8CF0CE821E4D', '78F1FFBE48EE451B88EE619036E9E906', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('D4CF6342BF7D4185B2392B4BBCC40BB5', 'A291958C761347159F28FBDF70ADC12D', '6E322F20C349488BB2F3F8094615C593');
INSERT INTO `iot_user_role_auth` VALUES ('D76D3AD440664D24970A0EFA9D8FB749', '3F49C890CB8144698537CD9F8D8FA0B9', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('D823A531BB4D4A6EAC570EB5FE98FE99', '655630E6C50C4CFFAF76FAF2D21B86BA', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('DF6D925EB61E4C8A90A7A2D342A30C00', '7A987B996C744EFAEC54B5855F7C98E', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('E1F43E61947D4F48B49AFE1F0CC867BE', 'A291958C761347159F28FBDF70ADC12D', 'A490BC5F3D2245CCBB77722FC96C5B6B');
INSERT INTO `iot_user_role_auth` VALUES ('E2F1C245C4A64E039C357B090CBAFDAD', '723BD1BD7414459F9FA499BE28B17FF2', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('E6AAF7F784B74CE4BDC05548DA14D906', '723BD1BD7414459F9FA499BE28B17FF2', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('E7002A5AEAE24CE4A2238369D69648FE', 'A291958C761347159F28FBDF70ADC12D', 'CC32DD5ECE23438783EA710CCFFD1F7B');
INSERT INTO `iot_user_role_auth` VALUES ('E91D1040B0A244959663EEB803784695', '723BD1BD7414459F9FA499BE28B17FF2', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('EA7FF3419B7B47F393A72FC63E5D66E9', '3709C53C7AA7467E9866CE2473F32A06', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('EDDED53DB7D64E6F9BBB955822AC1059', 'A9A1F373D3A0491493A9E2DE991780C3', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('EE5C93C296694E2DB857B8736C98E703', '2ba62c1a1414d7491eb05338d14c1c3', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('EE74700F0A1248CAAF0E1EE45D135152', '655630E6C50C4CFFAF76FAF2D21B86BA', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('F09E22FC9BFB46DD85BD3729894413C8', 'A291958C761347159F28FBDF70ADC12D', '4519C01351774685A31AF3C1E68075AD');
INSERT INTO `iot_user_role_auth` VALUES ('F293706C6A63456CB3C286CC6A54A291', '57454B010B9D47499E1094CCB9B8D9CF', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('F2D8C0EAE16A4F4FAE32EA73F1324390', '26674768CDA449FA9F677F9B9F4FF0D2', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('F2DE048A01F14A4C8E17B29D7F6B1F14', 'BAAD1EA0CD594F37A91B50C379D9016D', '6CCAEEC9592D450FB419C60244DB0805');
INSERT INTO `iot_user_role_auth` VALUES ('F32E4E15C0EA404F86D4C84BDB4EAE14', 'B5A8F0CA608F43819004DD4E0310BCE2', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('F40D02BFC0F541959168CBDCE3926F27', '3591A0F744F49EFBABA6959917139CE', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('F446CCA2165E4D8D9B680CE1E99F8681', '7FB4D637BB10473AAE6F3CB49366C8B6', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('F762513161A246D6A82F5DF75E75F150', 'BAAD1EA0CD594F37A91B50C379D9016D', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('F92FF5DB81AB4C8FB190FFE4805DBEC5', '5ED0EDF24274C6DA8447DAA8215DD6D', 'E72E0471CB7E45F0A2D100126A2889AA');
INSERT INTO `iot_user_role_auth` VALUES ('F9626DBF8AF94E7BB92430AD28680774', 'A9A1F373D3A0491493A9E2DE991780C3', '3BF679B48DDA4E0685A9AFE95EB1B5A1');
INSERT INTO `iot_user_role_auth` VALUES ('FA78F6A836FE4A62B9DBC0183B1B6CC1', 'A291958C761347159F28FBDF70ADC12D', 'D0DC8FD88A2E42519FA8AF159211517A');
INSERT INTO `iot_user_role_auth` VALUES ('FCD79EB778CD48CC8BBA10D210BBB8A9', 'A291958C761347159F28FBDF70ADC12D', 'CEF98E00485A4115965378E484D1AB08');

-- ----------------------------
-- Table structure for iot_user_role_role
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_role_role`;
CREATE TABLE `iot_user_role_role` (
  `RSID` varchar(32) NOT NULL,
  `ROLENAME` varchar(100) NOT NULL DEFAULT ' ',
  `ROLENAME1` varchar(100) NOT NULL DEFAULT ' ',
  `ROLENAME2` varchar(100) NOT NULL DEFAULT ' ',
  `ROLENAME3` varchar(100) NOT NULL DEFAULT ' ',
  `REMARK1` varchar(100) NOT NULL DEFAULT ' ',
  `REMARK2` varchar(100) NOT NULL DEFAULT ' ',
  PRIMARY KEY (`RSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_role_role
-- ----------------------------
INSERT INTO `iot_user_role_role` VALUES ('00001                           ', '3591A0F744F49EFBABA6959917139CE', '3591A0F744F49EFBABA6959917139CE', '3591A0F744F49EFBABA6959917139CE', 'A291958C761347159F28FBDF70ADC12D', '5424 ', '2452 ');
INSERT INTO `iot_user_role_role` VALUES ('00002                           ', '7A987B996C744EFAEC54B5855F7C98E', 'F2C4B20414C48F385DBF4F4595AF10F', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0', 'faf2158720e445fbdbf926846fdeb9a', '2525 ', '525 ');
INSERT INTO `iot_user_role_role` VALUES ('1                               ', '净化工段', '净化班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('10                              ', '化验', '分析班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('11                              ', 'HSE办', 'HSE办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('12                              ', '机械', '机械班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('13                              ', '仪表', '仪表班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('14                              ', '电工', '电工班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('2                               ', '维修工段', '维修班长', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('3                               ', 'HSE办公室', 'HSE办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('4                               ', '设备办', '设备办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('5                               ', '超级管理员', '超级管理员', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('6                               ', '生产办', '生产办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('7                               ', '综合办', '综合办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('8                               ', '财务经营办', '财务经营办主任', ' ', ' ', ' ', ' ');
INSERT INTO `iot_user_role_role` VALUES ('9                               ', '电站', '电站班长', ' ', ' ', ' ', ' ');

-- ----------------------------
-- Table structure for iot_user_user_role
-- ----------------------------
DROP TABLE IF EXISTS `iot_user_user_role`;
CREATE TABLE `iot_user_user_role` (
  `USER_ROL_ID` varchar(32) NOT NULL,
  `USERID` varchar(32) NOT NULL,
  `ROLID` varchar(32) NOT NULL,
  PRIMARY KEY (`USER_ROL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iot_user_user_role
-- ----------------------------
INSERT INTO `iot_user_user_role` VALUES ('010276B2119C4914A84F3CDB55D10A93', '陈亮', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('017548BD96F94FFDAF6F957100CB250C', '许尔明', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('031B69429B5743F0B690C85722ADFD7A', '邓尚渝', 'E06B004A1ECA40BE82915E4C7EED96A1');
INSERT INTO `iot_user_user_role` VALUES ('03D68616E07A44278BDD37C0616A4F34', '周珂', '3F49C890CB8144698537CD9F8D8FA0B9');
INSERT INTO `iot_user_user_role` VALUES ('0986A05D8EAB437A844237D6BA6B593A', '吴静', 'B5A8F0CA608F43819004DD4E0310BCE2');
INSERT INTO `iot_user_user_role` VALUES ('0DBB87F5FB9442DC8AF8A394A2ABF773', '余虹钢', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('0F1BCD60574F4D2991221A3A7709E7B6', '杨帆', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('11BB03FC19AB48799043EA1E616CC1F5', '王洪东', '8569B97F69794AB58214BFF9E8E3442B');
INSERT INTO `iot_user_user_role` VALUES ('11BCE5663A3C4A188D9E5BAC9EB114FA', '岳志坚', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('139744C8BD894144806D434BBDAC1133', '代超', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('165810C8084D416FB715BB3C1CE1FD52', 'test', '655630E6C50C4CFFAF76FAF2D21B86BA');
INSERT INTO `iot_user_user_role` VALUES ('171D9C98AB0A4169A38E81B6D1851BC5', '周超', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('1853E6F12741454FADAA48492AA67A1A', '庄秀芳', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('1929C7BF64704F27B57A94F688DD86F7', '陈念华', 'E06B004A1ECA40BE82915E4C7EED96A1');
INSERT INTO `iot_user_user_role` VALUES ('20412C3C53154F2AAA0D9C605551782B', '江山', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('21E683DCB3B24DE18E786F95B4FEC77F', '颜萍', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('278FDB07B9B145B6A041BEAC2DDB9405', 'admin', 'A291958C761347159F28FBDF70ADC12D');
INSERT INTO `iot_user_user_role` VALUES ('292B39DABFF14631A6903F2A6498F405', '苟列生', 'C2D2B1358C984A62BC0C1FAA3463DEAA');
INSERT INTO `iot_user_user_role` VALUES ('2A0C69503E8B40A29D2573CBFEC8321E', '罗仁江', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('32040C5656FB48AE98028C3B68A543FC', '廖婉媚', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('324D522C3F984D8788EE59DA6137D859', '熊运涛', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('365F2179305848A6B4D589258C0DD244', '李渝', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('37047FF3C3934D2CA3A581195309EA32', '熊运涛', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('3D2B4AB6AE48431F999F1FE8E70F90AB', '张世富', '78F1FFBE48EE451B88EE619036E9E906');
INSERT INTO `iot_user_user_role` VALUES ('3DE3775790A4462AB8883508C8B1A90', '179', '7A987B996C744EFAEC54B5855F7C98E');
INSERT INTO `iot_user_user_role` VALUES ('3EF646688B6548CD888C303FEFFD05FE', '赵沁宇', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('3F3D5AB3A9AF49AEA879FBFA0C7AD4D1', '岳志坚', 'B5F0C7F4C4BF482A88F7FB340F92E8A2');
INSERT INTO `iot_user_user_role` VALUES ('40D50CABD74447CD97A4985C749E0939', '李跃平', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('417C4F8683C74229974BEE3CD0F25E00', '赵浩', 'B5F0C7F4C4BF482A88F7FB340F92E8A2');
INSERT INTO `iot_user_user_role` VALUES ('421242534958431EAD96F73C1696DA24', '吴韵秋', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('42CD7180445940658846E4D862597F49', '李渝', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('434240A88C5A4749B1CC63ED8C41FEC1', '杨铁林', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('45CF2CD80DFE4021AFD6AE9B8FA408C6', '杨帆', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('494BCFCB45F84CC6A0D2515CBDA68F6F', '周孝胜', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('4BAF7B2513FE4925949E36285A44C23A', '邓尚渝', '9B494FC3182A4288A3FECA4F36785886');
INSERT INTO `iot_user_user_role` VALUES ('5598ADDC1FFB45ACA47C5C460BAEFC11', '曾钊伟', 'B5F0C7F4C4BF482A88F7FB340F92E8A2');
INSERT INTO `iot_user_user_role` VALUES ('59CEE991460340F9874B14B5F830497B', '梁革', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('5E39506CFE614F738EFE673844105FB1', '曾文革', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('6015525886FA450AA2D8DB4928BDEC1E', '黄娅', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('61E349600A6C4A08B54638399BABDA33', '刘进', 'B5F0C7F4C4BF482A88F7FB340F92E8A2');
INSERT INTO `iot_user_user_role` VALUES ('631CEC03C0A14DB7A4DD57402B9E8F97', '杨勇1', '3709C53C7AA7467E9866CE2473F32A06');
INSERT INTO `iot_user_user_role` VALUES ('64A834DAD2224D1595654481C17D3048', '曾文革', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('6684DCAF94714E5BA759423989CDBBF9', '杨正刚', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('687E32B868A14BFF9D74FE3BEE3F8627', '查先德', '78F1FFBE48EE451B88EE619036E9E906');
INSERT INTO `iot_user_user_role` VALUES ('69FBBB7EAC3C489C8F902B794DEBFA7C', '邓雪', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('6A3FD39B31634228B0F0EE1D1232644C', '蔡莉\r\n', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('6B5CB98D5B8F4172B973D75A3EEC0CC8', '周孝胜', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('7075AE5359F34FEA97B60545CA230C82', '班寒梅', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('7143BE7A2A2E404F9AE9B805F722F7FB', '班寒梅', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('7792BB604BDA49059F3E868CAE6ABFD0', '杨勇', '65C211FDB0DD40A99B7EFDE6C2143411');
INSERT INTO `iot_user_user_role` VALUES ('780D18C30278430396268E78CFF93FFC', '赵浩', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('7A5096062E634A268F662570D32A8C6F', '王琪', '8569B97F69794AB58214BFF9E8E3442B');
INSERT INTO `iot_user_user_role` VALUES ('7BF2ACB99D164AE098554FBA23BA70D0', '杨贤', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('7CCE6D2F74B94A66AC9351A230B9399C', '179', '2ba62c1a1414d7491eb05338d14c1c3');
INSERT INTO `iot_user_user_role` VALUES ('7F466BE57E214256977E7837A78ECF2C', '钟琴', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('871EE2D47DE64FCD997EA54B4681B89F', '曹杰', '8008A6E5656E4381AC2A0C262E3F694E');
INSERT INTO `iot_user_user_role` VALUES ('8890B40F2D9C4DF39BD32C49F0186F12', '邓欣', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('88DE209D1C994C339B9EDA89B3F238D4', '代超', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('8CF55C947318495094C603FBE4F68BDF', '吴韵秋', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('8DB4684420304440945A7029E9645FE1', '廖婉媚', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('93FD6867F29B42A9BC8F1E7BD78265AC', '陈波', '73D21E26D1B542E39865A7AA1CB74A5E');
INSERT INTO `iot_user_user_role` VALUES ('94F3C8E750B54843B6CF5DF29A432AEB', '段练', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('960F0D3803C14343BA2958D931F34E6D', '邓雪', '3F49C890CB8144698537CD9F8D8FA0B9');
INSERT INTO `iot_user_user_role` VALUES ('96BD4EF716654BD0B5D1842A0992F398', '蒲发勇', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('9A586528242E40BAAA0A41450E6B4870', '曹杰', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('9BDA70DE6B3A43B5A2D880ECBF29960C', '周景', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('9C3D03B341624EE3931DA6C68B7491AF', '钟云', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('9CCEB680508E47AEAC3CB80B87DD3029', '陈亮', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('A241BABBB923493FA9D6334ACF039CA7', '吴娇', '3709C53C7AA7467E9866CE2473F32A06');
INSERT INTO `iot_user_user_role` VALUES ('A2AC2E810315495489849673709C68C8', '贾勇\r\n', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('A48097120771467484003E85172BDCE8', '周珂', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('A55944C2E9AE4E718991D5B1BDEF6AB4', '江梦菲', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('A8B24C39958A459791A53E53744687AD', '曾玉', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('A9C784FDAD4544CE962715878E01F829', '曾钊伟', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('AB24A7202A974F979D00BA2364B059F', '172', 'BB8D6DDF91943C4BD15C3DE742147B8');
INSERT INTO `iot_user_user_role` VALUES ('ACEB19B5C7FD47B194CEC59638CCAC23', '苟列生', '3709C53C7AA7467E9866CE2473F32A06');
INSERT INTO `iot_user_user_role` VALUES ('B2E03E5D13434C91BC91D312BA828ABA', '钟云', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('B5A42DAEF1F9419F9A3F6C0F07CD04E2', '江山', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('B727880DD79C43328A80088775FA901C', '赵丹', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('B9961DE311ED4D009BF5AF4F3B363813', '伍治源', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('BAB2F1CA92834BA4880A3C8F09C28B27', '贾勇', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('BB5F6D48B1584B248B1EF0B01270FA48', '徐妤', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('C1403A32D65948E0809CF5E35AB216AB', '庄秀芳', '3F49C890CB8144698537CD9F8D8FA0B9');
INSERT INTO `iot_user_user_role` VALUES ('C1EF28EFA5C34035A993DED9979EE2D6', '冯志伟', '78F1FFBE48EE451B88EE619036E9E906');
INSERT INTO `iot_user_user_role` VALUES ('c368ce7af47711e99650448a5bee81ee', '严莉', '');
INSERT INTO `iot_user_user_role` VALUES ('c368cee0f47711e99650448a5bee81ee', '江婷婷', '');
INSERT INTO `iot_user_user_role` VALUES ('c368cef9f47711e99650448a5bee81ee', '李亚', '');
INSERT INTO `iot_user_user_role` VALUES ('c368cf0bf47711e99650448a5bee81ee', '邵强', '');
INSERT INTO `iot_user_user_role` VALUES ('C6D4A7007A5A48319172E1E6DBE65053', '李泳锡', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('CA143F083A5844D5B762307F89369E28', '段练', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('CA81F8186F444B56B29FA83F625AD2B0', '赵沁宇', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('CA90919AA43349CE97DECAFB0250E75C', '伍治源', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('CAFE3EB57B03477BA1759A60CF0FDFBD', '梁革', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('CBB8900EA15B498E8B5E48452E4FD73D', '张倩', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('CC842378B71643EDBF448BCC20F4F336', '黄世伟', '723BD1BD7414459F9FA499BE28B17FF2');
INSERT INTO `iot_user_user_role` VALUES ('CD0B3D56C8EA4FDBA655B334F317FAC0', '邓雪', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('CDB4350FC1874C7FA434FEE20F657540', '王琪', '65C211FDB0DD40A99B7EFDE6C2143411');
INSERT INTO `iot_user_user_role` VALUES ('CF06AB54D54C48A2B9DE1F7984117087', '杨铁林', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('CF9D6E579E544155ABB899E562AE459A', '陈念华', 'BAAD1EA0CD594F37A91B50C379D9016D');
INSERT INTO `iot_user_user_role` VALUES ('D0D360F329244715AD9DC4F8AE438994', '李云志', '78F1FFBE48EE451B88EE619036E9E906');
INSERT INTO `iot_user_user_role` VALUES ('D17F59FC055A49968A7B05D7EEBD6799', '叶华伦', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('D363BA8754BE4CB8B1191E8DF16C194B', '黄昱恺', '8569B97F69794AB58214BFF9E8E3442B');
INSERT INTO `iot_user_user_role` VALUES ('D5E8015926CC405FBE56B3811D3AE00', '172', 'D332D8E3AA94D0C9AEA287EC18FB31D');
INSERT INTO `iot_user_user_role` VALUES ('D5E8015926CC405FBE56B3811n3AE00', '172', 'DF1E1B39EEC48B39DD2E30CC4ED5820');
INSERT INTO `iot_user_user_role` VALUES ('D5E8015926CC405FBE56B3817D3AE00', '172', 'F2C4B20414C48F385DBF4F4595AF10F');
INSERT INTO `iot_user_user_role` VALUES ('D5E8015926CC405FBE56B3831D3AE00', '172', '9FF5CA9B0E94EA6BBC9CE21F08AF2F0');
INSERT INTO `iot_user_user_role` VALUES ('D60B36C201C94427A7DAC1FE497C7376', '曾文革', 'A9A1F373D3A0491493A9E2DE991780C3');
INSERT INTO `iot_user_user_role` VALUES ('D8FDEE8A6EF64B78B23DBA42309F7C09', '郭莹', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('DA32C2103F014186A8C7F80CEE808BF', '179', 'faf2158720e445fbdbf926846fdeb9a');
INSERT INTO `iot_user_user_role` VALUES ('DA8AF250FA3A428D977C912366DB830F', '李泳锡', 'B5F0C7F4C4BF482A88F7FB340F92E8A2');
INSERT INTO `iot_user_user_role` VALUES ('DB2A11EF79EC4353B987A83CC2C66E91', '苟列生', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('E10F2B5C26524B87B25DE7B98D582940', '叶华伦', 'A642FAE80A874BCD8BB145711E76BA1B');
INSERT INTO `iot_user_user_role` VALUES ('E2E688F803CD497DA8669C7C11BE8A87', '周蕙云', '6F46C2325D49450E89D4C1CB38B44FA7');
INSERT INTO `iot_user_user_role` VALUES ('E3B14C7B6227407693B28A7B3259BC55', '王敏', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('E51823A4FC134DCFB7619F6632A21748', '邓尚渝', '65C211FDB0DD40A99B7EFDE6C2143411');
INSERT INTO `iot_user_user_role` VALUES ('E5F02E234DB44CF28A8B9EEE4DE23E4D', '张秋林', '3709C53C7AA7467E9866CE2473F32A06');
INSERT INTO `iot_user_user_role` VALUES ('E5F60B73EFE246218A75B1A96080ADD3', '黄勇', '65C211FDB0DD40A99B7EFDE6C2143411');
INSERT INTO `iot_user_user_role` VALUES ('E6D084AA229B4E8A87C84B11C618D640', '杨勇', 'AEE1D55EE6D14FBB9E7835368075C6B5');
INSERT INTO `iot_user_user_role` VALUES ('E6F0A9D8D39F4BD9803584B0B9E8A771', '余虹钢', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('E71662C1780E493C8300B7C74D0E2B4B', '李红芳', '3709C53C7AA7467E9866CE2473F32A06');
INSERT INTO `iot_user_user_role` VALUES ('E77C3930AA704A4D9C347A45BAFA963', '172', 'D332D8E3AA94D0C9AEA287EC18FB31D');
INSERT INTO `iot_user_user_role` VALUES ('EA3887781EEA4003B133227862404CD9', '杜成丽', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('EBAB52FBD0634C67BDF3C2900B889A7F', '赵丹', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('EFA7D19529C44302ADF461474CB4589D', '杜成丽', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('F01BFB353FD14168987E3BD1E82335CA', '罗仁江', '723BD1BD7414459F9FA499BE28B17FF2');
INSERT INTO `iot_user_user_role` VALUES ('F0339ECE1CE047F897372CF898543DD8', '刘进', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('F1770B8774384A44910BC059EA522A9A', '杨贤', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('F3908AFF4D224311B0807EFC6A1BFB18', '杨庆', 'BF383CE2890B4E99AE0D1D41F4E199FC');
INSERT INTO `iot_user_user_role` VALUES ('F4527D6D9C15493B8F6641483B6267AC', '钟琴', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('F5D097737F954BFAA185E232CD3E25A6', '董栖君', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('F8033C9BDB7B485482E8A43C2101563C', '杨帆', '26674768CDA449FA9F677F9B9F4FF0D2');
INSERT INTO `iot_user_user_role` VALUES ('FBDD932631884F10AA43104CC6164562', '许尔明', '1546015664FE4CF99D898FAC7DBE3971');
INSERT INTO `iot_user_user_role` VALUES ('FD6F67A36346407A81679169406A0853', '李跃平', '26674768CDA449FA9F677F9B9F4FF0D2');
