package com.example.multiple_games_hw7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Tik_tak_toe extends Fragment implements View.OnClickListener{
    char[][] table = new char[3][3];
    boolean turnX = true;
    boolean empty = false;
    TextView displayWinner;
    TextView displayTurn;
    TextView displayWins;
    TextView displayLoss;

    int turns = 0;
    boolean someoneWin = false;
    Button r1c1;
    Button r1c2;
    Button r1c3;

    Button r2c1;
    Button r2c2;
    Button r2c3;

    Button r3c1;
    Button r3c2;
    Button r3c3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tik_tak_toe = inflater.inflate(R.layout.fragment_tik_tak_toe, container, false);
        displayWinner = tik_tak_toe.findViewById(R.id.displayWinnerLabel);
        displayTurn = tik_tak_toe.findViewById(R.id.displayTurnLabel);
        displayWins = tik_tak_toe.findViewById(R.id.displayWins);
        displayLoss = tik_tak_toe.findViewById(R.id.displayLosses);

        r1c1 = tik_tak_toe.findViewById(R.id.button1_1);
        r1c2 = tik_tak_toe.findViewById(R.id.button1_2);
        r1c3 = tik_tak_toe.findViewById(R.id.button1_3);

        r2c1 = tik_tak_toe.findViewById(R.id.button2_1);
        r2c2 = tik_tak_toe.findViewById(R.id.button2_2);
        r2c3 = tik_tak_toe.findViewById(R.id.button2_3);

        r3c1 = tik_tak_toe.findViewById(R.id.button3_1);
        r3c2 = tik_tak_toe.findViewById(R.id.button3_2);
        r3c3 = tik_tak_toe.findViewById(R.id.button3_3);

        r1c1.setOnClickListener(this);
        r1c2.setOnClickListener(this);
        r1c3.setOnClickListener(this);

        r2c1.setOnClickListener(this);
        r2c2.setOnClickListener(this);
        r2c3.setOnClickListener(this);

        r3c1.setOnClickListener(this);
        r3c2.setOnClickListener(this);
        r3c3.setOnClickListener(this);
        clearTable();

        return tik_tak_toe;
    }
    public Tik_tak_toe(){

    }
    void clearTable(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j<3;j++){
                table[i][j] = ' ';
            }
        }
        r1c1.setText("-");
        r1c2.setText("-");
        r1c3.setText("-");
        r2c1.setText("-");
        r2c2.setText("-");
        r2c3.setText("-");
        r3c1.setText("-");
        r3c2.setText("-");
        r3c3.setText("-");
        turns = 0;
        if(turnX){
            turnX = false;
        }else turnX = true;
    }

    void turn(int row, int col){
        if(table[row][col] != 'x' && table[row][col] != 'o') {
            empty = true;
            if(turnX) {
                table[row][col] = 'x';
                turnX = false;
                displayTurn.setText("X");
            }else{
                table[row][col] = 'o';
                turnX = true;
                displayTurn.setText("O");
            }
            if(checkWin()){
                if(turnX) {
                    displayWinner.setText("X WINS!");
                    int totalWins = Integer.parseInt((String) displayWins.getText());
                    totalWins++;
                    displayWins.setText(String.valueOf(totalWins));
                }
                else{
                    displayWinner.setText("O WINS!");
                    int totalLosses = Integer.parseInt((String)displayLoss.getText());
                    totalLosses++;
                    displayLoss.setText(String.valueOf(totalLosses));
                }
                clearTable();
            }else turns++;
            if(turns == 9){
                displayWinner.setText("DRAW");
                someoneWin = true;
                clearTable();
            }
        }else empty =false;
    }

    boolean checkWin(){
        if(table[0][0] == table[0][1] && table[0][1] == table [0][2] && table[0][0] != ' '){ //check row 1
            someoneWin = true;
            return true;
        }else if(table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] != ' '){ //check row 2
            someoneWin = true;
            return true;
        }else if(table[2][0] == table[2][1] && table[2][1] == table[2][2]&& table[2][0] != ' '){ //check row 3
            someoneWin = true;
            return true;
        }else if(table[0][0] == table[1][0] && table[1][0] == table[2][0]&& table[0][0] != ' '){ //check col 1
            someoneWin = true;
            return true;
        }else if(table[0][1] == table[1][1] && table[1][1] == table[2][1]&& table[0][1] != ' '){ //check col2
            someoneWin = true;
            return true;
        }else if(table[0][2] == table [1][2] && table[1][2] == table[2][2] && table[0][2] != ' '){ //check col3
            someoneWin = true;
            return true;
        }else if(table[2][0] == table[1][1] && table[1][1] == table[0][2]&& table[2][0] != ' '){
            someoneWin = true;
            return true;
        }else if(table[0][0] == table[1][1] && table[1][1] == table[2][2]&& table[0][0] != ' '){
            someoneWin = true;
            return true;
        }
        someoneWin = false;
        return false;


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1_1:
                turn(0,0);
                if(empty && !someoneWin){
                    if(turnX){
                        r1c1.setText("X");
                    }else{
                        r1c1.setText("O");
                    }
                }
                break;
            case R.id.button1_2:
                turn(0,1);
                if(empty && !someoneWin){
                    if(turnX){
                        r1c2.setText("X");
                    }else{
                        r1c2.setText("O");
                    }
                }
                break;
            case R.id.button1_3:
                turn(0,2);
                if(empty && !someoneWin){
                    if(turnX){
                        r1c3.setText("X");
                    }else{
                        r1c3.setText("O");
                    }
                }
                break;
            case R.id.button2_1:
                turn(1,0);
                if(empty && !someoneWin){
                    if(turnX){
                        r2c1.setText("X");
                    }else{
                        r2c1.setText("O");
                    }
                }
                break;
            case R.id.button2_2:
                turn(1,1);
                if(empty && !someoneWin){
                    if(turnX){
                        r2c2.setText("X");
                    }else{
                        r2c2.setText("O");
                    }
                }
                break;
            case R.id.button2_3:
                turn(1,2);
                if(empty && !someoneWin){
                    if(turnX){
                        r2c3.setText("X");
                    }else{
                        r2c3.setText("O");
                    }
                }
                break;
            case R.id.button3_1:
                turn(2,0);
                if(empty && !someoneWin){
                    if(turnX){
                        r3c1.setText("X");
                    }else{
                        r3c1.setText("O");
                    }
                }
                break;
            case R.id.button3_2:
                turn(2,1);
                if(empty && !someoneWin){
                    if(turnX){
                        r3c2.setText("X");
                    }else{
                        r3c2.setText("O");
                    }
                }
                break;
            case R.id.button3_3:
                turn(2,2);
                if(empty && !someoneWin){
                    if(turnX){
                        r3c3.setText("X");
                    }else{
                        r3c3.setText("O");
                    }
                }
                break;
        }

    }
}