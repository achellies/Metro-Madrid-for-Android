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