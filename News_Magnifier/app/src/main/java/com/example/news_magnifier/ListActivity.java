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
        String[] str = intent.getExtras().getStringArray("title");

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem(str[0]);
        adapter.addItem(str[1]);
        adapter.addItem(str[2]);
        adapter.addItem(str[3]);
        adapter.addItem(str[4]);

        adapter.notifyDataSetChanged();
    }
}