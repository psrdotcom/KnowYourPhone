/**
 * 
 */
package com.psrandapps.mobile.android.knowyourphone.features;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

/**
 * @author Suresh Raju Pilli
 *
 */
public class LocationOptions
{	
	private Context context;
	private double lati, longi;
	private String lat_long;
	
	public LocationOptions()
	{}
	
	public LocationOptions(Context context)
	{
		this.context = context;
	}
	
	/**
	 * @return the lat_long
	 */
	public String getLat_long()
	{
		return lat_long;
	}
	
	/**
	 * @param lat_long the lat_long to set
	 */
	public void setLat_long(double lati, double longi)
	{
		this.lati = lati;
		this.longi = longi;
		this.lat_long = "Latitude: " + String.valueOf(lati) + "Longitude" + String.valueOf(longi);
	}
	
	/**
	 * @return the lati
	 */
	public double getLati()
	{
		return lati;
	}
	
	/**
	 * @param lati the lati to set
	 */
	public void setLati(double lati)
	{
		this.lati = lati;
	}
	
	/**
	 * @return the longi
	 */
	public double getLongi()
	{
		return longi;
	}
	
	/**
	 * @param longi the longi to set
	 */
	public void setLongi(double longi)
	{
		this.longi = longi;
	}

	public String getLocation()
	{
		LocationManager locmgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = locmgr.getBestProvider(criteria, false);
		Location loc = locmgr.getLastKnownLocation(provider);
		if (loc != null)
		{
			double longi = loc.getLongitude();
			double lat = loc.getLatitude();
			lat_long = "Latitude: " + String.valueOf(lat) + "\nLongitude: " + String.valueOf(longi);
		} else
		{
			lat_long = "Provider Not Available";
		}
		return lat_long;
	}

}
