package com.tww.rocketmq.controller;

import com.tww.model.UserNode;
import com.tww.service.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-13 11:09
 */
@Controller
@RequestMapping("/neo4j")
public class Neo4jController {

    @Autowired
    Neo4jService neo4jService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody UserNode node){
        neo4jService.addUser(node);
        return "新增成功";
    }

    @RequestMapping(value = "/addrelation", method = RequestMethod.POST)
    @ResponseBody
    public String addrelation(@RequestParam("firstUserName") String firstUserName,@RequestParam("secondUserName") String secondUserName ){
        neo4jService.addUserRelation(firstUserName,secondUserName);
        return "新增成功";
    }
}
