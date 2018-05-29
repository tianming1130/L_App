package cn.zknu.l_app.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.zknu.l_app.app.App;

public class BaseActivity extends AppCompatActivity {

    protected App mApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication=(App)getApplication();
    }
}
