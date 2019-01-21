package com.androidexercise.admin.tugas7_final_educa62.data.local;

import android.content.Context;

import com.androidexercise.admin.tugas7_final_educa62.data.TeamDataSource;

public class TeamLocalDataSource implements TeamDataSource {
    @Override
    public void getListTeams(Context context, GetListTeamsCallback callback) {
        TeamDatabase teamDatabase = TeamDatabase.createDatabase(context);

        if (teamDatabase.teamDao().selectAll() != null){
            callback.onSuccess(teamDatabase.teamDao().selectAll());
        } else callback.onFailure("Locale is empty!!!");
    }
}
