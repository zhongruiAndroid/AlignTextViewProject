package com.zr.aligntextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zr.align.AlignTextView;

public class MainActivity extends AppCompatActivity {

    private TextView atv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = atv.getText();
                Log.i("=====","==CharSequence==="+text);
            }
        });
        atv = findViewById(R.id.atv);
    }
}