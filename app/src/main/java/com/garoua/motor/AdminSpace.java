package com.garoua.motor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Locale;

public class AdminSpace extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Gestion> listGestion=new ArrayList<>();
    private  ArrayList<Gestion> result=new ArrayList<>();
    private  DBHelper dbHelper;
    private GestionAdapter gestionAdapter;
    ImageView addAdmin;
    private EditText search;

    public static boolean isActionMode=false;
    public static ArrayList<Gestion> userSelectionList=new ArrayList<>();
    public static ActionMode actionModeAdmin=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_space);

        dbHelper=new DBHelper(getApplicationContext());
        listView=findViewById(R.id.listview);
        search=findViewById(R.id.search);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);

        addAdmin=findViewById(R.id.addAdmin);
        listGestion=dbHelper.gestionsAdmin();
        result=dbHelper.gestionsAdmin();
        gestionAdapter=new GestionAdapter(this, listGestion);
        listView.setAdapter(gestionAdapter);


        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminSpace.this, Admin.class);
                startActivity(intent);
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {
                listGestion=filterText(sequence.toString());
                gestionAdapter=new GestionAdapter(getApplicationContext(), listGestion);
                listView.setAdapter(gestionAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private ArrayList<Gestion> filterText(String textfilter){
        ArrayList<Gestion> mesArrayList=new ArrayList<>();
        if (textfilter !=null){
            for (int i=0; i<result.size();i++){
                if (result.get(i).getName().toUpperCase().contains(textfilter.toUpperCase())){
                    mesArrayList.add(result.get(i));

                }
            }
        }else {
            mesArrayList=result;
        }
        return mesArrayList;
    }

    AbsListView.MultiChoiceModeListener modeListener=new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater inflater=actionModeAdmin.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);

            isActionMode=true;
            actionModeAdmin=actionMode;
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.action_delete_menu:
                   dbHelper.deleteAdmin(userSelectionList);
                    updateDisplayAdmin();
                    actionMode.finish();

                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            isActionMode=false;
            actionModeAdmin=null;
            userSelectionList.clear();
            updateDisplayAdmin();
        }
    };

    private  void updateDisplayAdmin(){
        result=dbHelper.gestionsAdmin();
        listGestion=dbHelper.gestionsAdmin();
        gestionAdapter=new GestionAdapter(getApplicationContext(), listGestion);
        listView.setAdapter(gestionAdapter);

    }
}