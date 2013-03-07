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

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nagendra.nagendralibrary.util.LibConstants;

/**
 * This class is used to send the user information like name , email address, contact details and some other which is fully customized,
 * It will store the information in  a hash map and it will send it to the server
 * @author Nagendra
 *
 */
public class UserRegistration
{
	public static final String TAG = "UserRegistration";
	private final HashMap<String,String> userRegData = new HashMap<String,String>();
	private final AsyncHttpClient userRegDataClient;
	private final RequestParams userRequestParam;
	
	public UserRegistration()
		{
			super();
			userRegDataClient = new AsyncHttpClient();
			userRequestParam = new RequestParams();
		}
	/**
	 * 
	 * <b><i>public void userRegistrationDetails(<font color = "red"><u>String</u></font> key, <font color="red"><u>String</u></font> value)</i></b>
	 * </br></br>Store user data which should be send to the server
	 * @param key      Key which will be used to store data
	 * @param value    Value which will be stored against the provided key
	 */
	public void userRegistrationDetails(String key, String value)
		{
			userRegData.put(key,value);
			
		}
	
	/**
	 * <b><i>public void clearUserData()</b></i>
	 * </br>
	 * </br>
	 * Clear complete user data from the data structure
	 */
	public void clearUserData()
		{
			userRegData.clear();
		}
	/**
	 *  <b><i>public void removeUserRegistrationData(<font color = "red"><u>String</u></font> key)</i></b>
	 *  </br></br>
	 *  Remove the data from data structure against the particular key which will be passed as parameter
	 * @param key      Key against which you want to remove data from the data structure
	 */
	public void removeUserRegistrationData(String key)
	{	
		userRegData.remove(key);
	}
	/**
	 *  <b><i>public void sendUserRegDataToServer()</b></i>
	 *  </br></br>
	 * Send user data to the server
	 */
	public void sendUserRegDataToServer()
		{
			userRequestParam.put("user_reg_data",userRegData.toString());
			userRegDataClient.get(LibConstants.SERVER_ADDRESS_REG,userRequestParam,new userRegDataResponseHandler());
		}
	
	
	public class userRegDataResponseHandler extends AsyncHttpResponseHandler
	{
		@Override
		public void onSuccess(String message)
			{
				Log.d(TAG,"User registration  successfull");

			}
		@Override
		public void onFailure(Throwable e)
			{
				Log.d(TAG,"Error occured " + e);
			}
	}
}

