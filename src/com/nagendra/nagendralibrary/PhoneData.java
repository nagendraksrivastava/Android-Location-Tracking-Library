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

public class PhoneData {
	
	public static final String TAG = "PhoneData";
	//-----------private data fields-------------------------------------------------------------------
	private String deviceIMEI;
	private String phoneNo;
	private String countryISO;
	private String networkOperator;
	 
	
	
	//----------------------------------------------------------------------------------------------------
	public String getDeviceIMEI() {
		return deviceIMEI;
	}
	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}
	//----------------------------------------------------------------------------------------------------
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	//----------------------------------------------------------------------------------------------------
	
	public String getCountryISO() {
		return countryISO;
	}
	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}
	//----------------------------------------------------------------------------------------------------
	
	public String getNetworkOperator() {
		return networkOperator;
	}
	public void setNetworkOperator(String networkOperator) {
		this.networkOperator = networkOperator;
	}
	
	
	
	
	

}
