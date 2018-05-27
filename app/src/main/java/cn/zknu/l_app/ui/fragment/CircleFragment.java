package cn.zknu.l_app.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private View mView;
    private String[] mTitle={"新闻","视频","图片"};
    public CircleFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mFragments=new ArrayList<>();
        mFragments.add(new NewsFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new ImageFragment());

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));

        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initView() {
        mViewPager=(ViewPager)mView.findViewById(R.id.view_pager);
        mTabLayout=(TabLayout)mView.findViewById(R.id.tab_layout);
    }
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    }
}
