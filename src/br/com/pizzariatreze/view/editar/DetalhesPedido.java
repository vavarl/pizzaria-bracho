package br.com.pizzariatreze.view.editar;

import br.com.pizzariatreze.controller.IngredienteController;
import br.com.pizzariatreze.controller.PedidoController;
import br.com.pizzariatreze.dao.IngredienteDao;
import br.com.pizzariatreze.dao.PedidoDao;
import br.com.pizzariatreze.dao.ProdutoDao;
import br.com.pizzariatreze.dto.IngredienteDto;
import br.com.pizzariatreze.dto.PedidoDto;
import br.com.pizzariatreze.dto.ProdutoDto;
import br.com.pizzariatreze.view.consulta.ConsultaPedido;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class DetalhesPedido extends javax.swing.JFrame {

    private PedidoDto pedido;

    public DetalhesPedido() {
        initComponents();
    }

    public DetalhesPedido(int id) {
        initComponents();
        
        PedidoDao pdao = new PedidoDao();
        ProdutoDao prodDao = new ProdutoDao();
        ProdutoDto prod = null;
        
        this.pedido = pdao.getById(id);
        lblTituloPedido.setText("Detalhes do pedido #" + pedido.getId());
        txtNomeCliente.setText(pedido.getCliente().getNome());
        txtIdCliente.setText(String.valueOf(pedido.getCliente().getId()));
        txtTelefoneCliente.setText(pedido.getCliente().getTelefone());
        txtEndereco.setText(pedido.getCliente().getEndereco());
        txtNomeAtendente.setText(pedido.getFuncionario().getNome());
        txtCargo.setText(pedido.getFuncionario().getCargo());
        
        String texto = "";
        String[] produtosSplit = pedido.getComposicaoString().split(",");
        for (int i = 0; i < produtosSplit.length; i++) {
            String[] produtoQtd = produtosSplit[i].split("|");
            prod = prodDao.getById(Integer.parseInt(produtoQtd[0]));
            String composicaoProduto = "";
            if (prod.getComposicao().size() > 0) {
                for(IngredienteDto ing : prod.getComposicao()) {
                    composicaoProduto = composicaoProduto + ing.getNome() + ", ";
                }
                String compFinal = composicaoProduto.substring(0, composicaoProduto.length()-2);
                texto = texto + produtoQtd[2] + "x " + prod.getNome() + " (" + compFinal + ")\n";
            } else {
                texto = texto + produtoQtd[2] + "x " + prod.getNome() + "\n";
            }
        }
        
        txaPedido.setText(texto);
        
        if (pedido.getTipo() == 1) {
            cbxSim.setSelected(true);
        }
        
        if (pedido.getStatus() == -1 || pedido.getStatus() == 2) {
            btnFinalizar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnAutorizar.setEnabled(false);
            lblStringStatus.setText(pedido.getStatus() == -1 ? "Cancelado" : "Finalizado");
        } else if (pedido.getStatus() == 0) {
            btnFinalizar.setEnabled(false);
            lblStringStatus.setText("Pendente");
        } else if (pedido.getStatus() == 1) {
            btnAutorizar.setEnabled(false);
            lblStringStatus.setText("Autorizado");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabelVoltar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtIdCliente = new javax.swing.JTextField();
        lblIdCliente = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefoneCliente = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTituloAtendente = new javax.swing.JLabel();
        lblNomeAtendente = new javax.swing.JLabel();
        txtNomeAtendente = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaPedido = new javax.swing.JTextArea();
        lblTituloPedido = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnAutorizar = new javax.swing.JButton();
        lblEntrega = new javax.swing.JLabel();
        cbxSim = new javax.swing.JCheckBox();
        lblStatus = new javax.swing.JLabel();
        lblStringStatus = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Detalhes do pedido");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabelVoltar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVoltar.setText("Voltar");
        jLabelVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVoltarMouseClicked(evt);
            }
        });

        jLabel2.setText("Dados do cliente:");

        txtIdCliente.setEditable(false);

        lblIdCliente.setText("ID:");

        lblNomeCliente.setText("Nome:");

        txtNomeCliente.setEditable(false);

        lblTelefone.setText("Telefone:");

        txtTelefoneCliente.setEditable(false);

        lblEndereco.setText("Endereço:");

        txtEndereco.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdCliente)
                    .addComponent(lblNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefone)
                    .addComponent(lblEndereco))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdCliente)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblTituloAtendente.setText("Dados do atendente:");

        lblNomeAtendente.setText("Nome:");

        txtNomeAtendente.setEditable(false);

        lblCargo.setText("Cargo:");

        txtCargo.setEditable(false);

        txaPedido.setEditable(false);
        txaPedido.setColumns(20);
        txaPedido.setRows(5);
        jScrollPane3.setViewportView(txaPedido);

        lblTituloPedido.setText("Dados do pedido");

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnAutorizar.setText("Autorizar");
        btnAutorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizarActionPerformed(evt);
            }
        });

        lblEntrega.setText("Entrega?");

        cbxSim.setText("Sim");
        cbxSim.setEnabled(false);

        lblStatus.setText("Status Pedido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAutorizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTituloAtendente)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblNomeAtendente)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblCargo)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtCargo))))
                                            .addComponent(lblTituloPedido))
                                        .addGap(98, 98, 98)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblEntrega)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbxSim))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblStatus)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblStringStatus)))))
                                .addGap(0, 198, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTituloAtendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAtendente)
                    .addComponent(txtNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntrega)
                    .addComponent(cbxSim))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloPedido)
                    .addComponent(lblStatus)
                    .addComponent(lblStringStatus))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutorizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizarActionPerformed
        PedidoController pedidoCtrl = new PedidoController();
        
        Map<String, Object> pedido = new HashMap<>();
        pedido.put("id", this.pedido.getId());
        pedido.put("status", "1");
        
        String resposta = "";
        try {
            resposta = pedidoCtrl.save(pedido) ? "Pedido autorizado com sucesso." : "Erro ao autorizar pedido.";
            btnAutorizar.setEnabled(false);
            btnFinalizar.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            resposta = e.getMessage();
        }
        
        JOptionPane.showMessageDialog(null, resposta);

    }//GEN-LAST:event_btnAutorizarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        PedidoController pedidoCtrl = new PedidoController();
        IngredienteDao idao = new IngredienteDao();
        ProdutoDao prodDao = new ProdutoDao();
        
        Map<String, Object> pedido = new HashMap<>();
        pedido.put("id", this.pedido.getId());
        pedido.put("status", "2");
        
        String resposta = "";
        try {
            resposta = pedidoCtrl.save(pedido) ? "Pedido finalizado com sucesso." : "Erro ao finalizar pedido.";
            btnAutorizar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnFinalizar.setEnabled(false);
            
            String[] produtosSplit = this.pedido.getComposicaoString().split(",");
            for (int i = 0; i < produtosSplit.length; i++) {
                String[] produtoQtd = produtosSplit[i].split("|");
                ProdutoDto prod = prodDao.getById(Integer.parseInt(produtoQtd[0]));
                if (prod.getComposicao().size() > 0) {
                    for(IngredienteDto ing : prod.getComposicao()) {
                        ing.setQuantidade(ing.getQuantidade()-Integer.parseInt(produtoQtd[2]));
                        idao.save(ing);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resposta = e.getMessage();
        }
        
        JOptionPane.showMessageDialog(null, resposta);

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jLabelVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltarMouseClicked
        ConsultaPedido cp = new ConsultaPedido();
        cp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelVoltarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PedidoController pedidoCtrl = new PedidoController();
        
        Map<String, Object> pedido = new HashMap<>();
        pedido.put("id", this.pedido.getId());
        pedido.put("status", "-1");
        
        String resposta = "";
        try {
            resposta = pedidoCtrl.save(pedido) ? "Pedido cancelado com sucesso." : "Erro ao cancelar pedido.";
            btnAutorizar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnFinalizar.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
            resposta = e.getMessage();
        }
        
        JOptionPane.showMessageDialog(null, resposta);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DetalhesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalhesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalhesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalhesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalhesPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutorizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JCheckBox cbxSim;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelVoltar;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblNomeAtendente;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStringStatus;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTituloAtendente;
    private javax.swing.JLabel lblTituloPedido;
    private javax.swing.JTextArea txaPedido;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeAtendente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
