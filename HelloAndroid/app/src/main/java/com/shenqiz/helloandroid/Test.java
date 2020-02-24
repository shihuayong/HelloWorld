package com.shenqiz.helloandroid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Handler handler = new Handler();

        Looper.myLooper()

        new Parcelable() {
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {

            }
        };
    }
}
