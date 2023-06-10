package com.design.libraryManagement.mapper;

import com.design.libraryManagement.dto.Page;
import com.design.libraryManagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 12:00:56
 */
public interface UsersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);


    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);



    List<Users> getPageListByCondition(@Param("page") Page<Users> page);

    Integer getPageListCount(@Param("page")Page<Users> page);

    Users getByTelephone(String telephone);

    Users getByTelephoneAndRole(String telephone, String role);

    List<Users> getUserList();
}
