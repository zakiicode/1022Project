package com.example.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class highscore {
    public ArrayList<String> w = new ArrayList<String>(10);
    ArrayList<String> w1 = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<>();
    public String f = "greg";
    public int r = 700;
    public void highscoreer()  {
        File myObj = new File("scores");
        try {
            Scanner reader = new Scanner(myObj);
            for (int i = 0; i < 5; i++)
            {
                String data = reader.nextLine();
                w.add(data);
            }
            for (int i = 5; i < 10; i++) {
                String data = reader.nextLine();
                names.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i =0;
        for (i = 0; i < 5; i++) {
            String p = w.get(i);
            int u = Integer.parseInt(p);
            if (u > r){
                w1.add(p);
            }
            else {
                String z = String.valueOf(r);
                w1.add(z);
                names.set(i, f);
                break;
            }
        }
        for( i=i; i<5; i++){
            try {
                String p = w.get(i);
                w1.add(p);
            }
            catch(Exception e){
            }
        }

        int index = 5;
        w1.remove(index);
        FileWriter writer = null;
        try {
            writer = new FileWriter("scores");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            for(String e: w1){
                String e1 = String.valueOf(e);
                writer.write(e1);
                writer.append('\n');
            }
            for (String e: names) {
                writer.write(e);
                writer.append('\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  public ArrayList<String> gethighscoreprinter(){
        return w1;
  }
}
