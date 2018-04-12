package com.qsx.crm.model;
/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 * 
 * All rights reserved
 * 
 *****************************************************************************/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 采购订单条目实体类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Entity
@Table(name = "qsx_purchase_order_item")
public class PurchaseOrderItemModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    // 产品数量
    @Column
    private Integer quantity;

    // 采购订单
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "purchaseorder_id")
    private PurchaseOrderModel purchaseOrder;

    // 产品
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "product_id")
    private ProductModel product;

    // 产品总价
    @Column
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PurchaseOrderModel getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderModel purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

