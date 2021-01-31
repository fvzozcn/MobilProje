package com.example.odevtekrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView lstv;
    String _url;
    List<webUser> webUsers;
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstv=findViewById(R.id.lstv);
        webUsers=new ArrayList<webUser>();
        _url="https://run.mocky.io/v3/05ecacd6-f9e3-48e9-b1e5-f1092ac4a145";
        getVolley(new VolleyCallBack() {
            @Override
            public void finish() {
                userAdap a=new userAdap(webUsers,MainActivity2.this);
                lstv.setAdapter(a);
                lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i=new Intent(MainActivity2.this,vwplayer.class);
                        i.putExtra("vw",webUsers.get(position)._th);
                        startActivity(i);

                    }
                });
            }
        });

    }
    public interface VolleyCallBack
    {
        void finish();
    }

    public void getVolley(VolleyCallBack callBack)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest json=new JsonObjectRequest(Request.Method.GET, _url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jo = response.getJSONArray("data");
                    for (int i = 0; i < jo.length(); i++) {
                        JSONObject jso = jo.getJSONObject(i);

                        String _ad = jso.getString("name");
                        String _yil = jso.getString("year");
                        String _th = jso.getString("url");
                        webUsers.add(new webUser(_ad,_yil,_th));

                    }
                    callBack.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });requestQueue.add(json);
    }
}