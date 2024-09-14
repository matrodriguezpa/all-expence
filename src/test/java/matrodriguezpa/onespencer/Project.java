package matrodriguezpa.onespencer;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Project {

    String url = "jdbc:sqlite:src/main/resources/baseDatos.db";
    Connection connect;

    private void connectDatabase() {
        try {
            this.connect = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conexión exitosa.");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void createProjectsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS proyectos ("
                + "usuario TEXT NOT NULL, nombre TEXT NOT NULL,"
                + "presupuestoMes1 REAL, idProyectoMes1 BOOLEAN,"
                + "presupuestoMes2 REAL, idProyectoMes2 BOOLEAN,"
                + "presupuestoMes3 REAL, idProyectoMes3 BOOLEAN,"
                + "presupuestoMes4 REAL, idProyectoMes4 BOOLEAN,"
                + "presupuestoMes5 REAL, idProyectoMes5 BOOLEAN,"
                + "presupuestoMes6 REAL, idProyectoMes6 BOOLEAN,"
                + "presupuestoMes7 REAL, idProyectoMes7 BOOLEAN,"
                + "presupuestoMes8 REAL, idProyectoMes8 BOOLEAN,"
                + "presupuestoMes9 REAL, idProyectoMes9 BOOLEAN,"
                + "presupuestoMes10 REAL, idProyectoMes10 BOOLEAN,"
                + "presupuestoMes11 REAL, idProyectoMes11 BOOLEAN,"
                + "presupuestoMes12 REAL, idProyectoMes12 BOOLEAN);";

        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tabla 'proyectos' creada o ya existe.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
