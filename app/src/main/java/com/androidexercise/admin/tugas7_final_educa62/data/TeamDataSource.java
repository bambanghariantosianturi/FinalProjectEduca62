package com.androidexercise.admin.tugas7_final_educa62.data;

import android.content.Context;

import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.List;

public interface TeamDataSource {

    void getListTeams(Context context, GetListTeamsCallback callback);

    interface GetListTeamsCallback {
        void onSuccess(List<Team> TeamList);
        void onFailure(String errMsg);
    }
}
