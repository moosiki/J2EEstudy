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
 * 常见问答实体类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Entity
@Table(name = "qsx_problem")
public class ProblemModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    // 常见问答编码
    @Column
    private String code;

    // 问题
    @Column
    private String problem;

    // 回答
    @Column
    private String answer;

    // 常见问答状态
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "status_code")
    private ProblemStatus status;

    // 产品
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "product_id")
    private ProductModel product;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public ProblemStatus getStatus() {
        return status;
    }

    public void setStatus(ProblemStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

