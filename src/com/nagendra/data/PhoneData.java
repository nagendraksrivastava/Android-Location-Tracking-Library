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
package com.nagendra.data;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
/**
 * This class will have required phone related data . Still working on this
 * @author Nagendra
 *
 */
public class PhoneData {
	public static final String TAG = "PhoneData";
	private TelephonyManager telephonyManager;
	
	public PhoneData()
	{
		 super();
	}
	
	
	/**
	 * <b><i>public final String getMobileNo(<font color="red"><u>Context</font></u> context)</b></i></P>
	 * Returns the mobile number of the user
	 * @param context - 	Context of your application which can get by using <font color="red"><u> getApplicationContext()</u></font> or <font color="red"> <u>this</u></font>
	 * @return    		mobile number</br>
	 * Required Permission---  <b><font color="red">READ_PHONE_STATE</font></b>  declare this permission in androidmanifest.xml file in which is available in your project root folder
	 */
	public final String getMobileNo(Context context)
		{
			
			telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
			return telephonyManager.getLine1Number();
			
		}
	/**
	 * <b><i>public final String getMobileDeviceID(<font color="red"><u>Context</font></u> context)</b></i></P>
	 * @param context - Context of your application which can get by using <font color="red"><u> getApplicationContext()</u></font> or <font color="red"> <u>this</u></font>
	 * @return  Android Id of the device
	 * 
	 */
	
	public final String getMobileDeviceID(Context context)
	{
		return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
	}

}
