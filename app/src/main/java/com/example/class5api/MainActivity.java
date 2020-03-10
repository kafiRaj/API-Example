package com.example.class5api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfileAdapter profileAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;

    private RequestQueue mQueue;

    String url = "https://reqres.in/api/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylerId);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mQueue = Volley.newRequestQueue(this);
        profileModelArrayList = new ArrayList<>();





    ApiResult();


    }




    private void ApiResult() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject data = jsonArray.getJSONObject(i);

                        String id = data.getString("id");
                        String email = data.getString("email");
                        String first_name = data.getString("first_name");
                        String last_name = data.getString("last_name");
                        String avatar = data.getString("avatar");


                        profileModelArrayList.add(new ProfileModel(email,first_name,last_name,avatar));
                    }


                    profileAdapter = new ProfileAdapter(MainActivity.this, profileModelArrayList);
                    recyclerView.setAdapter(profileAdapter);



                } catch (JSONException e) {
                    e.printStackTrace();


                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        });

        mQueue.add(jsonObjectRequest);

    }


}
