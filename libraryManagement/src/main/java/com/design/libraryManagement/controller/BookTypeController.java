package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.BookType;
import com.design.libraryManagement.service.BookTypeService;
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
 * (BookType)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:21:28
 */
@RestController
@RequestMapping("/bookType")
public class BookTypeController {
    /**
     * 服务对象
     */
    @Autowired
    private BookTypeService bookTypeService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<BookType>page) throws Exception{
        return this.bookTypeService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<BookType> queryById(@RequestBody BookType bookType) {
        return this.bookTypeService.queryById(bookType.getId());
    }

    /**
     * 新增数据
     *
     * @param bookType 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody BookType bookType) {
        return this.bookTypeService.insert(bookType);
    }

    /**
     * 编辑数据
     *
     * @param bookType 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody BookType bookType) {
        return this.bookTypeService.update(bookType);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody BookType bookType) {
        return this.bookTypeService.deleteById(bookType.getId());
    }
    /**
     *
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/type/list")
    public RestFulBean<List<BookType>> getTypeList() throws Exception{
        return this.bookTypeService.getTypeList();
    }
}

