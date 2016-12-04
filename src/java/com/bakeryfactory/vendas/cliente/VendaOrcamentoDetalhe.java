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
public class VendaOrcamentoDetalhe extends InternalFrame {

    private VendaOrcamentoDetalheGridController gridController;
    private VendaOrcamentoDetalheController controller;

    private LookupController vendedorController;
    private LookupController clienteController;
    private LookupController transportadoraController;
    private LookupController condicoesPagamentoController;
    private LookupController produtoController;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public VendaOrcamentoDetalhe(VendaOrcamentoDetalheController controller) {
        this.produtoController = new LookupController();
        this.condicoesPagamentoController = new LookupController();
        this.transportadoraController = new LookupController();
        this.clienteController = new LookupController();
        this.vendedorController = new LookupController();
        initComponents();

        this.controller = controller;

        form1.setFormController(controller);

        gridController = new VendaOrcamentoDetalheGridController(this);
        gridControl1.setController(gridController);
        gridControl1.setGridDataLocator(gridController);

/*
         * Configurações do lookup do vendedor
         */
        vendedorController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.VendedorVO");
        vendedorController.addLookup2ParentLink("id", "vendedor.id");
        vendedorController.addLookup2ParentLink("colaborador.pessoa.nome", "vendedor.colaborador.pessoa.nome");
        vendedorController.addLookup2ParentLink("comissao", "taxaComissao");
        vendedorController.setHeaderColumnName("id", "ID");
        vendedorController.setHeaderColumnName("colaborador.pessoa.nome", "Nome");
        vendedorController.setHeaderColumnName("comissao", "Comissão");
        vendedorController.setFrameTitle("Importa Vendedor");

        vendedorController.setVisibleStatusPanel(true);
        vendedorController.setVisibleColumn("id", true);
        vendedorController.setVisibleColumn("colaborador.pessoa.nome", true);
        vendedorController.setVisibleColumn("comissao", true);
        vendedorController.setFramePreferedSize(new Dimension(600, 500));

        vendedorController.setLookupDataLocator(new LookupDataLocatorGenerico(vendedorController.getLookupValueObjectClassName()));
        codLookupControlVendedor.setLookupController(vendedorController);

        /*
         * Configurações do lookup do cliente
         */
        clienteController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ClienteVO");
        clienteController.addLookup2ParentLink("id", "cliente.id");
        clienteController.addLookup2ParentLink("pessoa.nome", "cliente.pessoa.nome");
        clienteController.setHeaderColumnName("id", "ID");
        clienteController.setHeaderColumnName("cliente.pessoa.nome", "Nome");
        clienteController.setFrameTitle("Importa Dados Cliente");

        clienteController.setVisibleStatusPanel(true);
        clienteController.setVisibleColumn("id", true);
        clienteController.setVisibleColumn("nome", true);
        clienteController.setFramePreferedSize(new Dimension(600, 500));

        clienteController.setLookupDataLocator(new LookupDataLocatorGenerico(clienteController.getLookupValueObjectClassName()));
        codLookupControlCliente.setLookupController(clienteController);

        /*
         * Configurações do lookup da transportadora
         */
        transportadoraController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.TransportadoraVO");
        transportadoraController.addLookup2ParentLink("id", "transportadora.id");
        transportadoraController.addLookup2ParentLink("pessoa.nome", "transportadora.pessoa.nome");
        transportadoraController.setHeaderColumnName("id", "ID");
        transportadoraController.setHeaderColumnName("pessoa.nome", "Nome");
        transportadoraController.setFrameTitle("Importa Transportadora");

        transportadoraController.setVisibleStatusPanel(true);
        transportadoraController.setVisibleColumn("id", true);
        transportadoraController.setVisibleColumn("pessoa.nome", true);
        transportadoraController.setFramePreferedSize(new Dimension(600, 500));

        transportadoraController.setLookupDataLocator(new LookupDataLocatorGenerico(transportadoraController.getLookupValueObjectClassName()));
        codLookupControlTransportadora.setLookupController(transportadoraController);

        /*
         * Configurações do lookup da condicao de pagamento
         */
        condicoesPagamentoController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCondicoesPagamentoVO");
        condicoesPagamentoController.addLookup2ParentLink("id", "vendaCondicoesPagamento.id");
        condicoesPagamentoController.addLookup2ParentLink("nome", "vendaCondicoesPagamento.nome");
        condicoesPagamentoController.setHeaderColumnName("id", "ID");
        condicoesPagamentoController.setHeaderColumnName("nome", "Nome");
        condicoesPagamentoController.setFrameTitle("Importa Condições de Pagamento");

        condicoesPagamentoController.setVisibleStatusPanel(true);
        condicoesPagamentoController.setVisibleColumn("id", true);
        condicoesPagamentoController.setVisibleColumn("nome", true);
        condicoesPagamentoController.setFramePreferedSize(new Dimension(600, 500));

        condicoesPagamentoController.setLookupDataLocator(new LookupDataLocatorGenerico(condicoesPagamentoController.getLookupValueObjectClassName()));
        codLookupControlCondicaoPgto.setLookupController(condicoesPagamentoController);

        /*
         * Configurações do lookup do produto
         */
        produtoController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ProdutoVO");
        produtoController.addLookup2ParentLink("id", "produto.id");
        produtoController.addLookup2ParentLink("nome", "produto.nome");
        produtoController.addLookup2ParentLink("valorVenda", "valorUnitario");
        produtoController.setHeaderColumnName("id", "ID");
        produtoController.setHeaderColumnName("nome", "Nome");
        produtoController.setHeaderColumnName("valorVenda", "Valor");
        produtoController.setFrameTitle("Importa Produto");

        produtoController.setVisibleStatusPanel(true);
        produtoController.setVisibleColumn("id", true);
        produtoController.setVisibleColumn("nome", true);
        produtoController.setVisibleColumn("valorVenda", true);
        produtoController.setFramePreferedSize(new Dimension(600, 500));

        produtoController.setLookupDataLocator(new LookupDataLocatorGenerico(produtoController.getLookupValueObjectClassName()));
        codLookupColumnProduto.setLookupController(produtoController);

    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public VendaOrcamentoDetalheController getFormController() {
        return controller;
    }

    public VendaOrcamentoDetalheGridController getGridController() {
        return gridController;
    }

    public org.openswing.swing.client.GridControl getGridControl1() {
        return gridControl1;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelVendaOrcamentoCab = new javax.swing.JPanel();
        editButtonOrcamentoCab = new org.openswing.swing.client.EditButton();
        reloadButtonOrcamentoCab = new org.openswing.swing.client.ReloadButton();
        saveButtonOrcamentoCab = new org.openswing.swing.client.SaveButton();
        form1 = new org.openswing.swing.form.client.Form();
        lblCondPagto = new org.openswing.swing.client.LabelControl();
        codLookupControlCondicaoPgto = new org.openswing.swing.client.CodLookupControl();
        textControlCondPgto = new org.openswing.swing.client.TextControl();
        lblVendedor = new org.openswing.swing.client.LabelControl();
        codLookupControlVendedor = new org.openswing.swing.client.CodLookupControl();
        textControlVendedor = new org.openswing.swing.client.TextControl();
        lblTransportadora = new org.openswing.swing.client.LabelControl();
        codLookupControlTransportadora = new org.openswing.swing.client.CodLookupControl();
        textControlTransportadora = new org.openswing.swing.client.TextControl();
        lblCliente = new org.openswing.swing.client.LabelControl();
        codLookupControlCliente = new org.openswing.swing.client.CodLookupControl();
        textControlCliente = new org.openswing.swing.client.TextControl();
        lblTipo = new org.openswing.swing.client.LabelControl();
        comboBoxControl6 = new org.openswing.swing.client.ComboBoxControl();
        lblCodigo = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        lblDataCadastro = new org.openswing.swing.client.LabelControl();
        dateControl8 = new org.openswing.swing.client.DateControl();
        lblDataEntrega = new org.openswing.swing.client.LabelControl();
        dateControl9 = new org.openswing.swing.client.DateControl();
        lblValidade = new org.openswing.swing.client.LabelControl();
        dateControl10 = new org.openswing.swing.client.DateControl();
        lblTipoFrete = new org.openswing.swing.client.LabelControl();
        comboBoxControl11 = new org.openswing.swing.client.ComboBoxControl();
        lblValorSubTotal = new org.openswing.swing.client.LabelControl();
        numControlValorSubTotal = new org.openswing.swing.client.NumericControl();
        lblValorFrete = new org.openswing.swing.client.LabelControl();
        numControlValorFrete = new org.openswing.swing.client.NumericControl();
        lblTaxaComissao = new org.openswing.swing.client.LabelControl();
        numControlTaxaComissao = new org.openswing.swing.client.NumericControl();
        lblValorComissao = new org.openswing.swing.client.LabelControl();
        numControlValorComissao = new org.openswing.swing.client.NumericControl();
        lblTaxaDesconto = new org.openswing.swing.client.LabelControl();
        numControlTaxaDesconto = new org.openswing.swing.client.NumericControl();
        lblValorDesconto = new org.openswing.swing.client.LabelControl();
        numControlValorDesconto = new org.openswing.swing.client.NumericControl();
        lblValorTotal = new org.openswing.swing.client.LabelControl();
        numControlValorTotal = new org.openswing.swing.client.NumericControl();
        lblObservacao = new org.openswing.swing.client.LabelControl();
        lblSituacao = new org.openswing.swing.client.LabelControl();
        cbControlSituacao = new org.openswing.swing.client.ComboBoxControl();
        textAreaControlObserv = new org.openswing.swing.client.TextAreaControl();
        jPanel2 = new javax.swing.JPanel();
        jPanelVendaOrcamentoDet = new javax.swing.JPanel();
        insertButtonOrcamentoDet = new org.openswing.swing.client.InsertButton();
        editButtonOrcamentoDet = new org.openswing.swing.client.EditButton();
        deleteButtonOrcamentoDet = new org.openswing.swing.client.DeleteButton();
        saveButtonOrcamentoDet = new org.openswing.swing.client.SaveButton();
        reloadButtonOrcamentoDet = new org.openswing.swing.client.ReloadButton();
        navigatorBarOrcamentoDet = new org.openswing.swing.client.NavigatorBar();
        gridControl1 = new org.openswing.swing.client.GridControl();
        codLookupColumnProduto = new org.openswing.swing.table.columns.client.CodLookupColumn();
        decimalColumn4 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn5 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn6 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn9 = new org.openswing.swing.table.columns.client.DecimalColumn();

        setTitle("Bakery Factory - Vendas e Faturamento");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelVendaOrcamentoCab.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Orcamento Cabecalho"));
        jPanelVendaOrcamentoCab.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));
        jPanelVendaOrcamentoCab.add(editButtonOrcamentoCab);
        jPanelVendaOrcamentoCab.add(reloadButtonOrcamentoCab);
        jPanelVendaOrcamentoCab.add(saveButtonOrcamentoCab);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelVendaOrcamentoCab, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO");
        form1.setEditButton(editButtonOrcamentoCab);
        form1.setFunctionId("vendaOrcamentoCabecalho");
        form1.setReloadButton(reloadButtonOrcamentoCab);
        form1.setSaveButton(saveButtonOrcamentoCab);
        form1.setLayout(new java.awt.GridBagLayout());

        lblCondPagto.setText("Condição de Pagamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblCondPagto, gridBagConstraints);

        codLookupControlCondicaoPgto.setAllowOnlyNumbers(true);
        codLookupControlCondicaoPgto.setAttributeName("vendaCondicoesPagamento.id");
        codLookupControlCondicaoPgto.setEnabled(false);
        codLookupControlCondicaoPgto.setLinkLabel(lblCondPagto);
        codLookupControlCondicaoPgto.setMaxCharacters(10);
        codLookupControlCondicaoPgto.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlCondicaoPgto, gridBagConstraints);

        textControlCondPgto.setAttributeName("vendaCondicoesPagamento.nome");
        textControlCondPgto.setEnabled(false);
        textControlCondPgto.setEnabledOnEdit(false);
        textControlCondPgto.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlCondPgto, gridBagConstraints);

        lblVendedor.setText("Vendedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblVendedor, gridBagConstraints);

        codLookupControlVendedor.setAllowOnlyNumbers(true);
        codLookupControlVendedor.setAttributeName("vendedor.id");
        codLookupControlVendedor.setEnabled(false);
        codLookupControlVendedor.setLinkLabel(lblVendedor);
        codLookupControlVendedor.setMaxCharacters(10);
        codLookupControlVendedor.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlVendedor, gridBagConstraints);

        textControlVendedor.setAttributeName("vendedor.colaborador.pessoa.nome");
        textControlVendedor.setEnabled(false);
        textControlVendedor.setEnabledOnEdit(false);
        textControlVendedor.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlVendedor, gridBagConstraints);

        lblTransportadora.setText("Transportadora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTransportadora, gridBagConstraints);

        codLookupControlTransportadora.setAllowOnlyNumbers(true);
        codLookupControlTransportadora.setAttributeName("transportadora.id");
        codLookupControlTransportadora.setEnabled(false);
        codLookupControlTransportadora.setLinkLabel(lblTransportadora);
        codLookupControlTransportadora.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlTransportadora, gridBagConstraints);

        textControlTransportadora.setAttributeName("transportadora.pessoa.nome");
        textControlTransportadora.setEnabled(false);
        textControlTransportadora.setEnabledOnEdit(false);
        textControlTransportadora.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlTransportadora, gridBagConstraints);

        lblCliente.setText("Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblCliente, gridBagConstraints);

        codLookupControlCliente.setAllowOnlyNumbers(true);
        codLookupControlCliente.setAttributeName("cliente.id");
        codLookupControlCliente.setEnabled(false);
        codLookupControlCliente.setLinkLabel(lblCliente);
        codLookupControlCliente.setMaxCharacters(10);
        codLookupControlCliente.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlCliente, gridBagConstraints);

        textControlCliente.setAttributeName("cliente.pessoa.nome");
        textControlCliente.setEnabled(false);
        textControlCliente.setEnabledOnEdit(false);
        textControlCliente.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControlCliente, gridBagConstraints);

        lblTipo.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTipo, gridBagConstraints);

        comboBoxControl6.setAttributeName("tipo");
        comboBoxControl6.setDomainId("vendaOrcamentoTipo");
        comboBoxControl6.setEnabled(false);
        comboBoxControl6.setLinkLabel(lblTipo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl6, gridBagConstraints);

        lblCodigo.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblCodigo, gridBagConstraints);

        textControl7.setAttributeName("codigo");
        textControl7.setEnabled(false);
        textControl7.setLinkLabel(lblCodigo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl7, gridBagConstraints);

        lblDataCadastro.setLabel("Data Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDataCadastro, gridBagConstraints);

        dateControl8.setAttributeName("dataCadastro");
        dateControl8.setEnabled(false);
        dateControl8.setLinkLabel(lblDataCadastro);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl8, gridBagConstraints);

        lblDataEntrega.setLabel("Data Entrega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDataEntrega, gridBagConstraints);

        dateControl9.setAttributeName("dataEntrega");
        dateControl9.setEnabled(false);
        dateControl9.setLinkLabel(lblDataEntrega);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl9, gridBagConstraints);

        lblValidade.setLabel("Validade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValidade, gridBagConstraints);

        dateControl10.setAttributeName("validade");
        dateControl10.setEnabled(false);
        dateControl10.setLinkLabel(lblValidade);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl10, gridBagConstraints);

        lblTipoFrete.setLabel("Tipo Frete:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTipoFrete, gridBagConstraints);

        comboBoxControl11.setAttributeName("tipoFrete");
        comboBoxControl11.setDomainId("compraTipoFrete");
        comboBoxControl11.setEnabled(false);
        comboBoxControl11.setLinkLabel(lblTipoFrete);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl11, gridBagConstraints);

        lblValorSubTotal.setLabel("Valor Subtotal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValorSubTotal, gridBagConstraints);

        numControlValorSubTotal.setAttributeName("valorSubtotal");
        numControlValorSubTotal.setDecimals(2);
        numControlValorSubTotal.setEnabled(false);
        numControlValorSubTotal.setEnabledOnEdit(false);
        numControlValorSubTotal.setEnabledOnInsert(false);
        numControlValorSubTotal.setLinkLabel(lblValorSubTotal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlValorSubTotal, gridBagConstraints);

        lblValorFrete.setLabel("Valor Frete:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValorFrete, gridBagConstraints);

        numControlValorFrete.setAttributeName("valorFrete");
        numControlValorFrete.setDecimals(2);
        numControlValorFrete.setEnabled(false);
        numControlValorFrete.setLinkLabel(lblValorFrete);
        numControlValorFrete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numControlValorFreteFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlValorFrete, gridBagConstraints);

        lblTaxaComissao.setText("Taxa Comissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTaxaComissao, gridBagConstraints);

        numControlTaxaComissao.setAttributeName("taxaComissao");
        numControlTaxaComissao.setDecimals(2);
        numControlTaxaComissao.setEnabled(false);
        numControlTaxaComissao.setEnabledOnEdit(false);
        numControlTaxaComissao.setEnabledOnInsert(false);
        numControlTaxaComissao.setLinkLabel(lblTaxaComissao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlTaxaComissao, gridBagConstraints);

        lblValorComissao.setText("Valor Comissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValorComissao, gridBagConstraints);

        numControlValorComissao.setAttributeName("valorComissao");
        numControlValorComissao.setDecimals(2);
        numControlValorComissao.setEnabled(false);
        numControlValorComissao.setEnabledOnEdit(false);
        numControlValorComissao.setEnabledOnInsert(false);
        numControlValorComissao.setLinkLabel(lblValorComissao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlValorComissao, gridBagConstraints);

        lblTaxaDesconto.setLabel("Taxa Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTaxaDesconto, gridBagConstraints);

        numControlTaxaDesconto.setAttributeName("taxaDesconto");
        numControlTaxaDesconto.setDecimals(2);
        numControlTaxaDesconto.setEnabled(false);
        numControlTaxaDesconto.setLinkLabel(lblTaxaComissao);
        numControlTaxaDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numControlTaxaDescontoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlTaxaDesconto, gridBagConstraints);

        lblValorDesconto.setLabel("Valor Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValorDesconto, gridBagConstraints);

        numControlValorDesconto.setAttributeName("valorDesconto");
        numControlValorDesconto.setDecimals(2);
        numControlValorDesconto.setEnabled(false);
        numControlValorDesconto.setEnabledOnEdit(false);
        numControlValorDesconto.setEnabledOnInsert(false);
        numControlValorDesconto.setLinkLabel(lblValorDesconto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlValorDesconto, gridBagConstraints);

        lblValorTotal.setLabel("Valor Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblValorTotal, gridBagConstraints);

        numControlValorTotal.setAttributeName("valorTotal");
        numControlValorTotal.setDecimals(2);
        numControlValorTotal.setEnabled(false);
        numControlValorTotal.setLinkLabel(lblValorTotal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numControlValorTotal, gridBagConstraints);

        lblObservacao.setText("Observação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblObservacao, gridBagConstraints);

        lblSituacao.setText("Situação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSituacao, gridBagConstraints);

        cbControlSituacao.setAttributeName("situacao");
        cbControlSituacao.setDomainId("vendaOrcamentoSituacao");
        cbControlSituacao.setEnabled(false);
        cbControlSituacao.setLinkLabel(lblSituacao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(cbControlSituacao, gridBagConstraints);

        textAreaControlObserv.setAttributeName("observacao");
        textAreaControlObserv.setEnabled(false);
        textAreaControlObserv.setLinkLabel(lblObservacao);
        textAreaControlObserv.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textAreaControlObserv, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanelVendaOrcamentoDet.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Orçamento Detalhe"));
        jPanelVendaOrcamentoDet.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));
        jPanelVendaOrcamentoDet.add(insertButtonOrcamentoDet);
        jPanelVendaOrcamentoDet.add(editButtonOrcamentoDet);
        jPanelVendaOrcamentoDet.add(deleteButtonOrcamentoDet);
        jPanelVendaOrcamentoDet.add(saveButtonOrcamentoDet);
        jPanelVendaOrcamentoDet.add(reloadButtonOrcamentoDet);
        jPanelVendaOrcamentoDet.add(navigatorBarOrcamentoDet);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanelVendaOrcamentoDet, gridBagConstraints);

        gridControl1.setAutoLoadData(false);
        gridControl1.setDeleteButton(deleteButtonOrcamentoDet);
        gridControl1.setEditButton(editButtonOrcamentoDet);
        gridControl1.setFunctionId("vendaOrcamentoDetalhe");
        gridControl1.setInsertButton(insertButtonOrcamentoDet);
        gridControl1.setNavBar(navigatorBarOrcamentoDet);
        gridControl1.setReloadButton(reloadButtonOrcamentoDet);
        gridControl1.setSaveButton(saveButtonOrcamentoDet);
        gridControl1.setValueObjectClassName("com.bakeryfactory.vendas.java.VendaOrcamentoDetalheVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumnProduto.setColumnName("produto.nome");
        codLookupColumnProduto.setEditableOnEdit(true);
        codLookupColumnProduto.setEditableOnInsert(true);
        codLookupColumnProduto.setHeaderColumnName("Produto");
        codLookupColumnProduto.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColumnProduto.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(codLookupColumnProduto);

        decimalColumn4.setColumnName("quantidade");
        decimalColumn4.setDecimals(2);
        decimalColumn4.setEditableOnEdit(true);
        decimalColumn4.setEditableOnInsert(true);
        decimalColumn4.setHeaderColumnName("Quantidade");
        decimalColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn4);

        decimalColumn5.setColumnName("valorUnitario");
        decimalColumn5.setColumnRequired(false);
        decimalColumn5.setDecimals(2);
        decimalColumn5.setHeaderColumnName("Valor Unitário");
        decimalColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn5);

        decimalColumn6.setColumnName("valorSubtotal");
        decimalColumn6.setColumnRequired(false);
        decimalColumn6.setDecimals(2);
        decimalColumn6.setHeaderColumnName("Valor Subtotal");
        decimalColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn6);

        decimalColumn7.setColumnName("taxaDesconto");
        decimalColumn7.setColumnRequired(false);
        decimalColumn7.setDecimals(2);
        decimalColumn7.setEditableOnEdit(true);
        decimalColumn7.setEditableOnInsert(true);
        decimalColumn7.setHeaderColumnName("Taxa Desconto");
        decimalColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn7);

        decimalColumn8.setColumnName("valorDesconto");
        decimalColumn8.setColumnRequired(false);
        decimalColumn8.setDecimals(2);
        decimalColumn8.setHeaderColumnName("Valor Desconto");
        decimalColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn8);

        decimalColumn9.setColumnName("valorTotal");
        decimalColumn9.setColumnRequired(false);
        decimalColumn9.setDecimals(2);
        decimalColumn9.setHeaderColumnName("Valor Total");
        decimalColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(decimalColumn9);

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

    private void numControlValorFreteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numControlValorFreteFocusLost
        controller.atualizaTotais();
    }//GEN-LAST:event_numControlValorFreteFocusLost

    private void numControlTaxaDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numControlTaxaDescontoFocusLost
        controller.atualizaTotais();
    }//GEN-LAST:event_numControlTaxaDescontoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.ComboBoxControl cbControlSituacao;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumnProduto;
    private org.openswing.swing.client.CodLookupControl codLookupControlCliente;
    private org.openswing.swing.client.CodLookupControl codLookupControlCondicaoPgto;
    private org.openswing.swing.client.CodLookupControl codLookupControlTransportadora;
    private org.openswing.swing.client.CodLookupControl codLookupControlVendedor;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl11;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl6;
    private org.openswing.swing.client.DateControl dateControl10;
    private org.openswing.swing.client.DateControl dateControl8;
    private org.openswing.swing.client.DateControl dateControl9;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn4;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn6;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn9;
    private org.openswing.swing.client.DeleteButton deleteButtonOrcamentoDet;
    private org.openswing.swing.client.EditButton editButtonOrcamentoCab;
    private org.openswing.swing.client.EditButton editButtonOrcamentoDet;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButtonOrcamentoDet;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelVendaOrcamentoCab;
    private javax.swing.JPanel jPanelVendaOrcamentoDet;
    private org.openswing.swing.client.LabelControl lblCliente;
    private org.openswing.swing.client.LabelControl lblCodigo;
    private org.openswing.swing.client.LabelControl lblCondPagto;
    private org.openswing.swing.client.LabelControl lblDataCadastro;
    private org.openswing.swing.client.LabelControl lblDataEntrega;
    private org.openswing.swing.client.LabelControl lblObservacao;
    private org.openswing.swing.client.LabelControl lblSituacao;
    private org.openswing.swing.client.LabelControl lblTaxaComissao;
    private org.openswing.swing.client.LabelControl lblTaxaDesconto;
    private org.openswing.swing.client.LabelControl lblTipo;
    private org.openswing.swing.client.LabelControl lblTipoFrete;
    private org.openswing.swing.client.LabelControl lblTransportadora;
    private org.openswing.swing.client.LabelControl lblValidade;
    private org.openswing.swing.client.LabelControl lblValorComissao;
    private org.openswing.swing.client.LabelControl lblValorDesconto;
    private org.openswing.swing.client.LabelControl lblValorFrete;
    private org.openswing.swing.client.LabelControl lblValorSubTotal;
    private org.openswing.swing.client.LabelControl lblValorTotal;
    private org.openswing.swing.client.LabelControl lblVendedor;
    private org.openswing.swing.client.NavigatorBar navigatorBarOrcamentoDet;
    private org.openswing.swing.client.NumericControl numControlTaxaComissao;
    private org.openswing.swing.client.NumericControl numControlTaxaDesconto;
    private org.openswing.swing.client.NumericControl numControlValorComissao;
    private org.openswing.swing.client.NumericControl numControlValorDesconto;
    private org.openswing.swing.client.NumericControl numControlValorFrete;
    private org.openswing.swing.client.NumericControl numControlValorSubTotal;
    private org.openswing.swing.client.NumericControl numControlValorTotal;
    private org.openswing.swing.client.ReloadButton reloadButtonOrcamentoCab;
    private org.openswing.swing.client.ReloadButton reloadButtonOrcamentoDet;
    private org.openswing.swing.client.SaveButton saveButtonOrcamentoCab;
    private org.openswing.swing.client.SaveButton saveButtonOrcamentoDet;
    private org.openswing.swing.client.TextAreaControl textAreaControlObserv;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControlCliente;
    private org.openswing.swing.client.TextControl textControlCondPgto;
    private org.openswing.swing.client.TextControl textControlTransportadora;
    private org.openswing.swing.client.TextControl textControlVendedor;
    // End of variables declaration//GEN-END:variables
}
