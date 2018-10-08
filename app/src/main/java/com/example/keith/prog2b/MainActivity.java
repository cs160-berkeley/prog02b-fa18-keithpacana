package com.example.keith.prog2b;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;

import com.google.android.gms.tasks.OnSuccessListener;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.Locale;
import java.util.Random;



import android.Manifest;


public class MainActivity extends AppCompatActivity {
    private String JSON_URL;
    private JsonObjectRequest request;
    private RequestQueue req_q;
    TextView ab;
    TextView ab1;
    public Button get_informed;
    String full_name;
    EditText zip;
    String zcode;
    Intent mIntent;
    Button rando;
    String[] listzip;
    public Button curr_loc;
    final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 1234;
    private GoogleMap mMap;
    LocationManager locationManager;
    private GoogleMap mGoogleMap;
    private FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(MainActivity.this);

            get_informed = (Button) findViewById(R.id.getinformedbutton);
            req_q = Volley.newRequestQueue(this);
            zip = (EditText) findViewById(R.id.zipcode);
            rando = (Button) findViewById(R.id.currbutton);
            rando.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listzip = getResources().getStringArray(R.array.zip_codes);
                    Random r = new Random();
                    int Low = 0;
                    int High = 41465;
                    int Result = r.nextInt(High-Low) + Low;
                    zcode = listzip[Result];
                    JSON_URL = "https://api.geocod.io/v1.3/geocode?postal_code=" + zcode + "&fields=cd," +
                            "stateleg&api_key=6b88c89ba6082d8559b0a0c3360b43dde5cbdab";
                    jssonrequest();


                }
            });

            curr_loc = (Button) findViewById(R.id.button2);
            curr_loc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED){
                    return;
                }
                client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            double lati = location.getLatitude();
                            double longi = location.getLongitude();
                            Geocoder geocoder;
                            List<Address> addresses;
                            geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                            try {
                                List<Address> addy = geocoder.getFromLocation(lati, longi, 1);
                                String z = addy.get(0).getPostalCode();
                                zcode = z;
                                JSON_URL = "https://api.geocod.io/v1.3/geocode?postal_code=" + z + "&fields=cd," +
                                        "stateleg&api_key=6b88c89ba6082d8559b0a0c3360b43dde5cbdab";
                                jssonrequest();

                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                }});
            }
        });
            get_informed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String z = zip.getText().toString();
                    zcode = z;
                    JSON_URL = "https://api.geocod.io/v1.3/geocode?postal_code=" + z + "&fields=cd," +
                            "stateleg&api_key=6b88c89ba6082d8559b0a0c3360b43dde5cbdab";
                    jssonrequest();
                }
            });
            Log.d("hello!", "he");

        }


        private void requestPermission(){
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        private void jssonrequest() {
            request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray s1 = response.getJSONArray("results");
                        JSONObject s2 = s1.getJSONObject(0);
                        JSONObject s3 = s2.getJSONObject("fields");
                        JSONArray s4 = s3.getJSONArray("congressional_districts");
                        int num_reps = s4.length();
                        JSONObject s5 = s4.getJSONObject(0);
                        JSONArray s6 = s5.getJSONArray("current_legislators");
                        int len = s6.length();
                        JSONObject rep = s6.getJSONObject(0);
                        JSONObject ref = rep.getJSONObject("references");
                        String id = ref.getString("bioguide_id");
                        JSONObject cont = rep.getJSONObject("contact");
                        String email = cont.getString("contact_form");
                        String web = cont.getString("url");
                        if (email == null) {
                            email = web;
                        }
                        JSONObject s8 = rep.getJSONObject("bio");
                        String first = s8.getString("first_name");
                        String last = s8.getString("last_name");
                        String p1 = s8.getString("party");


                        JSONObject senate = s6.getJSONObject(1);
                        JSONObject ref2 = senate.getJSONObject("references");
                        String id2 = ref2.getString("bioguide_id");
                        JSONObject cont2 = senate.getJSONObject("contact");
                        String email2 = cont2.getString("contact_form");
                        String web2 = cont2.getString("url");
                        if (email2 == null) {
                            email2 = web2;
                        }
                        JSONObject s9 = senate.getJSONObject("bio");
                        String first1 = s9.getString("first_name");
                        String last1 = s9.getString("last_name");
                        String p2 = s9.getString("party");

                        JSONObject senate2 = s6.getJSONObject(2);
                        JSONObject ref3 = senate2.getJSONObject("references");
                        JSONObject s10 = senate2.getJSONObject("bio");
                        JSONObject cont3 = senate2.getJSONObject("contact");
                        String email3 = cont3.getString("contact_form");
                        String web3 = cont3.getString("url");
                        if (email3 == null) {
                            email3 = web3;
                        }
                        String first2 = s10.getString("first_name");
                        String last2 = s10.getString("last_name");
                        String p3 = s10.getString("party");

                        String full_name = first + " " + last;
                        String full_name1 = first1 +" " + last1;
                        String full_name2 = first2 + " " +last2;
                        if (num_reps == 2) {
                            //more than 1 districts
                            JSONObject a1 =s4.getJSONObject(1);
                            JSONArray a2 = a1.getJSONArray("current_legislators");
                            JSONObject a3 = a2.getJSONObject(0);
                            JSONObject a4 = a3.getJSONObject("bio");
                            JSONObject con = a3.getJSONObject("contact");
                            String e1 = con.getString("contact_form");
                            String we1 = con.getString("url");
                            if (e1 == null) {
                                e1 = we1;
                            }
                            String f1 = a4.getString("first_name");
                            String f2 = a4.getString("last_name");
                            String f3 = f1 + " " +f2;
                            String p4 = a4.getString("party");



                            mIntent = new Intent(MainActivity.this, Longlist.class);
                            mIntent.putExtra("p1",p1);
                            mIntent.putExtra("p2",p2);
                            mIntent.putExtra("p3",p3);
                            mIntent.putExtra("p4",p4);
                            mIntent.putExtra("em",email);
                            mIntent.putExtra("em2",email2);
                            mIntent.putExtra("em3",email3);
                            mIntent.putExtra("em4",e1);
                            mIntent.putExtra("w1",web);
                            mIntent.putExtra("w2",web2);
                            mIntent.putExtra("w3",web3);
                            mIntent.putExtra("w4",we1);
                            mIntent.putExtra("num",num_reps);
                            mIntent.putExtra("rep", full_name);
                            mIntent.putExtra("senate1",full_name1);
                            mIntent.putExtra("senate2",full_name2);
                            mIntent.putExtra("senate3",f3);
                            mIntent.putExtra("zip",zcode);
                            startActivity(mIntent);
                        }
                        else if (num_reps == 3) {
                            //more than 1 districts
                            JSONObject a1 =s4.getJSONObject(1);
                            JSONArray a2 = a1.getJSONArray("current_legislators");
                            JSONObject a3 = a2.getJSONObject(0);
                            JSONObject a4 = a3.getJSONObject("bio");
                            String f1 = a4.getString("first_name");
                            String f2 = a4.getString("last_name");
                            String f3 = f1 + " " +f2;

                            JSONObject b1 = s4.getJSONObject(2);
                            JSONArray b2 = b1.getJSONArray("current_legislators");
                            JSONObject b3 = b2.getJSONObject(0);
                            JSONObject b4 = b3.getJSONObject("bio");
                            String e1 = b4.getString("first_name");
                            String e2 = b4.getString("last_name");
                            String e3 = e1 + " " +e2;


                            mIntent = new Intent(MainActivity.this, Longlist.class);
                            mIntent.putExtra("num",num_reps);
                            mIntent.putExtra("rep", full_name);
                            mIntent.putExtra("senate1",full_name1);
                            mIntent.putExtra("senate2",full_name2);
                            mIntent.putExtra("senate3",f3);
                            mIntent.putExtra("senate4",e3);
                            mIntent.putExtra("zip",zcode);


                            startActivity(mIntent);
                        }
                        else if (num_reps == 4) {
                            //more than 1 districts
                            JSONObject a1 =s4.getJSONObject(1);
                            JSONArray a2 = a1.getJSONArray("current_legislators");
                            JSONObject a3 = a2.getJSONObject(0);
                            JSONObject a4 = a3.getJSONObject("bio");
                            JSONObject a5 = a3.getJSONObject("contact");
                            String em4 = a5.getString("contact_form");
                            String w4 = a5.getString("url");
                            String f1 = a4.getString("first_name");
                            String f2 = a4.getString("last_name");
                            String p4 = a4.getString("party");
                            String f3 = f1 + " " +f2;

                            JSONObject b1 = s4.getJSONObject(2);
                            JSONArray b2 = b1.getJSONArray("current_legislators");
                            JSONObject b3 = b2.getJSONObject(0);
                            JSONObject b4 = b3.getJSONObject("bio");
                            JSONObject b5 = b3.getJSONObject("contact");
                            String em5 = b5.getString("contact_form");
                            String w5 = b5.getString("url");
                            String e1 = b4.getString("first_name");
                            String e2 = b4.getString("last_name");
                            String p5 = b4.getString("party");
                            String e3 = e1 + " " +e2;

                            JSONObject c1 = s4.getJSONObject(3);
                            JSONArray c2 = c1.getJSONArray("current_legislators");
                            JSONObject c3 = c2.getJSONObject(0);
                            JSONObject c4 = c3.getJSONObject("bio");
                            JSONObject c5 = c3.getJSONObject("contact");
                            String em6 = c5.getString("contact_form");
                            String w6 = c5.getString("url");
                            String d1 = c4.getString("first_name");
                            String d2 = c4.getString("last_name");
                            String p6 = c4.getString("party");
                            String d3 = d1 + " " + d2;


                            mIntent = new Intent(MainActivity.this, Longlist.class);
                            mIntent.putExtra("num",num_reps);
                            mIntent.putExtra("rep", full_name);
                            mIntent.putExtra("senate1",full_name1);
                            mIntent.putExtra("senate2",full_name2);
                            mIntent.putExtra("senate3",f3);
                            mIntent.putExtra("senate4",e3);
                            mIntent.putExtra("senate5",d3);
                            mIntent.putExtra("zip",zcode);

                            mIntent.putExtra("em",email);
                            mIntent.putExtra("em2",email2);
                            mIntent.putExtra("em3",email3);
                            mIntent.putExtra("em4",em4);
                            mIntent.putExtra("em5",em5);
                            mIntent.putExtra("em6",em6);


                            mIntent.putExtra("w1",web);
                            mIntent.putExtra("w2",web2);
                            mIntent.putExtra("w3",web3);
                            mIntent.putExtra("w4",w4);
                            mIntent.putExtra("w5",w5);
                            mIntent.putExtra("w6",w6);

                            mIntent.putExtra("p1",p1);
                            mIntent.putExtra("p2",p2);
                            mIntent.putExtra("p3",p3);
                            mIntent.putExtra("p4",p4);
                            mIntent.putExtra("p5",p5);
                            mIntent.putExtra("p6",p6);



                            startActivity(mIntent);
                        }
                        else {
                            mIntent = new Intent(MainActivity.this, SearchRes.class);
                            mIntent.putExtra("rep", full_name);
                            mIntent.putExtra("senate1",full_name1);
                            mIntent.putExtra("senate2",full_name2);
                            mIntent.putExtra("zip",zcode);
                            mIntent.putExtra("em",email);
                            mIntent.putExtra("em2",email2);
                            mIntent.putExtra("em3",email3);
                            mIntent.putExtra("w1",web);
                            mIntent.putExtra("w2",web2);
                            mIntent.putExtra("w3",web3);
                            mIntent.putExtra("p1",p1);
                            mIntent.putExtra("p2",p2);
                            mIntent.putExtra("p3",p3);
                            startActivity(mIntent);
                        }


                    } catch (JSONException e) {
                        Log.d("enter catch", "catch");
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "ughhhhhh", Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            }) {
                @Override
                public HashMap getHeaders() {
                    HashMap headers = new HashMap();
                    headers.put("X-API-Key", "5AMQm2QSACHWMzecIvdEbf5ndHAqvmtylmqPoUhl");
                    return headers;
                }

            };
            req_q.add(request);

        }
    }


