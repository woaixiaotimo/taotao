package com.taotao.service;


import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * Created by 啊Q on 2017/11/12.
 */
public interface ItemService {
    TbItem getItemlById(long itemId);
    EasyUIDataGridResult getItemList(int page, int rows);
}
