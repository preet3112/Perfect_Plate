package com.example.perfect_plate;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TableDetailsActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2,spinner3;
    Button book;
    TextView res_name;
    String res_nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);
        Bundle bundle=getIntent().getExtras();
        res_nam=bundle.getString("res_name");
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        res_name=findViewById(R.id.ress_name);
        res_name.setText(res_nam);
        book=findViewById(R.id.btnSubmit);
        addItemsOnSpinners();


    }
    public void addItemsOnSpinners() {

        List<String> list = new ArrayList<String>();
        list.add("Birthday Party");
        list.add("Normal");
        list.add("Date");
        list.add("Family Time");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        List<String> list2 = new ArrayList<String>();
        list2.add("Chairs");
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        list2.add("more than 10");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        List<String> list3 = new ArrayList<String>();
        list3.add("Veg");
        list3.add("Non- Veg");


        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter3);
    }
}