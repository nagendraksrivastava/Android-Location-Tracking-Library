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

public class InstantLocationData
	{
		public static final String TAG = "InstantLocationData";
		
		private double instantLatitude;
		private double instantLongitude;
		private double instantSpeed;
		private double instantAltitude;
		private double instantDataAcuracy;
		private double instantBearing;
		private double instantTime;
		private String instantDataProvider;
		private int    instantNoOfSatelite;
		
		//-------------------------------------------------------------------------------------------------------		
		public double getInstantLatitude()
			{
				return instantLatitude;
			}
		public void setInstantLatitude(double instantLatitude)
			{
				this.instantLatitude = instantLatitude;
			}
		//-------------------------------------------------------------------------------------------------------
		public double getInstantLongitude()
			{
				return instantLongitude;
			}
		public void setInstantLongitude(double instantLongitude)
			{
				this.instantLongitude = instantLongitude;
			}
		//-------------------------------------------------------------------------------------------------------
		
		public double getInstantSpeed()
			{
				return instantSpeed;
			}
		public void setInstantSpeed(double instantSpeed)
			{
				this.instantSpeed = instantSpeed;
			}		
		//-------------------------------------------------------------------------------------------------------
		public double getInstantAltitude()
			{
				return instantAltitude;
			}
		public void setInstantAltitude(double instantAltitude)
			{
				this.instantAltitude = instantAltitude;
			}
		//-------------------------------------------------------------------------------------------------------
		public double getInstantDataAcuracy()
			{
				return instantDataAcuracy;
			}
		public void setInstantDataAcuracy(double instantDataAcuracy)
			{
				this.instantDataAcuracy = instantDataAcuracy;
			}
		//-------------------------------------------------------------------------------------------------------
		public double getInstantBearing()
			{
				return instantBearing;
			}
		public void setInstantBearing(double instantBearing)
			{
				this.instantBearing = instantBearing;
			}
		//-------------------------------------------------------------------------------------------------------
		
		public double getInstantTime()
			{
				return instantTime;
			}
		public void setInstantTime(long instantTime)
			{
				this.instantTime = instantTime;
			}
		//-------------------------------------------------------------------------------------------------------
		public String getInstantDataProvider()
			{
				return instantDataProvider;
			}
		public void setInstantDataProvider(String instantDataProvider)
			{
				this.instantDataProvider = instantDataProvider;
			}
		//-------------------------------------------------------------------------------------------------------
		public int getInstantNoOfSatelite()
			{
				return instantNoOfSatelite;
			}
		public void setInstantNoOfSatelite(int instantNoOfSatelite)
			{
				this.instantNoOfSatelite = instantNoOfSatelite;
			}
		
	}
