package com.mp.speach_to_text.B;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mp.speach_to_text.C.MicActivity;
import com.mp.speach_to_text.R;

import java.util.Timer;
import java.util.TimerTask;

public class SpeechActivity extends AppCompatActivity {

    private LinearLayout btn_mic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_speech_activity);

        setViewPager();

        btn_mic = findViewById(R.id.btn_mic);
        btn_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpeechActivity.this, MicActivity.class));
            }
        });
    }

    //ViewPager
    private Timer timer = null;
    private int timekitper = 0;
    private ViewPager viewPager;
    private Bitmap[] benu = null;
    private ViewPaperAdapter viewPaperAdapter;

    public void setViewPager() {
        Drawable drawable = getResources().getDrawable(R.drawable.b_benu);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        benu = new Bitmap[1];
        benu[0] = bitmap;

        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(1);
        viewPaperAdapter = new ViewPaperAdapter(this, benu);
        viewPager.setAdapter(viewPaperAdapter);

        ViewGroup.LayoutParams params = viewPager.getLayoutParams();
        params.height = getResources().getDisplayMetrics().widthPixels;
        viewPager.setLayoutParams(params);
        viewPager.setClipToPadding(false);
        int value = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (value*d);
        viewPager.setPadding(margin, margin, margin, margin);
        viewPager.setPageMargin(margin/2);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1), true);
                        timekitper++;
                        if(timekitper==200)
                        {
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 5000, 5000);
    }
}
