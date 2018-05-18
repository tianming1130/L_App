package cn.zknu.l_app.net.function;


import cn.zknu.l_app.net.HttpResult;
import cn.zknu.l_app.net.exception.ServerException;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class HttpResultFunction<T> implements Function<HttpResult<T>, T> {
    @Override
    public T apply(HttpResult<T> tHttpResult) throws Exception {
        if (tHttpResult.getCode() != 0) {
            throw new ServerException(tHttpResult.getCode(), tHttpResult.getMessage());
        } else {
            return tHttpResult.getData();
        }
    }
}
