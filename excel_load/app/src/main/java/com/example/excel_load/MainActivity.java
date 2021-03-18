package com.example.excel_load;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readExcel();
    }

    public void readExcel() {
        try{
            ListView list_view = (ListView)findViewById(R.id.list_view);
            List<String> data = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, data);
            list_view.setAdapter(adapter);

            InputStream is = getBaseContext().getResources().getAssets().open("test.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if(wb != null) {
                Sheet sheet = wb.getSheet(0);

                if(sheet != null) {
                    int colTotal = sheet.getColumns();
                    int rowIndexStart = 1;
                    int rowTotal = sheet.getColumn(colTotal - 1).length;

                    StringBuilder sb;

                    for (int row = rowIndexStart; row < rowTotal; row++) {
                        sb = new StringBuilder();

                        for (int col = 0; col < colTotal; col++) {
                            String contents = sheet.getCell(col, row).getContents();
                            data.add("row" + row + " : " + ", col" + col + " : " + contents);
                        }
                    }
                }
            }

        }catch(Exception e){ }
    }
}