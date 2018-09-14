package com.example.luizsabiano.capwinverify.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.*;

@Entity
public class Usuario {

    @Id(autoincrement =  true)
    private Long id;

    @Property
    private String name;

    @Property
    private String email;

    @Property
    private String password;

    @Property
    private String cpf;

    @Property
    private String token;

    @Generated(hash = 805853993)
    public Usuario(Long id, String name, String email, String password, String cpf,
            String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.token = token;
    }

    @Generated(hash = 562950751)
    public Usuario() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
