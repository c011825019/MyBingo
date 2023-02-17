package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int maxNumber = 75;
    private EditText maxNumberEditText;
    private Button registerMaxNumberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxNumberEditText = findViewById(R.id.max_number);
        registerMaxNumberButton = findViewById(R.id.register_max_number);

        maxNumberEditText.setText("" + maxNumber);

        registerMaxNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maxNumberString = maxNumberEditText.getText().toString();
                maxNumber = Integer.valueOf(maxNumberString);

                Log.d("MainActivity", "maxNumber: " + maxNumber);
            }
        });
    }
}