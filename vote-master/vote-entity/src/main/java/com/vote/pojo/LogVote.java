package com.vote.pojo;

import java.util.Date;

public class LogVote {
    private Integer id;

    private String name;

    private Date votetime;

    private String ip;

    private Integer vote;

    private Integer voteitem;

    private Integer type;

    private Integer enable;

    private Date createtime;

    public LogVote(Integer id, String name, Date votetime, String ip, Integer vote, Integer voteitem, Integer type, Integer enable, Date createtime) {
        this.id = id;
        this.name = name;
        this.votetime = votetime;
        this.ip = ip;
        this.vote = vote;
        this.voteitem = voteitem;
        this.type = type;
        this.enable = enable;
        this.createtime = createtime;
    }

    public LogVote() {
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

    public Date getVotetime() {
        return votetime;
    }

    public void setVotetime(Date votetime) {
        this.votetime = votetime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Integer getVoteitem() {
        return voteitem;
    }

    public void setVoteitem(Integer voteitem) {
        this.voteitem = voteitem;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}