package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.content.Intent;
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


    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_cadastro);
        control = new MainControl(this);

    }
    public void voltar(View v){
        control.voltarAction();
    }

}
