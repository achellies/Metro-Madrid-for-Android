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

import com.smaato.SOMA.SOMABanner;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MapActivity extends Activity {

	private SOMABanner mBanner;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);

        // Set WebView properties.
        WebView mView = (WebView) findViewById(R.id.layout_map_webview);
        mView.getSettings().setBuiltInZoomControls(true);
        mView.getSettings().setUseWideViewPort(true);
        mView.getSettings().setJavaScriptEnabled(false);
        mView.loadUrl("file:///android_asset/map.html");

        // Set ad properties.
        mBanner = (SOMABanner) findViewById(R.id.layout_map_ad);
        mBanner.setPublisherId(KeyClass.SMAATO_PUBLISHER_ID);
        mBanner.setAdSpaceId(KeyClass.SMAATO_APP_ID);
        mBanner.setLocationUpdateEnabled(true);
    }

	@Override
	protected void onResume() {
		super.onResume();
		mBanner.setAutoRefresh(true);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mBanner.setAutoRefresh(false);
	}
}
