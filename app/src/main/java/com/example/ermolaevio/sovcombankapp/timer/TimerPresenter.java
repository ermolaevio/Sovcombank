package com.example.ermolaevio.sovcombankapp.timer;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

@InjectViewState
public class TimerPresenter extends MvpPresenter<TimerView> {

    @NonNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NonNull
    private final TimerInteractor timerInteractor;

    public TimerPresenter(@NonNull TimerInteractor timerInteractor) {
        this.timerInteractor = timerInteractor;
    }

    public void onStartTimerClick() {
        disposables.add(timerInteractor.startTimer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> getViewState().showDialog(),
                        (error) -> handleError()));
    }

    private void handleError() {
        // ignore
    }

    public void onCloseDialogClick() {
        getViewState().hideDialog();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}
