package com.example.wuqi.model.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ConcernBean {
    @Id
    private Long mId;
    private String icon;
    private String title;
    private String content;
    @Generated(hash = 1393929190)
    public ConcernBean(Long mId, String icon, String title, String content) {
        this.mId = mId;
        this.icon = icon;
        this.title = title;
        this.content = content;
    }
    @Generated(hash = 51149824)
    public ConcernBean() {
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
