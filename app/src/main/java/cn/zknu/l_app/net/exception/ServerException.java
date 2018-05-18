package cn.zknu.l_app.net.exception;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class ServerException extends Exception {
    private int code;
    private String message;
    public ServerException(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
