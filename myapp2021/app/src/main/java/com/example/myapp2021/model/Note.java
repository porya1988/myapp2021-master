package com.example.myapp2021.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_note")
public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    private int noteId;

    @ColumnInfo(name = "buy")
    private String buy;

    @ColumnInfo(name = "amount")
    private String amount;


    public Note( String buy, String amount) {
        this.buy = buy;
        this.amount = amount;
    }
    @Ignore
    public Note(int noteId, String buy, String amount) {
        this.noteId = noteId;
        this.buy = buy;
        this.amount = amount;
    }

    protected Note(Parcel in) {
        setNoteId(in.readInt());
        setBuy(in.readString());
        setAmount(in.readString());
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Ignore
    public Note() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getNoteId());
        dest.writeString(getBuy());
        dest.writeString(getAmount());
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
