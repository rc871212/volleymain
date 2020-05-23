package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Bag extends AppCompatActivity {
    private Button button;
    private Button bag0;
    private Button bag1;
    private Button bag2;
    private Button bag3;
    private Button bag4;
    private Button bag5;
    private Button bag6;
    private Button bag7;
    private Button bag8;


    private ArrayList<player> players=new ArrayList<player>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        button = findViewById(R.id.add);
        bag0 = findViewById(R.id.bag0);
        bag1 = findViewById(R.id.bag1);
        bag2= findViewById(R.id.bag2);
        bag3 = findViewById(R.id.bag3);
        bag4 = findViewById(R.id.bag4);
        bag5 = findViewById(R.id.bag5);
        bag6 = findViewById(R.id.bag6);
        bag7 = findViewById(R.id.bag7);
        bag8 = findViewById(R.id.bag8);
        Button[] bags=new Button[9];
        bags[0]=bag0;
        bags[1]=bag1;
        bags[2]=bag2;
        bags[3]=bag3;
        bags[4]=bag4;
        bags[5]=bag5;
        bags[6]=bag6;
        bags[7]=bag7;
        bags[8]=bag8;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPlayer();
            }
        });

        DBHelper dh=new DBHelper(getApplicationContext());
        SQLiteDatabase db = dh.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT*FROM PlayerData",null);
        for(int i=0;i<c.getCount();i++)
        {
            c.moveToPosition(i);
            String name=c.getString(c.getColumnIndex("name"));
            int id = c.getInt(c.getColumnIndex("id"));
        player p=new player(id,name);
        players.add(p);
        }
        c.close();
        db.close();
        getNewPlayerData();
        for(int i=0;i<players.size();i++)
        {
            bags[i].setText(players.get(i).getName());
        }


    }



    private void getNewPlayerData() {
        try
        {
            Bundle bundle = this.getIntent().getExtras();
            if (bundle != null)
            {
                int pId=bundle.getInt("id");
                String pName=bundle.getString("Name");
                players.add(new player(pId,pName));
                DBHelper dh=new DBHelper(getApplicationContext());
                SQLiteDatabase db = dh.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id",pId);
                values.put("name",pName);
                db.insert("PlayerData",null,values);
                db.close();


            }
        }
        catch (Exception e)
        {

        }
    }

    public void openAddPlayer() {
        Intent intent = new Intent(this, AddPlayer.class);
        startActivity(intent);
    }

}
class player
        {
            private int id;
            private String name ;
            player(int id, String name)
            {
                this.id=id;
                this.name=name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

