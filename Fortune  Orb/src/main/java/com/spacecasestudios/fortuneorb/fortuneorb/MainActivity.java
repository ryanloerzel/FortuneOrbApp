package com.spacecasestudios.fortuneorb.fortuneorb;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    //Member variables
    private Orb mOrb = new Orb();
    private TextView mAnswerLabel;
    private Button mGetAnswerButton;

    //Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign view variables to views from the activity_main.xml layout
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mGetAnswerButton = (Button) findViewById(R.id.button1);

        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = mOrb.getAnAnswer();
                //Update the label with a dynamic answer
                mAnswerLabel.setText(answer);

                animateAnswer();
                playSound();

            }
        });
    }

   //Creates a fade in animation for the crystal ball text
   private void animateAnswer(){
       //set the opacity
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);

        fadeInAnimation.setDuration(1500);
        fadeInAnimation.setFillAfter(true);


        mAnswerLabel.clearAnimation();/*Hack to make sure the animation
                                        runs every time the button is pressed*/

        mAnswerLabel.setAnimation(fadeInAnimation);

     
    }

    private void playSound(){
        MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
