package cn.zknu.l_app.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.adapter.VideoAdapter;
import cn.zknu.l_app.bean.Video;
import cn.zknu.l_app.net.HttpUtil;
import cn.zknu.l_app.ui.activity.VideoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements OnItemClickListener {
    private static final String TAG="VideoFragment";
    private RecyclerView mRecyclerView;
    private VideoAdapter mAdapter;
    private View mView;
    private List<Video> mVideos;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_video, container, false);

        initView();
        init();
        return mView;
    }

    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){

        mVideos=new ArrayList<>();
        mAdapter=new VideoAdapter(R.layout.item_view_video,mVideos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        HttpUtil.getInstance().getVideo(new Subscriber<List<Video>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(List<Video> videos) {
                mAdapter.addData(videos);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Video video=(Video) adapter.getItem(position);
        EventBus.getDefault().postSticky(video);
        Intent intent=new Intent(getActivity(), VideoActivity.class);
//        intent.putExtra("video_id",video.getId());
//        intent.putExtra("video_name",video.getName());
//        intent.putExtra("video_url",video.getUrl());
//        intent.putExtra("video_thumb_url",video.getVideoThumbUrl());
        startActivity(intent);

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
