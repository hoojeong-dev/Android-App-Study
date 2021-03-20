package com.example.eyephone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listview ;
    private ListViewAdapter adapter;
    List<Bbs> datas = new ArrayList<>();
    //Context context;
    //LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String[] titleArray1 = intent.getExtras().getStringArray("title");
        String[] keyArray2 = intent.getExtras().getStringArray("key");
        String keyvalue = intent.getExtras().getString("key2");

        adapter = new ListViewAdapter();

        //Bbs b=Dao.datas.get(Integer.parseInt(keyvalue)-1);


        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        for(int i =0;i<5;i++) {
            adapter.addItem(titleArray1[i]);
        }

        adapter.setKey(keyArray2);
        adapter.notifyDataSetChanged();
    }
    public void setarray(List<Bbs> datas) {
        System.out.println("**************************************");
        this.datas = datas;
    }
}