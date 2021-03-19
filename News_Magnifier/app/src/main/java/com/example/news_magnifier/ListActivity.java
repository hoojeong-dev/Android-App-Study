package com.example.news_magnifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ListView listview ;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String[] titleArray = intent.getExtras().getStringArray("title");
        String[] keyArray = intent.getExtras().getStringArray("key");

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem(titleArray[0]);
        adapter.addItem(titleArray[1]);
        adapter.addItem(titleArray[2]);
        adapter.addItem(titleArray[3]);
        adapter.addItem(titleArray[4]);

        adapter.setKey(keyArray);

        adapter.notifyDataSetChanged();
    }
}