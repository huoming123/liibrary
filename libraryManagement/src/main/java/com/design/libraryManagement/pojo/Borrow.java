package com.design.libraryManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Borrow)实体类
 *
 * @author makejava
 * @since 2022-12-16 19:22:03
 */
public class Borrow implements Serializable {
    private static final long serialVersionUID = -45013631322771473L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 书id 记录借的是哪一本书
     */
    private Integer bookId;
     /**
     * 用户id 记录是哪一个人借的
     */
    private Integer userId;
     /**
     * 借书人
     */
    private String createdBy;
     /**
     * 借书天数
     */
    private Integer days;
     /**
     * 借书时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 还书时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deletedAt;
     /**
     * 逾期费用
     */
    private Double fee;
     /**
     * 是否逾期
     */
    private Integer over;
     /**
     * 逾期是否缴费 1为缴费  0为未缴费
     */
    private Integer status;
    //照片
    private String images;
    //照片路劲
    private String imagesUrl;
    //用户名
    private String userName;
    //图书名字
    private String bookName;
    //是否可编辑
    private Boolean disabled;
    //管理员确认还书是否可编辑
    private Boolean checkDisabled;
    //归还状态
    private  String returnState;
    //图书ISBN
    private  String isbn;
    //是否归还
    private  Integer back;
    //逾期天数
    private  Integer overTime;
    //已借天数
    private Integer borrowDay;
    //已借天数
    private Integer renewalDay;
    //审核
    private Integer checked;

    public Boolean getCheckDisabled() {
        return checkDisabled;
    }

    public void setCheckDisabled(Boolean checkDisabled) {
        this.checkDisabled = checkDisabled;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getRenewalDay() {
        return renewalDay;
    }

    public void setRenewalDay(Integer renewalDay) {
        this.renewalDay = renewalDay;
    }

    public Integer getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Integer borrowDay) {
        this.borrowDay = borrowDay;
    }
    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getOver() {
        return over;
    }

    public void setOver(Integer over) {
        this.over = over;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

