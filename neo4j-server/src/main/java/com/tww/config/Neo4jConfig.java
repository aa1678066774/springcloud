package com.tww.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-13 11:00
 */
@Configuration
@EnableNeo4jRepositories("com.tww.repository")
@EntityScan(basePackages = "com.tww.model")
public class Neo4jConfig {
}
