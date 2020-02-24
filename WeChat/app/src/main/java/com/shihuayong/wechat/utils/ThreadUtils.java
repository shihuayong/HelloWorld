package com.shihuayong.wechat.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadUtils {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void run(Runnable action) {
        EXECUTOR.submit(action);
    }

    public static void postOnMainThread(Runnable action) {
        HANDLER.post(action);
    }

}
