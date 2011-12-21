package com.antoniovazquezblanco.metromadrid.api;

import android.location.Location;

import com.google.api.client.util.Key;

public class Geometry {
	
	@Key
	public Loc location;

	public Location getLocation() {
		Location l = new Location("");
		l.setLatitude(location.lat);
		l.setLongitude(location.lng);
		return l;
	}
}
