package com.example.keith.prog2b;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.util.*;

public class Longlist extends AppCompatActivity {
    TextView h;
    TextView sen1;
    TextView sen2;
    TextView label1;
    TextView label2;
    TextView label3;
    Button more;
    ImageView firste;
    ImageView sece;
    ImageView thirde;

    ImageView wb1;
    ImageView wb2;
    ImageView wb3;

    ImageView m1;
    ImageView m2;
    ImageView m3;

    TextView p1;
    TextView p2;
    TextView p3;
    TextView zipcode;
    final String hou = "Representative |";
    final String sen8 = "Senator |";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longlist);

        String temp = "House of Rep";
        String temp2 = "Senate";

        final int no = getIntent().getIntExtra("num",2);
        firste = findViewById(R.id.imageView9);
        sece = findViewById(R.id.imageView16);
        thirde = findViewById(R.id.imageView26);
        zipcode = findViewById(R.id.zip);

        p1 = findViewById(R.id.textView7);
        p2 = findViewById(R.id.textView9);
        p3 = findViewById(R.id.textView2);

        final String pa1 = getIntent().getStringExtra("p1");
        final String pa2 = getIntent().getStringExtra("p2");
        final String pa3 = getIntent().getStringExtra("p3");
        final String pa4 = getIntent().getStringExtra("p4");

        m1 = findViewById(R.id.imageView10);
        m2 = findViewById(R.id.imageView29);
        m3 = findViewById(R.id.imageView14);

        h = (TextView) findViewById(R.id.house);
        sen1 = (TextView) findViewById(R.id.senate);
        sen2 = (TextView) findViewById(R.id.senate2);
        label1 = (TextView) findViewById(R.id.textView5);
        label2 = (TextView) findViewById(R.id.textView8);
        label3 = (TextView) findViewById(R.id.textView3);

        final String s = getIntent().getStringExtra("rep");
        final String s4 = getIntent().getStringExtra("senate3");
        final String s1 = getIntent().getStringExtra("senate1");

        final String em1 = getIntent().getStringExtra("em");
        final String em2 = getIntent().getStringExtra("em2");
        final String em3 = getIntent().getStringExtra("em3");
        final String em4 = getIntent().getStringExtra("em4");

        final String w1 = getIntent().getStringExtra("w1");
        final String w2 = getIntent().getStringExtra("w2");
        final String w3 = getIntent().getStringExtra("w3");
        final String w4 = getIntent().getStringExtra("w4");
        final String s2 = getIntent().getStringExtra("senate2");
        final String a = getIntent().getStringExtra("zip");
        zipcode.setText(a);
        zipcode.setPaintFlags(zipcode.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        zipcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Longlist.this, MainActivity.class);
                startActivity(i);
                }
                });
        wb1 = findViewById(R.id.imageView8);
        wb2 = findViewById(R.id.imageView28);
        wb3 = findViewById(R.id.imageView15);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a11 = new Intent(Longlist.this,Profile.class);
                a11.putExtra("xd1",s);
                a11.putExtra("em",em1);
                a11.putExtra("w",w1);
                a11.putExtra("p",pa1);
                a11.putExtra("a",hou);
                startActivity(a11);
            }
        });
        wb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w1);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });
        wb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse(w4);
                Intent intent = new Intent(Intent.ACTION_VIEW,u);
                startActivity(intent);
            }
        });

        if (no == 2) {
            h.setText(s);
            sen1.setText(s4);
            sen2.setText(s1);
            label1.setText(temp);
            label2.setText(temp);
            label3.setText(temp2);
            p1.setText(pa1);
            p2.setText(pa4);
            p3.setText(pa2);
            m2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a11 = new Intent(Longlist.this,Profile.class);
                    a11.putExtra("xd1",s4);
                    a11.putExtra("em",em4);
                    a11.putExtra("w",w4);
                    a11.putExtra("p",pa4);
                    a11.putExtra("a",hou);
                    startActivity(a11);
                }
            });
            m3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a11 = new Intent(Longlist.this,Profile.class);
                    a11.putExtra("xd1",s1);
                    a11.putExtra("em",em2);
                    a11.putExtra("w",w2);
                    a11.putExtra("p",pa2);
                    a11.putExtra("a",sen8);
                    startActivity(a11);
                }
            });
            wb3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(w2);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            firste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em1);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            sece.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em4);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            thirde.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em2);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            more = (Button) findViewById(R.id.buttonz);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Longlist.this,second.class);
                    i.putExtra("num",no);
                    i.putExtra("zip",a);
                    i.putExtra("cong",s2);
                    i.putExtra("web1",w3);
                    i.putExtra("em2",em3);
                    i.putExtra("p",pa3);
                    i.putExtra("a",sen8);
                    startActivity(i);

                }
            });

        }
        else if (no == 3) {
            final String s3 = getIntent().getStringExtra("senate4");

            h.setText(s);
            sen1.setText(s4);
            sen2.setText(s1);
            label1.setText(temp);
            label2.setText(temp);
            label3.setText(temp);
        }
        else {
            final String s3 = getIntent().getStringExtra("senate4");
            final String s5 = getIntent().getStringExtra("senate5");
            final String em5 = getIntent().getStringExtra("em5");
            final String w5 = getIntent().getStringExtra("w5");
            final String em6 = getIntent().getStringExtra("em6");
            final String w6 = getIntent().getStringExtra("w6");
            final String pa5 = getIntent().getStringExtra("p5");
            final String pa6 = getIntent().getStringExtra("p6");
            h.setText(s);
            sen1.setText(s4);
            sen2.setText(s3);
            p1.setText(pa1);
            p2.setText(pa4);
            p3.setText(pa5);
            more = (Button) findViewById(R.id.buttonz);
            m2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Longlist.this,Profile.class);
                    i.putExtra("xd1",s4);
                    i.putExtra("w",w4);
                    i.putExtra("em",em4);
                    i.putExtra("a",hou);
                    startActivity(i);
                }
            });
            m3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Longlist.this,Profile.class);
                    i.putExtra("xd1",s3);
                    i.putExtra("em",em5);
                    i.putExtra("w",w5);
                    i.putExtra("a",hou);
                    startActivity(i);
                }
            });
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Longlist.this,second.class);
                    i.putExtra("num",no);
                    i.putExtra("zip",a);
                    i.putExtra("cong",s5);
                    i.putExtra("cong1",s2);
                    i.putExtra("cong2",s1);
                    i.putExtra("em6",em6);
                    i.putExtra("w6",w6);
                    i.putExtra("em3",em3);
                    i.putExtra("w3",w3);
                    i.putExtra("em2",em2);
                    i.putExtra("w2",w2);
                    i.putExtra("p6",pa6);
                    i.putExtra("p2",pa2);
                    i.putExtra("p3",pa3);


                    startActivity(i);

                }
            });
            label1.setText(temp);
            label2.setText(temp);
            label3.setText(temp);
        }




    }
}
