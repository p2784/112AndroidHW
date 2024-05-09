package com.example.foodimgmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView) findViewById(R.id.outputberger);
        image2 = (ImageView) findViewById(R.id.outputfries);
        image3 = (ImageView) findViewById(R.id.outputcoffee);
        image4 = (ImageView) findViewById(R.id.outputsoup);
        image5 = (ImageView) findViewById(R.id.outputcola);

        CheckBox cb1 = (CheckBox) findViewById(R.id.chkberger);
        CheckBox cb2 = (CheckBox) findViewById(R.id.chkfries);
        CheckBox cb3 = (CheckBox) findViewById(R.id.chkcoffee);
        CheckBox cb4 = (CheckBox) findViewById(R.id.chksoup);
        CheckBox cb5 = (CheckBox) findViewById(R.id.chkcola);

        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb1.isChecked()) {
                    image1.setVisibility(ImageView.VISIBLE);
                } else {
                    image1.setVisibility(ImageView.GONE);
                }
            }
        });
cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb2.isChecked()) {
                    image2.setVisibility(ImageView.VISIBLE);
                } else {
                    image2.setVisibility(ImageView.GONE);
                }
            }
        });
cb3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb3.isChecked()) {
                    image3.setVisibility(ImageView.VISIBLE);
                } else {
                    image3.setVisibility(ImageView.GONE);
                }
            }
        });
cb4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb4.isChecked()) {
                    image4.setVisibility(ImageView.VISIBLE);
                } else {
                    image4.setVisibility(ImageView.GONE);
                }
            }
        });
cb5.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb5.isChecked()) {
                    image5.setVisibility(ImageView.VISIBLE);
                } else {
                    image5.setVisibility(ImageView.GONE);
                }
            }
        });
//        cb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cb1.isChecked()) {
//                    image1.setVisibility(ImageView.VISIBLE);
//                } else {
//                    image1.setVisibility(ImageView.GONE);
//                }
//            }
//        });
//        cb2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cb2.isChecked()) {
//                    image2.setVisibility(ImageView.VISIBLE);
//                } else {
//                    image2.setVisibility(ImageView.GONE);
//                }
//            }
//        });
//        cb3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cb3.isChecked()) {
//                    image3.setVisibility(ImageView.VISIBLE);
//                } else {
//                    image3.setVisibility(ImageView.GONE);
//                }
//            }
//        });
//        cb4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cb4.isChecked()) {
//                    image4.setVisibility(ImageView.VISIBLE);
//                } else {
//                    image4.setVisibility(ImageView.GONE);
//                }
//            }
//        });
//        cb5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cb5.isChecked()) {
//                    image5.setVisibility(ImageView.VISIBLE);
//                } else {
//                    image5.setVisibility(ImageView.GONE);
//                }
//            }
//        });
    }


}