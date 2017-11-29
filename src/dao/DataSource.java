package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    private Connection connection;

    public DataSource() {
        try {
            hostname = "localhost";
            port = 3306;
            database = "cruddb";
            username = "root";
            password = "";

            String url = "jdbc:mysql://"+hostname+":"+ port +"/"+database;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            connection = (Connection) DriverManager.getConnection(url, username, password);

            System.out.println("Deu tudo certo, Palmas para o JC!");

        } catch (SQLException ex) {
            System.out.println("Erro de conexão: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro geral: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }
}
