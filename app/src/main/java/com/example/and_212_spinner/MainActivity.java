package com.example.and_212_spinner;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner mCountriesSpinner;
    private Spinner mCitiesSpinner;
    private Spinner mHouseNumberSpinner;
    private Button mShowAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        mCountriesSpinner = findViewById(R.id.countriesSpinner);
        mCitiesSpinner = findViewById(R.id.citiesSpinner);
        mHouseNumberSpinner = findViewById(R.id.houseNumberSpinner);
        mShowAddressBtn = findViewById(R.id.showAddress);
        initSpinnerCountries();
        initHousNumbersSpinner();
        mShowAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this
                        ,mCountriesSpinner.getSelectedItem().toString()
                                + " "
                                + mCitiesSpinner.getSelectedItem().toString()
                                + " "
                                + mHouseNumberSpinner.getSelectedItem().toString()
                        ,Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private void initHousNumbersSpinner() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, houseNumbers);
        mHouseNumberSpinner.setAdapter(adapter);
    }

    private void initSpinnerCountries() {

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCountriesSpinner.setAdapter(adapterCountries);

        mCountriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                initSpinnerCities(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initSpinnerCities(int country) {
        ArrayAdapter<CharSequence> adapter ;
        switch (country) {
            case Country.RUSSIA:
                adapter = ArrayAdapter.createFromResource(this, R.array.r_cities, android.R.layout.simple_spinner_item);
                break;
            case Country.UKRAINE:
                adapter = ArrayAdapter.createFromResource(this, R.array.u_cities, android.R.layout.simple_spinner_item);
                break;
            case Country.BELARUS:
                adapter = ArrayAdapter.createFromResource(this, R.array.b_cities, android.R.layout.simple_spinner_item);
                break;
            default:
                adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,  new String[]{" "} );
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCitiesSpinner.setAdapter(adapter);
    }
}
