package zxyilian.myvideoview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final VideoView
                videoView = (VideoView) findViewById(R.id.video);
//        Uri uri = Uri.parse("http://192.168.1.132:9090//ueditor/jsp/upload/video/20160517/1463456371416066131.mp4");
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/q171.mp4");
//File file=new File();
//File file=new File( Environment.getExternalStorageDirectory()+"q17.mp4");

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Log.d("asd", "onPrepare");
            }
        });


        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.requestFocus();

        final Button button = (Button) findViewById(R.id.button);
        CountDownTimer timer=new CountDownTimer(95000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                int position = videoView.getCurrentPosition();
                button.setText(position/1000 + ","+(float)(position+500)*100/(float)videoView.getDuration()+
                ",position="+position+",Duration="+videoView.getDuration());
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });
    }




}
