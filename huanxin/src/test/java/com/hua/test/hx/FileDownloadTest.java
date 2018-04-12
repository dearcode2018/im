/**
 * 描述: 
 * FileDownloadTest.java
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

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述:文件下载
 * 
 * @author qye.zheng
 * FileDownloadTest
 */
public final class FileDownloadTest extends BaseTest {

	/**
	 * 
	 * 描述: 下载图片
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownloadImage() {
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
			log.error("testDownloadImage =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 下载缩略图
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownloadThumbnails() {
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
			log.error("testDownloadThumbnails =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 下载语音
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownloadAudio() {
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
			log.error("testDownloadAudio =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 下载视频
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownloadVideo() {
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
			log.error("testDownloadVideo =====> ", e);
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
