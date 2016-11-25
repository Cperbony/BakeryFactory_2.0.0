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
package com.bakeryfactory.cadastros.cliente;

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class ClienteDetalhe extends InternalFrame {

    private final LookupController pessoaController;
    private final LookupController atividadeController;
    private final LookupController situacaoController;
    private final LookupController contaContabilController;
    private final LookupController operacaoFiscalController;

    /**
     * Creates new form ClienteDetalhe
     *
     * @param controller
     */
    public ClienteDetalhe(ClienteDetalheController controller) {
        this.operacaoFiscalController = new LookupController();
        this.contaContabilController = new LookupController();
        this.situacaoController = new LookupController();
        this.atividadeController = new LookupController();
        this.pessoaController = new LookupController();
        
        initComponents();
        form1.setFormController(controller);

        /*
              //Configurações do Lookup da Pessoa
        codLookupControlPessoa.setLookupController(pessoaController);

        //Configuração do Lookup da Situação
        codLookupControlSituacao.setLookupController(situacaoController);

        //Configurações do lookup da Atividade
        codLookupControlAtividade.setLookupController(atividadeController);
        
        //TODO quando extender para Módulo Contábil Configurações do Lookup da Conta Contábil
       
        //Configurações do lookup da Conta Fiscal
        codLookupControlContaContabil.setLookupController(contaContabilController);

        //Configurações do lookup da Operação Fiscal
        codLookupOpFiscal.setLookupController(operacaoFiscalController);
        */
 
        /*
         * Configurações do lookup da pessoa
         */
        pessoaController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaVO");
        pessoaController.addLookup2ParentLink("id", "pessoa.id");
        pessoaController.addLookup2ParentLink("nome", "pessoa.nome");
        pessoaController.setHeaderColumnName("id", "ID");
        pessoaController.setHeaderColumnName("nome", "Nome");
        pessoaController.setFrameTitle("Importa Pessoa");

        pessoaController.setVisibleStatusPanel(true);
        pessoaController.setVisibleColumn("id", true);
        pessoaController.setVisibleColumn("nome", true);
        pessoaController.setFramePreferedSize(new Dimension(600, 500));

        pessoaController.setLookupDataLocator(new LookupDataLocatorGenerico(pessoaController.getLookupValueObjectClassName()));
        codLookupControlPessoa.setLookupController(pessoaController);

        /*
         * Configurações do lookup da situacao
         */
        situacaoController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SituacaoForCliVO");
        situacaoController.addLookup2ParentLink("id", "situacaoForCli.id");
        situacaoController.addLookup2ParentLink("nome", "situacaoForCli.nome");
        situacaoController.setHeaderColumnName("id", "ID");
        situacaoController.setHeaderColumnName("nome", "Nome");
        situacaoController.setFrameTitle("Importa Situação");

        situacaoController.setVisibleStatusPanel(true);
        situacaoController.setVisibleColumn("id", true);
        situacaoController.setVisibleColumn("nome", true);
        situacaoController.setFramePreferedSize(new Dimension(600, 500));

        situacaoController.setLookupDataLocator(new LookupDataLocatorGenerico(situacaoController.getLookupValueObjectClassName()));
        codLookupControlSituacao.setLookupController(situacaoController);

        /*
         * Configurações do lookup da atividade
         */
        atividadeController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.AtividadeForCliVO");
        atividadeController.addLookup2ParentLink("id", "atividadeForCli.id");
        atividadeController.addLookup2ParentLink("nome", "atividadeForCli.nome");
        atividadeController.setHeaderColumnName("id", "ID");
        atividadeController.setHeaderColumnName("nome", "Nome");
        atividadeController.setFrameTitle("Importa Atividade");

        atividadeController.setVisibleStatusPanel(true);
        atividadeController.setVisibleColumn("id", true);
        atividadeController.setVisibleColumn("nome", true);
        atividadeController.setFramePreferedSize(new Dimension(600, 500));

        atividadeController.setLookupDataLocator(new LookupDataLocatorGenerico(atividadeController.getLookupValueObjectClassName()));
        codLookupControlAtividade.setLookupController(atividadeController);

        /*
         * Configurações do lookup da conta contabil
         */
        contaContabilController.setLookupValueObjectClassName("com.bakeryfactory.contabilidade.java.ContabilContaVO");
        contaContabilController.addLookup2ParentLink("id", "contabilConta.id");
        contaContabilController.addLookup2ParentLink("descricao", "contabilConta.descricao");
        contaContabilController.setHeaderColumnName("id", "ID");
        contaContabilController.setHeaderColumnName("descricao", "Descrição");
        contaContabilController.setFrameTitle("Importa Conta Contábil");

        contaContabilController.setVisibleStatusPanel(true);
        contaContabilController.setVisibleColumn("id", true);
        contaContabilController.setVisibleColumn("descricao", true);
        contaContabilController.setFramePreferedSize(new Dimension(600, 500));

        contaContabilController.setLookupDataLocator(new LookupDataLocatorGenerico(contaContabilController.getLookupValueObjectClassName()));
        codLookupControlContaContabil.setLookupController(contaContabilController);

        /*
         * Configurações do lookup da operacao fiscal
         */
        operacaoFiscalController.setLookupValueObjectClassName("com.bakeryfactory.tributacao.java.TributOperacaoFiscalVO");
        operacaoFiscalController.addLookup2ParentLink("id", "tributOperacaoFiscal.id");
        operacaoFiscalController.addLookup2ParentLink("descricao", "tributOperacaoFiscal.descricao");
        operacaoFiscalController.setHeaderColumnName("id", "ID");
        operacaoFiscalController.setHeaderColumnName("descricao", "Descrição");
        operacaoFiscalController.setFrameTitle("Importa Operação Fiscal");

        operacaoFiscalController.setVisibleStatusPanel(true);
        operacaoFiscalController.setVisibleColumn("id", true);
        operacaoFiscalController.setVisibleColumn("descricao", true);
        operacaoFiscalController.setFramePreferedSize(new Dimension(600, 500));

        operacaoFiscalController.setLookupDataLocator(new LookupDataLocatorGenerico(operacaoFiscalController.getLookupValueObjectClassName()));
        codLookupOpFiscal.setLookupController(operacaoFiscalController);
        
    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        editButton1 = new org.openswing.swing.client.EditButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        form1 = new org.openswing.swing.form.client.Form();
        lblContaContabil = new org.openswing.swing.client.LabelControl();
        codLookupControlContaContabil = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        lblOperacaoFiscal = new org.openswing.swing.client.LabelControl();
        codLookupOpFiscal = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        lblPessoa = new org.openswing.swing.client.LabelControl();
        codLookupControlPessoa = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        lblAtividade = new org.openswing.swing.client.LabelControl();
        codLookupControlAtividade = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        lblSituacao = new org.openswing.swing.client.LabelControl();
        codLookupControlSituacao = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        lblDesde = new org.openswing.swing.client.LabelControl();
        dateControl7 = new org.openswing.swing.client.DateControl();
        lblDataCadastro = new org.openswing.swing.client.LabelControl();
        dateControl8 = new org.openswing.swing.client.DateControl();
        lblObservacao = new org.openswing.swing.client.LabelControl();
        lblContaTomador = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblGeraFinanceiro = new org.openswing.swing.client.LabelControl();
        comboBoxControlGeraFinanceiro = new org.openswing.swing.client.ComboBoxControl();
        lblIndicadorPreco = new org.openswing.swing.client.LabelControl();
        comboBoxControlIndPreco = new org.openswing.swing.client.ComboBoxControl();
        lblPorcentoDesconto = new org.openswing.swing.client.LabelControl();
        numericControl13 = new org.openswing.swing.client.NumericControl();
        lblFormaDesconto = new org.openswing.swing.client.LabelControl();
        comboBoxControlFormaDesconto = new org.openswing.swing.client.ComboBoxControl();
        lblLimiteCredito = new org.openswing.swing.client.LabelControl();
        numericControl15 = new org.openswing.swing.client.NumericControl();
        lblFrete = new org.openswing.swing.client.LabelControl();
        comboBoxControlTipoFrete = new org.openswing.swing.client.ComboBoxControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Bakery Factory - Cadastros");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente Detalhes"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.cadastros.java.ClienteVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("cliente");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        lblContaContabil.setText("Conta Contábil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblContaContabil, gridBagConstraints);

        codLookupControlContaContabil.setAllowOnlyNumbers(true);
        codLookupControlContaContabil.setAttributeName("contabilConta.id");
        codLookupControlContaContabil.setEnabled(false);
        codLookupControlContaContabil.setLinkLabel(lblContaContabil);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlContaContabil, gridBagConstraints);

        textControl2.setAttributeName("contabilConta.descricao");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        lblOperacaoFiscal.setText("Operação Fiscal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblOperacaoFiscal, gridBagConstraints);

        codLookupOpFiscal.setAllowOnlyNumbers(true);
        codLookupOpFiscal.setAttributeName("tributOperacaoFiscal.id");
        codLookupOpFiscal.setEnabled(false);
        codLookupOpFiscal.setLinkLabel(lblOperacaoFiscal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupOpFiscal, gridBagConstraints);

        textControl3.setAttributeName("tributOperacaoFiscal.descricao");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        lblPessoa.setLabel("Pessoa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPessoa, gridBagConstraints);

        codLookupControlPessoa.setAllowOnlyNumbers(true);
        codLookupControlPessoa.setAttributeName("pessoa.id");
        codLookupControlPessoa.setEnabled(false);
        codLookupControlPessoa.setLinkLabel(lblPessoa);
        codLookupControlPessoa.setMaxCharacters(10);
        codLookupControlPessoa.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlPessoa, gridBagConstraints);

        textControl4.setAttributeName("pessoa.nome");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl4, gridBagConstraints);

        lblAtividade.setLabel("Atividade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblAtividade, gridBagConstraints);

        codLookupControlAtividade.setAllowOnlyNumbers(true);
        codLookupControlAtividade.setAttributeName("atividadeForCli.id");
        codLookupControlAtividade.setEnabled(false);
        codLookupControlAtividade.setLinkLabel(lblAtividade);
        codLookupControlAtividade.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlAtividade, gridBagConstraints);

        textControl5.setAttributeName("atividadeForCli.nome");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl5, gridBagConstraints);

        lblSituacao.setText("Situação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSituacao, gridBagConstraints);

        codLookupControlSituacao.setAllowOnlyNumbers(true);
        codLookupControlSituacao.setAttributeName("situacaoForCli.id");
        codLookupControlSituacao.setEnabled(false);
        codLookupControlSituacao.setLinkLabel(lblSituacao);
        codLookupControlSituacao.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlSituacao, gridBagConstraints);

        textControl6.setAttributeName("situacaoForCli.nome");
        textControl6.setEnabled(false);
        textControl6.setEnabledOnEdit(false);
        textControl6.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl6, gridBagConstraints);

        lblDesde.setLabel("Desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDesde, gridBagConstraints);

        dateControl7.setAttributeName("desde");
        dateControl7.setEnabled(false);
        dateControl7.setLinkLabel(lblDesde);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl7, gridBagConstraints);

        lblDataCadastro.setLabel("Data Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDataCadastro, gridBagConstraints);

        dateControl8.setAttributeName("dataCadastro");
        dateControl8.setEnabled(false);
        dateControl8.setEnabledOnEdit(false);
        dateControl8.setEnabledOnInsert(false);
        dateControl8.setLinkLabel(lblDataCadastro);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl8, gridBagConstraints);

        lblObservacao.setText("Observação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblObservacao, gridBagConstraints);

        lblContaTomador.setLabel("Conta Tomador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblContaTomador, gridBagConstraints);

        textControl10.setAttributeName("contaTomador");
        textControl10.setEnabled(false);
        textControl10.setLinkLabel(lblContaTomador);
        textControl10.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl10, gridBagConstraints);

        lblGeraFinanceiro.setLabel("Gera Financeiro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblGeraFinanceiro, gridBagConstraints);

        comboBoxControlGeraFinanceiro.setAttributeName("geraFinanceiro");
        comboBoxControlGeraFinanceiro.setDomainId("naosim");
        comboBoxControlGeraFinanceiro.setEnabled(false);
        comboBoxControlGeraFinanceiro.setLinkLabel(lblGeraFinanceiro);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControlGeraFinanceiro, gridBagConstraints);

        lblIndicadorPreco.setText("Indicador Preço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblIndicadorPreco, gridBagConstraints);

        comboBoxControlIndPreco.setAttributeName("indicadorPreco");
        comboBoxControlIndPreco.setDomainId("clienteIndicadorPreco");
        comboBoxControlIndPreco.setEnabled(false);
        comboBoxControlIndPreco.setLinkLabel(lblIndicadorPreco);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControlIndPreco, gridBagConstraints);

        lblPorcentoDesconto.setLabel("Porcento Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPorcentoDesconto, gridBagConstraints);

        numericControl13.setAttributeName("porcentoDesconto");
        numericControl13.setDecimals(2);
        numericControl13.setEnabled(false);
        numericControl13.setLinkLabel(lblPorcentoDesconto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl13, gridBagConstraints);

        lblFormaDesconto.setLabel("Forma Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblFormaDesconto, gridBagConstraints);

        comboBoxControlFormaDesconto.setAttributeName("formaDesconto");
        comboBoxControlFormaDesconto.setDomainId("clienteFormaDesconto");
        comboBoxControlFormaDesconto.setEnabled(false);
        comboBoxControlFormaDesconto.setLinkLabel(lblFormaDesconto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControlFormaDesconto, gridBagConstraints);

        lblLimiteCredito.setText("Limite Crédito:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblLimiteCredito, gridBagConstraints);

        numericControl15.setAttributeName("limiteCredito");
        numericControl15.setDecimals(2);
        numericControl15.setEnabled(false);
        numericControl15.setLinkLabel(lblLimiteCredito);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl15, gridBagConstraints);

        lblFrete.setLabel("Tipo Frete:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblFrete, gridBagConstraints);

        comboBoxControlTipoFrete.setAttributeName("tipoFrete");
        comboBoxControlTipoFrete.setDomainId("clienteTipoFrete");
        comboBoxControlTipoFrete.setEnabled(false);
        comboBoxControlTipoFrete.setLinkLabel(lblFrete);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControlTipoFrete, gridBagConstraints);

        textAreaControl1.setAttributeName("observacao");
        textAreaControl1.setEnabled(false);
        textAreaControl1.setLinkLabel(lblObservacao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textAreaControl1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        form1.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControlAtividade;
    private org.openswing.swing.client.CodLookupControl codLookupControlContaContabil;
    private org.openswing.swing.client.CodLookupControl codLookupControlPessoa;
    private org.openswing.swing.client.CodLookupControl codLookupControlSituacao;
    private org.openswing.swing.client.CodLookupControl codLookupOpFiscal;
    private org.openswing.swing.client.ComboBoxControl comboBoxControlFormaDesconto;
    private org.openswing.swing.client.ComboBoxControl comboBoxControlGeraFinanceiro;
    private org.openswing.swing.client.ComboBoxControl comboBoxControlIndPreco;
    private org.openswing.swing.client.ComboBoxControl comboBoxControlTipoFrete;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.client.DateControl dateControl8;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private org.openswing.swing.client.LabelControl lblAtividade;
    private org.openswing.swing.client.LabelControl lblContaContabil;
    private org.openswing.swing.client.LabelControl lblContaTomador;
    private org.openswing.swing.client.LabelControl lblDataCadastro;
    private org.openswing.swing.client.LabelControl lblDesde;
    private org.openswing.swing.client.LabelControl lblFormaDesconto;
    private org.openswing.swing.client.LabelControl lblFrete;
    private org.openswing.swing.client.LabelControl lblGeraFinanceiro;
    private org.openswing.swing.client.LabelControl lblIndicadorPreco;
    private org.openswing.swing.client.LabelControl lblLimiteCredito;
    private org.openswing.swing.client.LabelControl lblObservacao;
    private org.openswing.swing.client.LabelControl lblOperacaoFiscal;
    private org.openswing.swing.client.LabelControl lblPessoa;
    private org.openswing.swing.client.LabelControl lblPorcentoDesconto;
    private org.openswing.swing.client.LabelControl lblSituacao;
    private org.openswing.swing.client.NumericControl numericControl13;
    private org.openswing.swing.client.NumericControl numericControl15;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    // End of variables declaration//GEN-END:variables
}
