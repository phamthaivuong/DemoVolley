package com.example.phamthaivuong.demovolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {
    TextView txtHienThi;
    String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtHienThi = (TextView)findViewById(R.id.txt_hienthi);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(Main3Activity.this, response.toString(), Toast.LENGTH_LONG).show();
                for (int i = 0;i<response.length();i++){
                    try {
                        JSONObject jsonObject = (JSONObject)response.get(i);
                        String khoahoc = jsonObject.getString("khoahoc");
                        Integer hocphi = jsonObject.getInt("hocphi");
                        txtHienThi.append(khoahoc + "" +hocphi + "\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main3Activity.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
