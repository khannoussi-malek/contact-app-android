package com.example.gestiondecontact;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyContectRecycleAdapter extends RecyclerView.Adapter<MyContectRecycleAdapter.MyViewHolder> {

    Context conn;
    ArrayList<Contact> data;

    public MyContectRecycleAdapter(ArrayList<Contact> data, Context conn) {
        this.data = data;
        this.conn = conn;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a view holder
        LayoutInflater inf = LayoutInflater.from(conn);
        View v = inf.inflate(R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact c = data.get(position);

        holder.lvName.setText(c.name);
        holder.lvPsedo.setText(c.psedo);
        holder.lvPhone.setText(c.phone);

        // set the holders


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView lvName ;
        TextView lvPsedo;
        TextView lvPhone;
        ImageButton ibCall, ibDelete,ibEdit;
        public MyViewHolder(@NonNull View v) {
            super(v);
            // get the holders

             lvName = v.findViewById(R.id.lvName);
             lvPsedo = v.findViewById(R.id.lvPsedo);
             lvPhone = v.findViewById(R.id.lvPhone);

             ibCall = v.findViewById(R.id.ibCall);
             ibDelete = v.findViewById(R.id.ibDelete);
             ibEdit = v.findViewById(R.id.ibEdit);


            ibDelete.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View view) {
                   int indice= getAdapterPosition();
                    data.remove(indice);
                    notifyDataSetChanged();
                }
            });

            ibCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice= getAdapterPosition();
                    Contact c = data.get(indice);
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
        }
    }
}
