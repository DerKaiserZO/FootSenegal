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
import com.example.footsenegal.models.scoreMatch;
import com.example.footsenegal.ui.ligue.ListResultsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListResults2Fragment extends Fragment {

    private RecyclerView mTeamRecyclerView;
    private static final String TAG = "Matchs Results";
    MatchResultAdapter mAdapter;
    ApiInterface apiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_list_results, container, false);

        Retrofit retrofit = ApiClient.getClient();

        apiInterface = retrofit.create(ApiInterface.class);

        mTeamRecyclerView = root.findViewById(R.id.list_result_match_recycler_view);
        mTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        try {
            Call<List<scoreMatch>> call = apiInterface.getListMatchsResultsLigue(2);
            call.enqueue(new Callback<List<scoreMatch>>() {
                @Override
                public void onResponse(Call<List<com.example.footsenegal.models.scoreMatch>> call, Response<List<scoreMatch>> response) {
                    updateUI(response.body());
                    Log.d(TAG, "onResponse " + response.body());
                }

                @Override
                public void onFailure(Call<List<com.example.footsenegal.models.scoreMatch>> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getLocalizedMessage());
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return root;
    }
    private class MatchResultHolder extends RecyclerView.ViewHolder {

        private TextView mTeamFirst;
        private TextView mTeamSecond;
        private TextView mScoreFirst;
        private TextView mScoreSecond;
        private com.example.footsenegal.models.scoreMatch mMatch;

        public void BindMatch(com.example.footsenegal.models.scoreMatch match){
            mMatch = match;
            mTeamFirst.setText(match.getTeam_first());
            mTeamSecond.setText(match.getTeam_second());
            mScoreFirst.setText(Integer.toString(match.getScore_first()));
            mScoreSecond.setText(Integer.toString(match.getScore_second()));
        }

        public MatchResultHolder(@NonNull View itemView) {
            super(itemView);
            mTeamFirst = (TextView) itemView.findViewById(R.id.team_first);
            mTeamSecond = (TextView) itemView.findViewById(R.id.team_second);
            mScoreFirst = (TextView) itemView.findViewById(R.id.score_first);
            mScoreSecond = (TextView) itemView.findViewById(R.id.score_second);
        }
    }

    private class MatchResultAdapter extends RecyclerView.Adapter<MatchResultHolder>{
        private List<com.example.footsenegal.models.scoreMatch> mMatchs;

        private MatchResultAdapter(List<com.example.footsenegal.models.scoreMatch> m){
            mMatchs = m;
        }


        @NonNull
        @Override
        public MatchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_result, parent, false);
            return new MatchResultHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MatchResultHolder holder, int position) {
            com.example.footsenegal.models.scoreMatch match = mMatchs.get(position);
            holder.BindMatch(match);
        }

        @Override
        public int getItemCount() {
            return mMatchs.size();
        }
    }

    private void updateUI(List<com.example.footsenegal.models.scoreMatch> matches) {
        mAdapter = new MatchResultAdapter(matches);
        mTeamRecyclerView.setAdapter(mAdapter);
    }
}
