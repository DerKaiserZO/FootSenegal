package com.example.footsenegal.ui.ligue2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footsenegal.ApiClient;
import com.example.footsenegal.ApiInterface;
import com.example.footsenegal.R;
import com.example.footsenegal.models.equipe;
import com.example.footsenegal.ui.ligue.ListTeamsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListTeams2Fragment extends Fragment {
    private RecyclerView mTeamRecyclerView;
    private TeamAdapter mAdapter;
    private static final String TAG = "Equipe";
    ApiInterface apiInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_list_teams, container, false);

        Retrofit retrofit = ApiClient.getClient();

        apiInterface = retrofit.create(ApiInterface.class);

        mTeamRecyclerView = root.findViewById(R.id.list_team_recycler_view);
        mTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        try {
            Call<List<equipe>> call = apiInterface.getListEquipeLigue(2);
            call.enqueue(new Callback<List<equipe>>() {
                @Override
                public void onResponse(Call<List<equipe>> call, Response<List<equipe>> response) {
                    Log.d(TAG, "onResponse " + response.body());
                    updateUI(response.body());
                }

                @Override
                public void onFailure(Call<List<equipe>> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getLocalizedMessage());
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return root;
    }
    private class TeamHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;

        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    private class TeamAdapter extends RecyclerView.Adapter<TeamHolder>{
        private List<equipe> mEquipes;

        private TeamAdapter(List<equipe> e){
            mEquipes = e;
        }

        @NonNull
        @Override
        public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new TeamHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
            equipe equipe = mEquipes.get(position);
            holder.mTitleTextView.setText(equipe.getNom());
        }

        @Override
        public int getItemCount() {
            return mEquipes.size();
        }
    }

    private void updateUI(List<equipe> equipes) {
        mAdapter = new TeamAdapter(equipes);
        mTeamRecyclerView.setAdapter(mAdapter);
    }
}
