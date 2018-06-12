package com.udacity.gradle.builditbigger.backend;

import com.phantom.asalama.javajokes.Joker;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

   private Joker mJoker ;

   public  JokeBean(){
       mJoker=new Joker();
   }

    public String getJoke() {
        return mJoker.getJoke();
    }

}