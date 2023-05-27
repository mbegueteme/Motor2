package com.garoua.motor;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DBname="motoDB.db";
    public static final int  Version=1;

    public DBHelper( Context context) {
        super(context, DBname, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1="CREATE TABLE Admin("
                +"id integer not null primary key autoincrement,"
                +"Nom TEXT,"
                +"Addresse TEXT,"
                +"Service TEXT,"
                +"Numero TEXT not null" +
                ")";
        db.execSQL(sql1);

        String sql11="CREATE TABLE MyAdmin("
                +"id integer not null primary key autoincrement,"
                +"Nom TEXT,"
                +"Addresse TEXT,"
                +"Service TEXT,"
                +"Numero TEXT not null,"
                +"isDonne bool not null,"
                +"id11 int not null"+
        ")";
        db.execSQL(sql11);


        String sql2="CREATE TABLE Motor("
                +"id integer not null primary key autoincrement,"
                +"Marque TEXT,"
                +"Addresse TEXT,"
                +"Matricule TEXT,"
                +"Num_carte TEXT not null" +
                ")";
        db.execSQL(sql2);

        String sql3="CREATE TABLE User("
                +"id integer not null primary key autoincrement,"
                +"Nom TEXT,"
                +"Addresse TEXT,"
                +"Numero integer not null" +
                ")";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    public ArrayList<Gestion> gestionsAdmin(){
        ArrayList<Gestion> mesGestions=new ArrayList<Gestion>();
        String selection="SELECT * FROM Admin";
        Cursor cursor=this.getWritableDatabase().rawQuery(selection, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                 @SuppressLint("Range") int id=cursor.getInt(cursor.getColumnIndex("id"));
                 @SuppressLint("Range") String nom=cursor.getString(cursor.getColumnIndex("Nom"));
                 nom=nom.replace("((%))","'");
                @SuppressLint("Range") String Addresse=cursor.getString(cursor.getColumnIndex("Addresse"));
                Addresse=Addresse.replace("((%))","'");
                @SuppressLint("Range") String service=cursor.getString(cursor.getColumnIndex("Service"));
                service=service.replace("((%))","'");
                @SuppressLint("Range") String Numero=cursor.getString(cursor.getColumnIndex("Numero"));
                Numero=Numero.replace("((%))","'");


                Gestion gestion=new Gestion();
                gestion.setId(id);
                gestion.setName(nom);
                gestion.setAddresse(Addresse);
                gestion.setService(service);
                gestion.setNumero(Numero);

                mesGestions.add(gestion);
                cursor.moveToNext();
            }
        }

        return mesGestions;
    }


    public ArrayList<Gestion> gestionsAdmin1(){
        ArrayList<Gestion> mesGestions=new ArrayList<Gestion>();
        String selection="SELECT * FROM Motor";
        Cursor cursor=this.getWritableDatabase().rawQuery(selection, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                @SuppressLint("Range") int id=cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String nom=cursor.getString(cursor.getColumnIndex("Marque"));
                nom=nom.replace("((%))","'");
                @SuppressLint("Range") String Addresse=cursor.getString(cursor.getColumnIndex("Addresse"));
                Addresse=Addresse.replace("((%))","'");
                @SuppressLint("Range") String service=cursor.getString(cursor.getColumnIndex("Matricule"));
                service=service.replace("((%))","'");
                @SuppressLint("Range") String Numero=cursor.getString(cursor.getColumnIndex("Num_carte"));
                Numero=Numero.replace("((%))","'");


                Gestion1 gestion=new Gestion1();
                gestion.setId(id);
                gestion.setName1(nom);
                gestion.setAddresse1(Addresse);
               // gestion.getNumero1(Numero);
                gestion.setNumero1(service);

               // mesGestions.add(gestion);
                cursor.moveToNext();
            }
        }

        return mesGestions;
    }
    public  void  insertAdmin(String NomAdmin, String Addresse, String ServiceAdmin, String NumeroAdmin){
        String name=NomAdmin.replace("'", "((%))");
        String addresse=Addresse.replace("'", "((%))");
        String service=ServiceAdmin.replace("'", "((%))");
        String nummero=NumeroAdmin.replace("'", "((%))");
        String sqlInsert="INSERT INTO admin " +
                "(Nom,Addresse,Service, Numero )values('"
                +NomAdmin+"','"
                +Addresse+"','"
                +ServiceAdmin+"','"
                +NumeroAdmin+"')";
        this.getWritableDatabase().execSQL(sqlInsert);

    }

    public void UpdateAdmin(String newnom, String newaddresse, String newservice, String newnumero, int Adminlist){
        newnom=newnom.replace("'", "((%))");
        newaddresse=newaddresse.replace("'", "((%))");
        newservice=newservice.replace("'", "((%))");
        newnumero=newnumero.replace("'", "((%))");

        String sql="update * FROM Admin set Nom='"+newnom+"'WHERE id="+Adminlist;
        this.getWritableDatabase().execSQL(sql);
    }

    public void deleteAdmin(ArrayList<Gestion> gestionArrayList){
        for (int i=0; i<gestionArrayList.size();i++){
            String sql="DELETE FROM Admin WHERE id="+gestionArrayList.get(i).getId();
            this.getWritableDatabase().execSQL(sql);

            String sql1="delete from MyAdmin where id11="+gestionArrayList.get(i).getId();
            this.getWritableDatabase().execSQL(sql1);
        }
    }

    /*


    public static final String TABLE_NAME="Moto";
    public static final String ColumnID="ID";
    public static final String columnMatricule="IMMATRICULATION";
    public static final String columnMarque="MARQUE";
    public static final String columnAssurance="ASSURANCE";
    public static final String columnCarte="CARTE_GRISE";

    Context context;

    public DBHelper(@Nullable Context context) {
        super(context,DBname, null, Version);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String Administrator= "CREATE TABLE Admin(idAdmin INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, localiteAdmin Text, serviceAdmin TEXT,addresseAdmin TEXT,telephone INTEGER, cniAdmin INTEGER )";
        String tableCreate= "CREATE TABLE Moto(idMoto INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, matriculMoto INTEGER, marqueMoto TEXT, assuranceMoto TEXT,carteGrise TEXT )";
        String user= "CREATE TABLE User(idUser INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, nomUser TEXT, prenomUser TEXT, addresseUser TEXT)";

        db.execSQL(tableCreate);
        db.execSQL(Administrator);
        db.execSQL(user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("DROP TABLE IF EXISTS Admin");
        db.execSQL("DROP TABLE IF EXISTS Moto");
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }


     insertion de la moto dans la base de donnee
    public void insertMoto( int matriculeMoto, String marqueMoto, String assuranceMoto, String numCarte){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("matriculMoto", matriculeMoto);
        cv.put("marqueMoto", marqueMoto);
        cv.put("assuranceMoto", assuranceMoto);
        cv.put("carteGrise", numCarte);
        long result=DB.insert("Moto", null, cv);

        if (result==-1){
            Toast.makeText(context, "Moto not saved", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "new Moto saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertAdmin( String localiteAdmin , String serviceAdmin, String addresseAdmin, int telephone, int cniAdmin){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("localiteAdmin", localiteAdmin);
        cv.put("serviceAdmin", serviceAdmin);
        cv.put("addresseAdmin", addresseAdmin);
        cv.put("telephone", telephone);
        cv.put("cniAdmin", cniAdmin);
        long result=DB.insert("Admin", null, cv);

        if (result==-1){
            Toast.makeText(context, "Admin not saved", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "new Admin saved", Toast.LENGTH_SHORT).show();
        }
    }



    public void inserUser( String nomUser, String prenomUser, String addresseUser){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nomUser", nomUser);
        cv.put("prenomUser", prenomUser);
        cv.put("addresseUser", addresseUser);
        long result=DB.insert("User", null, cv);

        if (result==-1){
            Toast.makeText(context, "User not saved", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "new User saved", Toast.LENGTH_SHORT).show();
        }
    }


    public void UpdateMoto(String idmoto, String matriculeMoto, String marqueMoto, String assuranceMoto, String numCarte){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("matriculMoto", matriculeMoto);
        cv.put("marqueMoto", marqueMoto);
        cv.put("assuranceMoto", assuranceMoto);
        cv.put("carteGrise", numCarte);

        long result = DB.update("Moto", cv, "ID = ?", new String[]{idmoto});
        if (result==-1){
            Toast.makeText(context, "Moto not updated ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Moto updated successfully", Toast.LENGTH_SHORT).show();
        }

        Cursor cursor=DB.rawQuery("select * from Moto where idmoto= ?", new String[]{idmoto});
    }


    public void DeleteMoto(String idmoto){
        SQLiteDatabase DB=this.getWritableDatabase();
        long result = DB.delete("Moto",  "ID = ?", new String[]{idmoto});
        if (result==-1){
            Toast.makeText(context, "Motor not deleted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Motor  deleted", Toast.LENGTH_SHORT).show();
        }
    }


    public Cursor ListMoto(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM Moto",null);
        return cursor;
    }

    public void DeleteAllMoto(String idmoto){
        SQLiteDatabase DB=this.getWritableDatabase();
        DB.execSQL("DELETE FROM Moto");

    }

    public  Cursor searchMoto(String id){
        SQLiteDatabase DB=this.getWritableDatabase();
        String[] columns=new String[]{"ID","matriculMoto","marqueMoto","assuranceMoto", "carteGrise"};
        Cursor cursor=DB.query("Moto", columns, "ID= ?", new String[]{id}, null, null, null, null);
        return cursor;
    }


    public void deleteAllMoto(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM Moto");
    }
*/


    /*===================================================================================================================*/

}
