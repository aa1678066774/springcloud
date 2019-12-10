package com.tww;

import com.tww.mapper.UserMapper;
import com.tww.model.User;
import com.tww.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-04 14:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.getList();
        userList.forEach(System.out::println);

        List<String> list=userService.getUserName();
        list.forEach(System.out::println);
    }

}
