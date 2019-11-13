package com.tww.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-10-31 10:10
 */
public class ImageBinary {

    public static byte[] getImageBinary(MultipartFile multiportFile) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            InputStream stream=multiportFile.getInputStream();
            int num = stream.read(buffer);
            while (num != -1) {
                baos.write(buffer, 0, num);
                num = stream.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
