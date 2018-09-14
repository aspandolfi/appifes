package com.example.luizsabiano.capwinverify;

import android.app.Application;

import com.example.luizsabiano.capwinverify.domain.DaoMaster;
import com.example.luizsabiano.capwinverify.domain.DaoSession;
import com.example.luizsabiano.capwinverify.services.TituloService;
import com.example.luizsabiano.capwinverify.services.UsuarioService;
import com.squareup.okhttp.OkHttpClient;

import org.greenrobot.greendao.database.Database;

public class App extends Application {

    private OkHttpClient okHttpClient;
    private UsuarioService usuarioService;
    private TituloService tituloService;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        // regular SQLite database
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "postal-db");
        Database db = helper.getWritableDb();

        // encrypted SQLCipher database
        // note: you need to add SQLCipher to your dependencies, check the build.gradle file
        // DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db-encrypted");
        // Database db = helper.getEncryptedWritableDb("encryption-key");

        daoSession = new DaoMaster(db).newSession();

        okHttpClient = new OkHttpClient();
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }

    public UsuarioService getUsuarioService() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService(okHttpClient);
        }
        return usuarioService;
    }

    public TituloService getTituloService() {
        if (tituloService == null) {
            tituloService = new TituloService(okHttpClient);
        }
        return tituloService;
    }
}
