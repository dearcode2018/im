/**
 * 描述: 
 * ChatGroupTest.java
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
 * 描述: 群组
 * 
 * @author qye.zheng
 * ChatGroupTest
 */
public final class ChatGroupTest extends BaseTest {

	/**
	 * 
	 * 描述: 获取 APP 中所有的群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetAllGroup() {
		try {
			uri = uriPrefix + "/chatgroups";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetAllGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 分页 获取 APP 中所有的群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetAllGroup2() {
		try {
			uri = uriPrefix + "/chatgroups?limit=20&cursor";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
			
		} catch (Exception e) {
			log.error("testGetAllGroup2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取群组详情
	 * 可以获取一个或多个群组的详情。 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetGroup() {
		try {
			// 多个id用逗号隔开
			uri = uriPrefix + "/chatgroups/216035307051549108,216035678574608812";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 创建一个群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCreateGroup() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 群组名称
			params.put("groupname", "这是群组啊2");
			// 群组描述
			params.put("desc", "群组 哈哈2");
			// 否是公开群
			params.put("public", true);
			// 群组成员最大数（包括群主），值为数值类型，默认值200，此属性为可选的
			params.put("maxusers", 300);
			// 加入公开群是否需要批准，默认值是false（加入公开群不需要群主批准），此属性为必选的，私有群必须为true
			params.put("approval", true);
			// 群组的管理员，此属性为必须的
			params.put("owner", "t0001");
			// 群组成员 群主不需要写入到members里面
			List<String> members = new ArrayList<String>();
			members.add("t0002");
			params.put("members", members);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatgroups";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testCreateGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 修改群组信息
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testModifyGroup() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 群组名称
			params.put("groupname", "这是群组啊1");
			// 群组描述
			params.put("description", "群组 哈哈1");
			// 群组成员最大数（包括群主），值为数值类型，默认值200，此属性为可选的
			params.put("maxusers", 300);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatgroups/216035307051549108";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			jersey2Client.setUri(uri);
			responseData = jersey2Client.put(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testModifyGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteGroup() {
		try {
			uri = uriPrefix + "/chatgroups/216036427463393728";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testDeleteGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取群组中的所有成员
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetAllMember() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetAllMember =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加群组成员[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddGroupMember() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/users/t0003";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddGroupMember =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加群组成员[批量]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddGroupMembers() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			List<String> usernames = new ArrayList<String>();
			usernames.add("t0004");
			params.put("usernames", usernames);
			
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatgroups/216035307051549108/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddGroupMembers =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 移除群组成员[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveGroupMember() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/users/t0003";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testRemoveGroupMember =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 移除群组成员[批量]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveGroupMembers() {
		try {
			// 多个id用逗号隔开
			uri = uriPrefix + "/chatgroups/216035307051549108/users/t0002,t0003";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testRemoveGroupMembers =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取一个用户参与的所有群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetUserAllGroup() {
		try {
			uri = uriPrefix + "/users/t0001/joined_chatgroups";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetUserAllGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 转让群组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTransferGroup() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			// 新的群主
			params.put("newowner", "t0002");
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatgroups/216035307051549108";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.put(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testTransferGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查询群组黑名单
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetGroupBlack() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/blocks/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.get();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testGetGroupBlack =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加用户至群组黑名单[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddBlackToGroup() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/blocks/users/t0001";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddBlackToGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 添加用户至群组黑名单[批量]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddBlacksToGroup() {
		try {
			final Map<String, Object> params = new HashMap<String, Object>();
			List<String> usernames = new ArrayList<String>();
			usernames.add("t0004");
			params.put("usernames", usernames);
			data = JacksonUtil.writeAsString(params);
			uri = uriPrefix + "/chatgroups/216035307051549108/blocks/users";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.post(data);
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testAddBlacksToGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 从群组黑名单移除用户[单个]
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveBlackFromGroup() {
		try {
			uri = uriPrefix + "/chatgroups/216035307051549108/blocks/users/t0004";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testRemoveBlackFromGroup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveBlacksFromGroup() {
		try {
			// 多个用逗号隔开
			uri = uriPrefix + "/chatgroups/216035307051549108/blocks/users/t0004,t0001";
			jersey2Client.setUri(uri);
			responseData = jersey2Client.delete();
			if (null != responseData)
			{
				result = responseData.getData();
			}
			
		} catch (Exception e) {
			log.error("testRemoveBlacksFromGroup =====> ", e);
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
