package zxyilian.mygesturedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import zxyilian.mygesturedemo.view.GestureLockViewGroup;


public class MainActivity extends Activity
{

	private GestureLockViewGroup mGestureLockViewGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mGestureLockViewGroup = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGroup);
		mGestureLockViewGroup.setAnswer(new int[] { 1, 2, 3, 4,5 });
		mGestureLockViewGroup
				.setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener()
				{

					@Override
					public void onUnmatchedExceedBoundary()
					{
						Toast.makeText(MainActivity.this, "错误5次...",
								Toast.LENGTH_SHORT).show();
						mGestureLockViewGroup.setUnMatchExceedBoundary(5);
					}

					@Override
					public void onGestureEvent(boolean matched)
					{
						Toast.makeText(MainActivity.this, matched+"",
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onBlockSelected(int cId)
					{
					}
				});

		Button btn=(Button)findViewById(R.id.confirm);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ArrayList<Integer> mList=mGestureLockViewGroup.getMyChose();
				for (Integer i:mList){
					Log.d("asd",i.toString());

				}

			}
		});
	}

}
