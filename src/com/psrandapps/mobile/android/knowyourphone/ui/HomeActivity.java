
package com.psrandapps.mobile.android.knowyourphone.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

import com.psrandapps.mobile.android.knowyourphone.R;
import com.psrandapps.mobile.android.knowyourphone.features.CallLogsOptions;
import com.psrandapps.mobile.android.knowyourphone.features.SMSLogOptions;
import com.psrandapps.mobile.android.knowyourphone.features.TelephoneManagerOptions;

public class HomeActivity extends Activity
{
	private Categories cats;
	private List<Feature> feat_tele, feat_callog, feat_sms, feat_pkg, feat_loca;
	private DataItems allData;

	private ExpandableListView elv;

	private TelephoneManagerOptions teleMgr;
	private CallLogsOptions callLogs;
	private SMSLogOptions smslogs;
	
	// private TextView mobileFeatureValue;

	private AlertDialog dialog;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		

		// Initialize telephone manager
		teleMgr = new TelephoneManagerOptions(this);
		// Initialize CallLogs
		callLogs = new CallLogsOptions(this);
		// Initialize SMS logs
		smslogs = new SMSLogOptions(this);

		addFeatures();

		// mobileFeatureValue = (TextView) findViewById(R.id.mobile_feature_value);
		elv = (ExpandableListView) findViewById(R.id.featureslist);
		elv.setAdapter(new KnowYourPhoneAdapter(this, cats, allData));

		elv.setOnChildClickListener(new OnChildClickListener()
		{
			boolean display = true;
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
			{
				TextView textView = (TextView) v;
				String clickedFeature = textView.getText().toString();
				String featureValue = "";
				
				// Telephony Manager
				if (clickedFeature.equalsIgnoreCase("CallState")) featureValue = teleMgr.getCallState();
				else if (clickedFeature.equalsIgnoreCase("CellLocation")) featureValue = teleMgr.getCellLocation();
				else if (clickedFeature.equalsIgnoreCase("DataDetails")) featureValue = teleMgr.getDataState() + "\n"
						+ teleMgr.getDataActivity();
				else if (clickedFeature.equalsIgnoreCase("DeviceDetails")) featureValue = "\nDevice ID: "
						+ teleMgr.getDeviceID() + "\nSoftware Version: " + teleMgr.getDeviceSoftwareVersion();
				else if (clickedFeature.equalsIgnoreCase("NetworkDetails")) featureValue = "\nNetwork Country ISO: "
						+ teleMgr.getNetworkCountryIso() + "\nNetwork Operator: " + teleMgr.getNetworkOperator()
						+ "\nNetwork Operator Name: " + teleMgr.getNetworkOperatorName() + "\nNetwork Type: "
						+ teleMgr.getNetworkType();
				else if (clickedFeature.equalsIgnoreCase("PhoneDetails")) featureValue = "\nPhoneType: "
						+ teleMgr.getPhoneType() + "\nPhoneNumber: " + teleMgr.getPhoneNumber();
				else if (clickedFeature.equalsIgnoreCase("SimDetails")) featureValue = "\nSIM Country ISO: "
						+ teleMgr.getSimCountryIso() + "\nSIM Operator: " + teleMgr.getSimOperator()
						+ "\nSIM Operator Name: " + teleMgr.getSimOperatorName() + "\nSIM Serial Number: "
						+ teleMgr.getSimSerialNumber() + "\nSIM Status: " + teleMgr.getSimStatus();
				else if (clickedFeature.equalsIgnoreCase("SubscriberID")) featureValue = teleMgr.getSubscriberId();
				else if (clickedFeature.equalsIgnoreCase("RoamingStatus")) featureValue = teleMgr.getRoamingStatus();
				// CallLogs
				else if (clickedFeature.equalsIgnoreCase("CallsList")) featureValue = callLogs.getCallLogs();
				// SMS
				else if (clickedFeature.equalsIgnoreCase("SMS")) featureValue = smslogs.getInboxSMSCount();
				// Location
				else if (clickedFeature.equalsIgnoreCase("LatLong"))
				{
					startActivity(new Intent().setClass(getApplicationContext(), LocationActivity.class));
					display = false;
				}
				// Display the details
				showFeatureValue(clickedFeature, featureValue, display);
				return true;
			}
		});
	}

	/*
	 * Display Message
	 * @param feature String Feature Name
	 * @param value String Value to display
	 * @return void
	 */
	private void showFeatureValue(String feature, String value, boolean display)
	{
		if (display)
		{
			if (value == null || value.equals("")) value = "Unavailable";
			
			// Toast.makeText(getApplicationContext(), feature + " : " + value,
			// Toast.LENGTH_SHORT).show();
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Information");
			builder.setMessage(feature + " : " + value);
			dialog = builder.create();
			dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
			dialog.show();
		}
	}
	
	/*
	 * Add all the features
	 */
	private void addFeatures()
	{
		
		// Add categories -- Groups
		cats = new Categories();
		cats.addCategory(" Telephony");
		cats.addCategory(" CallLogs");
		// cats.addCategory("PackageInfo");
		// cats.addCategory("SMS");
		cats.addCategory(" Location");
		
		// Telephony category: Adding features
		feat_tele = new ArrayList<Feature>();
		feat_tele.add(new Feature("CallState"));
		feat_tele.add(new Feature("CellLocation"));
		feat_tele.add(new Feature("DataDetails"));
		feat_tele.add(new Feature("DeviceDetails"));
		feat_tele.add(new Feature("NetworkDetails"));
		feat_tele.add(new Feature("PhoneDetails"));
		feat_tele.add(new Feature("SimDetails"));
		feat_tele.add(new Feature("SubscriberID"));
		feat_tele.add(new Feature("RoamingStatus"));
		
		// CallLog category
		feat_callog = new ArrayList<Feature>();
		feat_callog.add(new Feature("CallsList"));
		
		// Package Category: Adding features
		feat_pkg = new ArrayList<Feature>();
		feat_pkg.add(new Feature("Packages Count"));
		
		// SMS Category: Adding features
		feat_sms = new ArrayList<Feature>();
		feat_sms.add(new Feature("InboxCount"));
		
		// Location Category: Adding features
		feat_loca = new ArrayList<Feature>();
		feat_loca.add(new Feature("LatLong"));

		allData = new DataItems();
		allData.addFeatures(feat_tele);
		allData.addFeatures(feat_callog);
		// allData.addFeatures(feat_pkg);
		// allData.addFeatures(feat_sms);
		allData.addFeatures(feat_loca);
	}

	@Override
	public void onDestroy()
	{
		if (dialog != null)
		{
			if (dialog.isShowing())
			{
				dialog.dismiss();
			}
		}
		cats.clearCategoriesList();
		super.onDestroy();
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed()
	{
		this.finish();
		cats.clearCategoriesList();
		super.onBackPressed();
	}

}
