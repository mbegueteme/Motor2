package com.garoua.motor;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Gestion1 implements Parcelable {

    private int id1;
    private  String name1, addresse1, service1, numero1;
    public Gestion1(){

    }

    public int getId() {
        return id1;
    }

    public void setId(int id1) {
        this.id1 = id1;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getAddresse1() {
        return addresse1;
    }

    public void setAddresse1(String addresse1) {
        this.addresse1 = addresse1;
    }

    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    protected Gestion1(Parcel in1) {
        id1 = in1.readInt();
        name1 = in1.readString();
        addresse1 = in1.readString();
        service1 = in1.readString();
        numero1 = in1.readString();
    }

    public static final Creator<Gestion1> CREATOR = new Creator<Gestion1>() {
        @Override
        public Gestion1 createFromParcel(Parcel in) {
            return new Gestion1(in);
        }

        @Override
        public Gestion1[] newArray(int size) {
            return new Gestion1[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id1);
        dest.writeString(numero1);
        dest.writeString(name1);
        dest.writeString(addresse1);
        dest.writeString(service1);
    }
}
