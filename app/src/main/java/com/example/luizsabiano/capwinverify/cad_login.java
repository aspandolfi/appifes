package com.example.luizsabiano.capwinverify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luizsabiano.capwinverify.domain.DaoSession;
import com.example.luizsabiano.capwinverify.domain.Usuario;
import com.example.luizsabiano.capwinverify.domain.UsuarioDao;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class cad_login extends AppCompatActivity {
    private TextView texto;

    //criando os objetos
    EditText editUserName;
    EditText editCpf;
    EditText editCelPhone;
    EditText editEmail;
    EditText editPasswd;
    EditText editPasswd2;
    Button btnAddUser;
    BancoController db;

    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_login);

        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        usuarioDao = daoSession.getUsuarioDao();

        //vinculando objetos aos IDs
        editCpf = (EditText) findViewById(R.id.editCpf);
        editCelPhone = (EditText) findViewById(R.id.editCelPhone);
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPasswd = (EditText) findViewById(R.id.editPasswd);
        editPasswd2 = (EditText) findViewById(R.id.editPasswd2);
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnAddUser = (Button) findViewById(R.id.btnAddUser);

        // máscara Cpf
        SimpleMaskFormatter cpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(editCpf,cpf);
        editCpf.addTextChangedListener(mtw);
        // Fim máscara

        // máscara Celular
        SimpleMaskFormatter cel = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher celw = new MaskTextWatcher(editCelPhone,cel);
        editCelPhone.addTextChangedListener(celw);
        // Fim Celular

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ( editPasswd.getText().length() ==0 || editPasswd2.getText().length()==0
                        || editCpf.getText().length()==0 || editCelPhone.getText().length() ==0
                        || editUserName.getText().length() ==0 || editEmail.getText().length() == 0 ){
                    Toast.makeText(getApplication(),
                            "Todos os campos são obrigatórios",
                            Toast.LENGTH_LONG).show();
                } else {
                    if ( !editPasswd.getText().toString().equals(editPasswd2.getText().toString()  ) ){
                        Toast.makeText(getApplication(),
                                "As duas senhas digitadas devem ser iguais",
                                Toast.LENGTH_LONG).show();
                    } else {
                        // procedimento para verificação do cpf
                        // procedimento para conferir se o cel tem no mínimo 10 numeros
                        // caso tudo esteja ok cadastrar no banco de dados]
                        // implementar metodo para verificar se cpf ja esta cadastrado (alguns usuários tipo esposa e esposa só possuem um celular)
                        String resultado;
                        db = new BancoController(getBaseContext());
                        resultado = db.addUser(new User(
                                editUserName.getText().toString(),
                                editCpf.getText().toString(),
                                editCelPhone.getText().toString(),
                                editEmail.getText().toString(),
                                editPasswd.getText().toString()));

                        Usuario usuario = new Usuario(
                                0L,
                                editUserName.getText().toString(),
                                editEmail.getText().toString(),
                                editPasswd.getText().toString(),
                                editCpf.getText().toString());

                        usuarioDao.insert(usuario);

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



     /* Recebendo parametros de uma activity
        Intent it = getIntent();
        if (it != null) {
            String showLogin = it.getStringExtra("Login");
            String showSenha = it.getStringExtra("Senha");
            //int age = intent.getIntExtra("Senha", 0);
            this.texto = (TextView) findViewById(R.id.showLogin);
            this.texto.setText("TestPassParam: " + showLogin);
        } */
    }

}
