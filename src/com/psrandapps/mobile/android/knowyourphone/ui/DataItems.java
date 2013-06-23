/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suresh Raju Pilli
 *
 */
public class DataItems
{
	private static List<List<Feature>> features_list = new ArrayList<List<Feature>>();;

	public DataItems()
	{
	}

	public void addFeatures(List<Feature> features)
	{
		features_list.add(features);
	}

	/**
	 * @return the all features list
	 */
	public List<List<Feature>> getFeaturesList()
	{
		return features_list;

	}

}
