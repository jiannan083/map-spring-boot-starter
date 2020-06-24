package cn.bfay.okhttp;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClientBuilder;使用OkHttpClient okHttpClient = OkHttpClientBuilder.getInstance().getOkHttpClient();.
 *
 * @author wangjiannan
 */
public class OkHttpClientBuilder {
    private static final long CONNECT_TIMEOUT_MILLIS = 5 * 1000;
    private static final long READ_TIMEOUT_MILLIS = 10 * 1000;
    private static final long WRITE_TIMEOUT_MILLIS = 10 * 1000;
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;
    private static volatile OkHttpClientBuilder sInstance;
    private OkHttpClient mOkHttpClient;

    private OkHttpClientBuilder() {
        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);//日志级别，Body级别打印的信息最全面

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS) //链接超时
                .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS) //读取超时
                .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS) //写入超时
                //.addInterceptor(new HttpHeadInterceptor()) //应用拦截器：统一添加消息头
                .addInterceptor(new OkHttpLogInterceptor())//应用拦截器：打印日志
                //.addNetworkInterceptor(new NetworkspaceInterceptor())//网络拦截器
                //.cache(cache)  //设置缓存
                .build();
    }

    public static OkHttpClientBuilder getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpClientBuilder.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpClientBuilder();
                }
            }
        }
        return sInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
