/**
  * @filename ResponseData.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

 /**
 * @type ResponseData
 * @description 响应数据
 * @author qianye.zheng
 */
public final class ResponseData
{
	
	/* 响应状态码，例如: 200 */
	private int status;
	
	/* 原因短语 例如: OK */
	private String reasonPhrase;
	
	/* 响应数据: body内容 */
	private String data;
	
	private boolean success;

	/**
	 * @return the status
	 */
	public final int getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * @return the reasonPhrase
	 */
	public final String getReasonPhrase()
	{
		return reasonPhrase;
	}

	/**
	 * @param reasonPhrase the reasonPhrase to set
	 */
	public final void setReasonPhrase(String reasonPhrase)
	{
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * @return the data
	 */
	public final String getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public final void setData(String data)
	{
		this.data = data;
	}

	/**
	 * @return the success
	 */
	public final boolean isSuccess()
	{
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public final void setSuccess(boolean success)
	{
		this.success = success;
	}
	
}
