/**
  * @filename TextMessageRecordVo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;

 /**
 * @type TextMessageRecordVo
 * @description 聊天-文本消息记录 
 * @author qianye.zheng
 */
public final class TextMessageRecordVo
{
	/**
	 * 文本消息结构
	 */
	/* 环信消息id */
	private String msgId;
	
	/* 消息类型: txt | img | audio | video | loc */
	private String msgType;
	
	/* 聊天类型 */
	private String chatType;
	
	/* 发消息者（环信用户id） */
	private String from;
	
	/* 收消息者（环信用户id） */
	private String to;
	
	/* 消息内容 */
	private String content;
	
	/* 消息发送时间 */
	private Date createDt;

	/**
	 * @return the msgId
	 */
	public final String getMsgId()
	{
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public final void setMsgId(String msgId)
	{
		this.msgId = msgId;
	}

	/**
	 * @return the msgType
	 */
	public final String getMsgType()
	{
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public final void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	/**
	 * @return the chatType
	 */
	public final String getChatType()
	{
		return chatType;
	}

	/**
	 * @param chatType the chatType to set
	 */
	public final void setChatType(String chatType)
	{
		this.chatType = chatType;
	}

	/**
	 * @return the from
	 */
	public final String getFrom()
	{
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public final void setFrom(String from)
	{
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public final String getTo()
	{
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public final void setTo(String to)
	{
		this.to = to;
	}

	/**
	 * @return the content
	 */
	public final String getContent()
	{
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public final void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * @return the createDt
	 */
	public final Date getCreateDt()
	{
		return createDt;
	}

	/**
	 * @param createDt the createDt to set
	 */
	public final void setCreateDt(Date createDt)
	{
		this.createDt = createDt;
	}
	
}
