package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.BookType;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (BookType)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:21:28
 */
public interface BookTypeMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookType queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<BookType> getPageListByCondition(@Param("page") Page<BookType> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<BookType> page);


    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 影响行数
     */
    int insert(BookType bookType);




    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 影响行数
     */
    int update(BookType bookType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<BookType> getTypeList();
}

