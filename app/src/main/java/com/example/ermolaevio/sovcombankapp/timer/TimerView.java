package com.example.ermolaevio.sovcombankapp.timer;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface TimerView extends MvpView {

    void showDialog();

    void hideDialog();
}
