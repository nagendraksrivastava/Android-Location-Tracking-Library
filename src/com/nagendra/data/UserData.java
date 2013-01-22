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

import java.util.HashMap;

public class UserData {

	public static final String TAG = "UserData";
	
	HashMap<String, String> userDetailMap;
	
	public UserData()
	{
		userDetailMap = new HashMap<String, String>();
	}
	/**
	 * <b><i>public final void getUserDetail(<font color="blue"><u>String</u></font> key, <font color="blue"><u>String</u></font> userInformation)</b></i></p>
	 * Get the information and store in hash map in key value pair, Key must have some valid name in string format, Loop can be used to store multiple information in the hash map 
	 * @param key				&#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160	A human understandable key in string format 
	 * @param userInformation	&#160 &#160 &#160	User information which you want to pass
	 */
	public final void getUserDetail(String key, String userInformation)
	{
		userDetailMap.put(key,userInformation);
		
	}

}
