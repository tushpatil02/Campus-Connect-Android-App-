package com.example.new_tab;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tv;

    ArrayList<String> personNames = new ArrayList<>();
    ArrayList<String> emailIds = new ArrayList<>();
    ArrayList<String> mobileNumbers = new ArrayList<>();

    ArrayList<String> roomList = new ArrayList<>();
    ArrayList<String> wingList = new ArrayList<>();
    ArrayList<String> floorList = new ArrayList<>();
    ArrayList<String> empty = new ArrayList<>();
    String usertype, name2, filename;
    SearchView searchView;
    CustomAdapter customAdapter;

    RecyclerView recyclerView2;
    TextView tv2;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        recyclerView2 = findViewById(R.id.recyclerView2);
        tv2 = findViewById(R.id.textView2);
        searchView = findViewById(R.id.serchV);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        Intent intent = getIntent();

        String clicked = getIntent().getStringExtra("Clicked");
        Toast.makeText(this, "cliked " + clicked, Toast.LENGTH_SHORT).show();

        if (clicked.equals("CS") || clicked.equals("IT")) {

            Toast.makeText(this, "in loop FAC" , Toast.LENGTH_SHORT).show();

            personNames = intent.getStringArrayListExtra("personNames");
            emailIds = intent.getStringArrayListExtra("emailIds");
            mobileNumbers = intent.getStringArrayListExtra("mobileNumbers");


            tv2.setText(clicked);

            recyclerView = findViewById(R.id.recyclerView2);
            customAdapter = new CustomAdapter(personNames, emailIds, mobileNumbers, MainActivity3.this);

            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));



        } else if (clicked.equals("Rooms")) {
            Toast.makeText(this, " in loop room", Toast.LENGTH_SHORT).show();


            roomList = intent.getStringArrayListExtra("roomList");
            wingList = intent.getStringArrayListExtra("wingList");
            floorList = intent.getStringArrayListExtra("floorList");

            tv2.setText(clicked);

            recyclerView = findViewById(R.id.recyclerView2);
            customAdapter = new CustomAdapter(roomList, wingList, floorList, MainActivity3.this);

            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));


        }




    }

    private void filterList(String query) {
        List<String> filteredNames = new ArrayList<>();
        List<String> filteredEmails = new ArrayList<>();
        List<String> filteredMobileNumbers = new ArrayList<>();



        for (int i = 0; i < personNames.size(); i++) {
            String name = personNames.get(i);
            String email = emailIds.get(i);
            String mobile = mobileNumbers.get(i);

            // Convert to lowercase for case-insensitive search
            if (name.toLowerCase().contains(query.toLowerCase()) ||
                    email.toLowerCase().contains(query.toLowerCase()) ||
                    mobile.toLowerCase().contains(query.toLowerCase())) {
                filteredNames.add(name);
                filteredEmails.add(email);
                filteredMobileNumbers.add(mobile);
            }
        }

        // Update the adapter with filtered data
        customAdapter = new CustomAdapter((ArrayList<String>) filteredNames, (ArrayList<String>) filteredEmails, (ArrayList<String>) filteredMobileNumbers, MainActivity3.this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Filtering for room, wing, and floor
        if (!roomList.isEmpty() && !wingList.isEmpty() && !floorList.isEmpty()) {
            ArrayList<String> filteredRooms = new ArrayList<>();
            ArrayList<String> filteredWings = new ArrayList<>();
            ArrayList<String> filteredFloors = new ArrayList<>();

            for (int i = 0; i < roomList.size(); i++) {
                String room = roomList.get(i);
                String wing = wingList.get(i);
                String floor = floorList.get(i);

                // Convert to lowercase for case-insensitive search
                if (room.toLowerCase().contains(query.toLowerCase()) ||
                        wing.toLowerCase().contains(query.toLowerCase()) ||
                        floor.toLowerCase().contains(query.toLowerCase())) {
                    filteredRooms.add(room);
                    filteredWings.add(wing);
                    filteredFloors.add(floor);
                }
            }

            // Update the adapter with filtered room, wing, and floor data
            customAdapter = new CustomAdapter(filteredRooms, filteredWings, filteredFloors, MainActivity3.this);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

}
