package com.example.myapp.ActivityClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.myapp.HalperClass.ApiConfigration;
import com.example.myapp.HalperClass.Constants;
import com.example.myapp.HalperClass.PrefUtiles;
import com.example.myapp.HalperClass.VollyCallBack;
import com.example.myapp.ModalClass.Userdata;
import com.example.myapp.R;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class Login_Activity extends AppCompatActivity
{
    EditText usermobile,password;
    PrefUtiles preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        prefUtils = new PrefUtils(getApplication().getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE));

        preferences=new PrefUtiles(getApplication().getSharedPreferences(Constants.PREF_NAME,MODE_PRIVATE));
        usermobile=findViewById(R.id.usermobile);
        password=findViewById(R.id.password);

    }


    public void loginclick(View view)
    {
        String usermobilestring=usermobile.getText().toString().trim();
        String userpasswordstring=password.getText().toString().trim();

        if (usermobilestring.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "enter the usermobile", Toast.LENGTH_SHORT).show();

        }else if (userpasswordstring.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "enter the userpassword", Toast.LENGTH_SHORT).show();


        }else
        {
            try
            {
                JSONObject body=new JSONObject();
                body.accumulate("mobile",usermobilestring);
                body.accumulate("user_password",userpasswordstring);
                ApiConfigration.RequestToVolley(new VollyCallBack() {
                    @Override
                    public String onResponse(boolean success, String message) {
                        try
                        {
                            if (success)
                            {
                                JSONObject response=new JSONObject(message);
                                if (response.getBoolean("status"))
                                {
                                    Userdata userdata=new Userdata(
                                            response.getString("id"),
                                            response.getString("full_name"),
                                            response.getString("email"),
                                            response.getString("mobile"),
                                            response.getString("plot"),
                                            response.getString("address_lane_1"),
                                            response.getString("address_lane_2"),
                                            response.getString("area"),
                                            response.getString("pincode")

                                    );
                                    preferences.login(userdata);
                                    Intent intent = new Intent(getApplicationContext(), Homepage.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    ActivityCompat.finishAffinity(Login_Activity.this);
                                    Toast.makeText(getApplicationContext(),"Successfully login", Toast.LENGTH_LONG).show();



                                } else {
                                    Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_LONG).show();

                                }


                            }

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }


                        return message;
                    }
                },Login_Activity.this, Constants.loginapi,body, Request.Method.POST);


            }catch (Exception e)
            {
                e.printStackTrace();
            }



        }

    }
}