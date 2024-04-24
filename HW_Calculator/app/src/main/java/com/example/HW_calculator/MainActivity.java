package com.example.HW_calculator;


import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5,
            mBtn6, mBtn7, mBtn8, mBtn9, mBtn0,
            mBtnc, mBtndel, mBtnchu, mBtnche, mBtnjia,
            mBtnjian, mBtndian, mBtndy, mBtnyl;
    private EditText edsrk, edsck;

    private boolean deng_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn4 = findViewById(R.id.btn4);
        mBtn5 = findViewById(R.id.btn5);
        mBtn6 = findViewById(R.id.btn6);
        mBtn7 = findViewById(R.id.btn7);
        mBtn8 = findViewById(R.id.btn8);
        mBtn9 = findViewById(R.id.btn9);
        mBtn0 = findViewById(R.id.btn0);
        mBtnc = findViewById(R.id.btn_c);
        mBtndel = findViewById(R.id.btn_del);
        mBtnchu = findViewById(R.id.btn_chu);
        mBtnjia = findViewById(R.id.btn_jah);
        mBtnjian = findViewById(R.id.btn_jih);
        mBtndian = findViewById(R.id.btn_dian);
        mBtndy = findViewById(R.id.btn_dy);
        mBtnyl = findViewById(R.id.btn_yl);
        mBtnche = findViewById(R.id.btn_che);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtn0.setOnClickListener(this);
        mBtnc.setOnClickListener(this);
        mBtndel.setOnClickListener(this);
        mBtnchu.setOnClickListener(this);
        mBtnjia.setOnClickListener(this);
        mBtnjian.setOnClickListener(this);
        mBtndian.setOnClickListener(this);
        mBtndy.setOnClickListener(this);
        mBtnyl.setOnClickListener(this);
        mBtnche.setOnClickListener(this);

        edsrk = findViewById(R.id.ed_srk);
        edsck = findViewById(R.id.ed_sck);
    }

    @Override
    public void onClick(View view) {
        String input = edsrk.getText().toString();
        String output = edsck.getText().toString();

        switch (view.getId()) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btn0:

            case R.id.btn_dian:
                if (deng_flag) {
                    deng_flag = false;
                    edsrk.setText(null);
                    edsrk.setText(((Button) view).getText());
                } else {
                    edsrk.setText(input + ((Button) view).getText());
                }
                break;

            case R.id.btn_che:
            case R.id.btn_jah:
            case R.id.btn_jih:
            case R.id.btn_chu:
                edsrk.setText(input + " " + ((Button) view).getText() + " ");
                break;

            case R.id.btn_dy:
                getResult();
                break;

            case R.id.btn_yl:
            case R.id.btn_c:
                edsrk.setText(null);
                edsck.setText(null);
                break;

            case R.id.btn_del:
                if (deng_flag) {
                    deng_flag = false;
                    edsrk.setText("");
                } else if (input != null && !input.equals("")) {
                    edsrk.setText(input.substring(0, input.length() - 1));
                }
                break;
        }
    }

    private void getResult() {
        String input = edsrk.getText().toString();

        deng_flag = true;

        double dResult = 0;
        int iResult = 0;

        String s1 = input.substring(0, input.indexOf(" "));

        String op = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
        String s2 = input.substring(input.indexOf(" ") + 3);

        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);

        if (op.equals("+")) {
            dResult = d1 + d2;
        } else if (op.equals("-")) {
            dResult = d1 - d2;
        } else if (op.equals("*")) {
            dResult = d1 * d2;
        } else if (op.equals("/")) {
            if (d1 == 0) {
                dResult = 0;
            } else {
                dResult = d1 / d2;
            }
        } else {
            edsck.setText(dResult + "");
        }

        if (s1.contains(".") || s2.contains(".") || op.equals("/")) {
            edsck.setText(dResult + "");
        } else {
            iResult = (int) dResult;
            edsck.setText(iResult + "");
        }
    }
}