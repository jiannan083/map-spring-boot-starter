package cn.bfay.okhttp;

import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * OkHttpWapper.
 *
 * @author wangjiannan
 */
public class OkHttpWapper {
    private Request request;
    private TypeReference typeReference;
    private Object response;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public TypeReference getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(TypeReference typeReference) {
        this.typeReference = typeReference;
    }

    //public Object getResponse() {
    //    return response;
    //}
    public <T> T getResponse() {
        return (T) response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public OkHttpWapper registResponseBean(TypeReference typeReference) {
        this.typeReference = typeReference;
        return this;
    }

    /**
     * 注册返回对象类型.
     *
     * @param clazz 类型
     * @param <T>   类型泛型
     * @return {@link OkHttpWapper}
     */
    public <T> OkHttpWapper registResponseBean(Class<T> clazz) {
        this.typeReference = new TypeReference<T>() {
            @Override
            public Type getType() {
                return clazz;
            }
        };
        return this;
    }

    public OkHttpWapper createGetRequest(String url) {
        this.request = buildGetRequest(url);
        return this;
    }

    public OkHttpWapper createGetRequest(String url, Map<String, String> paramMap) {
        this.request = buildGetRequest(url, paramMap);
        return this;
    }

    public OkHttpWapper createGetRequest(String url, Map<String, String> paramMap,
                                         Map<String, String> headers) {
        this.request = buildGetRequest(url, paramMap, headers);
        return this;
    }


    public OkHttpWapper createJsonPostRequest(String url, String requestBody) {
        this.request = buildJsonRequestBodyPost(url, requestBody, null);
        return this;
    }


    public OkHttpWapper createJsonPostRequest(String url, String requestBody, Map<String, String> headers) {
        this.request = buildJsonRequestBodyPost(url, requestBody, headers);
        return this;
    }


    public OkHttpWapper createFormPostRequest(String url, Map<String, String> fromMap) {
        this.request = buildFormPost(url, fromMap, null);
        return this;
    }

    public OkHttpWapper createFormPostRequest(String url, Map<String, String> fromMap,
                                              Map<String, String> headers) {
        this.request = buildFormPost(url, fromMap, headers);
        return this;
    }


    private static Request buildGetRequest(String url) {
        Request.Builder getBuilder = baseBuild(url, null, null);
        return getBuilder.get().build();
    }

    private static Request buildGetRequest(String url, Map<String, String> paramMap) {
        Request.Builder getBuilder = baseBuild(url, paramMap, null);
        return getBuilder.get().build();
    }

    private static Request buildGetRequest(String url, Map<String, String> paramMap, Map<String, String> headers) {
        Request.Builder getBuilder = baseBuild(url, paramMap, headers);
        return getBuilder.get().build();
    }

    private static Request.Builder baseBuild(String url, Map<String, String> paramMap, Map<String, String> headers) {
        Request.Builder getBuilder = new Request.Builder();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        if (paramMap != null && !paramMap.isEmpty()) {
            paramMap.forEach((key, value) -> urlBuilder.addQueryParameter(key, value));
        }
        getBuilder.url(urlBuilder.build());
        if (headers != null) {
            getBuilder.headers(Headers.of(headers));
        }
        return getBuilder;
    }

    private static Request buildRequestBodyPost(String url,
                                                MediaType mediaType, String requestBody,
                                                Map<String, String> headers) {
        Request.Builder baseBuild = baseBuild(url, null, headers);
        if (requestBody != null) {
            RequestBody body = RequestBody.create(mediaType, requestBody);
            baseBuild.post(body);
        }
        return baseBuild.build();
    }

    private static Request buildJsonRequestBodyPost(String url,
                                                    String requestBody, Map<String, String> headers) {
        return buildRequestBodyPost(url, JSON, requestBody, headers);
    }


    private static Request buildFormPost(String url, Map<String, String> formMap, Map<String, String> headers) {
        FormBody.Builder params = new FormBody.Builder();
        if (formMap != null) {
            formMap.forEach((key, value) -> params.add(key, value));
        }

        Request.Builder baseBuild = baseBuild(url, null, headers);
        return baseBuild.post(params.build()).build();
    }
}
