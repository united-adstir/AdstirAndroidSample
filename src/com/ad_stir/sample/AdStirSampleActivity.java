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

import com.ngigroup.adstir.AdstirTerminate;
import com.ngigroup.adstir.AdstirView;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AdStirSampleActivity extends Activity {
	private AdstirView adstirView;
	private LinearLayout layout = null;
	private static final int SPOT = 枠No; // 枠Noは利用するアプリの枠Noを指定してください。

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// onCreate()にここから
		layout = (LinearLayout) findViewById(R.id.ad_layout); // 先ほどレイアウトに追加したidを指定してください。
		adstirView = new AdstirView(this, SPOT);
		layout.addView(adstirView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		// ここまでを追加
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// onDestroy()にここから
		new AdstirTerminate(this);
		// ここまでを追加
	}

	// AdstirViewのstopメソッドを実行することにより、不要な通信を抑えることが出来ます。
	@Override
	protected void onPause() {
		super.onPause();

		// onPause()にここから
		adstirView.stop();
		ViewGroup parent = (ViewGroup) adstirView.getParent();
		if (parent != null) {
			parent.removeView(adstirView);
		}
		// ここまでを追加
	}

	// AdstirViewのstartメソッドを実行することにより、通信を再開することが出来ます。
	@Override
	protected void onResume() {
		super.onResume();

		// onResume()にここから
		int index = 0;
		while (layout.getChildAt(index) != null) {
			if (layout.getChildAt(index) == adstirView) {
				return;
			}
			index++;
		}
		adstirView = null;
		adstirView = new AdstirView(this, SPOT);
		layout.addView(adstirView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		adstirView.start();
		// ここまでを追加
	}
}
