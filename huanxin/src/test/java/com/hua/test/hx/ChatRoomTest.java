/**
 * 描述: 
 * ChatRoomTest.java
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
 * 描述: 聊天室
 * 
 * @author qye.zheng
 * ChatRoomTest
 */
public final class ChatRoomTest extends BaseTest {

	/**
	 * 
	 * 描述: 创建聊天室
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCreateRoom() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 聊天室名称
			params.put("name", "聊天室1");
			// 聊天室描述
			params.put("description", "聊天室1 哈哈");
			///聊天室成员最大数（包括群主），值为数值类型，默认值200，此属性为可选的
			params.put("maxusers", 200);
			// 聊天室的管理员
			params.put("owner", "t0001");
			// 聊天室成员，（注：群主不需要写入到members里面）
			List<String> members = new ArrayList<String>();
			params.put("members", members);
			members.add("t0002");
			members.add("t0003");
			
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatrooms";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testCreateRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 修改聊天室信息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testModifyRoom() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 聊天室名称
			params.put("name", "聊天室2");
			// 聊天室描述
			params.put("description", "聊天室2 哈哈");
			///聊天室成员最大数（包括群主），值为数值类型，默认值200，此属性为可选的
			params.put("maxusers", 200);

			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatrooms/216045254212583860";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.put(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testModifyRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除聊天室
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteRoom() {
		try {
			uri = uriPrefix + "/chatrooms/216045439114281404";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testDeleteRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取 APP 中所有的聊天室
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetAllRooms() {
		try {
			uri = uriPrefix + "/chatrooms";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetAllRooms =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取一个聊天室详情
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetRoom() {
		try {
			uri = uriPrefix + "/chatrooms/216045000058732996";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取用户加入的聊天室
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetUserAllRooms() {
		try {
			uri = uriPrefix + "/users/t0001/joined_chatrooms";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetUserAllRooms =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加聊天室成员[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddMemberToRoom() {
		try {
			uri = uriPrefix + "/chatrooms/216045254212583860/users/t0002";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddMemberToRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加聊天室成员[批量]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddMembersToRoom() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			List<String> usernames = new ArrayList<String>();
			usernames.add("t0004");
			params.put("usernames", usernames);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatrooms/216045254212583860/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddMembersToRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除聊天室成员[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteMemberFromRoom() {
		try {
			uri = uriPrefix + "/chatrooms/216045254212583860/users/t0001";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testDeleteMemberFromRoom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除聊天室成员[批量]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteMembersFromRoom() {
		try {

			uri = uriPrefix + "/chatrooms/216045254212583860/users/t0001,t0002";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testDeleteMembersFromRoom =====> ", e);
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
