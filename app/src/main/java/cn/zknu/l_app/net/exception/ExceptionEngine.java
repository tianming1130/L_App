package cn.zknu.l_app.net.exception;

import android.content.Context;
import android.net.ParseException;
import android.widget.Toast;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Created by Administrator on 2018\5\21 0021.
 */

public class ExceptionEngine {
    public static void handleException(Context context, Throwable t) {
        if (t instanceof ServerException) {    //服务器返回的错误
            switch (((ServerException) t).getCode()) {
                case 1:
                    showExceptionMsg(context, "非法请求！");
                    break;
            }
        } else if (t instanceof JsonParseException //均视为解析错误
                || t instanceof JSONException
                || t instanceof ParseException) {
            showExceptionMsg(context, "数据解析失败");
        } else if (t instanceof ConnectException ||t instanceof SocketTimeoutException) { //均视为网络错误
            showExceptionMsg(context, "连接失败");
        } else {  //未知错误
            showExceptionMsg(context, "未知错误");
        }
    }

    private static void showExceptionMsg(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
