package com.androidexercise.admin.tugas7_final_educa62.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "team")
public class Team {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    private int idTeam;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String strTeam;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String strStadium;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String strStadiumThumb;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String strStadiumDescription;

    @ColumnInfo(name = "strStadiumLocation")
    @SerializedName("strStadiumLocation")
    private String strStadiumLocation;

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    public Team(int idTeam, String strTeamBadge, String strTeam, String strStadium, String strStadiumThumb, String strStadiumDescription, String strStadiumLocation, String strDescriptionEN) {
        this.idTeam = idTeam;
        this.strTeamBadge = strTeamBadge;
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strStadiumThumb = strStadiumThumb;
        this.strStadiumDescription = strStadiumDescription;
        this.strStadiumLocation = strStadiumLocation;
        this.strDescriptionEN = strDescriptionEN;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }
}
