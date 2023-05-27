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

public class GestionAdapter extends ArrayAdapter<Gestion> {
    public ArrayList<Gestion> gestionArrayList;
    public DBHelper dbHelper;
    TextView nomItem, addresseItem, numeroItem, serviceItem;

    public GestionAdapter(Context context, ArrayList<Gestion>gestionArrayList){
        super(context, 0, gestionArrayList);
        this.gestionArrayList=gestionArrayList;
        this.dbHelper=new DBHelper(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View  initView (int position, View convertView,ViewGroup parent){

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        nomItem=convertView.findViewById(R.id.textview1);
        addresseItem=convertView.findViewById(R.id.textview2);
        serviceItem=convertView.findViewById(R.id.textview3);
        numeroItem=convertView.findViewById(R.id.textview4);

        Gestion currentGestion=getItem(position);
        if (currentGestion !=null){
            nomItem.setText(currentGestion.getName());
            addresseItem.setText(currentGestion.getAddresse());
            serviceItem.setText(currentGestion.getService());
            numeroItem.setText(currentGestion.getNumero());
        }
/*
        CheckBox checkBox=convertView.findViewById(R.id.checkbox);
        checkBox.setTag(position);
        ImageButton editImage0=convertView.findViewById(R.id.chekImage0);
        ImageButton editImage1=convertView.findViewById(R.id.checkImageEdit);
        EditText editName=convertView.findViewById(R.id.editNom);
        EditText editAdresse=convertView.findViewById(R.id.editAddresse);
        EditText editService=convertView.findViewById(R.id.editService);
        EditText editNumero=convertView.findViewById(R.id.editNumero);

        if (AdminSpace.isActionMode){
            checkBox.setVisibility(View.VISIBLE);
            editImage0.setVisibility(View.VISIBLE);
        }else{
            checkBox.setVisibility(View.GONE);
            editImage0.setVisibility(View.GONE);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int position=(int) compoundButton.getTag();
                if (AdminSpace.userSelectionList.contains(gestionArrayList.get(position))){
                    AdminSpace.userSelectionList.remove(gestionArrayList.get(position));
                }else{
                    AdminSpace.userSelectionList.add(gestionArrayList.get(position));
                    AdminSpace.actionModeAdmin.setTitle(AdminSpace.userSelectionList.size()+" Admin selectionnes...");

                }

            }
        });

        editImage0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setVisibility(View.GONE);
                nomItem.setVisibility(View.GONE);
                addresseItem.setVisibility(View.GONE);
                serviceItem.setVisibility(View.GONE);
                numeroItem.setVisibility(View.GONE);


                editName.setVisibility(View.VISIBLE);
                editName.setText(currentGestion.getName());
                editAdresse.setVisibility(View.VISIBLE);
                editAdresse.setText(currentGestion.getAddresse());
                editService.setVisibility(View.VISIBLE);
                editService.setText(currentGestion.getService());
                editNumero.setVisibility(View.VISIBLE);
                editNumero.setText(currentGestion.getNumero());
                editImage1.setVisibility(View.VISIBLE);

            }
        });

        editImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkBox.setVisibility(View.VISIBLE);
                nomItem.setVisibility(View.VISIBLE);
                addresseItem.setVisibility(View.VISIBLE);
                serviceItem.setVisibility(View.VISIBLE);
                numeroItem.setVisibility(View.VISIBLE);

                String newNom=editName.getText().toString();
                String newAddresse=editAdresse.getText().toString();
                String newService=editService.getText().toString();
                String newNumero=editNumero.getText().toString();

                editName.setVisibility(View.GONE);
                editAdresse.setVisibility(View.GONE);
                editService.setVisibility(View.GONE);
                editNumero.setVisibility(View.GONE);
                editImage1.setVisibility(View.GONE);

                nomItem.setText(newNom);
                addresseItem.setText(newAddresse);
                serviceItem.setText(newService);
                numeroItem.setText(newNumero);


                dbHelper.UpdateAdmin(newNom, newAddresse, newService, newNumero, currentGestion.getId());
            }
        });*/

        return  convertView;
    }


}
