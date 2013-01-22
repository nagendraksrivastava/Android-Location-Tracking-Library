package com.nagendra.nagendralibrary;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

public class ResponseFromServer extends AsyncHttpResponseHandler{
	
	public static String TAG = "ResponseFromServer";
	@Override
	public void onSuccess(String message)
		{
			Log.d(TAG,"Response from server recieved do what ever you want with received data");

		}
	@Override
	public void onFailure(Throwable e)
		{
			Log.d(TAG,"Error occured " + e);
		}

}
