package com.example.final_project;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import javax.sql.CommonDataSource;

public class MAIN_TABS extends ListActivity {
    TabHost tabHost;
    private SQLiteDatabase myDatabase;
    private String path;
    private Button favorites;
    String [] items = {"Captain America: First Avenger","Captain Marvel","Iron Man","Iron Man 2","The Incredible Hulk","Thor",
            "The Avengers","Thor: The Dark World","Guardians of the Galaxy","Guardians of the Galaxy: Vol2",
            "Iron Man 3","Captain America: The Winter Soldier","Avengers: Age of Ultron","Ant-Man","Captain America: Civil War"
            ,"Black Panther","Spiderman Homecoming","Doctor Strange","Thor: Ragnarok", "Ant-Man & the Wasp","Avengers: Infinity War","Avengers: Endgame"};

    ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tabs);

      listView= findViewById(android.R.id.list);


        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("Screen-1");
        tabSpec.setContent(R.id.tab_movie_info);
        tabSpec.setIndicator("INFO",null);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Screen-2");
        tabSpec.setContent(R.id.tab_test);
        tabSpec.setIndicator("TEST",null);
        tabHost.addTab(tabSpec);

        //start to create database
        File myDbPath = getApplication().getFilesDir();
        path = myDbPath + "/" + "MOVIEE";

        try {

            if(!databaseExist()) {
                //create the database
                myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);

                //create the table
                String table = "create table movie(" + "id integer primary key autoincrement," + "name text," + "year text," + "director text," + "subject text)";

                //execute the query to create the table
                myDatabase.execSQL(table); //now we have the table

            }

        }
        catch (SQLException e){
            e.getMessage();
        }

        write();
        tabHost.setCurrentTab(0);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

    }

    public void write(){
        //open my database
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "insert into movie(name,year,director,subject)" + "values('" + "Captain America:First Avenger" + "','" + "July 22, 2011" + "','" + "Joe Johnston" + "','" + "Steve Rogers wants to do his part and join Americas armed forces, but the military rejects him because of his small stature.Finally, Steve gets his chance when he is accepted into an experimental program that turns him into a supersoldier called Captain America.\\nJoining forces with Bucky Barnes and Peggy Carter, Captain America leads the fight against the Nazi organization, HYDRA." + "')";
        String input2 = "insert into movie(name,year,director,subject)" + "values('" + "Captain Marvel" + "','" + "March 8, 2019" + "','" + "Anna Boden" + "','" + "Carol Danvers becomes one of the universes most powerful heroes when Earth is caught in the middle of a galactic war between two alien races." + "')";
        String input3 = "insert into movie(name,year,director,subject)" + "values('" + "Iron Man" + "','" + "April 30, 2008" + "','" + "Jon Favreau" + "','" + "A billionaire industrialist and genius inventor, Tony Stark, is conducting weapons tests overseas, but terrorists kidnap him to force him to build a devastating weapon.\\nInstead, he builds an armored suit and upends his captors.\\nReturning to America, Stark refines the suit and uses it to combat crime and terrorism" + "')";
        String input4 = "insert into movie(name,year,director,subject)" + "values('" + "Iron Man 2" + "','" + "April 28, 2010" + "','" + "Jon Favreau" + "','" + "With the world now aware that he is Iron Man, billionaire inventor Tony Stark  faces pressure from all sides to share his technology with the military.\\nHe is reluctant to divulge the secrets of his armored suit, fearing the information will fall into the wrong hands.\\nWith Pepper Potts  and Rhodes  by his side, Tony must forge new alliances and confront a powerful new enemy." + "')";
        String input5 = "insert into movie(name,year,director,subject)" + "values('" + "The Incredible Hulk" + "','" + "April 13, 2008" + "','" + "Louis Leterrier" + "','" + "Scientist Bruce Banner desperately seeks a cure for the gamma radiation that contaminated his cells and turned him into The Hulk.Cut off from his true love Betty Ross  and forced to hide from his nemesis, Gen.\\nThunderbolt Ross , Banner soon comes face-to-face with a new threat: a supremely powerful enemy known as The Abomination." + "')";
        String input6 = "insert into movie(name,year,director,subject)" + "values('" + "Thor" + "','" + "April 27, 2011" + "','" + "Kenneth Branagh" + "','" + "As the son of Odin, king of the Norse gods, Thor will soon inherit the throne of Asgard from his aging father.However, on the day that he is to be crowned, Thor reacts with brutality when the gods enemies, the Frost Giants, enter the palace in violation of their treaty.\\nAs punishment, Odin banishes Thor to Earth.\\nWhile Loki , Thors brother, plots mischief in Asgard, Thor, now stripped of his powers, faces his greatest threat." + "')";
        String input7 = "insert into movie(name,year,director,subject)" + "values('" + "The Avengers" + "','" + "May 4, 2012" + "','" + "Joss Whedon" + "','" + "Earths mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity. " + "')";
        String input8 = "insert into movie(name,year,director,subject)" + "values('" + "Thor: The Dark World" + "','" + "October 30, 2013" + "','" + "Alan Taylor" + "','" + "Exploring Thors relationship with the Asgardian All-Father Odin, as well as Earthbound companion Jane Foster, Thor: The Dark World follows the God of Thunder to The Nine Realms beyond Asgard and Earth.And as his evil adoptive brother, Loki, returns for Asgardian justice, a new threat rises.Also rejoining Thor are his fellow Asgardians, Lady Sif, gatekeeper Heimdall, and Warriors Three, as they encounter mythical Norse creatures among the evildoers." + "')";
        String input9 = "insert into movie(name,year,director,subject)" + "values('" + "Guardians of the Galaxy" + "','" + "July 31, 2014" + "','" + "James Gunn" + "','" + "Marvel’s Guardians of the Galaxy expands the Marvel Cinematic Universe into the cosmos, where brash adventurer Peter Quill finds himself the object of an unrelenting bounty hunt after stealing a mysterious orb coveted by Ronan, a powerful villain with ambitions that threaten the entire universe.To evade the ever-persistent Ronan, Quill is forced into an uneasy truce with a quartet of disparate misfits — Rocket, a gun-toting raccoon; Groot, a humanoid tree; the deadly and enigmatic Gamora; and the rage/revenge-driven Drax the Destroyer.But when Peter discovers the true power of the orb and the menace it poses to the cosmos, he must do his best to rally his ragtag rivals for a last, desperate stand — with the galaxy’s fate in the balance." + "')";
        String input10 = "insert into movie(name,year,director,subject)" + "values('" + "Guardians of the Galaxy: Vol2" + "','" + "April 25, 2017" + "','" + "James Gunn" + "','" + " Set to the backdrop of Awesome Mixtape 2, Marvels Guardians of the Galaxy Vol. 2 continues the teams adventures as they traverse the outer reaches of the cosmos.The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quills true parentage.Old foes become new allies and fan-favorite characters from the classic comics will come to our heroes aid as the Marvel Cinematic Universe continues to expand. " + "')";
        String input11 = "insert into movie(name,year,director,subject)" + "values('" + "Iron Man 3" + "','" + "April 24, 2013" + "','" + "Shane Black" + "','" + "Tony Stark finds himself facing his most powerful enemy yet when he embarks on a harrowing quest to find those responsible for destroying his private world.Along the way, he discovers the answer to the question that has secretly haunted him: Does the man make the suit or does the suit make the man?" + "')";
        String input12 = "insert into movie(name,year,director,subject)" + "values('" + "Captain America: The Winter Soldier" + "','" + "March 26, 2014" + "','" + "Russo Brothers" + "','" + "wo years after the Battle of New York, Captain America lives quietly in Washington, D.C., still struggling to adapt to the modern society.In hopes of fitting in, Captain America becomes an agent of S.H.I.E.L.D., as well as a close friend of Black Widow and a new hero, Falcon.However, when a shadowy enemy from within the chief offices of S.H.I.E.L.D. (with whom Nick Fury initially agrees) starts creating countless weapons of mass destruction to seemingly protect the world - but really wants to destroy it and rebuild it, Captain America and his colleagues must team up to stop him.\\nBut things get more complicated when Steves thought deceased best friend Bucky is revealed to be alive and a villain like no other - the Winter Soldier." + "')";
        String input13 = "insert into movie(name,year,director,subject)" + "values('" + "Avengers: Age of Ultron" + "','" + "May 1, 2015" + "','" + "Joss Whedon" + "','" + "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and its up to Earths mightiest heroes to stop the villainous Ultron from enacting his terrible plan. " + "')";
        String input14 = "insert into movie(name,year,director,subject)" + "values('" + "Ant-Man" + "','" + "July 14, 2015" + "','" + "Peyton Reed" + "','" + "Armed with the astonishing ability to shrink in scale but increase in strength, master thief Scott Lang must embrace his inner-hero and help his mentor, Dr. Hank Pym, protect the secret behind his spectacular Ant-Man Suit from a new generation of towering threats.\\nAgainst seemingly insurmountable obstacles, Pym and Lang must plan and pull off a heist that will save the world." + "')";
        String input15 = "insert into movie(name,year,director,subject)" + "values('" + "Captain America: Civil War" + "','" + "April 27, 2016" + "','" + "Russo Brothers" + "','" + " Marvel’s Captain America: Civil War finds Steve Rogers leading the newly formed team of Avengers in their continued efforts to safeguard humanity.But after another incident involving the Avengers results in collateral damage, political pressure mounts to install a system of accountability, headed by a governing body to oversee and direct the team.The new status quo fractures the Avengers, resulting in two camps—one led by Steve Rogers and his desire for the Avengers to remain free to defend humanity without government interference, and the other following Tony Stark’s surprising decision to support government oversight and accountability." + "')";
        String input16 = "insert into movie(name,year,director,subject)" + "values('" + "Black Panther" + "','" + "February 16, 2018" + "','" + "Ryan Coogler" + "','" + "After the events of Captain America: Civil War, King TChalla returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his countrys new leader.However, TChalla soon finds that he is challenged for the throne from factions within his own country.When two foes conspire to destroy Wakanda, the hero known as Black Panther must team up with C.I.A. agent Everett K. Ross and members of the Dora Milaje, Wakandan special forces, to prevent Wakanda from being dragged into a world war." + "')";
        String input17 = "insert into movie(name,year,director,subject)" + "values('" + "Spiderman Homecoming" + "','" + "July 5, 2017" + "','" + "Jon Watts" + "','" + "A young Peter Parker/Spider-Man, who made his sensational debut in Captain America: Civil War, begins to navigate his newfound identity as the web-slinging superhero in Spider-Man: Homecoming.Thrilled by his experience with the Avengers, Peter returns home, where he lives with his Aunt May, under the watchful eye of his new mentor Tony Stark.Peter tries to fall back into his normal daily routine – distracted by thoughts of proving himself to be more than just your friendly neighborhood Spider-Man – but when the Vulture emerges as a new villain, everything that Peter holds most important will be threatened." + "')";
        String input18 = "insert into movie(name,year,director,subject)" + "values('" + "Doctor Strange" + "','" + "November 4, 2016" + "','" + "Scott Derrickson" + "','" + "While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts." + "')";
        String input19 = "insert into movie(name,year,director,subject)" + "values('" + "Thor: Ragnarok" + "','" + "October 24, 2017" + "','" + "Taika Waititi" + "','" + "Thors world is about to explode in Marvels Thor: Ragnarok.His devious brother, Loki, has taken over Asgard, the powerful Hela has emerged to steal the throne for herself and Thor is imprisoned on the other side of the universe.\\nTo escape captivity and save his home from imminent destruction, Thor must first win a deadly alien contest by defeating his former ally and fellow Avenger... The Incredible Hulk!" + "')";
        String input20 = "insert into movie(name,year,director,subject)" + "values('" + "Ant-Man & the Wasp" + "','" + "July 6, 2018" + "','" + "Peyton Reed" + "','" + "As Scott Lang balances being both a Super Hero and a father, Hope van Dyne and Dr. Hank Pym present an urgent new mission that finds the Ant-Man fighting alongside The Wasp to uncover secrets from their past." + "')";
        String input21 = "insert into movie(name,year,director,subject)" + "values('" + "Avengers: Infinity War" + "','" + "April 27, 2018" + "','" + "Russo Brothers" + "','" + "An unprecedented cinematic journey ten years in the making and spanning the entire Marvel Cinematic Universe, Marvel Studios Avengers: Infinity War brings to the screen the ultimate, deadliest showdown of all time." + "')";
        String input22 = "insert into movie(name,year,director,subject)" + "values('" + "Avengers: Endgame" + "','" + "April 26, 2019" + "','" + "Russo Brothers" + "','" + "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to undo Thanos actions and restore order to the universe." + "')";

        myDatabase.execSQL(input);
        myDatabase.execSQL(input2);
        myDatabase.execSQL(input3);
        myDatabase.execSQL(input4);
        myDatabase.execSQL(input5);
        myDatabase.execSQL(input6);
        myDatabase.execSQL(input7);
        myDatabase.execSQL(input8);
        myDatabase.execSQL(input9);
        myDatabase.execSQL(input10);
        myDatabase.execSQL(input11);
        myDatabase.execSQL(input12);
        myDatabase.execSQL(input13);
        myDatabase.execSQL(input14);
        myDatabase.execSQL(input15);
        myDatabase.execSQL(input16);
        myDatabase.execSQL(input17);
        myDatabase.execSQL(input18);
        myDatabase.execSQL(input19);
        myDatabase.execSQL(input20);
        myDatabase.execSQL(input21);
        myDatabase.execSQL(input22);


    }

DETAILED detailed = new DETAILED();

    //helper method to check if a database is exist
    private boolean databaseExist(){
        File dbFile = new File(path);
        return dbFile.exists();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //open my database
        String result = "";
        String sub = "";
        String fav = "";
        final ArrayList<String> my_array_nameforfav = new ArrayList<>();
        final ArrayList<String> my_array = new ArrayList<>();
        ArrayList<String> my_array_sub = new ArrayList<>();
        myDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String input = "select * from movie";
        Cursor cursor = myDatabase.rawQuery(input,null);

        while (cursor.moveToNext()) {
            result = cursor.getString(cursor.getColumnIndex("name")) + "\n"
                    + cursor.getString(cursor.getColumnIndex("year")) + "\n"
                    + cursor.getString(cursor.getColumnIndex("director"));

            sub = cursor.getString(cursor.getColumnIndex("subject"));
            fav = cursor.getString(cursor.getColumnIndex("name"));

            my_array.add(result);
            my_array_sub.add(sub);
            my_array_nameforfav.add(fav);

        }
        if(position == 0){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(0));
            intent.putExtra("SUBJECT", my_array_sub.get(0));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(0));
            intent.putExtra("IMAGENAME",items[0]);
            startActivity(intent);

        }
        if(position == 1){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(1));
            intent.putExtra("SUBJECT", my_array_sub.get(1));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(1));
            intent.putExtra("IMAGENAME",items[1]);
            startActivity(intent);


        }
        if(position == 2){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(2));
            intent.putExtra("SUBJECT", my_array_sub.get(2));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(2));
            intent.putExtra("IMAGENAME",items[2]);
            startActivity(intent);
        }
        if(position == 3){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(3));
            intent.putExtra("SUBJECT", my_array_sub.get(3));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(3));
            intent.putExtra("IMAGENAME",items[3]);
            startActivity(intent);
        }
        if(position == 4){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(4));
            intent.putExtra("SUBJECT", my_array_sub.get(4));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(4));
            intent.putExtra("IMAGENAME",items[4]);
            startActivity(intent);
        }
        if(position == 5){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(5));
            intent.putExtra("SUBJECT", my_array_sub.get(5));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(5));
            intent.putExtra("IMAGENAME",items[5]);
            startActivity(intent);
        }
        if(position == 6){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(6));
            intent.putExtra("SUBJECT", my_array_sub.get(6));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(6));
            intent.putExtra("IMAGENAME",items[6]);
            startActivity(intent);
        }
        if(position == 7){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(7));
            intent.putExtra("SUBJECT", my_array_sub.get(7));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(7));
            intent.putExtra("IMAGENAME",items[7]);
            startActivity(intent);
        }
        if(position == 8){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(8));
            intent.putExtra("SUBJECT", my_array_sub.get(8));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(8));
            intent.putExtra("IMAGENAME",items[8]);
            startActivity(intent);
        }
        if(position == 9){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(9));
            intent.putExtra("SUBJECT", my_array_sub.get(9));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(9));
            intent.putExtra("IMAGENAME",items[9]);
            startActivity(intent);
        }
        if(position == 10){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(10));
            intent.putExtra("SUBJECT", my_array_sub.get(10));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(10));
            intent.putExtra("IMAGENAME",items[10]);
            startActivity(intent);
        }
        if(position == 11){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(11));
            intent.putExtra("SUBJECT", my_array_sub.get(11));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(11));
            intent.putExtra("IMAGENAME",items[11]);
            startActivity(intent);
        }
        if(position == 12){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(12));
            intent.putExtra("SUBJECT", my_array_sub.get(12));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(12));
            intent.putExtra("IMAGENAME",items[12]);
            startActivity(intent);
        }
        if(position == 13){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(13));
            intent.putExtra("SUBJECT", my_array_sub.get(13));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(13));
            intent.putExtra("IMAGENAME",items[13]);
            startActivity(intent);
        }
        if(position == 14){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(14));
            intent.putExtra("SUBJECT", my_array_sub.get(14));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(14));
            intent.putExtra("IMAGENAME",items[14]);
            startActivity(intent);
        }
        if(position == 15){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(15));
            intent.putExtra("SUBJECT", my_array_sub.get(15));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(15));
            intent.putExtra("IMAGENAME",items[15]);
            startActivity(intent);
        }
        if(position == 16){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(16));
            intent.putExtra("SUBJECT", my_array_sub.get(16));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(16));
            intent.putExtra("IMAGENAME",items[16]);
            startActivity(intent);
        }
        if(position == 17){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(17));
            intent.putExtra("SUBJECT", my_array_sub.get(17));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(17));
            intent.putExtra("IMAGENAME",items[17]);
            startActivity(intent);
        }
        if(position == 18){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(18));
            intent.putExtra("SUBJECT", my_array_sub.get(18));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(18));
            intent.putExtra("IMAGENAME",items[18]);
            startActivity(intent);
        }
        if(position == 19){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(19));
            intent.putExtra("SUBJECT", my_array_sub.get(19));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(19));
            intent.putExtra("IMAGENAME",items[19]);
            startActivity(intent);
        }
        if(position == 20){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(20));
            intent.putExtra("SUBJECT", my_array_sub.get(20));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(20));
            intent.putExtra("IMAGENAME",items[20]);
            startActivity(intent);
        }
        if(position == 21){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(21));
            intent.putExtra("SUBJECT", my_array_sub.get(21));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(21));
            intent.putExtra("IMAGENAME",items[21]);
            startActivity(intent);
        }
        if(position == 22){
            Intent intent = new Intent(MAIN_TABS.this, DETAILED.class);
            intent.putExtra("MOVIE", my_array.get(22));
            intent.putExtra("SUBJECT", my_array_sub.get(22));
            intent.putExtra("FAVNAME",my_array_nameforfav.get(22));
            intent.putExtra("IMAGENAME",items[22]);
            startActivity(intent);
        }

    }


    public void go_test(View view){
        startActivity(new Intent(MAIN_TABS.this, TRIVIA.class));
    }

    public void go_back_to_explore(View view){
        startActivity(new Intent(MAIN_TABS.this, Explore.class));

    }

    public void go_fav(View view){
        startActivity(new Intent(MAIN_TABS.this, FAV.class));

    }


}
