package dao;

import model.Combustivel;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CombustivelDAO {

    // │──────────── INSERIR ────────────│
    public Combustivel insert(Combustivel combustivel) {
        String sql = "INSERT INTO combustivel (nome, preco_litro, descricao) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, combustivel.getNome());
            ps.setBigDecimal(2, combustivel.getPrecoLitro());
            ps.setString(3, combustivel.getDescricao());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    combustivel.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir novo Combustível!", e);
        }

        return combustivel;

    }

    // │──────────── BUSCAR POR ID ────────────│
    public Combustivel findById(int id) {
        String sql = "SELECT * FROM combustivel WHERE id = ?";
        Combustivel combustivel = null;

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    combustivel = mapCombustivel(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Combutível!",e);
        }

        return combustivel;
    }

    // │──────────── LISTAR TODOS ────────────│
    public List<Combustivel> readAll() {
        String sql = "SELECT * FROM combustivel";
        List<Combustivel> list = new ArrayList<>();

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapCombustivel(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos Combustíveis", e);
        }

        return list;

    }

    // │──────────── ATUALIZAR PRECO ────────────│
    public void updatePreco(int id, BigDecimal novoPreco) {

        String sql = "UPDATE combustivel SET preco_litro = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBigDecimal(1, novoPreco);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch(SQLException e) {
            throw new RuntimeException("Erro ao atualizar o preço do combustível", e);
        }

    }

    // │──────────── ATUALIZAR ────────────│
    public void update(Combustivel combustivel) {
        String sql = "UPDATE combustivel SET nome = ?, preco_litro = ?, descricao = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, combustivel.getNome());
            ps.setBigDecimal(2, combustivel.getPrecoLitro());
            ps.setString(3, combustivel.getDescricao());
            ps.setInt(4, combustivel.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Combustível",e);
        }

    }

    // │──────────── DELETAR POR ID ────────────│
    public void delete(int id) {
        String sql = "DELETE FROM combustivel WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Combustível", e);
        }

    }

    // │──────────── MAPEAR COMBUSTIVEL ────────────│
    private Combustivel mapCombustivel(ResultSet rs) throws SQLException {
        return new Combustivel(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getBigDecimal("preco_litro"),
            rs.getString("descricao")
        );
    }

}