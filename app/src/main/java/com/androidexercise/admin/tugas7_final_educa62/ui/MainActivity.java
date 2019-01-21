package com.androidexercise.admin.tugas7_final_educa62.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.androidexercise.admin.tugas7_final_educa62.Injection;
import com.androidexercise.admin.tugas7_final_educa62.R;
import com.androidexercise.admin.tugas7_final_educa62.adapter.TeamAdapter;
import com.androidexercise.admin.tugas7_final_educa62.main.ContractMain;
import com.androidexercise.admin.tugas7_final_educa62.main.Presenter;
import com.androidexercise.admin.tugas7_final_educa62.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContractMain.View {

    RecyclerView recyclerView;

    ProgressDialog progressDialog;
    private List<Team> teamList = new ArrayList<>();
    private TeamAdapter teamAdapter;
    private Presenter presenter = new Presenter(this, Injection.teamRepository());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_team);
        teamAdapter = new TeamAdapter(this, teamList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        presenter.getDataList(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(teamAdapter);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<Team> TeamList) {
        this.teamList.addAll(TeamList);
        teamAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String errMsg) {
        Toast.makeText(this, "Cannot load " + errMsg, Toast.LENGTH_LONG).show();
    }
}
