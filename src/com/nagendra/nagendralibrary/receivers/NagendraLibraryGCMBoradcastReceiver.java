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
 
package com.nagendra.nagendralibrary.receivers;

import android.content.Context;
import android.util.Log;

import com.google.android.gcm.GCMBroadcastReceiver;
import com.nagendra.nagendralibrary.services.GCMIntentService;


/**
 * Once C2DM event is received this method will automatically get called. 
 * @author nagendra
 *
 */
public class NagendraLibraryGCMBoradcastReceiver extends GCMBroadcastReceiver
	{
		private static final String TAG = "NagendraLibraryGCMBoradcastReceiver";
		
		@Override
		protected String getGCMIntentServiceClassName(Context context) {
			String serviceName = GCMIntentService.class.getCanonicalName();
			Log.d(TAG, "Service Name is : " + serviceName);
			return serviceName;
		}

	}
