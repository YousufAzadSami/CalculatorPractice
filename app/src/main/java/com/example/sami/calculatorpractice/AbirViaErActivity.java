package com.example.sami.calculatorpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AbirViaErActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abir_via_er);

        String data = getIntent().getExtras().getString("Mayesha");
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}
