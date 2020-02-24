package com.shihuayong.wechat.data;

public interface URLConstant {
    String BASE = "http://thoughtworks-ios.herokuapp.com/";

    /**
     * 用户
     */
    String GET_USER = BASE + "user/jsmith";

    /**
     * 推文
     */
    String GET_TWEET = BASE + "user/jsmith/tweets";
}
