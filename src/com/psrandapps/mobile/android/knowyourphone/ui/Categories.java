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
public class Categories
{
	private static List<String> categories = new ArrayList<String>();
	private String cat_name;

	public Categories()
	{}

	/**
	 * @return the cat_name
	 */
	public String getCategoryname()
	{
		return cat_name;
	}

	/**
	 * @param cat_name the cat_name to set
	 */
	public void setCat_name(String cat_name)
	{
		this.cat_name = cat_name;
	}

	/*
	 * @param cat_name the add category name
	 */
	public void addCategory(String cat_name)
	{
		setCat_name(cat_name);
		categories.add(cat_name);
	}

	/*
	 * @return the categories list
	 */
	public List<String> getCategoriesList()
	{
		return categories;
	}

	/*
	 * Clear Categories
	 */
	public void clearCategoriesList()
	{
		categories.clear();
	}
}
