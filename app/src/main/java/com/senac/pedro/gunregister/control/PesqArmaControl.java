package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.dao.ArmamentoDao;
import com.senac.pedro.gunregister.model.Armamento;


import java.sql.SQLException;

public class PesqArmaControl {
    private Activity activity;
    private ListView lvArmamento;
    private EditText editNome;
    private EditText editTipo;
    private EditText editMarca;
    private EditText editCalibre;
    private ArrayAdapter<Armamento> adapterArma;
    private Armamento armamento;
    private ArmamentoDao armamentoDao;


    public PesqArmaControl(Activity activity) {
        this.activity = activity;
        armamentoDao = new ArmamentoDao(this.activity);
        initComponents();
        configurarListView();
    }
    private void configurarListView(){
        montarListView();
        cliqueCurto();
        cliqueLongo();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editTipo = activity.findViewById(R.id.editTipo);
        editMarca = activity.findViewById(R.id.editMarca);
        editCalibre = activity.findViewById(R.id.editCalibre);
        lvArmamento = activity.findViewById(R.id.lvArmamento);


    }
    private void cliqueLongo(){
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

    public void voltarAction() {
        activity.finish();
    }

    private void cliqueCurto(){
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



