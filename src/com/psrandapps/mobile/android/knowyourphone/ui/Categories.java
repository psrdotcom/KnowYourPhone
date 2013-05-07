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
	private static List<String> categories = new ArrayList<String>();;

	public Categories()
	{
	}

	/*
	 * @param cat_name the add category name
	 */
	public void add_category(String cat_name)
	{
		categories.add(cat_name);
	}

	/*
	 * @return the categories list String array
	 */
	public String[] get_categories()
	{
		return categories.toArray(new String[categories.size()]);
	}
}
