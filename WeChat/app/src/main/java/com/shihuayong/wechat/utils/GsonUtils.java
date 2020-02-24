package com.shihuayong.wechat.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * GSON工具类
 */
public final class GsonUtils {
    private static final Gson INSTANCE = new Gson();

    public static <T> T toClass(String json, Class<T> clazz) {
        return INSTANCE.fromJson(json, clazz);
    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        return INSTANCE.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }
}
