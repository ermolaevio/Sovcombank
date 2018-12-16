package com.example.ermolaevio.sovcombankapp.timer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.ermolaevio.sovcombankapp.R;

public class TimerActivity extends MvpAppCompatActivity
        implements TimerView, MessageDialog.NoticeDialogListener {

    private static final String MESSAGE_DIALOG = "MessageDialog";

    @InjectPresenter
    TimerPresenter presenter;

    @ProvidePresenter
    TimerPresenter providePresenter() {
        return new TimerPresenter(new TimerInteractor());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.startTimerButton:
                presenter.onStartTimerClick();
                break;
        }
    }

    @Override
    public void showDialog() {
        Fragment df = getSupportFragmentManager().findFragmentByTag(MESSAGE_DIALOG);
        if (df == null) {
            MessageDialog dialog = new MessageDialog();
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), MESSAGE_DIALOG);
        }
    }


    @Override
    public void hideDialog() {
        MessageDialog df = (MessageDialog) getSupportFragmentManager().findFragmentByTag(MESSAGE_DIALOG);
        if (df != null) {
            df.dismiss();
        }
    }

    @Override
    public void onPositiveBtnClick() {
        presenter.onCloseDialogClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideDialog();
    }
}
