package com.antoniovazquezblanco.metromadrid.api;

import java.util.ArrayList;

import com.google.api.client.util.Key;

public class PlaceList {

	@Key
	public String status;

	@Key
	public ArrayList<Place> results;
}
