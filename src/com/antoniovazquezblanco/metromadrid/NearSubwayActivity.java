package com.antoniovazquezblanco.metromadrid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.antoniovazquezblanco.metromadrid.api.Place;
import com.antoniovazquezblanco.metromadrid.api.SubwaySearcher;

public class NearSubwayActivity extends Activity implements LocationListener {

	private Context mContext;
	private ArrayList<Place> mPlaceList;
	private PlaceListAdapter mAdapter;
	private SubwaySearcher mSubSearcher;
	private LocationManager mLocationManager;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_nearsubway);

		mContext = this;
		mSubSearcher = new SubwaySearcher(mContext);
		mPlaceList = new ArrayList<Place>();
		mAdapter = new PlaceListAdapter(mContext, R.id.layout_nearsubway_list, mPlaceList);
		((ListView) findViewById(R.id.layout_nearsubway_list)).setAdapter(mAdapter);
		mLocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		// TODO: Mostrar logo!
	}

	@Override
	public void onResume() {
		super.onResume();

		//Request location...
		String provider = mLocationManager.getBestProvider(new Criteria(), false);
		if(!mLocationManager.isProviderEnabled(provider))
			// TODO: Dialog...
			Toast.makeText(mContext, "This app needs GPS or location providers.", Toast.LENGTH_LONG);
		mLocationManager.requestLocationUpdates(provider, 500, 1, this);
	}

	@Override
	public void onPause() {
		super.onPause();

		//Delete listener...
		mLocationManager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		try {
			mPlaceList.clear();
			mPlaceList.addAll(mSubSearcher.performSearch(location));
			mAdapter.notifyDataSetChanged();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
