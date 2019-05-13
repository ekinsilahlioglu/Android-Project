package com.example.final_project;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CREDITS extends AppCompatActivity {
    TextView marvel,credits;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        marvel = findViewById(R.id.marvel);
        credits = findViewById(R.id.credits);

        Typeface font = Typeface.createFromAsset(getAssets(), "AVENGEANCE.ttf");
        marvel.setTypeface(font);
        credits.setTypeface(font);
    }
}
