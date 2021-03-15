package com.example.intent_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.intent_study.R;

public class MainActivity extends AppCompatActivity {

    private EditText et_text;
    private Button btn_send;
    private String str;

    // 어플이 처음 시작되면 동작하는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위에서 선언한 변수(EditText)와 xml의 EditText가 연결됨
        et_text = findViewById(R.id.et_text);
        btn_send = findViewById(R.id.btn_send);

        // btn_send 버튼을 클릭했을 때
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼을 누르면 해당 text가 입력 됨
                // et_id.setText("fujeong15");

                // text 란에 문자를 입력하면 str에 저장됨
                str = et_text.getText().toString();

                // 버튼을 누르면 다른 화면으로 넘어감
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                // 입력받은 변수 전달 id -> str
                intent.putExtra("str", str);
                startActivity(intent);   // Activity 이동
            }
        });
    }
}