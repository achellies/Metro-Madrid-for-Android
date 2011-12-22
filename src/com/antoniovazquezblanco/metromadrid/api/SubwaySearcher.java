/*
 * This file is part of Metro Madrid for Android.
 *
 * Metro Madrid is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Metro Madrid is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Metro Madrid.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.antoniovazquezblanco.metromadrid.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.location.Location;

import com.antoniovazquezblanco.metromadrid.KeyClass;
import com.antoniovazquezblanco.metromadrid.R;
import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

public class SubwaySearcher implements HttpRequestInitializer {

	private String APP_NAME;
	private HttpRequestFactory mHttpRequestFactory;

	public SubwaySearcher(Context mContext) {
		APP_NAME = mContext.getString(R.string.app_name);
		mHttpRequestFactory = new NetHttpTransport().createRequestFactory(this);
	}

	@Override
	public void initialize(HttpRequest request) throws IOException {
		GoogleHeaders headers = new GoogleHeaders();
		headers.setApplicationName(APP_NAME);
		request.setHeaders(headers);
		
		JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
		request.addParser(parser);
	}

	public ArrayList<Place> performSearch(Location location) throws IOException {
		HttpRequest request = mHttpRequestFactory.buildGetRequest(new GenericUrl("https://maps.googleapis.com/maps/api/place/search/json?"));
		request.getUrl().put("key", KeyClass.GOOGLE_API_KEY);
		request.getUrl().put("radius", 2000);
	    request.getUrl().put("sensor", "true");
	    request.getUrl().put("types", "subway_station");
	    request.getUrl().put("location", String.valueOf(location.getLatitude())+","+String.valueOf(location.getLongitude()));
	    ArrayList<Place> p = request.execute().parseAs(PlaceList.class).results;
	    for(Place pl : p)
	    	pl.computeDistance(location);
	    Collections.sort(p);
	    return p;
	}
}
