/*
 * Copyright 2013 Nagendra K Srivastava.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nagendra.nagendralibrary;

import java.util.HashMap;

import com.loopj.android.http.*;
import com.nagendra.nagendralibrary.util.EncryptDecryptData;
public class SendDataToServer {
	
	private static AsyncHttpClient asyncHttpClient;
	public SendDataToServer()
	{
		super();
		asyncHttpClient = new AsyncHttpClient();
	}
	
	public void sendDataByGet(String url,AsyncHttpResponseHandler responseHandler)
	{
		asyncHttpClient.get(url, responseHandler);
		
	}
	
	public void sendDataByGet(String url, HashMap<String, String> paramValue,
			AsyncHttpResponseHandler responseHandler)
	{
		RequestParams requestParam = new RequestParams(paramValue);
		asyncHttpClient.get(url, requestParam, responseHandler);
	}

	public void authenticateAndSendDataToServerByGet(String userName, String password,String url ,HashMap<String, String> requestParameter,
			AsyncHttpResponseHandler responseHandler)
	{
		asyncHttpClient.setBasicAuth(userName, password);
		RequestParams requestParam = new RequestParams(requestParameter);
		asyncHttpClient.get(url, requestParam, responseHandler);
	}
	
	/**
	 * <b><i>public void AuthenticateAndSendEncrypteData(<font color="red"><u>String</u></font> userName, <font color="red"><u>String</u></font> key, <font color="red"><u>String</u></font> password,<font color = "red"><u>String</u></font> url ,<font color="red"><u>HashMap<String, String></font></u> requestParameter,
			<font color="red"><u>AsyncHttpResponseHandler</u></font> responseHandler)</b></i>
	 * @param userName    
	 * @param key         
	 * @param password
	 * @param url
	 * @param requestParameter
	 * @param responseHandler
	 */
	public void AuthenticateAndSendEncrypteDataByGet(String userName, String key, String password,String url ,HashMap<String, String> requestParameter,
			AsyncHttpResponseHandler responseHandler)
	{
		try
		{
			String encryptUserName     = EncryptDecryptData.encrypt(key, userName); 
			String encryptPassword     = EncryptDecryptData.encrypt(key, password);
			RequestParams requestParam = new RequestParams(requestParameter);
			asyncHttpClient.setBasicAuth(encryptUserName,encryptPassword);
			asyncHttpClient.get(url, requestParam, responseHandler);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void sendDataByPost(String url, AsyncHttpResponseHandler resposeHandler)
	{
		asyncHttpClient.post(url, resposeHandler);
	}
	
	public void sendDataByPost(String url, HashMap<String, String> requestParameter,AsyncHttpResponseHandler responseHandler)
	{
		RequestParams requestParam = new RequestParams(requestParameter);
		asyncHttpClient.post(url, requestParam, responseHandler);
	}
	
	public void AuthenticateAndSendEncryptDataByPost(String url, HashMap<String, String> requestParameter, AsyncHttpResponseHandler responseHandler,
			String userName, String key,String password)
	{
		try
		{
			String encryptUserName     = EncryptDecryptData.encrypt(key, userName); 
			String encryptPassword     = EncryptDecryptData.encrypt(key, password);
			RequestParams requestParam = new RequestParams(requestParameter);
			asyncHttpClient.setBasicAuth(encryptUserName, encryptPassword);
			asyncHttpClient.post(url, requestParam, responseHandler);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

