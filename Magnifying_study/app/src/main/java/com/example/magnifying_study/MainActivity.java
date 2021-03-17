package com.example.magnifying_study;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Magnifier;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox canShowOutside = findViewById(R.id.canShowOutside);
        TextView sampleText = findViewById(R.id.sampleText);
        Magnifier magnifier = new Magnifier(sampleText);
        Rect outRect = new Rect();

        int[] viewPosition = new int[2];

        sampleText.post(new Runnable() {
            @Override
            public void run() {
                sampleText.getDrawingRect(outRect);
                sampleText.getLocationOnScreen(viewPosition);

                outRect.offset(viewPosition[0], viewPosition[1]);
            }
        });

        // setDefaultSourceToMagnifierOffset -> 돋보기 위젯 위치 설정 함수
        sampleText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE: {

                        if (!canShowOutside.isChecked() &&
                                !outRect.contains((int)event.getRawX(), (int)event.getRawX())
                        ) {
                            magnifier.dismiss();
                            return false;
                        }

                        magnifier.show(event.getRawX() - viewPosition[0],
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
    }
}
