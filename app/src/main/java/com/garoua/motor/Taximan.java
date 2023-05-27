package com.garoua.motor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Taximan extends AppCompatActivity {
Button addUser;
    DBHelper dbHelper;
    EditText nomUser, prenomUser, addresseUser;
    private  String nom, prenom, addresse, ID;
    Button clear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taximan);

    }
}