
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
/**
 * @author nagendra
 */
package com.nagendra.nagendralibrary.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nagendra.nagendralibrary.util.LibConstants;
import com.nagendra.nagendralibrary.util.Utility;

/**
 * This class will send the registration id to server 
 * @author nagendra
 *
 */
public class GCMregIdInformService extends IntentService
	{

		public static final String TAG = "GCMregIdInformService";
		public static final StringBuilder serverURL = new StringBuilder("some url");
		private String deviceID;
		private AsyncHttpClient registerC2DMID;
		private String version; 
		private String deviceType;
		private String tabOrMobile;
		private Context context;
		private String appToken;
		public GCMregIdInformService(String name)
		{
			super(name);
			
		}

		@Override
		public void onCreate()
			{
				super.onCreate();
				deviceID 	=  Secure.getString(this.getContentResolver(),Secure.ANDROID_ID);
				version 	=  Build.VERSION.RELEASE;
				deviceType 	=  Build.MANUFACTURER + "," + Build.MODEL;
				appToken 	=  context.getResources().getString(context.getResources().getIdentifier("app_token","string",context.getPackageName()));
				registerC2DMID = new AsyncHttpClient();
				if(Utility.isTablet(context)){

					tabOrMobile = "tab";
				}
				else{
					tabOrMobile = "mobile";
				}
				
				Log.d(TAG,"Tab or Mobile = " + tabOrMobile);
			}
		
	
		@Override
		protected void onHandleIntent(Intent intent)
			{
				String gcmRegId = intent.getStringExtra("c2dm_id"); 
				RequestParams gcmRegIdRequestParam = new RequestParams();
				gcmRegIdRequestParam.put("uuid",deviceID);
				gcmRegIdRequestParam.put("c2dmid",gcmRegId);
				gcmRegIdRequestParam.put("apptoken",appToken);
				gcmRegIdRequestParam.put("device",deviceType);
				gcmRegIdRequestParam.put("version",version);
				registerC2DMID.post(LibConstants.SERVER_ADDRESS,gcmRegIdRequestParam,new sendRegIdToServer());
			}

		   public class sendRegIdToServer extends AsyncHttpResponseHandler
		   {
			   @Override
				public void onSuccess(String response) {
					Log.d(TAG, "Successfully Informed server of c2dm token");
					Log.d(TAG, response);
				}

				@Override
				public void onFailure(Throwable e) {
					Log.e(TAG, "Failed to send c2dm token");
				}
			};
		   
		}

