package com.vote.pojo;

import java.util.Date;

public class Vote {
    private Integer id;

    private String name;

    private Date starttime;

    private Date endtime;

    private String headimg;

    private String linkurl;

    private Integer ecreator;

    private Integer ballotsum;

    private Integer itemnum;

    private Integer visitcapacity;

    private Date modifytime;

    private Date createtime;

    private Integer enable;

    private String description;

    public Vote(Integer id, String name, Date starttime, Date endtime, String headimg, String linkurl, Integer ecreator, Integer ballotsum, Integer itemnum, Integer visitcapacity, Date modifytime, Date createtime, Integer enable, String description) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.headimg = headimg;
        this.linkurl = linkurl;
        this.ecreator = ecreator;
        this.ballotsum = ballotsum;
        this.itemnum = itemnum;
        this.visitcapacity = visitcapacity;
        this.modifytime = modifytime;
        this.createtime = createtime;
        this.enable = enable;
        this.description = description;
    }

    public Vote() {
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public Integer getEcreator() {
        return ecreator;
    }

    public void setEcreator(Integer ecreator) {
        this.ecreator = ecreator;
    }

    public Integer getBallotsum() {
        return ballotsum;
    }

    public void setBallotsum(Integer ballotsum) {
        this.ballotsum = ballotsum;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }

    public Integer getVisitcapacity() {
        return visitcapacity;
    }

    public void setVisitcapacity(Integer visitcapacity) {
        this.visitcapacity = visitcapacity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}