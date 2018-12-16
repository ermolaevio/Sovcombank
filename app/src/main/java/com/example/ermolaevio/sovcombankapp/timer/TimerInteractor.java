package com.example.ermolaevio.sovcombankapp.timer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class TimerInteractor {

    public Completable startTimer() {
        return Completable.timer(5000, TimeUnit.MILLISECONDS, Schedulers.io());
    }

}
