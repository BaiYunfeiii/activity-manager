package cn.cooode.activityTools.dao;

/**
 * Created by BaiYunfei on 2017/1/3.
 */

import cn.cooode.activityTools.entity.Pager;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Dao基础类
 *
 * @author Yunfei
 *
 * @param <T>
 */
public interface BaseDao<T> {
    /**
     * 获取一个session对象
     * @return
     */
    public Session getSession();
    /**
     * 增加一个T类实例
     *
     * @param t
     *            要增加的实体
     * @return
     */
    public T save(T t);

    /**
     * 跟据id删除
     *
     * @param id
     */
    public void delete(Long id);

    /**
     * 更新一个T类型的实例
     *
     * @param t
     */
    public void update(T t);

    /**
     * 通过id获取一个T类型的实体
     *
     * @param id
     *            主键，id
     * @return T类型的实体
     */
    public T get(Long id);

    /**
     * 执行HQL 语句，查询一条记录
     *
     * @param hql
     * @param args
     *            参数，按顺序排列
     * @return 查询结果
     */
    public Object queryObject(String hql, Object... args);

    /**
     * 执行HQL语句，查询一条记录
     * @param hql
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public Object queryObject(String hql, Map<String, Object> alias);
    /**
     * 执行HQL语句，查询一条记录
     * @param hql
     * @param args 参数，按顺序的
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public Object queryObject(String hql, Map<String, Object> alias, Object[] args);

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param args 参数，按顺序的
     * @return 查询结果
     */
    public List<T> list(String hql, Object... args);

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public List<T> list(String hql, Map<String, Object> alias);

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param args 参数，按顺序的
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public List<T> list(String hql, Map<String, Object> alias, Object[] args);


    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param args
     * @return
     */
    public Pager<T> find(String hql, Object... args);

    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param alias
     * @return
     */
    public Pager<T> findByAlias(String hql, Map<String, Object> alias);

    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param args
     * @param alias
     * @return
     */
    public Pager<T> find(String hql, Map<String, Object> alias, Object[] args);
    /**
     * 執行hql語句
     * @param hql
     */
    public void executeUpdate(String hql, Object... args);

    public void executeUpdateByAlias(String hql, Map<String, Object> alias);

}


