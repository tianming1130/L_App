package cn.zknu.l_app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cn.zknu.l_app.MainActivity;

public class SplashActivity extends BaseActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isFirstTime = mApplication.mSharedPreferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            // 如果是第一次进入应用，停留1.5秒进入引导页面
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    SplashActivity.this.finish();
                }
            }, 1500);
        } else {
            // 否则，停留1.5秒进入主页面
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }
            }, 1500);
        }
    }
}
