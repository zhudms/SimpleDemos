package com.zl.myemptydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class PullableListView extends ListView implements Pullable {

	private boolean canPullDown = true;
	private boolean canPullUp = true;

	public PullableListView(Context context) {
		super(context);
	}

	public PullableListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PullableListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown() {

		if (!canPullDown) {
			return false;
		}

		if (getCount() == 0) {
			// 没有item的时候也可以下拉刷新
			return true;
		} else if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0) {
			// 滑到ListView的顶部了
			return true;
		} else
			return false;
	}

	@Override
	public boolean canPullUp() {

		if (!canPullUp) {
			return false;
		}

		if (getCount() == 0) {
			// 没有item的时候也可以上拉加载
			return true;
		} else if (getLastVisiblePosition() == (getCount() - 1)) {
			// 滑到底部了
			if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
					&& getChildAt(
							getLastVisiblePosition()
									- getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
				return true;
		}
		return false;
	}

	/* (non-Javadoc)设置是否可以加载更多
	 * @see com.fec.xyjiemo.common.pullableview.Pullable#setPullUp(boolean)
	 */
	@Override
	public void setPullUp(boolean canPullUp) {
		this.canPullUp = canPullUp;

	}

	/* (non-Javadoc)设置是否可以下拉刷新
	 * @see com.fec.xyjiemo.common.pullableview.Pullable#setPullDown(boolean)
	 */
	@Override
	public void setPullDown(boolean canPullDown) {
		this.canPullDown = canPullDown;

	}
}
