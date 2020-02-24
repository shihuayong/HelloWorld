package com.shihuayong.wechat.models;

import com.google.gson.annotations.SerializedName;

/**
 * 用户信息
 */
public class User {
    /**
     * 用户名称
     */
    private String username;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 头像URL
     */
    private String avatar;

    @SerializedName("profile-iamge")
    private String profileImage;
}
