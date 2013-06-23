/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.ui;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * @author Suresh Raju Pilli
 *
 */
public class KnowYourPhoneAdapter extends BaseExpandableListAdapter
{
	private Context context;

	private List<String> parent;
	private List<List<Feature>> childs;

	public KnowYourPhoneAdapter(Context context, Categories cats, DataItems allData)
	{
		this.context = context;
		Log.d("Adapter", "Adapter");
		
		parent = cats.getCategoriesList();
		childs = allData.getFeaturesList();
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getChild(int, int)
	 */
	@Override
	public Object getChild(int arg0, int arg1)
	{
		return childs.get(arg0).get(arg1).getFeature_name();
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getChildId(int, int)
	 */
	@Override
	public long getChildId(int arg0, int arg1)
	{
		return arg0 * arg1;
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3, ViewGroup arg4)
	{
		TextView tv = new TextView(context);
		tv.setText(childs.get(arg0).get(arg1).getFeature_name());
		tv.setPadding(50, 5, 5, 5);
		return tv;
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getChildrenCount(int)
	 */
	@Override
	public int getChildrenCount(int arg0)
	{
		return childs.get(arg0).size();
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getGroup(int)
	 */
	@Override
	public Object getGroup(int arg0)
	{
		return parent.get(arg0);
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getGroupCount()
	 */
	@Override
	public int getGroupCount()
	{
		return parent.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getGroupId(int)
	 */
	@Override
	public long getGroupId(int arg0)
	{
		return arg0;
	}

	/* (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3)
	{
		TextView tv = new TextView(context);
		tv.setText(parent.get(arg0));
		tv.setPadding(30, 10, 10, 10);
		tv.setTextSize(15.5f);
		return tv;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#hasStableIds()
	 */
	@Override
	public boolean hasStableIds()
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
	 */
	@Override
	public boolean isChildSelectable(int arg0, int arg1)
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.BaseExpandableListAdapter#onGroupCollapsed(int)
	 */
	@Override
	public void onGroupCollapsed(int groupPosition)
	{
		super.onGroupCollapsed(groupPosition);
	}

	/*
	 * (non-Javadoc)
	 * @see android.widget.BaseExpandableListAdapter#onGroupExpanded(int)
	 */
	@Override
	public void onGroupExpanded(int groupPosition)
	{
		super.onGroupExpanded(groupPosition);
	}

}
