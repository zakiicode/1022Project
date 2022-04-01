package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity2 extends AppCompatActivity  {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView Score5 = (TextView) findViewById(R.id.Score5);
        ArrayList<String> gamer = new ArrayList<>();
        highscore w = new highscore();
        gamer = w.gethighscoreprinter();



        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
    }
    public void  goback(){
        Intent intent = new Intent(getApplicationContext(),Activity.class);
        startActivity(intent);
    }
    public void changer(){
        TextView Score5 = (TextView) findViewById(R.id.Score5);
        Score5.setText("W!");
    }

    }


