package com.example.anuj.primenumberr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.view.Gravity.*;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private int mNumber;
    private static final String TAG = "Prime Number";
    private Button mYesButton;
    private Button mNoButton;
    private Button mNextButton;

    private static final String STATE_COUNTER = "number";

    int generateNumber() {
        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        return number;
    }

    int testNumber(int n)// Test whether the number is prime or not returns 0 if not prime else returns 1
    {
        if (n == 1) {
            return -1;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }

        }
        return 1;
    }

    void displayNextQuestion() {
        mTextView = (TextView) findViewById(R.id.questionTextView);
        mNumber = generateNumber();
        mTextView.setText("Is " + mNumber + " a prime number ? ");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mNumber = savedInstanceState.getInt(STATE_COUNTER, 0);
            mTextView = (TextView) findViewById(R.id.questionTextView);

            mTextView.setText("Is " + mNumber + " a prime number ? ");
        } else
            displayNextQuestion();

        mYesButton = (Button) findViewById(R.id.yesButton);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Yes");
                if (testNumber(mNumber) == -1) {
                    Toast.makeText(getApplicationContext(), "1 is neither a prime number nor a composit number", Toast.LENGTH_SHORT).show();
                    displayNextQuestion();
                } else if (testNumber(mNumber) == 1) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    displayNextQuestion();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mNoButton = (Button) findViewById(R.id.noButton);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked No");
                if (testNumber(mNumber) == -1) {
                    Toast.makeText(getApplicationContext(), "1 is neither a prime number nor a composit number", Toast.LENGTH_SHORT).show();
                    displayNextQuestion();
                } else if (testNumber(mNumber) == 0) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    displayNextQuestion();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mNextButton = (Button) findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Next");
                displayNextQuestion();

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt(STATE_COUNTER, mNumber);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnResume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
