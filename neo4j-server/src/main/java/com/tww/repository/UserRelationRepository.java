package com.tww.repository;

import com.tww.model.UserRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRelationRepository extends Neo4jRepository<UserRelation,Integer> {

    @Query("match p=(n:User)<-[r:UserRelation]->(n1:User) where n.userId={firstUserId} and n1.userId={secondUserId} return p")
    List<UserRelation> findUserRelationByEachId(@Param("firstUserId") String firstUserId, @Param("secondUserId") String secondUserId);

    @Query("match (fu:User),(su:User) where fu.name={firstUserName} and su.name={secondUserName} create p=(fu)-[r:朋友]->(su) return p")
    List<UserRelation> addUserRelation(@Param("firstUserName") String firstUserName, @Param("secondUserName") String secondUserName);

}
