package cn.cooode.activityTools.entity;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;

import java.util.Date;

/**
 * 活动审核
 * Created by BaiYunfei on 2017/1/3.
 */
@Entity
public class ActivityCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 活动
     */

    @OneToOne
    private Activity activity;
    /**
     * 审核者
     */
    @ManyToOne
    private User checker;
    /**
     * 是否通过
     */
    private Boolean pass;
    /**
     * 审核时间
     */
    private Date checkTime;
    /**
     * 是否已经处理
     */
    private Boolean processed = false;

    public ActivityCheck(Activity activity){
        this.activity = activity;
    }

    public ActivityCheck() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getChecker() {
        return checker;
    }

    public void setChecker(User checker) {
        this.checker = checker;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
