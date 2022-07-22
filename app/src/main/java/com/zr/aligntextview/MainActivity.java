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
        View tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = atv.getText();
                Log.i("=====","==CharSequence==="+text);
                atv.setText("7月21日上午，百度联合央视新闻在线上召开了“2022百度世界gasdfgasdf会”。在大会上，百度集团资深副总裁、智能驾驶事业群组总经b李震宇正式发布了第六代量产无人车Apollo RT6，有望于2023年下半年小批量投入到萝卜快跑试运营。2022百度世界大会召开：官方称将部署上万辆无方向盘汽车据介绍，Apollo RT6是百度面向未来出行自主研发、正向设计的量产车，整车针对乘客需求和无人驾驶出行场景进行了深度设计，支持有方向盘、无方向盘两种模式。未来，Apollo RT6可以在相关政策法规的允许下，实现无方向盘自动驾驶。该车成本只要25万元，量产成本大幅降低至业界的1/10。广告2022百度世界大会召开：官方称将部署上万辆无方向盘汽车百度创始人、董事长兼首席执行官李彦宏表示：“未来打无人车，要比现在打车便宜一半。”按计划，百度明年将在萝卜快跑平台使用RT6，未来可以在全国部署上万辆。除了可以无人驾驶之外，Apollo RT6还配置了具有识别和提示功能的灵犀交互灯语、智能电动侧滑门、百变智能空间、独立座椅以及智能交互系统后移设计等人性化功能。你会尝试完全无方向盘的无人驾驶车吗？");
            }
        });
        atv = findViewById(R.id.atv);
    }
}