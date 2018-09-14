package com.example.luizsabiano.capwinverify.services;

import com.example.luizsabiano.capwinverify.authorization.UsuarioAutenticado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.framed.Header;

import java.io.IOException;

public abstract class Service<T extends Object> {
    protected OkHttpClient Client;
    protected final String BaseUrl = "localhost:/api/";
    protected static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    protected static final Header JSONHEADER = new Header("Content-Type", "application/json; charset=utf-8");
    protected static final Header AUTHORIZATIONHEADER = new Header("Authorization", UsuarioAutenticado.Token);

    private static final String[] DEFAULTHEADERS = {"Authorization", UsuarioAutenticado.Token, "Content-Type", "application/json; charset=utf-8"};

    public Service(OkHttpClient okHttpClient) {
        this.Client = okHttpClient;
    }

    protected String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    protected T fromJson(String json) {
        return new Gson().fromJson(json, new TypeToken<T>() {
        }.getType());
    }

    protected Headers getDefaultHeaders() {
        return Headers.of(DEFAULTHEADERS);
    }

    public abstract T Add(T obj);

    public abstract T Get();

    public abstract T GetById(int id);
}
