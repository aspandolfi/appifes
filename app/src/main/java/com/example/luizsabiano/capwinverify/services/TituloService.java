package com.example.luizsabiano.capwinverify.services;

import com.example.luizsabiano.capwinverify.domain.Titulo;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class TituloService extends Service<Titulo> {
    private final String uri = super.BaseUrl + "titulo/";
    private Request request;
    private Response response;

    public TituloService(OkHttpClient okHttpClient) {
        super(okHttpClient);
    }

    @Override
    public Titulo Add(Titulo obj) {
        return null;
    }

    @Override
    public Titulo Get() {
        return null;
    }

    @Override
    public Titulo GetById(int id) {
        return null;
    }
}
