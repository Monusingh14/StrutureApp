package com.example.myapp.HalperClass;

import org.json.JSONObject;

public class Utiles
{

    public static void logApiResponse(String apiUrl, JSONObject response)
    {
        System.out.println("Response: " + apiUrl +"=========>"+response);

    }
    public static void logApiRequest(String apiUrl, JSONObject request)
    {
        System.out.println("Request: " + apiUrl +"=========>"+request);

    }
}
