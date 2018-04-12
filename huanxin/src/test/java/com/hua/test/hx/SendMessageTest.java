/**
 * 描述: 
 * SendMessageTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.hx;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 发送消息(文本/图片/音频/视频)
 * 
 * @author qye.zheng
 * SendMessageTest
 */
public final class SendMessageTest extends BaseTest {

	/**
	 * 
	 * 描述: 发送文本消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendTextMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "txt");
			// 消息内容
			msg.put("msg", "你好 t0002 现在是 2016年7月13日 10:21:57");
			params.put("msg", msg);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendTextMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 发送图片消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendImgMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "img");
			// 图片的url
			msg.put("url", "");
			// 文件名
			msg.put("filename", "abc.txt");
			// 文件访问密钥
			msg.put("secret", "");
			final Map<String, Object> size = new HashMap<String, Object>();
			size.put("width", 480);
			size.put("height", 720);
			msg.put("size", size);
			params.put("msg", msg);
			
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendImgMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 发送语音消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendAudioMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "audio");
			// 图片的url
			msg.put("url", "");
			// 文件名
			msg.put("filename", "abc.txt");
			// 文件访问密钥
			msg.put("secret", "");
			// 语音长度(时间)
			msg.put("length", 4);
			params.put("msg", msg);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendAudioMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 发送视频消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendVideoMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "video");
			// 图片的url
			msg.put("url", "");
			// 文件名
			msg.put("filename", "abc.txt");
			// 文件访问密钥
			msg.put("secret", "");
			// 视频播放长度
			msg.put("length", 4);
			// 视频文件大小
			msg.put("file_length", 4);
			// 视频缩略图url
			msg.put("thumb", "");
			msg.put("thumb_secret", "");
			params.put("msg", msg);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendVideoMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 发送透传消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendTransparentMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "cmd");
			// 消息内容
			msg.put("action", "");
			params.put("msg", msg);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendTransparentMsg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 发送扩展消息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSendExtMsg() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "txt");
			// 消息内容
			msg.put("msg", "你好 t0002");
			params.put("msg", msg);
			
			// 扩展消息
			final Map<String, Object> ext = new HashMap<String, Object>();
			params.put("ext", ext);
			// 扩展字段可以自定义命名
			ext.put("atrr1", "xx");
			
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testSendExtMsg =====> ", e);
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
			final Map<String, Object> params = new HashMap<String, Object>();
			// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
			params.put("target_type", "users");
			// 发送目标给用户发送时数组元素是用户名，给群组发送时  数组元素是groupid
			List<String> target = new ArrayList<String>();
			target.add("t0002");
			params.put("target", target);
			// 消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
			params.put("from", "t0001");
			
			final Map<String, Object> msg = new HashMap<String, Object>();
			// 消息类型
			msg.put("type", "txt");
			// 消息内容
			msg.put("msg", "你好 t0002");
			params.put("msg", msg);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/messages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
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
