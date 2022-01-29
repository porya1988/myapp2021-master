package com.example.myapp2021.main.shoppinglist;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.model.Note;

import java.util.List;

public class ShoppingViewModel extends ViewModel {

    MutableLiveData<List<Note>> notelist=null;
    NAppDatabase appDatabase= NAppDatabase.getInstance(AppConfiguration.getContext());

     
     List<Note> note;
     Note notes=new Note();

    public LiveData<List<Note>> getShoppingList(){
        if(notelist==null){
            notelist=new MutableLiveData<>();
            loadData();
        }
        return notelist;
    }

    public void loadData(){

        note=appDatabase.iDao().getNoteList();
        notelist.setValue(note);
        Log.e("","");
    }



}
