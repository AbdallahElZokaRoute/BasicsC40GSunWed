package com.route.basicsc40gsunwed.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.route.basicsc40gsunwed.R;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    RecyclerView settingsRecyclerView;
    SettingsAdapter adapter;
    ArrayList<SettingsItem> settingsList;

    // kotlin :- Programming Language -> Apps
    // Kotlin -> RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settingsRecyclerView = findViewById(R.id.settings_recycler_view);
//        settingsRecyclerView.setLayoutManager();
        createSettingsData();
        // Create an object from adapter
        adapter = new SettingsAdapter(settingsList);
        settingsRecyclerView.setAdapter(adapter);
        // Practice =>
    }

    private void createSettingsData() {
        settingsList = new ArrayList<>();
        settingsList.add(new SettingsItem("Wifi & Settings", "Wifi and settings and hotspot and mobile data options ", R.drawable.ic_wifi));
        settingsList.add(new SettingsItem("Apps", "Apps settings and its storage settings", R.drawable.ic_apps));
        settingsList.add(new SettingsItem("Airplane mode", "Disable network and communication services", R.drawable.ic_airplane));
        settingsList.add(new SettingsItem("Accessibility", "Accessibility settings and voice instructions", R.drawable.ic_accessibility));
        for (int i = 0; i < 1000; i++) {
            settingsList.add(new SettingsItem("Wifi & Settings number " + i, "Wifi and settings and hotspot and mobile data options & its number " + i, R.drawable.ic_wifi));
        }


    }


}

// Islami project
// To Do Project
//             kotlin -> XML  -> Recycler View

// News App             -> Jetpack compose -> LazyRow
// Chat App             -> Jetpack compose -> LazyColumn

// Singleton
// Builder
// Factory
// Observer
// Adapter


// SOLID Design Principles