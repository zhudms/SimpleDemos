package com.rongyile.myfacews;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rongyile.myfacews.eventBean.WSReconizeFaceE;
import com.rongyile.myfacews.ui.UIChild;
import com.rongyile.myfacews.ui.UIGroup;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "asd";
    private ImageView mImageVeiw;
    private ImageView face2;
    private int width;
    private int childWidth;
    private int currentChildNumb = 2;
    private int left;
    private UIGroup mGroupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WindowManager manager = ((WindowManager) getSystemService(Context.WINDOW_SERVICE));
//        Display dis = manager.getDefaultDisplay();
//        width = dis.getWidth();
        mGroupView = ((UIGroup) findViewById(R.id.group));

//        mImageVeiw = ((ImageView) findViewById(R.id.face_show));
//
//        mImageVeiw.getWidth();
//        left = mImageVeiw.getLeft();
//
//        face2 = ((ImageView) findViewById(R.id.face_2));
//        mImageVeiw.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.a));
//        try {
//
//            WebsocketPushMsg.startConnection(MainActivity.this, "ws://192.168.1.49:9000/video", "rtsp://192.168.1.40/user=admin&password=&channel=1&stream=0.sdp?");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }
        CountDownTimer timer = new CountDownTimer(30000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this,"onTick",Toast.LENGTH_SHORT).show();
                addShowView();
//                addShowView();
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"onFinish",Toast.LENGTH_LONG).show();
//                addShowView();
//                face2.setVisibility(View.INVISIBLE);
//                Log.d(TAG, "onFinish: onfinish");
//                Toast.makeText(MainActivity.this, "onFinish", Toast.LENGTH_LONG).show();
//                AnimationSet set = new AnimationSet(true);
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1.00f);
//                alphaAnimation.setDuration(5000);
//                set.addAnimation(alphaAnimation);
//                set.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        face2.setVisibility(View.VISIBLE);
//                        mImageVeiw.scrollTo(500+left,0);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//                face2.startAnimation(set);

            }
        };

        timer.start();

    }

    private void  addShowView(){
        UIChild child=new UIChild(MainActivity.this);
        mGroupView.startShow(child);
//        mGroupView.startShow(child);
//        mGroupView.startShow(child);
//        mGroupView.startShow(child);
//        mGroupView.startShow(child);
//        mGroupView.startShow(child);

    }


    @Subscribe
    public void onEvent(WSReconizeFaceE faceE) {
        Log.e(TAG, "onEvent: onFaceReconize");
        if (faceE.getmReconizaFace() != null) {
//            mImageVeiw.setImageBitmap(faceE.getmReconizaFace());
        } else {
            Log.e(TAG, "onEvent: face==null");
        }
    }
}
