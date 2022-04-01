package com.example.beybladespin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer(true);

    }
    //private double rand;
    private int round = 1;
    private boolean newRound = false;
    CountDownTimer timer;
    private int score =0;
    private int barSize =0;
    DisplayMetrics displayMetrics = new DisplayMetrics();


    public void timer(boolean onoroff){
        timer = new CountDownTimer(20000, 1000){
            TextView timerView = (TextView) findViewById(R.id.timer);
            Button barView=(Button) findViewById(R.id.timerbar);
            ViewGroup.LayoutParams layoutParams = barView.getLayoutParams();


            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long sec = (millisUntilFinished / 1000) % 60;
                timerView.setText(f.format(sec));
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                barSize+=(width/20);
                layoutParams.width=barSize;
                if(barSize <= width/3){
                    barView.setBackgroundColor(Color.GREEN);
                }
                else if(barSize >width/3 && barSize<= 2*(width/3)){
                    barView.setBackgroundColor(Color.YELLOW);
                }
                else{
                    barView.setBackgroundColor(Color.RED);

                }
                barView.setLayoutParams(layoutParams);
            }

            public void onFinish() {
                timerView.setText("00");
                TextView messageView= (TextView) findViewById(R.id.message);
                messageView.setVisibility(View.INVISIBLE);
                TextView beView= (TextView) findViewById(R.id.between);
                beView.setVisibility(View.INVISIBLE);
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

                round = 10;

            }
        };
        if(onoroff) {
            timer.start();
        }
        else if (!onoroff){
            timer.cancel();
        }
    }

    public void letitrip(View v){
        EditText guessView=(EditText) findViewById(R.id.guess);
        String gV = guessView.getText().toString();
        Button lirView = (Button) findViewById(R.id.lir);

        if (!(gV.equals(""))) {
            TextView rorwView = (TextView) findViewById(R.id.rorw);
            rorwView.setVisibility(View.INVISIBLE);
            Button contView = (Button) findViewById(R.id.cont);
            contView.setVisibility(View.INVISIBLE);
            TextView messageView = (TextView) findViewById(R.id.message);
            messageView.setVisibility(View.INVISIBLE);
            TextView betView = (TextView) findViewById(R.id.between);
            betView.setVisibility(View.INVISIBLE);
            guessView.setVisibility(View.INVISIBLE);

            lirView.setVisibility(View.INVISIBLE);
            TextView sureView = (TextView) findViewById(R.id.sure);
            sureView.setVisibility(View.VISIBLE);
            Button yesView = (Button) findViewById(R.id.yes);
            yesView.setVisibility(View.VISIBLE);
            Button noView = (Button) findViewById(R.id.no);
            noView.setVisibility(View.VISIBLE);
        }
        else {
            lirView.setError("guess cannot be null or a number that's 0-10");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    lirView.setError(null);
                }
            }, 3000);   //5 seconds

        }
    }
    public void no(View v){
        if(round<=9) {
            if (newRound) {
                timer.start();
                round++;
                barSize = 0;
                newRound = false;
            }
            TextView rorwView = (TextView) findViewById(R.id.rorw);
            rorwView.setVisibility(View.INVISIBLE);
            Button contView = (Button) findViewById(R.id.cont);
            contView.setVisibility(View.INVISIBLE);
            TextView messageView = (TextView) findViewById(R.id.message);
            messageView.setVisibility(View.VISIBLE);
            TextView betView = (TextView) findViewById(R.id.between);
            betView.setVisibility(View.VISIBLE);
            EditText guessView = (EditText) findViewById(R.id.guess);
            guessView.setVisibility(View.VISIBLE);

            Button lirView = (Button) findViewById(R.id.lir);
            lirView.setVisibility(View.VISIBLE);
            TextView sureView = (TextView) findViewById(R.id.sure);
            sureView.setVisibility(View.INVISIBLE);
            Button yesView = (Button) findViewById(R.id.yes);
            yesView.setVisibility(View.INVISIBLE);
            Button noView = (Button) findViewById(R.id.no);
            noView.setVisibility(View.INVISIBLE);
        }
        else{
            TextView rorwView= (TextView) findViewById(R.id.rorw);
            rorwView.setVisibility(View.INVISIBLE);
            Button contView=(Button) findViewById(R.id.cont);
            contView.setVisibility(View.VISIBLE);
            TextView sureView= (TextView) findViewById(R.id.sure);
            sureView.setVisibility(View.INVISIBLE);
            Button yesView=(Button) findViewById(R.id.yes);
            yesView.setVisibility(View.INVISIBLE);
            Button noView=(Button) findViewById(R.id.no);
            noView.setVisibility(View.INVISIBLE);

        }

    }
    public void yes(View v){
        Button barView=(Button) findViewById(R.id.timerbar);
        ViewGroup.LayoutParams layoutParams = barView.getLayoutParams();
        int speed = layoutParams.width;
        layoutParams.width=0;
        barView.setLayoutParams(layoutParams);
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
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        if (gV == random(10)){
            rorwView.setText("YESSIR");
            newRound=true;
            score = score + 100;
            if(speed<=width/5){
                score+=50;
            }
            else if(speed>width/5 && speed<=2*(width/5)){
                score+=30;
            }
            else if(speed>2*(width/5) && speed<=3*(width/5)){
                score+=15;
            }
            else if(speed>3*(width/5) && speed<=4*(width/5)){
                score+=7;
            }
            else{
                score+=2;
            }
            scoreView.setText("SCORE: "+score);
        }
        else{
            rorwView.setText("WRONG BUM");
            scoreView.setVisibility(View.INVISIBLE);
            round =10;

        }
    }

    public double random(int n){
        double rand = Math.floor((Math.random()*n) +1);
        return rand;
    }


}
