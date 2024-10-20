package com.example.gestiondecontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ednom, edmp;
    private Button btnval;
    private Button btnqt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edmp = findViewById(R.id.edmp_auth);
        ednom = findViewById(R.id.ednom_auth);
        btnval= findViewById(R.id.btvalid_auth);
        btnqt = findViewById(R.id.btnqte_auth);


        btnqt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom =ednom.getText().toString();
                String pw = edmp.getText().toString();


                if(nom.equalsIgnoreCase("m") && pw.equals("000")){
                    Intent i = new Intent(MainActivity.this,Accueil.class);
                    i.putExtra("user",nom);
                    i.putExtra("pw",pw);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Not authorized", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}