package com.example.perfect_plate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RedeemActivity extends AppCompatActivity {

    View redeem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        redeem1 = findViewById(R.id.redeem1);

        redeem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(RedeemActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });

        bottomnav();
    }
    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.redeem);

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
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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