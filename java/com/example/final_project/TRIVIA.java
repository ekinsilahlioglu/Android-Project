package com.example.final_project;


import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.File;
import java.util.ArrayList;

public class TRIVIA extends AppCompatActivity {
    private SQLiteDatabase myDatabase;
    private String path;
    private TextView txtMsg,q_place;
    private Button btn1,btn2,btn3,btn4;
    ArrayList<String> q = new ArrayList<>();
    ArrayList<String> a1 = new ArrayList<>();
    ArrayList<String> a2 = new ArrayList<>();
    ArrayList<String> a3 = new ArrayList<>();
    ArrayList<String> a4 = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        q_place = findViewById(R.id.question_place);

        //start to create database
        File myDbPath = getApplication().getFilesDir();
        path = myDbPath + "/" + "TRIVIAFINALL";

        try {
            if(!databaseExist()) {
                //create the database
                myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

                //create the table
                String table = "create table trivia(" + "id integer primary key autoincrement," + "name text,"  + "answer1 text,"+ "answer2 text,"+ "answer3 text," + "answer4 text)";

                //execute the query to create the table
                myDatabase.execSQL(table); //now we have the table

            }
        }
        catch (SQLException e){
            txtMsg.setText(e.getMessage());
        }

        questions();
        play();
        q_place.setText("Captain America was frozen in which war?");
        btn1.setText("World War 1");
        btn2.setText("World War 2");
        btn3.setText("American Civil War");
        btn4.setText("Cold War");


    }

    //helper method to check if a database is exist
    private boolean databaseExist(){
        File dbFile = new File(path);
        return dbFile.exists();
    }

    public void questions(){

        //open my database
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "insert into trivia(name,answer1,answer2,answer3,answer4)" + "values('" + "How many Infinity Stones does Thanos need to wipe out the half of the universe?" + "','" + "4" + "','"+ "5" + "','"+ "6" + "','" + "7" + "')";
        String input2 = "insert into trivia(name,answer1,answer2,answer3,answer4)" + "values('" + "Where did Thanos find the soul stone?"  + "','" + "Vormir" + "','"+ "Moraq" + "','"+ "Knowhere" + "','" + "Titan" + "')";
        String input3 = "insert into trivia(name,answer1,answer2,answer3,answer4)" + "values('" + "What is the name of AI in Spider-Mans suit?"  + "','" + "Jarvis" + "','"+ "Friday" + "','"+ "Karen" + "','" + "Janice" + "')";
        String input4 = "insert into trivia(name,answer1,answer2,answer3,answer4)" + "values('" + "What is the name of alien speicies that came to Earth from a portal in Avengers movie?" + "','" + "Titans" + "','"+ "Krees" + "','"+ "Andorians" + "','" + "Chiutari" + "')";
        String input5 = "insert into trivia(name,answer1,answer2,answer3,answer4)" + "values('" + "How many years Cap has been sleeping after he crashed into the iceberg?" + "','" + "40" + "','"+ "70" + "','"+ "60" + "','" + "50" + "')";
        myDatabase.execSQL(input);
        myDatabase.execSQL(input2);
        myDatabase.execSQL(input3);
        myDatabase.execSQL(input4);
        myDatabase.execSQL(input5);

        myDatabase.close();
    }


    public void play(){
        a1.clear();
        a2.clear();
        a3.clear();
        a4.clear();
        q.clear();
        String question = "";
        String ans1,ans2,ans3,ans4 = "";

        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "select * from trivia";
        Cursor cursor = myDatabase.rawQuery(input,null);
        while (cursor.moveToNext()) {
            question = cursor.getString(cursor.getColumnIndex("name"));
            ans1 = cursor.getString(cursor.getColumnIndex("answer1"));
            ans2 = cursor.getString(cursor.getColumnIndex("answer2"));
            ans3 = cursor.getString(cursor.getColumnIndex("answer3"));
            ans4 = cursor.getString(cursor.getColumnIndex("answer4"));

            q.add(question);
            a1.add(ans1);
            a2.add(ans2);
            a3.add(ans3);
            a4.add(ans4);

        }

    }


    public void button1(View v){

        if(btn1.getText() == "World War 1"){
            q_place.setText(q.get(0));
            btn1.setText(a1.get(0));
            btn2.setText(a2.get(0));
            btn3.setText(a3.get(0));
            btn4.setText(a4.get(0));

        }
        else if(btn1.getText() == a1.get(1)){
            q_place.setText(q.get(2));
            btn1.setText(a1.get(2));
            btn2.setText(a2.get(2));
            btn3.setText(a3.get(2));
            btn4.setText(a4.get(2));
        }

    }
    public void button2(View v){

        if(btn2.getText() == a2.get(4)){
            q_place.setText("Fun isn’t something one considers when balancing the universe. But this… does put a smile on my face.");
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
        }

    }
    public void button3(View v){

        if(btn3.getText() == a3.get(0)){
            q_place.setText(q.get(1));
            btn1.setText(a1.get(1));
            btn2.setText(a2.get(1));
            btn3.setText(a3.get(1));
            btn4.setText(a4.get(1));
        }
        else if(btn3.getText() == a3.get(2)){
            q_place.setText(q.get(3));
            btn1.setText(a1.get(3));
            btn2.setText(a2.get(3));
            btn3.setText(a3.get(3));
            btn4.setText(a4.get(3));
        }

    }
    public void button4(View v){

        if(btn4.getText() == a4.get(3)){
            q_place.setText(q.get(4));
            btn1.setText(a1.get(4));
            btn2.setText(a2.get(4));
            btn3.setText(a3.get(4));
            btn4.setText(a4.get(4));

        }

    }

}//end of class
