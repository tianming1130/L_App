package cn.zknu.l_app.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.zknu.l_app.R;
import cn.zknu.l_app.bean.Video;

/**
 * Created by Administrator on 2018\4\21 0021.
 */

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder> {
    private static final String TAG="VideoAdapter";
    public VideoAdapter(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
        //helper.setImageBitmap(R.id.video_thumb,getVideoThumb(item.getUrl()));
        helper.setText(R.id.tv_video_name,item.getName());
        Glide.with(mContext).load(item.getVideoThumbUrl()).into((ImageView) helper.getView(R.id.video_thumb));
    }

//    private Bitmap getVideoThumb(String url){
//        FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
//        mmr.setDataSource(url);
//        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
//        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);
//        Bitmap b = mmr.getFrameAtTime();
//        mmr.release();
//        return  b;
//    }
}
