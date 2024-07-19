package com.example.new_tab;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.new_tab.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {




            public boolean onNavigationItemSelected(MenuItem item) {


                Fragment selectedFragment = null;




                // Get the ID of the selected item
                int itemId = item.getItemId();

                // Check the ID and assign the appropriate fragment
                if (itemId == R.id.bottom_academics) {
                    selectedFragment = new AcademicsFragment();
                } else if (itemId == R.id.bottom_hostel) {
                    selectedFragment = new HostelFragment();
                } else if (itemId == R.id.bottom_others) {
                    selectedFragment = new OthersFragment();
                }

                // Replace the fragment container with the selected fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        selectedFragment).commit();

                return true;
            }
        });
    }


}
