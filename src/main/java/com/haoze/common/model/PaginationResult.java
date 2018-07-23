package com.haoze.common.model;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页封装信息。
 * @author maxl
 * @time 2018-05-03。
 */
public class PaginationResult<T> implements Serializable {

    private int total;
    private List<T> rows;

    public PaginationResult(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
