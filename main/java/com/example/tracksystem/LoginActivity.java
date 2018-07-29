package com.example.tracksystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=(EditText)findViewById(R.id.uname);
        t2=(EditText)findViewById(R.id.pass);
    }

    public void submit(View v){
        login();

    }

    private void login(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.isEmpty()){
                            Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();

                            try {

                                JSONObject j = new JSONObject(response);
                                Gson g=new Gson();
                               User u=g.fromJson(j.toString(),User.class);
                            if(u!=null){
                                Intent in=new Intent(LoginActivity.this,MainActivity.class);
                                in.putExtra("user",u);
                                startActivity(in);
                                finish();
                            }
                            }catch(Exception e){

                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Server Error " +error, Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //key must same with server parameter
                params.put("uname",t1.getText().toString());
                params.put("pass",t2.getText().toString());
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);


    }
}
