package com.example.thistimeprobablycorrect3rdpartylibs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private HalfGauge  halfGuage;
    private Range rangeRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        halfGuage = findViewById(R.id.guage);

        Range rangeBlue = new Range();
        rangeBlue.setColor(Color.parseColor("#ced8a1"));
        rangeBlue.setFrom(-20);
        rangeBlue.setTo(0);

        Range redRange = new Range();
        redRange.setColor(Color.parseColor("#00b20b"));
        redRange.setFrom(80);
        redRange.setTo(100);

        halfGuage.addRange(redRange);
        halfGuage.addRange(rangeBlue);

        halfGuage.setMinValue(-20);
        halfGuage.setMaxValue(100);
        halfGuage.setValue(50);
    }


    public void refreshBtnPress(View view) {
        Random random = new Random();
        double value = random.nextInt(100) + 1;
        halfGuage.setValue(value);
    }
}