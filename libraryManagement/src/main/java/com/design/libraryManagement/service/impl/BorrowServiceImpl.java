package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.mapper.BooksMapper;
import com.design.libraryManagement.pojo.Books;
import com.design.libraryManagement.pojo.Borrow;
import com.design.libraryManagement.mapper.BorrowMapper;
import com.design.libraryManagement.service.BorrowService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.libraryManagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.libraryManagement.util.PageUtil;
import com.design.libraryManagement.dto.Page;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Borrow)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 19:22:03
 */
@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BooksMapper booksMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Borrow> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Borrow> list= borrowMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Borrow borrow: list){
                borrow.setImagesUrl("http://localhost:8087/file/"+borrow.getImages());
                if(borrow.getDeletedAt()==null){ //如果归还时间为空 说明他未归还
                    borrow.setReturnState("未归还");
                    borrow.setDisabled(false); //未归还的话可以编辑归还的按钮
                }
                else{
                    borrow.setReturnState("已归还");//如果归还时间不为空 说明他已归还
                    borrow.setDisabled(true);//已归还的话就不可以编辑归还的按钮
                }
                if(borrow.getDeletedAt()==null){ //归还时间为空 说明还没归还 才需要进行计算
                    long t1 = borrow.getCreatedAt().getTime(); //获取借书的日期
                    long t2 = System.currentTimeMillis();//获取当前系统的日期
                    int day=(int) ((t2 - t1)/(1000*60*60*24)); //当前日期减去借书日期 得出已借天数
                    borrow.setBorrowDay(day);//已借天数
                    if(day>borrow.getDays()) //如果得出的已借天数大于借书的天数 说明逾期了
                    {
                        borrow.setOverTime(day-borrow.getDays());//超过天数
                        borrow.setFee(borrow.getOverTime()*1.00);//超过的天数按每天一元算
                        borrow.setOver(1);//已经逾期了 状态设置为1
                        borrow.setStatus(0);//逾期要缴费  这个值为0 代表还没缴费
                        borrowMapper.update(borrow);
                    }
                    else{//否则还没逾期
                        borrow.setFee(0.00);//费用为0
                        borrow.setOverTime(0);//逾期天数为 0
                    }
                }
                if(borrow.getChecked()==1){ //管理员确认图书已归还 按钮不可编辑
                    borrow.setCheckDisabled(true);
                }
               else{ //还没确认图书按钮可编辑
                    borrow.setCheckDisabled(false);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = borrowMapper.getPageListCount(page);
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
    public RestFulBean<Borrow> queryById(Integer id) {
       Borrow borrow=this.borrowMapper.queryById(id);
         return RestFulBean.succ(borrow);
    }

    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Borrow borrow) {
        //根据用户id图书id查询是否已经借过了
        Borrow borrowed= borrowMapper.queryByUserIdAndbookId(borrow.getUserId(),borrow.getBookId());
        if(borrowed!=null) //如果不为空 则说明已经借过这本书
        {
            return RestFulBean.error("你已经借阅过这本书籍");
        }
        //根据用户id查找 逾期未缴费的图书是不是超过了3本
        List<Borrow> borrowedList= borrowMapper.queryByUserId(borrow.getUserId());
        if(borrowedList.size()>2){
            return RestFulBean.error("你已经有"+borrowedList.size()+"本书逾期未缴费，请缴费归还图书之后再借书");
        }
        Books book = booksMapper.queryById(borrow.getBookId());  //根据图书id查询图书详情数据
        if(book.getTotal()==0){
            return RestFulBean.error("这本书没有库存了");
        }
        borrow.setOver(0); //是否逾期 默认为0 不逾期
        this.borrowMapper.insert(borrow);//执行数据库的新增语句
        book.setTotal(book.getTotal()-1); //借阅成功后 库存-1
        booksMapper.update(book); //更新图书表的数据
        return RestFulBean.succ("借阅成功");
    }

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Borrow borrow) {
        this.borrowMapper.update(borrow);//执行数据库的修改语句 根据id 修改
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
        this.borrowMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
    @Transactional
    @Override
    public RestFulBean<String> returnBook(Borrow borrow) {
        //根据用户id 和书id查看有没有这本书未归还
        Borrow borrowed = borrowMapper.queryByUserIdAndbookIdAndDeletedAt(borrow.getUserId(),borrow.getBookId());
        if(borrowed==null){ //如果等于空说明图书已经归还了 或者还没借阅
            return RestFulBean.error("此书你已经归还或者还未借阅,无需还书");
        }
        //根据用户id 和书id查看 和支付状态查看逾期的图书有没有付费
        Borrow borrowed1 = borrowMapper.queryByUserIdAndbookIdAndDeletedAtAndStatus(borrow.getUserId(),borrow.getBookId());
        if(borrowed1!=null){ //如果不等于空说明还没付费
            return RestFulBean.error("还没付费");
        }
        //还书的时候计算一下 把数据保存到数据库表中
        long t1 = borrowed.getCreatedAt().getTime(); //获取借书的日期
        long t2 = System.currentTimeMillis();//获取当前系统的日期
        int day=(int) ((t2 - t1)/(1000*60*60*24)); //当前日期减去借书日期 得出已借天数
        borrowed.setBorrowDay(day);//已借天数
        if(day>borrowed.getDays()) //如果得出的已借天数大于借书的天数 说明逾期了
        {
            borrowed.setOverTime(day-borrowed.getDays());//超过天数
            borrowed.setFee(borrow.getOverTime()*1.00);//超过的天数按每天一元算
            borrowed.setOver(1);//已经逾期了 状态设置为1
            borrowed.setStatus(1);//这里还书了 缴费状态为1了
            borrowMapper.update(borrowed);
        }
        else{//否则还没逾期
            borrowed.setFee(0.00);//费用为0
            borrowed.setStatus(1);//这里还书了 缴费状态为1了
            borrowed.setOverTime(0);//逾期天数为 0
            borrowMapper.update(borrowed);
        }
        //根据书id获取图书详情信息
        Books book = booksMapper.queryById(borrowed.getBookId());
        borrowed.setChecked(0); //还书的时候核实状态默认为0 未核实
        borrowMapper.returnBook(borrowed); //还书
        book.setTotal(book.getTotal()+1); //还书把书的库存加1
        booksMapper.update(book); //跟新这本书的库存
        return RestFulBean.succ("还书成功");
    }

    @Override
    public RestFulBean<String> pay(Borrow borrow) {
        borrowMapper.pay(borrow.getUserId(),borrow.getBookId()); //支付
        return RestFulBean.succ("缴费成功");
    }

    @Override
    public RestFulBean<String> renewal(Borrow borrow) {
        //根据用户id 和书id续借天数
        Integer newDay =borrow.getDays()+borrow.getRenewalDay(); //原来借书的天数+续借的天数
       borrowMapper.updateByUserIdAndbookIdAndDeletedAt(borrow.getUserId(),borrow.getBookId(),newDay);
        return RestFulBean.succ("续借成功");
    }
}
