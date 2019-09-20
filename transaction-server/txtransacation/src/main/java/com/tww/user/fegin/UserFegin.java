package com.tww.user.fegin;

import com.tww.base.ApiResult;
import com.tww.user.entity.User;
import com.tww.user.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "transaction1",fallback = UserHystrix.class)
public interface UserFegin {

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ApiResult<String> index(@RequestBody User apiParam);
}