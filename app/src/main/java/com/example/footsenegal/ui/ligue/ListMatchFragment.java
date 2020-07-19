package com.example.footsenegal.ui.ligue;

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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMatchFragment extends Fragment {

    private RecyclerView mTeamRecyclerView;
    private static final String TAG = "Matchs";
    private MatchAdapter mAdapter;
    ApiInterface apiInterface;
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_list_matchs, container, false);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        mTeamRecyclerView = root.findViewById(R.id.list_match_recycler_view);
        mTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        try {
            Call<List<com.example.footsenegal.models.match>> call = apiInterface.getListMatchsLigue1();
            call.enqueue(new Callback<List<com.example.footsenegal.models.match>>() {
                @Override
                public void onResponse(Call<List<com.example.footsenegal.models.match>> call, Response<List<com.example.footsenegal.models.match>> response) {
                    updateUI(response.body());
                    Log.d(TAG, "onResponse " + response.body());
                }

                @Override
                public void onFailure(Call<List<com.example.footsenegal.models.match>> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getLocalizedMessage());
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return root;
    }

    private class MatchHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    private class MatchAdapter extends RecyclerView.Adapter<MatchHolder>{
        private List<com.example.footsenegal.models.match> mMatchs;

        private MatchAdapter(List<com.example.footsenegal.models.match> m){
            mMatchs = m;
        }


        @NonNull
        @Override
        public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MatchHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MatchHolder holder, int position) {
            com.example.footsenegal.models.match match = mMatchs.get(position);
            holder.mTitleTextView.setText(match.getTeam_first()+ " VS "+ match.getTeam_second());
        }

        @Override
        public int getItemCount() {
            return mMatchs.size();
        }
    }

    private void updateUI(List<com.example.footsenegal.models.match> matches) {
        mAdapter = new MatchAdapter(matches);
        mTeamRecyclerView.setAdapter(mAdapter);
    }
}
