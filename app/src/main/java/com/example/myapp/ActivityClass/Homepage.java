package com.example.myapp.ActivityClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapp.HalperClass.Constants;
import com.example.myapp.HalperClass.PrefUtiles;
import com.example.myapp.MainActivity;
import com.example.myapp.R;

public class Homepage extends AppCompatActivity
{
    PrefUtiles preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        preferences=new PrefUtiles(getApplication().getSharedPreferences(Constants.PREF_NAME,MODE_PRIVATE));
    }

    public void logout(View view)
    {
        preferences.logout();
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        ActivityCompat.finishAffinity(Homepage.this);
    }
}