package com.shihuayong.wechat.models;

/**
 * 简单用户信息
 */
public class SimpleUser {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
