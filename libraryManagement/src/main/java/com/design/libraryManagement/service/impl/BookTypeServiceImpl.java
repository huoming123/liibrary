package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.pojo.BookType;
import com.design.libraryManagement.mapper.BookTypeMapper;
import com.design.libraryManagement.service.BookTypeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.libraryManagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.libraryManagement.util.PageUtil;
import com.design.libraryManagement.dto.Page;
/**
 * (BookType)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 19:21:28
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<BookType> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<BookType> list= bookTypeMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = bookTypeMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<BookType> queryById(Integer id) {
       BookType bookType=this.bookTypeMapper.queryById(id);
         return RestFulBean.succ(bookType);
    }

    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(BookType bookType) {
        if(bookType.getType()==null){
            return RestFulBean.error("图书类别不能为空");
        }
        this.bookTypeMapper.insert(bookType);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(BookType bookType) {
        this.bookTypeMapper.update(bookType);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.bookTypeMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<BookType>> getTypeList() {
        List<BookType> lsit =bookTypeMapper.getTypeList();
        return RestFulBean.succ(lsit);
    }
}
