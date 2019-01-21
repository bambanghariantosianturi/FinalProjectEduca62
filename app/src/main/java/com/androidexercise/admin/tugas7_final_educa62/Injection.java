package com.androidexercise.admin.tugas7_final_educa62;

import com.androidexercise.admin.tugas7_final_educa62.data.TeamRepository;
import com.androidexercise.admin.tugas7_final_educa62.data.local.TeamLocalDataSource;
import com.androidexercise.admin.tugas7_final_educa62.data.remote.TeamRemoteDataSource;

public class Injection {

    public static TeamRepository teamRepository(){
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource());
    }

}
