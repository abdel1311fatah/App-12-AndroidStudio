package com.example.app12_2023_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private RadioButton blue;
    private RadioButton red;
    private RadioButton green;
    private ConstraintLayout constraintLayout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constraintLayout);
        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextmailAddress);
        blue = (RadioButton) findViewById(R.id.rbBlue);
        red = (RadioButton) findViewById(R.id.rbRed);
        green = (RadioButton) findViewById(R.id.rbGreen);
    }

    public void color(View view) {

        // https://www.htcmania.com/showthread.php?t=338533
        try {
            if (blue.isChecked()) {
                constraintLayout.setBackgroundColor(Color.BLUE);
            } else if (red.isChecked()) {
                constraintLayout.setBackgroundColor(Color.RED);
            } else if (green.isChecked()) {
                constraintLayout.setBackgroundColor(Color.GREEN);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void exit(View view) {
        finish();
        System.exit(0);
        // https://stackoverflow.com/questions/6014028/closing-application-with-exit-button
    }
}