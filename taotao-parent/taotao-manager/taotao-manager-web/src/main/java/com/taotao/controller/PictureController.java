package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 上传图片处理
 * Created by 啊Q on 2017/11/22.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) {
        Map map = pictureService.uploadPicture(uploadFile);

        String resultJson = JsonUtils.objectToJson(map);
        return resultJson;
    }

}
