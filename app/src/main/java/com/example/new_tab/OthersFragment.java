package com.example.new_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.new_tab.R;

public class OthersFragment extends Fragment {

    public OthersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others, container, false);

        CardView generalStoreCardView = view.findViewById(R.id.OthercardView1);
        CardView saloonCardView = view.findViewById(R.id.OthercardView2);
        CardView lostFoundCardView = view.findViewById(R.id.OthercardView3);

        generalStoreCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for General Store CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked GeneralStore Card", Toast.LENGTH_SHORT).show();
            }
        });

        saloonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Saloon CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked Saloon Card", Toast.LENGTH_SHORT).show();
            }
        });

        lostFoundCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Lost&Found CardView
                // You can perform any action here, such as showing a toast or navigating to another activity
                Toast.makeText(getContext(), "Clicked Lost&Found Card", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
