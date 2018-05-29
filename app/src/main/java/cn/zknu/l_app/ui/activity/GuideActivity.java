package cn.zknu.l_app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zknu.l_app.MainActivity;
import cn.zknu.l_app.R;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<View> mViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        init();
    }
    private void init(){
        mApplication.mSharedPreferences.edit().putBoolean("isFirstTime", false)
                .commit();

        mViews=new ArrayList<>();
        ImageView imageView1 = new ImageView(this);  //创建imageview
        imageView1.setImageResource(R.drawable.guid1);  //设置imageview呈现的图片
        mViews.add(imageView1);
        ImageView imageView2 = new ImageView(this);  //创建imageview
        imageView2.setImageResource(R.drawable.guid2);  //设置imageview呈现的图片
        mViews.add(imageView2);
        ImageView imageView3 = new ImageView(this);  //创建imageview
        imageView3.setImageResource(R.drawable.guid3);  //设置imageview呈现的图片
        mViews.add(imageView3);
        ImageView imageView4 = new ImageView(this);  //创建imageview
        imageView4.setImageResource(R.drawable.guid4);  //设置imageview呈现的图片
        mViews.add(imageView4);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
            }
        });

        mViewPager.setAdapter(new MyPagerAdapter());
    }
    private class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
