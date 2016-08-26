package com.example.anuj.primenumberr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private int mNumber;
    private TextView mTextView;
    private int mFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Intent intent = getIntent();
        mNumber = Integer.parseInt(intent.getStringExtra(MainActivity.MESSAGE_CHEAT) );
    }
    public void showCheatPressed(View view) {
        mTextView = (TextView)findViewById(R.id.cheatTextView);
        mFlag = 1;
        int result = MainActivity.testNumber(mNumber) ;
        if(result == 1)//Prime
        {

            mTextView.setText(""+mNumber + " is a prime number" );
            mTextView.setVisibility(View.VISIBLE);
        }
        else if (result == 0)
        {
            mTextView.setText(""+mNumber + " is not a prime number " );
            mTextView.setVisibility(View.VISIBLE);
        }
        else if( result == -1){
            mTextView.setText("1 is neither a prime number nor a composite number " );
            mTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void finish(){

        Intent sendData = new Intent();
        sendData.putExtra("cheatReturnMessage" ,mFlag );
        setResult(RESULT_OK , sendData);
        super.finish();
    }
}
