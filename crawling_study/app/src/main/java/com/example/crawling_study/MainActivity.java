package com.example.crawling_study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class MainActivity extends AppCompatActivity {

    Document doc;
    String nums;
    private Button btn_load;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  btn_load = (Button) findViewById(R.id.btn_load);
        result = (TextView) findViewById(R.id.result);

        final Bundle bundle = new Bundle();

      //  btn_load.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run(){

                        try{
                            doc = (Document) Jsoup.connect("https://imnews.imbc.com/news/2021/politics/article/6121898_34866.html").get();
                            Elements contents = doc.select("#news_txt");


                            nums = doc.select("#art_title").text();

                            bundle.putString("numbers", nums);
                            Message msg = handler.obtainMessage();
                            msg.setData(bundle);
                            handler.sendMessage(msg);

                        }catch(Exception e){}
                    }
                }.start();
            }
      //  });
  //  }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            result.setText(bundle.getString("numbers"));
        }
    };
}