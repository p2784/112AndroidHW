package com.example.hwforticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText editTxtaccount = findViewById(R.id.editTxtaccount);
        Button btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String gender= "";
                RadioButton boy = (RadioButton) findViewById(R.id.radioButtonboy);
                RadioButton girl = (RadioButton) findViewById(R.id.radioButtongirl);
                RadioButton adult = (RadioButton) findViewById(R.id.radioButtonadult);
                RadioButton kid = (RadioButton) findViewById(R.id.radioButtonkid);
                RadioButton stu = (RadioButton) findViewById(R.id.radioButtonstu);
                TextView txtshowerror = (TextView) findViewById(R.id.txtshowerror);
                int adultTicketPrice = 500;
                int childTicketPrice = 250;
                int studentTicketPrice = 400;
                int total = 0;
                int account = 0;

                try {
                    account = Integer.parseInt(editTxtaccount.getText().toString());
                } catch (NumberFormatException e) {
                    txtshowerror.setText("請輸入有效的數字");
                    return;
                }
                if (account == 0) {
                    txtshowerror.setText("請輸入數字");
                    return; // 终止方法
                }
                if(boy.isChecked())
                    gender+="男生\n";
                else if (girl.isChecked())
                    gender += "女生\n";
                if(adult.isChecked())
                     total = adultTicketPrice * account;
                else if (kid.isChecked())
                    total = childTicketPrice * account;
                else if (stu.isChecked())
                    total = studentTicketPrice * account;

                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                intent.putExtra("gender", gender);
                intent.putExtra("ticketType", adult.isChecked() ? "成人票" : kid.isChecked() ? "兒童票" : "學生票");
                intent.putExtra("ticketCount", account);
                intent.putExtra("totalPrice", total);
                startActivity(intent);
                txtshowerror.setText("");
            }
        });
    }

}