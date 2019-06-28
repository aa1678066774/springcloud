package com.tww.feginInterface;

import com.tww.fegin.HelloFeginService;
import com.tww.hystrix.TestHystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Create by tangweiwei on 2019/5/5.
 */
@FeignClient(name= "spring-cloud-service1",fallback = TestHystrix.class)
public interface TestRemote extends HelloFeginService {

}
