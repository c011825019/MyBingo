package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int maxNumber = 75;
    private ArrayList<String> history = new ArrayList<>();
    private EditText maxNumberEditText;
    private Button registerMaxNumberButton;
    private Button nextNumberButton;
    private TextView currentNumberTextView;
    private TextView historyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxNumberEditText = findViewById(R.id.max_number);
        registerMaxNumberButton = findViewById(R.id.register_max_number);
        nextNumberButton = findViewById(R.id.next_number);
        currentNumberTextView = findViewById(R.id.current_number);
        historyTextView = findViewById(R.id.history);

        maxNumberEditText.setText("" + maxNumber);

        registerMaxNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maxNumberString = maxNumberEditText.getText().toString();
                maxNumber = Integer.valueOf(maxNumberString);
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
        int nextNumber = createRandomNumber();
        //int count = 0;

        while (history.contains("" + nextNumber)) {
            nextNumber = createRandomNumber();
//            count++;
//            if (count == maxNumber) {
//                break;
//            }
        }

        String nextNumberStr = "" + nextNumber;
        currentNumberTextView.setText(nextNumberStr);
        history.add(nextNumberStr);

        historyTextView.setText(history.toString());
    }

    private int createRandomNumber() {
        double randomNumber = Math.random() * (maxNumber - 1);
        return  (int) randomNumber + 1;
    }
}