package cn.cooode.activityTools.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * 类型
 * Created by BaiYunfei on 2017/1/3.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 类型名称
     */
    private String name;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 发布者
     */
    @ManyToOne(targetEntity = User.class)
    private User author;
    @OneToMany(targetEntity = Activity.class,mappedBy = "category")
    private Set<Activity> activitySet;
    /**
     * 状态
     */
    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Activity> getActivitySet() {
        return activitySet;
    }

    public void setActivitySet(Set<Activity> activitySet) {
        this.activitySet = activitySet;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
