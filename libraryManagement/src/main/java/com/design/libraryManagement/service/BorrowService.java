package com.design.libraryManagement.service;

import com.design.libraryManagement.pojo.Borrow;
import com.design.libraryManagement.pojo.res.RestFulBean;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Borrow)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 19:22:03
 */
public interface BorrowService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Borrow> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Borrow> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Borrow borrow);

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> returnBook(Borrow borrow);

    RestFulBean<String> pay(Borrow borrow);

    RestFulBean<String> renewal(Borrow borrow);
}
