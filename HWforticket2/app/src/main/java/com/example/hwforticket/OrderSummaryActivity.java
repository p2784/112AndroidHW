package com.example.hwforticket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String gender = getIntent().getStringExtra("gender");
        String ticketType = getIntent().getStringExtra("ticketType");
        int ticketCount = getIntent().getIntExtra("ticketCount", 0);
        int totalPrice = getIntent().getIntExtra("totalPrice", 0);

        // 在TextView中显示信息
        TextView genderTextView = findViewById(R.id.ticket_details);
        genderTextView.setText("性别: " + gender +"\n" +ticketType+":"
                +ticketCount+"張"+"\n"+"總金額: $" + totalPrice );

    }
}