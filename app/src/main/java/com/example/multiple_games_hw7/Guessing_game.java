package com.example.multiple_games_hw7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Guessing_game extends Fragment implements View.OnClickListener{
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    TextView numberRight;
    TextView numberWrong;
    TextView topLabel;
    int correctNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View guessingGame = inflater.inflate(R.layout.fragment_guessing_game,container,false);
        button1 = guessingGame.findViewById(R.id.button1);
        button2 = guessingGame.findViewById(R.id.button2);
        button3 = guessingGame.findViewById(R.id.button3);
        button4 = guessingGame.findViewById(R.id.button4);
        button5 = guessingGame.findViewById(R.id.button5);
        button6 = guessingGame.findViewById(R.id.button6);
        button7 = guessingGame.findViewById(R.id.button7);
        button8 = guessingGame.findViewById(R.id.button8);
        button9 = guessingGame.findViewById(R.id.button9);
        numberRight = guessingGame.findViewById(R.id.rightNumb);
        numberWrong = guessingGame.findViewById(R.id.wrongNumb);
        topLabel = guessingGame.findViewById(R.id.topNumberGuessLabel);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        correctNumber = getRandomNumberUsingNextInt(1,10);

        return guessingGame;
    }

    public Guessing_game(){

    }

    public void check(int buttonNumber){
        if(buttonNumber == correctNumber){
            topLabel.setText("NAILED IT! NUMBER RESET");
            correctNumber = getRandomNumberUsingNextInt(1,10);
            int correctRight = Integer.parseInt((String) numberRight.getText());
            correctRight++;
            numberRight.setText(String.valueOf(correctRight));
        }
        else {
            if(buttonNumber > correctNumber) {
                topLabel.setText("Too High");
            }else {
                topLabel.setText("Too Low");
            }
            int currentWrong = Integer.parseInt((String) numberWrong.getText());
            currentWrong++;
            numberWrong.setText(String.valueOf(currentWrong));
        }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:
                check(1);
                break;
            case R.id.button2:
                check(2);
                break;

            case R.id.button3:
                check(3);
                break;

            case R.id.button4:
                check(4);
                break;

            case R.id.button5:
                check(5);
                break;

            case R.id.button6:
                check(6);
                break;

            case R.id.button7:
                check(7);
                break;

            case R.id.button8:
                check(8);
                break;

            case R.id.button9:
                check(9);
                break;

        }




    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}