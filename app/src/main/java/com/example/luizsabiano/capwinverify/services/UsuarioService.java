package com.example.luizsabiano.capwinverify.services;

import com.example.luizsabiano.capwinverify.viewmodels.UsuarioViewModel;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class UsuarioService extends Service<UsuarioViewModel> {

    private String uri = super.BaseUrl + "account/";
    private Request request;
    private Response response;

    public UsuarioService(OkHttpClient okHttpClient) {
        super(okHttpClient);
    }

    public String Authenticate(String email, String password) {
        Login login = new Login(email, password);

        RequestBody requestBody = RequestBody.create(super.JSON, toJson(login));
        request = new Request.Builder()
                .url(this.uri)
                .post(requestBody)
                .build();
        try {
            response = super.Client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {

        }
        return "";
    }

    @Override
    public UsuarioViewModel GetById(int id) {
        return null;
    }

    @Override
    public UsuarioViewModel Add(UsuarioViewModel obj) {
        RequestBody requestBody = RequestBody.create(super.JSON, toJson(obj));

        request = new Request.Builder()
                .url(this.uri)
                .post(requestBody)
                .build();
        try {
            response = super.Client.newCall(request).execute();
            return super.fromJson(response.body().string());
        } catch (IOException e) {

        }
        return null;
    }

    @Override
    public UsuarioViewModel Get() {
        Request request = new Request.Builder()
                .headers(super.getDefaultHeaders())
                .url(this.uri)
                .build();
        try {
            response = super.Client.newCall(request).execute();
            return super.fromJson(response.body().string());
        } catch (IOException e) {

        }
        return null;
    }

    class Login {
        private String username;
        private String password;

        public Login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
