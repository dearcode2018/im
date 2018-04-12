/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hua.bean.ResponseData;
import com.hua.client.Jersey2Client;
import com.hua.log.BaseLog;
import com.hua.util.JacksonUtil;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	/* 组织名称 */
	protected static final String orgName = "100000001";
	
	/* 应用名称，一个组织可拥有多个应用 */
	protected static final String appName = "chatapp-test";
	
	/* uri 前缀 */
	protected static final String uriPrefix = "https://a1.easemob.com/" + orgName+ "/" + appName;
	
	/* 应用参数 */
	protected static final String appKey = orgName + "#" + appName;
	
	protected static final String clientId = "YXA6RHtVcEGIEeaz2n2m12CpIg";
	
	protected static final String clientSecret = "YXA6v43POhePt1fqIc8Q94-79uG14Ks";
	
	/* 环信 令牌 */
	protected static String token = "YWMtczWQqkNLEeaxT0MXqThmrwAAAVb0GqLzL77rfN7BslNOFEKYi9KgxbjeW1M";
	
	protected String uri;
	
	/* 请求数据 */
	protected String data;
	
	/* 响应数据 */
	protected String result;
	
	protected static Jersey2Client jersey2Client;
	
	protected ResponseData responseData;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		jersey2Client = new Jersey2Client();
		// 头部信息
		jersey2Client.addHeader("Content-Type", "application/json");
		jersey2Client.addHeader("Accept", "application/json");
		// 鉴权
		jersey2Client.addHeader("Authorization", "Bearer " + token);
		
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		if (null != responseData)
		{
			System.out.println("[status = " + responseData.getStatus() + ", reasonPhrase = " + responseData.getReasonPhrase() + "]");
			System.out.println("body data: ");
			System.out.println(responseData.getData());
		}
		System.out.println("afterMethod()");
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
	
}
