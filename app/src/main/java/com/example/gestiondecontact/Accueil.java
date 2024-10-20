package com.example.gestiondecontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {

    private TextView tvuser;
    private Button btnAffiche, btnAjout;

    static ArrayList<Contact> data = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        tvuser= findViewById(R.id.tvuser_accueil);
        btnAjout = findViewById(R.id.btn_add);
        btnAffiche = findViewById(R.id.btn_aff);
        btnAffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Accueil.this,Affichage.class);
                startActivity(i);
            }
        });
        Intent x = this.getIntent();
        Bundle b = x.getExtras();

        String user = b.getString("user");
        tvuser.setText("hi Mr."+user);
        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Accueil.this,Ajout.class);
                startActivity(i);
            }
        });

        data.add(new Contact(1,"malek","MK","54405431"));
        data.add(new Contact(2,"akram","AK","123654789"));
        data.add(new Contact(3,"raouf","RK","987654321"));
        data.add(new Contact(4,"sarah","SR","654321987"));
        data.add(new Contact(5,"ahmed","AH","112233445"));
        data.add(new Contact(6,"khadija","KH","998877665"));
        data.add(new Contact(7,"hamza","HZ","223344556"));
        data.add(new Contact(8,"amine","AM","334455667"));
        data.add(new Contact(9,"safia","SF","778899001"));
        data.add(new Contact(10,"layla","LY","445566778"));
        data.add(new Contact(11,"mohamed","MH","556677889"));
        data.add(new Contact(12,"yassine","YS","667788990"));
        data.add(new Contact(13,"hiba","HB","778899002"));
        data.add(new Contact(14,"tarek","TR","889900113"));
        data.add(new Contact(15,"ines","IN","990011223"));
        data.add(new Contact(16,"fouad","FD","110022334"));
        data.add(new Contact(17,"rim","RM","223344556"));
        data.add(new Contact(18,"khaled","KL","556677889"));
        data.add(new Contact(19,"nadia","ND","667788990"));
        data.add(new Contact(20,"omar","OM","778899001"));
        data.add(new Contact(21,"samir","SM","889900112"));
        data.add(new Contact(22,"islem","IS","990011223"));
        data.add(new Contact(23,"meryem","MR","223344556"));
        data.add(new Contact(24,"bilal","BL","334455667"));
        data.add(new Contact(25,"fatma","FT","445566778"));
        data.add(new Contact(26,"mehdi","MD","556677889"));
        data.add(new Contact(27,"nour","NR","667788990"));
        data.add(new Contact(28,"sami","SA","778899001"));
        data.add(new Contact(29,"imene","IM","889900113"));
        data.add(new Contact(30,"rafik","RF","990011224"));


    }
}