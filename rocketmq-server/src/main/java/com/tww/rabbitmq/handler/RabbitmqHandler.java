package com.tww.rabbitmq.handler;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-31 11:36
 */
@Component
public class RabbitmqHandler {

    /**
     * 一对一
     * exclusive 如果{@code true}，则容器中的单个使用者将独占使用
     * * {@link #queues（）}，以防止其他使用者接收来自
     * *队列。 当{@code true}时，要求并发1。默认{@code false}。
     * * @返回{@code Exclusive}布尔值标志。
     * priority  该端点的优先级。 需要RabbitMQ 3.2或更高版本。 不变
     * *默认情况下，容器优先级。 数字越大表示优先级越高，并且
     * *可以使用正数和负数。
     * @param message
     */
    @RabbitListener(queues = "hello",containerFactory = "pointTaskContainerFactory")
    public void receive(String message) {
        System.out.println("["+Thread.currentThread().getName()+"] 接收消息:" + message);
    }

    /**
     * 相同的交换机  不同的队列 订阅模式
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen(String msg) {
        System.out.println("订阅模式1 接收到消息：" + msg);
    }

    // 队列2（第二个人），同样能接收到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout.queue1", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen1(String msg) {
        System.out.println("订阅模式2 接收到消息：" + msg);
    }


    /**
     * 相同的交换机  不同的队列 路由模式
     * @param msg
     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "spring.direct.queue", durable = "true"),
//            exchange = @Exchange(
//                    value = "spring.direct.exchange",
//                    ignoreDeclarationExceptions = "true"
//            ),key = {"A"}
//    ))
//    public void listen2(String msg) {
//        System.out.println("订阅模式1 接收到消息：" + msg);
//    }
//
//    // 队列2（第二个人），同样能接收到消息
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "spring.direct.queue1", durable = "true"),
//            exchange = @Exchange(
//                    value = "spring.direct.exchange",
//                    ignoreDeclarationExceptions = "true"
//            ),key = {"B"}
//    ))
//    public void listen3(String msg) {
//        System.out.println("订阅模式2 接收到消息：" + msg);
//    }
}
