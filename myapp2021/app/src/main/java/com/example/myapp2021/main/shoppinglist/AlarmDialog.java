package com.example.myapp2021.main.shoppinglist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.FragmentShoppingBinding;
import com.example.myapp2021.model.Note;
import com.google.android.material.snackbar.Snackbar;

import java.time.chrono.IsoChronology;
import java.util.List;

import static com.google.android.material.snackbar.Snackbar.*;

public class AlarmDialog {

    Activity activity;
    NAppDatabase appDatabase;



    public AlarmDialog(Activity activity) {
        this.activity = activity;
        appDatabase = NAppDatabase.getInstance(AppConfiguration.getContext());
    }

    public void showAddAlarm(ISelection iSelection) {

        AlertDialog alertBuilder = new AlertDialog.Builder(activity).create();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.alert_dialog, null);
        alertBuilder.setView(view);
        alertBuilder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertBuilder.show();
        AppCompatEditText txt_buy = view.findViewById(R.id.txt_buy);
        AppCompatEditText txt_amount = view.findViewById(R.id.txt_amount);
        AppCompatButton btn_save = view.findViewById(R.id.btn_save_shopping);
        AppCompatButton btn_cancel = view.findViewById(R.id.btn_cancel);

        btn_save.setOnClickListener(v -> {
            Note note = new Note();
            note.setBuy(String.valueOf(txt_buy.getText()));
            note.setAmount(String.valueOf(txt_amount.getText()));
            Log.e("", "");
            if(TextUtils.isEmpty(txt_buy.getText()) || TextUtils.isEmpty(txt_amount.getText())) {
                Toast.makeText(AppConfiguration.getContext(), R.string.fill_both,Toast.LENGTH_SHORT).show();
            } else{
                long noteId = appDatabase.iDao().insert(note);
                if(noteId>0){
                    iSelection.iLoading();
                    Toast.makeText(AppConfiguration.getContext(),R.string.note_added,Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_cancel.setOnClickListener(v -> {
            alertBuilder.cancel();

        });
    }

}
