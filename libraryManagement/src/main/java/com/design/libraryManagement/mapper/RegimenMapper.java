package com.design.libraryManagement.mapper;

import com.design.libraryManagement.pojo.Regimen;
import java.util.List;
import com.design.libraryManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Regimen)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 19:23:56
 */
public interface RegimenMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Regimen queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Regimen> getPageListByCondition(@Param("page") Page<Regimen> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Regimen> page);


    /**
     * 新增数据
     *
     * @param regimen 实例对象
     * @return 影响行数
     */
    int insert(Regimen regimen);




    /**
     * 修改数据
     *
     * @param regimen 实例对象
     * @return 影响行数
     */
    int update(Regimen regimen);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Regimen> getRegimenList();
}

