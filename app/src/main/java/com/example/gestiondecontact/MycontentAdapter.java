package com.example.gestiondecontact;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MycontentAdapter extends BaseAdapter {
    Context conn;
    ArrayList<Contact> data;

    public MycontentAdapter(Context conn, ArrayList<Contact> data) {
        this.conn = conn;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // create a view holder
        LayoutInflater  inf = LayoutInflater.from(conn);
        View v = inf.inflate(R.layout.view_contact,null);
        // get the holders

        TextView lvName = v.findViewById(R.id.lvName);
        TextView lvPsedo = v.findViewById(R.id.lvPsedo);
        TextView lvPhone = v.findViewById(R.id.lvPhone);

        ImageButton ibCall = v.findViewById(R.id.ibCall);
        ImageButton ibDelete = v.findViewById(R.id.ibDelete);
        ImageButton ibEdit = v.findViewById(R.id.ibEdit);

        Contact c = data.get(position);

        lvName.setText(c.name);
        lvPsedo.setText(c.psedo);
        lvPhone.setText(c.phone);

        // set the holders

        ibDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyDataSetChanged();
            }
        });

        ibCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(android.net.Uri.parse("tel:"+c.phone));
                conn.startActivity(i);
            }
        });

        ibEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(conn);
                alert.setTitle("Edit");
                //alert.setMessage("update this");
                LayoutInflater inf = LayoutInflater.from(conn);
                View vd= inf.inflate(R.layout.edit_contaxt, null);
                alert.setView(vd);
                alert.show();
                /*

                Intent i = new Intent(conn,Ajout.class);
                i.putExtra("name",c.name);
                i.putExtra("psedo",c.psedo);
                i.putExtra("phone",c.phone);
                conn.startActivity(i);
                */

            }
        });
        // set event in holders


        return v;
    }
}
