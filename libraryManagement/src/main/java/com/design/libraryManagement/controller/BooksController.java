package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Books;
import com.design.libraryManagement.service.BooksService;
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
 * (Books)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:21:43
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    /**
     * 服务对象
     */
    @Autowired
    private BooksService booksService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Books>page) throws Exception{
        return this.booksService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Books> queryById(@RequestBody Books books) {
        return this.booksService.queryById(books.getId());
    }
    /**
     * 借书通过isbn查找图书
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/isbn")
    public RestFulBean<Books> getByISBN(@RequestBody Books books) {
        return this.booksService.getByISBN(books.getIsbn());
    }

    /**
     * 还书通过isbn查找图书
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/return/get/by/isbn")
    public RestFulBean<Books> returGetByISBN(@RequestBody Books books) {
        return this.booksService.returGetByISBN(books);
    }
    /**
     * 新增数据
     *
     * @param books 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Books books) {
        return this.booksService.insert(books);
    }

    /**
     * 编辑数据
     *
     * @param books 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Books books) {
        return this.booksService.update(books);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Books books) {
        return this.booksService.deleteById(books.getId());
    }

}

