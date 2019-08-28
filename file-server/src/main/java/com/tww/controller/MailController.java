package com.tww.controller;

import com.tww.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: root
 * @description: 发送邮件
 * @author: weiweiTang
 * @create: 2019-08-15 15:57
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @Resource(name = "scheduledFutures")
    private Map<String,ScheduledFuture<?>> scheduledFutures;

    @RequestMapping("/sendmail")
    public String sendTo(){
        mailService.sendSimpleMail("222222","123456");
        return "发送成功";
    }

    @RequestMapping("/sendmailwithfile")
    public String sendMailWithFile() throws MessagingException {
        Map<String, String> attachmentMap = new HashMap<>();
        attachmentMap.put("附件.txt", "http://127.0.0.1:4051/file/a.txt");
        mailService.sendHtmlMail("测试发送附件","这是解析失败的银行流水",attachmentMap);
        return "发送成功";
    }


    /**
     * 核心是利用ScheduledFeature的cancel()函数。
     *
     * @return
     */
    @RequestMapping("/stoptask")
    public String stopTask(String taskName){
        if(taskName != null){
            /**
             * ScheduledFeature继承了jdk的接口Future, cancel用到参数true表示强制关闭任务。
             * cancel的参数false，表示允许任务执行完毕。
             * 因为这里是周期任务，没有执行完毕的时候，所以用的是强制关闭任务。
             */
            ScheduledFuture<?> scheduledFuture=scheduledFutures.get(taskName);
            scheduledFuture.cancel(true);
        }
        System.out.println("stop task done");
        return "stop task done";
    }

}
