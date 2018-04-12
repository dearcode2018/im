/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : openfire

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-07-07 15:02:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ofgroup`
-- ----------------------------
DROP TABLE IF EXISTS `ofgroup`;
CREATE TABLE `ofgroup` (
  `groupName` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groupName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofgroup
-- ----------------------------
INSERT INTO `ofgroup` VALUES ('admin', '????');
INSERT INTO `ofgroup` VALUES ('user', '???');

-- ----------------------------
-- Table structure for `ofgroupprop`
-- ----------------------------
DROP TABLE IF EXISTS `ofgroupprop`;
CREATE TABLE `ofgroupprop` (
  `groupName` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`groupName`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofgroupprop
-- ----------------------------
INSERT INTO `ofgroupprop` VALUES ('admin', 'sharedRoster.displayName', '');
INSERT INTO `ofgroupprop` VALUES ('admin', 'sharedRoster.groupList', '');
INSERT INTO `ofgroupprop` VALUES ('admin', 'sharedRoster.showInRoster', 'nobody');
INSERT INTO `ofgroupprop` VALUES ('user', 'sharedRoster.displayName', '');
INSERT INTO `ofgroupprop` VALUES ('user', 'sharedRoster.groupList', '');
INSERT INTO `ofgroupprop` VALUES ('user', 'sharedRoster.showInRoster', 'nobody');

-- ----------------------------
-- Table structure for `ofgroupuser`
-- ----------------------------
DROP TABLE IF EXISTS `ofgroupuser`;
CREATE TABLE `ofgroupuser` (
  `groupName` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `administrator` tinyint(4) NOT NULL,
  PRIMARY KEY (`groupName`,`username`,`administrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofgroupuser
-- ----------------------------
INSERT INTO `ofgroupuser` VALUES ('admin', 'admin', '0');
INSERT INTO `ofgroupuser` VALUES ('user', 'test', '0');
INSERT INTO `ofgroupuser` VALUES ('user', 'user', '0');

-- ----------------------------
-- Table structure for `ofid`
-- ----------------------------
DROP TABLE IF EXISTS `ofid`;
CREATE TABLE `ofid` (
  `idType` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofid
-- ----------------------------
INSERT INTO `ofid` VALUES ('18', '6');
INSERT INTO `ofid` VALUES ('19', '76');
INSERT INTO `ofid` VALUES ('23', '1');
INSERT INTO `ofid` VALUES ('25', '9');
INSERT INTO `ofid` VALUES ('26', '2');

-- ----------------------------
-- Table structure for `ofoffline`
-- ----------------------------
DROP TABLE IF EXISTS `ofoffline`;
CREATE TABLE `ofoffline` (
  `username` varchar(64) NOT NULL,
  `messageID` bigint(20) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `messageSize` int(11) NOT NULL,
  `stanza` text NOT NULL,
  PRIMARY KEY (`username`,`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofoffline
-- ----------------------------
INSERT INTO `ofoffline` VALUES ('test', '72', '001436251780113', '193', '<message id=\"06pId-160\" to=\"test@com.hua.openfire/Smack\" from=\"user@com.hua.openfire/Spark\" type=\"chat\"><thread>1JSKW85</thread><active xmlns=\"http://jabber.org/protocol/chatstates\"/></message>');
INSERT INTO `ofoffline` VALUES ('test', '73', '001436251781324', '195', '<message id=\"06pId-161\" to=\"test@com.hua.openfire/Smack\" from=\"user@com.hua.openfire/Spark\" type=\"chat\"><thread>1JSKW86</thread><inactive xmlns=\"http://jabber.org/protocol/chatstates\"/></message>');
INSERT INTO `ofoffline` VALUES ('workisverygood', '16', '001436232756086', '194', '<message id=\"cg4Ed-39\" to=\"workisverygood@com.hua.openfire\" from=\"admin@com.hua.openfire/Spark\" type=\"chat\"><thread>cNae50</thread><gone xmlns=\"http://jabber.org/protocol/chatstates\"/></message>');

-- ----------------------------
-- Table structure for `ofpresence`
-- ----------------------------
DROP TABLE IF EXISTS `ofpresence`;
CREATE TABLE `ofpresence` (
  `username` varchar(64) NOT NULL,
  `offlinePresence` text,
  `offlineDate` char(15) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpresence
-- ----------------------------
INSERT INTO `ofpresence` VALUES ('admin', null, '001436251598120');
INSERT INTO `ofpresence` VALUES ('test', null, '001436251763046');
INSERT INTO `ofpresence` VALUES ('user', null, '001436251783609');

-- ----------------------------
-- Table structure for `ofprivate`
-- ----------------------------
DROP TABLE IF EXISTS `ofprivate`;
CREATE TABLE `ofprivate` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `namespace` varchar(200) NOT NULL,
  `privateData` text NOT NULL,
  PRIMARY KEY (`username`,`name`,`namespace`(100))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofprivate
-- ----------------------------

-- ----------------------------
-- Table structure for `ofproperty`
-- ----------------------------
DROP TABLE IF EXISTS `ofproperty`;
CREATE TABLE `ofproperty` (
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofproperty
-- ----------------------------
INSERT INTO `ofproperty` VALUES ('adminConsole.port', '9090');
INSERT INTO `ofproperty` VALUES ('adminConsole.securePort', '9091');
INSERT INTO `ofproperty` VALUES ('connectionProvider.className', 'org.jivesoftware.database.DefaultConnectionProvider');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.connectionTimeout', '1.0');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.driver', 'com.mysql.jdbc.Driver');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.maxConnections', '25');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.minConnections', '5');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.password', '0f39577dbf8bf06563f5e7dc23a84c1a944d87a6e620b6a6');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.serverURL', 'jdbc:mysql://127.0.0.1:3306/openfire?rewriteBatchedStatements=true');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.testAfterUse', 'false');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.testBeforeUse', 'false');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.testSQL', 'select 1');
INSERT INTO `ofproperty` VALUES ('database.defaultProvider.username', '7f5a62c5f0f4e825afa9e06c026cdb4d82f43fa8fdd7b0e3');
INSERT INTO `ofproperty` VALUES ('locale', 'zh_CN');
INSERT INTO `ofproperty` VALUES ('passwordKey', 'GUd2gLH3htkB2hq');
INSERT INTO `ofproperty` VALUES ('provider.admin.className', 'org.jivesoftware.openfire.admin.DefaultAdminProvider');
INSERT INTO `ofproperty` VALUES ('provider.auth.className', 'org.jivesoftware.openfire.auth.DefaultAuthProvider');
INSERT INTO `ofproperty` VALUES ('provider.group.className', 'org.jivesoftware.openfire.group.DefaultGroupProvider');
INSERT INTO `ofproperty` VALUES ('provider.lockout.className', 'org.jivesoftware.openfire.lockout.DefaultLockOutProvider');
INSERT INTO `ofproperty` VALUES ('provider.securityAudit.className', 'org.jivesoftware.openfire.security.DefaultSecurityAuditProvider');
INSERT INTO `ofproperty` VALUES ('provider.user.className', 'org.jivesoftware.openfire.user.DefaultUserProvider');
INSERT INTO `ofproperty` VALUES ('provider.vcard.className', 'org.jivesoftware.openfire.vcard.DefaultVCardProvider');
INSERT INTO `ofproperty` VALUES ('setup', 'true');
INSERT INTO `ofproperty` VALUES ('update.lastCheck', '1436231491258');
INSERT INTO `ofproperty` VALUES ('xmpp.auth.anonymous', 'true');
INSERT INTO `ofproperty` VALUES ('xmpp.client.tls.policy', 'disabled');
INSERT INTO `ofproperty` VALUES ('xmpp.domain', 'com.hua.openfire');
INSERT INTO `ofproperty` VALUES ('xmpp.server.certificate.accept-selfsigned', 'false');
INSERT INTO `ofproperty` VALUES ('xmpp.server.dialback.enabled', 'true');
INSERT INTO `ofproperty` VALUES ('xmpp.server.tls.enabled', 'true');
INSERT INTO `ofproperty` VALUES ('xmpp.session.conflict-limit', '0');
INSERT INTO `ofproperty` VALUES ('xmpp.socket.ssl.active', 'false');

-- ----------------------------
-- Table structure for `ofpubsubaffiliation`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubaffiliation`;
CREATE TABLE `ofpubsubaffiliation` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `affiliation` varchar(10) NOT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubaffiliation
-- ----------------------------
INSERT INTO `ofpubsubaffiliation` VALUES ('pubsub', '', 'com.hua.openfire', 'owner');

-- ----------------------------
-- Table structure for `ofpubsubdefaultconf`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubdefaultconf`;
CREATE TABLE `ofpubsubdefaultconf` (
  `serviceID` varchar(100) NOT NULL,
  `leaf` tinyint(4) NOT NULL,
  `deliverPayloads` tinyint(4) NOT NULL,
  `maxPayloadSize` int(11) NOT NULL,
  `persistItems` tinyint(4) NOT NULL,
  `maxItems` int(11) NOT NULL,
  `notifyConfigChanges` tinyint(4) NOT NULL,
  `notifyDelete` tinyint(4) NOT NULL,
  `notifyRetract` tinyint(4) NOT NULL,
  `presenceBased` tinyint(4) NOT NULL,
  `sendItemSubscribe` tinyint(4) NOT NULL,
  `publisherModel` varchar(15) NOT NULL,
  `subscriptionEnabled` tinyint(4) NOT NULL,
  `accessModel` varchar(10) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `replyPolicy` varchar(15) DEFAULT NULL,
  `associationPolicy` varchar(15) NOT NULL,
  `maxLeafNodes` int(11) NOT NULL,
  PRIMARY KEY (`serviceID`,`leaf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubdefaultconf
-- ----------------------------
INSERT INTO `ofpubsubdefaultconf` VALUES ('pubsub', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', 'publishers', '1', 'open', 'English', null, 'all', '-1');
INSERT INTO `ofpubsubdefaultconf` VALUES ('pubsub', '1', '1', '5120', '0', '-1', '1', '1', '1', '0', '1', 'publishers', '1', 'open', 'English', null, 'all', '-1');

-- ----------------------------
-- Table structure for `ofpubsubitem`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubitem`;
CREATE TABLE `ofpubsubitem` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `payload` mediumtext,
  PRIMARY KEY (`serviceID`,`nodeID`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubitem
-- ----------------------------

-- ----------------------------
-- Table structure for `ofpubsubnode`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubnode`;
CREATE TABLE `ofpubsubnode` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `leaf` tinyint(4) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `parent` varchar(100) DEFAULT NULL,
  `deliverPayloads` tinyint(4) NOT NULL,
  `maxPayloadSize` int(11) DEFAULT NULL,
  `persistItems` tinyint(4) DEFAULT NULL,
  `maxItems` int(11) DEFAULT NULL,
  `notifyConfigChanges` tinyint(4) NOT NULL,
  `notifyDelete` tinyint(4) NOT NULL,
  `notifyRetract` tinyint(4) NOT NULL,
  `presenceBased` tinyint(4) NOT NULL,
  `sendItemSubscribe` tinyint(4) NOT NULL,
  `publisherModel` varchar(15) NOT NULL,
  `subscriptionEnabled` tinyint(4) NOT NULL,
  `configSubscription` tinyint(4) NOT NULL,
  `accessModel` varchar(10) NOT NULL,
  `payloadType` varchar(100) DEFAULT NULL,
  `bodyXSLT` varchar(100) DEFAULT NULL,
  `dataformXSLT` varchar(100) DEFAULT NULL,
  `creator` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `replyPolicy` varchar(15) DEFAULT NULL,
  `associationPolicy` varchar(15) DEFAULT NULL,
  `maxLeafNodes` int(11) DEFAULT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubnode
-- ----------------------------
INSERT INTO `ofpubsubnode` VALUES ('pubsub', '', '0', '001436231246525', '001436231246525', null, '0', '0', '0', '0', '1', '1', '1', '0', '0', 'publishers', '1', '0', 'open', '', '', '', 'com.hua.openfire', '', 'English', '', null, 'all', '-1');

-- ----------------------------
-- Table structure for `ofpubsubnodegroups`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubnodegroups`;
CREATE TABLE `ofpubsubnodegroups` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `rosterGroup` varchar(100) NOT NULL,
  KEY `ofPubsubNodeGroups_idx` (`serviceID`,`nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubnodegroups
-- ----------------------------

-- ----------------------------
-- Table structure for `ofpubsubnodejids`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubnodejids`;
CREATE TABLE `ofpubsubnodejids` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `associationType` varchar(20) NOT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubnodejids
-- ----------------------------

-- ----------------------------
-- Table structure for `ofpubsubsubscription`
-- ----------------------------
DROP TABLE IF EXISTS `ofpubsubsubscription`;
CREATE TABLE `ofpubsubsubscription` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `state` varchar(15) NOT NULL,
  `deliver` tinyint(4) NOT NULL,
  `digest` tinyint(4) NOT NULL,
  `digest_frequency` int(11) NOT NULL,
  `expire` char(15) DEFAULT NULL,
  `includeBody` tinyint(4) NOT NULL,
  `showValues` varchar(30) DEFAULT NULL,
  `subscriptionType` varchar(10) NOT NULL,
  `subscriptionDepth` tinyint(4) NOT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofpubsubsubscription
-- ----------------------------

-- ----------------------------
-- Table structure for `ofroster`
-- ----------------------------
DROP TABLE IF EXISTS `ofroster`;
CREATE TABLE `ofroster` (
  `rosterID` bigint(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `jid` varchar(1024) NOT NULL,
  `sub` tinyint(4) NOT NULL,
  `ask` tinyint(4) NOT NULL,
  `recv` tinyint(4) NOT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rosterID`),
  KEY `ofRoster_unameid_idx` (`username`),
  KEY `ofRoster_jid_idx` (`jid`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofroster
-- ----------------------------
INSERT INTO `ofroster` VALUES ('1', 'user', 'test@com.hua.openfire', '3', '-1', '-1', 'test');
INSERT INTO `ofroster` VALUES ('2', 'test', 'user@com.hua.openfire', '3', '-1', '-1', 'user');
INSERT INTO `ofroster` VALUES ('3', 'workisverygood', 'admin@com.hua.openfire', '1', '-1', '1', 'admin');
INSERT INTO `ofroster` VALUES ('4', 'admin', 'workisverygood@com.hua.openfire', '2', '0', '-1', 'workisverygood');

-- ----------------------------
-- Table structure for `ofrostergroups`
-- ----------------------------
DROP TABLE IF EXISTS `ofrostergroups`;
CREATE TABLE `ofrostergroups` (
  `rosterID` bigint(20) NOT NULL,
  `rank` tinyint(4) NOT NULL,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY (`rosterID`,`rank`),
  KEY `ofRosterGroup_rosterid_idx` (`rosterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofrostergroups
-- ----------------------------
INSERT INTO `ofrostergroups` VALUES ('1', '0', 'Friends');
INSERT INTO `ofrostergroups` VALUES ('2', '0', 'Friends');
INSERT INTO `ofrostergroups` VALUES ('3', '0', 'Friends');
INSERT INTO `ofrostergroups` VALUES ('4', '0', 'Friends');

-- ----------------------------
-- Table structure for `ofuser`
-- ----------------------------
DROP TABLE IF EXISTS `ofuser`;
CREATE TABLE `ofuser` (
  `username` varchar(64) NOT NULL,
  `plainPassword` varchar(32) DEFAULT NULL,
  `encryptedPassword` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `ofUser_cDate_idx` (`creationDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofuser
-- ----------------------------
INSERT INTO `ofuser` VALUES ('admin', null, '9fbe3a54ccf970d9a33971c76c05c0c432cb9002d5532fec', 'Administrator', 'dearzqy2010@qq.com', '001436231452728', '0');
INSERT INTO `ofuser` VALUES ('test', null, '2836af12da256ec9e40034da68e4197381652e406a58a926', 'test', null, '001436231847026', '001436231847026');
INSERT INTO `ofuser` VALUES ('user', null, 'fc1978a1b199ab01d81517e717faed7455d870492c35f6c6', 'user', null, '001436231863427', '001436231863427');
INSERT INTO `ofuser` VALUES ('workisverygood', null, 'c851e6382078b12906b2722d073b4695ae9e5ebd04551a2efbccd9494c587cf17b8e19c70010c9fa', null, null, '001436232602787', '001436232602787');

-- ----------------------------
-- Table structure for `ofuserflag`
-- ----------------------------
DROP TABLE IF EXISTS `ofuserflag`;
CREATE TABLE `ofuserflag` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `startTime` char(15) DEFAULT NULL,
  `endTime` char(15) DEFAULT NULL,
  PRIMARY KEY (`username`,`name`),
  KEY `ofUserFlag_sTime_idx` (`startTime`),
  KEY `ofUserFlag_eTime_idx` (`endTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofuserflag
-- ----------------------------

-- ----------------------------
-- Table structure for `ofuserprop`
-- ----------------------------
DROP TABLE IF EXISTS `ofuserprop`;
CREATE TABLE `ofuserprop` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`username`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofuserprop
-- ----------------------------

-- ----------------------------
-- Table structure for `ofvcard`
-- ----------------------------
DROP TABLE IF EXISTS `ofvcard`;
CREATE TABLE `ofvcard` (
  `username` varchar(64) NOT NULL,
  `vcard` mediumtext NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofvcard
-- ----------------------------
INSERT INTO `ofvcard` VALUES ('workisverygood', '<vCard xmlns=\"vcard-temp\"><N><FAMILY/>\n<GIVEN>workisverygood hha</GIVEN>\n<MIDDLE/>\n</N>\n<ORG><ORGNAME/>\n<ORGUNIT/>\n</ORG>\n<FN>workisverygood hha</FN>\n<URL/>\n<TITLE/>\n<NICKNAME>nicheng hhah</NICKNAME>\n<EMAIL><HOME/><INTERNET/><PREF/><USERID/>\n</EMAIL>\n<TEL><PAGER/><WORK/><NUMBER/>\n</TEL>\n<TEL><CELL/><WORK/><NUMBER/>\n</TEL>\n<TEL><VOICE/><WORK/><NUMBER/>\n</TEL>\n<TEL><FAX/><WORK/><NUMBER/>\n</TEL>\n<TEL><PAGER/><HOME/><NUMBER/>\n</TEL>\n<TEL><CELL/><HOME/><NUMBER/>\n</TEL>\n<TEL><VOICE/><HOME/><NUMBER/>\n</TEL>\n<TEL><FAX/><HOME/><NUMBER/>\n</TEL>\n<ADR><WORK/><PCODE/>\n<REGION/>\n<STREET/>\n<CTRY/>\n<LOCALITY/>\n</ADR>\n<ADR><HOME/><PCODE/>\n<REGION/>\n<STREET/>\n<CTRY/>\n<LOCALITY/>\n</ADR>\n</vCard>');

-- ----------------------------
-- Table structure for `ofversion`
-- ----------------------------
DROP TABLE IF EXISTS `ofversion`;
CREATE TABLE `ofversion` (
  `name` varchar(50) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ofversion
-- ----------------------------
INSERT INTO `ofversion` VALUES ('openfire', '21');
