package cn.bfay.okhttp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TimeZone;

/**
 * OkHttpUtils.
 *
 * @author wangjiannan
 */
public class OkHttpUtils {
    private static final Logger log = LoggerFactory.getLogger(OkHttpUtils.class);

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new JavaTimeModule())
                .setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //.registerModule(new ParameterNamesModule())
        //.registerModule(new Jdk8Module())
    }

    public static void execute(OkHttpWapper... okHttpWappers) {
        parallelExecute(okHttpWappers);
    }

    /**
     * 执行get方法.
     *
     * @param url      地址
     * @param paramMap 参数map
     * @param headers  头部
     * @param tclass   返回泛型类
     * @param <T>      泛型
     * @return 泛型
     */
    public static <T> T executeGet(String url, Map<String, String> paramMap, Map<String, String> headers,
                                   TypeReference<T> tclass) {
        OkHttpWapper okHttpWapper = new OkHttpWapper().registResponseBean(tclass)
                .createGetRequest(url, paramMap, headers);
        parallelExecute(okHttpWapper);
        return okHttpWapper.getResponse();
    }

    public static <T> T executeGet(String url, Map<String, String> paramMap, TypeReference<T> tclass) {
        return executeGet(url, paramMap, null, tclass);
    }

    public static <T> T executeGet(String url, TypeReference<T> tclass) {
        return executeGet(url, null, tclass);
    }

    public static <T> T executeGet(String url, Map<String, String> paramMap,
                                   Map<String, String> headers, Class<T> tclass) {
        return executeGet(url, paramMap, headers, convert2TypeReference(tclass));
    }

    public static <T> T executeGet(String url, Map<String, String> paramMap, Class<T> tclass) {
        return executeGet(url, paramMap, null, tclass);
    }

    public static <T> T executeGet(String url, Class<T> tclass) {
        return executeGet(url, null, tclass);
    }

    /**
     * 执行post form.
     *
     * @param url     地址
     * @param formMap formMap
     * @param headers 头部
     * @param tclass  泛型类
     * @param <T>     泛型
     * @return 泛型
     */
    public static <T> T executePost(String url, Map<String, String> formMap,
                                    Map<String, String> headers, TypeReference<T> tclass) {
        OkHttpWapper okHttpWapper = new OkHttpWapper()
                .registResponseBean(tclass).createFormPostRequest(url, formMap, headers);
        parallelExecute(okHttpWapper);
        return okHttpWapper.getResponse();
    }

    public static <T> T executePost(String url, Map<String, String> formMap, TypeReference<T> tclass) {
        return executePost(url, formMap, null, tclass);
    }

    public static <T> T executePost(String url, Map<String, String> formMap,
                                    Map<String, String> headers, Class<T> tclass) {
        return executePost(url, formMap, headers, convert2TypeReference(tclass));
    }

    public static <T> T executePost(String url, Map<String, String> formMap, Class<T> tclass) {
        return executePost(url, formMap, null, tclass);
    }

    /**
     * 执行post requestbody.
     *
     * @param url         地址
     * @param requestBody 请求体
     * @param headers     头部
     * @param tclass      泛型类
     * @param <T>         泛型
     * @return 泛型
     */
    public static <T> T executePost(String url, String requestBody,
                                    Map<String, String> headers, TypeReference<T> tclass) {
        OkHttpWapper okHttpWapper = new OkHttpWapper()
                .registResponseBean(tclass).createJsonPostRequest(url, requestBody, headers);
        parallelExecute(okHttpWapper);
        return okHttpWapper.getResponse();
    }

    public static <T> T executePost(String url, String requestBody, TypeReference<T> tclass) {
        return executePost(url, requestBody, null, tclass);
    }

    public static <T> T executePost(String url, String requestBody, Map<String, String> headers, Class<T> tclass) {
        return executePost(url, requestBody, headers, convert2TypeReference(tclass));
    }

    public static <T> T executePost(String url, String requestBody, Class<T> tclass) {
        return executePost(url, requestBody, null, tclass);
    }

    private static <T> TypeReference<T> convert2TypeReference(Class<T> tclass) {
        return new TypeReference<T>() {
            @Override
            public Type getType() {
                return tclass;
            }
        };
    }

    //private static void parallelExecute(OkHttpWapper... okHttpWappers) {
    //    if (okHttpWappers == null || okHttpWappers.length == 0) {
    //        return;
    //    }
    //    CountDownLatch countDownLatch = new CountDownLatch(okHttpWappers.length);
    //
    //    OkHttpClient okHttpClient = OkHttpClientBuilder.getInstance().getOkHttpClient();
    //    for (OkHttpWapper okHttpWapper : okHttpWappers) {
    //        okHttpClient.newCall(okHttpWapper.getRequest()).enqueue(new Callback() {
    //            @Override
    //            public void onFailure(Call call, IOException e) {
    //                log.error("okhttp调用失败", e);
    //                countDownLatch.countDown();
    //            }
    //
    //            @Override
    //            public void onResponse(Call call, Response response) throws IOException {
    //                if (okHttpWapper.getTypeReference().getType() == String.class) {
    //                    okHttpWapper.setResponse(response.body().string());
    //                } else {
    //                    okHttpWapper.setResponse(mapper.readValue(response.body().string(), okHttpWapper.getTypeReference()));
    //                }
    //                countDownLatch.countDown();
    //            }
    //        });
    //    }
    //    try {
    //        countDownLatch.await();
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }
    //}

    private static void parallelExecute(OkHttpWapper... okHttpWappers) {
        if (okHttpWappers == null || okHttpWappers.length == 0) {
            return;
        }
        OkHttpClient okHttpClient = OkHttpClientBuilder.getInstance().getOkHttpClient();
        for (OkHttpWapper okHttpWapper : okHttpWappers) {
            try {
                Response response = okHttpClient.newCall(okHttpWapper.getRequest()).execute();
                if (okHttpWapper.getTypeReference().getType() == String.class) {
                    okHttpWapper.setResponse(response.body().string());
                } else {
                    okHttpWapper.setResponse(mapper.readValue(response.body().byteStream(), okHttpWapper.getTypeReference()));
                }
            } catch (IOException e) {
                log.error("okhttp调用失败", e);
            }
        }
    }
}
