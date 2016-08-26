package com.example.anuj.primenumberr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anuj on 8/25/2016.
 */
public class HintActivity extends AppCompatActivity {
    private TextView mTextView;
    private int mNumber,mFactor;
    private int mFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Intent intent = getIntent();
         mNumber = Integer.parseInt(intent.getStringExtra(MainActivity.MESSAGE_HINT) );
         mFactor = getHint(mNumber);
    }

    public void showHintPressed(View view) {
        mTextView = (TextView)findViewById(R.id.hintTextView);
        mFlag = 1;
        if(mFactor == 1)
        {
            int squareRoot = (int) Math.sqrt(mNumber);
            mTextView.setText("Try to divide "+mNumber + " by a number greater than "+ squareRoot  );
            mTextView.setVisibility(View.VISIBLE);
        }
        else
        {
            mTextView.setText("Try to divide "+mNumber + " by "+mFactor );
            mTextView.setVisibility(View.VISIBLE);
        }
    }

    //get first factor of mNumber
    private int getHint(int mNumber) {
        int i;
        for( i = 2 ; i <= Math.sqrt(mNumber) ; i++  )
            if( ( mNumber % i ) == 0)
            {
                return i;
            }
        return 1;
    }
    @Override
    public void finish(){

        Intent sendData = new Intent();
        sendData.putExtra("hintReturnMessage" ,mFlag );
        setResult(RESULT_OK , sendData);
        super.finish();
    }
}