package com.androidexercise.admin.tugas7_final_educa62.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.List;

@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeam(List<Team> teamList);

    @Query("SELECT * FROM team ORDER BY idTeam ASC")
    List<Team> selectAll();

}
