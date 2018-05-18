package cn.zknu.l_app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.adapter.VideoAdapter;
import cn.zknu.l_app.bean.Video;
import cn.zknu.l_app.db.DBUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private View mView;
    private List<Video> mVideos;
    private VideoAdapter mVideoAdapter;
    public FindFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_find, container, false);
        initView();
        init();
        return mView;
    }
    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){
        mVideos= DBUtil.getInstance(getContext()).query();
        mVideoAdapter=new VideoAdapter(R.layout.item_view_video,mVideos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mVideoAdapter);
    }
}
