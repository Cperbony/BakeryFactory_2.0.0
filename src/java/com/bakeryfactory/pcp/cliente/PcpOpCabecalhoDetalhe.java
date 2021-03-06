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

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class PcpOpCabecalhoDetalhe extends InternalFrame {

    private PcpOpDetalheGridController detalheController;
    private PcpInstrucaoOpGridController instrucaoOpController;
    private LookupController produtoController;
    private LookupController instrucaoController;

    /**
     * Creates new form TempGrid
     *
     * @param controller
     */
    public PcpOpCabecalhoDetalhe(PcpOpCabecalhoDetalheController controller) {
        this.produtoController = new LookupController();
        this.instrucaoController = new LookupController();
        initComponents();

        form1.setFormController(controller);

        detalheController = new PcpOpDetalheGridController(this);
        gridControlProdutos.setController(detalheController);
        gridControlProdutos.setGridDataLocator(detalheController);

        instrucaoOpController = new PcpInstrucaoOpGridController(this);
        gridControlInstrucoes.setController(instrucaoOpController);
        gridControlInstrucoes.setGridDataLocator(instrucaoOpController);

        /*
         * Configurações do lookup do produto
         */
        produtoController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ProdutoVO");
        produtoController.addLookup2ParentLink("id", "produto.id");
        produtoController.addLookup2ParentLink("nome", "produto.nome");
        produtoController.setHeaderColumnName("id", "ID");
        produtoController.setHeaderColumnName("nome", "Nome");
        produtoController.setFrameTitle("Importa Produto");

        produtoController.setVisibleStatusPanel(true);
        produtoController.setVisibleColumn("id", true);
        produtoController.setVisibleColumn("nome", true);
        produtoController.setFramePreferedSize(new Dimension(600, 500));

        produtoController.setLookupDataLocator(new LookupDataLocatorGenerico(produtoController.getLookupValueObjectClassName()));
        codLookupProduto.setLookupController(produtoController);

        /*
         * Configurações do lookup da instrucao
         */
        instrucaoController.setLookupValueObjectClassName("com.bakeryfactory.pcp.java.PcpInstrucaoVO");
        instrucaoController.addLookup2ParentLink("id", "pcpInstrucao.id");
        instrucaoController.addLookup2ParentLink("codigo", "pcpInstrucao.codigo");
        instrucaoController.addLookup2ParentLink("descricao", "pcpInstrucao.descricao");
        instrucaoController.setHeaderColumnName("codigo", "Codigo");
        instrucaoController.setHeaderColumnName("descricao", "Nome");
        instrucaoController.setFrameTitle("Importa Instrucao");

        instrucaoController.setVisibleStatusPanel(true);
        instrucaoController.setVisibleColumn("codigo", true);
        instrucaoController.setVisibleColumn("descricao", true);
        instrucaoController.setFramePreferedSize(new Dimension(600, 500));

        instrucaoController.setLookupDataLocator(new LookupDataLocatorGenerico(instrucaoController.getLookupValueObjectClassName()));
        codLookupInstrucao.setLookupController(instrucaoController);
    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public PcpOpDetalheGridController getDetalheController() {
        return detalheController;
    }

    public PcpInstrucaoOpGridController getInstrucaoOpController() {
        return instrucaoOpController;
    }

    /**
     *
     * @return GRID de Produtos
     */
    public org.openswing.swing.client.GridControl getGridProdutos() {
        return gridControlProdutos;
    }

    /**
     *
     * @return GRID de Instruções
     */
    public org.openswing.swing.client.GridControl getGridInstrucoes() {
        return gridControlInstrucoes;
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelOrdemProd = new javax.swing.JPanel();
        editButtonOrdemProd = new org.openswing.swing.client.EditButton();
        reloadButtonOrdemProd = new org.openswing.swing.client.ReloadButton();
        saveButtonOrdemProd = new org.openswing.swing.client.SaveButton();
        form1 = new org.openswing.swing.form.client.Form();
        lblInicio = new org.openswing.swing.client.LabelControl();
        dateControl3 = new org.openswing.swing.client.DateControl();
        lblPrevisaoEntrega = new org.openswing.swing.client.LabelControl();
        dateControl4 = new org.openswing.swing.client.DateControl();
        lblTermino = new org.openswing.swing.client.LabelControl();
        dateControl5 = new org.openswing.swing.client.DateControl();
        lblCustoTotalPrevisto = new org.openswing.swing.client.LabelControl();
        numericControl6 = new org.openswing.swing.client.NumericControl();
        lblCustoTotalRealizado = new org.openswing.swing.client.LabelControl();
        numericControl7 = new org.openswing.swing.client.NumericControl();
        lblPercentualVenda = new org.openswing.swing.client.LabelControl();
        numericControl8 = new org.openswing.swing.client.NumericControl();
        lblPercentualEstoque = new org.openswing.swing.client.LabelControl();
        numericControl9 = new org.openswing.swing.client.NumericControl();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanelProduto = new javax.swing.JPanel();
        insertButtonProduto = new org.openswing.swing.client.InsertButton();
        editButtonProduto = new org.openswing.swing.client.EditButton();
        deleteButtonProduto = new org.openswing.swing.client.DeleteButton();
        saveButtonProduto = new org.openswing.swing.client.SaveButton();
        reloadButtonProduto = new org.openswing.swing.client.ReloadButton();
        navigatorBarProduto = new org.openswing.swing.client.NavigatorBar();
        gridControlProdutos = new org.openswing.swing.client.GridControl();
        codLookupProduto = new org.openswing.swing.table.columns.client.CodLookupColumn();
        decimalColumn4 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn5 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn6 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        jPanel4 = new javax.swing.JPanel();
        jPanelInstrucoes = new javax.swing.JPanel();
        insertButtonInstrucoes = new org.openswing.swing.client.InsertButton();
        editButtonInstrucoes = new org.openswing.swing.client.EditButton();
        deleteButtonInstrucoes = new org.openswing.swing.client.DeleteButton();
        saveButtonInstrucoes = new org.openswing.swing.client.SaveButton();
        reloadButtonInstrucoes = new org.openswing.swing.client.ReloadButton();
        navigatorBarInstrucoes = new org.openswing.swing.client.NavigatorBar();
        gridControlInstrucoes = new org.openswing.swing.client.GridControl();
        codLookupInstrucao = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn1 = new org.openswing.swing.table.columns.client.TextColumn();

        setTitle("Bakery Factory - PCP");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelOrdemProd.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordem de Produção"));
        jPanelOrdemProd.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));
        jPanelOrdemProd.add(editButtonOrdemProd);
        jPanelOrdemProd.add(reloadButtonOrdemProd);
        jPanelOrdemProd.add(saveButtonOrdemProd);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelOrdemProd, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.pcp.java.PcpOpCabecalhoVO");
        form1.setEditButton(editButtonOrdemProd);
        form1.setFunctionId("pcpOpCabecalho");
        form1.setReloadButton(reloadButtonOrdemProd);
        form1.setSaveButton(saveButtonOrdemProd);
        form1.setLayout(new java.awt.GridBagLayout());

        lblInicio.setText("Início:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblInicio, gridBagConstraints);

        dateControl3.setAttributeName("inicio");
        dateControl3.setEnabled(false);
        dateControl3.setLinkLabel(lblInicio);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl3, gridBagConstraints);

        lblPrevisaoEntrega.setText("Previsão Entrega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPrevisaoEntrega, gridBagConstraints);

        dateControl4.setAttributeName("previsaoEntrega");
        dateControl4.setEnabled(false);
        dateControl4.setLinkLabel(lblPrevisaoEntrega);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl4, gridBagConstraints);

        lblTermino.setText("Término:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTermino, gridBagConstraints);

        dateControl5.setAttributeName("termino");
        dateControl5.setEnabled(false);
        dateControl5.setLinkLabel(lblTermino);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl5, gridBagConstraints);

        lblCustoTotalPrevisto.setLabel("Custo Total Previsto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblCustoTotalPrevisto, gridBagConstraints);

        numericControl6.setAttributeName("custoTotalPrevisto");
        numericControl6.setDecimals(2);
        numericControl6.setEnabled(false);
        numericControl6.setLinkLabel(lblCustoTotalPrevisto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl6, gridBagConstraints);

        lblCustoTotalRealizado.setLabel("Custo Total Realizado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblCustoTotalRealizado, gridBagConstraints);

        numericControl7.setAttributeName("custoTotalRealizado");
        numericControl7.setDecimals(2);
        numericControl7.setEnabled(false);
        numericControl7.setLinkLabel(lblCustoTotalRealizado);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl7, gridBagConstraints);

        lblPercentualVenda.setText("Percentual p/ Venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPercentualVenda, gridBagConstraints);

        numericControl8.setAttributeName("porcentoVenda");
        numericControl8.setDecimals(2);
        numericControl8.setEnabled(false);
        numericControl8.setLinkLabel(lblPercentualVenda);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl8, gridBagConstraints);

        lblPercentualEstoque.setText("Percentual p/ Estoque:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPercentualEstoque, gridBagConstraints);

        numericControl9.setAttributeName("porcentoEstoque");
        numericControl9.setDecimals(2);
        numericControl9.setEnabled(false);
        numericControl9.setLinkLabel(lblPercentualEstoque);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanelProduto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelProduto.add(insertButtonProduto);
        jPanelProduto.add(editButtonProduto);
        jPanelProduto.add(deleteButtonProduto);
        jPanelProduto.add(saveButtonProduto);
        jPanelProduto.add(reloadButtonProduto);
        jPanelProduto.add(navigatorBarProduto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanelProduto, gridBagConstraints);

        gridControlProdutos.setAutoLoadData(false);
        gridControlProdutos.setDeleteButton(deleteButtonProduto);
        gridControlProdutos.setEditButton(editButtonProduto);
        gridControlProdutos.setFunctionId("pcpOpDetalhe");
        gridControlProdutos.setInsertButton(insertButtonProduto);
        gridControlProdutos.setNavBar(navigatorBarProduto);
        gridControlProdutos.setReloadButton(reloadButtonProduto);
        gridControlProdutos.setSaveButton(saveButtonProduto);
        gridControlProdutos.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpOpDetalheVO");
        gridControlProdutos.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupProduto.setColumnName("produto.nome");
        codLookupProduto.setEditableOnEdit(true);
        codLookupProduto.setEditableOnInsert(true);
        codLookupProduto.setHeaderColumnName("Produto");
        codLookupProduto.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupProduto.setPreferredWidth(250);
        gridControlProdutos.getColumnContainer().add(codLookupProduto);

        decimalColumn4.setColumnName("quantidadeProduzir");
        decimalColumn4.setDecimals(2);
        decimalColumn4.setEditableOnEdit(true);
        decimalColumn4.setEditableOnInsert(true);
        decimalColumn4.setHeaderColumnName("Qtde Produzir");
        decimalColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlProdutos.getColumnContainer().add(decimalColumn4);

        decimalColumn5.setColumnName("quantidadeProduzida");
        decimalColumn5.setColumnRequired(false);
        decimalColumn5.setDecimals(2);
        decimalColumn5.setEditableOnEdit(true);
        decimalColumn5.setEditableOnInsert(true);
        decimalColumn5.setHeaderColumnName("Qtde Produzida");
        decimalColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlProdutos.getColumnContainer().add(decimalColumn5);

        decimalColumn6.setColumnName("quantidadeEntregue");
        decimalColumn6.setColumnRequired(false);
        decimalColumn6.setDecimals(2);
        decimalColumn6.setEditableOnEdit(true);
        decimalColumn6.setEditableOnInsert(true);
        decimalColumn6.setHeaderColumnName("Qtde Entregue");
        decimalColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlProdutos.getColumnContainer().add(decimalColumn6);

        decimalColumn7.setColumnName("custoPrevisto");
        decimalColumn7.setColumnRequired(false);
        decimalColumn7.setDecimals(2);
        decimalColumn7.setEditableOnEdit(true);
        decimalColumn7.setEditableOnInsert(true);
        decimalColumn7.setHeaderColumnName("Custo Previsto");
        decimalColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlProdutos.getColumnContainer().add(decimalColumn7);

        decimalColumn8.setColumnName("custoRealizado");
        decimalColumn8.setColumnRequired(false);
        decimalColumn8.setDecimals(2);
        decimalColumn8.setEditableOnEdit(true);
        decimalColumn8.setEditableOnInsert(true);
        decimalColumn8.setHeaderColumnName("Custo Realizado");
        decimalColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlProdutos.getColumnContainer().add(decimalColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControlProdutos, gridBagConstraints);

        jTabbedPane1.addTab("Produtos", jPanel2);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanelInstrucoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelInstrucoes.add(insertButtonInstrucoes);
        jPanelInstrucoes.add(editButtonInstrucoes);
        jPanelInstrucoes.add(deleteButtonInstrucoes);
        jPanelInstrucoes.add(saveButtonInstrucoes);
        jPanelInstrucoes.add(reloadButtonInstrucoes);
        jPanelInstrucoes.add(navigatorBarInstrucoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanelInstrucoes, gridBagConstraints);

        gridControlInstrucoes.setAutoLoadData(false);
        gridControlInstrucoes.setDeleteButton(deleteButtonInstrucoes);
        gridControlInstrucoes.setEditButton(editButtonInstrucoes);
        gridControlInstrucoes.setFunctionId("pcpInstrucaoOp");
        gridControlInstrucoes.setInsertButton(insertButtonInstrucoes);
        gridControlInstrucoes.setNavBar(navigatorBarInstrucoes);
        gridControlInstrucoes.setReloadButton(reloadButtonInstrucoes);
        gridControlInstrucoes.setSaveButton(saveButtonInstrucoes);
        gridControlInstrucoes.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpInstrucaoOpVO");
        gridControlInstrucoes.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupInstrucao.setColumnName("pcpInstrucao.codigo");
        codLookupInstrucao.setEditableOnEdit(true);
        codLookupInstrucao.setEditableOnInsert(true);
        codLookupInstrucao.setHeaderColumnName("Código");
        codLookupInstrucao.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlInstrucoes.getColumnContainer().add(codLookupInstrucao);

        textColumn1.setAdditionalHeaderColumnName("Descrição");
        textColumn1.setColumnName("pcpInstrucao.descricao");
        textColumn1.setEditableOnEdit(true);
        textColumn1.setEditableOnInsert(true);
        textColumn1.setHeaderColumnName("Descrição");
        textColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn1.setPreferredWidth(400);
        gridControlInstrucoes.getColumnContainer().add(textColumn1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(gridControlInstrucoes, gridBagConstraints);

        jTabbedPane1.addTab("Instruções", jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupInstrucao;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupProduto;
    private org.openswing.swing.client.DateControl dateControl3;
    private org.openswing.swing.client.DateControl dateControl4;
    private org.openswing.swing.client.DateControl dateControl5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn4;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn6;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.client.DeleteButton deleteButtonInstrucoes;
    private org.openswing.swing.client.DeleteButton deleteButtonProduto;
    private org.openswing.swing.client.EditButton editButtonInstrucoes;
    private org.openswing.swing.client.EditButton editButtonOrdemProd;
    private org.openswing.swing.client.EditButton editButtonProduto;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControlInstrucoes;
    private org.openswing.swing.client.GridControl gridControlProdutos;
    private org.openswing.swing.client.InsertButton insertButtonInstrucoes;
    private org.openswing.swing.client.InsertButton insertButtonProduto;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelInstrucoes;
    private javax.swing.JPanel jPanelOrdemProd;
    private javax.swing.JPanel jPanelProduto;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl lblCustoTotalPrevisto;
    private org.openswing.swing.client.LabelControl lblCustoTotalRealizado;
    private org.openswing.swing.client.LabelControl lblInicio;
    private org.openswing.swing.client.LabelControl lblPercentualEstoque;
    private org.openswing.swing.client.LabelControl lblPercentualVenda;
    private org.openswing.swing.client.LabelControl lblPrevisaoEntrega;
    private org.openswing.swing.client.LabelControl lblTermino;
    private org.openswing.swing.client.NavigatorBar navigatorBarInstrucoes;
    private org.openswing.swing.client.NavigatorBar navigatorBarProduto;
    private org.openswing.swing.client.NumericControl numericControl6;
    private org.openswing.swing.client.NumericControl numericControl7;
    private org.openswing.swing.client.NumericControl numericControl8;
    private org.openswing.swing.client.NumericControl numericControl9;
    private org.openswing.swing.client.ReloadButton reloadButtonInstrucoes;
    private org.openswing.swing.client.ReloadButton reloadButtonOrdemProd;
    private org.openswing.swing.client.ReloadButton reloadButtonProduto;
    private org.openswing.swing.client.SaveButton saveButtonInstrucoes;
    private org.openswing.swing.client.SaveButton saveButtonOrdemProd;
    private org.openswing.swing.client.SaveButton saveButtonProduto;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    // End of variables declaration//GEN-END:variables
}
