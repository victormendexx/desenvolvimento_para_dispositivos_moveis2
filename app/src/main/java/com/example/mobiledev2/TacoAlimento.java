package com.example.mobiledev2;

public class TacoAlimento {
    private String nome;
    private float caloria;

    public TacoAlimento(String nome, float caloria) {
        this.nome = nome;
        this.caloria = caloria;
    }

    public String getNome() {
        return nome;
    }

    public float getCaloria() {
        return caloria;
    }
}
