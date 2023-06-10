package com.design.libraryManagement.service;

import com.design.libraryManagement.dto.Page;
import com.design.libraryManagement.pojo.Users;
import com.design.libraryManagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 12:00:51
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> login(Users users);

    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;

    RestFulBean<Map> getList(Page<Users> page)throws Exception;

    RestFulBean<Map> getToTal();
}
