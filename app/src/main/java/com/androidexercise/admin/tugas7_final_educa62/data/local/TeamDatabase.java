package com.androidexercise.admin.tugas7_final_educa62.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.androidexercise.admin.tugas7_final_educa62.model.Team;

@Database(entities = Team.class, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    public abstract TeamDao teamDao();

    private static TeamDatabase INSTANCE;

    public static TeamDatabase createDatabase(Context context){
        synchronized (TeamDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, TeamDatabase.class, "db_team").allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }
}
