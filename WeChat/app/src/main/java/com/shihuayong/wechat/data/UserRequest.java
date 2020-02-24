package com.shihuayong.wechat.data;

import com.shihuayong.wechat.models.User;
import com.shihuayong.wechat.utils.GsonUtils;

import java.io.IOException;

import okhttp3.Response;

public class UserRequest extends BaseRequest<User> {

    public UserRequest() {
        super(URLConstant.GET_USER);
    }

    @Override
    protected User convert(Response response) throws IOException {
        return GsonUtils.toClass(response.body().string(), User.class);
    }
}
