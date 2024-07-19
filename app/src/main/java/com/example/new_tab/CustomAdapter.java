package com.example.new_tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> personNames;
    ArrayList<String> emailIds;
    ArrayList<String> mobileNumbers;
    Context ctx;
    TextView name , email, MobileNo;




    // Cretaing constructor


//    public CustomAdapter(ArrayList<String> personNames, ArrayList<String> emailIds, ArrayList<String> mobileNumbers, android.content.Context ctx) {
//        this.personNames = personNames;
//        this.emailIds = emailIds;
//        this.mobileNumbers = mobileNumbers;
//        this.ctx = ctx;
//
//    }


    public CustomAdapter(ArrayList<String> roomList, ArrayList<String> emailIds, ArrayList<String> mobileNumbers, android.content.Context ctx) {
        this.personNames = roomList;
        this.emailIds = emailIds;
        this.mobileNumbers = mobileNumbers;
        this.ctx = ctx;

    }



    /// 3 - View Holders

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the Utem Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the data in Item
        holder.name.setText(personNames.get(position));
        holder.email.setText(emailIds.get(position));
        Linkify.addLinks(holder.email , Linkify.EMAIL_ADDRESSES);
        holder.MobileNo.setText(mobileNumbers.get(position));
        //Linkify.addLinks(holder.MobileNo, Linkify.PHONE_NUMBERS);

    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    // 4 - My holder Class

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        // widgets
        TextView name , email , MobileNo;

        //Constructor
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            MobileNo = itemView.findViewById(R.id.mobileNO);

        }




    }
}
