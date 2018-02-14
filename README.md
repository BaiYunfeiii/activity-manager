# 活动发布平台

## 主要功能

活动组织者
1. 发布活动信息
2. 查看报名信息
3. 竞赛出成绩后，在系统中登记成绩

活动参与者
1. 查看活动信息
2. 报名

系统管理员
1. 审核活动
2. 管理分类

## 注意

1. 修改 /conf/jdbc.properties 中的数据库链接信息

## 运行效果
--------

### 所用用户

#### 活动列表

![输入图片说明](https://gitee.com/uploads/images/2018/0214/133845_bd0f18f7_1204709.png "83126337ede3891c99c4f5d6339f8048.png")

#### 活动详情

![输入图片说明](https://gitee.com/uploads/images/2018/0214/133914_dd0aace8_1204709.png "ec7f059b4c8b5847d2207333e757a018.png")

### 基本用户

#### 登陆后

登陆后，右侧显示关于我的信息

![输入图片说明](https://gitee.com/uploads/images/2018/0214/133937_efeb4ea5_1204709.png "328ebfb4d90cff680f4c2b515291cf22.png")

#### 报名参加活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134002_54ad4136_1204709.png "feff257c335910d4a8ffdf30a2106b4d.png")

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134028_4eacf0a2_1204709.png "ebbc23910a753aa74a10fdcda0a45e40.png")

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134036_d9459d24_1204709.png "4b6addd6e04a58ff9019cd0c08d0b3b5.png")

#### 查看活动报名情况

仅活动的创建者可以查看活动报名情况

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134103_9ff53a7f_1204709.png "364b79a0202e24990d5c8774307c7890.png")

点击后可以看到刚刚“白云”用户的报名信息

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134117_1468c56f_1204709.png "95872cb83ade1bc3889fe1993f597a61.png")

#### 添加成绩

活动创建者进入活动后台后，可以点击“成绩管理”

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134129_6ce835ae_1204709.png "1bb14532bbcf8d8b8a87990ea681a0d2.png")

输入用户编号、阶段、成绩，保存添加

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134148_1794d921_1204709.png "5a3b6401e19f835ec0377b1fc97f3622.png")

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134205_32cba017_1204709.png "1f79e9d9ed08866a744b74ac7d263cea.png")

还具备修改、删除功能

#### 发布活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134221_111182b8_1204709.png "6f86d33fd282285cccdff70a325f2609.png")

点击发起活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134236_f60a7601_1204709.png "cb5c37475619ddf53cd81af3efe86728.png")

点击底部的“发起”添加活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134250_59a8f8b1_1204709.png "072f73ff9fdce271d252a534d0a5a594.png")

此时活动为待审核状态，在我发起的活动中可以查看

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134301_8f82bf3f_1204709.png "2c49fddf40a674bb7adadc1711bc9465.png")

### 管理员

#### 审核活动

登陆admin账号（或其他role为9的账号）进入管理员页面/admin

可以在“活动审核”板块看到我们刚刚添加的活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134315_34771d6c_1204709.png "fea252cfa811041752ca068b44a7af9f.png")

点击“同意”后，活动显示已同意

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134324_95518e60_1204709.png "28c6dc4173a1a64cc9a3be80e27a5d93.png")

返回首页，已经显示了刚刚通过审核的活动

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134340_71c1407a_1204709.png "6cb965ebba460e660cd6f15ab86f0256.png")

#### 管理分类

5![输入图片说明](https://gitee.com/uploads/images/2018/0214/134359_25bcf24e_1204709.png "5e41afecdd2190fbd730691e915c4dcd.png")

添加分类“艺术类”，列表中多了“艺术类”

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134410_badbe47c_1204709.png "4e033efc25f3b48068dd39df6265081d.png")

首页的活动列表二级菜单中也添加了“艺术类”菜单

![输入图片说明](https://gitee.com/uploads/images/2018/0214/134423_f63ae864_1204709.png "40f02c9e7ba89d1c6613e683c3dcb0c5.png")
