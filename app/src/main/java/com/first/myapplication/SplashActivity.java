package com.first.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Lifecycle","create");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToCalculatorActivity();

            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("Lifecycle","start");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Lifecycle","pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle","onstop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Lifecycle","destroy");

    }

    void goToCalculatorActivity(){
        Intent intent = new Intent(SplashActivity.this,CalculatorActivity.class);
            startActivity(intent);
            finish();
    }





    }
