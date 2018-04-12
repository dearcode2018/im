/**
 * 描述: 
 * UserArchitectureTest.java
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

import com.hua.bean.ResponseData;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 用户体系
 * 
 * @author qye.zheng
 * UserArchitectureTest
 */
public final class UserArchitectureTest extends BaseTest {

	/**
	 * 
	 * 描述: 使用 APP 的 client_id 和 client_secret 获取授权管理员 token
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetToken() {
		try {
			/*
			 * {"access_token":"YWMtepdqpEMxEeaN5Z1DmRbpVAAAAVbzcG6SUofQUb292ETFwZ1NcUiOV5pKOFI",
			 * "expires_in":5183999,"application":"447b5570-4188-11e6-b3da-7da6d760a922"}
			 */
			final Map<String, Object> params = new HashMap<String, Object>();
			// 客户端证书
			params.put("grant_type", "client_credentials");
			params.put("client_id", clientId);
			params.put("client_secret", clientSecret);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/token";
			jersey2Client.setUri(uri);
			
			responseData = jersey2Client.post(data);
			
		} catch (Exception e) {
			log.error("testGetToken=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 注册IM用户(单个)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRegisterUserSingle() {
		try {
			/*
			{
			  "action" : "post",
			  "application" : "447b5570-4188-11e6-b3da-7da6d760a922",
			  "path" : "/users",
			  "uri" : "https://a1.easemob.com/100000001/chatapp-test/users",
			  "entities" : [ {
			    "uuid" : "c7862a60-4342-11e6-b9de-1ba3036e4890",
			    "type" : "user",
			    "created" : 1467786477574,
			    "modified" : 1467786477574,
			    "username" : "t0001",
			    "activated" : true,
			    "nickname" : "哈哈t0001"
			  } ],
			  "timestamp" : 1467786477579,
			  "duration" : 1,
			  "organization" : "100000001",
			  "applicationName" : "chatapp-test"
			}
			 */
			final Map<String, Object> params = new HashMap<String, Object>();
			// 
			params.put("username", "t0001");
			params.put("password", "123456");
			params.put("nickname", "哈哈t0001");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testRegisterUserSingle =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 注册IM用户(批量)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRegisterUserBatch() {
		try {
			final List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
			Map<String, Object> item = null;
			// 
			item = new HashMap<String, Object>();
			item.put("username", "t0002");
			item.put("password", "123456");
			item.put("nickname", "哈哈t0001");
			params.add(item);
			
			item = new HashMap<String, Object>();
			item.put("username", "t0003");
			item.put("password", "123456");
			item.put("nickname", "哈哈t0001");
			params.add(item);
			
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}		
			
		} catch (Exception e) {
			log.error("testRegisterUserBatch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取IM用户(单个)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetUserSingle() {
		try {
			uri = uriPrefix + "/users/t0001";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testGetUserSingle =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取IM用户(批量)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetUserBatch() {
		try {
			//uri = uriPrefix + "/users?limit=1";
			uri = uriPrefix + "/users?limit=1&cursor=LTgzNDAxMjM3OTp4NFlxWUVOQ0VlYTUzaHVqQTI1SWtB";
			uri = uriPrefix + "/users?limit=1&cursor=LTgzNDAxMjM3OTpoQnNnY0VOS0VlYUNVVVBadUN5Q3BB";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}		
			
		} catch (Exception e) {
			log.error("testGetUserBatch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除IM用户(单个)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteUserSingle() {
		try {
			uri = uriPrefix + "/users/t0001";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testDeleteUserSingle =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除IM用户(批量)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteUserBatch() {
		try {
			uri = uriPrefix + "/users?limit=100";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}		
			
		} catch (Exception e) {
			log.error("testDeleteUserBatch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 重置IM用户密码
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResetUserPassword() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 
			params.put("newpassword", "123");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/t0002/password";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.put(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testResetUserPassword =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 修改IM用户昵称
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testModifyNickname() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 
			params.put("nickname", "哈哈t0002");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/users/t0002";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.put(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testModifyNickname =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 给IM用户添加好友
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactAddFriend() {
		try {
			uri = uriPrefix + "/users/t0001/contacts/users/t0002";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(null);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactAddFriend =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述:  解除IM用户的好友
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactDeleteFriend() {
		try {
			uri = uriPrefix + "/users/t0002/contacts/users/t0003";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactDeleteFriend =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查看IM用户好友
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactGetFriend() {
		try {
			uri = uriPrefix + "/users/t0002/contacts/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactGetFriend =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取IM用户的黑名单
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactGetBlack() {
		try {
			uri = uriPrefix + "/users/t0002/blocks/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactGetBlack =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 往 IM 用户的黑名单中加人
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactAddToBlack() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 黑名单
			List<String> blacks = new ArrayList<String>();
			blacks.add("t0003");
			// 
			params.put("usernames", blacks);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/users/t0002/blocks/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactAddToBlack =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 从 IM 用户的黑名单中减人
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testContactRemoveFromBlack() {
		try {
			uri = uriPrefix + "/users/t0002/blocks/users/t0003";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testContactRemoveFromBlack=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查看用户在线状态
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetUserStatus() {
		try {
			uri = uriPrefix + "/users/t0002/status";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testGetUserStatus=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询离线消息数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetOfflineMsgCount() {
		try {
			uri = uriPrefix + "/users/t0001/offline_msg_count";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}				
			
		} catch (Exception e) {
			log.error("testGetOfflineMsgCount=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询某条离线消息状态
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetOfflineMsgStatus() {
		try {
			uri = uriPrefix + "/users/t0002/offline_msg_status/{msg_id}";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testGetOfflineMsgStatus=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 用户账号禁用
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeactivateUser() {
		try {
			uri = uriPrefix + "/users/t0002/deactivate";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testDeactivateUser=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 用户账号解禁
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testActivateUser() {
		try {
			uri = uriPrefix + "/users/t0002/activate";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testActivateUser=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 强制用户下线
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUserDisconnect() {
		try {
			uri = uriPrefix + "/users/t0002/disconnect";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}			
			
		} catch (Exception e) {
			log.error("testUserDisconnect=====> ", e);
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
			log.error("test=====> ", e);
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
