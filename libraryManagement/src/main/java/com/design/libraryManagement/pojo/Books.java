package com.design.libraryManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Books)实体类
 *
 * @author makejava
 * @since 2022-12-17 13:17:05
 */
public class Books implements Serializable {
    private static final long serialVersionUID = 166192612076756245L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 简介
     */
    private String describ;
    /**
     * 作者
     */
    private String autour;
    /**
     * 出版社
     */
    private String press;
    /**
     * 国家
     */
    private String region;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 图书编号
     */
    private String isbn;
    /**
     * 类型
     */
    private String type;
    /**
     * 价格
     */
    private Double price;
    /**
     * 数量
     */
    private Integer total;
    /**
     * 显示与隐藏 1为显示 0为隐藏
     */
    private Integer showIn;
    /**
     * 是否为读者推荐 1为是 0 为否
     */
    private Integer recommend;
    /**
     * 图片
     */
    private String images;

    private String imagesUrl;
   //用户id
    private Integer userId;
    //超出的天数
    private Integer overTime;
    //费用
    private Double Fee;
    //借书天数
    private Integer days;
    //已借天数
    private Integer borrowDay;
    //逾期支付状态
    private Integer status;
    //是否可编辑
    private Boolean disabled;

    /**
     * 存放位置
     */
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Integer borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        Fee = fee;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private List<Comments> CommentsList;

    public List<Comments> getCommentsList() {
        return CommentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        CommentsList = commentsList;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getAutour() {
        return autour;
    }

    public void setAutour(String autour) {
        this.autour = autour;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
