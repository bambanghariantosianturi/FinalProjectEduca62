package com.androidexercise.admin.tugas7_final_educa62.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {

    @SerializedName("teams")
    private List<Team> teamList;

    public TeamResponse(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "TeamResponse{" +
                "teamList=" + teamList +
                '}';
    }
}
