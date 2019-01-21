package com.androidexercise.admin.tugas7_final_educa62.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidexercise.admin.tugas7_final_educa62.R;
import com.androidexercise.admin.tugas7_final_educa62.model.Team;
import com.androidexercise.admin.tugas7_final_educa62.ui.DetailTeamActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.BamsHolder> {

    private Context context;
    private List<Team> teams;

    public TeamAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @NonNull
    @Override
    public BamsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_team,
                viewGroup,
                false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new BamsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BamsHolder bamsHolder, int i) {
        final Team team = teams.get(i);

        Glide.with(context)
                .load(team.getStrTeamBadge())
                .into(bamsHolder.imageView);
        bamsHolder.textView.setText(team.getStrTeam());

        bamsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail = new Intent(context, DetailTeamActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("team_name", team.getStrTeam());
                bundle.putString("team_desc", team.getStrDescriptionEN());
                bundle.putString("stadium_name", team.getStrStadium());
                bundle.putString("stadium_loc", team.getStrStadiumLocation());
                bundle.putString("team_pic", team.getStrTeamBadge());
                bundle.putString("stadium_pict", team.getStrStadiumThumb());
                intentDetail.putExtras(bundle);
                context.startActivity(intentDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    class BamsHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public BamsHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_team_badge);
            textView = itemView.findViewById(R.id.tv_name_team);
        }
    }
}
