package akshatchhaya.example.javaminiproject.ui.slideshow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.snackbar.Snackbar;

import akshatchhaya.example.javaminiproject.MainActivity;
import akshatchhaya.example.javaminiproject.R;
import akshatchhaya.example.javaminiproject.api.LoginAPI;
import akshatchhaya.example.javaminiproject.api.OnResponseListener;

public class Confirmation_dialogue extends AppCompatDialogFragment {

    final String TAG="Confirm Password";
    public ExampleDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.password_dialogue,null);


        builder.setView(view).setTitle("Confirm your password to change the password").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText password=view.findViewById(R.id.confirm_password_for_changing);
                listener.applyTexts(password.getText().toString());

            }
        });
        return  builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener)getTargetFragment();
        } catch (ClassCastException e) {
            Log.e(TAG,"Dakho onAttach");
        }
    }
    public interface ExampleDialogListener {
        void applyTexts(String password);
    }
}
