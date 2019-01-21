package com.androidexercise.admin.tugas7_final_educa62.data.remote;

import com.androidexercise.admin.tugas7_final_educa62.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_all_teams.php")
    Call<TeamResponse> getTeamList(
            @Query("s") String s,
            @Query("c") String c
    );
}
