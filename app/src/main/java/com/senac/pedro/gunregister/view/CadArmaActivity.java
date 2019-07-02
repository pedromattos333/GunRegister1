package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.ArmamentoControl;

public class CadArmaActivity extends AppCompatActivity {
    private ArmamentoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_arm);

        control = new ArmamentoControl(this);
    }
        public void cadastrar(View v){
            control.cadastrarAction();
        }

        public void cancelar(View v){
            control.cancelarAction();
        }

        public void voltar(View v){
            control.voltarAction();
        }
    }
