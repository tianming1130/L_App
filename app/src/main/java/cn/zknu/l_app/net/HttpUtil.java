package cn.zknu.l_app.net;

import org.reactivestreams.Subscriber;

import java.util.List;

import cn.zknu.l_app.bean.News;
import cn.zknu.l_app.bean.Video;
import cn.zknu.l_app.net.function.HttpResultFunction;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018\4\20 0020.
 */

public class HttpUtil {
    private static final String TAG = "HttpUtil";

    private ApiService mApiService;
    private static  HttpUtil mHttpUtil=null;
    private HttpUtil(){
        mApiService=RetrofitManager.getInstance().getService(ApiService.class);
    }
    public static HttpUtil getInstance(){
        if (mHttpUtil==null){
            synchronized (HttpUtil.class){
                mHttpUtil=new HttpUtil();
            }
        }
        return mHttpUtil;
    }

    public void getNews(Subscriber<List<News>> subscriber){
        Flowable<HttpResult<List<News>>> flowable=mApiService.getNews();
        //call.enqueue(callback);
        flowable.map(new HttpResultFunction<List<News>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
    public void getVideo(Subscriber<List<Video>> subscriber){
        Flowable<HttpResult<List<Video>>> flowable=mApiService.getVideo();
        //call.enqueue(callback);
        flowable.map(new HttpResultFunction<List<Video>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
}
