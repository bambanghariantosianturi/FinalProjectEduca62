package com.androidexercise.admin.tugas7_final_educa62.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidexercise.admin.tugas7_final_educa62.R;
import com.bumptech.glide.Glide;

public class DetailTeamActivity extends AppCompatActivity {

    ImageView imgBackground;
    TextView tvStadiumName;
    TextView tvYear;
    TextView tvStadiumLocation;
    ImageView teamBage;
    TextView tvNameTeam;
    TextView tvTeamDesc;

    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        imgBackground = findViewById(R.id.img_background_detail);
        tvStadiumName = findViewById(R.id.tv_stadium_name);
        tvStadiumLocation = findViewById(R.id.tv_stadium_location);
        teamBage = findViewById(R.id.team_badge);
        tvNameTeam = findViewById(R.id.tv_name_team);
        tvTeamDesc = findViewById(R.id.tv_team_desc);

        bundle = getIntent().getExtras();
        String teamName = bundle.getString("team_name");
        String teamDesc = bundle.getString("team_desc");
        String stadiumName = bundle.getString("stadium_name");
        String stadiumLoc = bundle.getString("stadium_loc");
        String teamPic = bundle.getString("team_pic");
        String stadiumPict = bundle.getString("stadium_pict");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(teamName);

        if (actionBar != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this)
                .load(stadiumPict)
                .into(imgBackground);

        Glide.with(this)
                .load(teamPic)
                .into(teamBage);

        tvStadiumName.setText(stadiumName);
        tvStadiumLocation.setText(stadiumLoc);
        tvNameTeam.setText(teamName);
        tvTeamDesc.setText(teamDesc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
