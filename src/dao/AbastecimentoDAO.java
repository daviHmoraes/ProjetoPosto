package dao;

import model.Abastecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDAO {

    // │──────────── INSERIR ────────────│
    public void insert(Abastecimento abastecimento) {
        String sql = "INSERT INTO abastecimento (bomba_id, litros, valor_total) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, abastecimento.getBombaId());
            ps.setBigDecimal(2, abastecimento.getLitros());
            ps.setBigDecimal(3, abastecimento.getValorTotal());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir novo abastecimento", e);
        }

    }

    // │──────────── BUSCAR POR ID ────────────│
    public Abastecimento readId(int id) {
        String sql = "SELECT * FROM abastecimento WHERE id = ?";
        Abastecimento abastecimento = null;

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    abastecimento = mapAbastecimento(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar abastecimento");
        }

        return abastecimento;

    }

    // │──────────── LISTAR TODOS ────────────│
    public List<Abastecimento> readAll() {
        String sql = "SELECT * FROM abastecimento";
        List<Abastecimento> list = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapAbastecimento(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os abastecimentos");
        }

        return list;

    }

    // │──────────── MAPEAR ABASTECIMENTO ────────────│
    public Abastecimento mapAbastecimento(ResultSet rs) throws SQLException {
        return new Abastecimento(
                rs.getInt("id"),
                rs.getInt("bomba_id"),
                rs.getBigDecimal("litros"),
                rs.getBigDecimal("valor_total")
        );
    }

}

