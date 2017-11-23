package com.taotao.service.impl;


import com.taotao.service.PictureService;
import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 啊Q on 2017/11/22.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${ftp.address}")
    private String ftp_address;

    @Value("${ftp.port}")
    private Integer ftp_port;

    @Value("${ftp.username}")
    private String ftp_username;

    @Value("${ftp.pwd}")
    private String ftp_pwd;

    @Value("${ftp.basePath}")
    private String ftp_basePath;

    @Value("${image.baseUrl}")
    private String image_baseUrl;

    @Override
    public Map uploadPicture(MultipartFile uploadfile) {

        Map resultMap = new HashMap();

//        取文件原名
        String oldName = uploadfile.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        生成新的文件名+后缀
        String newName = IDUtils.genImageName();
        newName += oldName.substring(oldName.lastIndexOf("."));
        try {
            String imgFilePath = "/www/images" + new DateTime().toString("/yyyy/MM/dd");
            System.out.println("ftp_address = " + ftp_address);
            System.out.println("ftp_port = " + ftp_port);
            System.out.println("ftp_username = " + ftp_username);
            System.out.println("ftp_pwd = " + ftp_pwd);
            System.out.println("ftp_basePath = " + ftp_basePath);
            System.out.println("imgFilePath = " + imgFilePath);
            System.out.println("oldName = " + oldName);
            System.out.println("newName = " + newName);
//        ftp上传
            boolean result = FtpUtil.uploadFile(
                    ftp_address, ftp_port, ftp_username, ftp_pwd,
                    ftp_basePath, imgFilePath, newName, uploadfile.getInputStream());

            if (result) {
                resultMap.put("error", 0);
                resultMap.put("mssage", "上传成功！");
                resultMap.put("url", image_baseUrl + imgFilePath + "/" + newName);
                System.out.println("url = " + image_baseUrl+ imgFilePath + "/" + newName);
                return resultMap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultMap.put("error", 1);
        resultMap.put("mssage", "上传失败！");
        return resultMap;
    }
}
