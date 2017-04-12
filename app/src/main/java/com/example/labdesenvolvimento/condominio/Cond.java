package com.example.labdesenvolvimento.condominio;


public class Cond {
    private long ID;
    private String nome;
    private int apartamento;
    private String bloco;


    public Cond() {
    }

    public Cond(long ID, String nome, int apartamento, String bloco) {
        this.ID = ID;
        this.nome = nome;
        this.apartamento = apartamento;
        this.bloco = bloco;

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
}