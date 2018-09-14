package com.example.luizsabiano.capwinverify.viewmodels;

public class UsuarioViewModel {
    public String Name;
    public String Cpf;
    public String Email;
    public String PasswordConfirmation;

    public UsuarioViewModel(String name, String cpf, String email, String passwordConfirmation) {
        Name = name;
        Cpf = cpf;
        Email = email;
        PasswordConfirmation = passwordConfirmation;
    }
}
