package com.route.basicsc40gsunwed.basics;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.route.basicsc40gsunwed.R;

public class MainActivity extends AppCompatActivity {
    Button navigateToCalculatorButton;
    Button navigateToXOGameButton;
    Button navigateToLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle", "onCreate");
        initViews();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle", "onStart");
        // Views are Visible but not interactable
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Views are visible and interactable
        Log.e("LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Activity is Partially visible
        // TrueCaller dialog
        Log.e("LifeCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Activity is Completely invisible
        Log.e("LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle", "onDestroy");
        // Activity is destroyed
    }
    // Music ->
    // Pause
    // Resume

    private void initViews() {
        navigateToCalculatorButton = findViewById(R.id.open_calculator_button);
        navigateToXOGameButton = findViewById(R.id.open_xo_game_button);
        navigateToLoginButton = findViewById(R.id.open_login_button);
        // Intent ->   navigate between activites in same app
//                     navigate between 2 apps
        // 0106465122
        //  Gmail -> mohamed@route.com
//                     Hello World
        navigateToCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate To Calculator
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });
        navigateToXOGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToXOGame();
            }
        });
        navigateToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void navigateToXOGame() {
        // this or MainActivity.this
        Intent intent = new Intent(this, XOGameActivity.class);
        startActivity(intent);
    }

}