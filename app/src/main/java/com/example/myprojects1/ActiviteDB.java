package com.example.myprojects1;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class ActiviteDB implements Parcelable {

    private String userId;
    private float marche;
    private float course;
    private float velo;
    private float autre;
    private float caloriesBurned;


    public ActiviteDB(String userId, float marche, float course, float velo, float autre,float caloriesBurned ) {

        this.userId = userId;
        this.marche = marche;
        this.course = course;
        this.velo = velo;
        this.autre = autre;
        this.caloriesBurned=caloriesBurned;
    }

    public ActiviteDB(float marche, float course, float velo, float autre) {
        this.marche = marche;
        this.course = course;
        this.velo = velo;
        this.autre = autre;
    }
    public ActiviteDB(float caloriesBurned ) {
        this.caloriesBurned=caloriesBurned;
    }

    public ActiviteDB() {
    }

    protected ActiviteDB(Parcel in) {

        userId = in.readString();
        marche = in.readFloat();
        course = in.readFloat();
        velo = in.readFloat();
        autre = in.readFloat();
        caloriesBurned = in.readFloat();
    }

    public static final Creator<ActiviteDB> CREATOR = new Creator<ActiviteDB>() {
        @Override
        public ActiviteDB createFromParcel(Parcel in) {
            return new ActiviteDB(in);
        }

        @Override
        public ActiviteDB[] newArray(int size) {
            return new ActiviteDB[size];
        }
    };

    public float getMarche() {
        return marche;
    }

    public void setMarche(float marche) {
        this.marche = marche;
    }

    public float getCourse() {
        return course;
    }

    public void setCourse(float course) {
        this.course = course;
    }

    public float getVelo() {
        return velo;
    }

    public void setVelo(float velo) {
        this.velo = velo;
    }

    public float getAutre() {
        return autre;
    }

    public void setAutre(float autre) {
        this.autre = autre;
    }


    public float getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(float caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(userId);
        dest.writeFloat(marche);
        dest.writeFloat(course);
        dest.writeFloat(velo);
        dest.writeFloat(autre);
        dest.writeFloat(caloriesBurned);
    }
}


