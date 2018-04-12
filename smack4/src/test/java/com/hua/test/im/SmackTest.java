/**
 * 描述: 
 * SmackTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.im;

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

import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.JidWithLocalpart;
import org.jxmpp.jid.impl.JidCreate;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SmackTest
 */
public final class SmackTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSmack() {
		try {
			/*
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			/*
			 * TCP 连接 (XMPP TCP Connection)
			 * XMPPTCPConnection
			 */
				/*
				 * TCP 连接 (XMPP BOSH Connection)
				 * XMPPBOSHConnection
				 */		
			
		} catch (Exception e) {
			log.error("testSmack =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSmackTCP1() {
		try {
			//HttpsURLConnection.
			/*
			 * 
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			/*
			 * TCP 连接 (XMPP TCP Connection)
			 * XMPPTCPConnection
			 */
				/*
				 * TCP 连接 (XMPP BOSH Connection)
				 * XMPPBOSHConnection
				 */		
			
			//XMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			/*
			 * 创建连接对象
			 */
		    HostnameVerifier hv = new HostnameVerifier() {  
	            public boolean verify(String urlHostName, SSLSession session) {  
	                System.out.println("Warning: URL Host: " + urlHostName + " vs. "  
	                                   + session.getPeerHost());  
	                return true;  
	            }  
	        };  		
	        trustAllHttpsCertificates();  
	        HttpsURLConnection.setDefaultHostnameVerifier(hv);  	
			//	AbstractXMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			//AbstractXMPPConnection connection = new XMPPTCPConnection("admin", "admin", "com.hua.openfire");
	        
			/**
			 * JidCreate 创建 BareJid 对象，BareJid 继承 JidWithLocalpart
			 */
	        //DomainBareJid serviceName = JidCreate.domainBareFrom("com.hua.openfire");
	
/*	        XMPPTCPConnectionConfiguration configuration = XMPPTCPConnectionConfiguration.builder().
	        		setUsernameAndPassword("admin", "admin").setServiceName(serviceName).build();*/
/*	        XMPPTCPConnectionConfiguration configuration = XMPPTCPConnectionConfiguration.builder().
	        		setUsernameAndPassword("admin", "admin").setServiceName().build();*/
	      /*  HostnameVerifier hv2 =   configuration.getHostnameVerifier();
	        HttpsURLConnection.setDefaultHostnameVerifier(hv2);  	
			AbstractXMPPConnection connection = new XMPPTCPConnection(configuration);*/
	        XMPPTCPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			// 连接
			connection.connect();
			// 登录
			connection.login();
			
		} catch (Exception e) {
			log.error("testSmackTCP1 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSmackTCP2() {
		try {
			//HttpsURLConnection.
			/*
			 * 
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			/*
			 * TCP 连接 (XMPP TCP Connection)
			 * XMPPTCPConnection
			 */
				/*
				 * TCP 连接 (XMPP BOSH Connection)
				 * XMPPBOSHConnection
				 */		
			
			//XMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			/*
			 * 创建连接对象
			 */
	        //HttpsURLConnection.setDefaultHostnameVerifier(hv);  	
			//	AbstractXMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			//AbstractXMPPConnection connection = new XMPPTCPConnection("admin", "admin", "com.hua.openfire");
	        
			/**
			 * JidCreate 创建 BareJid 对象，BareJid 继承 JidWithLocalpart
			 */
	        DomainBareJid serviceName = JidCreate.domainBareFrom("com.hua.openfire");
	
	        XMPPTCPConnectionConfiguration configuration = XMPPTCPConnectionConfiguration.builder().
	        		setUsernameAndPassword("admin", "admin").setServiceName(serviceName).build();
	        
	        trustAllHttpsCertificates();  
	        HttpsURLConnection.setDefaultHostnameVerifier(configuration.getHostnameVerifier());  	
	        
	        XMPPTCPConnection connection = new XMPPTCPConnection(configuration);
			// 连接
			connection.connect();
			// 登录
			connection.login();
			
		} catch (Exception e) {
			log.error("testSmackTCP1 =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSmackTCP() {
		try {
			/*
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			/*
			 * TCP 连接 (XMPP TCP Connection)
			 * XMPPTCPConnection
			 */
				/*
				 * TCP 连接 (XMPP BOSH Connection)
				 * XMPPBOSHConnection
				 */		
			
			//XMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			/**
			 * 在openfire web管理端，进入 服务器-->安全设置--> SSL安全设置，将客户端
			 * 安全连接 设置为自定义，将2种方式均设置为无效.
			 * 这样设置之后，才不会抛 sun.security.validator.ValidatorException: 
			 * PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: 
			 * unable to find valid certification path to requested target
			 * 异常.
			 * TODO 关于证书安全方面，暂时不能解决.
			 */
			/*
			 * 创建连接对象
			 */
			//	AbstractXMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			//  new XMPPTCPConnection("用户名", "密码", "服务名称 即 服务器 域名");
			AbstractXMPPConnection connection = new XMPPTCPConnection("test", "test", "com.hua.openfire");
			// 连接
			connection.connect();
			// 登录
			connection.login();
			
			// 聊天管理器
			ChatManager chatManager = ChatManager.getInstanceFor(connection);
			
			/**
			 * JidCreate 创建 BareJid 对象，BareJid 继承 JidWithLocalpart
			 * 给谁发消息 用户名@服务器域名
			 */
			JidWithLocalpart jid = JidCreate.bareFrom("user@com.hua.openfire");
			// 创建聊天对象
			Chat chat = chatManager.createChat(jid, new ChatMessageListener() {
				/**
				 * 
				 * @description 消息监听 回调方法: 接收对方发送的消息
				 * @param chat
				 * @param message
				 * @author qianye.zheng
				 */
				@Override
				public void processMessage(Chat chat, Message message) {
					System.out.println("Received message: " + message);
				}
			});
			
			// 给目标发送消息
			chat.sendMessage("message from smack client ..." + new Date());
			
		} catch (Exception e) {
			log.error("testSmackTCP =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSmackBOSH() {
		try {
			/*
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			/*
			 * TCP 连接 (XMPP TCP Connection)
			 * XMPPTCPConnection
			 */
				/*
				 * TCP 连接 (XMPP BOSH Connection)
				 * XMPPBOSHConnection
				 */		
			
		} catch (Exception e) {
			log.error("testSmackBOSH =====> ", e);
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
			/*
			 * XMPPConnection 在 smark 4.x中已经抽象为接口
			 */
			//XMPPConnection connection = new XMPPConnection(domain);
			
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

	  private static void trustAllHttpsCertificates() throws Exception {  
          javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];  
          javax.net.ssl.TrustManager tm = new miTM();  
          trustAllCerts[0] = tm;  
          javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext  
                  .getInstance("SSL");  
          sc.init(null, trustAllCerts, null);  
          javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc  
                  .getSocketFactory());  
      }  
    
      static class miTM implements javax.net.ssl.TrustManager,  
              javax.net.ssl.X509TrustManager {  
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
              return null;  
          }  
    
          public boolean isServerTrusted(  
                  java.security.cert.X509Certificate[] certs) {  
              return true;  
          }  
    
          public boolean isClientTrusted(  
                  java.security.cert.X509Certificate[] certs) {  
              return true;  
          }  
    
          public void checkServerTrusted(  
                  java.security.cert.X509Certificate[] certs, String authType)  
                  throws java.security.cert.CertificateException {  
              return;  
          }  
    
          public void checkClientTrusted(  
                  java.security.cert.X509Certificate[] certs, String authType)  
                  throws java.security.cert.CertificateException {  
              return;  
          }  
      }  
}
