
package com.psrandapps.mobile.android.knowyourphone.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.psrandapps.mobile.android.knowyourphone.R;

public class HomeActivity extends Activity
{

	private Categories cats;
	private List<Feature> feat_tele, feat_pkg;
	private DataItems allData;

	private ExpandableListView elv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		cats = new Categories();
		cats.add_category("Telephony");
		cats.add_category("PackageInfo");

		feat_tele = new ArrayList<Feature>();
		feat_tele.add(new Feature("PhoneType"));
		feat_tele.add(new Feature("IMEI ID"));
		
		feat_pkg = new ArrayList<Feature>();
		feat_pkg.add(new Feature("Packages Count"));

		allData = new DataItems();
		allData.addFeatures(feat_tele);
		allData.addFeatures(feat_pkg);

		elv = (ExpandableListView) findViewById(R.id.featureslist);
		elv.setAdapter(new KnowYourPhoneAdapter(this));

	}

}
