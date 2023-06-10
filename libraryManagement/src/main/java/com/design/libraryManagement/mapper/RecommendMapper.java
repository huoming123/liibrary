package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.Recommend;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Recommend)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:25:05
 */
public interface RecommendMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recommend queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Recommend> getPageListByCondition(@Param("page") Page<Recommend> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Recommend> page);


    /**
     * 新增数据
     *
     * @param recommend 实例对象
     * @return 影响行数
     */
    int insert(Recommend recommend);




    /**
     * 修改数据
     *
     * @param recommend 实例对象
     * @return 影响行数
     */
    int update(Recommend recommend);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

