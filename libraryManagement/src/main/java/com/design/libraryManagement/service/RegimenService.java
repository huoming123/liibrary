package com.design.libraryManagement.service;

import com.design.libraryManagement.pojo.Regimen;
import com.design.libraryManagement.pojo.res.RestFulBean;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Regimen)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 19:23:56
 */
public interface RegimenService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Regimen> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Regimen> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param regimen 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Regimen regimen);

    /**
     * 修改数据
     *
     * @param regimen 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Regimen regimen);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Regimen>> getRegimenList();
}
