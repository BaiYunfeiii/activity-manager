package cn.cooode.activityTools.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * 活动
 * Created by BaiYunfei on 2017/1/3.
 */
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 主办方
     */
    private String organizer;
    /**
     * 地点
     */
    private String location;
    /**
     * 活动时间
     */
    private Date startTime;
    /**
     * 活动详情
     */
    @Column(columnDefinition = "TEXT")
    private String description;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 活动分类
     */
    @ManyToOne(targetEntity = Category.class)
    private Category category;
    /**
     * 创建者
     */
    @ManyToOne(targetEntity = User.class)
    private User author;
    /**
     * 阶段数量
     */
    private Integer round = 1;

    @OneToOne(mappedBy = "activity")
    /**
     * 活动审核
     */
    private ActivityCheck activityCheck;

    @OneToMany(mappedBy = "activity")
    private Set<Enroll> enrollSet;
    @OneToMany(mappedBy = "activity")
    private Set<Score> scoreSet;

    public ActivityCheck getActivityCheck() {
        return activityCheck;
    }

    public void setActivityCheck(ActivityCheck activityCheck) {
        this.activityCheck = activityCheck;
    }

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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Enroll> getEnrollSet() {
        return enrollSet;
    }

    public void setEnrollSet(Set<Enroll> enrollSet) {
        this.enrollSet = enrollSet;
    }

    public Set<Score> getScoreSet() {
        return scoreSet;
    }

    public void setScoreSet(Set<Score> scoreSet) {
        this.scoreSet = scoreSet;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
