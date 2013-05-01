/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.features;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @author PSR
 *
 */
public class TelephoneManagerOptions {

	private Context context;
	private TelephonyManager telemgr;
	
	public TelephoneManagerOptions()
	{}
	
	public TelephoneManagerOptions(Context context)
	{
		this.setContext(context);
		telemgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
	}
	
	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	public String getPhoneType()
	{
		int type = telemgr.getPhoneType();
		String phoneType = null;
		
		switch(type)
		{
		case (TelephonyManager.PHONE_TYPE_CDMA):
			phoneType = "CDMA Phone";
			break;
		case (TelephonyManager.PHONE_TYPE_GSM):
			phoneType = "GSM Phone";
			break;
		case (TelephonyManager.PHONE_TYPE_SIP):
			phoneType = "SIP Phone";
			break;
		case (TelephonyManager.PHONE_TYPE_NONE):
			phoneType = "No Radio";
			break;
		default:
			phoneType = "Invalid Phone Type";
			break;
		}
		return phoneType;
	}
	
	
}
