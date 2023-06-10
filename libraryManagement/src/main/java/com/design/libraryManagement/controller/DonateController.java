package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Donate;
import com.design.libraryManagement.service.DonateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.libraryManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.libraryManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Donate)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:22:41
 */
@RestController
@RequestMapping("/donate")
public class DonateController {
    /**
     * 服务对象
     */
    @Autowired
    private DonateService donateService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Donate>page) throws Exception{
        return this.donateService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Donate> queryById(@RequestBody Donate donate) {
        return this.donateService.queryById(donate.getId());
    }

    /**
     * 新增数据
     *
     * @param donate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Donate donate) {
        return this.donateService.insert(donate);
    }

    /**
     * 编辑数据
     *
     * @param donate 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Donate donate) {
        return this.donateService.update(donate);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Donate donate) {
        return this.donateService.deleteById(donate.getId());
    }

}

