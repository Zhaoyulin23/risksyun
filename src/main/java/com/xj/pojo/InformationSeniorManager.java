package com.xj.pojo;

import java.util.Date;

public class InformationSeniorManager {
    private Integer ismId;

    private Integer seId;

    private String name;

    private String position;

    private Date birthday;

    private String resume;

    private Date dismissionDate;

    public Integer getIsmId() {
        return ismId;
    }

    public void setIsmId(Integer ismId) {
        this.ismId = ismId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    public Date getDismissionDate() {
        return dismissionDate;
    }

    public void setDismissionDate(Date dismissionDate) {
        this.dismissionDate = dismissionDate;
    }
}