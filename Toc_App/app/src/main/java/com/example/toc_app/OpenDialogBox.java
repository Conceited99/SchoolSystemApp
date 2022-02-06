package com.example.toc_app;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class OpenDialogBox extends AppCompatDialogFragment {
    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(System.currentTimeMillis());
    Slots_Activity2 slot;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Assignment Submision")
        .setMessage("Submitted Assignment at: \n"+ timeStamp)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return builder.create();
    }
}
