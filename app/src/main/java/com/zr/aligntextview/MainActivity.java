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
                atv.setText("On the morning of July 21, Baidu and CCTV news held the \"2022 Baidu World Conference\" online. At the conference, Li Zhenyu, senior vice president of Baidu group and general manager of intelligent driving business group, officially released the sixth generation mass-produced unmanned vehicle Apollo RT6, which is expected to be put into trial operation in small quantities in the second half of 2023. 2022 Baidu World Conference: officials said that tens of thousands of vehicles without steering wheel will be deployed. According to reports, Apollo RT6 is a mass-produced vehicle independently developed and designed by Baidu for future travel. The whole vehicle has been deeply designed for passenger needs and driverless travel scenarios, and supports two modes of steering wheel and no steering wheel. In the future, Apollo RT6 can realize automatic driving without steering wheel under the permission of relevant policies and regulations. The cost of the car is only 250000 yuan, and the mass production cost is significantly reduced to 1/10 of the industry. Advertisement 2022 Baidu World Conference held: the official said that tens of thousands of vehicles without steering wheel will be deployed. Robin Lee, the founder, chairman and CEO of Baidu, said: \"it is half cheaper to hit an unmanned car in the future than it is now.\" According to the plan, Baidu will use RT6 on the turnip express platform next year and can deploy tens of thousands of vehicles nationwide in the future. In addition to being driverless, Apollo RT6 is also equipped with human-oriented functions such as smart interactive light language with recognition and prompt functions, intelligent electric side sliding door, variable intelligent space, independent seat and intelligent interactive system backward design. Will you try a driverless car without a steering wheel at all?");
            }
        });
        atv = findViewById(R.id.atv);
    }
}