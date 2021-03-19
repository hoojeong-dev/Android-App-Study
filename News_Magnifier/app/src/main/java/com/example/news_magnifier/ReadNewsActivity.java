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

    private String[] newsContents = new String[1000];
    private int count=0;
    private int count1 = 0;
    //private int count2 = 0;
    int[] viewPosition = new int[2];

    private Button btnbottom, btntop;
    private TextView newstext1, newstext2,newstext3, newstext4, newstext5;

    private String[] keyvalue;
    //private String[] newsArray = new String[100];

    setNewsString setnewsstring = new setNewsString();

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.Q)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readnews);

        //Intent intent = getIntent();
        //keyvalue = intent.getExtras().getStringArray("key");

        newstext1 = (TextView) findViewById(R.id.newstext1);
        newstext2 = (TextView) findViewById(R.id.newstext2);
        newstext3 = (TextView) findViewById(R.id.newstext3);
        newstext4 = (TextView) findViewById(R.id.newstext4);
        newstext5 = (TextView) findViewById(R.id.newstext5);

        btnbottom = (Button) findViewById(R.id.btnbottom);
        btntop = (Button) findViewById(R.id.btntop);

        setNewsString.setContent();
        newsContents = setNewsString.getContent();
        count = setNewsString.getCount();

        for(int i=0;i<count;i++)
            System.out.println(i+" : "+newsContents[i]);

        //newsArray = setnewsstring.getContent();
        newstext1.setText(newsContents[0]);
        newstext2.setText(newsContents[1]);
        newstext3.setText(newsContents[2]);
        newstext4.setText(newsContents[3]);
        newstext5.setText(newsContents[4]);


        btnbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count1 > 0) {
                    count1 = count1 - 5;
                    newstext1.setText(newsContents[count1+1]);
                    newstext2.setText(newsContents[count1+2]);
                    newstext3.setText(newsContents[count1+3]);
                    newstext4.setText(newsContents[count1+4]);
                    newstext5.setText(newsContents[count1+5]);
                }
                else if(count1 == 0){ //if(count == 0){
                    Toast.makeText(getApplicationContext(), "처음 글입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btntop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count1 < count-5) {
                    count1 = count1 + 5;
                    newstext1.setText(newsContents[count1+1]);
                    newstext2.setText(newsContents[count1+2]);
                    newstext3.setText(newsContents[count1+3]);
                    newstext4.setText(newsContents[count1+4]);
                    newstext5.setText(newsContents[count1+5]);
                }

                else {//if (count >= newsArray.length-1){
                    Toast.makeText(getApplicationContext(), "마지막 글입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}