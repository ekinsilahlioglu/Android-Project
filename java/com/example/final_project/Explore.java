package com.example.final_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        new AlertDialog.Builder(this)
                .setTitle("Message")
                .setMessage("WELCOME AVENGER...\nReady for the journey?")
                .setIcon(R.drawable.aven)
                .setNeutralButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    public  void button_explore(View view){
        startActivity(new Intent(Explore.this, MAIN_TABS.class));
    }

    public void button_credits(View view){
        startActivity(new Intent(Explore.this, CREDITS.class));
    }

    AppRestart ar = new AppRestart();

    public void go_back_to_logout(View view){

        ar.doRestart(this);

    }


}
