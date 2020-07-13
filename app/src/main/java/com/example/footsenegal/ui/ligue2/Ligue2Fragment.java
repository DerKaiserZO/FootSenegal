package com.example.footsenegal.ui.ligue2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.footsenegal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ligue2Fragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    private ListTeams2Fragment listTeamsFragment;

    private static final String TAG = "ligue";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ligue, container, false);

        bottomNavigationView = root.findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_team);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_ligue, new ListTeams2Fragment())
                .commit();


        return root;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "owkey");
        switch (item.getItemId()){
            case R.id.bottom_nav_team: {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_ligue, new ListTeams2Fragment())
                        .commit();
                return true;
            }
            case R.id.bottom_nav_matchs: {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_ligue, new ListMatch2Fragment())
                        .commit();
                return true;
            }
            case R.id.bottom_nav_result: {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_ligue, new ListResults2Fragment())
                        .commit();
                return true;
            }
        }
        return false;
    }
}