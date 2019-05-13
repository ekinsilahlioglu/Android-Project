package com.example.final_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DETAILED extends AppCompatActivity {
    TextView myText,text_sub;
    ImageView poster;
    String [] items = {"Captain America: First Avenger","Captain Marvel","Iron Man","Iron Man 2","The Incredible Hulk","Thor",
            "The Avengers","Thor: The Dark World","Guardians of the Galaxy","Guardians of the Galaxy: Vol2",
            "Iron Man 3","Captain America: The Winter Soldier","Avengers: Age of Ultron","Ant-Man","Captain America: Civil War"
            ,"Black Panther","Spiderman Homecoming","Doctor Strange","Thor: Ragnarok", "Ant-Man & the Wasp","Avengers: Infinity War","Avengers: Endgame"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_nifo);

        myText = findViewById(R.id.textMOVIE);
        text_sub = findViewById(R.id.text_subject_movie);
        poster = findViewById(R.id.poster);

        String movie_information = getIntent().getStringExtra("MOVIE");
        String sub = getIntent().getStringExtra("SUBJECT");
        String image = getIntent().getStringExtra("IMAGENAME");

        myText.setText(movie_information);
        text_sub.setText(sub);


        if(image.equals(items[0])){
            Toast.makeText(this, items.length + "", Toast.LENGTH_SHORT).show();
            poster.setImageResource(R.drawable.captainfirstavenger);
        }
        if(image.equals(items[1])){
            Toast.makeText(this, "marveeel", Toast.LENGTH_SHORT).show();

            poster.setImageResource(R.drawable.captainmarvel);
        }
        if(image.equals(items[2])){
            Toast.makeText(this, "iroonman", Toast.LENGTH_SHORT).show();

            poster.setImageResource(R.drawable.ironman);
        }
        if(image.equals(items[3])){
            poster.setImageResource(R.drawable.ironman2);
        }
        if(image.equals(items[4])){
            poster.setImageResource(R.drawable.hulk);
        }
        if(image.equals(items[5])){
            poster.setImageResource(R.drawable.thor);
        }
        if(image.equals(items[6])){
            poster.setImageResource(R.drawable.avengers);
        }
        if(image.equals(items[7])){
            poster.setImageResource(R.drawable.thordark);
        }
        if(image.equals(items[8])){
            poster.setImageResource(R.drawable.guardians);
        }
        if(image.equals(items[9])){
            poster.setImageResource(R.drawable.guard2);
        }
        if(image.equals(items[10])){
            poster.setImageResource(R.drawable.ironman3);
        }
        if(image.equals(items[11])){
            poster.setImageResource(R.drawable.wintersoldier);
        }
        if(image.equals(items[12])){
            poster.setImageResource(R.drawable.ageofultron);
        }
        if(image.equals(items[13])){
            poster.setImageResource(R.drawable.ant);
        }
        if(image.equals(items[14])){
            poster.setImageResource(R.drawable.civilwar);
        }
        if(image.equals(items[15])){
            poster.setImageResource(R.drawable.blackpanther);
        }
        if(image.equals(items[16])){
            poster.setImageResource(R.drawable.homecoming);
        }
        if(image.equals(items[17])){
            poster.setImageResource(R.drawable.strange);
        }
        if(image.equals(items[18])){
            poster.setImageResource(R.drawable.ragnarok);
        }
        if(image.equals(items[19])){
            poster.setImageResource(R.drawable.antwasp);
        }
        if(image.equals(items[20])){
            poster.setImageResource(R.drawable.infinitywar);
        }
        if(image.equals("Avengers: Endgame")){
            poster.setImageResource(R.drawable.endgame);
        }





    }

    public void go_back_to_movie(View view){
        startActivity(new Intent(this, MAIN_TABS.class));
    }

    public void add_fav(View view){
        String favorite_intent = getIntent().getStringExtra("FAVNAME");

        Intent intent = new Intent(view.getContext(), FAV.class);

        intent.putExtra("name_fav", favorite_intent);
        startActivity(intent);




    }


}
