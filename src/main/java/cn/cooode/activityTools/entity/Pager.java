package cn.cooode.activityTools.entity;

import java.util.List;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
public class Pager<T> {

        /**
         * 当前页（起始页)
         */
        private Integer currentPage;
        /**
         * 页面大小
         */
        private Integer pageSize;
        /**
         * 总数据大小
         */
        private Long recordCount;
        /**
         * 页面总数
         */
        private Long pageCount;
        /**
         * 页面数据
         */
        private List<T> recordList;
        /**
         * 页码索引(开始)
         */
        private Integer beginPageIndex;
        /**
         * 页码索引(结束)
         */
        private Integer endPageIndex;

        /**
         * @return the currentPage
         */
        public Integer getCurrentPage() {
            return currentPage;
        }

        /**
         * @param currentPage
         *            the currentPage to set
         */
        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        /**
         * @return the pageSize
         */
        public Integer getPageSize() {
            return pageSize;
        }

        /**
         * @param pageSize
         *            the pageSize to set
         */
        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        /**
         * @return the recordCount
         */
        public Long getRecordCount() {
            return recordCount;
        }

        /**
         * @param recordCount the recordCount to set
         */
        public void setRecordCount(Long recordCount) {
            this.recordCount = recordCount;
        }


        /**
         * @return the pageCount
         */
        public Long getPageCount() {
            return pageCount;
        }

        /**
         * @param pageCount the pageCount to set
         */
        public void setPageCount(Long pageCount) {
            this.pageCount = pageCount;
        }

        /**
         * @return the recordList
         */
        public List<T> getRecordList() {
            return recordList;
        }

        /**
         * @param recordList the recordList to set
         */
        public void setRecordList(List<T> recordList) {
            this.recordList = recordList;
        }

        /**
         * @return the beginPageIndex
         */
        public Integer getBeginPageIndex() {
            return beginPageIndex;
        }

        /**
         * @param beginPageIndex
         *            the beginPageIndex to set
         */
        public void setBeginPageIndex(Integer beginPageIndex) {
            this.beginPageIndex = beginPageIndex;
        }

        /**
         * @return the endPageIndex
         */
        public Integer getEndPageIndex() {
            return endPageIndex;
        }

        /**
         * @param endPageIndex
         *            the endPageIndex to set
         */
        public void setEndPageIndex(Integer endPageIndex) {
            this.endPageIndex = endPageIndex;
        }

        public void setPageArgs(Pager pager){
            this.setBeginPageIndex(pager.getBeginPageIndex());
            this.setCurrentPage(pager.getCurrentPage());
            this.setEndPageIndex(pager.getEndPageIndex());
            this.setPageCount(pager.getPageCount());
            this.setPageSize(pager.getPageSize());
            this.setRecordCount(pager.getRecordCount());
        }
    }

