package services;

import dao.CombustivelDAO;
import dao.TanqueDAO;
import exceptions.CapacidadeInvalidaAltaException;
import exceptions.CapacidadeInvalidaBaixaException;
import exceptions.CombustivelNaoEncontradoException;
import exceptions.NomeVazioException;
import exceptions.TanqueNaoEncontradoException;
import java.math.BigDecimal;
import java.util.List;
import model.Combustivel;
import model.Tanque;

public class TanqueService {

    private final TanqueDAO tanqueDAO = new TanqueDAO();
    private final CombustivelDAO combustivelDAO = new CombustivelDAO();
    private final BigDecimal CAPACIDADE_MINIMA = new BigDecimal("0.1");
    private final BigDecimal CAPACIDADE_MAXIMA = new BigDecimal("60000.00");

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

    public void atualizarLitros(int id, BigDecimal litros){

        Tanque tanque = tanqueDAO.findById(id);

        if (tanque == null) {
            throw new TanqueNaoEncontradoException(id);
        } 

        

    }
    
}
