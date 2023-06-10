package com.design.libraryManagement.controller;

import com.design.libraryManagement.pojo.Borrow;
import com.design.libraryManagement.service.BorrowService;
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
 * (Borrow)表控制层
 *
 * @author makejava
 * @since 2022-12-16 19:22:03
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    /**
     * 服务对象
     */
    @Autowired
    private BorrowService borrowService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Borrow>page) throws Exception{
        return this.borrowService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Borrow> queryById(@RequestBody Borrow borrow) {
        return this.borrowService.queryById(borrow.getId());
    }

    /**
     * 借书
     *
     * @param borrow 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Borrow borrow) {
        return this.borrowService.insert(borrow);
    }
    /**
     * 续借
     *
     * @param borrow 实体
     * @return 新增结果
     */
    @PostMapping("/renewal")
    public RestFulBean<String> renewal(@RequestBody Borrow borrow) {
        return this.borrowService.renewal(borrow);
    }

    /**
     * 还书
     *
     * @param borrow 实体
     * @return 新增结果
     */
    @PostMapping("/return/book")
    public RestFulBean<String> returnBook(@RequestBody Borrow borrow) {
        return this.borrowService.returnBook(borrow);
    }
    /**
     * 编辑数据
     *
     * @param borrow 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Borrow borrow) {
        return this.borrowService.update(borrow);
    }
    /**
     * 缴费
     *
     * @param borrow 实体
     * @return 编辑结果
     */
    @PostMapping("/pay")
    public RestFulBean<String> pay(@RequestBody Borrow borrow) {
        return this.borrowService.pay(borrow);
    }
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Borrow borrow) {
        return this.borrowService.deleteById(borrow.getId());
    }

}

