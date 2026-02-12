package model;

public class Bomba {

    private int id;
    private String identificacao;
    private int combustivelId;
    private int tanqueId;
    private StatusBomba status;

    // │──────────── CONSTRUTOR ────────────│
    public Bomba(int id, String identificacao, int combustivelId, int tanqueId, StatusBomba status) {
        this.id = id;
        this.identificacao = identificacao;
        this.combustivelId = combustivelId;
        this.tanqueId = tanqueId;
        this.status = status;
    }

    // │──────────── GETERRS E SETTERS ────────────│

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getCombustivelId() {
        return combustivelId;
    }

    public void setCombustivelId(int combustivelId) {
        this.combustivelId = combustivelId;
    }

    public int getTanqueId() {
        return tanqueId;
    }

    public void setTanqueId(int tanqueId) {
        this.tanqueId = tanqueId;
    }

    public StatusBomba getStatus() {
        return status;
    }

    public void setStatus(StatusBomba status) {
        this.status = status;
    }
}
