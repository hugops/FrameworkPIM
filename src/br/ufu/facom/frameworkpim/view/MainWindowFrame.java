package br.ufu.facom.frameworkpim.view;

import br.ufu.facom.frameworkpim.config.Path;
import br.ufu.facom.frameworkpim.control.AbstractFactory;
import br.ufu.facom.frameworkpim.control.EventoControl;
import br.ufu.facom.frameworkpim.control.StickyNotesControl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
//import javax.swing.JOptionPane;

public class MainWindowFrame extends javax.swing.JFrame {

    public MainWindowFrame(AbstractFactory factory) {
        this.eventoControl = factory.createEventoControl();
        this.stickyNotesControl = factory.createCtickyNotesControl();
        this.setMainWindowConfigurations();
        this.setDesktopConfigurations();
        this.visibilityConfigurations();
        //Notifications.showMessage("Testando!", "Testando 123 Hello World!!", Notifications.ATENTION_ICON);
    }

    private void setMainWindowConfigurations() {
        this.initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Path.getImagePath("persimlogo.png")));
        this.setTitle("PERSIM - Personal Student Info. Manager");
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(tela.width, tela.height);
        this.setVisible(true);

    }

    protected void setDesktopConfigurations() {
        stickyNotes = stickyNotesControl.buildStickyNotesIFrames();
        for (Iterator<StickyNotesIFrame> it = stickyNotes.iterator(); it.hasNext();) {
            StickyNotesIFrame stickyNotesIFrame = it.next();
            this.desktopPane.add(stickyNotesIFrame);
        }
        this.calframe = new CalendarIFrame(eventoControl);
        this.desktopPane.add(this.calframe);
    }

    private void visibilityConfigurations() {
        /*int answer = JOptionPane.showConfirmDialog(this, "Não há períodos cadastrados! Antes de começar "
         + "você deve cadastrar um novo período",
         "Cadastre um novo período", JOptionPane.INFORMATION_MESSAGE ,
         JOptionPane.NO_OPTION);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        criarMenu = new javax.swing.JMenu();
        eventoMenu = new javax.swing.JMenuItem();
        lembreteMenuItem = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        criarMenu.setText("Criar");

        eventoMenu.setText("Evento");
        eventoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoMenuActionPerformed(evt);
            }
        });
        criarMenu.add(eventoMenu);

        lembreteMenuItem.setText("Lembrete");
        lembreteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembreteMenuItemActionPerformed(evt);
            }
        });
        criarMenu.add(lembreteMenuItem);

        menuBar.add(criarMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventoMenuActionPerformed
        this.eventFrame = new CadastroEventoIFrame(eventoControl);//instancia a classe iFrmCliente
        desktopPane.add(this.eventFrame);//adiciona o cliente no seu JdesktopPane
        this.eventFrame.setLocation(400, 0);//colocar a tela iFrmCliente na posiÃ§Ã£o(0,0)
        this.eventFrame.setVisible(true);//deixa visÃ­vel
    }//GEN-LAST:event_eventoMenuActionPerformed

    private void lembreteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembreteMenuItemActionPerformed
        this.stickyFrame = new CadastroStickyNotesIFrame(this.stickyNotes, stickyNotesControl);
        desktopPane.add(this.stickyFrame);
    }//GEN-LAST:event_lembreteMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainWindowFrame().setVisible(true);
//            }
//        });
//    }
    //Atributos declarados
    private CalendarIFrame calframe;
    private CadastroEventoIFrame eventFrame;
    private CadastroStickyNotesIFrame stickyFrame;
    private List<StickyNotesIFrame> stickyNotes;
    private EventoControl eventoControl;
    private StickyNotesControl stickyNotesControl;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu criarMenu;
    protected javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem eventoMenu;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem lembreteMenuItem;
    protected javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
