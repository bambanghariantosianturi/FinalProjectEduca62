package com.androidexercise.admin.tugas7_final_educa62.main;

import android.content.Context;

import com.androidexercise.admin.tugas7_final_educa62.data.TeamDataSource;
import com.androidexercise.admin.tugas7_final_educa62.data.TeamRepository;
import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.List;

public class Presenter implements ContractMain.Presenter {

    private final ContractMain.View view;
    private final TeamRepository teamRepository;

    public Presenter(ContractMain.View view, TeamRepository teamRepository) {
        this.view = view;
        this.teamRepository = teamRepository;
    }

    @Override
    public void getDataList(Context context) {
        view.showProgress();
        teamRepository.getListTeams(context, new TeamDataSource.GetListTeamsCallback() {
            @Override
            public void onSuccess(List<Team> TeamList) {
                view.hideProgress();
                view.showDataList(TeamList);
            }

            @Override
            public void onFailure(String errMsg) {
                view.hideProgress();
                view.showFailureMessage(errMsg);
            }
        });
    }
}
