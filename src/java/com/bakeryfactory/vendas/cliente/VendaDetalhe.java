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
import com.bakeryfactory.vendas.java.VendaCabecalhoVO;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public final class VendaDetalhe extends InternalFrame {

    private VendaDetalheController controller;
    private VendaDetalheGridController itensController;

    private LookupController vendedorController;
    private final LookupController clienteController;
    private LookupController transportadoraController;
    private LookupController condicaoPagamentoController;
    private LookupController produtoController;
    private LookupController orcamentoController;
    private LookupController tipoNotaFiscalController;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public VendaDetalhe(VendaDetalheController controller) {
        initComponents();
        this.produtoController = new LookupController();
        this.condicaoPagamentoController = new LookupController();
        this.tipoNotaFiscalController = new LookupController();
        this.orcamentoController = new LookupController();
        this.clienteController = new LookupController();
        this.transportadoraController = new LookupController();
        this.vendedorController = new LookupController();

        this.controller = controller;

        formTipoVenda.setFormController(controller);

        itensController = new VendaDetalheGridController(this);
        gridControlItemVenda.setController(itensController);
        gridControlItemVenda.setGridDataLocator(itensController);
        maskDataSaida();

        /*
         * Configurações do lookup do vendedor
         */
        vendedorController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.VendedorVO");
        vendedorController.addLookup2ParentLink("id", "vendedor.id");
        vendedorController.addLookup2ParentLink("colaborador.pessoa.nome", "vendedor.colaborador.pessoa.nome");
        vendedorController.addLookup2ParentLink("comissao", "taxaComissao");
        vendedorController.setHeaderColumnName("id", "ID");
        vendedorController.setHeaderColumnName("colaborador.pessoa.nome", "Nome");
        vendedorController.setFrameTitle("Importa Vendedor");

        vendedorController.setVisibleStatusPanel(true);
        vendedorController.setVisibleColumn("id", true);
        vendedorController.setVisibleColumn("colaborador.pessoa.nome", true);
        vendedorController.setFramePreferedSize(new Dimension(500, 400));

        vendedorController.setLookupDataLocator(new LookupDataLocatorGenerico(vendedorController.getLookupValueObjectClassName()));
        codLookupVendedor.setLookupController(vendedorController);

        /*
         * Configurações do lookup do cliente
         */
        clienteController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ClienteVO");
        clienteController.addLookup2ParentLink("id", "cliente.id");
        clienteController.addLookup2ParentLink("pessoa.nome", "cliente.pessoa.nome");
        clienteController.setHeaderColumnName("id", "ID");
        clienteController.setHeaderColumnName("pessoa.nome", "Nome");
        clienteController.setFrameTitle("Importa Cliente");

        clienteController.setVisibleStatusPanel(true);
        clienteController.setVisibleColumn("id", true);
        clienteController.setVisibleColumn("pessoa.nome", true);
        clienteController.setFramePreferedSize(new Dimension(500, 400));

        clienteController.setLookupDataLocator(new LookupDataLocatorGenerico(clienteController.getLookupValueObjectClassName()));
        codLookupCliente.setLookupController(clienteController);

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
        transportadoraController.setFramePreferedSize(new Dimension(500, 400));

        transportadoraController.setLookupDataLocator(new LookupDataLocatorGenerico(transportadoraController.getLookupValueObjectClassName()));
        codLookupTrasportadora.setLookupController(transportadoraController);

        /*
         * Configurações do lookup das condições de pagamento
         */
        condicaoPagamentoController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCondicoesPagamentoVO");
        condicaoPagamentoController.addLookup2ParentLink("id", "vendaCondicoesPagamento.id");
        condicaoPagamentoController.addLookup2ParentLink("nome", "vendaCondicoesPagamento.nome");
        condicaoPagamentoController.setHeaderColumnName("id", "ID");
        condicaoPagamentoController.setHeaderColumnName("nome", "Nome");
        condicaoPagamentoController.setFrameTitle("Importa Condições de Pagamento");

        condicaoPagamentoController.setVisibleStatusPanel(true);
        condicaoPagamentoController.setVisibleColumn("id", true);
        condicaoPagamentoController.setVisibleColumn("nome", true);
        condicaoPagamentoController.setFramePreferedSize(new Dimension(500, 400));

        condicaoPagamentoController.setLookupDataLocator(new LookupDataLocatorGenerico(condicaoPagamentoController.getLookupValueObjectClassName()));
        codLookupCondicaoPagamento.setLookupController(condicaoPagamentoController);

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
        produtoController.setFramePreferedSize(new Dimension(500, 400));

        produtoController.setLookupDataLocator(new LookupDataLocatorGenerico(produtoController.getLookupValueObjectClassName()));
        codLookupColumnProduto.setLookupController(produtoController);

        /*
         * Configurações do lookup do orcamento
         */
        orcamentoController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO");
        orcamentoController.addLookup2ParentLink("id", "vendaOrcamentoCabecalho.id");
        orcamentoController.addLookup2ParentLink("codigo", "vendaOrcamentoCabecalho.codigo");
        orcamentoController.addLookup2ParentLink("vendaCondicoesPagamento", "vendaCondicoesPagamento");
        orcamentoController.addLookup2ParentLink("transportadora", "transportadora");
        orcamentoController.addLookup2ParentLink("cliente", "cliente");
        orcamentoController.addLookup2ParentLink("vendedor", "vendedor");
        orcamentoController.addLookup2ParentLink("tipoFrete", "tipoFrete");
        orcamentoController.addLookup2ParentLink("valorSubtotal", "valorSubtotal");
        orcamentoController.addLookup2ParentLink("valorFrete", "valorFrete");
        orcamentoController.addLookup2ParentLink("taxaComissao", "taxaComissao");
        orcamentoController.addLookup2ParentLink("valorComissao", "valorComissao");
        orcamentoController.addLookup2ParentLink("taxaDesconto", "taxaDesconto");
        orcamentoController.addLookup2ParentLink("valorDesconto", "valorDesconto");
        orcamentoController.addLookup2ParentLink("valorTotal", "valorTotal");
        orcamentoController.addLookup2ParentLink("observacao", "observacao");
        orcamentoController.setHeaderColumnName("id", "ID");
        orcamentoController.setHeaderColumnName("codigo", "Código");
        orcamentoController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        orcamentoController.setFrameTitle("Importa Orçamento");

        orcamentoController.setVisibleStatusPanel(true);
        orcamentoController.setVisibleColumn("id", true);
        orcamentoController.setVisibleColumn("codigo", true);
        orcamentoController.setVisibleColumn("cliente.pessoa.nome", true);
        orcamentoController.setFramePreferedSize(new Dimension(500, 400));

        orcamentoController.setLookupDataLocator(new LookupDataLocatorGenerico(orcamentoController.getLookupValueObjectClassName()));
        codLookupOrcamento.setLookupController(orcamentoController);

        /*
         * Configurações do lookup do tipo de nota fiscal
         */
        tipoNotaFiscalController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.NotaFiscalTipoVO");
        tipoNotaFiscalController.addLookup2ParentLink("id", "notaFiscalTipo.id");
        tipoNotaFiscalController.addLookup2ParentLink("nome", "notaFiscalTipo.nome");
        tipoNotaFiscalController.setHeaderColumnName("id", "ID");
        tipoNotaFiscalController.setHeaderColumnName("nome", "Nome");
        tipoNotaFiscalController.setFrameTitle("Importa Tipo Nota Fiscal");

        tipoNotaFiscalController.setVisibleStatusPanel(true);
        tipoNotaFiscalController.setVisibleColumn("id", true);
        tipoNotaFiscalController.setVisibleColumn("nome", true);
        tipoNotaFiscalController.setFramePreferedSize(new Dimension(500, 400));

        tipoNotaFiscalController.setLookupDataLocator(new LookupDataLocatorGenerico(tipoNotaFiscalController.getLookupValueObjectClassName()));
        codLookupTipoNotaFiscal.setLookupController(tipoNotaFiscalController);

    }

    public void maskDataSaida() {
        try {
            MaskFormatter mask = new MaskFormatter("##:##:##");
            mask.setValidCharacters("0123456789");
            formattedTextControlDataSaida.setFormatter(mask);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return formTipoVenda;
    }

    public VendaDetalheController getFormController() {
        return controller;
    }

    public GridControl getGrid1() {
        return gridControlItemVenda;
    }

    public VendaDetalheGridController getItensController() {
        return itensController;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        gridControlItemVenda = new org.openswing.swing.client.GridControl();
        codLookupColumnProduto = new org.openswing.swing.table.columns.client.CodLookupColumn();
        decimalColumn1 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn2 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn3 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn6 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn4 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn5 = new org.openswing.swing.table.columns.client.DecimalColumn();
        jPanel5 = new javax.swing.JPanel();
        insertButtonItensVenda = new org.openswing.swing.client.InsertButton();
        editButtonItensVenda = new org.openswing.swing.client.EditButton();
        deleteButtonItensVenda = new org.openswing.swing.client.DeleteButton();
        saveButtonItensVenda = new org.openswing.swing.client.SaveButton();
        reloadButtonItensVenda = new org.openswing.swing.client.ReloadButton();
        navigatorBarItensVenda = new org.openswing.swing.client.NavigatorBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        editButtonVenda = new org.openswing.swing.client.EditButton();
        reloadButtonVenda = new org.openswing.swing.client.ReloadButton();
        saveButtonVenda = new org.openswing.swing.client.SaveButton();
        formTipoVenda = new org.openswing.swing.form.client.Form();
        lblTransportadora = new org.openswing.swing.client.LabelControl();
        lblValorSubtotal = new org.openswing.swing.client.LabelControl();
        lblValorFrete = new org.openswing.swing.client.LabelControl();
        lblTaxaComissao = new org.openswing.swing.client.LabelControl();
        lblValorComissao = new org.openswing.swing.client.LabelControl();
        lblTaxaDesconto = new org.openswing.swing.client.LabelControl();
        lblValorTotal = new org.openswing.swing.client.LabelControl();
        lblObservacoes = new org.openswing.swing.client.LabelControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        numControlValorSubtotal = new org.openswing.swing.client.NumericControl();
        numControlValorFrete = new org.openswing.swing.client.NumericControl();
        numControlTaxaComissao = new org.openswing.swing.client.NumericControl();
        numControlValorComissao = new org.openswing.swing.client.NumericControl();
        numControlTaxaDesconto = new org.openswing.swing.client.NumericControl();
        numControlValorTotal = new org.openswing.swing.client.NumericControl();
        codLookupCondicaoPagamento = new org.openswing.swing.client.CodLookupControl();
        textControlCondPgto = new org.openswing.swing.client.TextControl();
        codLookupTrasportadora = new org.openswing.swing.client.CodLookupControl();
        textControlLocalEntrega = new org.openswing.swing.client.TextControl();
        lblCondPgto = new org.openswing.swing.client.LabelControl();
        codLookupVendedor = new org.openswing.swing.client.CodLookupControl();
        lblTipoNotaFiscal = new org.openswing.swing.client.LabelControl();
        textControlVendedor = new org.openswing.swing.client.TextControl();
        codLookupCliente = new org.openswing.swing.client.CodLookupControl();
        lblCliente = new org.openswing.swing.client.LabelControl();
        textControlCliente = new org.openswing.swing.client.TextControl();
        numControlNumFatura = new org.openswing.swing.client.NumericControl();
        lblValorDesconto = new org.openswing.swing.client.LabelControl();
        cbControlFrete = new org.openswing.swing.client.ComboBoxControl();
        lblLocalEntrega = new org.openswing.swing.client.LabelControl();
        cbControlFormaPgto = new org.openswing.swing.client.ComboBoxControl();
        lblFrete = new org.openswing.swing.client.LabelControl();
        lblDataSaida = new org.openswing.swing.client.LabelControl();
        lblNumFatura = new org.openswing.swing.client.LabelControl();
        lblDataVenda = new org.openswing.swing.client.LabelControl();
        dateControlSaida = new org.openswing.swing.client.DateControl();
        dateControlVenda = new org.openswing.swing.client.DateControl();
        lblTipoVenda = new javax.swing.JLabel();
        cbOrcamentoVenda = new javax.swing.JComboBox();
        lblVendedor = new org.openswing.swing.client.LabelControl();
        codLookupTipoNotaFiscal = new org.openswing.swing.client.CodLookupControl();
        textControlTipoNF = new org.openswing.swing.client.TextControl();
        lblOrcamento = new org.openswing.swing.client.LabelControl();
        codLookupOrcamento = new org.openswing.swing.client.CodLookupControl();
        textControlOrcamento = new org.openswing.swing.client.TextControl();
        lblHoraSaida = new org.openswing.swing.client.LabelControl();
        numControlValorDesc = new org.openswing.swing.client.NumericControl();
        formattedTextControlDataSaida = new org.openswing.swing.client.FormattedTextControl();
        lblLocalCobranca = new org.openswing.swing.client.LabelControl();
        lblFormaPagto = new org.openswing.swing.client.LabelControl();
        textControlLocalCob = new org.openswing.swing.client.TextControl();
        textControlTransportadora = new org.openswing.swing.client.TextControl();

        setTitle("Bakery Factory - Vendas e Faturamento");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens da Venda"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        gridControlItemVenda.setAutoLoadData(false);
        gridControlItemVenda.setDeleteButton(deleteButtonItensVenda);
        gridControlItemVenda.setEditButton(editButtonItensVenda);
        gridControlItemVenda.setFunctionId("vendaDetalhe");
        gridControlItemVenda.setInsertButton(insertButtonItensVenda);
        gridControlItemVenda.setInsertRowsOnTop(false);
        gridControlItemVenda.setNavBar(navigatorBarItensVenda);
        gridControlItemVenda.setPreferredSize(new java.awt.Dimension(500, 300));
        gridControlItemVenda.setReloadButton(reloadButtonItensVenda);
        gridControlItemVenda.setSaveButton(saveButtonItensVenda);
        gridControlItemVenda.setValueObjectClassName("com.bakeryfactory.vendas.java.VendaDetalheVO");
        gridControlItemVenda.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumnProduto.setColumnName("produto.nome");
        codLookupColumnProduto.setEditableOnEdit(true);
        codLookupColumnProduto.setEditableOnInsert(true);
        codLookupColumnProduto.setHeaderColumnName("Produto");
        codLookupColumnProduto.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColumnProduto.setPreferredWidth(200);
        gridControlItemVenda.getColumnContainer().add(codLookupColumnProduto);

        decimalColumn1.setColumnName("quantidade");
        decimalColumn1.setDecimals(3);
        decimalColumn1.setEditableOnEdit(true);
        decimalColumn1.setEditableOnInsert(true);
        decimalColumn1.setHeaderColumnName("Quantidade");
        decimalColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        decimalColumn1.setMaxCharacters(3);
        decimalColumn1.setPreferredWidth(80);
        gridControlItemVenda.getColumnContainer().add(decimalColumn1);

        decimalColumn2.setColumnName("valorUnitario");
        decimalColumn2.setColumnRequired(false);
        decimalColumn2.setDecimals(2);
        decimalColumn2.setGrouping(true);
        decimalColumn2.setHeaderColumnName("Valor Unitário");
        decimalColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlItemVenda.getColumnContainer().add(decimalColumn2);

        decimalColumn3.setColumnName("valorSubtotal");
        decimalColumn3.setColumnRequired(false);
        decimalColumn3.setDecimals(2);
        decimalColumn3.setGrouping(true);
        decimalColumn3.setHeaderColumnName("SubTotal");
        decimalColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlItemVenda.getColumnContainer().add(decimalColumn3);

        decimalColumn6.setColumnName("taxaDesconto");
        decimalColumn6.setColumnRequired(false);
        decimalColumn6.setDecimals(2);
        decimalColumn6.setEditableOnEdit(true);
        decimalColumn6.setEditableOnInsert(true);
        decimalColumn6.setGrouping(true);
        decimalColumn6.setHeaderColumnName("Taxa Desconto");
        decimalColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlItemVenda.getColumnContainer().add(decimalColumn6);

        decimalColumn4.setColumnName("valorDesconto");
        decimalColumn4.setColumnRequired(false);
        decimalColumn4.setDecimals(2);
        decimalColumn4.setGrouping(true);
        decimalColumn4.setHeaderColumnName("Desconto");
        decimalColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlItemVenda.getColumnContainer().add(decimalColumn4);

        decimalColumn5.setColumnName("valorTotal");
        decimalColumn5.setColumnRequired(false);
        decimalColumn5.setDecimals(2);
        decimalColumn5.setGrouping(true);
        decimalColumn5.setHeaderColumnName("Valor Total");
        decimalColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlItemVenda.getColumnContainer().add(decimalColumn5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(gridControlItemVenda, gridBagConstraints);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel5.add(insertButtonItensVenda);
        jPanel5.add(editButtonItensVenda);
        jPanel5.add(deleteButtonItensVenda);
        jPanel5.add(saveButtonItensVenda);
        jPanel5.add(reloadButtonItensVenda);
        jPanel5.add(navigatorBarItensVenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel6.add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButtonVenda);
        jPanel1.add(reloadButtonVenda);
        jPanel1.add(saveButtonVenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanel1, gridBagConstraints);

        formTipoVenda.setVOClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        formTipoVenda.setEditButton(editButtonVenda);
        formTipoVenda.setFunctionId("vendaCabecalho");
        formTipoVenda.setReloadButton(reloadButtonVenda);
        formTipoVenda.setSaveButton(saveButtonVenda);
        formTipoVenda.setLayout(new java.awt.GridBagLayout());

        lblTransportadora.setLabel("Transportadora:");
        lblTransportadora.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblTransportadora, gridBagConstraints);

        lblValorSubtotal.setLabel("Valor Subtotal:");
        lblValorSubtotal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblValorSubtotal, gridBagConstraints);

        lblValorFrete.setLabel("Valor Frete:");
        lblValorFrete.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblValorFrete, gridBagConstraints);

        lblTaxaComissao.setLabel("Taxa Comissão:");
        lblTaxaComissao.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblTaxaComissao, gridBagConstraints);

        lblValorComissao.setLabel("Valor Comissão:");
        lblValorComissao.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblValorComissao, gridBagConstraints);

        lblTaxaDesconto.setLabel("Taxa Desconto:");
        lblTaxaDesconto.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblTaxaDesconto, gridBagConstraints);

        lblValorTotal.setLabel("Valor Total:");
        lblValorTotal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblValorTotal, gridBagConstraints);

        lblObservacoes.setLabel("Observações:");
        lblObservacoes.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblObservacoes, gridBagConstraints);

        textAreaControl1.setAttributeName("observacao");
        textAreaControl1.setEnabled(false);
        textAreaControl1.setLinkLabel(lblObservacoes);
        textAreaControl1.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(textAreaControl1, gridBagConstraints);

        numControlValorSubtotal.setAttributeName("valorSubtotal");
        numControlValorSubtotal.setDecimals(2);
        numControlValorSubtotal.setEnabled(false);
        numControlValorSubtotal.setEnabledOnEdit(false);
        numControlValorSubtotal.setEnabledOnInsert(false);
        numControlValorSubtotal.setGrouping(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlValorSubtotal, gridBagConstraints);

        numControlValorFrete.setAttributeName("valorFrete");
        numControlValorFrete.setDecimals(2);
        numControlValorFrete.setEnabled(false);
        numControlValorFrete.setGrouping(true);
        numControlValorFrete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numControlValorFreteFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlValorFrete, gridBagConstraints);

        numControlTaxaComissao.setAttributeName("taxaComissao");
        numControlTaxaComissao.setDecimals(2);
        numControlTaxaComissao.setEnabled(false);
        numControlTaxaComissao.setEnabledOnEdit(false);
        numControlTaxaComissao.setEnabledOnInsert(false);
        numControlTaxaComissao.setGrouping(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlTaxaComissao, gridBagConstraints);

        numControlValorComissao.setAttributeName("valorComissao");
        numControlValorComissao.setDecimals(2);
        numControlValorComissao.setEnabled(false);
        numControlValorComissao.setEnabledOnEdit(false);
        numControlValorComissao.setEnabledOnInsert(false);
        numControlValorComissao.setGrouping(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlValorComissao, gridBagConstraints);

        numControlTaxaDesconto.setAttributeName("taxaDesconto");
        numControlTaxaDesconto.setDecimals(2);
        numControlTaxaDesconto.setEnabled(false);
        numControlTaxaDesconto.setGrouping(true);
        numControlTaxaDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numControlTaxaDescontoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlTaxaDesconto, gridBagConstraints);

        numControlValorTotal.setAttributeName("valorTotal");
        numControlValorTotal.setDecimals(2);
        numControlValorTotal.setEnabled(false);
        numControlValorTotal.setEnabledOnEdit(false);
        numControlValorTotal.setEnabledOnInsert(false);
        numControlValorTotal.setGrouping(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlValorTotal, gridBagConstraints);

        codLookupCondicaoPagamento.setAllowOnlyNumbers(true);
        codLookupCondicaoPagamento.setAttributeName("vendaCondicoesPagamento.id");
        codLookupCondicaoPagamento.setEnabled(false);
        codLookupCondicaoPagamento.setEnabledOnInsert(false);
        codLookupCondicaoPagamento.setLinkLabel(lblCondPgto);
        codLookupCondicaoPagamento.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupCondicaoPagamento, gridBagConstraints);

        textControlCondPgto.setAttributeName("vendaCondicoesPagamento.nome");
        textControlCondPgto.setEnabled(false);
        textControlCondPgto.setEnabledOnEdit(false);
        textControlCondPgto.setEnabledOnInsert(false);
        textControlCondPgto.setLinkLabel(lblCondPgto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlCondPgto, gridBagConstraints);

        codLookupTrasportadora.setAllowOnlyNumbers(true);
        codLookupTrasportadora.setAttributeName("transportadora.id");
        codLookupTrasportadora.setEnabled(false);
        codLookupTrasportadora.setEnabledOnInsert(false);
        codLookupTrasportadora.setLinkLabel(lblTransportadora);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupTrasportadora, gridBagConstraints);

        textControlLocalEntrega.setAttributeName("localEntrega");
        textControlLocalEntrega.setEnabled(false);
        textControlLocalEntrega.setLinkLabel(lblLocalEntrega);
        textControlLocalEntrega.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlLocalEntrega, gridBagConstraints);

        lblCondPgto.setLabel("Condições Pagamento:");
        lblCondPgto.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblCondPgto, gridBagConstraints);

        codLookupVendedor.setAllowOnlyNumbers(true);
        codLookupVendedor.setAttributeName("vendedor.id");
        codLookupVendedor.setEnabled(false);
        codLookupVendedor.setEnabledOnInsert(false);
        codLookupVendedor.setLinkLabel(lblVendedor);
        codLookupVendedor.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupVendedor, gridBagConstraints);

        lblTipoNotaFiscal.setLabel("Tipo de Nota Fiscal:");
        lblTipoNotaFiscal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblTipoNotaFiscal, gridBagConstraints);

        textControlVendedor.setAttributeName("vendedor.colaborador.pessoa.nome");
        textControlVendedor.setEnabled(false);
        textControlVendedor.setEnabledOnEdit(false);
        textControlVendedor.setEnabledOnInsert(false);
        textControlVendedor.setLinkLabel(lblVendedor);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlVendedor, gridBagConstraints);

        codLookupCliente.setAllowOnlyNumbers(true);
        codLookupCliente.setAttributeName("cliente.id");
        codLookupCliente.setEnabled(false);
        codLookupCliente.setEnabledOnInsert(false);
        codLookupCliente.setLinkLabel(lblCliente);
        codLookupCliente.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupCliente, gridBagConstraints);

        lblCliente.setLabel("Cliente:");
        lblCliente.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblCliente, gridBagConstraints);

        textControlCliente.setAttributeName("cliente.pessoa.nome");
        textControlCliente.setEnabled(false);
        textControlCliente.setEnabledOnEdit(false);
        textControlCliente.setEnabledOnInsert(false);
        textControlCliente.setLinkLabel(lblCliente);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlCliente, gridBagConstraints);

        numControlNumFatura.setAttributeName("numeroFatura");
        numControlNumFatura.setEnabled(false);
        numControlNumFatura.setGrouping(true);
        numControlNumFatura.setLinkLabel(lblNumFatura);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlNumFatura, gridBagConstraints);

        lblValorDesconto.setLabel("Valor Desconto:");
        lblValorDesconto.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblValorDesconto, gridBagConstraints);

        cbControlFrete.setAttributeName("tipoFrete");
        cbControlFrete.setDomainId("compraTipoFrete");
        cbControlFrete.setEnabled(false);
        cbControlFrete.setLinkLabel(lblFrete);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(cbControlFrete, gridBagConstraints);

        lblLocalEntrega.setLabel("Local de Entrega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblLocalEntrega, gridBagConstraints);

        cbControlFormaPgto.setAttributeName("formaPagamento");
        cbControlFormaPgto.setDomainId("formaPagamento");
        cbControlFormaPgto.setEnabled(false);
        cbControlFormaPgto.setLinkLabel(lblFormaPagto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(cbControlFormaPgto, gridBagConstraints);

        lblFrete.setLabel("Frete:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblFrete, gridBagConstraints);

        lblDataSaida.setLabel("Data Saída:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblDataSaida, gridBagConstraints);

        lblNumFatura.setLabel("Número Fatura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblNumFatura, gridBagConstraints);

        lblDataVenda.setLabel("Data Venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblDataVenda, gridBagConstraints);

        dateControlSaida.setAttributeName("dataSaida");
        dateControlSaida.setEnabled(false);
        dateControlSaida.setLinkLabel(lblDataSaida);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(dateControlSaida, gridBagConstraints);

        dateControlVenda.setAttributeName("dataVenda");
        dateControlVenda.setEnabled(false);
        dateControlVenda.setLinkLabel(lblDataVenda);
        dateControlVenda.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(dateControlVenda, gridBagConstraints);

        lblTipoVenda.setText("Tipo de Venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblTipoVenda, gridBagConstraints);

        cbOrcamentoVenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Do Orçamento", "Venda Direta" }));
        cbOrcamentoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrcamentoVendaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(cbOrcamentoVenda, gridBagConstraints);

        lblVendedor.setLabel("Vendedor:");
        lblVendedor.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblVendedor, gridBagConstraints);

        codLookupTipoNotaFiscal.setAllowOnlyNumbers(true);
        codLookupTipoNotaFiscal.setAttributeName("notaFiscalTipo.id");
        codLookupTipoNotaFiscal.setEnabled(false);
        codLookupTipoNotaFiscal.setLinkLabel(lblTipoNotaFiscal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupTipoNotaFiscal, gridBagConstraints);

        textControlTipoNF.setAttributeName("notaFiscalTipo.nome");
        textControlTipoNF.setEnabled(false);
        textControlTipoNF.setEnabledOnEdit(false);
        textControlTipoNF.setEnabledOnInsert(false);
        textControlTipoNF.setLinkLabel(lblTipoNotaFiscal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlTipoNF, gridBagConstraints);

        lblOrcamento.setLabel("Orçamento:");
        lblOrcamento.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblOrcamento, gridBagConstraints);

        codLookupOrcamento.setAllowOnlyNumbers(true);
        codLookupOrcamento.setAttributeName("vendaOrcamentoCabecalho.id");
        codLookupOrcamento.setEnabled(false);
        codLookupOrcamento.setLinkLabel(lblOrcamento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        formTipoVenda.add(codLookupOrcamento, gridBagConstraints);

        textControlOrcamento.setAttributeName("vendaOrcamentoCabecalho.codigo");
        textControlOrcamento.setEnabled(false);
        textControlOrcamento.setEnabledOnEdit(false);
        textControlOrcamento.setEnabledOnInsert(false);
        textControlOrcamento.setLinkLabel(lblOrcamento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlOrcamento, gridBagConstraints);

        lblHoraSaida.setLabel("Hora Saída:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblHoraSaida, gridBagConstraints);

        numControlValorDesc.setAttributeName("valorDesconto");
        numControlValorDesc.setDecimals(2);
        numControlValorDesc.setEnabled(false);
        numControlValorDesc.setEnabledOnEdit(false);
        numControlValorDesc.setEnabledOnInsert(false);
        numControlValorDesc.setGrouping(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(numControlValorDesc, gridBagConstraints);

        formattedTextControlDataSaida.setAttributeName("horaSaida");
        formattedTextControlDataSaida.setLinkLabel(lblHoraSaida);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formTipoVenda.add(formattedTextControlDataSaida, gridBagConstraints);

        lblLocalCobranca.setLabel("Local de Cobrança:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblLocalCobranca, gridBagConstraints);

        lblFormaPagto.setLabel("Forma de Pagamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formTipoVenda.add(lblFormaPagto, gridBagConstraints);

        textControlLocalCob.setAttributeName("localCobranca");
        textControlLocalCob.setEnabled(false);
        textControlLocalCob.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlLocalCob, gridBagConstraints);

        textControlTransportadora.setAttributeName("transportadora.pessoa.nome");
        textControlTransportadora.setEnabled(false);
        textControlTransportadora.setEnabledOnEdit(false);
        textControlTransportadora.setEnabledOnInsert(false);
        textControlTransportadora.setLinkLabel(lblTransportadora);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        formTipoVenda.add(textControlTransportadora, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(formTipoVenda, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(jPanel2, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel6);

        getContentPane().add(jScrollPane1, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numControlValorFreteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numControlValorFreteFocusLost
        controller.atualizaTotais();
    }//GEN-LAST:event_numControlValorFreteFocusLost

    private void numControlTaxaDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numControlTaxaDescontoFocusLost
        controller.atualizaTotais();
    }//GEN-LAST:event_numControlTaxaDescontoFocusLost

    private void cbOrcamentoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrcamentoVendaActionPerformed
        if (cbOrcamentoVenda.getSelectedIndex() == 0) {//do orcamento
            codLookupOrcamento.setEnabled(true);
            codLookupCliente.setEnabled(false);
            codLookupVendedor.setEnabled(false);
            codLookupCondicaoPagamento.setEnabled(false);
            codLookupTrasportadora.setEnabled(false);
        } else {
            //venda direta
            VendaCabecalhoVO vendaCabecalho = (VendaCabecalhoVO) formTipoVenda.getVOModel().getValueObject();
            codLookupOrcamento.setEnabled(false);
            vendaCabecalho.getVendaOrcamentoCabecalho().setId(null);
            vendaCabecalho.getVendaOrcamentoCabecalho().setCodigo(null);

            codLookupCliente.setEnabled(true);
            codLookupVendedor.setEnabled(true);
            codLookupCondicaoPagamento.setEnabled(true);
            codLookupTrasportadora.setEnabled(true);

            formTipoVenda.pull();
        }
    }//GEN-LAST:event_cbOrcamentoVendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.ComboBoxControl cbControlFormaPgto;
    private org.openswing.swing.client.ComboBoxControl cbControlFrete;
    private javax.swing.JComboBox cbOrcamentoVenda;
    private org.openswing.swing.client.CodLookupControl codLookupCliente;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumnProduto;
    private org.openswing.swing.client.CodLookupControl codLookupCondicaoPagamento;
    private org.openswing.swing.client.CodLookupControl codLookupOrcamento;
    private org.openswing.swing.client.CodLookupControl codLookupTipoNotaFiscal;
    private org.openswing.swing.client.CodLookupControl codLookupTrasportadora;
    private org.openswing.swing.client.CodLookupControl codLookupVendedor;
    private org.openswing.swing.client.DateControl dateControlSaida;
    private org.openswing.swing.client.DateControl dateControlVenda;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn2;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn3;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn4;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn6;
    private org.openswing.swing.client.DeleteButton deleteButtonItensVenda;
    private org.openswing.swing.client.EditButton editButtonItensVenda;
    private org.openswing.swing.client.EditButton editButtonVenda;
    private org.openswing.swing.form.client.Form formTipoVenda;
    private org.openswing.swing.client.FormattedTextControl formattedTextControlDataSaida;
    private org.openswing.swing.client.GridControl gridControlItemVenda;
    private org.openswing.swing.client.InsertButton insertButtonItensVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private org.openswing.swing.client.LabelControl lblCliente;
    private org.openswing.swing.client.LabelControl lblCondPgto;
    private org.openswing.swing.client.LabelControl lblDataSaida;
    private org.openswing.swing.client.LabelControl lblDataVenda;
    private org.openswing.swing.client.LabelControl lblFormaPagto;
    private org.openswing.swing.client.LabelControl lblFrete;
    private org.openswing.swing.client.LabelControl lblHoraSaida;
    private org.openswing.swing.client.LabelControl lblLocalCobranca;
    private org.openswing.swing.client.LabelControl lblLocalEntrega;
    private org.openswing.swing.client.LabelControl lblNumFatura;
    private org.openswing.swing.client.LabelControl lblObservacoes;
    private org.openswing.swing.client.LabelControl lblOrcamento;
    private org.openswing.swing.client.LabelControl lblTaxaComissao;
    private org.openswing.swing.client.LabelControl lblTaxaDesconto;
    private org.openswing.swing.client.LabelControl lblTipoNotaFiscal;
    private javax.swing.JLabel lblTipoVenda;
    private org.openswing.swing.client.LabelControl lblTransportadora;
    private org.openswing.swing.client.LabelControl lblValorComissao;
    private org.openswing.swing.client.LabelControl lblValorDesconto;
    private org.openswing.swing.client.LabelControl lblValorFrete;
    private org.openswing.swing.client.LabelControl lblValorSubtotal;
    private org.openswing.swing.client.LabelControl lblValorTotal;
    private org.openswing.swing.client.LabelControl lblVendedor;
    private org.openswing.swing.client.NavigatorBar navigatorBarItensVenda;
    private org.openswing.swing.client.NumericControl numControlNumFatura;
    private org.openswing.swing.client.NumericControl numControlTaxaComissao;
    private org.openswing.swing.client.NumericControl numControlTaxaDesconto;
    private org.openswing.swing.client.NumericControl numControlValorComissao;
    private org.openswing.swing.client.NumericControl numControlValorDesc;
    private org.openswing.swing.client.NumericControl numControlValorFrete;
    private org.openswing.swing.client.NumericControl numControlValorSubtotal;
    private org.openswing.swing.client.NumericControl numControlValorTotal;
    private org.openswing.swing.client.ReloadButton reloadButtonItensVenda;
    private org.openswing.swing.client.ReloadButton reloadButtonVenda;
    private org.openswing.swing.client.SaveButton saveButtonItensVenda;
    private org.openswing.swing.client.SaveButton saveButtonVenda;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControlCliente;
    private org.openswing.swing.client.TextControl textControlCondPgto;
    private org.openswing.swing.client.TextControl textControlLocalCob;
    private org.openswing.swing.client.TextControl textControlLocalEntrega;
    private org.openswing.swing.client.TextControl textControlOrcamento;
    private org.openswing.swing.client.TextControl textControlTipoNF;
    private org.openswing.swing.client.TextControl textControlTransportadora;
    private org.openswing.swing.client.TextControl textControlVendedor;
    // End of variables declaration//GEN-END:variables
}
