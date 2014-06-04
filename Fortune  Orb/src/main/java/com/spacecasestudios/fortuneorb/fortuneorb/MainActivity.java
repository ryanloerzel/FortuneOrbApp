package com.spacecasestudios.fortuneorb.fortuneorb;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    //An array of available answers that will be shown in the orb
    private String[] answers = {
            "It is undeniable",
            "All signs point to YES",
            "It is certain",
            "Without a single doubt",
            "It is decidedly so",
            "The stars are not aligned",
            "Don't count on it",
            "Very doubtful",
            "My reply is a strong NO",
            "The Gods are not on your side",
            "Most certainly not",
            "It can not be known",
            "Better not tell you now",
            "Meditate and ask again",
            "The Gods frown upon such questions",
            "What will be will be"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare View variables and assign them to views from the activity_main.xml layout
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);

        getAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //The button was clicked, so update the answer label with an answer
                String answer = "";

                //Randomly select an integer to index the answers array
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(answers.length);
                answer = answers[randomNumber];

                //Update the label with a dynamic answer
                answerLabel.setText(answer);
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
