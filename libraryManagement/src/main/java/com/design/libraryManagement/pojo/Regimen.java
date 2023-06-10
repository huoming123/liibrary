package com.design.libraryManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Regimen)实体类
 *
 * @author makejava
 * @since 2022-12-16 19:23:56
 */
public class Regimen implements Serializable {
    private static final long serialVersionUID = 938125452224270474L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 借阅制度
     */
    private String regimen;
     /**
     * 时间
     */
    private Date createdAt;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 是否显示 1为显示 0 为隐藏
     */
    private Integer showIn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

}

