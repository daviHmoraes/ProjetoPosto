package services;

import dao.CombustivelDAO;
import dao.TanqueDAO;
import exceptions.*;

import java.math.BigDecimal;
import java.util.List;
import model.Combustivel;
import model.Tanque;

public class TanqueService {

    private final TanqueDAO tanqueDAO = new TanqueDAO();
    private final CombustivelDAO combustivelDAO = new CombustivelDAO();
    private final BigDecimal CAPACIDADE_MINIMA = new BigDecimal("0.1");
    private final BigDecimal CAPACIDADE_MAXIMA = new BigDecimal("60000.00");

    private void validarNomeNulo(String nome) {
        if (nome == null) {
            throw new NomeNuloException();
        }
    }

    public Tanque inserirTanque(String nome, BigDecimal capacidadeMax, int combustivelId) {

        Combustivel combustivel = combustivelDAO.findById(combustivelId);
        if (combustivel == null) {
            throw new CombustivelNaoEncontradoException(combustivelId);
        }

        if (capacidadeMax.compareTo(CAPACIDADE_MINIMA) < 0) {
            throw new CapacidadeInvalidaBaixaException(capacidadeMax);
        }

        if (capacidadeMax.compareTo(CAPACIDADE_MAXIMA) > 0) {
            throw new CapacidadeInvalidaAltaException(capacidadeMax);
        }

        if (nome.isBlank()) {
            throw new NomeVazioException(nome);
        }

        Tanque tanque = new Tanque();

        tanque.setNome(nome);
        tanque.setCapacidadeMax(capacidadeMax);
        tanque.setCombustivelId(combustivelId);

        return tanqueDAO.insert(tanque);

    }

    public List<Tanque> listarTodos() {
        return tanqueDAO.readAll();
    }

    public void debitarLitros(int id, BigDecimal litros){

        if (litros.compareTo(BigDecimal.ZERO) <= 0) {
            throw new QuantidadeLitrosInvalidaException(litros);
        }

        Tanque tanque = tanqueDAO.findById(id);

        if (tanque == null) {
            throw new TanqueNaoEncontradoException(id);
        }

        BigDecimal novoLitrosAtuais = tanque.getLitrosAtuais().subtract(litros);

        if (novoLitrosAtuais.compareTo(BigDecimal.ZERO) < 0) {
            throw new CombustivelInsuficienteException(litros);
        }

        tanqueDAO.updateLitrosAtuais(id, novoLitrosAtuais);

    }

    public void creditarLitros(int id, BigDecimal litros) {

        if (litros.compareTo(BigDecimal.ZERO) <= 0) {
            throw new QuantidadeLitrosInvalidaException(litros);
        }

        Tanque tanque = tanqueDAO.findById(id);

        if (tanque == null) {
            throw new TanqueNaoEncontradoException(id);
        }

        BigDecimal novoLitrosAtuais = tanque.getLitrosAtuais().add(litros);

        if (novoLitrosAtuais.compareTo(tanque.getCapacidadeMax()) > 0) {
            throw new CapacidadeInvalidaAltaException(tanque.getCapacidadeMax());
        }

        tanqueDAO.updateLitrosAtuais(id, novoLitrosAtuais);

    }

    public void deletarTanque(int id) {

        Tanque tanque = tanqueDAO.findById(id);

        if (tanque == null) {
            throw new TanqueNaoEncontradoException(id);
        }

        tanqueDAO.delete(id);

    }

}
