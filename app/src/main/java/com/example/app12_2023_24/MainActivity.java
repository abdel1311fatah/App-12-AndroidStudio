package com.example.app12_2023_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
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
    private int colorFondo = 0;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void color(View view) {

        // https://www.htcmania.com/showthread.php?t=338533
        try {
            if (blue.isChecked()) {
                colorFondo = Color.BLUE;
                constraintLayout.setBackgroundColor(Color.BLUE);
            } else if (red.isChecked()) {
                colorFondo = Color.RED;
                constraintLayout.setBackgroundColor(Color.RED);
            } else if (green.isChecked()) {
                colorFondo = Color.GREEN;
                constraintLayout.setBackgroundColor(Color.GREEN);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void save(View view){
        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String nom = name.getText().toString();
        String correu = email.getText().toString();
        int color = colorFondo;
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nom);
        editor.putString("correu",correu);
        editor.putInt("color", color);
        editor.commit();
    }

    public void recover(View view){
        SharedPreferences preferences = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String nom = preferences.getString("user","");
        String correu = preferences.getString("correu","");
        int color = preferences.getInt("color",Color.WHITE);

        name.setText(nom);
        email.setText(correu);
        constraintLayout.setBackgroundColor(color);

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", nom);
        intent.putExtra("useremail", correu);
        intent.putExtra("usercolor", color);
        startActivity(intent);

    }

    public void exit(View view) {
        finish();
        System.exit(0);
        // https://stackoverflow.com/questions/6014028/closing-application-with-exit-button
    }
}