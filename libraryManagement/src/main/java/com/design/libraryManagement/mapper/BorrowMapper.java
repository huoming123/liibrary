package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.Borrow;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Borrow)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:22:03
 */
public interface BorrowMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Borrow queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Borrow> getPageListByCondition(@Param("page") Page<Borrow> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Borrow> page);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int insert(Borrow borrow);




    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int update(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Borrow queryByUserIdAndbookId(Integer userId, Integer bookId);
    Borrow queryByUserIdAndbookIdAndDeletedAt(Integer userId, Integer bookId);

    void returnBook(Borrow borrow);

    Borrow queryByUserIdAndbookIdAndDeletedAtAndStatus(Integer userId, Integer bookId);

    void pay(Integer userId, Integer bookId);

    void updateByUserIdAndbookIdAndDeletedAt(Integer userId, Integer bookId, Integer newDay);

    List<Borrow> getBorrowList();

    List<Borrow> queryByUserId(Integer userId);
}

