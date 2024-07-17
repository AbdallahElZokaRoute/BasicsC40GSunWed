package com.route.basicsc40gsunwed.basics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.route.basicsc40gsunwed.R;

public class CalculatorActivity extends AppCompatActivity {
    // XO Game -> UI and Logic
    TextView resultTextView; // null
    Button buttonDot;

    String tempOperation = "";
    String LHS = "";

    boolean isEqualClick = false;
    boolean isDotClick = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator); // Inflation
        resultTextView = findViewById(R.id.result_text_view);
        buttonDot = findViewById(R.id.button_dot);

    }

    // 3 Functions ->
    // 11 -> onDigitClick()
    // 4 -> onOperationClick()
    // 1 -> onEqualClick
    // View -> Parent of all views
    // TextView
    // Button
    public void onDigitClick(View view) {
        if (view instanceof Button) {
            Button clickedOnButton = (Button) view; // casting
            String digit = clickedOnButton.getText().toString();
            if (resultTextView.getText().toString().length() < 10) {
                if (isDotClick == false && digit.equals(".")) {
                    isDotClick = true;
                    buttonDot.setEnabled(false);
                } else if (isDotClick && digit.equals(".")) {
                    return;
                }
                if (isEqualClick) {
                    resultTextView.setText(digit);
                    isEqualClick = false;
                } else {
                    resultTextView.append(digit);
                }
            }
        }
    }

    public void onOperationClick(View view) {
        if (view instanceof Button) {
            Button clickedOperation = (Button) view;
            String operation = clickedOperation.getText().toString();
            isDotClick = false;
            buttonDot.setEnabled(true);
            if (tempOperation.isEmpty()) { // first Case
                LHS = resultTextView.getText().toString();
                tempOperation = operation;
                resultTextView.setText("");
            } else {
                String RHS = resultTextView.getText().toString();
                if (!RHS.isEmpty()) {
                    LHS = calculate(LHS, tempOperation, RHS);
                    tempOperation = operation;
                    resultTextView.setText("");
                }
            }

        }
    }

    private String calculate(String lhs, String operation, String rhs) {
        double number1 = Double.parseDouble(lhs); // parsing -> String -> Data Type
        double number2 = Double.parseDouble(rhs);
        double result = 0.0;
        if (operation.equals("+")) {
            result = number1 + number2;
        } else if (operation.equals("-")) {
            result = number1 - number2;
        } else if (operation.equals("*")) {
            result = number1 * number2;

        } else if (operation.equals("/")) {
            if (number2 == 0.0)
                result = 0.0;
            else
                result = number1 / number2;

        }
        return result + "";

    }
    //50       - 20 = 30

    public void onEqualClick(View view) {
        String RHS = resultTextView.getText().toString();
        LHS = calculate(LHS, tempOperation, RHS);
        resultTextView.setText(LHS);
        LHS = "";
        tempOperation = "";
        isEqualClick = true;
        isDotClick = false;
    }
}

