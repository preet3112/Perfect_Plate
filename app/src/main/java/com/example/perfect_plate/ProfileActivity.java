package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    Button logOut;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
       bottomnav();
    }
    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mapsearch:
                        startActivity(new Intent(getApplicationContext(),SearchActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.restaurant:
                        startActivity(new Intent(getApplicationContext(),ResListActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.redeem:
                        startActivity(new Intent(getApplicationContext(),RedeemActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}