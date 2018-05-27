package cn.zknu.l_app.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.zknu.l_app.R;
import cn.zknu.l_app.bean.Video;
import cn.zknu.l_app.db.DBUtil;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;
    private Video mVideo;
    private ImageView mFavoriteImageView;
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEventBusReceiver(Video video){
        mVideo=video;
        mJZVideoPlayerStandard.setUp(mVideo.getUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, mVideo.getName());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initView();
        init();
    }

    private void init() {
        EventBus.getDefault().register(this);
        mFavoriteImageView.setOnClickListener(this);
    }

    private void initView() {
        mJZVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.player_video);
        mFavoriteImageView=(ImageView)findViewById(R.id.iv_favorite);
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_favorite:
                DBUtil.getInstance(this).insert(mVideo);
                mFavoriteImageView.setImageResource(R.drawable.ico_favorite_selected);
                break;
        }
    }

}
