package br.ufu.facom.frameworkpim.view;

import br.ufu.facom.frameworkpim.control.StickyNotesControl;
import br.ufu.facom.frameworkpim.model.StickyNote;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;

public class CadastroStickyNotesIFrame extends javax.swing.JInternalFrame {

    private List<StickyNotesIFrame> list;

    private StickyNotesControl stickyNotesControl;

    public CadastroStickyNotesIFrame(List<StickyNotesIFrame> snotes, StickyNotesControl stickyNotesControl) {
        super("Add Sticky Note");
        initComponents();
        this.stickyNotesControl = stickyNotesControl;
        this.list = snotes;
        this.setVisible(true);
        this.setLocation(490, 200);
        this.setClosable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.lembreteJText.setBackground(new Color(255, 255, 200));

        this.lembreteJText.addKeyListener(new LimitDigitsListener(120, this.lembreteJText));
        /*this.lembreteJText.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         if (getTextArea().getText().length() > 120){
         String text = getTextArea().getText();
         getTextArea().setText(text.substring(0, 120));
         }
         }
         @Override
         public void keyPressed(KeyEvent e) {}
         @Override
         public void keyReleased(KeyEvent e) {}
         });*/

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lembreteJText = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        lembreteJText.setColumns(20);
        lembreteJText.setRows(5);
        jScrollPane1.setViewportView(lembreteJText);

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStickyToParentDesktopPane();
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        jLabel1.setText("Faça sua anotação aqui");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(33, 33, 33)
                        .addComponent(cancelButton)
                        .addGap(75, 75, 75))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel1)))
                        .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addButton)
                                .addComponent(cancelButton))
                        .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JTextArea getTextArea() {
        return this.lembreteJText;
    }

    private void addStickyToParentDesktopPane() {
        StickyNote stk = new StickyNote(this.lembreteJText.getText(), 400, 0);
        StickyNotesIFrame sticky = new StickyNotesIFrame(stk, stickyNotesControl);
        ((JDesktopPane) this.getParent()).add(sticky);
        this.lembreteJText.setText("");
        stickyNotesControl.save(stk);
        this.list.add(sticky);
    }

    private void close() {
        this.dispose();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lembreteJText;
    // End of variables declaration//GEN-END:variables
}
