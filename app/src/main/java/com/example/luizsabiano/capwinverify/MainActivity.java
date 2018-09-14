package com.example.luizsabiano.capwinverify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luizsabiano.capwinverify.authorization.UsuarioAutenticado;
import com.example.luizsabiano.capwinverify.services.UsuarioService;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity {

    //criando os objetos
    EditText editLogin;
    EditText editPassLogin;
    Button btnAcessar;
    Button btnCadUser;
    BancoController db;
    UsuarioService usuarioService;

    private UsuarioService getUsuarioService() {
        return ((App) getApplication()).getUsuarioService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculando objetos aos IDs
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassLogin = (EditText) findViewById(R.id.editPassLogin);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        btnCadUser = (Button) findViewById(R.id.btnCadUser);

        //    Agora você pode colocar uma ação de chamar outra tela nele através do nome que você criou, dessa forma:

        btnCadUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it;
                it = new Intent(MainActivity.this, cad_login.class);
                startActivity(it);
            }
        });


        // máscara Cpf
        SimpleMaskFormatter cpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(editLogin, cpf);
        editLogin.addTextChangedListener(mtw);
        // Fim máscara

        //Programando o botão Acessar

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editLogin.getText().length() == 0 || editPassLogin.getText().length() == 0) {
                    Toast.makeText(getApplication(),
                            "Os campos Login e Senha são obrigatórios",
                            Toast.LENGTH_LONG).show();
                } else {

                    String token = getUsuarioService().Authenticate(editLogin.getText().toString(), editPassLogin.getText().toString());

                    if (token != null) {
                        UsuarioAutenticado.Token = token;
                    }

//                    db = new BancoController(getBaseContext());
//                    int id = db.checkUser(new User(editLogin.getText().toString(), editPassLogin.getText().toString()));
//
//
//                    if (id == -1) {
//                        Toast.makeText(getApplication(),
//                                "Usuario não existe",
//                                Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getApplication(),
//                                "Usuário: " + editLogin.getText().toString() + " Logou com sucesso",
//                                Toast.LENGTH_LONG).show();
//                    }
/*

                    //-------------------
                    Intent it = new Intent(MainActivity.this, cad_login.class);
                    Bundle parametros = new Bundle();
                    parametros.putString("Login", editLogin.getText().toString());
                    parametros.putString("Senha", editPassLogin.getText().toString());
                    it.putExtras(parametros);
                  //  startActivity(it);

                */
                }
            }
        });
    }
}