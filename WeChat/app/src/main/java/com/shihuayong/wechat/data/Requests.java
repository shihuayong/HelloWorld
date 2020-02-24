package com.shihuayong.wechat.data;

import com.shihuayong.wechat.models.Tweet;

import java.util.List;

public class Requests {

    public static List<Tweet> tweets() {
        return new TweetRequest().get();
    }

}
