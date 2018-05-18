package cn.zknu.l_app.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.bean.News;

/**
 * Created by Administrator on 2018\4\20 0020.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder> {
    public NewsAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.news_title,item.getTitle());
        helper.setText(R.id.news_content,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.news_thumb));
    }
}
