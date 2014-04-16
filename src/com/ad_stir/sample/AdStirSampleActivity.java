/*
   Copyright 2012-2013 UNITED, inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ad_stir.sample;

import com.ad_stir.webview.AdstirMraidView;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.app.Activity;
import android.os.Bundle;

public class AdStirSampleActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		AdstirMraidView view = new AdstirMraidView(this, "MEDIA-ID", SPOT-NO,AdstirMraidView.AdSize.Size320x50,AdstirMraidView.DEFAULT_INTERVAL);
		
		ViewGroup layout = (ViewGroup) findViewById(R.id.ad_layout);
		layout.addView(view, new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
