package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by 啊Q on 2017/11/22.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadfile);
}
