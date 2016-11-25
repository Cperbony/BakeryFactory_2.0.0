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
public class ColaboradorDetalhe extends InternalFrame {

    private LookupController pessoaLookup;
    private LookupController tipoColaboraborLookup;
    private LookupController situacaoColaboradorLookup;
    private LookupController tipoAdmissaoLookup;
    private LookupController nivelFormacaoLookup;
    private LookupController cargoLookup;
    private LookupController contaContabilLookup;
    private LookupController sindicatoLookup;
    private LookupController setorLookup;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public ColaboradorDetalhe(ColaboradorDetalheController controller) {
        this.pessoaLookup = new LookupController();
        this.contaContabilLookup = new LookupController();
        this.cargoLookup = new LookupController();
        this.nivelFormacaoLookup = new LookupController();
        this.tipoAdmissaoLookup = new LookupController();
        this.situacaoColaboradorLookup = new LookupController();
        this.tipoColaboraborLookup = new LookupController();
        this.sindicatoLookup = new LookupController();
        this.setorLookup = new LookupController();
        initComponents();

        formColaborador.setFormController(controller);

        /*
        * Configuração do Lookup para a Pessoa relacionada
         */
        pessoaLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaVO");
        pessoaLookup.addLookup2ParentLink("id", "pessoa.id");
        pessoaLookup.addLookup2ParentLink("nome", "pessoa.nome");
        pessoaLookup.setHeaderColumnName("id", "ID");
        pessoaLookup.setHeaderColumnName("nome", "Nome");
        pessoaLookup.setFrameTitle("Importa Pessoa");

        pessoaLookup.setVisibleStatusPanel(true);
        pessoaLookup.setVisibleColumn("id", true);
        pessoaLookup.setVisibleColumn("nome", true);
        pessoaLookup.setFramePreferedSize(new Dimension(600, 500));

        pessoaLookup.setLookupDataLocator(new LookupDataLocatorGenerico(pessoaLookup.getLookupValueObjectClassName()));
        codLookupControlPessoa.setLookupController(pessoaLookup);

        /*
        * Configuração do Lookup para o Tipo do Colaborador
         */
        tipoColaboraborLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.TipoColaboradorVO");
        tipoColaboraborLookup.addLookup2ParentLink("id", "tipoColaborador.id");
        tipoColaboraborLookup.addLookup2ParentLink("nome", "tipoColaborador.nome");
        tipoColaboraborLookup.setHeaderColumnName("id", "ID");
        tipoColaboraborLookup.setHeaderColumnName("nome", "Nome");
        tipoColaboraborLookup.setFrameTitle("Importa Tipo Colaborador");

        tipoColaboraborLookup.setVisibleStatusPanel(true);
        tipoColaboraborLookup.setVisibleColumn("id", true);
        tipoColaboraborLookup.setVisibleColumn("nome", true);
        tipoColaboraborLookup.setFramePreferedSize(new Dimension(600, 500));

        tipoColaboraborLookup.setLookupDataLocator(new LookupDataLocatorGenerico(tipoColaboraborLookup.getLookupValueObjectClassName()));
        codLookupControlTipo.setLookupController(tipoColaboraborLookup);

        /*
        * Configuração do Lookup para o Tipo Situação Colaborador
         */
        situacaoColaboradorLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SituacaoColaboradorVO");
        situacaoColaboradorLookup.addLookup2ParentLink("id", "situacaoColaborador.id");
        situacaoColaboradorLookup.addLookup2ParentLink("nome", "situacaoColaborador.nome");
        situacaoColaboradorLookup.setHeaderColumnName("id", "ID");
        situacaoColaboradorLookup.setHeaderColumnName("nome", "Nome");
        situacaoColaboradorLookup.setFrameTitle("Importa Situacao Colaborador");

        situacaoColaboradorLookup.setVisibleStatusPanel(true);
        situacaoColaboradorLookup.setVisibleColumn("id", true);
        situacaoColaboradorLookup.setVisibleColumn("nome", true);
        situacaoColaboradorLookup.setFramePreferedSize(new Dimension(600, 500));

        situacaoColaboradorLookup.setLookupDataLocator(new LookupDataLocatorGenerico(situacaoColaboradorLookup.getLookupValueObjectClassName()));
        codLookupControlSituacao.setLookupController(situacaoColaboradorLookup);

        /*
        * Configuração do Lookup para o Tipo Admissão do Colaborador
         */
        tipoAdmissaoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.TipoAdmissaoVO");
        tipoAdmissaoLookup.addLookup2ParentLink("id", "tipoAdmissao.id");
        tipoAdmissaoLookup.addLookup2ParentLink("nome", "tipoAdmissao.nome");
        tipoAdmissaoLookup.setHeaderColumnName("id", "ID");
        tipoAdmissaoLookup.setHeaderColumnName("nome", "Nome");
        tipoAdmissaoLookup.setFrameTitle("Importa Tipo Admissao");

        tipoAdmissaoLookup.setVisibleStatusPanel(true);
        tipoAdmissaoLookup.setVisibleColumn("id", true);
        tipoAdmissaoLookup.setVisibleColumn("nome", true);
        tipoAdmissaoLookup.setFramePreferedSize(new Dimension(600, 500));

        tipoAdmissaoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(tipoAdmissaoLookup.getLookupValueObjectClassName()));
        codLookupControlTipoAdmissao.setLookupController(tipoAdmissaoLookup);

        /*
        * Configuração do Lookup para o Nível Formação
         */
        nivelFormacaoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.NivelFormacaoVO");
        nivelFormacaoLookup.addLookup2ParentLink("id", "nivelFormacao.id");
        nivelFormacaoLookup.addLookup2ParentLink("nome", "nivelFormacao.nome");
        nivelFormacaoLookup.setHeaderColumnName("id", "ID");
        nivelFormacaoLookup.setHeaderColumnName("nome", "Nome");
        nivelFormacaoLookup.setFrameTitle("Importa Nivel Formacao");

        nivelFormacaoLookup.setVisibleStatusPanel(true);
        nivelFormacaoLookup.setVisibleColumn("id", true);
        nivelFormacaoLookup.setVisibleColumn("nome", true);
        nivelFormacaoLookup.setFramePreferedSize(new Dimension(600, 500));

        nivelFormacaoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(nivelFormacaoLookup.getLookupValueObjectClassName()));
        codLookupControlNivelFormacao.setLookupController(nivelFormacaoLookup);

        /*
        * Configuração do Lookup para o Cargo
         */
        cargoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.CargoVO");
        cargoLookup.addLookup2ParentLink("id", "cargo.id");
        cargoLookup.addLookup2ParentLink("nome", "cargo.nome");
        cargoLookup.setHeaderColumnName("id", "ID");
        cargoLookup.setHeaderColumnName("nome", "Nome");
        cargoLookup.setFrameTitle("Importa Cargo");

        cargoLookup.setVisibleStatusPanel(true);
        cargoLookup.setVisibleColumn("id", true);
        cargoLookup.setVisibleColumn("nome", true);
        cargoLookup.setFramePreferedSize(new Dimension(600, 500));

        cargoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(cargoLookup.getLookupValueObjectClassName()));
        codLookupControlCargo.setLookupController(cargoLookup);

        /*
        * Configuração do Lookup para o Conta Contábil
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
        codLookupControlContabilConta.setLookupController(contaContabilLookup);

        /*
        * Configuração do Lookup para o Setor
         */
        setorLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SetorVO");
        setorLookup.addLookup2ParentLink("id", "setor.id");
        setorLookup.addLookup2ParentLink("nome", "setor.nome");
        setorLookup.setHeaderColumnName("id", "ID");
        setorLookup.setHeaderColumnName("nome", "Nome");
        setorLookup.setFrameTitle("Importa Setor");

        setorLookup.setVisibleStatusPanel(true);
        setorLookup.setVisibleColumn("id", true);
        setorLookup.setVisibleColumn("nome", true);
        setorLookup.setFramePreferedSize(new Dimension(600, 500));

        setorLookup.setLookupDataLocator(new LookupDataLocatorGenerico(setorLookup.getLookupValueObjectClassName()));
        codLookupControlSetor.setLookupController(setorLookup);

        /*
        * Configuração do Lookup para o Tipo Sindicato
         */
        sindicatoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SindicatoVO");
        sindicatoLookup.addLookup2ParentLink("id", "sindicato.id");
        sindicatoLookup.addLookup2ParentLink("nome", "sindicato.nome");
        sindicatoLookup.setHeaderColumnName("id", "ID");
        sindicatoLookup.setHeaderColumnName("nome", "Nome");
        sindicatoLookup.setFrameTitle("Importa Sindicato");

        sindicatoLookup.setVisibleStatusPanel(true);
        sindicatoLookup.setVisibleColumn("id", true);
        sindicatoLookup.setVisibleColumn("nome", true);
        sindicatoLookup.setFramePreferedSize(new Dimension(600, 500));

        sindicatoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(sindicatoLookup.getLookupValueObjectClassName()));
        codLookupControlSindicato.setLookupController(sindicatoLookup);
    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return formColaborador;
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
        formColaborador = new org.openswing.swing.form.client.Form();
        jTabbedPaneDados = new javax.swing.JTabbedPane();
        jPanelDadosPrincipais = new javax.swing.JPanel();
        lblPessoa = new org.openswing.swing.client.LabelControl();
        codLookupControlPessoa = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        lblTipo = new org.openswing.swing.client.LabelControl();
        codLookupControlTipo = new org.openswing.swing.client.CodLookupControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        lblSituacao = new org.openswing.swing.client.LabelControl();
        codLookupControlSituacao = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        lblTipoAdmissao = new org.openswing.swing.client.LabelControl();
        codLookupControlTipoAdmissao = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        lblNivelFormacao = new org.openswing.swing.client.LabelControl();
        codLookupControlNivelFormacao = new org.openswing.swing.client.CodLookupControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        lblCargo = new org.openswing.swing.client.LabelControl();
        codLookupControlCargo = new org.openswing.swing.client.CodLookupControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        lblSetor = new org.openswing.swing.client.LabelControl();
        codLookupControlSetor = new org.openswing.swing.client.CodLookupControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblContabilConta = new org.openswing.swing.client.LabelControl();
        codLookupControlContabilConta = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        lblSindicato = new org.openswing.swing.client.LabelControl();
        codLookupControlSindicato = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        lblDataCadastro = new org.openswing.swing.client.LabelControl();
        dateControl13 = new org.openswing.swing.client.DateControl();
        lblDataAdmissao = new org.openswing.swing.client.LabelControl();
        dateControl14 = new org.openswing.swing.client.DateControl();
        labelControl23 = new org.openswing.swing.client.LabelControl();
        dateControl15 = new org.openswing.swing.client.DateControl();
        labelControl24 = new org.openswing.swing.client.LabelControl();
        dateControl16 = new org.openswing.swing.client.DateControl();
        labelControl53 = new org.openswing.swing.client.LabelControl();
        dateControl45 = new org.openswing.swing.client.DateControl();
        lblDescontoPlanoSaúde = new org.openswing.swing.client.LabelControl();
        comboBoxControl37 = new org.openswing.swing.client.ComboBoxControl();
        lblSaiNaRais = new org.openswing.swing.client.LabelControl();
        comboBoxControl38 = new org.openswing.swing.client.ComboBoxControl();
        labelControl54 = new org.openswing.swing.client.LabelControl();
        textControl46 = new org.openswing.swing.client.TextControl();
        lblObservacao = new org.openswing.swing.client.LabelControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelOutrasInf = new javax.swing.JPanel();
        jPanelExameMedico = new javax.swing.JPanel();
        lblExameMedicoUltimo = new org.openswing.swing.client.LabelControl();
        dateControl26 = new org.openswing.swing.client.DateControl();
        dateControl27 = new org.openswing.swing.client.DateControl();
        lblExameMedicoVenc = new org.openswing.swing.client.LabelControl();
        jPanelSefip = new javax.swing.JPanel();
        lblOcorrenciaSefip = new org.openswing.swing.client.LabelControl();
        numericControl41 = new org.openswing.swing.client.NumericControl();
        lblCategSefip = new org.openswing.swing.client.LabelControl();
        textControl39 = new org.openswing.swing.client.TextControl();
        lblCodDemissaoSefip = new org.openswing.swing.client.LabelControl();
        numericControl44 = new org.openswing.swing.client.NumericControl();
        jPanelCaged = new javax.swing.JPanel();
        lblCodAdCaged = new org.openswing.swing.client.LabelControl();
        numericControl42 = new org.openswing.swing.client.NumericControl();
        lblCodDemCaged = new org.openswing.swing.client.LabelControl();
        numericControl43 = new org.openswing.swing.client.NumericControl();
        jPanelFgts = new javax.swing.JPanel();
        lblFgtsOptante = new org.openswing.swing.client.LabelControl();
        comboBoxControl17 = new org.openswing.swing.client.ComboBoxControl();
        dateControl18 = new org.openswing.swing.client.DateControl();
        lblFgtsDataOpcao = new org.openswing.swing.client.LabelControl();
        numericControl19 = new org.openswing.swing.client.NumericControl();
        lblFgtsConta = new org.openswing.swing.client.LabelControl();
        jPanelCarteiraProf = new javax.swing.JPanel();
        lblCtpsNumero = new org.openswing.swing.client.LabelControl();
        textControl33 = new org.openswing.swing.client.TextControl();
        lblCtpsSerie = new org.openswing.swing.client.LabelControl();
        textControl34 = new org.openswing.swing.client.TextControl();
        lblCtpsDatExp = new org.openswing.swing.client.LabelControl();
        dateControl35 = new org.openswing.swing.client.DateControl();
        lblCtpsUf = new org.openswing.swing.client.LabelControl();
        textControl36 = new org.openswing.swing.client.TextControl();
        jPanelpagamento = new javax.swing.JPanel();
        labelControl28 = new org.openswing.swing.client.LabelControl();
        comboBoxControl20 = new org.openswing.swing.client.ComboBoxControl();
        lblBanco = new org.openswing.swing.client.LabelControl();
        textControl21 = new org.openswing.swing.client.TextControl();
        lblAgencia = new org.openswing.swing.client.LabelControl();
        textControl22 = new org.openswing.swing.client.TextControl();
        lblDV1 = new org.openswing.swing.client.LabelControl();
        lblConta = new org.openswing.swing.client.LabelControl();
        textControl24 = new org.openswing.swing.client.TextControl();
        lblDV2 = new org.openswing.swing.client.LabelControl();
        textControl25 = new org.openswing.swing.client.TextControl();
        textControl26 = new org.openswing.swing.client.TextControl();
        jPanelPis = new javax.swing.JPanel();
        lblPisDataCadastro = new org.openswing.swing.client.LabelControl();
        dateControl28 = new org.openswing.swing.client.DateControl();
        lblPisNumero = new org.openswing.swing.client.LabelControl();
        textControl29 = new org.openswing.swing.client.TextControl();
        textControl30 = new org.openswing.swing.client.TextControl();
        lblPisBanco = new org.openswing.swing.client.LabelControl();
        lblPisAgencia = new org.openswing.swing.client.LabelControl();
        textControl31 = new org.openswing.swing.client.TextControl();
        lblPisAgenciaDigito = new org.openswing.swing.client.LabelControl();
        textControl32 = new org.openswing.swing.client.TextControl();
        jSeparator2 = new javax.swing.JSeparator();

        setTitle("Bakery Factory - Colaborador Detalhes");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Colaborador"));
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

        formColaborador.setVOClassName("com.bakeryfactory.cadastros.java.ColaboradorVO");
        formColaborador.setEditButton(editButton1);
        formColaborador.setFunctionId("colaborador");
        formColaborador.setReloadButton(reloadButton1);
        formColaborador.setSaveButton(saveButton1);
        formColaborador.setLayout(new java.awt.CardLayout());

        jPanelDadosPrincipais.setLayout(new java.awt.GridBagLayout());

        lblPessoa.setLabel("Pessoa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblPessoa, gridBagConstraints);

        codLookupControlPessoa.setAllowOnlyNumbers(true);
        codLookupControlPessoa.setAttributeName("pessoa.id");
        codLookupControlPessoa.setEnabled(false);
        codLookupControlPessoa.setLinkLabel(lblPessoa);
        codLookupControlPessoa.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlPessoa, gridBagConstraints);

        textControl6.setAttributeName("pessoa.nome");
        textControl6.setEnabled(false);
        textControl6.setEnabledOnEdit(false);
        textControl6.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl6, gridBagConstraints);

        lblTipo.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblTipo, gridBagConstraints);

        codLookupControlTipo.setAllowOnlyNumbers(true);
        codLookupControlTipo.setAttributeName("tipoColaborador.id");
        codLookupControlTipo.setEnabled(false);
        codLookupControlTipo.setLinkLabel(lblTipo);
        codLookupControlTipo.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlTipo, gridBagConstraints);

        textControl7.setAttributeName("tipoColaborador.nome");
        textControl7.setEnabled(false);
        textControl7.setEnabledOnEdit(false);
        textControl7.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl7, gridBagConstraints);

        lblSituacao.setText("Situação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblSituacao, gridBagConstraints);

        codLookupControlSituacao.setAllowOnlyNumbers(true);
        codLookupControlSituacao.setAttributeName("situacaoColaborador.id");
        codLookupControlSituacao.setEnabled(false);
        codLookupControlSituacao.setLinkLabel(lblSituacao);
        codLookupControlSituacao.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlSituacao, gridBagConstraints);

        textControl5.setAttributeName("situacaoColaborador.nome");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl5, gridBagConstraints);

        lblTipoAdmissao.setText("Tipo Admissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblTipoAdmissao, gridBagConstraints);

        codLookupControlTipoAdmissao.setAttributeName("idtipoadmissao.id");
        codLookupControlTipoAdmissao.setEnabled(false);
        codLookupControlTipoAdmissao.setLinkLabel(lblTipoAdmissao);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlTipoAdmissao, gridBagConstraints);

        textControl4.setAttributeName("tipoAdmissao.nome");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl4, gridBagConstraints);

        lblNivelFormacao.setText("Nivel Formação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblNivelFormacao, gridBagConstraints);

        codLookupControlNivelFormacao.setAllowOnlyNumbers(true);
        codLookupControlNivelFormacao.setAttributeName("nivelFormacao.id");
        codLookupControlNivelFormacao.setEnabled(false);
        codLookupControlNivelFormacao.setLinkLabel(lblNivelFormacao);
        codLookupControlNivelFormacao.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlNivelFormacao, gridBagConstraints);

        textControl8.setAttributeName("nivelFormacao.nome");
        textControl8.setEnabled(false);
        textControl8.setEnabledOnEdit(false);
        textControl8.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl8, gridBagConstraints);

        lblCargo.setLabel("Cargo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblCargo, gridBagConstraints);

        codLookupControlCargo.setAllowOnlyNumbers(true);
        codLookupControlCargo.setAttributeName("cargo.id");
        codLookupControlCargo.setEnabled(false);
        codLookupControlCargo.setLinkLabel(lblCargo);
        codLookupControlCargo.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlCargo, gridBagConstraints);

        textControl9.setAttributeName("cargo.nome");
        textControl9.setEnabled(false);
        textControl9.setEnabledOnEdit(false);
        textControl9.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl9, gridBagConstraints);

        lblSetor.setLabel("Setor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblSetor, gridBagConstraints);

        codLookupControlSetor.setAllowOnlyNumbers(true);
        codLookupControlSetor.setAttributeName("setor.id");
        codLookupControlSetor.setEnabled(false);
        codLookupControlSetor.setLinkLabel(lblSetor);
        codLookupControlSetor.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlSetor, gridBagConstraints);

        textControl10.setAttributeName("setor.nome");
        textControl10.setEnabled(false);
        textControl10.setEnabledOnEdit(false);
        textControl10.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl10, gridBagConstraints);

        lblContabilConta.setText("Contábil Conta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblContabilConta, gridBagConstraints);

        codLookupControlContabilConta.setAllowOnlyNumbers(true);
        codLookupControlContabilConta.setAttributeName("contabilConta.id");
        codLookupControlContabilConta.setEnabled(false);
        codLookupControlContabilConta.setLinkLabel(lblContabilConta);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlContabilConta, gridBagConstraints);

        textControl2.setAttributeName("contabilConta.descricao");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl2, gridBagConstraints);

        lblSindicato.setLabel("Sindicato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblSindicato, gridBagConstraints);

        codLookupControlSindicato.setAllowOnlyNumbers(true);
        codLookupControlSindicato.setAttributeName("sindicato.id");
        codLookupControlSindicato.setEnabled(false);
        codLookupControlSindicato.setLinkLabel(lblSindicato);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(codLookupControlSindicato, gridBagConstraints);

        textControl3.setAttributeName("sindicato.nome");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl3, gridBagConstraints);

        lblDataCadastro.setLabel("Data Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblDataCadastro, gridBagConstraints);

        dateControl13.setAttributeName("dataCadastro");
        dateControl13.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(dateControl13, gridBagConstraints);

        lblDataAdmissao.setText("Data Admissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblDataAdmissao, gridBagConstraints);

        dateControl14.setAttributeName("dataAdmissao");
        dateControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(dateControl14, gridBagConstraints);

        labelControl23.setText("Vencimento Férias:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(labelControl23, gridBagConstraints);

        dateControl15.setAttributeName("vencimentoFerias");
        dateControl15.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(dateControl15, gridBagConstraints);

        labelControl24.setText("Data Transferência:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(labelControl24, gridBagConstraints);

        dateControl16.setAttributeName("dataTransferencia");
        dateControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(dateControl16, gridBagConstraints);

        labelControl53.setText("Data Demissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(labelControl53, gridBagConstraints);

        dateControl45.setAttributeName("dataDemissao");
        dateControl45.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(dateControl45, gridBagConstraints);

        lblDescontoPlanoSaúde.setText("Desconto Plano Saúde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblDescontoPlanoSaúde, gridBagConstraints);

        comboBoxControl37.setAttributeName("descontoPlanoSaude");
        comboBoxControl37.setDomainId("simnao");
        comboBoxControl37.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(comboBoxControl37, gridBagConstraints);

        lblSaiNaRais.setLabel("Sai Na Rais:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblSaiNaRais, gridBagConstraints);

        comboBoxControl38.setAttributeName("saiNaRais");
        comboBoxControl38.setDomainId("simnao");
        comboBoxControl38.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(comboBoxControl38, gridBagConstraints);

        labelControl54.setText("Código Turma Ponto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(labelControl54, gridBagConstraints);

        textControl46.setAttributeName("codigoTurmaPonto");
        textControl46.setEnabled(false);
        textControl46.setMaxCharacters(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textControl46, gridBagConstraints);

        lblObservacao.setText("Observação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDadosPrincipais.add(lblObservacao, gridBagConstraints);

        textAreaControl1.setAttributeName("observacao");
        textAreaControl1.setEnabled(false);
        textAreaControl1.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDadosPrincipais.add(textAreaControl1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelDadosPrincipais.add(jSeparator1, gridBagConstraints);

        jTabbedPaneDados.addTab("Dados Principais", jPanelDadosPrincipais);

        jPanelOutrasInf.setLayout(new java.awt.GridBagLayout());

        jPanelExameMedico.setBorder(javax.swing.BorderFactory.createTitledBorder("Exame Médico"));
        jPanelExameMedico.setLayout(new java.awt.GridBagLayout());

        lblExameMedicoUltimo.setText("Exame Médico Último:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelExameMedico.add(lblExameMedicoUltimo, gridBagConstraints);

        dateControl26.setAttributeName("exameMedicoUltimo");
        dateControl26.setEnabled(false);
        dateControl26.setLinkLabel(lblExameMedicoUltimo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelExameMedico.add(dateControl26, gridBagConstraints);

        dateControl27.setAttributeName("exameMedicoVencimento");
        dateControl27.setEnabled(false);
        dateControl27.setLinkLabel(lblExameMedicoVenc);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelExameMedico.add(dateControl27, gridBagConstraints);

        lblExameMedicoVenc.setText("Exame Médico Vencimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelExameMedico.add(lblExameMedicoVenc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelExameMedico, gridBagConstraints);

        jPanelSefip.setBorder(javax.swing.BorderFactory.createTitledBorder("Sefip"));
        jPanelSefip.setLayout(new java.awt.GridBagLayout());

        lblOcorrenciaSefip.setLabel("Ocorrencia Sefip:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelSefip.add(lblOcorrenciaSefip, gridBagConstraints);

        numericControl41.setAttributeName("ocorrenciaSefip");
        numericControl41.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelSefip.add(numericControl41, gridBagConstraints);

        lblCategSefip.setLabel("Categoria Sefip:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelSefip.add(lblCategSefip, gridBagConstraints);

        textControl39.setAttributeName("categoriaSefip");
        textControl39.setEnabled(false);
        textControl39.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelSefip.add(textControl39, gridBagConstraints);

        lblCodDemissaoSefip.setText("Código Demissão Sefip:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelSefip.add(lblCodDemissaoSefip, gridBagConstraints);

        numericControl44.setAttributeName("codigoDemissaoSefip");
        numericControl44.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelSefip.add(numericControl44, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelSefip, gridBagConstraints);

        jPanelCaged.setBorder(javax.swing.BorderFactory.createTitledBorder("Caged"));
        jPanelCaged.setLayout(new java.awt.GridBagLayout());

        lblCodAdCaged.setText("Código Admissão Caged:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCaged.add(lblCodAdCaged, gridBagConstraints);

        numericControl42.setAttributeName("codigoAdmissaoCaged");
        numericControl42.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCaged.add(numericControl42, gridBagConstraints);

        lblCodDemCaged.setText("Código Demissão Caged:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCaged.add(lblCodDemCaged, gridBagConstraints);

        numericControl43.setAttributeName("codigoDemissaoCaged");
        numericControl43.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCaged.add(numericControl43, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelCaged, gridBagConstraints);

        jPanelFgts.setBorder(javax.swing.BorderFactory.createTitledBorder("FGTS"));
        jPanelFgts.setLayout(new java.awt.GridBagLayout());

        lblFgtsOptante.setLabel("Fgts Optante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelFgts.add(lblFgtsOptante, gridBagConstraints);

        comboBoxControl17.setAttributeName("fgtsOptante");
        comboBoxControl17.setDomainId("simnao");
        comboBoxControl17.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelFgts.add(comboBoxControl17, gridBagConstraints);

        dateControl18.setAttributeName("fgtsDataOpcao");
        dateControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelFgts.add(dateControl18, gridBagConstraints);

        lblFgtsDataOpcao.setText("Fgts Data Opção:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelFgts.add(lblFgtsDataOpcao, gridBagConstraints);

        numericControl19.setAttributeName("fgtsConta");
        numericControl19.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelFgts.add(numericControl19, gridBagConstraints);

        lblFgtsConta.setLabel("Fgts Conta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelFgts.add(lblFgtsConta, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelFgts, gridBagConstraints);

        jPanelCarteiraProf.setBorder(javax.swing.BorderFactory.createTitledBorder("Carteira Profissional"));
        jPanelCarteiraProf.setLayout(new java.awt.GridBagLayout());

        lblCtpsNumero.setText("Ctps Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCarteiraProf.add(lblCtpsNumero, gridBagConstraints);

        textControl33.setAttributeName("ctpsNumero");
        textControl33.setEnabled(false);
        textControl33.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCarteiraProf.add(textControl33, gridBagConstraints);

        lblCtpsSerie.setText("Ctps Série:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCarteiraProf.add(lblCtpsSerie, gridBagConstraints);

        textControl34.setAttributeName("ctpsSerie");
        textControl34.setEnabled(false);
        textControl34.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCarteiraProf.add(textControl34, gridBagConstraints);

        lblCtpsDatExp.setLabel("Ctps Data Expedicao:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCarteiraProf.add(lblCtpsDatExp, gridBagConstraints);

        dateControl35.setAttributeName("ctpsDataExpedicao");
        dateControl35.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCarteiraProf.add(dateControl35, gridBagConstraints);

        lblCtpsUf.setLabel("Ctps Uf:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelCarteiraProf.add(lblCtpsUf, gridBagConstraints);

        textControl36.setAttributeName("ctpsUf");
        textControl36.setEnabled(false);
        textControl36.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelCarteiraProf.add(textControl36, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelCarteiraProf, gridBagConstraints);

        jPanelpagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));
        jPanelpagamento.setLayout(new java.awt.GridBagLayout());

        labelControl28.setLabel("Pagamento Forma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(labelControl28, gridBagConstraints);

        comboBoxControl20.setAttributeName("pagamentoForma");
        comboBoxControl20.setDomainId("colaboradorFormaPagamento");
        comboBoxControl20.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(comboBoxControl20, gridBagConstraints);

        lblBanco.setLabel("Banco:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(lblBanco, gridBagConstraints);

        textControl21.setAttributeName("pagamentoBanco");
        textControl21.setEnabled(false);
        textControl21.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(textControl21, gridBagConstraints);

        lblAgencia.setText("Agência:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(lblAgencia, gridBagConstraints);

        textControl22.setAttributeName("pagamentoAgencia");
        textControl22.setEnabled(false);
        textControl22.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(textControl22, gridBagConstraints);

        lblDV1.setLabel("DV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(lblDV1, gridBagConstraints);

        lblConta.setLabel("Conta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(lblConta, gridBagConstraints);

        textControl24.setAttributeName("pagamentoConta");
        textControl24.setEnabled(false);
        textControl24.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(textControl24, gridBagConstraints);

        lblDV2.setLabel("DV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelpagamento.add(lblDV2, gridBagConstraints);

        textControl25.setAttributeName("pagamentoConta");
        textControl25.setEnabled(false);
        textControl25.setMaxCharacters(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(textControl25, gridBagConstraints);

        textControl26.setAttributeName("pagamentoConta");
        textControl26.setEnabled(false);
        textControl26.setMaxCharacters(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelpagamento.add(textControl26, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelpagamento, gridBagConstraints);

        jPanelPis.setBorder(javax.swing.BorderFactory.createTitledBorder("PIS"));
        jPanelPis.setLayout(new java.awt.GridBagLayout());

        lblPisDataCadastro.setLabel("Pis Data Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPis.add(lblPisDataCadastro, gridBagConstraints);

        dateControl28.setAttributeName("pisDataCadastro");
        dateControl28.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPis.add(dateControl28, gridBagConstraints);

        lblPisNumero.setText("Pis Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPis.add(lblPisNumero, gridBagConstraints);

        textControl29.setAttributeName("pisNumero");
        textControl29.setEnabled(false);
        textControl29.setMaxCharacters(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPis.add(textControl29, gridBagConstraints);

        textControl30.setAttributeName("pisBanco");
        textControl30.setEnabled(false);
        textControl30.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPis.add(textControl30, gridBagConstraints);

        lblPisBanco.setLabel("Pis Banco:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPis.add(lblPisBanco, gridBagConstraints);

        lblPisAgencia.setText("Pis Agência:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPis.add(lblPisAgencia, gridBagConstraints);

        textControl31.setAttributeName("pisAgencia");
        textControl31.setEnabled(false);
        textControl31.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPis.add(textControl31, gridBagConstraints);

        lblPisAgenciaDigito.setText("Pis Agência Dígito:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPis.add(lblPisAgenciaDigito, gridBagConstraints);

        textControl32.setAttributeName("pisAgencia");
        textControl32.setEnabled(false);
        textControl32.setMaxCharacters(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPis.add(textControl32, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelOutrasInf.add(jPanelPis, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelOutrasInf.add(jSeparator2, gridBagConstraints);

        jTabbedPaneDados.addTab("Outras Informações", jPanelOutrasInf);

        formColaborador.add(jTabbedPaneDados, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(formColaborador, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControlCargo;
    private org.openswing.swing.client.CodLookupControl codLookupControlContabilConta;
    private org.openswing.swing.client.CodLookupControl codLookupControlNivelFormacao;
    private org.openswing.swing.client.CodLookupControl codLookupControlPessoa;
    private org.openswing.swing.client.CodLookupControl codLookupControlSetor;
    private org.openswing.swing.client.CodLookupControl codLookupControlSindicato;
    private org.openswing.swing.client.CodLookupControl codLookupControlSituacao;
    private org.openswing.swing.client.CodLookupControl codLookupControlTipo;
    private org.openswing.swing.client.CodLookupControl codLookupControlTipoAdmissao;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl17;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl20;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl37;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl38;
    private org.openswing.swing.client.DateControl dateControl13;
    private org.openswing.swing.client.DateControl dateControl14;
    private org.openswing.swing.client.DateControl dateControl15;
    private org.openswing.swing.client.DateControl dateControl16;
    private org.openswing.swing.client.DateControl dateControl18;
    private org.openswing.swing.client.DateControl dateControl26;
    private org.openswing.swing.client.DateControl dateControl27;
    private org.openswing.swing.client.DateControl dateControl28;
    private org.openswing.swing.client.DateControl dateControl35;
    private org.openswing.swing.client.DateControl dateControl45;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form formColaborador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCaged;
    private javax.swing.JPanel jPanelCarteiraProf;
    private javax.swing.JPanel jPanelDadosPrincipais;
    private javax.swing.JPanel jPanelExameMedico;
    private javax.swing.JPanel jPanelFgts;
    private javax.swing.JPanel jPanelOutrasInf;
    private javax.swing.JPanel jPanelPis;
    private javax.swing.JPanel jPanelSefip;
    private javax.swing.JPanel jPanelpagamento;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneDados;
    private org.openswing.swing.client.LabelControl labelControl23;
    private org.openswing.swing.client.LabelControl labelControl24;
    private org.openswing.swing.client.LabelControl labelControl28;
    private org.openswing.swing.client.LabelControl labelControl53;
    private org.openswing.swing.client.LabelControl labelControl54;
    private org.openswing.swing.client.LabelControl lblAgencia;
    private org.openswing.swing.client.LabelControl lblBanco;
    private org.openswing.swing.client.LabelControl lblCargo;
    private org.openswing.swing.client.LabelControl lblCategSefip;
    private org.openswing.swing.client.LabelControl lblCodAdCaged;
    private org.openswing.swing.client.LabelControl lblCodDemCaged;
    private org.openswing.swing.client.LabelControl lblCodDemissaoSefip;
    private org.openswing.swing.client.LabelControl lblConta;
    private org.openswing.swing.client.LabelControl lblContabilConta;
    private org.openswing.swing.client.LabelControl lblCtpsDatExp;
    private org.openswing.swing.client.LabelControl lblCtpsNumero;
    private org.openswing.swing.client.LabelControl lblCtpsSerie;
    private org.openswing.swing.client.LabelControl lblCtpsUf;
    private org.openswing.swing.client.LabelControl lblDV1;
    private org.openswing.swing.client.LabelControl lblDV2;
    private org.openswing.swing.client.LabelControl lblDataAdmissao;
    private org.openswing.swing.client.LabelControl lblDataCadastro;
    private org.openswing.swing.client.LabelControl lblDescontoPlanoSaúde;
    private org.openswing.swing.client.LabelControl lblExameMedicoUltimo;
    private org.openswing.swing.client.LabelControl lblExameMedicoVenc;
    private org.openswing.swing.client.LabelControl lblFgtsConta;
    private org.openswing.swing.client.LabelControl lblFgtsDataOpcao;
    private org.openswing.swing.client.LabelControl lblFgtsOptante;
    private org.openswing.swing.client.LabelControl lblNivelFormacao;
    private org.openswing.swing.client.LabelControl lblObservacao;
    private org.openswing.swing.client.LabelControl lblOcorrenciaSefip;
    private org.openswing.swing.client.LabelControl lblPessoa;
    private org.openswing.swing.client.LabelControl lblPisAgencia;
    private org.openswing.swing.client.LabelControl lblPisAgenciaDigito;
    private org.openswing.swing.client.LabelControl lblPisBanco;
    private org.openswing.swing.client.LabelControl lblPisDataCadastro;
    private org.openswing.swing.client.LabelControl lblPisNumero;
    private org.openswing.swing.client.LabelControl lblSaiNaRais;
    private org.openswing.swing.client.LabelControl lblSetor;
    private org.openswing.swing.client.LabelControl lblSindicato;
    private org.openswing.swing.client.LabelControl lblSituacao;
    private org.openswing.swing.client.LabelControl lblTipo;
    private org.openswing.swing.client.LabelControl lblTipoAdmissao;
    private org.openswing.swing.client.NumericControl numericControl19;
    private org.openswing.swing.client.NumericControl numericControl41;
    private org.openswing.swing.client.NumericControl numericControl42;
    private org.openswing.swing.client.NumericControl numericControl43;
    private org.openswing.swing.client.NumericControl numericControl44;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl21;
    private org.openswing.swing.client.TextControl textControl22;
    private org.openswing.swing.client.TextControl textControl24;
    private org.openswing.swing.client.TextControl textControl25;
    private org.openswing.swing.client.TextControl textControl26;
    private org.openswing.swing.client.TextControl textControl29;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl30;
    private org.openswing.swing.client.TextControl textControl31;
    private org.openswing.swing.client.TextControl textControl32;
    private org.openswing.swing.client.TextControl textControl33;
    private org.openswing.swing.client.TextControl textControl34;
    private org.openswing.swing.client.TextControl textControl36;
    private org.openswing.swing.client.TextControl textControl39;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl46;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables
}
