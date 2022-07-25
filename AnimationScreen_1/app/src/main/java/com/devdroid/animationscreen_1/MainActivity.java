package com.devdroid.animationscreen_1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    boolean isCheckedDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LottieAnimationView lottieCheckedDone = findViewById(R.id.lottieCheckedDone);
        lottieCheckedDone.setSpeed(3f);
        lottieCheckedDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCheckedDone) {
                    lottieCheckedDone.setMinAndMaxProgress(0.5f,1.0f);
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = false;
                } else {
                    lottieCheckedDone.setMinAndMaxProgress(0.0f,0.5f);
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = true;
                }
            }
        });

    }
}