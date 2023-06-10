package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Recommend;
import com.design.libraryManagement.service.RecommendService;
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
 * (Recommend)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:25:02
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {
    /**
     * 服务对象
     */
    @Autowired
    private RecommendService recommendService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Recommend>page) throws Exception{
        return this.recommendService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Recommend> queryById(@RequestBody Recommend recommend) {
        return this.recommendService.queryById(recommend.getId());
    }

    /**
     * 新增数据
     *
     * @param recommend 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Recommend recommend) {
        return this.recommendService.insert(recommend);
    }

    /**
     * 编辑数据
     *
     * @param recommend 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Recommend recommend) {
        return this.recommendService.update(recommend);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Recommend recommend) {
        return this.recommendService.deleteById(recommend.getId());
    }

}

