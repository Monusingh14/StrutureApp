package com.example.myapp.HalperClass;


import android.app.Activity;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ApiConfigration
{
    public static void RequestToVolley(VollyCallBack vollyCallBack, Activity activity, String url, JSONObject data, int method) {
        try {
            Utiles.logApiRequest(url, data);
            RequestQueue requestQueue = Volley.newRequestQueue(activity);
            JsonObjectRequest request = new JsonObjectRequest(method, url, data, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Utiles.logApiResponse(url, response);
                    vollyCallBack.onResponse(true, response.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    vollyCallBack.onResponse(false, error.getMessage());

                }
            });
            requestQueue.add(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
