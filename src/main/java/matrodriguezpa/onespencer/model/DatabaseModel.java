package matrodriguezpa.onespencer.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseModel {

    // Construct the URL to the SQLite database in the user's Documents directory
    private final String url = constructDatabaseUrl();
    private Connection connect;

    // Method to construct the database URL
    private static String constructDatabaseUrl() {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");
        // Construct the path to the Documents directory
        Path documentsPath = Paths.get(userHome, "Documents", "baseDatos.db");

        // Check if the path exists (optional)
        if (!documentsPath.toFile().exists()) {
            // Create the database file if it doesn't exist
            try {
                documentsPath.toFile().getParentFile().mkdirs(); // Ensure parent directories exist
                documentsPath.toFile().createNewFile(); // Create the database file
            } catch (IOException e) {
                System.out.println(e); // Handle exceptions
            }
        }

        // Return the database connection URL
        return "jdbc:sqlite:" + documentsPath.toString();
    }

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

    public void executeUpdate2(String sql, String usuario, String nombreProyecto) throws SQLException {
        PreparedStatement stmt = connect.prepareStatement(sql); // Establecer los valores para el usuario y el nombre del proyecto
        stmt.setString(1, usuario);
        stmt.setString(2, nombreProyecto);
        stmt.executeUpdate(); // Ejecutar la inserción
    }

    public void executeUpdate3(String sql, String presupuesto) throws SQLException {
        PreparedStatement stmt = connect.prepareStatement(sql); // Establecer los valores para el usuario y el nombre del proyecto
        stmt.setString(1, presupuesto);
        stmt.setString(2, "TRUE");
        stmt.executeUpdate(); // Ejecutar la inserción
    }

    public ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = connect().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }

    public void executeUpdate4(String sql, String date, String razonSocial, Double Monto, String GGasto, String Matriz, String FPago) throws SQLException {
        PreparedStatement st = connect.prepareStatement(sql); // Establecer los valores para el usuario y el nombre del proyecto
        st.setString(1, date); // Fecha
        st.setString(2, razonSocial); // RazonSocial
        st.setDouble(3, Monto); // Monto
        st.setString(4, GGasto); // GGasto
        st.setString(5, Matriz); // Matriz
        st.setString(6, FPago);
        st.executeUpdate();
    }
}
