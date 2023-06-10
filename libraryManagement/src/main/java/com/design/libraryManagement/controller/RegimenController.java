package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Regimen;
import com.design.libraryManagement.service.RegimenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.libraryManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Regimen)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:23:56
 */
@RestController
@RequestMapping("/regimen")
public class RegimenController {
    /**
     * 服务对象
     */
    @Autowired
    private RegimenService regimenService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Regimen>page) throws Exception{
        return this.regimenService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Regimen> queryById(@RequestBody Regimen regimen) {
        return this.regimenService.queryById(regimen.getId());
    }

    /**
     * 新增数据
     *
     * @param regimen 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Regimen regimen) {
        return this.regimenService.insert(regimen);
    }

    /**
     * 编辑数据
     *
     * @param regimen 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Regimen regimen) {
        return this.regimenService.update(regimen);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Regimen regimen) {
        return this.regimenService.deleteById(regimen.getId());
    }
    //获取借阅制度数据
    @PostMapping("/get/regimen/list")
    public RestFulBean<List<Regimen>> getRegimenList() throws Exception{
        return this.regimenService.getRegimenList();
    }
}

