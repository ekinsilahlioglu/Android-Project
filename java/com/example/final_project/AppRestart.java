package com.example.final_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AppRestart extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.exit(0);
    }
    public static void doRestart(Activity anyActivity) {
        anyActivity.startActivity(new Intent(anyActivity.getApplicationContext(), MainActivity.class));
    }

}
