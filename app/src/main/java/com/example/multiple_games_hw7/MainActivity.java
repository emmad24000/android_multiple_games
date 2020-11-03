package com.example.multiple_games_hw7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout top;
    FrameLayout bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top = findViewById(R.id.topFrameLayout);
        bottom = findViewById(R.id.bottomFrameLayout);
    }

    public void GuessingGameBottom(View view) {
        Guessing_game guessing_game = new Guessing_game();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bottomFrameLayout,guessing_game);
        fragmentTransaction.commit();
    }

    public void TTTBottom(View view) {
        Tik_tak_toe tik_tak_toe = new Tik_tak_toe();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bottomFrameLayout,tik_tak_toe);
        fragmentTransaction.commit();
    }

    public void TTTTop(View view) {
        Tik_tak_toe tik_tak_toe = new Tik_tak_toe();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.topFrameLayout,tik_tak_toe);
        fragmentTransaction.commit();
    }

    public void GuessingGameTop(View view) {
        Guessing_game guessing_game = new Guessing_game();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.topFrameLayout,guessing_game);
        fragmentTransaction.commit();
    }
}