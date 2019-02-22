package com.vote.pojo;

import java.util.Date;

public class VoteItem {
    private Integer id;

    private String name;

    private String description;

    private String img;

    private Integer ballot;

    private Date modifytime;

    private Date createtime;

    private Integer enable;

    private Integer parent;

    @Override
    public String toString() {
        return "VoteItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", ballot=" + ballot +
                ", modifytime=" + modifytime +
                ", createtime=" + createtime +
                ", enable=" + enable +
                ", parent=" + parent +
                '}';
    }

    public VoteItem(Integer id, String name, String description, String img, Integer ballot, Date modifytime, Date createtime, Integer enable, Integer parent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.ballot = ballot;
        this.modifytime = modifytime;
        this.createtime = createtime;
        this.enable = enable;
        this.parent = parent;
    }

    public VoteItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getBallot() {
        return ballot;
    }

    public void setBallot(Integer ballot) {
        this.ballot = ballot;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}