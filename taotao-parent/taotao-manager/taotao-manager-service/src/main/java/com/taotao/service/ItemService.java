package com.taotao.service;

import com.taotao.pojo.TbItem;
import org.springframework.stereotype.Service;

/**
 * Created by 啊Q on 2017/11/12.
 */
public interface ItemService {
    TbItem getItemlById(long itemId);
}
