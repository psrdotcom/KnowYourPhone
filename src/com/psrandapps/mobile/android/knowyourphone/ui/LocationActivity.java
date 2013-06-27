
package com.psrandapps.mobile.android.knowyourphone.ui;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.psrandapps.mobile.android.knowyourphone.R;
import com.psrandapps.mobile.android.knowyourphone.features.LocationOptions;

public class LocationActivity extends Activity
{
	private LocationOptions locationMgr;
	private EditText sms_recipient;
	private Button send_sms;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		
		locationMgr = new LocationOptions(this);

		sms_recipient = (EditText) findViewById(R.id.sms_recipient);
		send_sms = (Button) findViewById(R.id.send_sms);

		send_sms.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				try
				{
					// Send SMS to user specified number
					SmsManager smsManager = SmsManager.getDefault();
					String sms_rcvr = sms_recipient.getText().toString();
					if (!(TextUtils.isEmpty(sms_rcvr) || sms_rcvr.length() < 10))
					{
						System.out.println("SMS Recipient: " + sms_rcvr);
						System.out.println("Location: " + locationMgr.getLocation());

						smsManager.sendTextMessage(sms_recipient.getText().toString(), null, locationMgr.getLocation(),
								null, null);
						Toast.makeText(getApplicationContext(), "SMS has been sent", Toast.LENGTH_LONG).show();
						finish();
					}
					else
					{
						sms_recipient.setError("Incorrect values");
						Toast.makeText(getApplicationContext(), "Please enter correct mobile number", Toast.LENGTH_LONG)
								.show();
					}
				}
				catch (Exception e)
				{
					Toast.makeText(getApplicationContext(), "SMS failed, please try again later!", Toast.LENGTH_LONG)
							.show();
					e.printStackTrace();
				}
			}
		});

	}
	
	@Override
	public void onBackPressed()
	{
		this.finish();
	}
}
