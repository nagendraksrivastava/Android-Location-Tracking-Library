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
/**
 * This class will store all the latest periodic data so that you should not query again and again for location updates multiple time in your app 
 * @author Nagendra
 *
 */
public class PeriodicLocationData
	{
		public static final String TAg = "PeriodicLocationData";
		
		private double periodicLatitude;
		private double periodicLongitude;
		private double periodicAltitude;
		private double periodicSpeed;
		private double periodicDataAcuracy;
		private double periodicBearing;
		private double periodicTime;
		private String periodicDataProvider;
		private int    periodicNoOfSatelite;
		
		public int getPeriodicNoOfSatelite()
			{
				return periodicNoOfSatelite;
			}
		public void setPeriodicNoOfSatelite(int periodicNoOfSatelite)
			{
				this.periodicNoOfSatelite = periodicNoOfSatelite;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		public double getPeriodicLatitude()
			{
				return periodicLatitude;
			}
		public void setPeriodicLatitude(double periodicLatitude)
			{
				this.periodicLatitude = periodicLatitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicLongitude()
			{
				return periodicLongitude;
			}
		public void setPeriodicLongitude(double periodicLongitude)
			{
				this.periodicLongitude = periodicLongitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicAltitude()
			{
				return periodicAltitude;
			}
		public void setPeriodicAltitude(double periodicAltitude)
			{
				this.periodicAltitude = periodicAltitude;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicSpeed()
			{
				return periodicSpeed;
			}
		public void setPeriodicSpeed(double periodicSpeed)
			{
				this.periodicSpeed = periodicSpeed;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicDataAcuracy()
			{
				return periodicDataAcuracy;
			}
		public void setPeriodicDataAcuracy(double periodicDataAcuracy)
			{
				this.periodicDataAcuracy = periodicDataAcuracy;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicBearing()
			{
				return periodicBearing;
			}
		public void setPeriodicBearing(double periodicBearing)
			{
				this.periodicBearing = periodicBearing;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public double getPeriodicTime()
			{
				return periodicTime;
			}
		public void setPeriodicTime(long periodicTime)
			{
				this.periodicTime = periodicTime;
			}
		//---------------------------------------------------------------------------------------------------------------------------------
		
		public String getPeriodicDataProvider()
			{
				return periodicDataProvider;
			}
		public void setPeriodicDataProvider(String periodicDataProvider)
			{
				this.periodicDataProvider = periodicDataProvider;
			}
	}
