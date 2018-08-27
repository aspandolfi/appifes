package com.example.luizsabiano.capwinverify;

public class User {
    public int id;
    public String userName;
    public String cpf;
    public String celPhone;
    public String email;
    public String passwd;

    // Construtor para autenticação

    public User(String cpf, String passwd) {
        this.cpf = cpf;
        this.passwd = passwd;
    }

    // Construtor sem Id

    public User( String userName,  String cpf,  String celPhone, String email, String passwd) {
        this.id = id;
        this.userName = userName;
        this.cpf = cpf;
        this.celPhone = celPhone;
        this.email = email;
        this.passwd = passwd;
    }

    // Construtor com todos os parametros

    public User(int id, String userName,  String cpf,  String celPhone, String email, String passwd) {
        this.id = id;
        this.userName = userName;
        this.cpf = cpf;
        this.celPhone = celPhone;
        this.email = email;
        this.passwd = passwd;
    }

    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }
    //getting name
    public String getUserName() {
        return userName;
    }
    //setting name
    public void setUserName(String name) {
        this.userName = name;
    }
    //getting cpf
    public String getCpf() {
        return cpf;
    }
    //setting cpf
    public void setCpf(String name) {
        this.cpf = cpf;
    }
    //getting celPhone
    public String getCelPhone() {
        return celPhone;
    }
    //setting celPhone
    public void setCelPhone(String name) {
        this.celPhone = celPhone;
    }
    //getting email
    public String getEmail() {
        return email;
    }
    //setting email
    public void setEmail(String name) {
        this.email = email;
    }
    //getting password
    public String getPasswd() {
        return passwd;
    }
    //setting password
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
