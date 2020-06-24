package cn.bfay.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

/**
 * OkHttpLogInterceptor.
 *
 * @author wangjiannan
 */
public class OkHttpLogInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(OkHttpLogInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = new Date().getTime();
        Response response = chain.proceed(chain.request());
        long endTime = new Date().getTime();
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        // url|startTime|endTime|usedTime|method|response|
        log.info("{}|{}|{}|{}|{}|{}|", request.url(), startTime, endTime, endTime - startTime, request.method(), content);
        return response.newBuilder()
                .body((okhttp3.ResponseBody.create(mediaType, content)))
                .build();
    }
}
