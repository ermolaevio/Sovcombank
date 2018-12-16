package com.example.ermolaevio.sovcombankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ermolaevio.sovcombankapp.list.ListActivity;
import com.example.ermolaevio.sovcombankapp.timer.TimerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.openListBtn:
                start(ListActivity.class);
                break;
            case R.id.openTimerBtn:
                start(TimerActivity.class);
                break;
        }
    }

    private void start(Class<? extends AppCompatActivity> cls) {
        startActivity(new Intent(this, cls));
    }
}
