package com.tww.repository;

import com.tww.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-25 15:27
 */
public interface UserRepository extends ReactiveCrudRepository<User, String> {  // 1
    Mono<User> findByUsername(String username);     // 2
    Mono<Long> deleteByUsername(String username);
}
