package com.garoua.motor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GestionAdapter1 extends ArrayAdapter<Gestion1> {

    public ArrayList<Gestion1> gestionArrayList1;
    public DBHelper dbHelper1;
    TextView nomItem1, addresseItem1, numeroItem1, serviceItem1;

    public GestionAdapter1(Context context, ArrayList<Gestion1>gestionArrayList1){
        super(context, 0, gestionArrayList1);
        this.gestionArrayList1=gestionArrayList1;
        this.dbHelper1=new DBHelper(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View  initView (int position, View convertView,ViewGroup parent){

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_view1, parent, false);
        }

        nomItem1=convertView.findViewById(R.id.textview21);
        addresseItem1=convertView.findViewById(R.id.textview22);
        serviceItem1=convertView.findViewById(R.id.textview23);
        numeroItem1=convertView.findViewById(R.id.textview24);

        Gestion1 currentGestion1=getItem(position);
        if (currentGestion1 !=null){
            nomItem1.setText(currentGestion1.getName1());
            addresseItem1.setText(currentGestion1.getAddresse1());
            serviceItem1.setText(currentGestion1.getService1());
            numeroItem1.setText(currentGestion1.getNumero1());
        }

        return  convertView;
    }


}
