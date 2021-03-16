package com.example.intent_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView list_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list_test = (ListView)findViewById(R.id.list_test);

        List<String> data = new ArrayList<>();

        // ListView 와 ArrayList 를 연결해줌 (중간 다리 역할)
        // ArrayAdapter 와 ArrayList 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, data);

        // ArrayAdapter 와 ListView 연결
        list_test.setAdapter(adapter);

        data.add("김후정");
        data.add("컴퓨터공학부");
        data.add("2019243110");

        // 추가한 데이터를 저장한다는 뜻뜻
       adapter.notifyDataSetChanged();

    }
}