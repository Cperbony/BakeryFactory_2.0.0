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
public class FornecedorDetalhe extends InternalFrame {

    private LookupController pessoaLookupController;
    private LookupController atividadeLookupController;
    private LookupController situacaoLookupController;
    private LookupController contaContabilLookup;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public FornecedorDetalhe(FornecedorDetalheController controller) {
        this.contaContabilLookup = new LookupController();
        this.situacaoLookupController = new LookupController();
        this.atividadeLookupController = new LookupController();
        this.pessoaLookupController = new LookupController();
        initComponents();

        form1.setFormController(controller);

        /*
         * Configurações do lookup da pessoa
         */
        pessoaLookupController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaVO");
        pessoaLookupController.addLookup2ParentLink("id", "pessoa.id");
        pessoaLookupController.addLookup2ParentLink("nome", "pessoa.nome");
        pessoaLookupController.setHeaderColumnName("id", "ID");
        pessoaLookupController.setHeaderColumnName("nome", "Nome");
        pessoaLookupController.setFrameTitle("Importa Pessoa");

        pessoaLookupController.setVisibleStatusPanel(true);
        pessoaLookupController.setVisibleColumn("id", true);
        pessoaLookupController.setVisibleColumn("nome", true);
        pessoaLookupController.setFramePreferedSize(new Dimension(600, 500));

        pessoaLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(pessoaLookupController.getLookupValueObjectClassName()));
        codLookupControlPessoa.setLookupController(pessoaLookupController);

        /*
         * Configurações do lookup da situacao
         */
        situacaoLookupController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SituacaoForCliVO");
        situacaoLookupController.addLookup2ParentLink("id", "situacaoForCli.id");
        situacaoLookupController.addLookup2ParentLink("nome", "situacaoForCli.nome");
        situacaoLookupController.setHeaderColumnName("id", "ID");
        situacaoLookupController.setHeaderColumnName("nome", "Nome");
        situacaoLookupController.setFrameTitle("Importa Situação");

        situacaoLookupController.setVisibleStatusPanel(true);
        situacaoLookupController.setVisibleColumn("id", true);
        situacaoLookupController.setVisibleColumn("nome", true);
        situacaoLookupController.setFramePreferedSize(new Dimension(600, 500));

        situacaoLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(situacaoLookupController.getLookupValueObjectClassName()));
        codLookupControlSituacao.setLookupController(situacaoLookupController);

        /*
         * Configurações do lookup da atividade
         */
        atividadeLookupController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.AtividadeForCliVO");
        atividadeLookupController.addLookup2ParentLink("id", "atividadeForCli.id");
        atividadeLookupController.addLookup2ParentLink("nome", "atividadeForCli.nome");
        atividadeLookupController.setHeaderColumnName("id", "ID");
        atividadeLookupController.setHeaderColumnName("nome", "Nome");
        atividadeLookupController.setFrameTitle("Importa Atividade");

        atividadeLookupController.setVisibleStatusPanel(true);
        atividadeLookupController.setVisibleColumn("id", true);
        atividadeLookupController.setVisibleColumn("nome", true);
        atividadeLookupController.setFramePreferedSize(new Dimension(600, 500));

        atividadeLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(atividadeLookupController.getLookupValueObjectClassName()));
        codLookupControlAtividade.setLookupController(atividadeLookupController);

        /*
         * Configurações do lookup da conta contabil
         */
        contaContabilLookup.setLookupValueObjectClassName("com.bakeryfactory.contabilidade.java.ContabilContaVO");
        contaContabilLookup.addLookup2ParentLink("id", "contabilConta.id");
        contaContabilLookup.addLookup2ParentLink("descricao", "contabilConta.descricao");
        contaContabilLookup.setHeaderColumnName("id", "ID");
        contaContabilLookup.setHeaderColumnName("descricao", "Descrição");
        contaContabilLookup.setFrameTitle("Importa Conta Contábil");

        contaContabilLookup.setVisibleStatusPanel(true);
        contaContabilLookup.setVisibleColumn("id", true);
        contaContabilLookup.setVisibleColumn("descricao", true);
        contaContabilLookup.setFramePreferedSize(new Dimension(600, 500));

        contaContabilLookup.setLookupDataLocator(new LookupDataLocatorGenerico(contaContabilLookup.getLookupValueObjectClassName()));
        codLookupControlContaContabil.setLookupController(contaContabilLookup);

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
        lblDesde = new org.openswing.swing.client.LabelControl();
        dateControl6 = new org.openswing.swing.client.DateControl();
        lblOptanteSimplesNac = new org.openswing.swing.client.LabelControl();
        comboBoxControl7 = new org.openswing.swing.client.ComboBoxControl();
        lblLocalizacao = new org.openswing.swing.client.LabelControl();
        comboBoxControl8 = new org.openswing.swing.client.ComboBoxControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        dateControl9 = new org.openswing.swing.client.DateControl();
        lblSofreRetencao = new org.openswing.swing.client.LabelControl();
        comboBoxControl10 = new org.openswing.swing.client.ComboBoxControl();
        lblChequeNominal = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        lblObservacao = new org.openswing.swing.client.LabelControl();
        lblContaRemetente = new org.openswing.swing.client.LabelControl();
        textControl13 = new org.openswing.swing.client.TextControl();
        lblPrazoMedioEntrega = new org.openswing.swing.client.LabelControl();
        numericControl14 = new org.openswing.swing.client.NumericControl();
        lblGeraFaturamento = new org.openswing.swing.client.LabelControl();
        comboBoxControl15 = new org.openswing.swing.client.ComboBoxControl();
        lblNumDiasPrimVenc = new org.openswing.swing.client.LabelControl();
        numericControl16 = new org.openswing.swing.client.NumericControl();
        lblNumDiasIntervalo = new org.openswing.swing.client.LabelControl();
        numericControl17 = new org.openswing.swing.client.NumericControl();
        lblQuantParcelas = new org.openswing.swing.client.LabelControl();
        numericControl18 = new org.openswing.swing.client.NumericControl();
        lblPessoa = new org.openswing.swing.client.LabelControl();
        codLookupControlPessoa = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        lblSituacao = new org.openswing.swing.client.LabelControl();
        codLookupControlSituacao = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        lblAtividade = new org.openswing.swing.client.LabelControl();
        codLookupControlAtividade = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        codLookupControlContaContabil = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Bakery Factory - Cadastros Detalhes");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.cadastros.java.FornecedorVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("fornecedor");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        lblDesde.setLabel("Desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblDesde, gridBagConstraints);

        dateControl6.setAttributeName("desde");
        dateControl6.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl6, gridBagConstraints);

        lblOptanteSimplesNac.setLabel("Optante Simples Nacional:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblOptanteSimplesNac, gridBagConstraints);

        comboBoxControl7.setAttributeName("optanteSimplesNacional");
        comboBoxControl7.setDomainId("naosim");
        comboBoxControl7.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl7, gridBagConstraints);

        lblLocalizacao.setText("Localização:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblLocalizacao, gridBagConstraints);

        comboBoxControl8.setAttributeName("localizacao");
        comboBoxControl8.setDomainId("fornecedorLocalizacao");
        comboBoxControl8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl8, gridBagConstraints);

        labelControl12.setLabel("Data Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl12, gridBagConstraints);

        dateControl9.setAttributeName("dataCadastro");
        dateControl9.setEnabled(false);
        dateControl9.setEnabledOnEdit(false);
        dateControl9.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl9, gridBagConstraints);

        lblSofreRetencao.setText("Sofre Retenção:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSofreRetencao, gridBagConstraints);

        comboBoxControl10.setAttributeName("sofreRetencao");
        comboBoxControl10.setDomainId("simnao");
        comboBoxControl10.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl10, gridBagConstraints);

        lblChequeNominal.setLabel("Cheque Nominal A:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblChequeNominal, gridBagConstraints);

        textControl11.setAttributeName("chequeNominalA");
        textControl11.setEnabled(false);
        textControl11.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl11, gridBagConstraints);

        lblObservacao.setText("Observação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblObservacao, gridBagConstraints);

        lblContaRemetente.setLabel("Conta Remetente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblContaRemetente, gridBagConstraints);

        textControl13.setAttributeName("contaRemetente");
        textControl13.setEnabled(false);
        textControl13.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl13, gridBagConstraints);

        lblPrazoMedioEntrega.setText("Prazo Médio Entrega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPrazoMedioEntrega, gridBagConstraints);

        numericControl14.setAttributeName("prazoMedioEntrega");
        numericControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl14, gridBagConstraints);

        lblGeraFaturamento.setLabel("Gera Faturamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblGeraFaturamento, gridBagConstraints);

        comboBoxControl15.setAttributeName("geraFaturamento");
        comboBoxControl15.setDomainId("naosim");
        comboBoxControl15.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl15, gridBagConstraints);

        lblNumDiasPrimVenc.setLabel("Num Dias Primeiro Vencimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblNumDiasPrimVenc, gridBagConstraints);

        numericControl16.setAttributeName("numDiasPrimeiroVencimento");
        numericControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl16, gridBagConstraints);

        lblNumDiasIntervalo.setLabel("Num Dias Intervalo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblNumDiasIntervalo, gridBagConstraints);

        numericControl17.setAttributeName("numDiasIntervalo");
        numericControl17.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl17, gridBagConstraints);

        lblQuantParcelas.setLabel("Quantidade Parcelas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblQuantParcelas, gridBagConstraints);

        numericControl18.setAttributeName("quantidadeParcelas");
        numericControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl18, gridBagConstraints);

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

        labelControl1.setText("Conta Contábil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl1, gridBagConstraints);

        codLookupControlContaContabil.setAllowOnlyNumbers(true);
        codLookupControlContaContabil.setAttributeName("contabilConta.id");
        codLookupControlContaContabil.setEnabled(false);
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
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        textAreaControl1.setAttributeName("observacao");
        textAreaControl1.setEnabled(false);
        textAreaControl1.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
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
    private org.openswing.swing.client.ComboBoxControl comboBoxControl10;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl15;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl7;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl8;
    private org.openswing.swing.client.DateControl dateControl6;
    private org.openswing.swing.client.DateControl dateControl9;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl12;
    private org.openswing.swing.client.LabelControl lblAtividade;
    private org.openswing.swing.client.LabelControl lblChequeNominal;
    private org.openswing.swing.client.LabelControl lblContaRemetente;
    private org.openswing.swing.client.LabelControl lblDesde;
    private org.openswing.swing.client.LabelControl lblGeraFaturamento;
    private org.openswing.swing.client.LabelControl lblLocalizacao;
    private org.openswing.swing.client.LabelControl lblNumDiasIntervalo;
    private org.openswing.swing.client.LabelControl lblNumDiasPrimVenc;
    private org.openswing.swing.client.LabelControl lblObservacao;
    private org.openswing.swing.client.LabelControl lblOptanteSimplesNac;
    private org.openswing.swing.client.LabelControl lblPessoa;
    private org.openswing.swing.client.LabelControl lblPrazoMedioEntrega;
    private org.openswing.swing.client.LabelControl lblQuantParcelas;
    private org.openswing.swing.client.LabelControl lblSituacao;
    private org.openswing.swing.client.LabelControl lblSofreRetencao;
    private org.openswing.swing.client.NumericControl numericControl14;
    private org.openswing.swing.client.NumericControl numericControl16;
    private org.openswing.swing.client.NumericControl numericControl17;
    private org.openswing.swing.client.NumericControl numericControl18;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl13;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    // End of variables declaration//GEN-END:variables
}
