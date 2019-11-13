package com.tww.controller;

import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.tww.util.ImageBinary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @program: root
 * @description: 文件
 * @author: weiweiTang
 * @create: 2019-10-28 13:50
 */
@Controller
@RequestMapping("/file")
public class FileController {

    // 获得SpringBoot提供的mongodb的GridFS对象
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Resource
    private MongoDbFactory mongoDbFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static Log log = LogFactory.getLog(FileController.class);

    /**
     *
     * @param multiportFile
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam("file")MultipartFile multiportFile) throws Exception {
        //获取当前用户（shiro权限框架的方法）
        // 获得提交的文件名
        String fileName = multiportFile.getOriginalFilename();
        // 获得文件输入流
        InputStream ins = multiportFile.getInputStream();
        // 获得文件类型
        String contentType = multiportFile.getContentType();
        // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息
        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public void uploadImage(@RequestParam("file")MultipartFile multiportFile) throws Exception {
        //获取当前用户（shiro权限框架的方法）
        // 获得提交的文件名
        Data data =new Data();
        data.set_id(UUID.randomUUID().toString().replaceAll("-",""));
        data.setValue(ImageBinary.getImageBinary(multiportFile));
        String str="{\"_id\":\""+UUID.randomUUID().toString().replaceAll("-","")+"\",\"data\":\"123\"}";
        log.error(str);
        mongoTemplate.insert(str,"cell_info");
    }

    /**
     * 下载
     *
     * @param fileId   文件id
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(@RequestParam(name = "file_id") String fileId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
//        GridFSFile gfsFile = gridFsTemplate.findOne(query);
        Data data=mongoTemplate.findOne(query,Data.class,"cell_info");
//        GridFsResource gridFsResource=new GridFsResource(gfsFile.get(0), GridFSBuckets.create(mongoDbFactory.getDb()).openDownloadStream(gfsFile.get(0).getObjectId()));
//        response.setContentType(gridFsResource.getContentType());
        response.setContentType("image/png");
        IOUtils.copy(new ByteArrayInputStream(data.getValue()),response.getOutputStream());

    }

    @RequestMapping(value = "/downloadFileByMd5")
    public void downloadFileByMd5(@RequestParam(name = "md5") String md5, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Query query = Query.query(Criteria.where("md5").is(md5));
        // 查询单个文件
        GridFSFile gfsFile = gridFsTemplate.findOne(query);
        GridFsResource gridFsResource=new GridFsResource(gfsFile, GridFSBuckets.create(mongoDbFactory.getDb()).openDownloadStream(gfsFile.getObjectId()));
        IOUtils.copy(gridFsResource.getInputStream(),response.getOutputStream());
    }

    /**
     * 删除文件
     * @param fileIds
     */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFile(@RequestBody List<String> fileIds) {
        Query query = Query.query(Criteria.where("_id").in(fileIds));
        // 查询单个文件
        long count=mongoTemplate.remove(query,"cell_info").getDeletedCount();
        System.out.println(count);
    }
}

class Data{
    private String _id;

    private byte[] value;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }
}
