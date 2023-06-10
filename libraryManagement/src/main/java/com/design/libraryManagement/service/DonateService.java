package com.design.libraryManagement.service;

import com.design.libraryManagement.pojo.Donate;
import com.design.libraryManagement.pojo.res.RestFulBean;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Donate)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 19:22:41
 */
public interface DonateService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Donate> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Donate> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param donate 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Donate donate);

    /**
     * 修改数据
     *
     * @param donate 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Donate donate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
