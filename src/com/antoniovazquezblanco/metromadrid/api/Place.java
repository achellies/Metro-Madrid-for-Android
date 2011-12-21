package com.antoniovazquezblanco.metromadrid.api;

import android.location.Location;

import com.google.api.client.util.Key;

public class Place implements Comparable<Place> {

	@Key
	public Geometry geometry;

	@Key
	public String id;

	@Key
	public String name;

	@Key
	public String reference;

	public double distance;

	public void computeDistance(double latitude, double longitude) {
		
	}

	@Override
	public int compareTo(Place a) {
		return (int)(distance-a.distance);
	}

	public void computeDistance(Location location) {
		distance = location.distanceTo(geometry.getLocation());
	}
}
