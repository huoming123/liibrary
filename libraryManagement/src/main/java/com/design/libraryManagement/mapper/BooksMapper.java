package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.Books;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Books)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:21:43
 */
public interface BooksMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Books queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Books> getPageListByCondition(@Param("page") Page<Books> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Books> page);


    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int insert(Books books);




    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int update(Books books);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Books getByISBN(String isbn);

    Books getByBookName(String bookName);


    List<Books> getBooksList();
}

