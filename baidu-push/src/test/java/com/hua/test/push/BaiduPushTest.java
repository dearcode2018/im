/**
 * 描述: 
 * BaiduPushTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.push;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.model.AddDevicesToTagRequest;
import com.baidu.yun.push.model.AddDevicesToTagResponse;
import com.baidu.yun.push.model.CreateTagRequest;
import com.baidu.yun.push.model.CreateTagResponse;
import com.baidu.yun.push.model.DeleteDevicesFromTagRequest;
import com.baidu.yun.push.model.DeleteDevicesFromTagResponse;
import com.baidu.yun.push.model.DeleteTagRequest;
import com.baidu.yun.push.model.DeleteTagResponse;
import com.baidu.yun.push.model.DeviceInfo;
import com.baidu.yun.push.model.KeyValueForDevice;
import com.baidu.yun.push.model.KeyValueForMsg;
import com.baidu.yun.push.model.KeyValueForTopic;
import com.baidu.yun.push.model.MsgSendInfo;
import com.baidu.yun.push.model.MsgStatInfo;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.baidu.yun.push.model.PushMsgToSmartTagRequest;
import com.baidu.yun.push.model.PushMsgToSmartTagResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.baidu.yun.push.model.QueryDeviceNumInTagRequest;
import com.baidu.yun.push.model.QueryDeviceNumInTagResponse;
import com.baidu.yun.push.model.QueryMsgStatusRequest;
import com.baidu.yun.push.model.QueryMsgStatusResponse;
import com.baidu.yun.push.model.QueryStatisticDeviceRequest;
import com.baidu.yun.push.model.QueryStatisticDeviceResponse;
import com.baidu.yun.push.model.QueryStatisticMsgRequest;
import com.baidu.yun.push.model.QueryStatisticMsgResponse;
import com.baidu.yun.push.model.QueryStatisticTopicRequest;
import com.baidu.yun.push.model.QueryStatisticTopicResponse;
import com.baidu.yun.push.model.QueryTagsRequest;
import com.baidu.yun.push.model.QueryTagsResponse;
import com.baidu.yun.push.model.QueryTimerListRequest;
import com.baidu.yun.push.model.QueryTimerListResponse;
import com.baidu.yun.push.model.QueryTimerRecordsRequest;
import com.baidu.yun.push.model.QueryTimerRecordsResponse;
import com.baidu.yun.push.model.QueryTopicListRequest;
import com.baidu.yun.push.model.QueryTopicListResponse;
import com.baidu.yun.push.model.QueryTopicRecordsRequest;
import com.baidu.yun.push.model.QueryTopicRecordsResponse;
import com.baidu.yun.push.model.Record;
import com.baidu.yun.push.model.TagInfo;
import com.baidu.yun.push.model.TimerResultInfo;
import com.baidu.yun.push.model.TopicResultInfo;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * BaiduPushTest
 */
public final class BaiduPushTest extends BaseTest {

	/**
	 * 百度推送
	 * 
	 * ak=WmmqGhrglDmznnfflATms4tx
	 * 
	 * 
	 * 名称：安卓消息推送
	 * D：6607194
	 * API Key：zoqrbgWnH56CoEFvIlpPZ9V7
	 * Secret Key：g3BY0ITeTy88Xo9MReHQQvS8XIk64c5w
	 * 
	 * 
	 * 设备信息:
	 * onBind errorCode=0 appid=6607194 userId=969405660452316832 
	 * channelId=4134624474921335860 requestId=1328891826
	 * 
	 */
	
	/* 开发者帐号 - 应用详情 apiKey */
	private String apiKey = "zoqrbgWnH56CoEFvIlpPZ9V7";
	
	/* 开发者帐号 - 应用详情 secretKey */
	private String secretKey = "g3BY0ITeTy88Xo9MReHQQvS8XIk64c5w";
	
	/* 单播测试-安卓设备 渠道id */
	private String channelId = "4134624474921335860";
	
	/* 百度推送域名 常量: BaiduPushConstants.CHANNEL_REST_URL */
	private String host = "api.push.baidu.com";
	

	/**
	 * 异常: 
	 * PushClientException 
	 * PushServerException
	 * catch (PushClientException e) {
            //ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,
            //'true' 表示抛出, 'false' 表示捕获。
            if (BaiduPushConstants.ERROROPTTYPE) { 
                throw e;
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                System.out.println(String.format(
                        "requestId: %d, errorCode: %d, errorMsg: %s",
                        e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBaiduPush() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBaiduPush =====> ", e);
		}
	}

	/** TODO ========================== 基础功能接口 ========================== */
	/**
	 * 
	 * 描述: 单播 (向单个设备推送消息) 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushMsgToSingleDevice() {
		try {
		     /*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushMsgToSingleDeviceRequest request =  new PushMsgToSingleDeviceRequest();
			// 设置 渠道id (安装了指定app的设备 渠道id)
			request.addChannelId(channelId);
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushMsgToSingleDevice!\"}";
			request.addMessage(message);
			
			// 5. 执行http请求
			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
        } catch (Exception e) {
			log.error("testPushMsgToSingleDevice =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 广播 (推送消息给所有设备)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushMsgToAll() {
		try {
			 /*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushMsgToAllRequest request =  new PushMsgToAllRequest();
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushMsgToAll!\"}";
			request.addMessage(message);
			/*
			 * 设置定时发送 单位: 秒 
			 * 待发送时间戳，必须在当前时间60s以外，1年（31536000s）以内
			 * 设置指定的时间点发送，用秒来描述.
			 */
		    // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例70秒后推送
			//request.setSendTime(System.currentTimeMillis() / 1000 + 70);
			
			// 5. 执行http请求
			PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
			
		} catch (Exception e) {
			log.error("testPushMsgToAll =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 组播 (按标签分组 向绑定到tag中的用户推送消息，即普通组播)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushMsgToTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushMsgToTagRequest request =  new PushMsgToTagRequest();
			/*
			 * 设置要推送的标签名称 (单个标签)
			 * 标签不存在 会抛异常，
			 */
			request.addTagName("sunday");
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			/*
			 * 设置定时发送 单位: 秒 
			 * 待发送时间戳，必须在当前时间60s以外，1年（31536000s）以内
			 * 设置指定的时间点发送，用秒来描述.
			 */
		    // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例70秒后推送
			//request.setSendTime(System.currentTimeMillis() / 1000 + 70);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushMsgToTag!\"}";
			request.addMessage(message);
			
			// 5. 执行http请求
			PushMsgToTagResponse response = pushClient.pushMsgToTag(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
			
		} catch (Exception e) {
			log.error("testPushMsgToTag =====> ", e);
		}
	}
	
	/** TODO ========================== 高级功能接口  ========================== */
	/**
	 * 
	 * 描述: 组播 (按标签分组)
	 * 推送消息给指定的标签组。注：目前开放组合运算功能，仅对Android平台有效。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushMsgToSmartTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushMsgToSmartTagRequest request =  new PushMsgToSmartTagRequest();
			
			// "AND":交,"OR":并,"DIFF":差
	         // example.2 {"OR":[{"tag":"xxxx"},{"tag":"xxxx"}]}
            // JSONObject firstTag = new JSONObject();
            // firstTag.put("tag", "xxxx");
			// net.sf.json.JSONObject
            // JSONObject secondTag = new JSONObject();
            // secondTag.put("tag", "xxxx");
            // JSONArray tagArray = new JSONArray();
            // tagArray.add(0, firstTag);
            // tagArray.add(1, secondTag);
            // selector.put("OR", tagArray);			
			String selectContent = null;
			// selectContent = "{\"AND\":[{\"tag\":\"xxxx\"},{\"tag\":\"xxxx\"}]}";
			// selectContent = "{\"OR\":[{\"tag\":\"xxxx\"},{\"tag\":\"xxxx\"}]}";
			// selectContent = "{\"DIFF\":[{\"tag\":\"xxxx\"},{\"tag\":\"xxxx\"}]}";
			 selectContent = "{\"OR\":[{\"tag\":\"sunday\"},{\"tag\":\"monday\"}]}";
			// 设置 标签选择器
			 request.addSelector(selectContent);
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			/*
			 * 设置定时发送 单位: 秒 
			 * 待发送时间戳，必须在当前时间60s以外，1年（31536000s）以内
			 * 设置指定的时间点发送，用秒来描述.
			 */
		    // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例70秒后推送
			//request.setSendTime(System.currentTimeMillis() / 1000 + 70);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushMsgToSmartTag!\"}";
			request.addMessage(message);
			
			// 5. 执行http请求
			PushMsgToSmartTagResponse response = pushClient.pushMsgToSmartTag(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
			
		} catch (Exception e) {
			log.error("testPushMsgToSmartTag =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 推送消息给批量设备（批量单播）
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushBatchUniMsg() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushBatchUniMsgRequest request =  new PushBatchUniMsgRequest();
			// 渠道数组，渠道id不存在不会抛异常
			String[] channelIds = {"4134624474921335860", "111"};
			request.addChannelIds(channelIds);
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			// 设置类别主题 正则:  [_0-9a-zA-Z] and length less than or equal 128"}]
			request.addTopicId("topicId_pushBatchUniMsg");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushBatchUniMsg!\"}";
			request.addMessage(message);
			
			// 5. 执行http请求
			PushBatchUniMsgResponse response = pushClient.pushBatchUniMsg(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
			
		} catch (Exception e) {
			log.error("testPushBatchUniMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询消息推送状态，包括成功、失败、待发送、发送中4种状态。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryMsgStatus() {
		try {
			// msg_id: 4379556434527904723
			/**
			 * msgStatus
			 * 0：已发送
			 * 1：待发送
			 * 2：正在发送
			 * 3：失败
			 */
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryMsgStatusRequest request =  new QueryMsgStatusRequest();

			// 消息id数组，id不存在不会抛异常
			String[] msgIds = {"4379556434527904723", "11"};
			// 单个 addMsgId 或多个 addMsgIds
			request.addMsgIds(msgIds);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			
			// 5. 执行http请求
			QueryMsgStatusResponse response = pushClient.queryMsgStatus(request);
			
			// 6. http 请求返回值解析
            System.out.println("totalNum: " + response.getTotalNum() + "\n"
                    + "result:");
            // 遍历输出 MsgSendInfo
            if (null != response) {
                List<MsgSendInfo> list = response.getMsgSendInfos();
                for (int i = 0; i < list.size(); i++) {
                    MsgSendInfo msgSendInfo = list.get(i);
                    StringBuilder strBuilder = new StringBuilder();
                    strBuilder.append("List[" + i + "]: {" + "msgId = "
                            + msgSendInfo.getMsgId() + ",status = "
                            + msgSendInfo.getMsgStatus() + ",sendTime = "
                            + msgSendInfo.getSendTime() + ",successCount = "
                            + msgSendInfo.getSuccessCount());
                    strBuilder.append("}\n");
                    System.out.println(strBuilder.toString());
                }
            }            
            
			
		} catch (Exception e) {
			log.error("testQueryMsgStatus =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 根据 timerId，获取一个定时的消息推送记录。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryTimerRecords() {
		try {
			/*
			 * {"msg_id":"6617556851108257907","send_time":"1439371685","timer_id":"6193663463702746611"}}
			 */
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryTimerRecordsRequest request =  new QueryTimerRecordsRequest();
			// 设置 定时任务的id
			request.addTimerId("6193663463702746611");
			// 查询记录数 整数：[1,100]，默认值为100
			request.addLimit(50);
			/*
			 * Given timestamp of range_end out range 90 days
			 * 注意: unix timestamp
			 */
			//设置查询开始时间 这样写参数不是unix timestamp
			//request.addRangeStart(System.currentTimeMillis() / 1000 - 500);
			//设置查询结束时间 这样写参数不是unix timestamp
			//request.addRangeEnd(System.currentTimeMillis() / 1000);
			
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			
			// 5. 执行http请求
			QueryTimerRecordsResponse response = pushClient.queryTimerRecords(request);
			
			// 6. http 请求返回值解析
			   System.out.println("timerId: " + response.getTimerId()
	                    + "\nresult: \n");
			   if (null != response) {
	                List<Record> list = response.getTimerRecords();
	                for (int i = 0; i < list.size(); i++) {
                        Record record =  list.get(i);
                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append("List[" + i + "]: {" + "msgId = "
                                + record.getMsgId() + ",status = "
                                + record.getMsgStatus() + ",sendTime = "
                                + record.getSendTime() + "}");
                        System.out.println(strBuilder.toString());
	                }
	            }
		} catch (Exception e) {
			log.error("testQueryTimerRecords =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 根据 topic_id， 获取相应时间范围内的消息推送记录。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryTopicRecords() {
		try {
			// topicId_pushBatchUniMsg
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryTopicRecordsRequest request =  new QueryTopicRecordsRequest();
			// 设置主体id
			request.addTopicId("topicId_pushBatchUniMsg");
			// 起始记录
			request.addStart(0);
			// 查询数据大小
			request.addLimit(50);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			
			// 5. 执行http请求
			QueryTopicRecordsResponse response = pushClient.queryTopicRecords(request);
			
			// 6. http 请求返回值解析
	          StringBuilder strBuilder = new StringBuilder();
	            if (null != response) {
	                strBuilder.append("topicId: " + response.getTopicId() + "\n"
	                        + "result:{");
	                List<Record> list = response.getTopicRecords();
	                for (int i = 0; i < list.size(); i++) {
	                    if (i != 0) {
	                        strBuilder.append(",");
	                    }
                        Record record = list.get(i);
                        strBuilder
                                .append("{msgId: " + record.getMsgId()
                                        + ", status: " + record.getMsgStatus()
                                        + ", sendTime: " + record.getSendTime()
                                        + "}\n");
	                }
	                strBuilder.append("}");
	                System.out.println(strBuilder.toString());
	            }
			
		} catch (Exception e) {
			log.error("testQueryTopicRecords =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询定时推送任务信息列表。目前，每个应用可设置10个有效的定时任务。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryTimerList() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryTimerListRequest request =  new QueryTimerListRequest();
			// [1,10]
			// 起始记录
			request.addStart(1);
			// 查询数据大小
			request.addLimit(10);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			QueryTimerListResponse response = pushClient.queryTimerList(request);
			
			// 6. http 请求返回值解析
			 System.out.println("totalNum: " + response.getTotalNum() + "\n"
	                    + "result:");
	            if (null != response) {
	                List<TimerResultInfo> list = response.getTimerResultInfos();
	                for (int i = 0; i < list.size(); i++) {
	                    StringBuilder strBuilder = new StringBuilder();
                        TimerResultInfo timerResult = list.get(i);
                        strBuilder.append("List[" + i + "]: " + "timerId= "
                                + timerResult.getTimerId() + ",sendTime= "
                                + timerResult.getSendTime() + ",= "
                                + timerResult.getSendTime() + ",msgType= "
                                + timerResult.getMsgType() + ",rangeType= "
                                + timerResult.getRangeType() + "\n");
	                    System.out.println(strBuilder.toString());
	                }
	            }    
			
		} catch (Exception e) {
			log.error("testQueryTimerList =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询当前90天内消息推送中使用的类别主题的信息。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryTopicList() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryTopicListRequest request =  new QueryTopicListRequest();
			// 起始记录，从0开始
			request.addStart(0);
			// 范围[1,20]，默认值为20
			// 查询数据大小
			request.addLimit(10);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			QueryTopicListResponse response = pushClient.queryTopicList(request);
			
			// 6. http 请求返回值解析
	        System.out.println("totalNum: " + response.getTotalNum() + "\n"
                    + "result:");
	        if (null != response) {
                List<TopicResultInfo> list = response.getTimerResultInfos();
                for (int i = 0; i < list.size(); i++) {
                    StringBuilder strBuilder = new StringBuilder();
                        TopicResultInfo topicResult = list.get(i);
                        strBuilder.append("List[" + i + "]: " + "topicId= "
                                + topicResult.getTopicId() + ",firstPushTime= "
                                + topicResult.getFirstPushTime()
                                + ",lastPushTime= "
                                + topicResult.getLastPushTime()
                                + ",totalPushDevsNum= "
                                + topicResult.getTotalPushDevsNum()
                                + ",totalAckDevsNum= "
                                + topicResult.getTotalAckDevsNum());
                    System.out.println(strBuilder.toString());
                }
            }
		} catch (Exception e) {
			log.error("testQueryTopicList =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询用户定义的标签组信息。
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryTags() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryTagsRequest request =  new QueryTagsRequest();
			/*
			 * 设置标签名称
			 * 标签变量，不传则获取app下所有标签信息
			 */
			//request.addTagName("sunday");
			//request.addTagName("default");
			// 起始记录，从0开始
			request.addStart(0);
			// [1,100]，默认值为100 	
			// 查询数据大小
			request.addLimit(10);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			// 5. 执行http请求
			QueryTagsResponse response = pushClient.queryTags(request);
			
			/*
			 * tagId=66575705,tag=monday,info=monday6607194,type=2,creatTime=1439369461
			 */
			// 6. http 请求返回值解析
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("totalNum: " + response.getTotalNum() + "\n");
            if (null != response) {
                List<TagInfo> list = response.getTagsInfo();
                for (int i = 0; i < list.size(); i++) {
                        TagInfo tagInfo = list.get(i);
                        strBuilder.append("List[" + i + "]: " + "tagId="
                                + tagInfo.getTagId() + ",tag="
                                + tagInfo.getTagName() + ",info="
                                + tagInfo.getInfo() + ",type="
                                + tagInfo.getType() + ",creatTime="
                                + tagInfo.getCreateTime() + "\n");
                }
                System.out.println(strBuilder.toString());
            }
			
		} catch (Exception e) {
			log.error("testQueryTags =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 创建用户自定义的标签组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCreateTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			CreateTagRequest request =  new CreateTagRequest();
			/**
			 * 1-128字节。注：tag的值不允许为"default"，否则判错
			 * 设置标签名称，标签名称已经存在 则不做任何处理
			 */
			request.setTagName("t1,t2");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			CreateTagResponse response = pushClient.createTag(request);
			
			// 6. http 请求返回值解析
			 System.out.println(String.format("tagName: %s, result: %d",
	                    response.getTagName(), response.getResult()));
		} catch (Exception e) {
			log.error("testCreateTag =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除用户自定义的标签组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			DeleteTagRequest request =  new DeleteTagRequest();
			/**
			 * 设置标签名称，标签不存在则抛异常
			 * default 标签不能删除，是保留标签
			 */
			request.setTagName("monday2");
			//request.setTagName("default");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			DeleteTagResponse response = pushClient.deleteTag(request);
			
			// 6. http 请求返回值解析
            System.out.println(String.format("tagName: %s, result: %d",
                    response.getTagName(), response.getResult()));
			
		} catch (Exception e) {
			log.error("testDeleteTag =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 向标签组中批量添加设备
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddDevicesToTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			AddDevicesToTagRequest request =  new AddDevicesToTagRequest();
			// 渠道数组，渠道id不存在不会抛异常
			String[] channelIds = {"4134624474921335860", "111"};
			request.setChannelIds(channelIds);
			// 标签: 必须是成功创建的tag，且其值不能为"default"
			request.setTagName("monday");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			AddDevicesToTagResponse response = pushClient.addDevicesToTag(request);
			
			// 6. http 请求返回值解析
			if (null != response) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("devicesInTag：{");
                List<DeviceInfo> devicesInfo = response.getDevicesInfoAfterAdded();
                for (int i = 0; i < devicesInfo.size(); i++) {
                    if (i != 0) {
                        strBuilder.append(",");
                    }
                    DeviceInfo deviceInfo = devicesInfo.get(i);
                    strBuilder.append("{channelId:"
                            + deviceInfo.getChannelId() + ",result:"
                            + deviceInfo.getResult() + "}");
                }
                strBuilder.append("}");
                System.out.println(strBuilder.toString());
            }
			
		} catch (Exception e) {
			log.error("testAddDevicesToTag =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 从标签组中批量删除设备
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteDevicesFromTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			DeleteDevicesFromTagRequest request =  new DeleteDevicesFromTagRequest();
			// 渠道数组，渠道id不存在不会抛异常
			String[] channelIds = {"4134624474921335860", "111"};
			request.setChannelIds(channelIds);
			// 标签: 必须是成功创建的tag，且其值不能为"default"，名称不存在则抛异常
			request.setTagName("monday");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			
			// 5. 执行http请求
			DeleteDevicesFromTagResponse response = pushClient.deleteDevicesFromTag(request);
			
			// 6. http 请求返回值解析
			if (null != response) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("devicesInfoAfterDel:{");
                List<DeviceInfo> list = response.getDevicesInfoAfterDel();
                for (int i = 0; i < list.size(); i++) {
                    if (i != 0) {
                        strBuilder.append(",");
                    }
                    DeviceInfo deviceInfo = list.get(i);
                    strBuilder.append("{channelId: "
                            + deviceInfo.getChannelId() + ", result: "
                            + deviceInfo.getResult() + "}");
                }
                strBuilder.append("}");
                System.out.println(strBuilder.toString());
            }
			
		} catch (Exception e) {
			log.error("testDeleteDevicesFromTag =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查看标签组中关联的设备
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryDeviceNumInTag() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryDeviceNumInTagRequest request =  new QueryDeviceNumInTagRequest();
			request.setTagName("monday");
			//request.setTagName("default");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			QueryDeviceNumInTagResponse response = pushClient.queryDeviceNumInTag(request);
			
			// 6. http 请求返回值解析
		       if (null != response) {
	                System.out.println(String.format("deviceNum: %d",
	                        response.getDeviceNum()));
	            }
		       
			
		} catch (Exception e) {
			log.error("testQueryDeviceNumInTag =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 统计app消息信息,返回30天所有统计项
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryStatisticMsg() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryStatisticMsgRequest request =  new QueryStatisticMsgRequest();

			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			/*统计的消息类型状态
			 * 0：tag组播
			 * 1：广播
			 * 2：批量单播
			 * 3：组合运算
			 * 4：精准推送
			 * 5：LBS推送
			 * 6：强订阅组播推送
			 * 7：单播
			 */
			request.addDeviceType(7);
			// 5. 执行http请求
			QueryStatisticMsgResponse response = pushClient.queryStatisticMsg(request);
			
			// 6. http 请求返回值解析
	          if (null != response) {
	                StringBuilder strBuilder = new StringBuilder();
	                List<MsgStatInfo> msgStats = response.getMsgStats();
	                for (int i = 0; i < msgStats.size(); i++) {
	                    MsgStatInfo msgStatInfo = msgStats.get(i);
	                    strBuilder.append("totalNum:" + msgStatInfo.getTotalNum()
	                            + "\n" + "rangetype:" + msgStatInfo.getRangeType()
	                            + "\n" + "result:{");
	                    List<KeyValueForMsg> result = msgStatInfo.getResult();
	                    for (int j = 0; j < result.size(); j++) {
	                        KeyValueForMsg keyValue = result.get(j);
	                        if (j != 0) {
	                            strBuilder.append(",");
	                        }
	                        strBuilder.append("" + keyValue.getKey() + ":{ "
	                                + "pushNum=" + keyValue.getValue().getPushNum()
	                                + ",ackNum=" + keyValue.getValue().getAckNum()
	                                + ",delNum=" + keyValue.getValue().getDelNum()
	                                + ",clickNum="
	                                + keyValue.getValue().getClickNum() + "}\n");
	                    }
	                    strBuilder.append("\n}");
	                }
	                System.out.println(strBuilder.toString());
	            }
			
		} catch (Exception e) {
			log.error("testQueryStatisticMsg =====> ", e);
		}
	}

	/**
	 * 统计app某个分类主题的30天内的消息数
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryStatisticTopic() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryStatisticTopicRequest request =  new QueryStatisticTopicRequest();
			// 设置类别主题 正则:  [_0-9a-zA-Z] and length less than or equal 128"}]
			request.addTopicId("topicId_pushBatchUniMsg");
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			QueryStatisticTopicResponse response = pushClient.queryStatisticTopic(request);
			
			// 6. http 请求返回值解析
	           if (null != response) {
	                StringBuilder strBuilder = new StringBuilder();
	                strBuilder.append("totalNum: " + response.getTotalNum());
	                List<KeyValueForTopic> topicStats = response.getResult();
	                strBuilder.append("\nresult:{");
	                for (int i = 0; i < topicStats.size(); i++) {
	                    KeyValueForTopic keyValue = topicStats.get(i);
	                    if (i != 0) {
	                        strBuilder.append(",");
	                    }
	                    strBuilder.append("" + keyValue.getKey() + ":{"
	                            + "ackNum: " + keyValue.getValue().getAckNum()
	                            + "}");
	                }
	                strBuilder.append("\n}");
	                System.out.println(strBuilder.toString());
	            }
			
		} catch (Exception e) {
			log.error("testQueryStatisticTopic =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 统计安装了app的设备数,返回30天的所有统计项
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQueryStatisticDevice() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			QueryStatisticDeviceRequest request =  new QueryStatisticDeviceRequest();

			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);

			
			// 5. 执行http请求
			QueryStatisticDeviceResponse response = pushClient.queryStatisticDevice(request);
			
			// 6. http 请求返回值解析
			if (null != response) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("totalNum: " + response.getTotalNum()
                        + "\n");
                List<KeyValueForDevice> deviceStats = response.getResult();
                strBuilder.append("result:{\n");
                for (int i = 0; i < deviceStats.size(); i++) {
                    KeyValueForDevice keyValue = deviceStats.get(i);
                    if (i != 0) {
                        strBuilder.append(",");
                    }
                    strBuilder.append("" + keyValue.getKey() + ":{"
                            + "newDeviceNum=" + keyValue.getValue().getNewDevNum()
                            + ",delDeviceNum=" + keyValue.getValue().getDelDevNum()
                            + ",onlineDeviceNum=" + keyValue.getValue().getOnlineDevNum()
                            + ",addUpDeviceNum=" + keyValue.getValue().getAddUpDevNum()
                            + ",totalDeviceNum=" + keyValue.getValue().getTotalDevNum()
                            + "}\n");
                }
                strBuilder.append("\n}");
                System.out.println(strBuilder.toString());
            }
			
		} catch (Exception e) {
			log.error("testQueryStatisticDevice =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPushTemplate() {
		try {
			/*1. 创建PushKeyPair
	         *用于app的合法身份认证
	         *apikey和secretKey可在应用详情中获取
	         */
			PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
			
			// 2. 创建BaiduPushClient，访问SDK接口 (域名: BaiduPushConstants.CHANNEL_REST_URL)
			BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
			
			// 3. 注册YunLogHandler，获取本次请求的交互信息
			pushClient.setChannelLogHandler(new YunLogHandler()
			{
				/**
				 * @description 
				 * @param event
				 * @author qianye.zheng
				 */
				@Override
				public void onHandle(YunLogEvent event) {
					// 输出 交互信息
					System.out.println(event.getMessage());
				}
			});
			
			// 4. 设置请求参数，创建请求实例
			PushMsgToSingleDeviceRequest request =  new PushMsgToSingleDeviceRequest();
			// 设置 渠道id (安装了指定app的设备 渠道id)
			request.addChannelId(channelId);
			// 设置消息的有效时间，单位为秒，默认 3600 * 5
			request.addMsgExpires(3600);
			// 设置消息类型,0表示透传消息,1表示通知,默认为0.
			request.addMessageType(1);
			//request.addMessageType(0);
			/*
			 * 设置设备类型，
			 * deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
			 */
			request.addDeviceType(3);
			// 设置消息内容，json格式
			String message = null;
			message = "{\"title\":\"Android TEST\",\"description\":\"testPushMsgToSingleDevice!\"}";
			request.addMessage(message);
			
			// 5. 执行http请求
			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			
			// 6. http 请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
			
		} catch (Exception e) {
			log.error("testPushTemplate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
