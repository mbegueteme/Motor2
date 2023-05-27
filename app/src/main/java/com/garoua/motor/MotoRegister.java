package com.garoua.motor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MotoRegister extends AppCompatActivity {
    private EditText idEdit, matriculeEdit, marqueEdit, assuranceEdit, numcarteEdit;
    private  String carteGrise, assurance, marque, ID;
    private int matricule;
    private DBHelper dbHelper;
    TextView addButton, delButton, updateButton, showButton, searchButton, deleteAll;

Button next, show, search;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto_register);

    }
}