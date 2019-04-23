package com.androidexercise.admin.tugas7_final_educa62.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.androidexercise.admin.tugas7_final_educa62.data.local.TeamDatabase;
import com.androidexercise.admin.tugas7_final_educa62.data.local.TeamLocalDataSource;
import com.androidexercise.admin.tugas7_final_educa62.data.remote.TeamRemoteDataSource;
import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.List;

public class TeamRepository implements TeamDataSource {

    private final TeamRemoteDataSource teamRemoteDataSource;
    private final TeamLocalDataSource teamLocalDataSource;
    private TeamDatabase teamDatabase;

    public TeamRepository(TeamRemoteDataSource teamRemoteDataSource, TeamLocalDataSource teamLocalDataSource) {
        this.teamRemoteDataSource = teamRemoteDataSource;
        this.teamLocalDataSource = teamLocalDataSource;
    }

    @Override
    public void getListTeams(Context context, final GetListTeamsCallback callback) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        teamDatabase = TeamDatabase.createDatabase(context);

        if (teamDatabase.teamDao().selectAll().size() != 0){
            Toast.makeText(context, "Use Locale Database!!!", Toast.LENGTH_LONG).show();
            teamLocalDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Team> TeamList) {
                    callback.onSuccess(TeamList);
                }

                @Override
                public void onFailure(String errMsg) {
                    callback.onFailure(errMsg);
                }
            });
        } else if (networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(context, "Use Remote Source", Toast.LENGTH_LONG).show();
            teamRemoteDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Team> TeamList) {
                    callback.onSuccess(TeamList);
                    teamDatabase.teamDao().insertTeam(TeamList);
                }

                @Override
                public void onFailure(String errMsg) {
                    callback.onFailure(errMsg);
                }
            });
        } else {
            callback.onFailure("......");
        }
    }
}
