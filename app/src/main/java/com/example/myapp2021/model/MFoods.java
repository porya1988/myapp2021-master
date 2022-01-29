package com.example.myapp2021.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_food")
public class MFoods implements Parcelable {

    public MFoods( String id, String category, String description, String imageAddress, String name, String prepare, String ingredients) {

        this.id = id;
        this.category = category;
        this.description = description;
        this.imageAddress = imageAddress;
        this.name = name;
        this.prepare = prepare;
        this.ingredients = ingredients;
    }

    @Ignore
    public MFoods(int foodID, String id, String category, String description, String imageAddress, String name, String prepare, String ingredients) {
        this.setFoodID(foodID);
        this.id = id;
        this.category = category;
        this.description = description;
        this.imageAddress = imageAddress;
        this.name = name;
        this.prepare = prepare;
        this.ingredients = ingredients;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="foodId")
    private int foodID;

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("category")
    @Expose
    @ColumnInfo(name = "category")
    private String category;

    @SerializedName("description")
    @Expose
    @ColumnInfo(name= "description")
    private String description;

    @SerializedName("imageAddress")
    @Expose
    @ColumnInfo(name="imageAddres")
    private String imageAddress;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("prepare")
    @Expose
    @ColumnInfo(name = "prepare")
    private String prepare;

    @SerializedName("ingredients")
    @Expose
    @ColumnInfo(name="ingrdients")
    private String ingredients;


    protected MFoods(Parcel in) {
        id = in.readString();
        category = in.readString();
        description = in.readString();
        imageAddress = in.readString();
        name = in.readString();
        prepare = in.readString();
        ingredients = in.readString();
    }

    public static final Creator<MFoods> CREATOR = new Creator<MFoods>() {
        @Override
        public MFoods createFromParcel(Parcel in) {
            return new MFoods(in);
        }

        @Override
        public MFoods[] newArray(int size) {
            return new MFoods[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(category);
        dest.writeString(description);
        dest.writeString(imageAddress);
        dest.writeString(name);
        dest.writeString(prepare);
        dest.writeString(ingredients);
    }


    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
}
