package cn.zknu.l_app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.adapter.MessageAdapter;

import static cn.zknu.l_app.adapter.MessageAdapter.LEFT_MESSAGE;
import static cn.zknu.l_app.adapter.MessageAdapter.RIGHT_MESSAGE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mView;
    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_message, container, false);
        initView();
        init();
        return mView;
    }
    private void initView(){
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){

        MessageAdapter.MultipleItem multipleItem1=new MessageAdapter.MultipleItem(LEFT_MESSAGE,"周口师范学院");
        MessageAdapter.MultipleItem multipleItem2=new MessageAdapter.MultipleItem(RIGHT_MESSAGE,"计算机科学与技术学院");


        List<MessageAdapter.MultipleItem> multipleItems=new ArrayList<>();
        multipleItems.add(multipleItem1);
        multipleItems.add(multipleItem2);
        MessageAdapter messageAdapter=new MessageAdapter(multipleItems);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(messageAdapter);
    }
}
