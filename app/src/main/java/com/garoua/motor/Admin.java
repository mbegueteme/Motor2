package com.garoua.motor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
  private String nom, addresse, service, numero;
     EditText nomEdit, addresseEdit, serviceEdit, numeroEdit;
     Button addAdmin;
     private DBHelper helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

         helper=new DBHelper(getApplicationContext());
      nomEdit=findViewById(R.id.txt3);
        addresseEdit=findViewById(R.id.txt4);
        serviceEdit=findViewById(R.id.txt5);
        numeroEdit=findViewById(R.id.txt6);

        addAdmin=findViewById(R.id.btnAdd);
        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom=nomEdit.getText().toString();
                addresse=addresseEdit.getText().toString();
                service=serviceEdit.getText().toString();
                numero=numeroEdit.getText().toString();

                helper.insertAdmin(nom, addresse, service, numero);

                Intent start=new Intent(getApplicationContext(), AdminSpace.class);
                startActivity(start);
            }
        });



/*

        add=findViewById(R.id.btnadd);

        DBHelper  dbHelper=new DBHelper(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idAdmin=id.getText().toString();
                localiteAdmin=localite.getText().toString();
                serviceAdmin=service.getText().toString();
                addresseAdmin=addresse.getText().toString();

                if (localiteAdmin.isEmpty()||serviceAdmin.isEmpty()||addresseAdmin.isEmpty()){
                    Toast.makeText(Admin.this, "cannot insert empty Admin", Toast.LENGTH_SHORT).show();
                }else {
                    telAdmin=Integer.parseInt(tel.getText().toString());
                    cniAdmin=Integer.parseInt(cni.getText().toString());

                    try {
                        dbHelper.insertAdmin(localiteAdmin, serviceAdmin, addresseAdmin, cniAdmin, telAdmin);

                        // clear data field

                        id.getText().clear();
                        localite.getText().clear();
                        service.getText().clear();
                        tel.getText().clear();
                        cni.getText().clear();
                        addresse.getText().clear();

                    }catch (Exception e){
                         e.printStackTrace();
                    }
                }
                }
        });
*/
        //clear=findViewById(R.id.btnclear);

/*
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNotificationChanel();
                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(), CHANEL_ID)
                        .setSmallIcon(R.drawable.admin)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                                .setContentTitle("control des moto taxis")
                        .setContentText("This is a new Control")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(NOTIFICATION_ID, builder.build());
            }
        });

        public void createNotificationChanel(){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.0){
                CharSequence sequence="Notification";
                String description="simple Notification";
                int importance= NotificationManager.IMPORTANCE_DEFAULT;

                NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID, sequence, importance);
                notificationChannel.setDescription(description);

                NotificationManager notificationManager=getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }*/
    }

}