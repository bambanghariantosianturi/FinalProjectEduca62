package com.androidexercise.admin.tugas7_final_educa62.main;

import android.content.Context;

import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.List;

public interface ContractMain {

    interface View {
        void showProgress();

        void hideProgress();

        void showDataList(List<Team> TeamList);

        void showFailureMessage(String errMsg);
    }

    interface Presenter {
        void getDataList(Context context);
    }
}
