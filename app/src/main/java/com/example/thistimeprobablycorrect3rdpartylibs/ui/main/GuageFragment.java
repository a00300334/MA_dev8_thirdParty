package com.example.thistimeprobablycorrect3rdpartylibs.ui.main;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;
import com.example.thistimeprobablycorrect3rdpartylibs.R;

import java.util.Random;

public class GuageFragment extends Fragment {

    private HalfGauge halfGuage;
    private Range rangeRed;

    public GuageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guage, container, false);
        halfGuage = view.findViewById(R.id.guage);

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

        Button btn = view.findViewById(R.id.refresh_btn);
        btn.setOnClickListener(e->{
            Random random = new Random();
            double value = random.nextInt(100) + 1-21;
            halfGuage.setValue(value);
        });

        // Inflate the layout for this fragment
        return view;
    }
}