package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.ArmamentoControl;

public class ArmamentoActivity extends Activity {
    private ArmamentoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armamento);

        control = new ArmamentoControl(this);

    }

    public void chamaTelaCadArma(View v){
        control.chamaTelaCadArmaAction();
    }

    public void chamaTelaPesqArma(View v){
        control.chamaTelaPesqArmaAction();
    }

    public void voltar(View v){
        control.voltarAction();
    }
}