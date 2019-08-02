package com.tww.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-02 15:54
 */
@FeignClient(name = "sso-server", path = "/")
public interface SsoFeign {
    /**
     * 判断key是否存在
     */
    @RequestMapping("redis/hasKey/{key}")
    public Boolean hasKey(@PathVariable("key") String key);

}
