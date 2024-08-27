package matrodriguezpa.expensetracker;

import java.sql.*;

public class Model {
    private String mensaje;

    public String getMensaje() {
        if (mensaje == null) {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mensajes.db");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT mensaje FROM mensajes")) {
                if (rs.next()) {
                    mensaje = rs.getString("mensaje");
                } else {
                    System.out.println("No se encontró ningún mensaje en la base de datos.");
                }
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return mensaje;
    }
}