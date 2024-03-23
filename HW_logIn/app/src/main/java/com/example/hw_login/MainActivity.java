package com.example.hw_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String defaultAccount = "1234";
    private String defaultPassword = "2345";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnenter(View view) {
        TextView txtMessage =  (TextView) findViewById(R.id.txtMessage);
        EditText edtAccount = (EditText)  findViewById(R.id.edtAccount);
        EditText edtPassword =  (EditText) findViewById(R.id.edtPassword);

        String inputAccount = edtAccount.getText().toString();
        String inputPassword = edtPassword.getText().toString();


        if (inputAccount.equals(defaultAccount) && inputPassword.equals(defaultPassword)) {

            txtMessage.setText("登入成功");
            edtAccount.setText("");
            edtPassword.setText("");
        } else {
            txtMessage.setText("帳號或密碼錯誤");
            edtAccount.setText("");
            edtPassword.setText("");
        }
    }

}