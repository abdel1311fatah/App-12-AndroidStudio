package com.example.app12_2023_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        constraintLayout = findViewById(R.id.constraintLayout);

        Intent intent = getIntent();
        TextView name = findViewById(R.id.userName);
        TextView email = findViewById(R.id.email);

        String nom = intent.getStringExtra("username");
        String correu = intent.getStringExtra("useremail");
        int color = intent.getIntExtra("usercolor", Color.WHITE); // per defecte li fiquem blanc

        name.setText(nom);
        email.setText(correu);
        constraintLayout.setBackgroundColor(color);

    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}