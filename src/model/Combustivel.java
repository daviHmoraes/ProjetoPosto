package model;

import java.math.BigDecimal;

public class Combustivel {

    private int id;
    private String nome;
    private BigDecimal precoLitro;
    private String descricao;


    // │──────────── CONSTRUTOR PADRAO ────────────│
    public Combustivel() {
    }

    // │──────────── CONSTRUTOR ────────────│
    public Combustivel(int id, String nome, BigDecimal precoLitro, String descricao) {

        this.id = id;
        this.nome = nome;
        this.precoLitro = precoLitro;
        this.descricao = descricao;

    }

    // │──────────── GETERRS E SETTERS ────────────│

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(BigDecimal precoLitro) {
        this.precoLitro = precoLitro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
