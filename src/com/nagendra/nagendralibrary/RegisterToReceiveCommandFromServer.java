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
package com.nagendra.nagendralibrary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;
import com.nagendra.nagendralibrary.services.GCMregIdInformService;
import com.nagendra.nagendralibrary.util.LibConstants;


/**
 * This class will be used to get the location of the device periodically
 * @author nagendra
 *
 */
public class RegisterToReceiveCommandFromServer
{

	public static final String TAG = "RegisterForLocationUpdates";
	
	

	public RegisterToReceiveCommandFromServer()
		{
			super();
		}

	public  RegisterToReceiveCommandFromServer(Context ctx)
		{
			
			registerAppWithGCM(ctx);
		}

	
	/**
	 * this method will register the APP with GCM server to receive C2DM messages
	 */
	public void registerAppWithGCM(Context context)
		{
			GCMRegistrar.checkDevice(context);
			GCMRegistrar.checkManifest(context);
			final String regId = GCMRegistrar.getRegistrationId(context);
			Log.d(TAG,"Registration ID = " + regId);
			if (regId.equals(""))
				{
					Log.d(TAG, "Now calling GCM register");
					GCMRegistrar.register(context, LibConstants.SENDER_ID);
				} else
					{
						Log.d(TAG, "GCM RegID : " + regId);
						Intent informServiceIntent = new Intent(context, GCMregIdInformService.class);
						informServiceIntent.putExtra("c2dm_id", regId);
						context.startService(informServiceIntent);
						Log.v(TAG, "Already registered " + regId);
					}
		}

}
