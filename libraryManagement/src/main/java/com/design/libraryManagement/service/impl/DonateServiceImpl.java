package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.pojo.Donate;
import com.design.libraryManagement.mapper.DonateMapper;
import com.design.libraryManagement.service.DonateService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.libraryManagement.pojo.res.RestFulBean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.libraryManagement.util.PageUtil;
import com.design.libraryManagement.dto.Page;
/**
 * (Donate)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 19:22:42
 */
@Service("donateService")
public class DonateServiceImpl implements DonateService {
    @Autowired
    private DonateMapper donateMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Donate> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        if(page.getKey().getCreatedAt()!=null){            //根据捐赠日期搜索时 把时间转化为字符串进行搜索
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = fmt.format(page.getKey().getCreatedAt());
            page.setDateTime(dateStr);  //字符串日期赋值
        }
        //根据前端传来的的条件进行查询  //分页查询
        List<Donate> list= donateMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Donate donate: list){
                donate.setImagesUrl("http://localhost:8087/file/"+donate.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = donateMapper.getPageListCount(page);
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
    public RestFulBean<Donate> queryById(Integer id) {
       Donate donate=this.donateMapper.queryById(id);
         return RestFulBean.succ(donate);
    }

    /**
     * 新增数据
     *
     * @param donate 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Donate donate) {
        this.donateMapper.insert(donate);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param donate 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Donate donate) {
        this.donateMapper.update(donate);//执行数据库的修改语句 根据id 修改
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
        this.donateMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
