package com.design.libraryManagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comments)实体类
 *
 * @author makejava
 * @since 2022-12-17 15:26:45
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = 678908937790177080L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 图书id 记录读者留言的图书
     */
    private Integer bookId;
    /**
     * 评论人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 读者留言
     */
    private String comments;
    /**
     * 头像
     */
    private String images;

    private String imagesUrl;

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
