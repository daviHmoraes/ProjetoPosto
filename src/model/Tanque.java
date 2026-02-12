package model;

import java.math.BigDecimal;

public class Tanque {

    private int id;
    private String nome;
    private BigDecimal capacidadeMax;
    private BigDecimal litrosAtuais = BigDecimal.ZERO;
    private int combustivelId;

    // │──────────── CONSTRUTOR PADRAO ────────────│
    public Tanque() {
    }

    // │──────────── CONSTRUTOR ────────────│
    public Tanque(int id, String nome, int combustivelId, BigDecimal capacidadeMax, BigDecimal litrosAtuais) {
        this.id = id;
        this.nome = nome;
        this.combustivelId = combustivelId;
        this.capacidadeMax = capacidadeMax;
    }

    // │──────────── GETTERS E SETTERS ────────────│


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(BigDecimal capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public BigDecimal getLitrosAtuais() {
        return litrosAtuais;
    }

    public void setLitrosAtuais(BigDecimal litrosAtuais) {
        this.litrosAtuais = litrosAtuais;
    }

    public int getCombustivelId() {
        return combustivelId;
    }

    public void setCombustivelId(int combustivelId) {
        this.combustivelId = combustivelId;
    }
}
