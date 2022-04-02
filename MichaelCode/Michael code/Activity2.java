package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.transition.ScaleProvider;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Activity2 extends AppCompatActivity {

    private Context mcontext;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent i = intent.getIntExtra(guesser.ress, 1000);
        getIntent().putExtra()

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
    }


    public void goback() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    public void gethighscores(int r, String f) {
        ArrayList<String> w = new ArrayList<>(10);
        ArrayList<String> w1 = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<>();
        TextView Score1 = findViewById(R.id.Score1);
        TextView Score2 = findViewById(R.id.Score2);
        TextView Score3 = findViewById(R.id.Score3);
        TextView Score4 = findViewById(R.id.Score4);
        TextView Score5 = findViewById(R.id.Score5);
        int counter = 0;
        w.add("0");
        w.add("0");
        w.add("0");
        w.add("0");
        w.add("0");
        w.add("N/A");
        w.add("N/A");
        w.add("N/A");
        w.add("N/A");
        w.add("N/A");
        int i = 0;
        for (i = 0; i < 5; i++) {
            String p = w.get(i);
            int u = Integer.parseInt(p);

            if (u > r) {
                counter++;
                w1.add(p);
            } else {
                String z = String.valueOf(r);
                w1.add(z);
                names.set(i, f);
                break;
            }
        }
        for (i = i; i < 5; i++) {
            try {
                String p = w.get(i);
                w1.add(p);
            } catch (Exception e) {
            }
        }
        if (counter != 5) {
            w.remove(4);
        }

        Score1.setText(w1.get(0));
        Score2.setText(w1.get(1));
        Score3.setText(w1.get(2));
        Score4.setText(w1.get(3));
        Score5.setText(w1.get(4));
    }
}

