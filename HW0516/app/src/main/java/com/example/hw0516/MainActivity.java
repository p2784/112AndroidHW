package com.example.hw0516;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listViewMain;
    private ListView listViewAdditions;
    private ListView ListViewDrinks;
    private Spinner spinner;
    private TextView txvResult;

    private String mainDish = "";
    private String addition = "";
    private String drink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMain = findViewById(R.id.listViewMain);
        listViewAdditions = findViewById(R.id.listViewAdditions);
        ListViewDrinks = findViewById(R.id.ListViewDrinks);
        spinner = findViewById(R.id.spinner);
        txvResult = findViewById(R.id.txvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainDish = "主餐: " + parent.getItemAtPosition(position);
                updateResult();
            }
        });

        listViewAdditions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addition = "附餐: " + parent.getItemAtPosition(position);
                updateResult();
            }
        });

        ListViewDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drink = "飲料: " + parent.getItemAtPosition(position);
                updateResult();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("主餐")) {
                    listViewMain.setVisibility(View.VISIBLE);
                    listViewAdditions.setVisibility(View.GONE);
                    ListViewDrinks.setVisibility(View.GONE);
                } else if (parent.getItemAtPosition(position).equals("附餐")) {
                    listViewMain.setVisibility(View.GONE);
                    listViewAdditions.setVisibility(View.VISIBLE);
                    ListViewDrinks.setVisibility(View.GONE);
                } else if (parent.getItemAtPosition(position).equals("飲料")) {
                    listViewMain.setVisibility(View.GONE);
                    listViewAdditions.setVisibility(View.GONE);
                    ListViewDrinks.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private void updateResult() {
        txvResult.setText(mainDish + "\n" + addition + "\n" + drink);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 建立選單
        MenuInflater inflater = getMenuInflater();// 取得MenuInflater物件
        inflater.inflate(R.menu.menu, menu);// 載入選單資源
        return super.onCreateOptionsMenu(menu);// 回傳true表示顯示選單
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cancel) {
            mainDish = "";
            addition = "";
            drink = "";
            updateResult();
            return true;
        } else if (id == R.id.send) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result", txvResult.getText().toString());
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}