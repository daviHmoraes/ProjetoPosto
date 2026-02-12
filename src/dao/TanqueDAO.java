package dao;

import model.Tanque;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TanqueDAO {

    // │──────────── INSERIR ────────────│
    public Tanque insert(Tanque tanque) {

        String sql = "INSERT INTO tanque (nome, combustivel_id, capacidade_max, litros_atuais) VALUES (?, ?, ?, ?)";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, tanque.getNome());
            ps.setInt(2, tanque.getCombustivelId());
            ps.setBigDecimal(3, tanque.getCapacidadeMax());
            ps.setBigDecimal(4, tanque.getLitrosAtuais());

            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    tanque.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir um novo tanque", e);
        }

        return tanque;

    }

    // │──────────── BUSCAR POR ID ────────────│
    public Tanque findById(int id) {

        String sql = "SELECT * FROM tanque WHERE id = ?";
        Tanque tanque = null;

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    tanque = mapTanque(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tanque por ID", e);
        }

        return tanque;
    }

    // │──────────── LISTA TODOS ────────────│
    public List<Tanque> readAll() {
        String sql = "SELECT * FROM tanque";
        List<Tanque> list = new ArrayList<>();

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                list.add(mapTanque(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os tanques", e);
        }

        return list;

    }

    // │──────────── ATUALIZAR LITROS ATUAIS ────────────│
    public void updateLitrosAtuais(int id, BigDecimal novoLitros) {

        String sql = "UPDATE tanque SET litros_atuais = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBigDecimal(1, novoLitros);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar os litros atuais do tanque", e);
        }

    }

    // │──────────── ATUALIZAR ────────────│
    public void update(Tanque tanque)  {
        String sql = "UPDATE tanque SET nome = ? capacidade_max = ?, litros_atuais = ?, combustivel_id = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tanque.getNome());
            ps.setBigDecimal(2, tanque.getCapacidadeMax());
            ps.setBigDecimal(3, tanque.getLitrosAtuais());
            ps.setInt(4, tanque.getCombustivelId());
            ps.setInt(5, tanque.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o tanque!", e);
        }

    }

    // │──────────── DELETAR POR ID ────────────│
    public void delete(int id) {
        String sql = "DELETE FROM tanque WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar tanque!", e);
        }

    }

    // │──────────── MAPEAR TANQUE ────────────│
    private Tanque mapTanque(ResultSet rs) throws SQLException {
        return new Tanque(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("combustivel_id"),
                rs.getBigDecimal("capacidade_max"),
                rs.getBigDecimal("litros_atuais")
        );
    }

}
