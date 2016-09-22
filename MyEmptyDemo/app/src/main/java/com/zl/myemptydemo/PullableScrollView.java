package com.zl.myemptydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PullableScrollView extends ScrollView implements Pullable {

	private boolean canPullDown = true;
	private boolean canPullUp = true;

	public PullableScrollView(Context context) {
		super(context);
	}

	public PullableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PullableScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown() {

		if (!canPullDown) {
			return false;
		}

		if (getScrollY() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean canPullUp() {

		if (!canPullUp) {
			return false;
		}

		if (getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight()))
			return true;
		else
			return false;
	}

	@Override
	public void setPullUp(boolean canPullUp) {
		this.canPullUp = canPullUp;
	}

	@Override
	public void setPullDown(boolean canPullDown) {

		this.canPullDown = canPullDown;
	}

}
