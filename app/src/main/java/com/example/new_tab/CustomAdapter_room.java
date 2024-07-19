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

import com.example.new_tab.R;

import java.util.ArrayList;

public class CustomAdapter_room extends RecyclerView.Adapter<CustomAdapter_room.MyViewHolder> {

    ArrayList<String> roomList;
    ArrayList<String> wingList;
    ArrayList<String> floorList;
    Context ctx;

    public CustomAdapter_room(ArrayList<String> roomList, ArrayList<String> wingList, ArrayList<String> floorList, Context ctx) {
        this.roomList = roomList;
        this.wingList = wingList;
        this.floorList = floorList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout2, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.room.setText(roomList.get(position));
        holder.wing.setText(wingList.get(position));
        holder.floor.setText(floorList.get(position));

        // You can add Linkify for room, wing, and floor as needed



    }

    @Override
    public int getItemCount() {
        // Assuming all lists have the same size
        return roomList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView room, wing, floor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.wing);
            wing = itemView.findViewById(R.id.wing);
            floor = itemView.findViewById(R.id.floor);
        }
    }
}
