package com.garoua.motor;

import static com.garoua.motor.AdminSpace.userSelectionList;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;

public class AdminSpace1 extends AppCompatActivity {

    private ListView listView1;
    private ArrayList<Gestion1> listGestion1=new ArrayList<>();
    private  ArrayList<Gestion1> result1=new ArrayList<>();
    private  DBHelper dbHelper1;
    private GestionAdapter1 gestionAdapter1;
    ImageView addAdmin1;
    private EditText search1;

    public static boolean isActionMode1=false;
    public static ArrayList<Gestion1> userSelectionList1=new ArrayList<>();
    public static ActionMode actionModeAdmin1=null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_space);

        dbHelper1=new DBHelper(getApplicationContext());
        listView1=findViewById(R.id.listview1);
        search1=findViewById(R.id.search1);

        listView1.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView1.setMultiChoiceModeListener(modeListener);

        addAdmin1=findViewById(R.id.addAdmin);
        gestionAdapter1=new GestionAdapter1(this, listGestion1);
        listView1.setAdapter(gestionAdapter1);


        addAdmin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminSpace1.this, Admin.class);
                startActivity(intent);
            }
        });

        search1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {
                listGestion1=filterText(sequence.toString());
                gestionAdapter1=new GestionAdapter1(getApplicationContext(), listGestion1);
                listView1.setAdapter(gestionAdapter1);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private ArrayList<Gestion1> filterText(String textfilter1){
        ArrayList<Gestion1> mesArrayList1=new ArrayList<>();
        if (textfilter1 !=null){
            for (int i=0; i<result1.size();i++){
                if (result1.get(i).getName1().toUpperCase().contains(textfilter1.toUpperCase())){
                    mesArrayList1.add(result1.get(i));

                }
            }
        }else {
            mesArrayList1=result1;
        }
        return mesArrayList1;
    }

    AbsListView.MultiChoiceModeListener modeListener=new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater inflater=actionModeAdmin1.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);

            isActionMode1=true;
            actionModeAdmin1=actionMode;
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
                    dbHelper1.deleteAdmin(userSelectionList);

                    actionMode.finish();

                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            isActionMode1=false;
            actionModeAdmin1=null;
            userSelectionList1.clear();

        }
    };


}