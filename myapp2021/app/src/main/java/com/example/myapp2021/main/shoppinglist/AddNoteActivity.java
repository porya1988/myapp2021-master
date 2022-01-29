package com.example.myapp2021.main.shoppinglist;

import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.ActivityAddNoteBinding;

import com.example.myapp2021.model.Note;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.rd.draw.data.RtlMode;

import java.util.List;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding binding;
    NAppDatabase appDatabase;
    Notelistadapter notelistadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        appDatabase = NAppDatabase.getInstance(AppConfiguration.getContext());
        setContentView(binding.getRoot());
        binding.btnSaveShopping.setOnClickListener(v -> {
            long noetId = addNote();

            if (noetId > 0) {

                notelistadapter.notifyItemInserted((int) noetId);
                Snackbar.make(v, R.string.note_added, Snackbar.LENGTH_LONG).show();
                //notelistadapter.notifyDataSetChanged();
                //notelistadapter.notifyItemInserted(note.getNoteId());

            }
        });
    }

    private long addNote() {
        Note note = new Note();
        note.setBuy(String.valueOf(binding.txtBuy.getText()));
        note.setAmount(String.valueOf(binding.txtAmount.getText()));
        return appDatabase.iDao().insert(note);
    }


}