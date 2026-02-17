package services;

import dao.CombustivelDAO;
import dao.TanqueDAO;
import exceptions.CombustivelNaoEncontradoException;
import exceptions.IdentificacaoNulaException;
import exceptions.TanqueNaoEncontradoException;
import model.Bomba;
import model.Combustivel;
import model.StatusBomba;
import model.Tanque;


public class BombaService {

    private final TanqueDAO tanqueDAO = new TanqueDAO();
    private final CombustivelDAO combustivelDAO = new CombustivelDAO();

    public Bomba inserirBomba(String identificacao, int combustivelId, int tanqueId, StatusBomba status) {

     Combustivel combustivel = combustivelDAO.findById(combustivelId);
     if (combustivel == null) {
         throw new CombustivelNaoEncontradoException(combustivelId);
     }

     Tanque tanque = tanqueDAO.findById(tanqueId);
     if (tanque == null) {
         throw new TanqueNaoEncontradoException(tanqueId);
     }

     if (identificacao.isBlank()) {
         throw new IdentificacaoNulaException();
     }

     

    }

}
