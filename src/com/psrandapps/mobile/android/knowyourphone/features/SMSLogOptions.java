/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.features;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * @author Suresh Raju Pilli
 *
 */
public class SMSLogOptions
{	
	private Context context;
	private Cursor cursor;
	
	public SMSLogOptions()
	{}
	
	public SMSLogOptions(Context context)
	{
		this.context = context;
	}
	
	private void readSMS()
	{
		cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
	}

	public String getInboxSMSCount()
	{
		int count = 0, cnt = 0;
		cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
		cursor.moveToFirst();
		while (cursor.moveToNext())
		{
			System.out.println("SMS: " + cursor.getString(count));
			cnt += 1;
		}
		return "You have " + cnt + "message in your Inbox";
	}
}
