package com.qsx.crm.model;
/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 * 
 * All rights reserved
 *****************************************************************************/

import java.util.List;

/**
 * 菜单josn 类
 * 
 * @author QingShiXun
 * @version 1.0
 */
public class MenuJSON {

    // id
    private Integer id;

    // 子菜单
    private List<MenuJSON> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MenuJSON> getChildren() {
        return children;
    }

    public void setChildren(List<MenuJSON> children) {
        this.children = children;
    }

}

