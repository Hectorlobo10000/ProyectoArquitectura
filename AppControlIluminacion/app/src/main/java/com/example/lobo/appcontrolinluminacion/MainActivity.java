package com.example.lobo.appcontrolinluminacion;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView ip = findViewById(R.id.ip);
        Button test = findViewById(R.id.button);
        final Switch sala = findViewById(R.id.switch1);
        final Switch cocina = findViewById(R.id.switch2);
        final Switch habitacion = findViewById(R.id.switch3);
        sala.setEnabled(false);
        cocina.setEnabled(false);
        habitacion.setEnabled(false);
        final MainActivity activity = this;


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ip.toString().isEmpty()) {
                    Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://" + ip.getText().toString().trim() + "/test";
                    RequestQueue request = Volley.newRequestQueue(activity);
                    JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONArray test = response.getJSONArray("connection");
                                        JSONObject object = test.getJSONObject(0);
                                        boolean value = object.getBoolean("connection");
                                        if (value) {
                                            Toast.makeText(activity, "Connection success", Toast.LENGTH_SHORT).show();
                                            sala.setEnabled(true);
                                            cocina.setEnabled(true);
                                            habitacion.setEnabled(true);
                                        }
                                    } catch (JSONException e) {
                                        /*e.printStackTrace();*/
                                        Toast.makeText(activity, "Error en el objeto", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    request.add(jsonRequest);
                }
            }
        });

        sala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url;
                if(sala.isChecked()) {
                    url = "http://" + ip.getText().toString().trim() + "/home/onledone";
                } else {
                    url = "http://" + ip.getText().toString().trim() + "/home/offledone";
                }
                RequestQueue request = Volley.newRequestQueue(activity);
                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray test = response.getJSONArray("connection");
                            JSONObject object = test.getJSONObject(0);
                            boolean value = object.getBoolean("connection");
                            if(value){
                                Toast.makeText(activity, "Luz encendida", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity, "Luz apagada", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                                        /*e.printStackTrace();*/
                            Toast.makeText(activity, "Error en el objeto", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                request.add(jsonRequest);
            }
        });

        cocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url;
                if(cocina.isChecked()) {
                    url = "http://" + ip.getText().toString().trim() + "/home/onledtwo";
                } else {
                    url = "http://" + ip.getText().toString().trim() + "/home/offledtwo";
                }
                RequestQueue request = Volley.newRequestQueue(activity);
                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray test = response.getJSONArray("connection");
                            JSONObject object = test.getJSONObject(0);
                            boolean value = object.getBoolean("connection");
                            if(value){
                                Toast.makeText(activity, "Luz encendida", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity, "Luz apagada", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                                        /*e.printStackTrace();*/
                            Toast.makeText(activity, "Error en el objeto", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                request.add(jsonRequest);
            }
        });

        habitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url;
                if(habitacion.isChecked()) {
                    url = "http://" + ip.getText().toString().trim() + "/home/onledthree";
                } else {
                    url = "http://" + ip.getText().toString().trim() + "/home/offledthree";
                }
                RequestQueue request = Volley.newRequestQueue(activity);
                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray test = response.getJSONArray("connection");
                            JSONObject object = test.getJSONObject(0);
                            boolean value = object.getBoolean("connection");
                            if(value){
                                Toast.makeText(activity, "Luz encendida", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity, "Luz apagada", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                                        /*e.printStackTrace();*/
                            Toast.makeText(activity, "Error en el objeto", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                request.add(jsonRequest);
            }
        });
    }
}
