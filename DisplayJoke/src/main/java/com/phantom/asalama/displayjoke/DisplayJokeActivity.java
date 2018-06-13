package com.phantom.asalama.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public String JOKE_EXTRA_KEY="joke_key";
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView jokeTxt=findViewById(R.id.joke);

        if(savedInstanceState==null){
            mJoke= getIntent().getStringExtra(JOKE_EXTRA_KEY);
        }else{
            mJoke= savedInstanceState.getString(JOKE_EXTRA_KEY);
        }

        jokeTxt.setText(mJoke);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_EXTRA_KEY,mJoke);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mJoke=savedInstanceState.getString(JOKE_EXTRA_KEY);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return true;

    }
}
