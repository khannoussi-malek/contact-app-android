package com.example.gestiondecontact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity {


    ImageView iv;
    ListView lv;
    RecyclerView rv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_affichage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        iv = findViewById(R.id.btnBack);



        // lv=findViewById(R.id.lv);
        rv= findViewById(R.id.rv);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Affichage.this.finish();
                //Affichage.super.onBackPressed();
                /*
                Intent i = new Intent(Affichage.this,Contact.class);
                startActivity(i);
                 */
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // MycontentAdapter ad = new MycontentAdapter(Affichage.this, Accueil.data);

        MyContectRecycleAdapter ad= new MyContectRecycleAdapter(Accueil.data, this);
        rv.setAdapter(ad);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,true);
        rv.setLayoutManager(gridLayoutManager);
    }
}