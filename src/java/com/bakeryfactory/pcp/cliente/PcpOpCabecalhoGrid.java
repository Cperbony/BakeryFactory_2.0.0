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
package com.bakeryfactory.pcp.cliente;

import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class PcpOpCabecalhoGrid extends InternalFrame {

    /**
     * Creates new form TempGrid
     * @param controller
     */
    public PcpOpCabecalhoGrid(PcpOpCabecalhoGridController controller) {
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

        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();
        gridControl1 = new org.openswing.swing.client.GridControl();
        dateColumn3 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn4 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn5 = new org.openswing.swing.table.columns.client.DateColumn();
        decimalColumn6 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn9 = new org.openswing.swing.table.columns.client.DecimalColumn();

        setResizable(false);
        setTitle("Bakery Factory - PCP");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PCP - Ordem de Produção"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));
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

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setFunctionId("pcpOpCabecalho");
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setNavBar(navigatorBar1);
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpOpCabecalhoVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        dateColumn3.setColumnName("inicio");
        dateColumn3.setHeaderColumnName("Início");
        dateColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn3);

        dateColumn4.setColumnName("previsaoEntrega");
        dateColumn4.setHeaderColumnName("Previsão Entrega");
        dateColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn4);

        dateColumn5.setColumnName("termino");
        dateColumn5.setHeaderColumnName("Término");
        dateColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn5);

        decimalColumn6.setColumnName("custoTotalPrevisto");
        decimalColumn6.setDecimals(2);
        decimalColumn6.setHeaderColumnName("Custo Total Previsto");
        decimalColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn6.setPreferredWidth(120);
        gridControl1.getColumnContainer().add(decimalColumn6);

        decimalColumn7.setColumnName("custoTotalRealizado");
        decimalColumn7.setDecimals(2);
        decimalColumn7.setHeaderColumnName("Custo Total Realizado");
        decimalColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn7.setPreferredWidth(130);
        gridControl1.getColumnContainer().add(decimalColumn7);

        decimalColumn8.setColumnName("porcentoVenda");
        decimalColumn8.setHeaderColumnName("Porcento Venda");
        decimalColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn8.setDecimals(2);
        gridControl1.getColumnContainer().add(decimalColumn8);

        decimalColumn9.setColumnName("porcentoEstoque");
        decimalColumn9.setDecimals(2);
        decimalColumn9.setHeaderColumnName("Porcento Estoque");
        decimalColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn9.setPreferredWidth(120);
        gridControl1.getColumnContainer().add(decimalColumn9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.DateColumn dateColumn3;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn4;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn6;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn9;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    // End of variables declaration//GEN-END:variables
}
