package com.qsx.crm.model;
/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 * 
 * All rights reserved
 * 
 *****************************************************************************/

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 产品状态
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "com.qingshixun.project.crm.model.ProductStatus")
public class ProductStatus extends DictionaryModel {

    private static final long serialVersionUID = 1L;

    // 销售中
    public static final ProductStatus saleStatus = new ProductStatus("PROS_Sale");

    // 停止销售
    public static final ProductStatus stopStatus = new ProductStatus("PROS_Stop");

    public ProductStatus() {
    }

    public ProductStatus(String code) {
        super.setCode(code);
    }
}

