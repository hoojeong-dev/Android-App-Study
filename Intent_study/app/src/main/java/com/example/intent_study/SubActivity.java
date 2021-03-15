package com.example.intent_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView sub_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        sub_text = findViewById(R.id.sub_text);

        // 값이 넘어오면 받겠다는 뜻
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        // 전달받은 문자 xml에 출력
        sub_text.setText(str);
    }
}