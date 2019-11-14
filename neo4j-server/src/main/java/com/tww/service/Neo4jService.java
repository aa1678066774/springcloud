package com.tww.service;

import com.tww.model.UserNode;
import com.tww.repository.UserRelationRepository;
import com.tww.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-13 11:07
 */
@Service
public class Neo4jService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRelationRepository userRelationRepository;

    /**
     * Always use constructor based dependency injection in your beans.
     * Always use assertions for mandatory dependencies.
     */

    public int addUser(UserNode userNode){
        userRepository.addUserNodeList(userNode.getName(),userNode.getAge());
        return 1;
    }
    public int addUserRelation( String firstUserName,String secondUserName ){
        userRelationRepository.addUserRelation(firstUserName,secondUserName);
        return 1;
    }
}
