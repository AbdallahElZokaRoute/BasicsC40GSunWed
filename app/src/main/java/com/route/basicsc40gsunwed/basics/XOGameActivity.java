package com.route.basicsc40gsunwed.basics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.route.basicsc40gsunwed.R;

import java.util.ArrayList;
// Context -> Parent
// Activity -> Child

public class XOGameActivity extends AppCompatActivity {
    int counter = 0;
    int player1Score = 0;
    int player2Score = 0;
    TextView player1ScoreTextView; // null
    TextView player2ScoreTextView; // null
    ArrayList<String> boardState;
    ConstraintLayout rootLayout;
    // Task
    // Task Updated with recycler View


    //     Practice  -> Recycler View
    //                               Timeline of facebook
    //                               Contacts of whatsapp
    //                               Chats of Whatsapp
    // Recycler View   -------->
    // Kotlin -> Recycler View

    // RecyclerView OnItemClicks (interface callback) + Git + Github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xogame);
        boardState = new ArrayList<>();
        player1ScoreTextView = findViewById(R.id.player_1_score);
        player2ScoreTextView = findViewById(R.id.player_2_score);
        rootLayout = findViewById(R.id.root_constraint_element);
        initializeBoardState();
    }
    // Islami
    // To Do


    // //    ["X", "O", "",
// //     "X", "O", "X",
////     "", "O", "", "" , "" , ""
////            ]
    private void initializeBoardState() {
        boardState.clear();
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            View view = rootLayout.getChildAt(i);
            if (view instanceof Button) {
                Button button = (Button) view;
                button.setText("");
            }
        }
    }

    private void putPlayerCodeInBoardState(int buttonId, String playerCode) {
        if (buttonId == R.id.button_0) {
            boardState.set(0, playerCode);
        } else if (buttonId == R.id.button_1) {
            boardState.set(1, playerCode);
        } else if (buttonId == R.id.button_2) {
            boardState.set(2, playerCode);
        } else if (buttonId == R.id.button_3) {
            boardState.set(3, playerCode);
        } else if (buttonId == R.id.button_4) {
            boardState.set(4, playerCode);
        } else if (buttonId == R.id.button_5) {
            boardState.set(5, playerCode);
        } else if (buttonId == R.id.button_6) {
            boardState.set(6, playerCode);
        } else if (buttonId == R.id.button_7) {
            boardState.set(7, playerCode);
        } else if (buttonId == R.id.button_8) {
            boardState.set(8, playerCode);
        }
    }

    private boolean checkWinner(String playerCode) {
        // Check Columns
        for (int i = 0; i < 3; i++)
            if (
                    boardState.get(i).equals(playerCode) &&
                            boardState.get(i + 3).equals(playerCode) &&
                            boardState.get(i + 6).equals(playerCode)
            )
                return true;

        // Check Rows
        for (int i = 0; i < 9; i += 3)
            if (
                    boardState.get(i).equals(playerCode) &&
                            boardState.get(i + 1).equals(playerCode) &&
                            boardState.get(i + 2).equals(playerCode)
            )
                return true;

        // Check Diagonal
        if (boardState.get(0).equals(playerCode) &&
                boardState.get(4).equals(playerCode) &&
                boardState.get(8).equals(playerCode))
            return true;
        if (boardState.get(2).equals(playerCode) &&
                boardState.get(4).equals(playerCode) &&
                boardState.get(6).equals(playerCode)
        )
            return true;

        return false;
    }

    public void onPlayerClick(View view) {
        if (view instanceof Button) {
            Button clickedButton = (Button) view;
//            clickedButton.setEnabled(false);
            if (!clickedButton.getText().toString().isEmpty())
                return;
            if (counter % 2 == 0) {
                // X
                clickedButton.setText("X"); //  X  =>  58
                putPlayerCodeInBoardState(clickedButton.getId(), "X");
            } else {
                // O
                clickedButton.setText("O");
                putPlayerCodeInBoardState(clickedButton.getId(), "O");
            }
            counter++;

            if (checkWinner("X")) {
                // X wins (Player 1 )
                player1Score += 5;
                player1ScoreTextView.setText(player1Score + "");
                initializeBoardState();
                counter = 0;
                // Context
                Toast.makeText(this, "Player 1 (X) Wins!", Toast.LENGTH_LONG).show();
            } else if (checkWinner("O")) {
                // O Wins (Player 2 )
                player2Score += 5;
                counter = 0;
                player2ScoreTextView.setText(player2Score + "");
                initializeBoardState();
                Toast.makeText(this, "Player 2 (O) Wins!", Toast.LENGTH_LONG).show();
            } else if (counter == 9) {
                // Draw
                Toast.makeText(this, "Draw !", Toast.LENGTH_LONG).show();
                player1Score += 2;
                player2Score += 2;
                counter = 0;
                player1ScoreTextView.setText(player1Score + "");
                player2ScoreTextView.setText(player2Score + "");
                initializeBoardState();
            }

        }
    }
}