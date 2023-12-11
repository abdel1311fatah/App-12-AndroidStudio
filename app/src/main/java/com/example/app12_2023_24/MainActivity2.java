package com.example.app12_2023_24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        TextView name = findViewById(R.id.userName);
        TextView email = findViewById(R.id.email);

        String nom = intent.getStringExtra("username");
        String correu = intent.getStringExtra("useremail");
        name.setText(nom);
        email.setText(correu);
    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}