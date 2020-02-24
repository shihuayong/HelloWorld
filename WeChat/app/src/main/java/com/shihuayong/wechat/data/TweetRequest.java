package com.shihuayong.wechat.data;

import com.shihuayong.wechat.models.Tweet;
import com.shihuayong.wechat.utils.GsonUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;

public class TweetRequest extends BaseRequest<List<Tweet>> {

    public TweetRequest() {
        super(URLConstant.GET_TWEET);
    }

    @Override
    protected List<Tweet> convert(Response response) throws IOException {
        return GsonUtils.toList(response.body().string(), Tweet.class);
    }
}
