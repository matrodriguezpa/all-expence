package matrodriguezpa.onespencer;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OneSpencerExample extends javax.swing.JFrame {

    private String usuario;

    public OneSpencerExample() {
        initComponents();
        tableModel = (DefaultTableModel) this.jTable1.getModel();
    }

    String url = "jdbc:sqlite:src/main/resources/baseDatos.db";
    Connection connect;

    DefaultTableModel tableModel;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        ConnectButton = new javax.swing.JButton();
        CreateProjectButton = new javax.swing.JButton();
        insertNewProject = new javax.swing.JButton();
        LoadProjectButton = new javax.swing.JButton();
        CreateMonthButton = new javax.swing.JButton();
        InsertMonthDataButton = new javax.swing.JButton();
        ExportProjectButton = new javax.swing.JButton();
        CloseConnectionButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jToolBar4 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        jTextField8 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("One Spencer - Test project");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Razon Social", "Monto", "Gasto", "Matriz", "Forma de pago"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        ConnectButton.setText("Connect DB");
        ConnectButton.setFocusable(false);
        ConnectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConnectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ConnectButton);

        CreateProjectButton.setText("CreateProjectTable");
        CreateProjectButton.setFocusable(false);
        CreateProjectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateProjectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreateProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProjectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(CreateProjectButton);

        insertNewProject.setText("InsertNewProject");
        insertNewProject.setFocusable(false);
        insertNewProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        insertNewProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        insertNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNewProjectActionPerformed(evt);
            }
        });
        jToolBar1.add(insertNewProject);

        LoadProjectButton.setText("Load Project data");
        LoadProjectButton.setFocusable(false);
        LoadProjectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoadProjectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LoadProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadProjectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(LoadProjectButton);

        CreateMonthButton.setText("Create Month-Project");
        CreateMonthButton.setFocusable(false);
        CreateMonthButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreateMonthButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreateMonthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateMonthButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(CreateMonthButton);

        InsertMonthDataButton.setText("Insert new data");
        InsertMonthDataButton.setFocusable(false);
        InsertMonthDataButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InsertMonthDataButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InsertMonthDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertMonthDataButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(InsertMonthDataButton);

        ExportProjectButton.setText("Export Project");
        ExportProjectButton.setFocusable(false);
        ExportProjectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExportProjectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExportProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportProjectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ExportProjectButton);

        CloseConnectionButton.setText("Close connection DB");
        CloseConnectionButton.setFocusable(false);
        CloseConnectionButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CloseConnectionButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CloseConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseConnectionButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(CloseConnectionButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);
        jToolBar2.setMinimumSize(new java.awt.Dimension(200, 200));
        jToolBar2.setName(""); // NOI18N
        jToolBar2.setPreferredSize(new java.awt.Dimension(180, 180));

        jDateChooser1.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jDateChooser1);

        jTextField2.setText("jTextField2");
        jTextField2.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jTextField2);

        jTextField3.setText("9999");
        jTextField3.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jTextField3);

        jTextField4.setText("jTextField4");
        jTextField4.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jTextField4);

        jTextField5.setText("jTextField5");
        jTextField5.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jTextField5);

        jTextField6.setText("jTextField6");
        jTextField6.setMaximumSize(new java.awt.Dimension(140, 30));
        jToolBar2.add(jTextField6);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.LINE_END);

        jToolBar3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar3.setRollover(true);

        jLabel1.setText("No load user");
        jToolBar3.add(jLabel1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("No load project");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jToolBar3.add(jScrollPane2);

        getContentPane().add(jToolBar3, java.awt.BorderLayout.LINE_START);

        jToolBar4.setRollover(true);
        jToolBar4.add(filler1);

        jTextField8.setText("nombreProyecto");
        jTextField8.setMaximumSize(new java.awt.Dimension(100, 100));
        jTextField8.setMinimumSize(new java.awt.Dimension(50, 50));
        jTextField8.setPreferredSize(new java.awt.Dimension(100, 30));
        jToolBar4.add(jTextField8);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mes1", "mes2", "mes3", "mes4", "mes5", "mes6", "mes7", "mes8", "mes9", "mes10", "mes11", "mes12", " " }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 100));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 30));
        jToolBar4.add(jComboBox1);

        getContentPane().add(jToolBar4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed
        try {
            connect = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conexión exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_ConnectButtonActionPerformed

    private void InsertMonthDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertMonthDataButtonActionPerformed
        try {
            PreparedStatement st = connect.prepareStatement(
                    "INSERT INTO mes1" + jLabel1.getText() + " (Fecha, RazonSocial, Monto, GGasto, Matriz, FPago) VALUES (?, ?, ?, ?, ?, ?)"
            );

            // Establecer los valores para cada columna (ajustar según los tipos de datos de las columnas)
            String day = String.valueOf(jDateChooser1.getDate().getDay());
            String month = String.valueOf(jDateChooser1.getDate().getMonth());
            String year = String.valueOf(jDateChooser1.getDate().getYear());
            String date = day + "-" + month + "-" + year;

            st.setString(1, date); // Fecha
            st.setString(2, jTextField2.getText()); // RazonSocial
            st.setDouble(3, Double.parseDouble(jTextField3.getText())); // Monto
            st.setString(4, jTextField4.getText()); // GGasto
            st.setString(5, jTextField5.getText()); // Matriz
            st.setString(6, jTextField6.getText()); // FPago

            // Ejecutar la consulta
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserción exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_InsertMonthDataButtonActionPerformed

    private void CloseConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseConnectionButtonActionPerformed
        // TODO add your handling code here:
        try {
            connect.close();
            JOptionPane.showMessageDialog(null, "Conexión cerrada.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_CloseConnectionButtonActionPerformed

    private void CreateProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProjectButtonActionPerformed
        String sql = "CREATE TABLE IF NOT EXISTS proyectos ("
                + "usuario TEXT NOT NULL,"
                + "nombre TEXT NOT NULL,"
                + "presupuestoMes1 REAL,"
                + "idProyectoMes1 BOOLEAN,"
                + "presupuestoMes2 REAL,"
                + "idProyectoMes2 BOOLEAN,"
                + "presupuestoMes3 REAL,"
                + "idProyectoMes3 BOOLEAN,"
                + "presupuestoMes4 REAL,"
                + "idProyectoMes4 BOOLEAN,"
                + "presupuestoMes5 REAL,"
                + "idProyectoMes5 BOOLEAN,"
                + "presupuestoMes6 REAL,"
                + "idProyectoMes6 BOOLEAN,"
                + "presupuestoMes7 REAL,"
                + "idProyectoMes7 BOOLEAN,"
                + "presupuestoMes8 REAL,"
                + "idProyectoMes8 BOOLEAN,"
                + "presupuestoMes9 REAL,"
                + "idProyectoMes9 BOOLEAN,"
                + "presupuestoMes10 REAL,"
                + "idProyectoMes10 BOOLEAN,"
                + "presupuestoMes11 REAL,"
                + "idProyectoMes11 BOOLEAN,"
                + "presupuestoMes12 REAL,"
                + "idProyectoMes12 BOOLEAN);";

        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tabla 'proyectos' creada o ya existe.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_CreateProjectButtonActionPerformed

    private void ExportProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportProjectButtonActionPerformed
        String filename = "src/main/resources/exported_file.xls";
        File file = new File(filename);
        file.getParentFile().mkdirs(); // Crear directorios padres si no existen
        try (OutputStream fileOut = new FileOutputStream(file)) {
            Workbook wb = new HSSFWorkbook();
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(OneSpencerExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExportProjectButtonActionPerformed

    private void LoadProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadProjectButtonActionPerformed
        usuario = "nombreUsuario";
        
        ResultSet resul;
        try {
            // Consulta para obtener todos los proyectos con un parámetro
            PreparedStatement st = connect.prepareStatement("SELECT * FROM proyectos WHERE usuario = ?");
            st.setString(1, this.usuario); // Reemplaza this.usuario por el valor correcto

            resul = st.executeQuery();

            // Crear el nodo raíz del árbol
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Proyectos");

            // Recorrer todos los proyectos
            while (resul.next()) {
                // Crear un nodo para el proyecto con su nombre
                String projectName = resul.getString("nombre");
                DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(projectName);

                // Agregar los meses como nodos secundarios
                for (int i = 1; i <= 12; i++) {
                    String columnIdProyectoMes = "idProyectoMes" + i; // Nombre de la columna
                    if (resul.getString(columnIdProyectoMes) != null) {
                        String monthName = "mes" + i;
                        DefaultMutableTreeNode monthNode = new DefaultMutableTreeNode(monthName);
                        projectNode.add(monthNode);
                    }
                }

                // Agregar el proyecto al nodo raíz
                root.add(projectNode);
            }

            // Crear el modelo del árbol con el nodo raíz
            DefaultTreeModel treeModel = new DefaultTreeModel(root);

            // Establecer el modelo en el JTree (asumiendo que tienes un JTree llamado jTree1)
            jTree1.setModel(treeModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_LoadProjectButtonActionPerformed

    private void insertNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertNewProjectActionPerformed
        String sql = "INSERT INTO proyectos("
                + "usuario, nombre,"
                + "presupuestoMes1, idProyectoMes1, "
                + "presupuestoMes2, idProyectoMes2, "
                + "presupuestoMes3, idProyectoMes3, "
                + "presupuestoMes4, idProyectoMes4, "
                + "presupuestoMes5, idProyectoMes5, "
                + "presupuestoMes6, idProyectoMes6, "
                + "presupuestoMes7, idProyectoMes7, "
                + "presupuestoMes8, idProyectoMes8, "
                + "presupuestoMes9, idProyectoMes9, "
                + "presupuestoMes10, idProyectoMes10, "
                + "presupuestoMes11, idProyectoMes11, "
                + "presupuestoMes12, idProyectoMes12) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setString(1, "userName"); // Asigna un valor al usuario (String)
            stmt.setString(2, jTextField8.getText());    // Asigna un valor al nombre del proyecto (String)

            // Ejemplo: presupuestoMes1 es un valor de tipo Double y idProyectoMes1 es un valor de tipo Integer
            stmt.setDouble(3, 1); 
            stmt.setBoolean(4, true);     
            stmt.setObject(5, 0);
            stmt.setBoolean(6, false);
            stmt.setObject(5, 0);
            stmt.setBoolean(6, false);
            stmt.setObject(7, 0);
            stmt.setBoolean(8, false);
            stmt.setObject(9, 0);
            stmt.setBoolean(10, false);
            stmt.setObject(11, 0);
            stmt.setBoolean(12, false);
            stmt.setObject(13, 0);
            stmt.setBoolean(14, false);
            stmt.setObject(15, 0);
            stmt.setBoolean(16, false);
            stmt.setObject(17, 0);
            stmt.setBoolean(18, false);
            stmt.setObject(19, 0);
            stmt.setBoolean(20, false);
            stmt.setObject(21, 0);
            stmt.setBoolean(22, false);
            stmt.setObject(23, 0);
            stmt.setBoolean(24, false);
            stmt.setObject(25, 0);
            stmt.setBoolean(26, false);

            stmt.executeUpdate();    // Ejecuta la inserción
            JOptionPane.showMessageDialog(null, "Insersión exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el proyecto: " + e.getMessage());
        }
    }//GEN-LAST:event_insertNewProjectActionPerformed

    private void CreateMonthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateMonthButtonActionPerformed
        try {

            // Crear la tabla si no existe
            PreparedStatement createTableSt = connect.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS "
                    + "mes"+(jComboBox1.getSelectedIndex()+1)+this.usuario + " ("
                    + "Fecha TEXT,"
                    + "RazonSocial TEXT,"
                    + "Monto REAL,"
                    + "GGasto TEXT,"
                    + "Matriz TEXT,"
                    + "FPago TEXT)"
            );
            createTableSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tabla creada si no existía.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_CreateMonthButtonActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // Obtener el nodo seleccionado
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();

        // Verificar si el nodo es una hoja (nodo final)
        if (selectedNode != null && selectedNode.isLeaf()) {
            // Habilitar el botón LoadMonthDataButton
            loadMonth("mes1" + jLabel1.getText());
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void loadMonth(String nombreTabla) {
        tableModel.setRowCount(0);
        ResultSet resul;
        try {
            PreparedStatement st = connect.prepareStatement("SELECT * FROM " + nombreTabla);
            resul = st.executeQuery();
            while (resul.next()) {
                // Agrega las filas al modelo con los datos de la tabla 'gastos'
                tableModel.addRow(new Object[]{
                    resul.getString("Fecha"),
                    resul.getString("RazonSocial"),
                    resul.getDouble("Monto"),
                    resul.getString("GGasto"),
                    resul.getString("Matriz"),
                    resul.getString("FPago")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OneSpencerExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OneSpencerExample().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseConnectionButton;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JButton CreateMonthButton;
    private javax.swing.JButton CreateProjectButton;
    private javax.swing.JButton ExportProjectButton;
    private javax.swing.JButton InsertMonthDataButton;
    private javax.swing.JButton LoadProjectButton;
    public javax.swing.Box.Filler filler1;
    private javax.swing.JButton insertNewProject;
    public javax.swing.JComboBox<String> jComboBox1;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JToolBar jToolBar1;
    public javax.swing.JToolBar jToolBar2;
    public javax.swing.JToolBar jToolBar3;
    public javax.swing.JToolBar jToolBar4;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
