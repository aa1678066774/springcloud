package com.tww.dao;

import com.tww.model.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-30 16:23
 */
public interface UserReposiory extends ElasticsearchCrudRepository<UserEntity, String> {
}
