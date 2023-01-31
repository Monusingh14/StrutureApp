package com.example.myapp.HalperClass;


import android.content.SharedPreferences;

import com.example.myapp.ModalClass.Userdata;
import com.google.gson.Gson;

public class PrefUtiles
{
    private SharedPreferences preferences;
    public PrefUtiles(SharedPreferences sharedPreferences)
    {
        this.preferences=sharedPreferences;
    }
    public boolean isLogin()
    {
        return  this.preferences.getBoolean("is_login",false);
    }
    public void logout()
    {
        this.preferences.edit().putBoolean("is_login",false).apply();
        this.preferences.edit().putString("user_data","").apply();
    }
    public void login(Userdata userdata)
    {
        Gson gson=new Gson();
        String json=gson.toJson(userdata);
        this.preferences.edit().putBoolean("is_login",true).apply();
        this.preferences.edit().putString("user_data",json).apply();
    }
public Userdata getUserData()
{
    Gson gson=new Gson();
    String json=this.preferences.getString("user_data","");
    return gson.fromJson(json,Userdata.class);
}
public void setUserData(Userdata userdata)
{
    Gson gson=new Gson();
    String json=gson.toJson(userdata);
    this.preferences.edit().putString("user_data",json).apply();
}

}
