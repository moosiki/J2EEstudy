package com.qsx.crm.core;

/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com All rights reserved
 *****************************************************************************/
import java.util.Collection;

public class PageContainer {

    /** 状态 */
    private String status = "0";

    /** 记录的总数 */
    private long iTotalRecords;

    /** 当前页的记录总数 */
    private int iTotalDisplayRecords;

    /** 记录集合 */
    private Collection data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }

}

