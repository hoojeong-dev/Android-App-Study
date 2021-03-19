package com.example.news_magnifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView Title;
    String[] titleArray = {"dkssud", "whssk", "glaemfek", "tndjq", "roshwoa"};
    String[] keyArray = {"1", "2", "3", "4", "5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        Title = (TextView) findViewById(R.id.Title);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(MainActivity.this, ReadNewsActivity.class);
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("title", titleArray);
                intent.putExtra("key", keyArray);

                startActivity(intent);
            }
        });
    }
}