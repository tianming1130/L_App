package cn.zknu.l_app.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.zknu.l_app.R;
import cn.zknu.l_app.ui.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener{
    private View mView;
    private TextView name;
    public MeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        init();
        return mView;
    }

    private void initView() {
        name=(TextView)mView.findViewById(R.id.name);
    }
    private void init(){
        name.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }
}
