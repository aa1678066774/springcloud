import com.tww.RocketMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-31 11:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMqApplication.class)
public class MqTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello","12345");
    }
}
