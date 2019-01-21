package com.androidexercise.admin.tugas7_final_educa62.data.remote;

import com.androidexercise.admin.tugas7_final_educa62.main.Contract;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Contract.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }
}
