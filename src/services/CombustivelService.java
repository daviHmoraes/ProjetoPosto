package services;

import dao.CombustivelDAO;
import exceptions.CombustivelNaoEncontradoException;
import exceptions.PrecoCombustivelAltoException;
import exceptions.PrecoCombustivelBaixoException;
import model.Combustivel;

import java.math.BigDecimal;
import java.util.List;

public class CombustivelService {

    private final BigDecimal PRECO_MINIMO = new BigDecimal("0.1");
    private final BigDecimal PRECO_MAXIMO = new BigDecimal("100.00");

    private final CombustivelDAO combustivelDAO = new CombustivelDAO();

    public Combustivel cadastrarCombustivel(String nome, BigDecimal precoVenda, String descricao) {

        if (precoVenda.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PrecoCombustivelBaixoException(precoVenda);
        }

        if (precoVenda.compareTo(new BigDecimal("100")) >= 0) {
            throw new PrecoCombustivelAltoException(precoVenda);
        }

        Combustivel combustivel = new Combustivel();

        combustivel.setNome(nome);
        combustivel.setPrecoLitro(precoVenda);
        combustivel.setDescricao(descricao);

        return combustivelDAO.insert(combustivel);

    }

    public List<Combustivel> listarTodos() {
        return combustivelDAO.readAll();
    }

    public void atualizarPreco(int id, BigDecimal novoPreco) {

        Combustivel combustivel = combustivelDAO.findById(id);

        if (combustivel == null) {
            throw new CombustivelNaoEncontradoException(id);
        }

        if (novoPreco.compareTo(PRECO_MINIMO) < 0) {
            throw new PrecoCombustivelBaixoException(novoPreco);
        }

        if (novoPreco.compareTo(PRECO_MAXIMO) > 0) {
            throw new PrecoCombustivelAltoException(novoPreco);
        }

        combustivelDAO.updatePreco(id, novoPreco);

    }

    public void deletarCombustivel(int id) {

        Combustivel combustivel = combustivelDAO.findById(id);

        if (combustivel == null) {
            throw new CombustivelNaoEncontradoException(id);
        }

        combustivelDAO.delete(id);

    }

}
