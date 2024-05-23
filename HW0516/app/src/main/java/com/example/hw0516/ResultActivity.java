package com.example.hw0516;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txvResult = findViewById(R.id.txvResult);
        String result = getIntent().getStringExtra("result");
        txvResult.setText(result);
    }
}