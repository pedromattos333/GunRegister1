package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


import com.senac.pedro.gunregister.view.ArmamentoActivity;
import com.senac.pedro.gunregister.view.CadastroActivity;
import com.senac.pedro.gunregister.view.MainActivity;

public class MainControl {
    private Activity activity;
    private EditText editLogin;
    private EditText editSenha;

    public MainControl(Activity activity) {
        this.activity = activity;
    }

    public void entrarAction(){
        Intent it = new Intent(activity, ArmamentoActivity.class);
        activity.startActivity(it);
    }

    public void registrarAction(){
        Intent it = new Intent(activity, CadastroActivity.class);
        activity.startActivity(it);
    }
    public void voltarAction() {
        Intent it = new Intent(activity, MainActivity.class);
        activity.startActivity(it);
    }

    public void sairAction() {
    }
}
