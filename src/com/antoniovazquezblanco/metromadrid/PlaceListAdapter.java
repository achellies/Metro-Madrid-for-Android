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
