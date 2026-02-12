package dao;

import util.ConfigReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection() {

        try { // Tenta conectar ao DB

            String url = ConfigReader.get("db.url");
            String user = ConfigReader.get("db.user");
            String password = ConfigReader.get("db.password");

           return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new RuntimeException("Falha ao se conectar ao DB!", e);
        }

    }

}
