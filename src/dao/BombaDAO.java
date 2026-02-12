package dao;

import model.Bomba;
import model.StatusBomba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombaDAO {

    // │──────────── INSERIR ────────────│
    public void insert(Bomba bomba) {

        String sql = "INSERT INTO bomba (identificacao, combustivel_id, tanque_id, status) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bomba.getIdentificacao());
            ps.setInt(2, bomba.getCombustivelId());
            ps.setInt(3, bomba.getTanqueId());
            ps.setString(4, bomba.getStatus().name());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir nova bomba!", e);
        }
    }

    // │──────────── BUSCAR POR ID ────────────│
    public Bomba readId(int id) {
        String sql = "SELECT * FROM bomba WHERE id = ?";
        Bomba bomba = null;

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    bomba = mapBomba(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar bomba", e);
        }

        return bomba;

    }

    // │──────────── LISTAR TODOS ────────────│
    public List<Bomba> readAll(){

        String sql = "SELECT * FROM bomba";
        List<Bomba> list = new ArrayList<>();

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapBomba(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todas bombas", e);
        }

        return list;

    }

    // │──────────── ATUALIZAR STATUS ────────────│
    public void updateStatus(int id, StatusBomba novoStatus) {
        String sql = "UPDATE bomba SET status = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, novoStatus.name());
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Status da bomba", e);
        }

    }

    // │──────────── ATUALIZAR ────────────│
    public void update(Bomba bomba) {
        String sql = "UPDATE bomba SET identificacao = ?, combustivel_id = ?, tanque_id = ?, status = ? WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bomba.getIdentificacao());
            ps.setInt(2, bomba.getCombustivelId());
            ps.setInt(3, bomba.getTanqueId());
            ps.setString(4, bomba.getStatus().name());
            ps.setInt(5, bomba.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Bomba", e);
        }

    }

    // │──────────── DELETAR POR ID ────────────│
    public void delete(int id) {
        String sql = "DELETE FROM bomba WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar bomba", e);
        }

    }


    // │──────────── MAPEAR BOMBA ────────────│
    private Bomba mapBomba(ResultSet rs) throws SQLException {
        return new Bomba(
                rs.getInt("id"),
                rs.getString("identificacao"),
                rs.getInt("combustivel_id"),
                rs.getInt("tanque_id"),
                StatusBomba.valueOf(rs.getString("status"))
        );
    }

}
