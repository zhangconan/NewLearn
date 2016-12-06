package com.zkn.newlearn.domain;

/**
 * Created by wb-zhangkenan on 2016/12/6.
 */
public class TeamInfoDomain {

    /**
     * id
     */
    private Long teamId;
    /**
     * 路径
     */
    private String teamPath;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamPath() {
        return teamPath;
    }

    public void setTeamPath(String teamPath) {
        this.teamPath = teamPath;
    }

    public TeamInfoDomain() {

    }

    public TeamInfoDomain(Long teamId, String teamPath) {
        this.teamId = teamId;
        this.teamPath = teamPath;
    }
}
