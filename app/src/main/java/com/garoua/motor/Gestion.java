package com.garoua.motor;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.security.PublicKey;

public class Gestion implements Parcelable {
    private int id;
    private  String name, addresse, service, numero;
    public Gestion(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    protected Gestion(Parcel in) {
        id = in.readInt();
        name = in.readString();
        addresse = in.readString();
        service = in.readString();
        numero = in.readString();
    }

    public static final Creator<Gestion> CREATOR = new Creator<Gestion>() {
        @Override
        public Gestion createFromParcel(Parcel in) {
            return new Gestion(in);
        }

        @Override
        public Gestion[] newArray(int size) {
            return new Gestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(numero);
        dest.writeString(name);
        dest.writeString(addresse);
        dest.writeString(service);
    }
}
