package com.hardcastle.specificdatafetchjson;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AnimeActivity extends AppCompatActivity {
    Controllerdb db =new Controllerdb(this);
    SQLiteDatabase database;
    Button Submitdatabtn,Showdatabtn;
    String name,description,studio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_anime);
        Submitdatabtn= (Button) findViewById(R.id.btnSave);
        Showdatabtn=(Button) findViewById(R.id.btnShow);
        // hide the default actionbar
        getSupportActionBar().hide();

        // Recieve data

        final String name  = getIntent().getExtras().getString("anime_name");
        final String description = getIntent().getExtras().getString("anime_description");
        final String studio = getIntent().getExtras().getString("studio");


        // ini views



        TextView tv_name = findViewById(R.id.anime_nameS);
        TextView tv_decript = findViewById(R.id.descriptionS);
        TextView tu_studio = findViewById(R.id.studioS);

        // setting values to each view

        tv_name.setText(name);
        tv_decript.setText(description);
        tu_studio.setText(studio);




        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);



        Submitdatabtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {

                database=db.getWritableDatabase();
                database.execSQL("INSERT INTO UserDetails(Username,Mailid,Age)VALUES('"+name+"','"+description+"','"+studio+"')" );

                Toast.makeText(getBaseContext(), "data Inserted succusfully" , Toast.LENGTH_SHORT ).show();
            }

        });

        Showdatabtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {

                Intent i = new Intent(AnimeActivity.this, ShowdataListview.class);

// Starts TargetActivity
                startActivity(i);
            }

        });



    }
}
