package com.androidexercise.admin.tugas7_final_educa62.data.remote;

import android.content.Context;
import android.widget.Toast;

import com.androidexercise.admin.tugas7_final_educa62.data.TeamDataSource;
import com.androidexercise.admin.tugas7_final_educa62.main.Contract;
import com.androidexercise.admin.tugas7_final_educa62.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamRemoteDataSource implements TeamDataSource {

    private final ApiInterface api = ApiClient.getRetrofit().create(ApiInterface.class);

    @Override
    public void getListTeams(final Context context, final GetListTeamsCallback callback) {
        Call<TeamResponse> call = api.getTeamList(Contract.FOOTBALL, Contract.COUNTRY);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getTeamList());
                    Toast.makeText(context, "Test Success", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
                Toast.makeText(context, "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }
}
