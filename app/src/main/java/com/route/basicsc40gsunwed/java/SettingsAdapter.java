package com.route.basicsc40gsunwed.java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.route.basicsc40gsunwed.R;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {
    // Create Data Class SettingsItem (5 )
    private ArrayList<SettingsItem> settingsList; // null

    // 6
    public SettingsAdapter(ArrayList<SettingsItem> settingsList) {
        this.settingsList = settingsList;
    }

    // 8
    @NonNull
    @Override                                       // ViewGroup -> RecyclerView
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout Inflater -> Create a View in Runtime
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_settings, parent, false);
        return new SettingsViewHolder(view);
    }

    // 9
    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {
        SettingsItem item = settingsList.get(position); // item
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.settingsIcon.setImageResource(item.getImage());

    }

    // 7
    @Override
    public int getItemCount() {
        if (settingsList == null) // validation => settingsList == null -> return 0 ;
            return 0;
        return settingsList.size();
    }

    class SettingsViewHolder extends RecyclerView.ViewHolder {
        // 4
        ImageView settingsIcon; // null
        TextView title;// null
        TextView description; // null

        public SettingsViewHolder(View itemView) {
            super(itemView);
            settingsIcon = itemView.findViewById(R.id.settings_image);
            title = itemView.findViewById(R.id.settings_title);
            description = itemView.findViewById(R.id.settings_description);
        }
    }
}
