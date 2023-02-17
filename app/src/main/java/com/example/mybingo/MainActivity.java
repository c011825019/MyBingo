package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int maxNumber = 75;
    private EditText maxNumberEditText;
    private Button registerMaxNumberButton;
    private Button nextNumberButton;
    private TextView currentNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxNumberEditText = findViewById(R.id.max_number);
        registerMaxNumberButton = findViewById(R.id.register_max_number);
        nextNumberButton = findViewById(R.id.next_number);
        currentNumberTextView = findViewById(R.id.current_number);

        maxNumberEditText.setText("" + maxNumber);

        registerMaxNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maxNumberString = maxNumberEditText.getText().toString();
                maxNumber = Integer.valueOf(maxNumberString);

                ///Log.d("MainActivity", "maxNumber: " + maxNumber);
            }
        });

        nextNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNextNumber();
            }
        });
    }

    private void onClickNextNumber() {
        double randomNumber = Math.random() * (maxNumber - 1);
        int nextNumber = (int) randomNumber + 1;
        currentNumberTextView.setText("" + nextNumber);
        //Log.d("MainActivity", "nextNumber: " + nextNumber);
    }
}