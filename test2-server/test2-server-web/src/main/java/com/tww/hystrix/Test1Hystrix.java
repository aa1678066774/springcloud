package com.tww.hystrix;

import com.tww.feginInterface.Test1Remote;
import com.tww.feginInterface.TestRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-09-03 15:09
 */
@Component
public class Test1Hystrix implements Test1Remote {
    @Override
    public String index(@RequestParam("name") String name) {
        return "hello" +name+", this messge send failed";
    }
}
