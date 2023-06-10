package com.design.libraryManagement.service.impl;

import com.design.libraryManagement.pojo.Recommend;
import com.design.libraryManagement.mapper.RecommendMapper;
import com.design.libraryManagement.service.RecommendService;
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
 * (Recommend)表服务实现类
 *
 * @author makejava
 * @since 2022-12-16 19:25:05
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Recommend> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Recommend> list= recommendMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Recommend recommend: list){
                if(recommend.getChecked()==0){ //审核状态为0说明还未审核 读者可以编辑
                    recommend.setDisabled(false);
                }
                else{ //否则状态为已审核 读者不可以编辑
                    recommend.setDisabled(true);
                }
                recommend.setImagesUrl("http://localhost:8087/file/"+recommend.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = recommendMapper.getPageListCount(page);
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
    public RestFulBean<Recommend> queryById(Integer id) {
       Recommend recommend=this.recommendMapper.queryById(id);
         return RestFulBean.succ(recommend);
    }

    /**
     * 新增数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Recommend recommend) {
        //对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        if (recommend.getIsbn()==null){
            return RestFulBean.error("ISBN不能为空");
        }
        if (recommend.getBookName()==null){
            return RestFulBean.error("图书名字不能为空");
        }
        if (recommend.getImages()==null){
            return RestFulBean.error("照片不能为空");
        }
        this.recommendMapper.insert(recommend);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param recommend 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Recommend recommend) {
        this.recommendMapper.update(recommend);//执行数据库的修改语句 根据id 修改
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
        this.recommendMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
