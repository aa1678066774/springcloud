package com.tww;

import com.tww.model.User;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-11 17:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationHelloWordTests {

    @Autowired
    KieSession kieSession;

    @Test
    public void testHelloWord() {
        kieSession.fireAllRules();
    }

    @Test
    public void testUser() {
        User user=new User("张三",18);
        kieSession.insert(user);
        kieSession.fireAllRules();
        System.err.println("规则执行完毕后张三变为了："+user.getName());
    }

    @Test
    public void testOneRule() {
        User user=new User("张三",18);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("user"));
    }
}
