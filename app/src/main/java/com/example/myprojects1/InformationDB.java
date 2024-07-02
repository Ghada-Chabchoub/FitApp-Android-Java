package com.example.myprojects1;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class InformationDB implements Parcelable{

    private String userId;
    private int age;
    private float poid;
    private int taille;
    private String genre;
    private double imc;

    public InformationDB( String userId, int age, float poid, int taille, String genre,double imc) {

        this.userId = userId;
        this.age = age;
        this.poid = poid;
        this.taille = taille;
        this.genre = genre;
        this.imc = imc;
    }
    public InformationDB( int age, float poid, int taille, String genre) {

        this.age = age;
        this.poid = poid;
        this.taille = taille;
        this.genre = genre;

    }
    public InformationDB(double imc) {
        this.imc=imc;

    }

     public InformationDB() {

    }




    protected InformationDB(Parcel in) {

        userId = in.readString();
        age = in.readInt();
        poid = in.readFloat();
        taille = in.readInt();
        genre = in.readString();
        imc = in.readDouble();
    }

    public static final Creator<InformationDB> CREATOR = new Creator<InformationDB>() {
        @Override
        public InformationDB createFromParcel(Parcel in) {
            return new InformationDB(in);
        }

        @Override
        public InformationDB[] newArray(int size) {
            return new InformationDB[size];
        }
    };



    public float getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public float getPoid() {
        return poid;
    }

    public String getGenre() {
        return genre;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setPoid(float poid) {
        this.poid = poid;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(userId);
        dest.writeInt(age);
        dest.writeFloat(poid);
        dest.writeInt(taille);
        dest.writeString(genre);
        dest.writeDouble(imc);
    }
}//fin prog
