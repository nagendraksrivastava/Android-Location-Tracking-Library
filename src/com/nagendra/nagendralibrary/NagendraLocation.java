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

import java.util.HashMap;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nagendra.data.InstantLocationData;
import com.nagendra.data.PeriodicLocationData;
import com.nagendra.nagendralibrary.util.LibConstants;
import com.nagendra.nagendralibrary.util.Utility;
import com.nagendra.nagendralibrary.util.Utility.ServiceProviderException;
//this class is designed  for tracking as per user request from client side . For example if user request for taxi or similar situation or he wants to get tracked then this class can be utilized
public  class NagendraLocation
{
	public static final String TAG 		= 	"StartUserTrack";
	

	private LocationManager  				locationManager;
	private LocationListener				periodicLocationListner;
	private InstantLocationData             instantLocationData;
	private PeriodicLocationData			periodicLocationData;
	
	public interface gpsProvider
	{
		void gpsProviderEnabled();
		void gpsProviderDisabled();
	}
	

	public NagendraLocation()
		{
			super();

			
		}


	/**
	 * <b><i>public final void instantLocation(<font color="red"><u>Context</u></font> context)</b></i></p>
	 * Get instant location. provider will be automatically selected
	 * @param context Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font></p>
	 */
	public final void instantLocation(Context context)
		{
			instantLocationData = new InstantLocationData();
			locationManager  		= (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
			try
				{
					locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,new NagendraSingleLocationListener(),null);
				}
			catch (IllegalArgumentException e) {
				try
					{
						locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER,new NagendraSingleLocationListener(),null);
					}
				catch (IllegalArgumentException ilae) {
				 Log.d(TAG,"Both Gps and Network provider is not available");
				 
				}
				catch(SecurityException se)
				{
					Log.d(TAG, "Access coarse or access fine location permission is not declared in manifest file");
				}
			}
			catch(SecurityException se)
				{
					Log.d(TAG,"Access coarse or access fine location permission is not declared in manifest.xml ");
				}

		}
	
	/**
	 * <b><i>public final void instantLocation(<font color="blue"><u>Context</u></font> context, <font color="blue"><u>String</u></font> provider)</b></i></p>
	 * Get instant location  and send this location to our server
	 * @param context - Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font>
	 * @param provider - Provider name which will be passed as parameter which must be either gps , wifi or network 
	 * @throws ServiceProviderException   if provider is null or does not exist
	 */
	public final void instantLocation(Context context, String provider) throws ServiceProviderException
	{

		instantLocationData 	= new InstantLocationData();
		locationManager  		= (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		if(provider.equalsIgnoreCase("gps"))
			{
				locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,new NagendraSingleLocationListener(),null);
			}
		else
			{
				if(provider.equalsIgnoreCase("wifi") || provider.equalsIgnoreCase("network"))
					{
						locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER,new NagendraSingleLocationListener(),null);
					}
				else
					{
						throw new ServiceProviderException(provider);
					}
			}

	}
	
	/**
	 * <b><i>public HashMap<String,Double> userLastLocation(<font color="blue"><u>Context</u></font> context)</b></i></p>
	 * Retrieves user's last location data. It can be beneficial when user is not in network coverage so last location can be retrieved</br>
	 * <font colour="blue"><u>Key-</u></font> <font color="red"> lat, lon, dir </font> where lat- latitude, lon- longitude, dir- direction
	 * @param context				Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font>
	 * @return last location data 
	 */
	public HashMap<String,Double> userLastLocation(Context context)
		{
			HashMap<String,Double> locationData = new HashMap<String,Double>();
			locationManager  		= (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
			Location location 		= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			locationData.put("lat",location.getLatitude());
			locationData.put("lon",location.getLongitude());
			locationData.put("dir",(double)location.getBearing());
			return locationData;
			
		}
	
	/**
	 * <b><i>public final void startPeriodicTracking(<font color="blue"><u>Context</font></u> context,<font color="blue"><u>long</u></font> minTrackingTime,<font color="blue"><u>float</u></font>
	 *  minTrackingDistance)</b></i>
	 * <br>
	 * <br>
	 * this method should be called when user request for taxi for in the similar situation and need to send information to our centralised server(this comment must be modified later)
	 * Overriding of this method is not allowed.
	 * <br>
	 * @param context  				Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font></p>
	 * @param minTrackingTime		Minimum time interval for location updates ,  In mili seconds ,<b> For example</b> if minTrackingTime = 2000 then after every 2 seconds it will receive location updates.</p>
	 * @param minTrackingDistance   Minimum tracking distance for location updates , in meter , <b>For Example</b> if minTrackingDistance = 1000 then after every 1000 meter it will receive location updates
	 */
	public final void startPeriodicTracking(Context context,long minTrackingTime,float minTrackingDistance)
		{
			periodicLocationData = new PeriodicLocationData();
			locationManager  = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
	
			
			if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
				{
					locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTrackingTime,minTrackingDistance,new NagendraPeriodicLocationListner());
				}
			else
				{
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTrackingTime,minTrackingDistance,new NagendraPeriodicLocationListner());
				}
			

		}

	/**
	 * <b><i>public final void startPeriodicTracking(<font color="blue"><u>Context</u></font> context,<font color="blue"><u>String</font></u> provider,<font color="blue"><u>long</font></u> minTrackingTime,<font color="blue"><u>float</font></u> minTrackingDistance)
	 * </b></i></p>
	 * this method should be called when user request for taxi for in the similar situation and need to send information to our centralised server(this comment must be modified later for demo only)
	 * Overriding of this method is not allowed.
	 * @param context  						Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font></p>
	 * @param provider						Provider name which will be passed as parameter which must be either gps , wifi or network
	 * @param minTrackingTime				Minimum time interval for location updates ,  In mili seconds ,<b> For example</b> if minTrackingTime = 2000 then after every 2 seconds it will receive location updates.</p>
	 * @param minTrackingDistance			Minimum tracking distance for location updates , in meter , <b>For Example</b> if minTrackingDistance = 1000 then after every 1000 meter it will receive location updates
	 * @throws ServiceProviderException 	if provider is null or does not exist
	 */
	public final void startPeriodicTracking(Context context,String provider,long minTrackingTime,float minTrackingDistance) throws ServiceProviderException
	{	
		periodicLocationData 	= new PeriodicLocationData();
		locationManager  		= (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		if(provider.equalsIgnoreCase("gps") )
			{
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTrackingTime,minTrackingDistance,new NagendraPeriodicLocationListner());
			}
		else
			{
				if(provider.equalsIgnoreCase("wifi") || provider.equalsIgnoreCase("network"))
					{
						locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTrackingTime,minTrackingDistance,new NagendraPeriodicLocationListner());
					}
				else
					{
						throw new ServiceProviderException(provider);
					}
			}
	}
	
	/**
	 * This method will stop the periodic location update
	 */
	public void stopLocationUpdate()
		{
			locationManager.removeUpdates(periodicLocationListner);
		}
	/**
	 * Location Listener class which will listen for single location. That location will be current location of the device 
	 * @author nagendra
	 *
	 */
	private class NagendraSingleLocationListener implements LocationListener,gpsProvider
	{

		@Override
		public  void onLocationChanged(Location location)
			{
				instantLocationData.setInstantLatitude(location.getLatitude());
				instantLocationData.setInstantLongitude(location.getLongitude());
				instantLocationData.setInstantAltitude(location.getAltitude());
				instantLocationData.setInstantBearing(location.getBearing());
				instantLocationData.setInstantDataAcuracy(location.getAccuracy());
				instantLocationData.setInstantDataProvider(location.getProvider());
				instantLocationData.setInstantSpeed(location.getSpeed());
				instantLocationData.setInstantTime(location.getTime());
				instantLocationData.setInstantNoOfSatelite(location.getExtras().getInt("satellites", 0));

			}

		@Override
		public void onProviderDisabled(String provider)
			{
				gpsProviderDisabled();

			}

		@Override
		public void onProviderEnabled(String provider)
			{
				gpsProviderEnabled();

			}

		@Override
		public void onStatusChanged(String provider,int status,Bundle extras)
			{


			}

		@Override
		public void gpsProviderEnabled() {
			
			
		}

		@Override
		public void gpsProviderDisabled() {
			
			
		}

	}

	private class NagendraPeriodicLocationListner implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location)
			{
				periodicLocationData.setPeriodicAltitude(location.getAltitude()); 		
				periodicLocationData.setPeriodicBearing(location.getBearing());
				periodicLocationData.setPeriodicDataAcuracy(location.getAccuracy());
				periodicLocationData.setPeriodicDataProvider(location.getProvider());
				periodicLocationData.setPeriodicLatitude(location.getLatitude());
				periodicLocationData.setPeriodicLongitude(location.getLongitude());
				periodicLocationData.setPeriodicSpeed(location.getSpeed());
				periodicLocationData.setPeriodicTime(location.getTime());
				periodicLocationData.setPeriodicNoOfSatelite(location.getExtras().getInt("satellites ", 0));
				
			}

		@Override
		public void onProviderDisabled(String provider)
			{
				
			}

		@Override
		public void onProviderEnabled(String provider)
			{
				

			}

		@Override
		public void onStatusChanged(String provider,int status,Bundle extras)
			{
				

			}

	}
	
}
