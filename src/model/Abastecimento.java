package model;

import java.math.BigDecimal;

public class Abastecimento {

    private int id;
    private int bombaId;
    private BigDecimal litros;
    private BigDecimal valorTotal;



    // │──────────── CONSTRUTOR ────────────│
    public Abastecimento(int id, int bombaId, BigDecimal litros, BigDecimal valorTotal) {
        this.id = id;
        this.bombaId = bombaId;
        this.litros = litros;
        this.valorTotal = valorTotal;
    }

    // │──────────── GETERRS E SETTERS ────────────│

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBombaId() {
        return bombaId;
    }

    public void setBombaId(int bombaId) {
        this.bombaId = bombaId;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
