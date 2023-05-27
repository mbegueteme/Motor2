package com.garoua.motor;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PagePrincipal extends AppCompatActivity {

    ImageView adminPge, usersPage, motoPage, call, email, message, share;
    TextView admintxt, usersTxt, mototxt;
    EditText number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_principal);

        adminPge=findViewById(R.id.adminimg);
        usersPage=findViewById(R.id.usersimg);
         motoPage=findViewById(R.id.motoimg);


        mototxt=findViewById(R.id.mototxt);
        admintxt=findViewById(R.id.admintxt);
        usersTxt=findViewById(R.id.userstxt);

        email=findViewById(R.id.email);
        call=findViewById(R.id.call);
        message=findViewById(R.id.message);
        share=findViewById(R.id.share);
        
        
        number=findViewById(R.id.numberID);
      //  Button calll=findViewById(R.id.calll);



        admintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, Admin.class);
                startActivity(intent);
            }
        });

        adminPge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, Admin.class);
                startActivity(intent);
            }
        });


        usersPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, Taximan.class);
                startActivity(intent);
            }
        });

        usersTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, Taximan.class);
                startActivity(intent);
            }
        });


        motoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, MotoRegister.class);
                startActivity(intent);
            }
        });

        mototxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, MotoClass.class);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PagePrincipal.this, AdminSpace.class);
                startActivity(intent);
            }
        });





        /*==============================================================================================*/

        /*calll.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        
        String num=number.getText().toString().trim();
        if (!num.equals("")){
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("Tel:"+num));
            startActivity(intent);
        }else{
            Toast.makeText(PagePrincipal.this, "please enter your number", Toast.LENGTH_SHORT).show();
        }
       
    }
});*/
    }
}