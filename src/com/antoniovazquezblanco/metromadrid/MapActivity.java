package com.antoniovazquezblanco.metromadrid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MapActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);

        WebView mView = (WebView) findViewById(R.id.webview);
        mView.getSettings().setBuiltInZoomControls(true);
        mView.getSettings().setUseWideViewPort(true);
        mView.getSettings().setJavaScriptEnabled(false);
        mView.loadUrl("file:///android_asset/map.html");
    }
}
