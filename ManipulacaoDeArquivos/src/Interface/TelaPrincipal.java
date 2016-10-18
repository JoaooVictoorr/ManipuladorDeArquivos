/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import manipulacaodearquivos.Conversao;
import manipulacaodearquivos.Criar;
import manipulacaodearquivos.Escrever;
import manipulacaodearquivos.ManipulacaoDeArquivos;
import manipulacaodearquivos.SeparacaoDeSilabas;
import manipulacaodearquivos.SeparadorDePalavras;
import manipulacaodearquivos.SilabasSeparadasPorLinha;

/**
 *
 * @author João Victor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelecionarArquivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaLeitura = new javax.swing.JTextArea();
        btnComprimir = new javax.swing.JButton();
        labelCaminho = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSelecionarArquivo.setText("Selecionar Arquivo");
        btnSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarArquivoActionPerformed(evt);
            }
        });

        areaLeitura.setEditable(false);
        areaLeitura.setColumns(20);
        areaLeitura.setRows(5);
        areaLeitura.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(areaLeitura);

        btnComprimir.setText("Comprimir");
        btnComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprimirActionPerformed(evt);
            }
        });

        labelCaminho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnComprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionarArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCaminho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecionarArquivo)
                    .addComponent(labelCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnComprimir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarArquivoActionPerformed
       
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt", "txt");
        chooser.setDialogTitle("Selecione o .TXT a ser comprimido");
        chooser.setFileFilter(filtro);
        chooser.showOpenDialog(this);
        File arquivo = chooser.getSelectedFile();
        String caminho = arquivo.getAbsolutePath();
        labelCaminho.setText(caminho);
        
        try
        {
            FileReader reader = new FileReader(caminho);
            BufferedReader buffReader = new BufferedReader(reader);
            areaLeitura.read(buffReader, null);
            buffReader.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Arquivo não Encontrado!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível ler o arquivo!");
        }
    }//GEN-LAST:event_btnSelecionarArquivoActionPerformed

    private void btnComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprimirActionPerformed
         
        //Escrever escrever = new Escrever();
        SeparadorDePalavras separar = new SeparadorDePalavras();
        SeparacaoDeSilabas separacaoDeSilabas = new SeparacaoDeSilabas();
        SilabasSeparadasPorLinha silabas = new  SilabasSeparadasPorLinha();
        Criar criar = new Criar();

        File arquivo = criar.CriarArquivo(labelCaminho.getText());
        try {
            //escrever.Escrever(arquivo);
            //ler.Leitura(arquivo);
            separar.Separar(arquivo);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            separacaoDeSilabas.Regras();
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            silabas.Separar(arquivo);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnComprimirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaLeitura;
    private javax.swing.JButton btnComprimir;
    private javax.swing.JButton btnSelecionarArquivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCaminho;
    // End of variables declaration//GEN-END:variables
}
