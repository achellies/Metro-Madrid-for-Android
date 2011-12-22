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

package com.antoniovazquezblanco.metromadrid;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.antoniovazquezblanco.metromadrid.api.Place;

public class PlaceListAdapter extends ArrayAdapter<Place>{

	private ArrayList<Place> mItems;
	private Context mContext;

	public PlaceListAdapter(Context context, int textViewResourceId, ArrayList<Place> items) {
		super(context, textViewResourceId, items);
		mItems = items;
		mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null)
			v = ((LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_placeitem, null);
		Place item = mItems.get(position);
		if (item != null) {
			((TextView) v.findViewById(R.id.list_placeitem_name)).setText(item.name);
			((TextView) v.findViewById(R.id.list_placeitem_distance)).setText(new DecimalFormat("#.###").format(item.distance)+"m");
		}
		return v;
	}
}
