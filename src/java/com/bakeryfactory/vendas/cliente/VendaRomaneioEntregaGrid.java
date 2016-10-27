/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni - contact:cperbony@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bakeryfactory.vendas.cliente;

import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class VendaRomaneioEntregaGrid extends InternalFrame {

    /**
     * Creates new form TempGrid
     * @param controller
     */
    public VendaRomaneioEntregaGrid(VendaRomaneioEntregaGridController controller) {
        initComponents();
        gridControl1.setController(controller);
        gridControl1.setGridDataLocator(controller);
    }
    
      /**
     *
     * @return GRID associada a cada tela
     */
    public GridControl getGrid1() {
        return gridControl1;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        gridControl1 = new org.openswing.swing.client.GridControl();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn4 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn5 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn6 = new org.openswing.swing.table.columns.client.DateColumn();
        comboColumn7 = new org.openswing.swing.table.columns.client.ComboColumn();
        dateColumn8 = new org.openswing.swing.table.columns.client.DateColumn();
        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();

        setTitle("Bakery Factory - Vendas e Faturamento");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setFunctionId("vendaRomaneioEntrega");
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setNavBar(navigatorBar1);
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setSingleExpandableRow(true);
        gridControl1.setValueObjectClassName("com.bakeryfactory.vendas.java.VendaRomaneioEntregaVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn2.setColumnName("colaborador.pessoa.nome");
        textColumn2.setHeaderColumnName("Colaborador");
        textColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn2.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn2);

        textColumn3.setColumnName("descricao");
        textColumn3.setHeaderColumnName("Descrição");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn3.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn3);

        dateColumn4.setColumnName("dataEmissao");
        dateColumn4.setHeaderColumnName("Data Emissão");
        dateColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn4);

        dateColumn5.setColumnName("dataPrevista");
        dateColumn5.setHeaderColumnName("Data Prevista");
        dateColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn5);

        dateColumn6.setColumnName("dataSaida");
        dateColumn6.setHeaderColumnName("Data Saída");
        dateColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn6);

        comboColumn7.setColumnName("situacao");
        comboColumn7.setDomainId("vendaRomaneioSituacao");
        comboColumn7.setHeaderColumnName("Situação");
        comboColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(comboColumn7);

        dateColumn8.setColumnName("dataEncerramento");
        dateColumn8.setHeaderColumnName("Data Encerramento");
        dateColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        dateColumn8.setPreferredWidth(110);
        gridControl1.getColumnContainer().add(dateColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Romaneio Entrega"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(insertButton1);
        jPanel1.add(deleteButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(navigatorBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn7;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn4;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn5;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn6;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn8;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    // End of variables declaration//GEN-END:variables
}
