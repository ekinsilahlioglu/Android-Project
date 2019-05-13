package com.example.final_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    EditText login_mail,login_pass,signup_name,signup_mail,signup_pass;
    private SQLiteDatabase myDatabase;
    private String path;
    private TextView txtMsg;
    DETAILED detailed = new DETAILED();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_mail = findViewById(R.id.login_mail);
        login_pass = findViewById(R.id.login_pass);
        signup_name = findViewById(R.id.signup_name);
        signup_mail = findViewById(R.id.signup_mail);
        signup_pass = findViewById(R.id.signup_pass);

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("Screen-1");
        tabSpec.setContent(R.id.tab_login);
        tabSpec.setIndicator("LOG-IN",null);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Screen-2");
        tabSpec.setContent(R.id.tab_signup);
        tabSpec.setIndicator("SIGN-UP",null);
        tabHost.addTab(tabSpec);

        //start to create database
        File myDbPath = getApplication().getFilesDir();
        path = myDbPath + "/" + "SIGNUP";

        try {
            if(!databaseExist()) {
                //create the database
                myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

                //create the table
                String table = "create table signup(" + "id integer primary key autoincrement," + "name text,"  + "mail text," + "password text)";

                //execute the query to create the table
                myDatabase.execSQL(table); //now we have the table

            }
        }
        catch (SQLException e){
            txtMsg.setText(e.getMessage());
        }

        tabHost.setCurrentTab(0);

    }

    //helper method to check if a database is exist
    private boolean databaseExist(){
        File dbFile = new File(path);
        return dbFile.exists();
    }


    public void button_login(View view){
        String mailL = login_mail.getText().toString();
        String passL = login_pass.getText().toString();
        //open my database
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "select * from signup where mail=? ";
        String input2 = "select * from signup where password=? ";

        Cursor cursor = myDatabase.rawQuery(input,new String[]{mailL});
        Cursor cursor1 = myDatabase.rawQuery(input2,new String[]{passL});



        if(cursor.getCount() >0 && cursor1.getCount()>0){
            startActivity(new Intent(this, Explore.class));


        }
        else{
            Toast.makeText(this, "Invalid mail address or username", Toast.LENGTH_SHORT).show();
        }

        myDatabase.close();

    }

    public void button_signup(View view){
        String name = signup_name.getText().toString();
        String mailA = signup_mail.getText().toString();
        String pass = signup_pass.getText().toString();

        //open my database
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "insert into signup(name,mail,password)" + "values('" + name + "','" + mailA + "','" + pass + "')";
        myDatabase.execSQL(input);

        signup_name.setText("");
        signup_pass.setText("");
        signup_mail.setText("");

        myDatabase.close();
    }

}//end of class