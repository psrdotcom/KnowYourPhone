/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.ui;

/**
 * @author Suresh Raju Pilli
 */
public class Feature
{
	private String feature_name;

	public Feature()
	{}

	public Feature(String feature_name)
	{
		setFeature_name(feature_name);
	}

	/**
	 * @return the feature_name
	 */
	public String getFeature_name()
	{
		return feature_name;
	}

	/**
	 * @param feature_name the feature_name to set
	 */
	public void setFeature_name(String feature_name)
	{
		this.feature_name = feature_name;
	}
}
