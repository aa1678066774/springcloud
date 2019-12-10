package com.tww;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-06 15:46
 */
public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> list=page.getHtml().xpath("//img[@class='BDE_Image']/@src").all();
        list.stream().forEach(item->{
            downloadPicture(item, UUID.randomUUID().toString().replace("-","")+".jpg");
        });
    }

    private static void downloadPicture(String urlList,String imageName) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String path =  "C:\\Users\\Administrator\\Desktop\\tupian\\";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path+imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        List<String> urls= new ArrayList<>(625845);
        for(long i =5979374155L;i<=5980000000L;i++){
            urls.add("https://tieba.baidu.com/p/"+i);
        }

        Spider spider=Spider.create(new GithubRepoPageProcessor());
        spider.addUrl(urls.toArray(new String[urls.size()]))
                .addPipeline(new ConsolePipeline()).thread(10).run();

    }
}
