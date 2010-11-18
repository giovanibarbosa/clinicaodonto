/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GeradorDeBoleto.java
 *
 * Created on 18/11/2010, 00:23:01
 */

package InterfaceGrafica;

import boleto.GeradorDeBoletos;
import classes.Data;
import classes.Contrato;
import classes.Cliente;
import enums.StatusContrato;
import enums.TipoDeContrato;
import facades.SistemaFacade;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Tiago Brasileiro
 */
public class GeradorDeBoleto extends javax.swing.JPanel implements KeyListener{

    private JTabbedPane tabbed;
    private JScrollPane scroll;
    private SistemaFacade fachada = SistemaFacade.getInstance();


    /** Creates new form EditarContrato */
    public GeradorDeBoleto(JTabbedPane tabbed, JScrollPane scroll) {
        this.tabbed = tabbed;
        this.scroll = scroll;
        initComponents();

        scroll.addKeyListener(this);
        scroll.show();

        tabbed.addKeyListener(this);
        tabbed.show();

        this.addKeyListener(this);
        this.show();

        fieldCodigoCliente.addKeyListener(this);
        fieldCodigoCliente.show();



        botaoCadastrar.addKeyListener(this);
        botaoCadastrar.show();

        botaoCancelar.addKeyListener(this);
        botaoCancelar.show();


    }






     @SuppressWarnings("deprecation")
    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botaoCadastrarActionPerformed(null);

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    botaoCancelarActionPerformed(null);
            }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }

    private void reiniciaCampos() {
        fieldCodigoCliente.setText(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        fieldCodigoCliente = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 507));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18));
        jLabel1.setText("Gerar Boletos");

        jLabel2.setText("C�digo do Cliente");

        botaoCadastrar.setText("Gerar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Fechar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(botaoCancelar)
                            .addGap(40, 40, 40)
                            .addComponent(botaoCadastrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(67, 67, 67)
                            .addComponent(fieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(541, 541, 541))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoCancelar))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        try {
            String idCliente = (String) fieldCodigoCliente.getText();

            Cliente cliente = fachada.recuperaClientePorID(idCliente);

            GeradorDeBoletos gerador = new GeradorDeBoletos(cliente);
            gerador.GerarBoleto();

            JOptionPane.showMessageDialog(null, "Boleto gerado com sucesso!",
                    "Cadastro",
                    JOptionPane.CLOSED_OPTION);
            reiniciaCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Problemas com o cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        reiniciaCampos();
        tabbed.remove(scroll);
}//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JTextField fieldCodigoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
