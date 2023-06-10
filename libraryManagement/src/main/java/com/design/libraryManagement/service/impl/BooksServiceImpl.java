package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.mapper.BorrowMapper;
import com.design.libraryManagement.mapper.CommentsMapper;
import com.design.libraryManagement.pojo.Books;
import com.design.libraryManagement.mapper.BooksMapper;
import com.design.libraryManagement.pojo.Borrow;
import com.design.libraryManagement.pojo.Comments;
import com.design.libraryManagement.service.BooksService;
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
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 19:21:43
 */
@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private BorrowMapper borrowMapper;

         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Books> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Books> list= booksMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Books books: list){
                books.setImagesUrl("http://localhost:8087/file/"+books.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = booksMapper.getPageListCount(page);
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
    public RestFulBean<Books> queryById(Integer id) {
       Books books=this.booksMapper.queryById(id); //根据id获取详情
        books.setImagesUrl("http://localhost:8087/file/"+books.getImages()); //返回本地完整图片路劲给前端

        List<Comments> list=commentsMapper.getByBookId(books.getId());//根据书id获取这本书所有的留言
        if(list.size()>0){ //数据大于0  说明这本书有留言数据
            for(Comments comments:list) //用for循环把照片的完整路劲返回前端显示
            {
                comments.setImagesUrl("http://localhost:8087/file/"+comments.getImages());
            }
        }
         books.setCommentsList(list); //最后将处理好的数据返回给前端
         return RestFulBean.succ(books);
    }

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Books books) {
        //对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        if (books.getIsbn()==null){
            return RestFulBean.error("ISBN不能为空");
        }
        if (books.getBookName()==null){
            return RestFulBean.error("图书名字不能为空");
        }
        if (books.getTotal()==null){
            return RestFulBean.error("库存不能为空不能为空");
        }
        if (books.getImages()==null){
            return RestFulBean.error("照片不能为空");
        }
        Books books1 =booksMapper.getByISBN(books.getIsbn()); //根据isbn获取图书数据
        if(books1!=null){ //判断是否为空  如果不为空 说明该ibsn号已经添加过了
            return RestFulBean.error("该isbn号已经添加,请不要重复添加");
        }
        Books books2 =booksMapper.getByBookName(books.getBookName());//根据书名获取图书数据
        if(books2!=null){//判断是否为空  如果不为空 说明该书名已经添加过了
            return RestFulBean.error("该书名已经添加,请不要重复添加");
        }
        this.booksMapper.insert(books);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Books books) {
        this.booksMapper.update(books);//执行数据库的修改语句 根据id 修改
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
        this.booksMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Books> getByISBN(String isbn) {
        Books book = booksMapper.getByISBN(isbn); //根据isbn获取图书信息
        if(book==null) //如果查出来没有数据 则说明ISBN编号错误
        {
            return RestFulBean.error("ISBN编号错误");
        }
        book.setImagesUrl("http://localhost:8087/file/"+book.getImages()); //把照片的完整路劲返回前端显示
        return RestFulBean.succ(book);
    }

    @Override
    public RestFulBean<Books> returGetByISBN(Books books) {
        Books booked = booksMapper.getByISBN(books.getIsbn()); //根据isbn获取图书信息
        if(booked==null)//如果查出来没有数据 则说明ISBN编号错误
        {
            return RestFulBean.error("ISBN编号错误");
        }
        //根据用户id 和书id查看有没有这本书未归还
        Borrow borrow = borrowMapper.queryByUserIdAndbookIdAndDeletedAt(books.getUserId(),booked.getId());
        if(borrow==null){ //如果等于空说明图书已经归还了 或者还没借阅
            return RestFulBean.error("此书你已经归还或者还未借阅,无需还书");
        }
        long t1 = borrow.getCreatedAt().getTime(); //获取借书的日期
        long t2 = System.currentTimeMillis();//获取当前系统的日期
        int day=(int) ((t2 - t1)/(1000*60*60*24)); //当前日期减去借书日期 得出已借天数
        booked.setBorrowDay(day);//已借天数
        if(day>borrow.getDays()) //如果得出的已借天数大于借书的天数 说明逾期了
        {
            booked.setDisabled(true); //逾期了 续借按钮不可编辑
            booked.setOverTime(day-borrow.getDays());//超过天数
            booked.setFee(booked.getOverTime()*1.00);//超过的天数按每天一元算
        }
        else{//否则还没逾期
            booked.setFee(0.00);//费用为0
            booked.setOverTime(0);//逾期天数为 0
            booked.setDisabled(false); //不逾期 续借按钮可以编辑
        }
        booked.setDays(borrow.getDays()); //借书的天数
        booked.setImagesUrl("http://localhost:8087/file/"+booked.getImages()); //返回本地完整图片路劲给前端
        return RestFulBean.succ(booked);
    }
}
