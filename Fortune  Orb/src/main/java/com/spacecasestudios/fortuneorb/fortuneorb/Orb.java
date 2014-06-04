package com.spacecasestudios.fortuneorb.fortuneorb;

import java.util.Random;

/**
 * Created by Ryan on 6/4/2014.
 */
public class Orb {
    //Member variables

    //An array of available mAnswers that will be shown in the orb
    private String[] mAnswers = {
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
    private String mAnswer = "";


    //Methods
    public String getAnAnswer(){

        //Randomly select an integer to index the mAnswers array
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mAnswers.length);
        mAnswer = mAnswers[randomNumber];

        return mAnswer;
    }

}
