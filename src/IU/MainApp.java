package IU;

import IU.Entry.Entry;
import IU.Entry.Login;
import IU.Screen.Screen;
import IU.Settings.Settings;
import IU.Entry.Signin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends javax.swing.JFrame implements ActionListener{

    Entry entry = new Entry();
    Screen screen = new Screen();
    Settings settings = new Settings();
    Login login = new Login();
    Signin signin = new Signin();
    
    public MainApp() {
        initComponents();
                
        Screen.add(entry);
        entry.setVisible(true);
        entry.Input.add(signin);
        
        ButtonEnter.setVisible(true);
        ButtonSettings.setVisible(false);
        ButtonExit.setVisible(false);
        
        ButtonEnter.addActionListener(this);
        ButtonSettings.addActionListener(this);
        ButtonExit.addActionListener(this);
        ButtonLogin.addActionListener(this);
        ButtonSignin.addActionListener(this);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroupMainNavigation = new javax.swing.ButtonGroup();
        ScrollPane = new javax.swing.JScrollPane();
        Main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        PanelLogo = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        ButtonSignin = new javax.swing.JButton();
        Screen = new javax.swing.JPanel();
        MainNavigation = new javax.swing.JPanel();
        NavigationButtons = new javax.swing.JPanel();
        ButtonEnter = new javax.swing.JButton();
        ButtonSettings = new javax.swing.JButton();
        ButtonExit = new javax.swing.JButton();
        Footer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 450));
        setPreferredSize(new java.awt.Dimension(1300, 750));

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Main.setBackground(java.awt.Color.white);
        Main.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(0, 51, 153));

        PanelLogo.setBackground(new java.awt.Color(0, 51, 153));

        Tittle.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        Tittle.setForeground(new java.awt.Color(255, 255, 255));
        Tittle.setText("Budget Buddy");

        Slogan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Slogan.setForeground(new java.awt.Color(255, 255, 255));
        Slogan.setText("Tu amigo en el hogar");

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Slogan)
                    .addComponent(Tittle))
                .addGap(12, 12, 12))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Slogan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonLogin.setBackground(new java.awt.Color(0, 51, 102));
        ButtonLogin.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonLogin.setForeground(java.awt.Color.white);
        ButtonLogin.setText("Iniciar Sesión");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        ButtonSignin.setBackground(new java.awt.Color(0, 51, 102));
        ButtonSignin.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonSignin.setForeground(java.awt.Color.white);
        ButtonSignin.setText("Crear Cuenta");
        ButtonSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSigninActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 698, Short.MAX_VALUE)
                .addComponent(ButtonSignin)
                .addGap(18, 18, 18)
                .addComponent(ButtonLogin)
                .addGap(123, 123, 123))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonLogin)
                            .addComponent(ButtonSignin)))
                    .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Main.add(Header, java.awt.BorderLayout.PAGE_START);

        Screen.setBackground(java.awt.Color.white);
        Screen.setLayout(new java.awt.BorderLayout());

        MainNavigation.setLayout(new java.awt.BorderLayout());

        NavigationButtons.setBackground(new java.awt.Color(0, 153, 153));
        NavigationButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 15));
        NavigationButtons.setLayout(new javax.swing.BoxLayout(NavigationButtons, javax.swing.BoxLayout.Y_AXIS));

        ButtonEnter.setBackground(new java.awt.Color(0, 102, 102));
        ButtonEnter.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonEnter.setForeground(java.awt.Color.white);
        ButtonEnter.setText("Iniciar Sesión");
        ButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterActionPerformed(evt);
            }
        });
        NavigationButtons.add(ButtonEnter);

        ButtonSettings.setBackground(new java.awt.Color(0, 102, 102));
        ButtonSettings.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonSettings.setForeground(java.awt.Color.white);
        ButtonSettings.setText("Configuración");
        NavigationButtons.add(ButtonSettings);

        ButtonExit.setBackground(new java.awt.Color(0, 102, 102));
        ButtonExit.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ButtonExit.setForeground(java.awt.Color.white);
        ButtonExit.setText("Cerrar Sesión");
        NavigationButtons.add(ButtonExit);

        MainNavigation.add(NavigationButtons, java.awt.BorderLayout.LINE_START);

        Screen.add(MainNavigation, java.awt.BorderLayout.SOUTH);

        Main.add(Screen, java.awt.BorderLayout.CENTER);

        Footer.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1356, Short.MAX_VALUE)
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        Main.add(Footer, java.awt.BorderLayout.PAGE_END);

        ScrollPane.setViewportView(Main);

        getContentPane().add(ScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void ButtonSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSigninActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSigninActionPerformed

    private void ButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEnter;
    private javax.swing.JButton ButtonExit;
    private javax.swing.ButtonGroup ButtonGroupMainNavigation;
    public javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonSettings;
    public javax.swing.JButton ButtonSignin;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel MainNavigation;
    private javax.swing.JPanel NavigationButtons;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel Screen;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel Slogan;
    private javax.swing.JLabel Tittle;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object evt = e.getSource();
        if (evt.equals(ButtonEnter)){
            
            entry.setVisible(false);
            screen.setVisible(true);
            settings.setVisible(false);
            
            ButtonEnter.setVisible(false);
            ButtonSettings.setVisible(true);
            ButtonExit.setVisible(true);
            ButtonLogin.setVisible(false);
            ButtonSignin.setVisible(false);
            
            Screen.add(screen);
            Screen.validate();
        }
        else if (evt.equals(ButtonSettings)&&(screen.isVisible()==true)){
            entry.setVisible(false);
            screen.setVisible(false);
            settings.setVisible(true);
            
            ButtonEnter.setVisible(false);
            ButtonSettings.setVisible(true);
            ButtonExit.setVisible(false);
                        
            ButtonSettings.setText("Volver");
            Screen.add(settings);
            Screen.validate();
        }
        else if (evt.equals(ButtonSettings)&&(settings.isVisible()==true)){
            entry.setVisible(false);
            screen.setVisible(true);
            settings.setVisible(false);
            
            ButtonEnter.setVisible(false);
            ButtonSettings.setVisible(true);
            ButtonExit.setVisible(true);
            
            ButtonSettings.setText("Configuración");
            Screen.add(screen);
            Screen.validate();
        }
        else if (evt.equals(ButtonExit)){
            entry.setVisible(true);
            screen.setVisible(false);
            settings.setVisible(false);
            
            ButtonEnter.setVisible(true);
            ButtonSettings.setVisible(false);
            ButtonExit.setVisible(false);
            ButtonLogin.setVisible(true);
            ButtonSignin.setVisible(true);
            
            Screen.add(entry);
            Screen.validate();
        }
        
        if (evt.equals(ButtonLogin)){
            login.setVisible(true);
            signin.setVisible(false);
            
            entry.Preview.setVisible(false);
            
            entry.Input.add(login);
            entry.Input.validate();
        }
        else if (evt.equals(ButtonSignin)){
            login.setVisible(false);
            signin.setVisible(true);
            entry.Preview.setVisible(false);
            
            entry.Input.add(signin);
            entry.Input.validate();
        }
    }
}

