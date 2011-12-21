package com.antoniovazquezblanco.metromadrid;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	private Context mContext;
	private TabHost mTabHost;
	private Resources mResources;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO: Fragments+Pager: http://developer.android.com/resources/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentTabsPager.html

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		mContext = this;
		mResources = getResources();
		mTabHost = ((TabHost) findViewById(android.R.id.tabhost));

		mTabHost.addTab(mTabHost.newTabSpec("Map").setIndicator(getString(R.string.mapactivity_title), mResources.getDrawable(android.R.drawable.ic_menu_mapmode)).setContent(new Intent(mContext, MapActivity.class)));

		mTabHost.addTab(mTabHost.newTabSpec("NearSubway").setIndicator(getString(R.string.nearsubwayactivity_title), mResources.getDrawable(android.R.drawable.ic_menu_mylocation)).setContent(new Intent(mContext, NearSubwayActivity.class)));

		mTabHost.setCurrentTab(0);
	}
}