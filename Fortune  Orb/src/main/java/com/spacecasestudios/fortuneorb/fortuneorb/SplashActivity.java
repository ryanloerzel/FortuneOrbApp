package com.spacecasestudios.fortuneorb.fortuneorb;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private ImageView loadingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadingScreen = (ImageView) findViewById(R.id.loading_screen);

        fadeInLoadingScreen(2000, 5000);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish(); //finish this activity and return to the calling activity (MainActivity)
            }
        },7*1000); // wait 5 sec
    }

    private void fadeInLoadingScreen(int fadeIn, int fadeOut) {
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
        final AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0);

        fadeInAnimation.setDuration(fadeIn);
        fadeInAnimation.setFillAfter(true);
        fadeOutAnimation.setDuration(fadeOut);
        fadeOutAnimation.setFillAfter(true);

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                loadingScreen.setAnimation(fadeOutAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        loadingScreen.setAnimation(fadeInAnimation);
    }
}
