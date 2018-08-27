package com.example.luizsabiano.capwinverify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DataBaseCreator extends SQLiteOpenHelper {

    private static final int versao = 1;
    private static final String nomeBanco = "tWinVerify.db";
    private static final String tabPCap = "postalCap";
    private static final String [] postalCap = {"id", "cpf", "sorte", "titulo",
            "dtCompra", "dtResgate",  "sort1", "sort2", "sort3", "sort4", "sort5"};

    static final String tabUser = "user";
    static final String [] user = {"id", "userName", "cpf", "celPhone", "email", "passwd"};


    public DataBaseCreator (Context context) {
        super(context, nomeBanco,null, versao);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Cria estrutural da tabela PostalCap - contém informações do título

        String createTable = "CREATE TABLE " + tabPCap + "("
                + postalCap[0] + " integer primary key autoincrement";
        for( int i = 1; i < (postalCap.length); i ++) {
            createTable = createTable + "," + postalCap[i] + " text ";
        }
        createTable = createTable + ")";
        db.execSQL(createTable);


        // Cria estrutural da tabela user - responsável pela vinculação dos títulos ao usuário

        createTable = "CREATE TABLE " + tabUser + "("
                + user[0] + " integer primary key autoincrement";
        for( int i = 1; i < (user.length); i ++) {
            createTable = createTable + "," + user[i] + " text ";
        }
        createTable = createTable + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + tabPCap);
        db.execSQL("DROP TABLE IF EXISTS" + tabUser);
        onCreate(db);
        //Implementar método para salvar os dados do usuário
    }




}
