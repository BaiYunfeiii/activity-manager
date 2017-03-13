package cn.cooode.activityTools.service;

import cn.cooode.activityTools.entity.Category;

import java.util.List;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
public interface CategoryService {

    /**
     * 添加一个新分类
     * @param category
     * @return
     */
    Category save(Category category);

    /**
     * 更新
     * @param category
     * @return
     */
    void update(Category category);

    /**
     * 获取分类
     * @param id
     * @return
     */
    Category get(Long id);
    /**
     * 获取所有分类
     * @return
     */
    List<Category> list();

    /**
     * 统计分类下的文章数量
     * @param categoryId
     * @return
     */
    Long activityCount(Long categoryId);

    /**
     * 删除分类，将该分类中的文章移动到未分类
     * @param categoryId
     */
    void delete(Long categoryId);

}
