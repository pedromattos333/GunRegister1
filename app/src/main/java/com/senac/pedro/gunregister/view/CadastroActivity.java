package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.MainControl;


public class CadastroActivity  extends Activity  {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Button   btnRegistrar;
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_cadastro);
        etNome = (EditText) findViewById(R.id.et_nome);
        etEmail = (EditText) findViewById(R.id.et_email);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        control = new MainControl(this);


    }
    public void voltar(View v){
        control.voltarAction();
    }

}
