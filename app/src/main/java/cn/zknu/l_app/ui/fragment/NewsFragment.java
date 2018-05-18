package cn.zknu.l_app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.util.Const;
import cn.zknu.l_app.adapter.NewsAdapter;
import cn.zknu.l_app.bean.News;
import cn.zknu.l_app.loader.BannerImageLoader;
import cn.zknu.l_app.net.HttpUtil;
import cn.zknu.l_app.net.exception.ServerException;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private static final String TAG="NewsFragment";
    private RecyclerView mRecyclerView;
    private List<News> mNews;
    private NewsAdapter mAdapter;
    private View mView;
    private Banner mBanner;
    private List<String> mBannerImages;
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        init();
        return mView;

    }

    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
        mBanner=(Banner)mView.findViewById(R.id.banner);
    }
    private void init(){
        mBannerImages=new ArrayList<>();
        for (int i=0;i< Const.BANNER_IMAGE_URL.length;i++){
            mBannerImages.add(Const.BANNER_IMAGE_URL[i]);
        }
        mBanner.setImages(mBannerImages)
                .setImageLoader(new BannerImageLoader())
                .start();
        mNews=new ArrayList<>();
        mAdapter=new NewsAdapter(R.layout.item_view_news,mNews);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        HttpUtil.getInstance().getNews(new Subscriber<List<News>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(List<News> newses) {
                for (News news:newses){
                    Log.i(TAG,news.toString());
                }
                mAdapter.addData(newses);
            }

            @Override
            public void onError(Throwable t) {
                if(t instanceof ServerException){
                    Toast.makeText(NewsFragment.this.getContext(),((ServerException)t).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
