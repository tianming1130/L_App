package cn.zknu.l_app.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import cn.zknu.l_app.R;

/**
 * Created by Administrator on 2018\5\29 0029.
 */

public class MessageAdapter extends BaseMultiItemQuickAdapter<MessageAdapter.MultipleItem,BaseViewHolder> {
    public static final int LEFT_MESSAGE=1;
    public static final int RIGHT_MESSAGE=2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MessageAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(LEFT_MESSAGE, R.layout.left_message);
        addItemType(RIGHT_MESSAGE, R.layout.right_message);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {

        switch (helper.getItemViewType()) {
            case LEFT_MESSAGE:
                helper.setText(R.id.tv_message_left, item.getContent());
                break;
            case RIGHT_MESSAGE:
                helper.setText(R.id.tv_message_right, item.getContent());
                break;
        }
    }

    public static class MultipleItem implements MultiItemEntity{
        private int itemType;
        private String content;
        public MultipleItem(int itemType,String content) {
            this.itemType = itemType;
            this.content=content;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
        public String getContent(){
            return content;
        }
    }
}
