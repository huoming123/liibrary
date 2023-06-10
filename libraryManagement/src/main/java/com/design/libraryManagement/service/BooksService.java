package com.design.libraryManagement.service;

import com.design.libraryManagement.pojo.Books;
import com.design.libraryManagement.pojo.res.RestFulBean;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Books)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 19:21:43
 */
public interface BooksService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Books> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Books> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Books books);

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Books books);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Books> getByISBN(String isbn);


    RestFulBean<Books> returGetByISBN(Books books);
}
