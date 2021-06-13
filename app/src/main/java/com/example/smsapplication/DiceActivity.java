package com.example.smsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    private ImageView diceImg;
    private Button btnRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        diceImg = findViewById(R.id.img_dice);
        btnRoll = findViewById(R.id.btn_roll_dice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            Random random = new Random();
            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(6) + 1;
                if(randomNumber == 1) {
                    diceImg.setImageResource(R.drawable.one);
                }else if(randomNumber == 2) {
                    diceImg.setImageResource(R.drawable.two);
                }else if(randomNumber == 3) {
                    diceImg.setImageResource(R.drawable.three);
                }else if(randomNumber == 4) {
                    diceImg.setImageResource(R.drawable.four);
                }else if(randomNumber == 5) {
                    diceImg.setImageResource(R.drawable.five);
                }else{
                    diceImg.setImageResource(R.drawable.six);
                }
            }
        });
    }
}