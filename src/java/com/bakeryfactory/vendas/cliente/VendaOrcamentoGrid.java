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
public class VendaOrcamentoGrid extends InternalFrame {

    /**
     * Creates new form TempGrid
     * @param controller
     */
    public VendaOrcamentoGrid(VendaOrcamentoGridController controller) {
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
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        comboColumn6 = new org.openswing.swing.table.columns.client.ComboColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn8 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn9 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn10 = new org.openswing.swing.table.columns.client.DateColumn();
        comboColumn11 = new org.openswing.swing.table.columns.client.ComboColumn();
        decimalColumn12 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn13 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn14 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn15 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn16 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn17 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn18 = new org.openswing.swing.table.columns.client.DecimalColumn();
        comboColumn20 = new org.openswing.swing.table.columns.client.ComboColumn();
        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();

        setTitle("Bakery Factory - Vendas e Faturamento");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        gridControl1.setFunctionId("vendaOrcamentoCabecalho");
        gridControl1.setValueObjectClassName("com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn5.setColumnName("cliente.pessoa.nome");
        textColumn5.setHeaderColumnName("Cliente");
        textColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn5);

        textColumn3.setColumnName("vendedor.colaborador.pessoa.nome");
        textColumn3.setHeaderColumnName("Vendedor");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn3);

        textColumn2.setColumnName("vendaCondicoesPagamento.nome");
        textColumn2.setHeaderColumnName("Condição Pagamento");
        textColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn2.setPreferredWidth(130);
        gridControl1.getColumnContainer().add(textColumn2);

        textColumn4.setColumnName("transportadora.pessoa.nome");
        textColumn4.setHeaderColumnName("Transportadora");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn4);

        comboColumn6.setColumnName("tipo");
        comboColumn6.setDomainId("vendaOrcamentoTipo");
        comboColumn6.setHeaderColumnName("Tipo");
        comboColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(comboColumn6);

        textColumn7.setColumnName("codigo");
        textColumn7.setHeaderColumnName("Código");
        textColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn7);

        dateColumn8.setColumnName("dataCadastro");
        dateColumn8.setHeaderColumnName("Data Cadastro");
        dateColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn8);

        dateColumn9.setColumnName("dataEntrega");
        dateColumn9.setHeaderColumnName("Data Entrega");
        dateColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn9);

        dateColumn10.setColumnName("validade");
        dateColumn10.setHeaderColumnName("Validade");
        dateColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumn10);

        comboColumn11.setColumnName("tipoFrete");
        comboColumn11.setDomainId("compraTipoFrete");
        comboColumn11.setHeaderColumnName("Tipo Frete");
        comboColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(comboColumn11);

        decimalColumn12.setColumnName("valorSubtotal");
        decimalColumn12.setHeaderColumnName("Valor Subtotal");
        decimalColumn12.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn12.setDecimals(2);
        gridControl1.getColumnContainer().add(decimalColumn12);

        decimalColumn13.setColumnName("valorFrete");
        decimalColumn13.setHeaderColumnName("Valor Frete");
        decimalColumn13.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn13.setDecimals(2);
        gridControl1.getColumnContainer().add(decimalColumn13);

        decimalColumn14.setColumnName("taxaComissao");
        decimalColumn14.setDecimals(2);
        decimalColumn14.setHeaderColumnName("Taxa Comissão");
        decimalColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn14);

        decimalColumn15.setColumnName("valorComissao");
        decimalColumn15.setDecimals(2);
        decimalColumn15.setHeaderColumnName("Valor Comissão");
        decimalColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn15);

        decimalColumn16.setColumnName("taxaDesconto");
        decimalColumn16.setDecimals(2);
        decimalColumn16.setHeaderColumnName("Taxa Desconto");
        decimalColumn16.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn16);

        decimalColumn17.setColumnName("valorDesconto");
        decimalColumn17.setDecimals(2);
        decimalColumn17.setHeaderColumnName("Valor Desconto");
        decimalColumn17.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn17);

        decimalColumn18.setColumnName("valorTotal");
        decimalColumn18.setDecimals(2);
        decimalColumn18.setHeaderColumnName("Valor Total");
        decimalColumn18.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn18);

        comboColumn20.setColumnName("situacao");
        comboColumn20.setDomainId("vendaOrcamentoSituacao");
        comboColumn20.setHeaderColumnName("Situação");
        comboColumn20.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(comboColumn20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Orçamento Cabecalho"));
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
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn11;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn20;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn6;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn10;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn8;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn9;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn12;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn13;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn14;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn15;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn16;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn17;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn18;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    // End of variables declaration//GEN-END:variables
}
