package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.dao.ArmamentoDao;
import com.senac.pedro.gunregister.model.Armamento;
import com.senac.pedro.gunregister.view.CadArmaActivity;
import com.senac.pedro.gunregister.view.PesqArmaActivity;
import java.util.Collections;

import java.sql.SQLException;




public class ArmamentoControl {
    private Activity activity;
    private EditText editNome;
    private EditText editTipo;
    private EditText editMarca;
    private EditText editCalibre;
    private ArrayAdapter<Armamento> adapterArma;
    private ListView lvArmamento;

    private Armamento armamento = null;
    private ArmamentoDao armamentoDao;

    public ArmamentoControl(Activity activity) {
        this.activity = activity;
        armamentoDao = new ArmamentoDao(this.activity);
        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editTipo = activity.findViewById(R.id.editTipo);
        editMarca = activity.findViewById(R.id.editMarca);
        editCalibre = activity.findViewById(R.id.editCalibre);

    }

    public void chamaTelaCadArmaAction() {
        Intent it = new Intent(activity, CadArmaActivity.class);
        activity.startActivity(it);
    }

    public void chamaTelaPesqArmaAction() {
        Intent it = new Intent(activity, PesqArmaActivity.class);
        activity.startActivity(it);
    }

    public void voltarAction() {
        activity.finish();
    }

    public void cadastrarAction() {
        if (armamento == null) {
            armamento = new Armamento();
        }
        armamento.setNome(editNome.getText().toString());
        armamento.setTipo(editTipo.getText().toString());
        armamento.setMarca(editMarca.getText().toString());
        armamento.setCalibre(editCalibre.getText().toString());

        if (armamento.getNome().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_nome, Toast.LENGTH_LONG).show();
            editNome.requestFocus();
            return;
        } else if (armamento.getTipo().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_tipo, Toast.LENGTH_LONG).show();
            editTipo.requestFocus();
            return;
        } else if (armamento.getMarca().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_marca, Toast.LENGTH_LONG).show();
            editMarca.requestFocus();
            return;
        } else if (armamento.getCalibre().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_calibre, Toast.LENGTH_LONG).show();
            editCalibre.requestFocus();
            return;
        }

            try {
                Dao.CreateOrUpdateStatus res = armamentoDao.getDao().createOrUpdate(armamento);
                if (res.isCreated()) {
                    Toast.makeText(activity, R.string.cad_sucesso, Toast.LENGTH_LONG).show();
                } else if (res.isUpdated()) {
                    Toast.makeText(activity, R.string.edit_sucesso, Toast.LENGTH_SHORT).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            armamento = null;
        }

     public void cancelarAction(){
        activity.finish();
    }

    private void cliqueCurto(){
        lvArmamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                armamento = adapterArma.getItem(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setTitle("Visualizando armas");
                alerta.setMessage(armamento.toString());
                alerta.setNeutralButton("Fechar", null);
                alerta.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editNome.setText(armamento.getNome());
                        editTipo.setText(armamento.getTipo());
                        editMarca.setText(armamento.getMarca());
                        editCalibre.setText(armamento.getCalibre());
                    }
                });
                alerta.show();
            }
        });
    }

    private void cliqueLongo(){
        lvArmamento.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                armamento = adapterArma.getItem(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setTitle("Excluindo armamento");
                alerta.setMessage("Tem certeza que deseja excluir " + armamento.getNome()+"?");
                alerta.setIcon(android.R.drawable.ic_menu_delete);
                alerta.setNeutralButton("Não", null);
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            armamentoDao.getDao().delete(armamento);
                            adapterArma.remove(armamento);
                            armamento = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                alerta.show();
                return true;
            }
        });
    }


        public void pesquisarAction(){
            montarListView();
        }



    private void montarListView() {
        try {
            adapterArma = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_list_item_1,
                    armamentoDao.getDao().queryForAll()
            );
            lvArmamento.setAdapter(adapterArma);
            cliqueCurto();
            cliqueLongo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }




