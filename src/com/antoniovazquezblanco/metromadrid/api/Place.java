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
