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
        // 找到需要顯示資訊的 TextView
        TextView summaryTextView = findViewById(R.id.summaryTextView);

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String ticketType = intent.getStringExtra("ticketType");
        int ticketCount = intent.getIntExtra("ticketCount", 0);
        int totalAmount = intent.getIntExtra("totalAmount", 0);

        // 將取出的資訊和總金額設定到 TextView 上
        String summary = "性別: " + gender + "\n" +
                "票種: " + ticketType + "\n" +
                "張數: " + ticketCount + "\n" +
                "總金額: " + totalAmount;
        summaryTextView.setText(summary);
    }
}