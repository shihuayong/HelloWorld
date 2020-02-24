package com.shihuayong.wechat.data;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class BaseRequest<T> {
    private final String url;
    private final RequestMethod method;
    protected OkHttpClient client;
    protected Call call;

    public BaseRequest(String url) {
        this(url, RequestMethod.GET);
    }

    public BaseRequest(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
    }

    /**
     * 同步请求数据
     *
     * @return T model
     */
    public T get() {
        onCreateClient();
        onCreateCall();

        try {
            Response response = call.execute();
            if (response != null && response.isSuccessful()) {
                return convert(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onCreateClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
    }

    /**
     * 创建客户端
     */
    protected void onCreateCall() {
        if (call == null) {
            Request.Builder builder = new Request.Builder().url(this.url);

            switch (method) {
                case GET:
                default:
                    builder.get();
            }

            this.call = client.newCall(builder.build());
        }
    }

    /**
     * 从Response中提取数据，转换为模型
     *
     * @param response HTTP response
     * @return T model
     */
    protected abstract T convert(Response response) throws IOException;

    public enum RequestMethod {
        GET,
        POST
    }
}
