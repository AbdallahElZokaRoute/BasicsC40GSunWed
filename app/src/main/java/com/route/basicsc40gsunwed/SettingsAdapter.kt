package com.route.basicsc40gsunwed

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SettingsAdapter(
    val settingsList: List<SettingsItem>?,
) : Adapter<SettingsAdapter.SettingsViewHolder>() {
    // TimeLine Recycler View  and Stories Recycler View
    // 2
    var onItemClickListener: OnSettingsItemClickListener? = null
    var onImageClickListener: OnSettingsItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_settings, parent, false)
        return SettingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return settingsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val item = settingsList?.get(position)
        holder.iconSettings.setImageResource(item?.icon ?: R.drawable.ic_apps)
        holder.title.text = item?.title
        holder.description.text = item?.description
        // Adapter -> onBindViewHolder -> Handle on Click Listener
        // handle on Click listener inside adapter ?
        // 1- Context  -> memory leak
        // 2- Reusability ->
        // 3- Single Responsibility Principle -> SOLID Design Principles

        holder.itemView.setOnClickListener {
            // interface callback         -          Delegate
            onItemClickListener?.onSettingsItemClick(item!!, position)
        }
        if (onImageClickListener != null)
            holder.iconSettings.setOnClickListener {
                onImageClickListener?.onSettingsItemClick(item!!, position)
            }
    }

    class SettingsViewHolder(val itemSettingsView: View) : ViewHolder(itemSettingsView) {
        val iconSettings: ImageView = itemSettingsView.findViewById(R.id.settings_image)
        val title = itemSettingsView.findViewById<TextView>(R.id.settings_title)
        val description = itemSettingsView.findViewById<TextView>(R.id.settings_description)
    }
}
