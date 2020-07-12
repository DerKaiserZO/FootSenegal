package com.example.footsenegal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.footsenegal.ui.ligue.LigueFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LigueActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private LayoutInflater layoutInflater;
    private BottomNavigationView bottomNavigationView;

    private static final String TAG = "ligue";

    private View ligueFramelayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*ligueFramelayout = findViewById(R.id.fragment_container_ligue);
        setContentView(ligueFramelayout);

        View root = getLayoutInflater().inflate(R.layout.fragment_ligue, null);

        bottomNavigationView = root.findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_team);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);*/

        /*FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_ligue);

        if (fragment == null) {
            fragment = new LigueFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "owkey");
        return true;
    }
}
