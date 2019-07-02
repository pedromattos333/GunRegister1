package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    private EditText editLogin;
    private EditText editSenha;
    private Button   btEntrar;
    private Button   btEsqueci;
    private TextView Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = (EditText)findViewById(R.id.editLogin);
        editSenha = (EditText)findViewById(R.id.editSenha);
        btEntrar  = (Button) findViewById(R.id.btEntrar);
        Registrar = (TextView)findViewById(R.id.Registrar);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegistroIntent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(RegistroIntent);
            }
        });



        control = new MainControl(this);
    }

    public void entrar(View v){control.entrarAction();}

    public void registrar(View v){control.registrarAction();}



}
