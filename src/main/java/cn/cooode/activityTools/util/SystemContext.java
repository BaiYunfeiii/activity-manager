package cn.cooode.activityTools.util;

/**
 * 储存分页信息
 * @author BaiYunfei
 */
public class SystemContext {
    /**
     * 分页大小
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    /**
     * 分页的起始页
     */
    private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
    /**
     * 列表的排序字段
     */
    private static ThreadLocal<String> sort = new ThreadLocal<String>();
    /**
     * 列表的排序方式
     */
    private static ThreadLocal<String> order = new ThreadLocal<String>();

    private static ThreadLocal<String> realPath = new ThreadLocal<String>();

    public static String getRealPath() {
        return realPath.get();
    }

    public static void setRealPath(String _realPath) {
        realPath.set(_realPath);
    }

    public static Integer getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(Integer _pageSize) {
        if(_pageSize>0)
            pageSize.set(_pageSize);
    }

    public static Integer getPageOffset() {
        return pageOffset.get();
    }

    public static void setPageOffset(Integer _pageOffset) {
        if(_pageOffset>0)
            pageOffset.set(_pageOffset);
    }

    /**
     * 获取排序的字段
     *
     * @return
     */
    public static String getSort() {
        return sort.get();
    }

    /**
     * 设置排序的字段
     *
     * @param _sort
     */
    public static void setSort(String _sort) {
        sort.set(_sort);
    }

    /**
     * 获取排序的方式
     *
     * @return
     */
    public static String getOrder() {
        return order.get();
    }

    /**
     * 设置排序的方式
     *
     * @param _order
     */
    public static void setOrder(String _order) {
        order.set(_order);
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void removePageOffset() {
        pageOffset.remove();
    }

    public static void removeSort() {
        sort.remove();
    }

    public static void removeOrder() {
        order.remove();
    }

    public static void removeRealPath() {
        realPath.remove();
    }


    /**
     * 设置分页查询的参数
     *
     * @param pageSize
     *            页面大小
     * @param pageNum
     *            页码
     */
    public static void setPageArgs(int pageSize, int pageNum) {
        if (pageSize > 0) {
            setPageSize(pageSize);
        }
        if (pageNum > 0) {
            setPageOffset(pageNum);
        }
    }
}

