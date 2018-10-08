package com.example.keith.prog2b;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.util.HashMap;
import android.net.Uri;
import java.net.URL;

public class SearchRes extends AppCompatActivity {
    private JsonObjectRequest request;
    private RequestQueue req_q;
    private final String JSON_URL = "https://api.geocod.io/v1.3/geocode?postal_code=94704&fields=cd," +
            "stateleg&api_key=6b88c89ba6082d8559b0a0c3360b43dde5cbdab";
    String full_name;
    TextView test;
    TextView test1;
    TextView test2;
    TextView zipcode;
    ImageView e1;
    ImageView e2;
    ImageView e3;
    ImageView we1;
    ImageView we2;
    ImageView we3;
    ImageView m1;
    ImageView m2;
    ImageView m3;

    TextView p1;
    TextView p2;
    TextView p3;
    final String h = "Representative |";
    final String sen8 = "Senator |";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_res);
        test = findViewById(R.id.house);
        test1 = findViewById(R.id.senate);
        test2 = findViewById(R.id.senate2);
        e1 = findViewById(R.id.imageView9);
        e2 = findViewById(R.id.imageView16);
        e3 = findViewById(R.id.imageView26);
        we1 = findViewById(R.id.imageView8);
        we2 = findViewById(R.id.imageView28);
        we3 = findViewById(R.id.imageView15);
        m1 = findViewById(R.id.imageView10);
        m2 = findViewById(R.id.imageView29);
        m3 = findViewById(R.id.imageView14);
        p1 = findViewById(R.id.textView7);
        p2 = findViewById(R.id.textView9);
        p3 = findViewById(R.id.textView2);
        zipcode = findViewById(R.id.zip);



        final String s1 = getIntent().getStringExtra("senate1");
        final String s2 = getIntent().getStringExtra("senate2");
        final String s3 = getIntent().getStringExtra("rep");
        String a = getIntent().getStringExtra("zip");
        final String em1 = getIntent().getStringExtra("em");
        final String em2 = getIntent().getStringExtra("em2");
        final String em3 = getIntent().getStringExtra("em3");
        final String w1 = getIntent().getStringExtra("w1");
        final String w2 = getIntent().getStringExtra("w2");
        final String w3 = getIntent().getStringExtra("w3");
        final String pa1 = getIntent().getStringExtra("p1");
        final String pa2 = getIntent().getStringExtra("p2");
        final String pa3 = getIntent().getStringExtra("p3");
        p1.setText(pa1);
        p2.setText(pa2);
        p3.setText(pa3);

        zipcode.setText(a);
        zipcode.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchRes.this,MainActivity.class);
                startActivity(i);
            }
        });
        m1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a11 = new Intent(SearchRes.this,Profile.class);
                a11.putExtra("xd1",s3);
                a11.putExtra("em",em1);
                a11.putExtra("w",w1);
                a11.putExtra("p",pa1);
                a11.putExtra("a",h);
                startActivity(a11);
            }
        });
        m2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchRes.this,Profile.class);
                i.putExtra("xd1",s1);
                i.putExtra("em",em2);
                i.putExtra("w",w2);
                i.putExtra("p",pa2);
                i.putExtra("a",sen8);
                startActivity(i);
            }
        });
        m3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchRes.this,Profile.class);
                i.putExtra("xd1",s2);
                i.putExtra("em",em3);
                i.putExtra("w",w3);
                i.putExtra("p",pa3);
                i.putExtra("a",sen8);
                startActivity(i);
            }
        });
        zipcode = (TextView) findViewById(R.id.zip);

        we1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w1);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        we2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w2);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        we3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w3);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        e1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(em1);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        e2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(em2);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        e3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(em3);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        test.setText(s3);
        test1.setText(s1);
        test2.setText(s2);
        zipcode.setText(a);
        zipcode.setPaintFlags(zipcode.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

    }

}
