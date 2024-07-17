package com.route.basicsc40gsunwed

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.route.basicsc40gsunwed.fragments.ChatsFragment
import com.route.basicsc40gsunwed.fragments.StatusFragment

class HomeActivity : AppCompatActivity() {
    lateinit var chatsTextView: TextView
    lateinit var statusTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        chatsTextView = findViewById(R.id.chats_text_view)
        statusTextView = findViewById(R.id.status_text_view)
        chatsTextView.setOnClickListener {
            pushFragment(ChatsFragment())
        }
        statusTextView.setOnClickListener {
            pushFragment(StatusFragment())
        }
        // Do Some development Stuff
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
    // Background -> Red   1.0
    // Background and theme => Green -> 1.1
    // Background -> Red   1.0
    //   9 Persons ->

    //             1- Login
    //             2- Home
    //             3- Profile

    // Git  & Github
    // Repository -> Stores the code and its changes

    // Local Repository -> Repository on PC / Laptop
    // Remote Repository -> Repository on Server -> Github - Gitlab - Bitbucket
    // Commit -> Save the states with a certain message


    // Git :-
    //          1- tracked
    //          2- ignored
    //          3- UnTracked
}