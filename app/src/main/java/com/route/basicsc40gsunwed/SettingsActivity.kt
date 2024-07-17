package com.route.basicsc40gsunwed

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SettingsActivity : AppCompatActivity() {
    // Activity -> Context
    lateinit var adapter: SettingsAdapter
    lateinit var settingsRecyclerView: RecyclerView
    lateinit var settingsList: MutableList<SettingsItem>

    // Assignment # 3 (Facebook timeline & Stories )

    // Recycler View On Item Clicks (interface callback - delegate)
    // Fragments
    // Git & Github (Version Control Systems)
    //
    // Projects ->
    // Sunday Session -> Route ->    3 Courses
    //                         Recycler

    // Islami
    // Inefficient
    // Scroll View (Orientation => Vertical )


    // Kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        settingsRecyclerView = findViewById(R.id.settings_recycler_view)
        createList()
        adapter = SettingsAdapter(settingsList)
        // 4
        adapter.onItemClickListener = object : OnSettingsItemClickListener {
            override fun onSettingsItemClick(item: SettingsItem, position: Int) {
                // Do your work (Logic)
                val intent = Intent(this@SettingsActivity, SettingsDetailsActivity::class.java)
                // image and title
                intent.putExtra("title", item.title)
                intent.putExtra("icon", item.icon)
                startActivity(intent)
            }
        }
        adapter.onImageClickListener = object : OnSettingsItemClickListener {
            override fun onSettingsItemClick(item: SettingsItem, position: Int) {
                Toast.makeText(
                    this@SettingsActivity,
                    "You Clicked on ${item.title} Settings",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        settingsRecyclerView.adapter = adapter
    }

    fun createList() {
        // Immutable List
        settingsList = mutableListOf()
        settingsList.add(
            SettingsItem(
                title = "Wifi & Settings",
                description = "Wifi and settings and hotspot and mobile data options ",
                icon = R.drawable.ic_wifi
            )
        )
        settingsList.add(
            SettingsItem(
                title = "Apps",
                description = "Apps settings and its storage settings",
                icon = R.drawable.ic_apps
            )
        )
        settingsList.add(
            SettingsItem(
                title = "Airplane mode",
                description = "Disable network and communication services",
                icon = R.drawable.ic_airplane
            )
        )
        settingsList.add(
            SettingsItem(
                title = "Accessibility",
                description = "Accessibility settings and voice instructions",
                icon = R.drawable.ic_accessibility
            )
        )

        for (i in 0..999) {
            settingsList.add(
                SettingsItem(
                    title = "Wifi & Settings number $i",
                    description = "Wifi and settings and hotspot and mobile data options & its number $i",
                    icon = R.drawable.ic_wifi
                )
            )
        }

    }

}


//Settings Activity (Java) ->  R.layout.activity_settings
//Settings Activity (Kotlin) -> R.layout.activity_settings