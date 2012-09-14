/*
   Copyright 2012 motionBEAT Inc.

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

import com.ad_stir.AdstirTerminate;
import com.ad_stir.AdstirView;

import android.view.ViewGroup.LayoutParams;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AdStirSampleActivity extends Activity {
	private AdstirView adstirView;
	private LinearLayout layout = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// onCreate()にここから
		layout = (LinearLayout) findViewById(R.id.ad_layout);
		adstirView = new AdstirView(this, "MEDIA-ID", SPOT-NO);
		layout.addView(adstirView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		// ここまでを追加
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// onDestroy()にここから
		AdstirTerminate.init(this);
		// ここまでを追加
	}
}
