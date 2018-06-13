package com.phantom.asalama.javajokes;

import java.util.Random;

public class Joker {
    private final String [] mJokes={"Did you hear about the mathematician who's afraid of negative numbers ? "
            +"He'll stop at nothing to avoid them"
            ,"Q. A girl fell" +
            " off of a 30-foot ladder, but she didn’t get hurt at all. " +
            "How is this possible? A. She fell off the bottom step!"
            ,"Q. There are three apples on a table and you take away " +
            "two of them. How many apples do you have now? A. Two, of course!"};
    public String getJoke(){
        return mJokes[(new Random().nextInt(mJokes.length))];
    }
}
