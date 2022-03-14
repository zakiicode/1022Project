package com.example.beybladespin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private double rand;
    private int round;

    public void letitrip(View v){
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
        random(10);
    }
    public void no(View v){
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

        if (gV == rand){
            rorwView.setText("YESSIR");
        }
        else{
            rorwView.setText("WRONG BUM");

        }
    }

    public double random(int n){
        rand = Math.floor((Math.random()*n) +1);
        return rand;
    }


}