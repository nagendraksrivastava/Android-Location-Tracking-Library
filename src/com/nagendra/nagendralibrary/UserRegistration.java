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
	
	public void userRegistrationDetails(String key, String value)
		{
			userRegData.put(key,value);
			
		}
	
	public void clearUserData()
		{
			userRegData.clear();
		}
	
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

