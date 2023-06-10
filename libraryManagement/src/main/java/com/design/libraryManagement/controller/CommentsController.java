package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Comments;
import com.design.libraryManagement.service.CommentsService;
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
 * (Comments)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:22:25
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    /**
     * 服务对象
     */
    @Autowired
    private CommentsService commentsService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Comments>page) throws Exception{
        return this.commentsService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Comments> queryById(@RequestBody Comments comments) {
        return this.commentsService.queryById(comments.getId());
    }

    /**
     * 新增数据
     *
     * @param comments 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Comments comments) {
        return this.commentsService.insert(comments);
    }

    /**
     * 编辑数据
     *
     * @param comments 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Comments comments) {
        return this.commentsService.update(comments);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Comments comments) {
        return this.commentsService.deleteById(comments.getId());
    }

}

