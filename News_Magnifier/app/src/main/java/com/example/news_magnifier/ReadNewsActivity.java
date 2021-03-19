package com.example.news_magnifier;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Magnifier;
import android.widget.TextView;
import android.widget.Toast;

public class ReadNewsActivity extends AppCompatActivity {

    int[] viewPosition = new int[2];
    private String contents;
    private int count_row = 0, count_col = 0;

    private Button btnbottom, btntop;
    private TextView newstext;

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.Q)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readnews);

        Intent intent = getIntent();
        String keyvalue = intent.getStringExtra("key");

        newstext = (TextView) findViewById(R.id.newstext);
        btnbottom = (Button) findViewById(R.id.btnbottom);
        btntop = (Button) findViewById(R.id.btntop);

        Magnifier magnifier = new Magnifier.Builder(newstext)
                .setInitialZoom(1.2f)
                .setElevation(20.0f)
                .setSize(1110,150)
                .setCornerRadius(5.0f).build();
        Rect outRect = new Rect();

        newstext.post(new Runnable() {
            @Override
            public void run() {
                newstext.getDrawingRect(outRect);
                newstext.getLocationOnScreen(viewPosition);

                //outRect.offset(viewPosition[0], viewPosition[1]);
            }
        });

        newstext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE: {
/*
                        if (!outRect.contains((int)event.getRawX(), (int)event.getRawX())) {
                            magnifier.dismiss();
                            return false;
                        }
*/
                        magnifier.show(event.getRawX() - viewPosition[0],
                                event.getRawY() - viewPosition[1],
                                event.getRawX() - viewPosition[0],
                                event.getRawY() - viewPosition[1]);
                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        magnifier.dismiss();
                    }
                }
                return true;
            }
        });


        contents = getContents();
        String[] newsArray = contents.split("\\.");

        newstext.setText(newsArray[0]);

        btnbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_row > 0) {
                    count_row--;
                    newstext.setText(newsArray[count_row]);
                }
                else { //if(count == 0){
                    Toast.makeText(getApplicationContext(), "처음 글입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btntop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_row < newsArray.length - 1) {
                    count_row++;
                    newstext.setText(newsArray[count_row]);
                }
                else {//if (count >= newsArray.length-1){
                    Toast.makeText(getApplicationContext(), "마지막 글입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String getContents(){
        String Contents = "서울시 선관위가 고 박원순 전 서울시장의 성추행 피해자 A 씨에 대한 고발을 접수, 선거법 위반 여부 검토에 들어갔다고 18일 밝혔다. 선관위 관계자는 이날 통화에서 “A씨가 선거법을 위반했다는 신고가 현재까지 5건가량 있었고 고발 주체는 모두 기관·단체가 아닌 개인”이라고 말했다. A 씨는 전날(17일) 서울 중구 명동의 한 호텔에서 열린 ‘서울시장 위력 성폭력 사건 피해자와 함께 말하기’ 기자회견에 나와 “그분(박 전 시장)의 위력은 여전히 강하게 존재한다”며 “(서울시장 보궐선거를 앞둔) 지금 상황에서 본래 선거가 치러지게 된 계기가 많이 묻혔다고 생각한다”고 밝혔다.“피해 사실을 왜곡하고 상처 줬던 정당에서 시장이 선출됐을 때 저의 자리로 돌아갈 수 없을 것이란 두려움이 든다”는 말도 했다.";
        return Contents;
    }
}