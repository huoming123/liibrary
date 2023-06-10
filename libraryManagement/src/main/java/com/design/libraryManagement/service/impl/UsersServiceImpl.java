package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.dto.Page;
import com.design.libraryManagement.mapper.BooksMapper;
import com.design.libraryManagement.mapper.BorrowMapper;
import com.design.libraryManagement.pojo.Books;
import com.design.libraryManagement.pojo.Borrow;
import com.design.libraryManagement.pojo.Users;
import com.design.libraryManagement.mapper.UsersMapper;
import com.design.libraryManagement.service.UsersService;
import com.design.libraryManagement.util.FileUtil;
import com.design.libraryManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.libraryManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 12:00:53
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BooksMapper booksMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id); //根据id获取详情信息
        users.setImagesUrl("http://localhost:8087/file/"+users.getImages());
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getUserName()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("用户名不能为空");
        }
        if(users.getPassword()==null){
            return RestFulBean.error("密码不能为空");
        }
        if(users.getAddress()==null){
            return RestFulBean.error("住址不能为空");
        }
        if(users.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        Users usered =usersMapper.getByTelephone(users.getTelephone());//根据手机号查询该手机号是否注册了
        if(usered!=null){ //如果不为空 说明手机号已经注册
            return RestFulBean.error("该手机号已经注册");
        }
        this.usersMapper.insert(users); //执行新增的sql语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);
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
        this.usersMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> login(Users users) {
        if(users.getTelephone()==null)//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        Users usered =usersMapper.getByTelephoneAndRole(users.getTelephone(),users.getRole());//根据手机号查询该手机号是否注册了
        //定义 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        //如果用户不为空
        if (usered!=null){
            //如果密码跟数据库一样
            if(users.getPassword().equals(usered.getPassword()))
            {
                result.put("userName",usered.getUserName());               //将用户名userName加到result对象里面
                result.put("role",usered.getRole());//将角色加到result对象里面
                result.put("userId",usered.getId());             //将用户id加到result对象里面
                result.put("images",usered.getImages());             //将照片加到result对象里面
                return RestFulBean.succ(result);             //将数据返回给前端
            }
            else{   //如果密码跟数据库不一样 则返回密码错误
                return RestFulBean.error("密码错误");
            }

        }
        //如果用户为空 说明用户不存在
        return RestFulBean.error("用户不存在");
    }

    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) throws Exception {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        //返回一个完整的本地照片路径用于前端显示
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        //把照片的名字重新返回给前端用于保存到数据库users表的images字段中
        map.put("imageName",coverFile.getOriginalFilename());
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception {
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Users users: list){
                users.setImagesUrl("http://localhost:8087/file/"+users.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getToTal() {
        Integer total=0; //定义在线书籍库存数量
        Map result = new HashMap();
        List<Users> list=  usersMapper.getUserList(); //获取读者数据 统计数量
        List<Books> list1=  booksMapper.getBooksList();//获取图书数量 统计库存
        for(Books books:list1){ //用for把每种书的数量加起来
            total=total+books.getTotal();
        }
        List<Borrow> list2 = borrowMapper.getBorrowList(); //获取未归还的书籍 统计借出去多少本书

        result.put("readerCount",list.size());//读者数量
        result.put("borrowCount",list2.size());//借出去书籍统计
        result.put("booksCount",total);//在线书籍有多少本
        result.put("booksTotal",total+list2.size());//总库存
        return RestFulBean.succ(result);
    }
}
