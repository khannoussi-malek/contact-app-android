package com.example.gestiondecontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ajout extends AppCompatActivity {

    EditText name,psedo,phone;
    Button btQuite, btAjout;
    TextView addNumberTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addNumberTitle = findViewById(R.id.addNumberTitle);
        name = findViewById(R.id.name);
        psedo = findViewById(R.id.psedo);
        phone = findViewById(R.id.phone);

        Bundle b = this.getIntent().getExtras();

        try {

            name.setText(b.getString("name"));
            psedo.setText(b.getString("psedo"));
            phone.setText(b.getString("phone"));
            System.out.println("name = "+b.getString("name"));
            addNumberTitle.setText("Edit");

        }
        catch (Exception e){
            System.out.println("error = "+e.getMessage());
        }

        btAjout = findViewById(R.id.btAjoute);
        btQuite = findViewById(R.id.btQuite);

        btQuite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ajout.this.finish();
            }
        });

        btAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Accueil.data.add(0,new Contact(Ajout.this.name.getText().toString(),Ajout.this.psedo.getText().toString(),Ajout.this.phone.getText().toString()));
                Ajout.this.finish();
                System.out.println("data size = "+Accueil.data.get(0).name);
            }
        });


    }
}