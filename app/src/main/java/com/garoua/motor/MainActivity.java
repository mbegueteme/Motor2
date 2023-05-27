package com.garoua.motor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editText1, editText2;

    private Matcher matcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonValider=findViewById(R.id.btnValider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   /* login();
                    validateEmail("tombiouddou3@gmail.com");
                    validatePassword("1234");*/
                  Intent intent=new Intent(MainActivity.this, PagePrincipal.class);
                  startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public  void  login(){
        String email=editText1.getText().toString().trim();
        String password=editText2.getText().toString().trim();

        if (email.isEmpty()|| !validateEmail(email)){
            editText1.setError("Field cannot be empty");

            if (email.isEmpty()){
                Toast.makeText(this, "Cannot submit empty field", Toast.LENGTH_SHORT).show();
            }else if (!validateEmail(email)){
                editText1.setError("Email is not valid");
                Toast.makeText(this, "Fake email", Toast.LENGTH_SHORT).show();


            }
        }
        if (password.isEmpty()|| !validatePassword(email)){
            if (email.isEmpty()){

                editText1.setError("Field cannot be empty");
                Toast.makeText(this, "Cannot submit empty field", Toast.LENGTH_SHORT).show();

            }else if (!validatePassword(email)){
                editText1.setError("Email is not valid");
                Toast.makeText(this, "password not matched", Toast.LENGTH_SHORT).show();


            }
        }else {
            Toast.makeText(this, "successfully validated", Toast.LENGTH_SHORT).show();
        }
    }

    public  boolean validateEmail(String email){
        final  String emailPattern="^[a-zA-Z0-9#_~!$&'()*+,;=:.\"<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern=Pattern.compile(emailPattern);
        matcher=pattern.matcher(email);

        return matcher.matches();
    }

    public boolean validatePassword(String password){
        final String passwordPattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,20}$";
        Pattern pattern=Pattern.compile(passwordPattern);
        matcher=pattern.matcher(password);

        return matcher.matches();
    }
}