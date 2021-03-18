package com.example.news_magnifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ListView listview ;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem("제목1");
        adapter.addItem("제목2");
        adapter.addItem("제목3");
        adapter.addItem("제목4");
        adapter.addItem("제목5");

        adapter.notifyDataSetChanged();
    }
}