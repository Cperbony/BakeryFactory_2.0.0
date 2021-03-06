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

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class VendaRomaneioEntregaDetalhe extends InternalFrame {

    private LookupController colaboradorController;
    private LookupController setorController;
    private VendaRomaneioEntregaDetalheGridController vendasController;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public VendaRomaneioEntregaDetalhe(VendaRomaneioEntregaDetalheController controller) {
        this.setorController = new LookupController();
        this.colaboradorController = new LookupController();
        initComponents();

        form1.setFormController(controller);

        vendasController = new VendaRomaneioEntregaDetalheGridController(this);
        gridControl1.setController(vendasController);
        gridControl1.setGridDataLocator(vendasController);

        /*
         * Configurações do lookup do colaborador
         */
        colaboradorController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ColaboradorVO");
        colaboradorController.addLookup2ParentLink("id", "colaborador.id");
        colaboradorController.addLookup2ParentLink("pessoa.nome", "colaborador.pessoa.nome");
        colaboradorController.setHeaderColumnName("id", "ID");
        colaboradorController.setHeaderColumnName("pessoa.nome", "Nome");
        colaboradorController.setFrameTitle("Importa Colaborador");

        colaboradorController.setVisibleStatusPanel(true);
        colaboradorController.setVisibleColumn("id", true);
        colaboradorController.setVisibleColumn("pessoa.nome", true);
        colaboradorController.setFramePreferedSize(new Dimension(600, 500));

        colaboradorController.setLookupDataLocator(new LookupDataLocatorGenerico(colaboradorController.getLookupValueObjectClassName()));
        codLookupControlEntregador.setLookupController(colaboradorController);

        /*
         * Configurações do lookup da venda
         */
        setorController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        setorController.addLookup2ParentLink("vendaOrcamentoCabecalho", "vendaOrcamentoCabecalho");
        setorController.addLookup2ParentLink("vendaCondicoesPagamento", "vendaCondicoesPagamento");
        setorController.addLookup2ParentLink("cliente", "cliente");
        setorController.addLookup2ParentLink("vendedor", "vendedor");
        setorController.addLookup2ParentLink("notaFiscalTipo", "notaFiscalTipo");
        setorController.addLookup2ParentLink("transportadora", "transportadora");
        setorController.addLookup2ParentLink("vendaRomaneioEntrega", "vendaRomaneioEntrega");
        setorController.addLookup2ParentLink("id", "id");
        setorController.addLookup2ParentLink("dataVenda", "dataVenda");
        setorController.addLookup2ParentLink("dataSaida", "dataSaida");
        setorController.addLookup2ParentLink("horaSaida", "horaSaida");
        setorController.addLookup2ParentLink("numeroFatura", "numeroFatura");
        setorController.addLookup2ParentLink("localEntrega", "localEntrega");
        setorController.addLookup2ParentLink("localCobranca", "localCobranca");
        setorController.addLookup2ParentLink("valorSubtotal", "valorSubtotal");
        setorController.addLookup2ParentLink("taxaComissao", "taxaComissao");
        setorController.addLookup2ParentLink("valorComissao", "valorComissao");
        setorController.addLookup2ParentLink("taxaDesconto", "taxaDesconto");
        setorController.addLookup2ParentLink("valorDesconto", "valorDesconto");
        setorController.addLookup2ParentLink("valorTotal", "valorTotal");
        setorController.addLookup2ParentLink("tipoFrete", "tipoFrete");
        setorController.addLookup2ParentLink("formaPagamento", "formaPagamento");
        setorController.addLookup2ParentLink("valorFrete", "valorFrete");
        setorController.addLookup2ParentLink("valorSeguro", "valorSeguro");
        setorController.addLookup2ParentLink("observacao", "observacao");
        setorController.addLookup2ParentLink("situacao", "situacao");

        setorController.setHeaderColumnName("numeroFatura", "Número Fatura");
        setorController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        setorController.setHeaderColumnName("dataVenda", "Data Venda");
        setorController.setHeaderColumnName("valorTotal", "Valor Total");
        setorController.setFrameTitle("Importa Venda");

        setorController.setVisibleStatusPanel(true);
        setorController.setVisibleColumn("numeroFatura", true);
        setorController.setVisibleColumn("cliente.pessoa.nome", true);
        setorController.setVisibleColumn("dataVenda", true);
        setorController.setVisibleColumn("valorTotal", true);
        setorController.setFramePreferedSize(new Dimension(600, 500));

        setorController.setLookupDataLocator(new LookupDataLocatorGenerico(setorController.getLookupValueObjectClassName()));
        codLookupColumnNumFatura.setLookupController(setorController);

    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public org.openswing.swing.client.GridControl getGridControl1() {
        return gridControl1;
    }

    public VendaRomaneioEntregaDetalheGridController getVendasController() {
        return vendasController;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        editButtonEntrega = new org.openswing.swing.client.EditButton();
        reloadButtonEntrega = new org.openswing.swing.client.ReloadButton();
        saveButtonEntrega = new org.openswing.swing.client.SaveButton();
        form1 = new org.openswing.swing.form.client.Form();
        lblEntregador = new org.openswing.swing.client.LabelControl();
        codLookupControlEntregador = new org.openswing.swing.client.CodLookupControl();
        textControlEntregador = new org.openswing.swing.client.TextControl();
        lblDescricao = new org.openswing.swing.client.LabelControl();
        textControlDescricao = new org.openswing.swing.client.TextControl();
        lblDataEmissao = new org.openswing.swing.client.LabelControl();
        dateControlEmissao = new org.openswing.swing.client.DateControl();
        lblPrevista = new org.openswing.swing.client.LabelControl();
        dateControlPrevista = new org.openswing.swing.client.DateControl();
        lblSaida = new org.openswing.swing.client.LabelControl();
        dateControlDataSaida = new org.openswing.swing.client.DateControl();
        lblSituacao = new org.openswing.swing.client.LabelControl();
        cbControlSituacao = new org.openswing.swing.client.ComboBoxControl();
        lblEncerramento = new org.openswing.swing.client.LabelControl();
        dateControlEncerramento = new org.openswing.swing.client.DateControl();
        lblObservacao = new org.openswing.swing.client.LabelControl();
        textAreaControlObs = new org.openswing.swing.client.TextAreaControl();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        insertButtonVinculadas = new org.openswing.swing.client.InsertButton();
        deleteButtonVinculadas = new org.openswing.swing.client.DeleteButton();
        saveButtonVinculadas = new org.openswing.swing.client.SaveButton();
        reloadButtonVinculadas = new org.openswing.swing.client.ReloadButton();
        navigatorBarVinculadas = new org.openswing.swing.client.NavigatorBar();
        gridControl1 = new org.openswing.swing.client.GridControl();
        codLookupColumnNumFatura = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumnCliente = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumnDataVenda = new org.openswing.swing.table.columns.client.DateColumn();
        decimalColumnVlrTotal = new org.openswing.swing.table.columns.client.DecimalColumn();

        setTitle("Bakery Factory - Vendas e Faturamento");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Romaneio Entrega"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButtonEntrega);
        jPanel1.add(reloadButtonEntrega);
        jPanel1.add(saveButtonEntrega);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.vendas.java.VendaRomaneioEntregaVO");
        form1.setEditButton(editButtonEntrega);
        form1.setFunctionId("vendaRomaneioEntrega");
        form1.setInsertButton(insertButtonVinculadas);
        form1.setSaveButton(saveButtonEntrega);
        form1.setLayout(new java.awt.GridBagLayout());

        lblEntregador.setText("Entregador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblEntregador, gridBagConstraints);

        codLookupControlEntregador.setAllowOnlyNumbers(true);
        codLookupControlEntregador.setAttributeName("colaborador.id");
        codLookupControlEntregador.setEnabled(false);
        codLookupControlEntregador.setLinkLabel(lblEntregador);
        codLookupControlEntregador.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -60;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlEntregador, gridBagConstraints);

        textControlEntregador.setAttributeName("colaborador.pessoa.nome");
        textControlEntregador.setEnabled(false);
        textControlEntregador.setEnabledOnEdit(false);
        textControlEntregador.setEnabledOnInsert(false);
        textControlEntregador.setLinkLabel(lblEntregador);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlEntregador, gridBagConstraints);

        lblDescricao.setText("Descrição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDescricao, gridBagConstraints);

        textControlDescricao.setAttributeName("descricao");
        textControlDescricao.setEnabled(false);
        textControlDescricao.setLinkLabel(lblDescricao);
        textControlDescricao.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlDescricao, gridBagConstraints);

        lblDataEmissao.setText("Data Emissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDataEmissao, gridBagConstraints);

        dateControlEmissao.setAttributeName("dataEmissao");
        dateControlEmissao.setEnabled(false);
        dateControlEmissao.setLinkLabel(lblDataEmissao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControlEmissao, gridBagConstraints);

        lblPrevista.setLabel("Data Prevista:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPrevista, gridBagConstraints);

        dateControlPrevista.setAttributeName("dataPrevista");
        dateControlPrevista.setEnabled(false);
        dateControlPrevista.setLinkLabel(lblPrevista);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControlPrevista, gridBagConstraints);

        lblSaida.setText("Data Saída:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSaida, gridBagConstraints);

        dateControlDataSaida.setAttributeName("dataSaida");
        dateControlDataSaida.setEnabled(false);
        dateControlDataSaida.setLinkLabel(lblSaida);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControlDataSaida, gridBagConstraints);

        lblSituacao.setText("Situação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSituacao, gridBagConstraints);

        cbControlSituacao.setAttributeName("situacao");
        cbControlSituacao.setDomainId("vendaRomaneioSituacao");
        cbControlSituacao.setEnabled(false);
        cbControlSituacao.setLinkLabel(lblSituacao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(cbControlSituacao, gridBagConstraints);

        lblEncerramento.setLabel("Data Encerramento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblEncerramento, gridBagConstraints);

        dateControlEncerramento.setAttributeName("dataEncerramento");
        dateControlEncerramento.setEnabled(false);
        dateControlEncerramento.setLinkLabel(lblEncerramento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControlEncerramento, gridBagConstraints);

        lblObservacao.setText("Observação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblObservacao, gridBagConstraints);

        textAreaControlObs.setAttributeName("observacao");
        textAreaControlObs.setEnabled(false);
        textAreaControlObs.setLinkLabel(lblObservacao);
        textAreaControlObs.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textAreaControlObs, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendas Vinculadas"));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel3.add(insertButtonVinculadas);
        jPanel3.add(deleteButtonVinculadas);
        jPanel3.add(saveButtonVinculadas);
        jPanel3.add(reloadButtonVinculadas);
        jPanel3.add(navigatorBarVinculadas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        gridControl1.setAutoLoadData(false);
        gridControl1.setDeleteButton(deleteButtonVinculadas);
        gridControl1.setFunctionId("vendaCabecalho");
        gridControl1.setInsertButton(insertButtonVinculadas);
        gridControl1.setInsertRowsOnTop(false);
        gridControl1.setNavBar(navigatorBarVinculadas);
        gridControl1.setReloadButton(reloadButtonVinculadas);
        gridControl1.setSaveButton(saveButtonVinculadas);
        gridControl1.setValueObjectClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumnNumFatura.setAllowOnlyNumbers(true);
        codLookupColumnNumFatura.setColumnName("numeroFatura");
        codLookupColumnNumFatura.setEditableOnEdit(true);
        codLookupColumnNumFatura.setEditableOnInsert(true);
        codLookupColumnNumFatura.setHeaderColumnName("Número Fatura");
        codLookupColumnNumFatura.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(codLookupColumnNumFatura);

        textColumnCliente.setColumnName("cliente.pessoa.nome");
        textColumnCliente.setHeaderColumnName("Cliente");
        textColumnCliente.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumnCliente.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumnCliente);

        dateColumnDataVenda.setColumnName("dataVenda");
        dateColumnDataVenda.setHeaderColumnName("Data Venda");
        dateColumnDataVenda.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(dateColumnDataVenda);

        decimalColumnVlrTotal.setColumnName("valorTotal");
        decimalColumnVlrTotal.setDecimals(2);
        decimalColumnVlrTotal.setHeaderColumnName("Valor Total");
        decimalColumnVlrTotal.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumnVlrTotal);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControl1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.ComboBoxControl cbControlSituacao;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumnNumFatura;
    private org.openswing.swing.client.CodLookupControl codLookupControlEntregador;
    private org.openswing.swing.table.columns.client.DateColumn dateColumnDataVenda;
    private org.openswing.swing.client.DateControl dateControlDataSaida;
    private org.openswing.swing.client.DateControl dateControlEmissao;
    private org.openswing.swing.client.DateControl dateControlEncerramento;
    private org.openswing.swing.client.DateControl dateControlPrevista;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumnVlrTotal;
    private org.openswing.swing.client.DeleteButton deleteButtonVinculadas;
    private org.openswing.swing.client.EditButton editButtonEntrega;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButtonVinculadas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private org.openswing.swing.client.LabelControl lblDataEmissao;
    private org.openswing.swing.client.LabelControl lblDescricao;
    private org.openswing.swing.client.LabelControl lblEncerramento;
    private org.openswing.swing.client.LabelControl lblEntregador;
    private org.openswing.swing.client.LabelControl lblObservacao;
    private org.openswing.swing.client.LabelControl lblPrevista;
    private org.openswing.swing.client.LabelControl lblSaida;
    private org.openswing.swing.client.LabelControl lblSituacao;
    private org.openswing.swing.client.NavigatorBar navigatorBarVinculadas;
    private org.openswing.swing.client.ReloadButton reloadButtonEntrega;
    private org.openswing.swing.client.ReloadButton reloadButtonVinculadas;
    private org.openswing.swing.client.SaveButton saveButtonEntrega;
    private org.openswing.swing.client.SaveButton saveButtonVinculadas;
    private org.openswing.swing.client.TextAreaControl textAreaControlObs;
    private org.openswing.swing.table.columns.client.TextColumn textColumnCliente;
    private org.openswing.swing.client.TextControl textControlDescricao;
    private org.openswing.swing.client.TextControl textControlEntregador;
    // End of variables declaration//GEN-END:variables
}
