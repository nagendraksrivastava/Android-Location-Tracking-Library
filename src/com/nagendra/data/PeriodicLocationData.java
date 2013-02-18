/*
 * Copyright 2013 Nagendra K Srivastava.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use PeriodicLocationData file except in compliance with the License.
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
 * PeriodicLocationData class will store all the latest periodic data so that you should not query again and again for location updates multiple time in your app 
 * @author Nagendra
 *
 */
public class PeriodicLocationData
	{
		public static final String TAg = "PeriodicLocationData";
		
		private static double periodicLatitude;
		private static double periodicLongitude;
		private static double periodicAltitude;
		private static double periodicSpeed;
		private static double periodicDataAcuracy;
		private static double periodicBearing;
		private static double periodicTime;
		private static String periodicDataProvider;
		private static int    periodicNoOfSatelite;
		
		public static int getPeriodicNoOfSatelite()
			{
				return periodicNoOfSatelite;
			}
		public void setPeriodicNoOfSatelite(int periodicNoOfSatelite)
			{
				PeriodicLocationData.periodicNoOfSatelite = periodicNoOfSatelite;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		public static double getPeriodicLatitude()
			{
				return periodicLatitude;
			}
		public void setPeriodicLatitude(double periodicLatitude)
			{
				PeriodicLocationData.periodicLatitude = periodicLatitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static double getPeriodicLongitude()
			{
				return periodicLongitude;
			}
		public void setPeriodicLongitude(double periodicLongitude)
			{
				PeriodicLocationData.periodicLongitude = periodicLongitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static  double getPeriodicAltitude()
			{
				return periodicAltitude;
			}
		public void setPeriodicAltitude(double periodicAltitude)
			{
				PeriodicLocationData.periodicAltitude = periodicAltitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static double getPeriodicSpeed()
			{
				return periodicSpeed;
			}
		public void setPeriodicSpeed(double periodicSpeed)
			{
				PeriodicLocationData.periodicSpeed = periodicSpeed;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static double getPeriodicDataAcuracy()
			{
				return periodicDataAcuracy;
			}
		public  void setPeriodicDataAcuracy(double periodicDataAcuracy)
			{
				PeriodicLocationData.periodicDataAcuracy = periodicDataAcuracy;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static double getPeriodicBearing()
			{
				return periodicBearing;
			}
		public void setPeriodicBearing(double periodicBearing)
			{
				PeriodicLocationData.periodicBearing = periodicBearing;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static double getPeriodicTime()
			{
				return periodicTime;
			}
		public void setPeriodicTime(long periodicTime)
			{
				PeriodicLocationData.periodicTime = periodicTime;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public static  String getPeriodicDataProvider()
			{
				return periodicDataProvider;
			}
		public void setPeriodicDataProvider(String periodicDataProvider)
			{
				PeriodicLocationData.periodicDataProvider = periodicDataProvider;
			}
	}
