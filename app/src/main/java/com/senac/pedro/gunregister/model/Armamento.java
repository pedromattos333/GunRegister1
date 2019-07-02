package com.senac.pedro.gunregister.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "armamento")
public class Armamento implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;
    @DatabaseField(columnName = "nome",canBeNull = false, width = 50)
    private String nome;
    @DatabaseField(columnName = "tipo", canBeNull = false)
    private String tipo;
    @DatabaseField(columnName = "marca", canBeNull = false)
    private String marca;
    @DatabaseField(columnName = "calibre", canBeNull = false)
    private String calibre;


    public Armamento(){

    }
    public Armamento(Integer id, String nome, String tipo, String marca, String calibre){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.calibre = calibre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return " - " + nome + " - " + tipo + " - " + marca + " - " + calibre; }


    }

