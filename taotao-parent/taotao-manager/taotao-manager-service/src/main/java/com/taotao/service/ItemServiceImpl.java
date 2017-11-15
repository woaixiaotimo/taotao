package com.taotao.service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.taotao.pojo.TbItemExample.*;

/**
 * Created by 啊Q on 2017/11/12.
 * 商品管理service
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemlById(long itemId) {
//        TbItem item = itemMapper.selectByPrimaryKey(itemId);
//        return item;

        TbItemExample example = new TbItemExample();
//        添加查询条件
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> itemList = itemMapper.selectByExample(example);

        if (itemList != null && itemList.size() > 0) {
            TbItem item = itemList.get(0);
            return item;
        }
        return null;

    }
}
