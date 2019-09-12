package com.tww.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-08-15 15:59
 */
@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("a18038155494@163.com");
        mailMessage.setTo("weiweitang@shangshibang.com");

        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        javaMailSender.send(mailMessage);
    }


    public void sendHtmlMail(String subject, String text, Map<String, String> attachmentMap) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //是否发送的邮件是富文本（附件，图片，html等）
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true,"utf-8");

        messageHelper.setFrom("it-notice@shangshibang.com");
        String[] strs=new String[1];
        strs[0]="weiweitang@shangshibang.com";
//        strs[1]="kongchenwei@shangshibang.com";
//        strs[2]="frankfan@shangshibang.com";
        messageHelper.setTo(strs);

        messageHelper.setSubject(subject);
        messageHelper.setText(text, true);//重点，默认为false，显示原始html代码，无效果

        if(attachmentMap != null){
            attachmentMap.entrySet().stream().forEach(entrySet -> {
                try {
                    messageHelper.addAttachment(MimeUtility.encodeWord(entrySet.getKey(),"utf-8","B"), new ByteArrayResource(IOUtils.toByteArray(getInputStream(entrySet.getValue()))));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        javaMailSender.send(mimeMessage);
    }
    public static InputStream getInputStream(String destUrl) {
        InputStream inputStream = null;
        URLConnection urlConnection = null;
        URL url = null;
        try {
            destUrl=destUrl.replaceAll("%20", " ");
            destUrl= UriUtils.encodePath(destUrl,  "UTF-8");
            url = new URL(destUrl);
            urlConnection = url.openConnection();
            inputStream = urlConnection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
