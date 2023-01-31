package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapp.ActivityClass.Homepage;
import com.example.myapp.ActivityClass.Login_Activity;
import com.example.myapp.HalperClass.Constants;
import com.example.myapp.HalperClass.PrefUtiles;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrefUtiles preferences=new PrefUtiles(getApplication().getSharedPreferences(Constants.PREF_NAME,MODE_PRIVATE));

        if (preferences.isLogin())
        {
            Intent intent = new Intent(getApplicationContext(), Homepage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            ActivityCompat.finishAffinity(MainActivity.this);

        }else
        {

            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            ActivityCompat.finishAffinity(MainActivity.this);

        }

    }
}