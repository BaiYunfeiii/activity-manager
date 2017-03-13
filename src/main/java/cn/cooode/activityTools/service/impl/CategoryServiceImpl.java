package cn.cooode.activityTools.service.impl;

import cn.cooode.activityTools.constants.EntityConstants;
import cn.cooode.activityTools.dao.ActivityDao;
import cn.cooode.activityTools.dao.CategoryDao;
import cn.cooode.activityTools.entity.Activity;
import cn.cooode.activityTools.entity.Category;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.service.CategoryService;
import cn.cooode.activityTools.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ActivityDao activityDao;

    public Category save(Category category) {
        return categoryDao.save(category);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public Category get(Long id) {
        return categoryDao.get(id);
    }

    public List<Category> list() {
        SystemContext.setOrder("category.name");
        String hql = "from Category category " +
                "where category.state="+ EntityConstants.CATEGORY_STATE_NORMAL;

        return categoryDao.list(hql);
    }

    public Long activityCount(Long categoryId) {
        String hql = "from Activity where category.id=?";
        Pager<Activity> pager = activityDao.find(hql,categoryId);
        return pager.getRecordCount();
    }

    public void delete(Long categoryId){
        Category category = categoryDao.get(categoryId);
        category.setState(EntityConstants.CATEGORY_STATE_DELETED);
        categoryDao.update(category);

        //获取类别“未分类”
        String hql = "from Category where name='"+EntityConstants.CATEGORY_DEFAULT+"'";
        Category defaultCategory = (Category)categoryDao.queryObject(hql,null,null);

        //把原分类中的文章移动到“未分类”中
        hql = "from Activity where category.id=?";
        List<Activity> ActivityList = activityDao.list(hql,category.getId());
        int count = 0; //记录移动了的数量
        for(Activity Activity: ActivityList){
            Activity.setCategory(defaultCategory);
            activityDao.update(Activity);
            count ++;
        }
        //修改“未分类”的数量
        categoryDao.update(defaultCategory);
    }

}
