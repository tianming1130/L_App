package cn.zknu.l_app.net;

import java.util.concurrent.TimeUnit;

import cn.zknu.l_app.util.Const;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class RetrofitManager {
    private static RetrofitManager mInstance=null;
    private Retrofit mRetrofit;
    private RetrofitManager(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
        mRetrofit=new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static RetrofitManager getInstance(){
        if (mInstance==null){
            synchronized (RetrofitManager.class){
                mInstance=new RetrofitManager();
            }
        }
        return mInstance;
    }
    public  <T> T getService(Class<T> tClass){
        return mRetrofit.create(tClass);
    }
}
