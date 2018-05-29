package cn.zknu.l_app.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.baidu.mapapi.SDKInitializer;

import cn.zknu.l_app.util.Const;

/**
 * Created by Administrator on 2018\5\26 0026.
 */

public class App extends Application {
    public SharedPreferences mSharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = getSharedPreferences(
                Const.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SDKInitializer.initialize(this);
    }
}
