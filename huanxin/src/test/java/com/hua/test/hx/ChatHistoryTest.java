/**
 * 描述: 
 * ChatHistoryTest.java
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.TextMessageRecordVo;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 聊天记录
 * 
 * @author qye.zheng
 * ChatHistoryTest
 */
public final class ChatHistoryTest extends BaseTest {

	
	/**
	 * 聊天消息记录，按照时间升序返回，时间早的在前面，时间晚的(最新的)在后面
	 * 
	 * 获取前一天聊天记录: 大于等于昨天凌晨时间戳，然后在处理过程中 如果发现有大于等于今天凌晨的时间的
	 * 即停止不再获取一下页，这样就可以控制只全昨天一天的数据.
	 */
	
	/**
	 * 
	 * 描述: 获取聊天记录
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetChatMessage1() {
		try {
			//final Map<String, Object> params = new HashMap<String, Object>();
			//
			/*
			 * 查询语言(query language)
			 * 例如要查询大于某个时间之后的聊天记录，然后可以用最后1条消息的时间
			 * 作为下一次消息的查询时间
			 * 注意在url中对空格以及特殊字符做转成%16进制的格式处理
			 * 空格 : %20
			 * > : %3E
			 * >= : %3E%3D
			 * < : %3C
			 * <= : %3C%3D
			 */
			/*
			 * 首次查询之后，如果游标是空的则不再往下查询，否则将继续查询
			 * 循环往下查询，直到游标为空为止，
			 * 可以写成2个过程: 1.查询一次 2.拿到游标之后则进入循环，直到游标为空为止
			 */
			String cursor = "MTQzNjgyOTEyMDpnR2tBQVFNQWdHa0FCZ0ZWNGdjX1p3Q0FkUUFRVHpoVE1raWZFZWFmVHl1dTVtSFpjZ0NBZFFBUVR6aFRLRWlmRWVhLTZaTlNXVWdwTkFB";
			String ql = null;
			//params.put("ql", "select * where timestamp>1467873444022");
			//data = JacksonUtil.writeAsString(params);
			//ql = "select%20*%20where%20timestamp%3E1467803444022";
			// 上一次最后一条消息的时间(本次查询的最后一页数据的最后1条记录)
			long lastRecordTs = 1467734400000L;
			 lastRecordTs = 1411734400000L;
			//long todayBeforeDown = 1467820800000L;
			ql = "select%20*%20where%20timestamp%3E%3D" + lastRecordTs;
			System.out.println(ql);
			uri = uriPrefix + "/chatmessages?limit=1&ql=" + ql ;
			uri = uriPrefix + "/chatmessages?limit=2&ql=" + ql + "&cursor=" + cursor;
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			final List<TextMessageRecordVo> vos = new ArrayList<TextMessageRecordVo>();
			TextMessageRecordVo vo = null;
			// 是否进入循环查询模式，拿到游标则进入循环查询模式
			boolean isLoopQuery = false;
			if (null != responseData)
			{
				result = responseData.getData();
				if (StringUtil.isNotEmpty(result))
				{
					final JSONObject jsonObject = JSONObject.fromObject(result);
					// 获取游标
					cursor = jsonObject.optString("cursor");
					if (StringUtil.isNotEmpty(cursor))
					{
						isLoopQuery = true;
						System.out.println("拿到游标，进入循环查询模式");
					} else 
					{
						System.out.println("没有拿到游标，查询一次即结束");
					}
					final JSONArray entities = jsonObject.optJSONArray("entities");
					if (null != entities && !entities.isEmpty())
					{
						JSONObject jsonEntity = null;
						for (int i =0 ; i < entities.size(); i++)
						{
							vo = new TextMessageRecordVo();
							jsonEntity = entities.optJSONObject(i);
							// 解析消息体bodies
							final JSONObject payLoad = jsonEntity.optJSONObject("payload");
							if (null != payLoad)
							{
								final JSONArray bodies = payLoad.optJSONArray("bodies");
								if (null != bodies && !bodies.isEmpty())
								{ // 只处理第一条且类型为txt
									final JSONObject msgItem = bodies.getJSONObject(0);
									if ("txt".equals(msgItem.optString("type")))
									{
										vo.setMsgType(msgItem.optString("type"));
										vo.setContent(msgItem.optString("msg"));
									} else
									{
										// 其他类型消息直接忽略
										continue;
									}
								}
							}
							vo.setMsgId(jsonEntity.optString("msg_id"));
							vo.setChatType(jsonEntity.optString("chat_type"));
							vo.setFrom(jsonEntity.optString("from"));
							vo.setTo(jsonEntity.optString("to"));
							vo.setCreateDt(new Date(jsonEntity.optLong("created")));
							vos.add(vo);
						}
					}
				}
			}
			System.out.println(vos.size());
		} catch (Exception e) {
			log.error("testGetChatMessage1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 分页获取聊天记录
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetChatMessage2() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 
			params.put("ql", "select * where timestamp>1403164734226");
			params.put("cursor", "");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatmessages";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetChatMessage2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 分页获取聊天记录 使用 limit
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetChatMessage3() {
		try {
			uri = uriPrefix + "/chatmessages?limit=2";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetChatMessage3 =====> ", e);
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
			// 
			params.put("", "");
			params.put("", "");
			params.put("", "");
			params.put("", "");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/";
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
