package com.mohammed.shameem.clist;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends Activity {
    private ListView lvDetail;
    private Context context = MainActivity.this;
    private ArrayList myList = new ArrayList();
    private static final String URL_TO_PARSE = "http://services.hanselandpetal.com/feeds/flowers.json";
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDetail = (ListView) findViewById(R.id.lvCustomList);
        // insert data into the list before setting the adapter
        // otherwise it will generate NullPointerException  - Obviously
        getDataFromJson();


    }

    private void getDataFromJson() {
// Instantiate the RequestQueue.
        client=new AsyncHttpClient();
        client.get(context, URL_TO_PARSE, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response=new String(responseBody);
                /*response=response.substring(3);
                response=response.substring(0,response.length()-2);
                */
                final GsonBuilder gsonBuilder = new GsonBuilder();
                final Gson gson = gsonBuilder.create();

                Flower[] flower =  gson.fromJson(response, Flower[].class);
                myList.add(flower);
                lvDetail.setAdapter(new MyBaseAdapter(context, myList));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

      /*  RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "http://www.google.com";
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_TO_PARSE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        try {

                        } catch (Exception e) {

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
*/
    }


}