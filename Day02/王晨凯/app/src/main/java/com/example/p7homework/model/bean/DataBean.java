package com.example.p7homework.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DataBean {
    @Id(autoincrement = true)
    private Long mid;
            /**
             * id : 61
             * icon : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/icon_etpack.png
             * background : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/1111.png
             * activityIcon : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png
             * title : 2019高光时刻
             * intro : 2019年那些事,有哪些最让你怀念呢？
             * feedNum : 100
             * tagId : 1
             * enterNum : 1000
             * followNum : 100
             * hasFollow : false
             */

            private int id;
            private String icon;
            private String background;
            private String activityIcon;
            private String title;
            private String intro;
            private int feedNum;
            private int tagId;
            private int enterNum;
            private int followNum;
            private boolean hasFollow;

            @Generated(hash = 677349592)
            public DataBean(Long mid, int id, String icon, String background, String activityIcon, String title,
                    String intro, int feedNum, int tagId, int enterNum, int followNum, boolean hasFollow) {
                this.mid = mid;
                this.id = id;
                this.icon = icon;
                this.background = background;
                this.activityIcon = activityIcon;
                this.title = title;
                this.intro = intro;
                this.feedNum = feedNum;
                this.tagId = tagId;
                this.enterNum = enterNum;
                this.followNum = followNum;
                this.hasFollow = hasFollow;
            }

            @Generated(hash = 908697775)
            public DataBean() {
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getBackground() {
                return background;
            }

            public void setBackground(String background) {
                this.background = background;
            }

            public String getActivityIcon() {
                return activityIcon;
            }

            public void setActivityIcon(String activityIcon) {
                this.activityIcon = activityIcon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getFeedNum() {
                return feedNum;
            }

            public void setFeedNum(int feedNum) {
                this.feedNum = feedNum;
            }

            public int getTagId() {
                return tagId;
            }

            public void setTagId(int tagId) {
                this.tagId = tagId;
            }

            public int getEnterNum() {
                return enterNum;
            }

            public void setEnterNum(int enterNum) {
                this.enterNum = enterNum;
            }

            public int getFollowNum() {
                return followNum;
            }

            public void setFollowNum(int followNum) {
                this.followNum = followNum;
            }

            public boolean isHasFollow() {
                return hasFollow;
            }

            public void setHasFollow(boolean hasFollow) {
                this.hasFollow = hasFollow;
            }

            public Long getMid() {
                return this.mid;
            }

            public void setMid(Long mid) {
                this.mid = mid;
            }

            public boolean getHasFollow() {
                return this.hasFollow;
            }
        }