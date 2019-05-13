package com.example.final_project;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FAV extends ListActivity {
    ListView listView;
    private SQLiteDatabase myDatabase;
    private TextView txtMsg;
    private String path;
    String [] movie_names = {"Captain America: First Avenger","Captain Marvel","Iron Man","Iron Man 2","The Incredible Hulk","Thor",
            "The Avengers","Thor: The Dark World","Guardians of the Galaxy","Guardians of the Galaxy: Vol2",
            "Iron Man 3","Captain America: The Winter Soldier","Avengers: Age of Ultron","Ant-Man","Captain America: Civil War"
            ,"Black Panther","Spiderman Homecoming","Doctor Strange","Thor: Ragnarok", "Ant-Man & the Wasp","Avengers: Infinity War","Avengers: Endgame"};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites);

        listView= findViewById(android.R.id.list);
        String fav_information = getIntent().getStringExtra("name_fav");


        //start to create database
        File myDbPath = getApplication().getFilesDir();
        path = myDbPath + "/" + "FAVORITED";
        try {

            if(!databaseExist()) {
                //create the database
                myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

                //create the table
                String table = "create table favorite(" +  "name text Unique )";

                //execute the query to create the table
                myDatabase.execSQL(table); //now we have the table

            }
        }
        catch(Exception e){
            e.getMessage();
        }

        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);

        if(fav_information != null){
            String input = "insert into favorite(name)" + "values('" + fav_information + "')";
            myDatabase.execSQL(input);
        }

        read_fav();

    }

    //helper method to check if a database is exist
    private boolean databaseExist(){
        File dbFile = new File(path);
        return dbFile.exists();
    }

    ArrayList<String> my_array_for_list_fav = new ArrayList<>();
    public void read_fav(){
       my_array_for_list_fav.clear();
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input_fav = "select * from favorite";
        Cursor cursor = myDatabase.rawQuery(input_fav,null);
        String result = "";
        while (cursor.moveToNext()) {
            result = cursor.getString(cursor.getColumnIndex("name"));
            my_array_for_list_fav.add(result);

        }
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, my_array_for_list_fav));
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        for (int i =0;i<23;i++) {
            if (info.id == i) {
                myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

                myDatabase.delete("favorite", "name=?", new String[]{my_array_for_list_fav.get(i)});
                Toast.makeText(this, "The entry is deleted..", Toast.LENGTH_SHORT).show();

                read_fav();

            }

        }

        return super.onContextItemSelected(item);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);



        Object object = listView.getAdapter().getItem(position);
        String name = object.toString();

        for(int i = 0;i<movie_names.length;i++) {
            if (name.equalsIgnoreCase(movie_names[i])) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com"));
                startActivity(browserIntent);
            }
        }

    }

}
