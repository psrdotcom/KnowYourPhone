/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.features;

import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;

/**
 * @author Suresh Raju Pilli
 *
 */
public class CallLogsOptions
{	
	private Context context;
	
	public CallLogsOptions()
	{}
	
	public CallLogsOptions(Context context)
	{
		this.context = context;
	}

	public String getCallLogs()
	{
		return getCallDetails();
	}

	private String getCallDetails()
	{
		StringBuffer buffer = new StringBuffer();
		
		Cursor clCursor = context.getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI,
				null, null, null, android.provider.CallLog.Calls.DEFAULT_SORT_ORDER);
		int number = clCursor.getColumnIndex(CallLog.Calls.NUMBER);
		int type = clCursor.getColumnIndex(CallLog.Calls.TYPE);
		int date = clCursor.getColumnIndex(CallLog.Calls.DATE);
		int duration = clCursor.getColumnIndex(CallLog.Calls.DURATION);

		buffer.append("\n");
		
		while (clCursor.moveToNext())
		{
			String phNumber = clCursor.getString(number);
			String callType = clCursor.getString(type);
			String callDate = clCursor.getString(date);
			Date callDayTime = new Date(Long.valueOf(callDate));
			String callDuration = clCursor.getString(duration);

			String dir = null;
			int dircode = Integer.parseInt(callType);

			switch (dircode)
			{
				case CallLog.Calls.OUTGOING_TYPE:
				{
					dir = "OUTGOING";
					break;
				}
				case CallLog.Calls.INCOMING_TYPE:
				{
					dir = "INCOMING";
					break;
				}
				case CallLog.Calls.MISSED_TYPE:
				{
					dir = "MISSED";
					break;
				}
			}
			buffer.append(" \nCall Type >>> " + dir + "\nPhone Number >>> " + phNumber + " \nDate & Time >>> "
					+ callDayTime + " \nCall Duration >>> " + callDuration + " sec");
			buffer.append("\n");
		}
		clCursor.close();
		
		return buffer.toString();
	}
}
