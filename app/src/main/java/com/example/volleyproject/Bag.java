package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Bag extends AppCompatActivity {
    private Button button;

    ArrayList players=new ArrayList<player>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        button = findViewById(R.id.add);
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
            public player(int id , String name)
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

