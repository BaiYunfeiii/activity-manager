package cn.cooode.activityTools.dao.impl;

import cn.cooode.activityTools.dao.BaseDao;
import cn.cooode.activityTools.entity.Pager;
import cn.cooode.activityTools.util.SystemContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    /**
     * 默认的页面大小
     */
    @Value("${pageSize}")
    private Integer pageSize;
    /**
     * 默认的初始页
     */
    @Value("${pageOffset}")
    private Integer pageOffset;
    /**
     * 页面数量
     */
    @Value("${pageOffset}")
    private Integer pageCount;

    @Resource
    private SessionFactory sessioFactory;
    private Class<T> clz; // T的Class对象

    @SuppressWarnings("unchecked")
    private Class<T> getClz() {
        if(null == clz){
            clz = (Class<T>) (((ParameterizedType) (this.getClass()
                    .getGenericSuperclass()))
                    .getActualTypeArguments()[0]);
        }
        return clz;
    }

    /**
     * 获取一个Session
     *
     * @return
     */
    public Session getSession() {
        if (null == sessioFactory)
            System.out.println("sessionFactory为空");
        return this.sessioFactory.getCurrentSession();
    }


    public T save(T t) {
        getSession().save(t);
        return t;
    }


    public void delete(Long id) {
        T t = this.get(id);
        if (null != t) {
            this.getSession().delete(t);
            this.getSession().flush();
        }
    }


    public void update(T t) {
        this.getSession().update(t);
        this.getSession().flush();
    }


    public T get(Long id) {
        Session session = getSession();
        return (T) session.get(getClz(), id);
    }

    // 初始化HQL语句，增加排序
    private String initSort(String hql) {
        StringBuffer newHql = new StringBuffer(hql);
        // 从SystemContext获取排序方式
        String sort = SystemContext.getSort(); // 排序字段
        String order = SystemContext.getOrder(); // 排序方法

        if (null != sort && !"".equals(order)) {
            newHql.append(" order by ").append(sort);
            if ("desc".equals(order)) {
                newHql.append(" desc");
            } else {
                newHql.append(" asc");
            }
        }
        SystemContext.removeOrder();
        SystemContext.removeSort();
        return newHql.toString();
    }

    // 设置参数
    private void setParameters(Query query, Object[] args) {
        if (null != args && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
    }

    private void setAliasParameters(Query query, Map<String, Object> alias) {
        if (null != alias) {
            Set<String> keys = alias.keySet();
            for (String key : keys) {
                Object obj = alias.get(key);
                if (obj instanceof Collection) {
                    query.setParameter(key, (Collection) obj);
                } else {
                    query.setParameter(key, obj);
                }
            }
        }
    }

    //获得数量
    private String getCountHql(String hql, boolean isHql) {
        String e = hql.substring(hql.indexOf("from"));
        String c = "select  count(*) " + e;
        if (isHql)
            c = c.replaceAll("fetch", "");
        return c;
    }

    protected Long getCount(String hql,boolean isHql,Map<String,Object> alias)throws Exception{
        Query query = sessioFactory.getCurrentSession().createQuery(this.getCountHql(hql, isHql));
        setAliasParameters(query,alias);
        Object object = query.uniqueResult();
        return (Long)object;
    }

    // 设置分页参数
    private void setPager(Query query, Pager<T> pager) {
        Integer pageOffset = SystemContext.getPageOffset();
        Integer pageSize = SystemContext.getPageSize();
        if (null == pageOffset) {
            pageOffset = this.pageOffset;
        }
        if (null == pageSize) {
            pageSize = this.pageSize;
        }
        pager.setCurrentPage(pageOffset);
        pager.setPageSize(pageSize);
        query.setFirstResult((pageOffset - 1) * pageSize).setMaxResults(pageSize);
        //SystemContext.removePageSize();
        //SystemContext.removePageOffset();
    }

    //计算页码范围
    private void setPageRange(Pager pager) {
        int currentPage = pager.getCurrentPage();
        Long totalPage = pager.getPageCount();
        int beginPageIndex = 0;
        int endPageIndex = 0;
        int total = Integer.valueOf(totalPage.toString());
        if (pageCount > total) {
            beginPageIndex = 1;
            endPageIndex = total;
        } else {
            if (currentPage < pageCount / 2) {
                beginPageIndex = 1;
                endPageIndex = pageCount;
            } else {
                beginPageIndex = currentPage - (pageCount / 2) + 1;
                endPageIndex = beginPageIndex + pageCount - 1;
            }
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = endPageIndex - (pageCount - 1);
            }
        }
        pager.setBeginPageIndex(beginPageIndex);
        pager.setEndPageIndex(endPageIndex);
    }

    /**
     * 执行HQL 语句，查询一条记录
     * @param hql
     * @param args 参数，按顺序排列
     * @return 查询结果
     */
    public Object queryObject(String hql, Object[] args) {
        return queryObject(hql, null, args);
    }

    /**
     * 执行HQL语句，查询一条记录
     * @param hql
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public Object queryObject(String hql, Map<String, Object> alias) {
        return queryObject(hql, alias, null);
    }
    /**
     * 执行HQL语句，查询一条记录
     * @param hql
     * @param args 参数，按顺序的
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public Object queryObject(String hql, Map<String, Object> alias, Object[] args) {
        hql = initSort(hql);
        Query query = getSession().createQuery(hql);
        setParameters(query, args);
        setAliasParameters(query, alias);
        return query.uniqueResult();
    }

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param args 参数，按顺序的
     * @return 查询结果
     */
    public List<T> list(String hql, Object[] args) {
        return list(hql, null, args);
    }

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public List<T> list(String hql, Map<String, Object> alias) {
        return list(hql, alias, null);
    }

    /**
     * 执行HQL语句，查询一组记录
     * @param hql
     * @param args 参数，按顺序的
     * @param alias 参数，“参数：值”的键值对
     * @return 查询结果
     */
    public List<T> list(String hql, Map<String, Object> alias, Object[] args) {
        hql = initSort(hql);
        Query query = getSession().createQuery(hql);
        setParameters(query, args);
        setAliasParameters(query, alias);
        return (List<T>) query.list();
    }

    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param args
     * @return
     */
    public Pager<T> find(String hql, Object... args) {
        return find(hql, null, args);
    }

    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param alias
     * @return
     */
    public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
        return find(hql, alias, null);
    }

    /**
     * 执行HQL语句，带分页查询
     * @param hql
     * @param args
     * @param alias
     * @return
     */
    public Pager<T> find(String hql, Map<String, Object> alias, Object[] args) {
        hql = initSort(hql);
        String cql = getCountHql(hql, true);
        Query query = getSession().createQuery(hql);
        Query cquery = getSession().createQuery(cql);
        setParameters(query, args);
        setParameters(cquery, args);
        setAliasParameters(query, alias);
        setAliasParameters(cquery, alias);
        Pager<T> pager = new Pager<T>();
        setPager(query, pager);
        List<T> result = query.list();
        pager.setRecordList(result); // 页面数据
        Long total = (Long) cquery.uniqueResult();
        pager.setRecordCount(total); // 总记录数
        pager.setPageCount((total + pager.getPageSize() - 1) / pager.getPageSize()); // 总页数
        setPageRange(pager);// 计算页码索引范围
        return pager;
    }


    public void executeUpdate(String hql,Object[] args) {
        Query query = getSession().createQuery(hql);
        setParameters(query, args);
        query.executeUpdate();
    }


    public void executeUpdateByAlias(String hql, Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setAliasParameters(query, alias);
        query.executeUpdate();
    }

}
