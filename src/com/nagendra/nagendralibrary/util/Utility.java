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
package com.nagendra.nagendralibrary.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;


public class Utility
{

	public static final String TAG = "Utility";
	
/**
 * <b><i>public static void generateLogOnSD(<font color="blue"><u>String</u></font> sBody, <font color="blue"><u>String</u></font> fileName, <font color="blue"><u>String</u></font> folderName)</b></i></p> 
	 * this method can be used to write file on sd card. It receives content of file as sbody parameter, name of the file 
	 * as fileName parameter and folder name as folderName parameter, First this method checks that sd card is available or not if available then
	 * it will write file on external storage which is called sd card	
 * @param sBody     	Content of the string
 * @param fileName		File name 
 * @param folderName	Folder Name
 */
	 public static void generateLogOnSD(String sBody, String fileName, String folderName) {
			try {
				Log.d(TAG,"inside generateLogOnSD");
				if(isExternalStoragePresent())
				{
					File file = new File(Environment.getExternalStorageDirectory(),folderName);
					if (!file.exists()) {
						file.mkdirs();
					}
					File gpxfile = new File(file, fileName);
					FileWriter writer = new FileWriter(gpxfile, true);
					writer.write(sBody);
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {

				e.printStackTrace();

			}
		}
/**
 * <b><i>private static boolean isExternalStoragePresent()</b></i></p>
 * this method can used to check that external storage(Sd card on device ) is available on device or not
 * @return {@link bool}
 * 
 */
	 private static boolean isExternalStoragePresent() {

			boolean mExternalStorageAvailable = false;
			boolean mExternalStorageWriteable = false;
			String state = Environment.getExternalStorageState();

			if (Environment.MEDIA_MOUNTED.equals(state)) {
				mExternalStorageAvailable = mExternalStorageWriteable = true;
			} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
				mExternalStorageAvailable = true;
				mExternalStorageWriteable = false;
			} else {
				mExternalStorageAvailable = mExternalStorageWriteable = false;
			}
			if (!((mExternalStorageAvailable) && (mExternalStorageWriteable))) {
			}
			return (mExternalStorageAvailable) && (mExternalStorageWriteable);
		}
	/**
	 * <b><i>public static boolean isTablet(Context context){</b></i>
	 * this method will return true if device is tab else it will return false
	 * @param context
	 * @return {@link bool}
	 * 
	 */
	public static boolean isTablet(Context context){
		TelephonyManager _manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		if(_manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
			return true;
		}
		else{
			return false;
		}
	}


	/**
	 * <b><i>public static boolean isTabletDevice(<font color="blue"><u>Context</u></font> activityContext)</b></i></p>
	 * Checks if the device is a tablet or a phone on the basis of density and display
	 * @param activityContext
	 *            The Activity Context.
	 * @return Returns true if the device is a Tablet
	 * 
	 */
	public static boolean isTabletDevice(Context activityContext) {

		boolean xlarge = ((activityContext.getResources().getConfiguration().screenLayout & 
					Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
		if (xlarge) {
			DisplayMetrics metrics = new DisplayMetrics();
			Activity activity = (Activity) activityContext;
			activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
			if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
						|| metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
						|| metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM)
				{

					// Yes, this is a tablet!
					return true;
				}
		}

		// No, this is not a tablet!
		return false;
	}
	
	/**
	 * <b><i>public  static void buildAlertMessageNoGps(final <font color="blue"><u>Context</font></u> context)</b></i></p> 
	 *  This method will prompt a dialog box and it will redirect to settings from where user can enable GPS functionality
	 *  @param context   Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font></p>
	 */
	public  static void buildAlertMessageNoGps(final Context context) {
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage("Your GPS seems to be disabled, do you want to enable it? With GPS we can track you more accurately")
		.setCancelable(false)
		.setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
			@Override
			public void onClick( final DialogInterface dialog,  final int id) {
				context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(final DialogInterface dialog,  final int id) {
				dialog.cancel();
			}
		});
		final AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Throws this exception if getting wrong location provider
	 * @author nagendra
	 *
	 */
		@SuppressWarnings("serial")
		public static class ServiceProviderException extends Exception
		{
			private final String locationProvider;

			public ServiceProviderException(String provider)
				{
					this.locationProvider = provider;
				}
			@Override
			public String toString()
				{
					return "You have passed provider "  + locationProvider + "  which is not available , Please use either gps, wifi or network"; 
				}

		}
		/**
		 * <b><i>public static boolean isGPRSAvailable(<font color="blue"><u>Context</font></u> context)</b></i></p>
		 * this will check whether GPRS is available or not
		 * @param  context	Context of your application which can get by using <font color="blue"><u> getApplicationContext()</u></font> or <font color="blue"> <u>this</u></font></p>
		 * @return boolean
		 * 
		 */
		public static boolean isGPRSAvailable(Context context)
			{
				ConnectivityManager connect = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo  netInfoMobile = connect.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
				if(netInfoMobile.isConnected())
					return true;
				else 
					return false;
			}
		/**
		 * <b><i>public static boolean isWIFIAvailable(<font color ="blue"><u>Context</font></u> context)</b></i></p>
		 * This method will check whether WIFI is available or not , if available it will return true else it will return false
		 * @return boolean
		 */
		public static boolean isWIFIAvailable(Context context)
			{
				ConnectivityManager connect = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo  netInfoWifi = connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
				if(netInfoWifi.isConnected())
					return true;
				else 
					return false;
			}
		/**
		 *  This method is used to write password on XML file
		 * @param password
		 */
		public static void writePasswordOnXml(String password, Context context)
			{
				SharedPreferences sharePrefs = context.getSharedPreferences("Name of the file", context.MODE_PRIVATE);
				SharedPreferences.Editor prefEditor; 
				try 
				{
					String data = EncryptDecryptData.encrypt("Capience",password);
					prefEditor = sharePrefs.edit();
					prefEditor.putString("password", data);
					prefEditor.commit();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}

			}
		/**
		 * <b><i>public static boolean isValidEmail(<font color="blue"><u>String</u></font> email)</b></i></p>
		 * this method can be used for email format validation if matched then return true else return false 
		 * @param email   pass the email address as a parameter which need to be validated
		 * @return boolean 
		 */
		public static boolean isValidEmail(String email) 
			{
				Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
				Matcher matcher = pattern.matcher(email);
				return matcher.matches();

			}

		/**
		 * <b><i>public static HashMap<String,String> getCurrentLocationByName(<font color="blue"><u>Context</u></font> context)</b></i></p>
		 * This method will return the address of the location in the form of hash map in key value pair, Values of the address can be retrieved using keys.
		 * The available keys are <font color = "red">country</font>, <font color = "red">admin_area</font>, <font color = "red">feature_name</font>, <font color = "red">locality_name</font>, 
		 * <font color = "red">postal_code</font>, <font color = "red">premises</font>, <font color = "red">sub_adminarea</font>, <font color = "red">sub_locality</font>,
		 *  <font color = "red">street_no</font>, <font color = "red">street_address</font>
		 * 
		 */
		public static HashMap<String,String> getCurrentLocationByName(Context context)
			{
				HashMap<String,String> addressValues = new HashMap<String,String>();
				double latitude = 0.0;
				double longtiude = 0.0;
				LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
				Location quickLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

				if (quickLocation != null)
					{
						latitude = quickLocation.getLatitude();
						longtiude = quickLocation.getLongitude();
					}
				Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
				try
					{
						List<Address> addresses = geoCoder.getFromLocation(latitude, longtiude, 1);
						if (addresses.size() > 0)
							{
								addressValues.put("country",addresses.get(0).getCountryName());
								addressValues.put("admin_area",addresses.get(0).getAdminArea());
								addressValues.put("feature_name",addresses.get(0).getFeatureName());
								addressValues.put("locality_name",addresses.get(0).getLocality());
								addressValues.put("postal_code",addresses.get(0).getPostalCode());
								addressValues.put("premises",addresses.get(0).getPremises());
								addressValues.put("sub_adminarea",addresses.get(0).getSubAdminArea());
								addressValues.put("sub_locality",addresses.get(0).getSubLocality());
								addressValues.put("street_no",addresses.get(0).getSubThoroughfare());
								addressValues.put("street_address",addresses.get(0).getThoroughfare());
								
								
							}
					} catch (IOException e)
					{

						e.printStackTrace();
					}
				return addressValues;
			}
}
