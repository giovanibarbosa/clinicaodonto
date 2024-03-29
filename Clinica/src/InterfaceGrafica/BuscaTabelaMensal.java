/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscaTabelaMensal.java
 *
 * Created on 17/11/2010, 14:41:24
 */

package InterfaceGrafica;

import facades.SistemaFacade;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
/**
 *
 * @author Tiago Brasileiro
 */
public class BuscaTabelaMensal extends javax.swing.JPanel implements KeyListener{

 private JTabbedPane tabbed;
    private JScrollPane scroll;
    private SistemaFacade fachada = SistemaFacade.getInstance();

    /** Creates new form TabelaDiaria */
    public BuscaTabelaMensal(JTabbedPane tabbed, JScrollPane scroll) {
        this.tabbed = tabbed;
        this.scroll = scroll;
        initComponents();

        scroll.addKeyListener(this);
        scroll.show();

        tabbed.addKeyListener(this);
        tabbed.show();

        this.addKeyListener(this);
        this.show();
        
        botaoFechar.addKeyListener(this);
        botaoFechar.show();

        jList1.addKeyListener(this);
        jList1.show();

        botaoLimpar.addKeyListener(this);
        botaoLimpar.show();

        reiniciaCampos();

    }



     @SuppressWarnings("deprecation")
    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    VisualizaTabelaActionPerformed(null);

            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    botaoFecharActionPerformed(null);
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
        try {
            jList1.setModel(new javax.swing.AbstractListModel() {
            String[] tabelas = fachada.recuperaStringsTabelasMensais();
            public int getSize() {return tabelas.length;}
            public String getElementAt(int i){return tabelas[i];}
            });
            jScrollPane1.setViewportView(jList1);
        } catch (Exception e) {

        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        botaoLimpar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        VisualizaTabela = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Busca de Tabelas Mensais");

        jScrollPane1.setViewportView(jList1);

        botaoLimpar.setText("Limpar Dados");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoFechar.setText("Fechar Aba");
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        VisualizaTabela.setText("Visualizar");
        VisualizaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizaTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(578, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(botaoFechar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VisualizaTabela)
                .addGap(442, 442, 442))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(VisualizaTabela)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoLimpar))
                        .addGap(56, 56, 56))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        reiniciaCampos();
}//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        reiniciaCampos();
        tabbed.remove(scroll);
}//GEN-LAST:event_botaoFecharActionPerformed

    private void VisualizaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizaTabelaActionPerformed
        if(jList1.isSelectionEmpty())
            JOptionPane.showMessageDialog(null, "Selecione uma data",
                    "Selecione",
                    JOptionPane.ERROR_MESSAGE);
        else {
            try {
                String data = String.valueOf(jList1.getSelectedValue());
                Object[][][] tupla = fachada.recuperaTuplaMensal
                        (data);
                if(tupla != null) {
                    JScrollPane s = new JScrollPane();
                    VisualizaTabela visualizavel = new VisualizaTabela
                            (tupla, data, tabbed, s);
                    s.setViewportView(visualizavel);
                    tabbed.addTab("Editar Tabela Mensal", s);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Problemas",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_VisualizaTabelaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VisualizaTabela;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
