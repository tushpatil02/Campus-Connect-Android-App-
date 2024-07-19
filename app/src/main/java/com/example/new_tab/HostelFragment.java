package com.example.new_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.new_tab.R;

public class HostelFragment extends Fragment {

    CardView wardenOfficeCardView, messCardView,laundryCardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hostel, container, false);

        CardView wardenOfficeCardView = view.findViewById(R.id.HostelcardView1);
        CardView messCardView = view.findViewById(R.id.HostelcardView2);
        CardView laundryCardView = view.findViewById(R.id.HostelcardView3);

        wardenOfficeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Warden Office CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked WardenOffice Card", Toast.LENGTH_SHORT).show();
            }
        });

        messCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Mess CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked Mess Card", Toast.LENGTH_SHORT).show();
            }
        });

        laundryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Laundry CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked Laundry Card", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}