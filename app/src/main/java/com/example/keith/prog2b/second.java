package com.example.keith.prog2b;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Paint;


import org.w3c.dom.Text;


public class second extends AppCompatActivity {
    ImageView i12;
    ImageView i13;
    ImageView i29;
    ImageView i28;
    ImageView i16;
    ImageView i18;
    ImageView i22;
    ImageView i23;
    ImageView i25;
    ImageView i26;
    ImageView i15;
    ImageView i14;
    TextView house;
    TextView senate;
    TextView senate2;
    TextView tv3;
    TextView tv8;
    TextView tv2;
    TextView tv9;
    TextView email2;
    TextView email8;
    TextView email10;
    TextView email6;
    TextView email11;
    TextView email9;
    Button back;

    TextView zipcode;

    ImageView i9;
    ImageView i8;
    ImageView i10;
    TextView tv5;

    TextView tv7;

    final String hou = "Representative |";
    final String sen8 = "Senator |";
    final String sen = "Senator";
    final String hor = "House of Rep";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        zipcode = findViewById(R.id.zip);
        back = (Button) findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv7 = findViewById(R.id.textView7);
        tv5 = findViewById(R.id.textView5);
        tv3 = findViewById(R.id.textView3);
        tv8 = findViewById(R.id.textView8);
        i9 = findViewById(R.id.imageView9);
        i8 = findViewById(R.id.imageView8);
        i10 = findViewById(R.id.imageView10);
        house = (TextView) findViewById(R.id.house);
        i12 = (ImageView) findViewById(R.id.imageView12);
        i13 = (ImageView) findViewById(R.id.imageView13);
        i29 = (ImageView) findViewById(R.id.imageView29);
        i28 = findViewById(R.id.imageView28);
        i16 = findViewById(R.id.imageView16);
        i18 = findViewById(R.id.imageView18);
        i22 = findViewById(R.id.imageView22);
        i23 = findViewById(R.id.imageView23);
        i25 = findViewById(R.id.imageView25);
        i26 =findViewById(R.id.imageView26);
        i15 = findViewById(R.id.imageView15);
        i14 = findViewById(R.id.imageView14);

        tv2 = findViewById(R.id.textView2);
        tv9 = findViewById(R.id.textView9);
        email2 = findViewById(R.id.email2);
        email6 = findViewById(R.id.email6);
        email9 = findViewById(R.id.email9);
        email8 = findViewById(R.id.email8);
        email10 = findViewById(R.id.email10);
        email11 = findViewById(R.id.email11);
        senate = findViewById(R.id.senate);
        senate2 = findViewById(R.id.senate2);
        String a = getIntent().getStringExtra("zip");
        zipcode.setText(a);
        zipcode.setPaintFlags(zipcode.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        zipcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(second.this, MainActivity.class);
                startActivity(i);
            }
        });
        String num = getIntent().getStringExtra("num");
        if (getIntent().getIntExtra("num",2)== 2){
            final String name = getIntent().getStringExtra("cong");
            house.setText(name);
            final String web1 = getIntent().getStringExtra("web1");
            final String em1 = getIntent().getStringExtra("em2");
            final String p = getIntent().getStringExtra("p");
            tv7.setText(p);
            tv5.setText(sen);
            i9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em1);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(web1);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(second.this, Profile.class);
                    i.putExtra("xd1", name);
                    i.putExtra("w", web1);
                    i.putExtra("em", em1);
                    i.putExtra("p",p);
                    i.putExtra("a",sen8);
                    startActivity(i);
                }
            });
        }

        else if (getIntent().getIntExtra("num",2) == 3) {
            i13.setVisibility(View.VISIBLE);
            i12.setVisibility(View.VISIBLE);
        }
        else {
            i13.setVisibility(View.VISIBLE);
            i12.setVisibility(View.VISIBLE);
            i29.setVisibility(View.VISIBLE);
            i28.setVisibility(View.VISIBLE);
            i16.setVisibility(View.VISIBLE);
            i18.setVisibility(View.VISIBLE);
            i22.setVisibility(View.VISIBLE);
            i23.setVisibility(View.VISIBLE);
            i25.setVisibility(View.VISIBLE);
            i26.setVisibility(View.VISIBLE);
            i15.setVisibility(View.VISIBLE);
            i14.setVisibility(View.VISIBLE);

            tv3.setVisibility(View.VISIBLE);
            tv8.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.VISIBLE);
            tv9.setVisibility(View.VISIBLE);
            email2.setVisibility(View.VISIBLE);
            email8.setVisibility(View.VISIBLE);
            email6.setVisibility(View.VISIBLE);
            email11.setVisibility(View.VISIBLE);
            email9.setVisibility(View.VISIBLE);
            email10.setVisibility(View.VISIBLE);
            senate.setVisibility(View.VISIBLE);
            senate2.setVisibility(View.VISIBLE);

            final String hos = getIntent().getStringExtra("cong");
            final String se1 = getIntent().getStringExtra("cong1");
            final String se2 = getIntent().getStringExtra("cong2");
            final String em6 = getIntent().getStringExtra("em6");
            final String w6 = getIntent().getStringExtra("w6");
            final String em2 = getIntent().getStringExtra("em2");
            final String w2 = getIntent().getStringExtra("w2");
            final String em3 = getIntent().getStringExtra("em3");
            final String w3 = getIntent().getStringExtra("w3");
            final String p6 = getIntent().getStringExtra("p6");
            final String p2 = getIntent().getStringExtra("p2");
            final String p3 = getIntent().getStringExtra("p3");
            tv7.setText(p6);
            tv9.setText(p2);
            tv2.setText(p3);
            tv5.setText(hor);
            tv3.setText(sen);
            tv8.setText(sen);

            i8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(w6);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em6);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });

            i10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(second.this,Profile.class);
                    i.putExtra("xd1",hos);
                    i.putExtra("em",em6);
                    i.putExtra("w",w6);
                    i.putExtra("p",p6);
                    i.putExtra("a",hou);
                    startActivity(i);
                }
            });
            i16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em2);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i28.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(w2);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i29.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(second.this,Profile.class);
                    i.putExtra("xd1",se2);
                    i.putExtra("em",em2);
                    i.putExtra("w",w2);
                    i.putExtra("p",p2);
                    i.putExtra("a",sen8);
                    startActivity(i);
                }
            });
            i26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(em3);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });

            i15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri u = Uri.parse(w3);
                    Intent intent = new Intent(Intent.ACTION_VIEW,u);
                    startActivity(intent);
                }
            });
            i14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(second.this,Profile.class);
                    i.putExtra("xd1",se1);
                    i.putExtra("em",em3);
                    i.putExtra("w",w3);
                    i.putExtra("p",p3);
                    i.putExtra("a",sen8);
                    startActivity(i);
                }
            });
            house.setText(hos);
            senate.setText(se2);
            senate2.setText(se1);
        }
    }
}
