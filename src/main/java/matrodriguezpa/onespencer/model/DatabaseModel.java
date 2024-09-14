package matrodriguezpa.onespencer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseModel {

    private final String url = "jdbc:sqlite:src/main/resources/baseDatos.db";
    private Connection connect;

    public Connection connect() throws SQLException {
        connect = DriverManager.getConnection(url);
        return connect;
    }

    public void close() throws SQLException {
        if (connect != null && !connect.isClosed()) {
            connect.close();
        }
    }

    public void executeUpdate(String sql) throws SQLException {
        PreparedStatement stmt = connect.prepareStatement(sql);
        stmt.execute();
    }

    public ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = connect().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }
}
