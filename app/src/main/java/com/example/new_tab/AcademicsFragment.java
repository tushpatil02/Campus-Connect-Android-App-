package com.example.new_tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AcademicsFragment extends Fragment {

    RecyclerView recyclerView;
    TextView tv;
    ArrayList<String> personNames = new ArrayList<>();
    ArrayList<String> emailIds = new ArrayList<>();
    ArrayList<String> mobileNumbers = new ArrayList<>();
    String filename = "";
    String usertype = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_academics, container, false);

        CardView itCardView = view.findViewById(R.id.cardView1);
        CardView csCardView = view.findViewById(R.id.cardView2);
        CardView aimlCardView = view.findViewById(R.id.cardView3);

        csCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype = "CS"; // Set usertype to "CS" for CS card
                try {
                    Start_faculty(usertype);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        itCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype = "IT"; // Set usertype to "IT" for IT card
                try {
                    Start_faculty(usertype);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        aimlCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype = "Rooms"; // Set usertype to "IT" for IT card
                try {
                    Start_room(usertype);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return view;
    }

    private void Start_room(String usertype) throws JSONException {

        JSONObject jsonObject =  JsonDataFromAssets(getContext(), "room.json");
        JSONArray roomArray = jsonObject.getJSONArray(usertype);

// Creating arrays to store room, wing, and floor details
        ArrayList<String> roomList = new ArrayList<>();
        ArrayList<String> wingList = new ArrayList<>();
        ArrayList<String> floorList = new ArrayList<>();

// Parsing room data
        for (int i = 0; i < roomArray.length(); i++) {
            JSONObject roomDetail = roomArray.getJSONObject(i);
            roomList.add(roomDetail.getString("Room"));
            wingList.add(roomDetail.getString("Wing"));
            floorList.add(roomDetail.getString("Floor"));
        }

// Starting MainActivity2 with the parsed room data
        Intent intent = new Intent(getContext(), MainActivity2.class);
        intent.putStringArrayListExtra("roomList", roomList);
        intent.putStringArrayListExtra("wingList", wingList);
        intent.putStringArrayListExtra("floorList", floorList);
        intent.putExtra("Clicked", "Rooms"); // Assuming "Rooms" is the usertype

        getContext().startActivity(intent);


    }








    private void Start_faculty(String usertype) throws JSONException {

        Toast.makeText(getContext(), "Started for " + usertype , Toast.LENGTH_SHORT).show();
        Context context = getContext();



        JSONObject jsonObject = JsonDataFromAssets(getContext(), "J.json");

        JSONArray userArray = jsonObject.getJSONArray(usertype);

        ArrayList<String> personNames = new ArrayList<>();
        ArrayList<String> emailIds = new ArrayList<>();
        ArrayList<String> mobileNumbers = new ArrayList<>();
        ArrayList<String> Picture = new ArrayList<>();


        for (int i = 0; i < userArray.length(); i++) {
            JSONObject userDetail = userArray.getJSONObject(i);
            JSONObject userDetail2 = userArray.getJSONObject(i);

            personNames.add(userDetail.getString("Name"));
            emailIds.add(userDetail.getString("Email"));
//            JSONObject contact = userDetail.getJSONObject("Contact");
//            mobileNumbers.add(contact.getString("Mobile"));
            mobileNumbers.add(userDetail.getString("Mobile"));
            Picture.add(userDetail.getString("Picture"));

        }

        Intent intent = new Intent(getContext(), MainActivity2.class);
        intent.putStringArrayListExtra("personNames", personNames);
        intent.putStringArrayListExtra("emailIds", emailIds);
        intent.putStringArrayListExtra("mobileNumbers", mobileNumbers);
        intent.putExtra("Clicked", usertype); // Assuming "Rooms" is the usertype

//        Toast.makeText(context, "" + Picture, Toast.LENGTH_LONG).show();


        context.startActivity(intent);
    }

    public JSONObject JsonDataFromAssets(Context context, String fileName) throws JSONException {
        String json = null;

        try {
            InputStream is = context.getAssets().open(fileName);
            int SizeOffFile = is.available();
            byte[] bufferData = new byte[SizeOffFile];
            is.read(bufferData);
            is.close();
            json = new String(bufferData, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception gracefully by returning a default or empty JSON string
            json = "{}"; // Default to an empty JSON object
        }

        return new JSONObject(json);
    }
}
