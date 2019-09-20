package com.tww.user.hystrix;

import com.tww.base.ApiResult;
import com.tww.user.entity.User;
import com.tww.user.fegin.UserFegin;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-09-18 11:06
 */
public class UserHystrix implements UserFegin {
    @Override
    public ApiResult<String> index(@RequestBody User apiParam) {
        return null;
    }
}
