package com.example.luizsabiano.capwinverify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;



public class BancoController extends AppCompatActivity {
    private SQLiteDatabase db;
    DataBaseCreator banco;


    public BancoController(Context context) {
        banco = new DataBaseCreator(context);
    }



    public String addUser(User usr) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataBaseCreator.user[1], usr.getUserName());
        valores.put(DataBaseCreator.user[2], usr.getCpf());
        valores.put(DataBaseCreator.user[3], usr.getCelPhone());
        valores.put(DataBaseCreator.user[4], usr.getEmail());
        valores.put(DataBaseCreator.user[5], usr.getPasswd());
        resultado = db.insert(DataBaseCreator.tabUser, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }



    public int checkUser(User usr)
    {
        int id=-1;
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM "+ DataBaseCreator.tabUser + " " +
                        "               WHERE "+DataBaseCreator.user[2]+"=? " +
                        "               AND "+DataBaseCreator.user[5]+"=?",
                new String[]{usr.getCpf(),usr.getPasswd()});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();

        }
        db.close();
        return id;
    }


}




