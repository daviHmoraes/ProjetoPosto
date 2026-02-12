import dao.Conexao;

import util.ConfigReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection conn = Conexao.getConnection();

        String mysql = "INSERT INTO combustivel (nome, preco_litro, descricao) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, "Gasolina");
            ps.setDouble(2, 5.4);
            ps.setString(3, "Gasolina é um combustível líquido derivado do petróleo");
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // TESTAR O INSERT PARA VER COMO ESTÁ O DATABASE
        }
    }
}
