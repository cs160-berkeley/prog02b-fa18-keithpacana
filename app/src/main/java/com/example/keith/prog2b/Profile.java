package com.example.keith.prog2b;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {
    TextView name;
    ImageView email;
    ImageView website;
    TextView party;
    TextView aff;
    TextView zcode;
    Button back1;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = findViewById(R.id.imageView11);
        website = findViewById(R.id.imageView17);
        aff = findViewById(R.id.textView10);
        back1 = findViewById(R.id.button4);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        home = findViewById(R.id.button3);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this,MainActivity.class);
                startActivity(i);
            }
        });
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String n = getIntent().getStringExtra("xd1");
        final String e = getIntent().getStringExtra("em");
        final String w = getIntent().getStringExtra("w");
        final String p = getIntent().getStringExtra("p");
        final String a = getIntent().getStringExtra("a");
        name = (TextView) findViewById(R.id.textView4);
        party = findViewById(R.id.textView11);
        party.setText(p);
        name.setText(n);
        aff.setText(a);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(e);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
    }
}
