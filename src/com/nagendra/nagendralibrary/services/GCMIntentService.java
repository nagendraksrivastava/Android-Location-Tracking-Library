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

package com.nagendra.nagendralibrary.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService
{
	public static final String TAG = "GCMIntentService";

	public GCMIntentService()
		{
			super("248742198467");  // this is the project id which we can get from GCM server while registering
		}

	@Override
	public void onCreate()
		{
			super.onCreate();
			Log.d(TAG,"On create of GCMIntentService");
		}
	@Override
	protected void onError(Context context,String errorId)
		{
			Log.i(TAG, "Received error: " + errorId);

		}

	@Override
	protected void onMessage(Context context,Intent intent)
		{
			final String dataFromGCM = intent.getStringExtra("data");
			// write code according to json received from server
			if(dataFromGCM.equalsIgnoreCase(""))
				{
					
				}
			Log.d(TAG,"On receive Message do here whatever you want");

		}

	@Override
	protected void onRegistered(Context context,String regId)
		{
			Log.d(TAG, "Register Received : " + regId);
			Intent informServiceIntent = new Intent(context, GCMregIdInformService.class);
			informServiceIntent.putExtra("c2dm_id", regId);
			context.startService(informServiceIntent);
		}

	@Override
	protected void onUnregistered(Context context,String regId)
		{

			Log.d(TAG,"Unregistered from google GCM server");
		}

}
