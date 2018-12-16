package com.example.ermolaevio.sovcombankapp.timer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.ermolaevio.sovcombankapp.R;

public class MessageDialog extends AppCompatDialogFragment {

    public interface NoticeDialogListener {
        void onPositiveBtnClick();
    }

    @Nullable
    private NoticeDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NoticeDialogListener) {
            listener = (NoticeDialogListener) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage(R.string.dialogMessage)
                .setPositiveButton(R.string.closeDialog, (d, v) -> onPositiveBtnClick())
                .create();
    }

    private void onPositiveBtnClick() {
        if (listener != null) {
            listener.onPositiveBtnClick();
        }
    }
}
