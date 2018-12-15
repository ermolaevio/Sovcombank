package com.example.ermolaevio.sovcombankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ermolaevio.sovcombankapp.list.ListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.openListBtn:
                openList();
                break;
            case R.id.openTimerBtn:
                openTimer();
                break;
        }
    }

    private void openList() {
        startActivity(new Intent(this, ListActivity.class));
    }

    private void openTimer() {

    }
}
