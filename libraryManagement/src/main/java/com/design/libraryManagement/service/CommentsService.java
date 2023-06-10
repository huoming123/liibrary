package com.design.libraryManagement.service;

import com.design.libraryManagement.pojo.Comments;
import com.design.libraryManagement.pojo.res.RestFulBean;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Comments)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 19:22:25
 */
public interface CommentsService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Comments> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Comments> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Comments comments);

    /**
     * 修改数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Comments comments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
