package cn.zknu.l_app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.zknu.l_app.R;
import cn.zknu.l_app.bean.Video;
import cn.zknu.l_app.db.DBUtil;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;
    private BootstrapButton mFavoriteButton;
    private Video mVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("video_url");
        String videoName = intent.getStringExtra("video_name");
        String videoThumbUrl=intent.getStringExtra("video_thumb_url");
        int videoId=intent.getIntExtra("video_id",-1);

        mVideo=new Video(videoId,videoName,videoUrl,videoThumbUrl);

        mJZVideoPlayerStandard.setUp(videoUrl
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, videoName);

        mFavoriteButton.setOnClickListener(this);
    }

    private void initView() {
        mJZVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.player_video);
        mFavoriteButton = (BootstrapButton) findViewById(R.id.btn_favorite);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_favorite:
                favorite();
                break;
        }
    }

    private void favorite() {
        DBUtil.getInstance(this).insert(mVideo);
    }
}
