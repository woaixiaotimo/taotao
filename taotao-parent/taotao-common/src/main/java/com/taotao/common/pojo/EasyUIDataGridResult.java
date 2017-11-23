package com.taotao.common.pojo;

import java.util.List;

/**
 * Created by 啊Q on 2017/11/16.
 */
public class EasyUIDataGridResult {

    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private List<?> rows;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
