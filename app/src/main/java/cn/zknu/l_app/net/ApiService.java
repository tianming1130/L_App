package cn.zknu.l_app.net;

import java.util.List;

import cn.zknu.l_app.bean.News;
import cn.zknu.l_app.bean.Video;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018\4\20 0020.
 */

public interface ApiService {
    @GET("getNews.php")
    Flowable<HttpResult<List<News>>> getNews();

    @GET("getVideo.php")
    Flowable<HttpResult<List<Video>>> getVideo();
}
