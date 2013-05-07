/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.ui;

import java.util.ArrayList;
import java.util.Iterator;
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
	public String[][] getFeaturesList()
	{
		String[][] allFeatures = new String[features_list.size()][];

		int i = 0, j = 0;
		for (Iterator<List<Feature>> itr = features_list.iterator(); itr.hasNext();)
		{
			List<Feature> feature = itr.next();
			Feature feature_arr[];
			allFeatures[i] = new String[feature.size()];

			// feature_arr = feature.toArray(new Feature[feature.size()]);
			// for (; j < feature_arr;)
			// allFeatures[i][j] = feature_arr[i].getFeature_name();
			// i++;
			// j++;
		}

		return allFeatures;
	}

}
