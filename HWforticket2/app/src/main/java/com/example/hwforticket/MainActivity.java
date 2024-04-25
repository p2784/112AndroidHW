package com.example.hwforticket;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // 定義全域變數來儲存選擇的性別、票種和張數
    private String selectedGender = "";
    private String selectedTicketType = "";
    private int ticketCount = 0;
    private int totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 找到視圖元件
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        RadioGroup ticketTypeGroup = findViewById(R.id.radioGrouptype);
        EditText ticketCountEditText = findViewById(R.id.editTxtaccount);
        Button confirmButton = findViewById(R.id.btnEnter);
        TextView errorTextView = findViewById(R.id.txtError);

        genderGroup.setOnCheckedChangeListener((group, checkedId) -> {
            selectedGender = getRadioButtonText(checkedId);
            updateErrorTextView(errorTextView);
        });

        ticketTypeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            selectedTicketType = getRadioButtonText(checkedId);
            calculateTotalAmount();
            updateErrorTextView(errorTextView);
        });

        // 為 EditText 設定傾聽者
        ticketCountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    ticketCount = Integer.parseInt(s.toString());
                    if (ticketCount < 0) {
                        throw new NumberFormatException();
                    }
                    calculateTotalAmount();
                    updateErrorTextView(errorTextView);
                } catch (NumberFormatException e) {
                    ticketCount = 0;
                    totalAmount = 0;
                    updateErrorTextView(errorTextView);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });

        // 為按鈕設定點擊事件
        confirmButton.setOnClickListener(v -> {
            // 檢查選擇的性別、票種和張數是否為空
            if (selectedGender.isEmpty() || selectedTicketType.isEmpty() || ticketCount == 0) {
                errorTextView.setText("請選擇性別、票種和輸入正確的張數");
                return;
            }

            // 創建一個新的 Intent
            Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);

            // 將資訊放入 Intent
            intent.putExtra("gender", selectedGender);
            intent.putExtra("ticketType", selectedTicketType);
            intent.putExtra("ticketCount", ticketCount);
            intent.putExtra("totalAmount", totalAmount);

            // 啟動 OrderSummaryActivity
            startActivity(intent);
        });

    }

    private String getRadioButtonText(@IdRes int checkedId) {
        RadioButton radioButton = findViewById(checkedId);
        return radioButton.getText().toString();
    }

    private void calculateTotalAmount() {
        // 根據票種計算票價
        switch (selectedTicketType) {
            case "成人(500):":
                totalAmount = ticketCount * 500;
                break;
            case "孩童(250):":
                totalAmount = ticketCount * 250;
                break;
            case "學生(400):":
                totalAmount = ticketCount * 400;
                break;
            default:
                totalAmount = 0;
                break;
        }

        // 檢查票數是否小於等於 0
        if (ticketCount <= 0) {
            totalAmount = 0;
        }
    }

    private void updateErrorTextView(TextView errorTextView) {
        String summary = "性別: " + selectedGender + "\n" +
                "票種: " + selectedTicketType + "\n" +
                "張數: " + ticketCount + "\n" +
                "總金額: " + totalAmount;
        errorTextView.setText(summary);
    }
}
