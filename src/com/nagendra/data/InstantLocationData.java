/*
 * Copyright 2013 Nagendra K Srivastava.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use InstantLocationData file except in compliance with the License.
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
/**
 * InstantLocationData class will store the instant data of the location so once location is recieved and if you want to get that data any where in your app then there is 
 * no need to query again for location from privider just get the latest data from here which will save the cellphone battery.
 * @author Nagendra
 *
 */
public class InstantLocationData
	{
		public static final String TAG = "InstantLocationData";
		
		private static double instantLatitude;
		private static double instantLongitude;
		private static double instantSpeed;
		private static double instantAltitude;
		private static double instantDataAcuracy;
		private static double instantBearing;
		private static double instantTime;
		private static String instantDataProvider;
		private static int    instantNoOfSatelite;
		
		//-------------------------------------------------------------------------------------------------------		
		public static double getInstantLatitude()
			{
				return instantLatitude;
			}
		public void setInstantLatitude(double instantLatitude)
			{
				InstantLocationData.instantLatitude = instantLatitude;
			}
		//-------------------------------------------------------------------------------------------------------
		public static double getInstantLongitude()
			{
				return instantLongitude;
			}
		public void setInstantLongitude(double instantLongitude)
			{
				InstantLocationData.instantLongitude = instantLongitude;
			}
		//-------------------------------------------------------------------------------------------------------
		
		public static double getInstantSpeed()
			{
				return instantSpeed;
			}
		public void setInstantSpeed(double instantSpeed)
			{
				InstantLocationData.instantSpeed = instantSpeed;
			}		
		//-------------------------------------------------------------------------------------------------------
		public static double getInstantAltitude()
			{
				return instantAltitude;
			}
		public void setInstantAltitude(double instantAltitude)
			{
				InstantLocationData.instantAltitude = instantAltitude;
			}
		//-------------------------------------------------------------------------------------------------------
		public static  double getInstantDataAcuracy()
			{
				return instantDataAcuracy;
			}
		public void setInstantDataAcuracy(double instantDataAcuracy)
			{
				InstantLocationData.instantDataAcuracy = instantDataAcuracy;
			}
		//-------------------------------------------------------------------------------------------------------
		public static  double getInstantBearing()
			{
				return instantBearing;
			}
		public void setInstantBearing(double instantBearing)
			{
				InstantLocationData.instantBearing = instantBearing;
			}
		//-------------------------------------------------------------------------------------------------------
		
		public static double getInstantTime()
			{
				return instantTime;
			}
		public void setInstantTime(long instantTime)
			{
				InstantLocationData.instantTime = instantTime;
			}
		//-------------------------------------------------------------------------------------------------------
		public static String getInstantDataProvider()
			{
				return instantDataProvider;
			}
		public void setInstantDataProvider(String instantDataProvider)
			{
				InstantLocationData.instantDataProvider = instantDataProvider;
			}
		//-------------------------------------------------------------------------------------------------------
		public static  int getInstantNoOfSatelite()
			{
				return instantNoOfSatelite;
			}
		public void setInstantNoOfSatelite(int instantNoOfSatelite)
			{
				InstantLocationData.instantNoOfSatelite = instantNoOfSatelite;
			}
		
	}
