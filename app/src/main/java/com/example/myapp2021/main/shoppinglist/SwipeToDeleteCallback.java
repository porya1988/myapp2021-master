package com.example.myapp2021.main.shoppinglist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    private Notelistadapter notelistadapter;

    public SwipeToDeleteCallback(Notelistadapter notelistadapter) {
        super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT );
        this.notelistadapter=notelistadapter;
    }


    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
     int position=viewHolder.getLayoutPosition();
     
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }
}
