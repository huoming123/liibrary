package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.Donate;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Donate)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:22:42
 */
public interface DonateMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Donate queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Donate> getPageListByCondition(@Param("page") Page<Donate> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Donate> page);


    /**
     * 新增数据
     *
     * @param donate 实例对象
     * @return 影响行数
     */
    int insert(Donate donate);




    /**
     * 修改数据
     *
     * @param donate 实例对象
     * @return 影响行数
     */
    int update(Donate donate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

