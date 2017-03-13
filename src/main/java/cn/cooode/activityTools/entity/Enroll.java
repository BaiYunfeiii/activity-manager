package cn.cooode.activityTools.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/3.
 */
@Entity
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 活动
     */
    @ManyToOne(targetEntity = Activity.class)
    @JoinColumn
    private Activity activity;
    /**
     * 用户
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User user;
    /**
     * 报名时间
     */
    private Date enrollTime;
    @Column(columnDefinition = "TEXT")
    private String info;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
