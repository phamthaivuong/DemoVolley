package com.example.phamthaivuong.demovolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    TextView txtHienThi;
    String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtHienThi = (TextView)findViewById(R.id.txt_hienthi);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String monhoc = response.getString("monhoc");
                    String noihoc = response.getString("noihoc");
                    String website = response.getString("website");
                    String fanpage = response.getString("fanpage");
                    String logo = response.getString("logo");

                    txtHienThi.setText(monhoc + "\n"+ noihoc + "\n"+ website+ "\n"+fanpage+ "\n"+logo);
                } catch (JSONException e) {
                    Log.d("Error",e.toString());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
