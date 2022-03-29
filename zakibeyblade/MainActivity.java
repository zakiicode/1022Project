package com.example.beybladespin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer(true);
    }
    //private double rand;
    private int round = 1;
    private int right =0;
    private boolean newRound = false;
    CountDownTimer timer;
    private int score =0;

    public void timer(boolean onoroff){
        timer = new CountDownTimer(20000, 1000){
            TextView timerView = (TextView) findViewById(R.id.timer);

            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long sec = (millisUntilFinished / 1000) % 60;
                timerView.setText(f.format(sec));
            }

            public void onFinish() {
                timerView.setText("00");
                TextView messageView= (TextView) findViewById(R.id.message);
                messageView.setVisibility(View.INVISIBLE);
                EditText guessView=(EditText) findViewById(R.id.guess);
                guessView.setVisibility(View.INVISIBLE);

                Button lirView=(Button) findViewById(R.id.lir);
                lirView.setVisibility(View.INVISIBLE);
                TextView rorwView= (TextView) findViewById(R.id.rorw);
                rorwView.setVisibility(View.VISIBLE);
                Button contView=(Button) findViewById(R.id.cont);
                contView.setVisibility(View.VISIBLE);
                TextView sureView= (TextView) findViewById(R.id.sure);
                sureView.setVisibility(View.INVISIBLE);
                Button yesView=(Button) findViewById(R.id.yes);
                yesView.setVisibility(View.INVISIBLE);
                Button noView=(Button) findViewById(R.id.no);
                noView.setVisibility(View.INVISIBLE);
                rorwView.setText("WRONG BUM");

                //round = 0;

            }
        };
        if(onoroff) {
            timer.start();
        }
        else if (onoroff == false){
            timer.cancel();
        }
    }

    public void letitrip(View v){

        TextView rorwView= (TextView) findViewById(R.id.rorw);
        rorwView.setVisibility(View.INVISIBLE);
        Button contView=(Button) findViewById(R.id.cont);
        contView.setVisibility(View.INVISIBLE);
        TextView messageView= (TextView) findViewById(R.id.message);
        messageView.setVisibility(View.INVISIBLE);
        EditText guessView=(EditText) findViewById(R.id.guess);
        guessView.setVisibility(View.INVISIBLE);

        Button lirView=(Button) findViewById(R.id.lir);
        lirView.setVisibility(View.INVISIBLE);
        TextView sureView= (TextView) findViewById(R.id.sure);
        sureView.setVisibility(View.VISIBLE);
        Button yesView=(Button) findViewById(R.id.yes);
        yesView.setVisibility(View.VISIBLE);
        Button noView=(Button) findViewById(R.id.no);
        noView.setVisibility(View.VISIBLE);

    }
    public void no(View v){
        if(newRound){
            timer.start();
            newRound=false;
        }
        TextView rorwView= (TextView) findViewById(R.id.rorw);
        rorwView.setVisibility(View.INVISIBLE);
        Button contView=(Button) findViewById(R.id.cont);
        contView.setVisibility(View.INVISIBLE);
        TextView messageView= (TextView) findViewById(R.id.message);
        messageView.setVisibility(View.VISIBLE);
        EditText guessView=(EditText) findViewById(R.id.guess);
        guessView.setVisibility(View.VISIBLE);

        Button lirView=(Button) findViewById(R.id.lir);
        lirView.setVisibility(View.VISIBLE);
        TextView sureView= (TextView) findViewById(R.id.sure);
        sureView.setVisibility(View.INVISIBLE);
        Button yesView=(Button) findViewById(R.id.yes);
        yesView.setVisibility(View.INVISIBLE);
        Button noView=(Button) findViewById(R.id.no);
        noView.setVisibility(View.INVISIBLE);


    }
    public void yes(View v){
        timer.cancel();
        TextView timerView = (TextView) findViewById(R.id.timer);

        timerView.setText("00");

        TextView rorwView= (TextView) findViewById(R.id.rorw);
        rorwView.setVisibility(View.VISIBLE);
        Button contView=(Button) findViewById(R.id.cont);
        contView.setVisibility(View.VISIBLE);
        TextView sureView= (TextView) findViewById(R.id.sure);
        sureView.setVisibility(View.INVISIBLE);
        Button yesView=(Button) findViewById(R.id.yes);
        yesView.setVisibility(View.INVISIBLE);
        Button noView=(Button) findViewById(R.id.no);
        noView.setVisibility(View.INVISIBLE);

        EditText guessView=(EditText) findViewById(R.id.guess);
        double gV = Double.parseDouble(guessView.getText().toString());
        TextView scoreView= (TextView) findViewById(R.id.score);

        if (gV == 10){
            rorwView.setText("YESSIR");
            right++;
            newRound=true;
            score = score + 100;
            scoreView.setText("SCORE: "+score);
        }
        else{
            rorwView.setText("WRONG BUM");
            scoreView.setVisibility(View.INVISIBLE);

        }
    }

    public double random(int n){
        double rand = Math.floor((Math.random()*n) +1);
        return rand;
    }


}
