package com.wanghuan.base;

import java.io.Serializable;

/**
 * Created by 54416 on 2017/8/1.
 */
public class BaseEntity implements Serializable{
    protected int page = 1;

    protected int size = 20;

    protected String sidx = "id";

    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
