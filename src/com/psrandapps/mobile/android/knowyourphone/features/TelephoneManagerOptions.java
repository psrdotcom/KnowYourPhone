/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.features;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

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

	/*
	 * @return the CallState
	 */
	public String getCallState()
	{
		String callState = "";
		
		int callSt = telemgr.getCallState();
		switch (callSt)
		{
			case TelephonyManager.CALL_STATE_IDLE:
			{
				callState = "No activity";
				break;
			}
			case TelephonyManager.CALL_STATE_OFFHOOK:
			{
				callState = "Off-hook";
				break;
			}
			case TelephonyManager.CALL_STATE_RINGING:
			{
				callState = "Ringing";
				break;
			}
		}
		return callState;
	}
	
	/*
	 * @return the CellLocation
	 */
	public String getCellLocation()
	{
		GsmCellLocation loc = (GsmCellLocation) telemgr.getCellLocation();
		
		int cellid = loc.getCid();
		int lac = loc.getLac();
		return "\nCellID: " + String.valueOf(cellid) + "\nLAC: " + String.valueOf(lac);
	}
	
	/*
	 * @return the Data Activity
	 */
	public String getDataActivity()
	{
		String dataActivtiy = "";
		
		int dataAct = telemgr.getDataActivity();
		switch (dataAct)
		{
			case TelephonyManager.DATA_ACTIVITY_DORMANT:
			{
				dataActivtiy = "Data connection is active, but physical link is down";
				break;
			}
			case TelephonyManager.DATA_ACTIVITY_IN:
			{
				dataActivtiy = "Data connection activity: Currently receiving IP PPP traffic";
				break;
			}
			case TelephonyManager.DATA_ACTIVITY_INOUT:
			{
				dataActivtiy = "Data connection activity: Currently both sending and receiving IP PPP traffic";
				break;
			}
			case TelephonyManager.DATA_ACTIVITY_NONE:
			{
				dataActivtiy = "Data connection activity: No traffic";
				break;
			}
			case TelephonyManager.DATA_ACTIVITY_OUT:
			{
				dataActivtiy = "Data connection activity: Currently sending IP PPP traffic";
				break;
			}
		}
		return dataActivtiy;
	}
	
	/*
	 * @return the DataState
	 */
	public String getDataState()
	{
		String dataState = "";
		
		int dataSt = telemgr.getDataState();
		switch (dataSt)
		{
			case TelephonyManager.DATA_CONNECTED:
			{
				dataState = "Connected";
				break;
			}
			case TelephonyManager.DATA_CONNECTING:
			{
				dataState = "Currently setting up a data connection";
				break;
			}
			case TelephonyManager.DATA_DISCONNECTED:
			{
				dataState = "Disconnected";
				break;
			}
			case TelephonyManager.DATA_SUSPENDED:
			{
				dataState = "Suspended";
				break;
			}
		}
		return "\n" + "Data connection state: " + dataState;
	}
	
	/*
	 * @return the phone unique id GSM - IMEI, CDMA - MEID
	 */
	public String getDeviceID()
	{
		return telemgr.getDeviceId();
	}
	
	/*
	 * @return the DeviceSoftwareVersion
	 */
	public String getDeviceSoftwareVersion()
	{
		return telemgr.getDeviceSoftwareVersion();
	}

	/*
	 * @return the NetworkCountryIso
	 */
	public String getNetworkCountryIso()
	{
		return telemgr.getNetworkCountryIso();
	}
	
	/*
	 * @return the NetworkOperator
	 */
	public String getNetworkOperator()
	{
		return telemgr.getNetworkOperator();
	}
	
	/*
	 * @return the NetworkOperatorName
	 */
	public String getNetworkOperatorName()
	{
		return telemgr.getNetworkOperatorName();
	}
	
	/*
	 * @return the Network Type
	 */
	public String getNetworkType()
	{
		String networkType = "";
		
		int netType = telemgr.getNetworkType();
		switch (netType)
		{
			case (TelephonyManager.NETWORK_TYPE_1xRTT) :
			{
				networkType = "1xRTT";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_CDMA) :
			{
				networkType = "CDMA: Either IS95A or IS95B";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_EDGE) :
			{
				networkType = "EDGE";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_EHRPD):
			{
				networkType = "eHRPD";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_EVDO_0) :
			{
				networkType = "EVDO revision 0";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_EVDO_A):
			{
				networkType = "EVDO revision A";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_EVDO_B):
			{
				networkType = "EVDO revision B";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_GPRS):
			{
				networkType = "GPRS";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_HSDPA):
			{
				networkType = "HSDPA";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_HSPA):
			{
				networkType = "HSPA";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_HSPAP):
			{
				networkType = "HSPA+";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_HSUPA):
			{
				networkType = "HSUPA";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_IDEN):
			{
				networkType = "iDen";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_LTE):
			{
				networkType = "LTE";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_UMTS):
			{
				networkType = "UMTS";
				break;
			}
			case (TelephonyManager.NETWORK_TYPE_UNKNOWN):
			{
				networkType = "UNKNOWN";
				break;
			}
		}
		return "Current network is " + networkType;
	}
	
	/*
	 * @return the phone number
	 */
	public String getPhoneNumber()
	{
		return telemgr.getLine1Number();
	}
	
	/*
	 * @return the phone type GSM, CDMA
	 */
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
	
	/*
	 * @return the SimCountryIso
	 */
	public String getSimCountryIso()
	{
		return telemgr.getSimCountryIso();
	}
	
	/*
	 * @return the SimOperator
	 */
	public String getSimOperator()
	{
		return telemgr.getSimOperator();
	}
	
	/*
	 * @return the SimOperatorName
	 */
	public String getSimOperatorName()
	{
		return telemgr.getSimOperatorName();
	}
	
	/*
	 * @return the SimSerialNumber
	 */
	public String getSimSerialNumber()
	{
		return telemgr.getSimSerialNumber();
	}
	
	/*
	 * @return the SimStatus
	 */
	public String getSimStatus()
	{
		String simState = "";
		
		int SIMState=telemgr.getSimState();
	    switch(SIMState)
	    {
	            case TelephonyManager.SIM_STATE_ABSENT :
	                simState = "No SIM card available on the device";
	                break;
	            case TelephonyManager.SIM_STATE_NETWORK_LOCKED :
	                simState = "Locked: requries a network PIN to unlock";
	                break;
	            case TelephonyManager.SIM_STATE_PIN_REQUIRED :
	                simState = "Locked: requires the user's SIM PIN to unlock";
	                break;
	            case TelephonyManager.SIM_STATE_PUK_REQUIRED :
	                simState = "Locked: requires the user's SIM PUK to unlock";
	                break;
	            case TelephonyManager.SIM_STATE_READY :
	                simState = "Ready to use";
	                break;
	            case TelephonyManager.SIM_STATE_UNKNOWN :
	                simState = "Unknown state";
	                break;
	    }
		return simState;
	}
	
	/*
	 * @return the SubscriberId
	 */
	public String getSubscriberId()
	{
		return telemgr.getSubscriberId();
	}
	
	/*
	 * @return the VoiceMailNumber
	 */
	public String getVoiceMailNumber()
	{
		return telemgr.getVoiceMailNumber();
	}
	
	/*
	 * @return the Roaming Status
	 */
	public String getRoamingStatus()
	{
		if (telemgr.isNetworkRoaming()) return "Roaming";
		else return "Not Roaming";
	}

}
