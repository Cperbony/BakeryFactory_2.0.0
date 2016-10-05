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
import javax.swing.text.MaskFormatter;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class PessoaDetalhe extends InternalFrame {

    private PessoaFisicaDetalheController pessoaFisicaController;
    private PessoaJuridicaDetalheController pessoaJuridicaController;
    private PessoaContatoGridController contatoController;
    private PessoaEnderecoGridController enderecoController;
    private PessoaTelefoneGridController telefoneController;
    private LookupController estadoCivilController = new LookupController();

    /**
     * Creates new form PessoaDetalhe
     */
    public PessoaDetalhe(PessoaDetalheController controller) {
        initComponents();

        formattedTextControlCpf.setEnabled(false);
        formattedTextControlCnpj.setEnabled(false);

        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/###-##");
            mask.setValidCharacters("0123456789");
            mask.setValueContainsLiteralCharacters(false);
            formattedTextControlCnpj.setFormatter(mask);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        form1.setFormController(controller);

        pessoaFisicaController = new PessoaFisicaDetalheController();
        formPessoaFisica.setFormController(pessoaFisicaController);

        pessoaJuridicaController = new PessoaJuridicaDetalheController();
        formPessoaJuridica.setFormController(pessoaJuridicaController);

        contatoController = new PessoaContatoGridController(this);
        gridControlContatos.setController(contatoController);
        gridControlContatos.setGridDataLocator(contatoController);

        enderecoController = new PessoaEnderecoGridController(this);
        gridControlEndereco.setController(enderecoController);
        gridControlEndereco.setGridDataLocator(enderecoController);
        
        telefoneController = new PessoaTelefoneGridController(this);
        gridControlTelefone.setController(telefoneController);
        gridControlTelefone.setGridDataLocator(telefoneController);
        
        
        /*
        * Configurações do lookup do estado civil
        */
        
        estadoCivilController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.EstadoCivilVO");
        estadoCivilController.addLookup2ParentLink("id", "estadoCivil.id");
        estadoCivilController.addLookup2ParentLink("nome", "estadoCivil.nome");
        estadoCivilController.setHeaderColumnName("id", "ID");
        estadoCivilController.setHeaderColumnName("nome", "Nome");
        estadoCivilController.setFrameTitle("Importa Estado Civil");
        
        estadoCivilController.setVisibleStatusPanel(true);
        estadoCivilController.setVisibleColumn("id", true);
        estadoCivilController.setVisibleColumn("nome", true);
        estadoCivilController.setFramePreferedSize(new Dimension(600, 500));
        
        estadoCivilController.setLookupDataLocator(new LookupDataLocatorGenerico(estadoCivilController.getLookupValueObjectClassName()));
        codLookupEstadoCivil.setLookupController(estadoCivilController);

    }

    /**
     *
     * @return o Form vinculado
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    //retorna o Form Vinculado à Pessoa Física
    public org.openswing.swing.form.client.Form getFormPessoaFisica() {
        return formPessoaFisica;
    }

    //retorna o Form Vinculado à Pessoa Juridica
    public org.openswing.swing.form.client.Form getFormPessoaJuridica() {
        return formPessoaJuridica;
    }

    /**
     *
     * @return GRIDS
     */
    //retorna a GRID Vinculada à Pessoa Contatos
    public org.openswing.swing.client.GridControl getGridControlContatos() {
        return gridControlContatos;
    }

    //retorna a GRID Vinculada à Pessoa Endereco
    public org.openswing.swing.client.GridControl getGridControlEndereco() {
        return gridControlEndereco;
    }
    
         //retorna a GRID Vinculada à Pessoa Telefone
   public org.openswing.swing.client.GridControl getGridControlTelefone(){
      return gridControlTelefone;
  }
   
   /**
    * 
    * @return DetalheController
    */

    public PessoaFisicaDetalheController getPessoaFisicaController() {
        return pessoaFisicaController;
    }

    public PessoaJuridicaDetalheController getPessoaJuridicaController() {
        return pessoaJuridicaController;
    }

    public PessoaContatoGridController getContatoController() {
        return contatoController;
    }

    public PessoaEnderecoGridController getEnderecoController() {
        return enderecoController;
    }

    public PessoaTelefoneGridController getTelefoneController() {
        return telefoneController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        lblNome = new org.openswing.swing.client.LabelControl();
        textControl1 = new org.openswing.swing.client.TextControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        lblEmail = new org.openswing.swing.client.LabelControl();
        lblTipo = new org.openswing.swing.client.LabelControl();
        comboBoxControl2 = new org.openswing.swing.client.ComboBoxControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        lblSite = new org.openswing.swing.client.LabelControl();
        jPanel2 = new javax.swing.JPanel();
        lblCliente = new org.openswing.swing.client.LabelControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        lblFornecedor = new org.openswing.swing.client.LabelControl();
        comboBoxControl3 = new org.openswing.swing.client.ComboBoxControl();
        lblColaborador = new org.openswing.swing.client.LabelControl();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        lblTransportadora = new org.openswing.swing.client.LabelControl();
        comboBoxControl5 = new org.openswing.swing.client.ComboBoxControl();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        formPessoaFisica = new org.openswing.swing.form.client.Form();
        lblEstadoCivil = new org.openswing.swing.client.LabelControl();
        codLookupEstadoCivil = new org.openswing.swing.client.CodLookupControl();
        lblCpf = new org.openswing.swing.client.LabelControl();
        lblDtaNascimento = new org.openswing.swing.client.LabelControl();
        dateControl8 = new org.openswing.swing.client.DateControl();
        lblSexo = new org.openswing.swing.client.LabelControl();
        comboBoxControl12 = new org.openswing.swing.client.ComboBoxControl();
        lblNaturalidade = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblNacionalidade = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        lblRaca = new org.openswing.swing.client.LabelControl();
        comboBoxControl13 = new org.openswing.swing.client.ComboBoxControl();
        lblTipoSangue = new org.openswing.swing.client.LabelControl();
        lblNomeMae = new org.openswing.swing.client.LabelControl();
        textControl22 = new org.openswing.swing.client.TextControl();
        lblNomePai = new org.openswing.swing.client.LabelControl();
        textControl23 = new org.openswing.swing.client.TextControl();
        jPanel7 = new javax.swing.JPanel();
        lblRG = new org.openswing.swing.client.LabelControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        lblOrgaoRg = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        dateControl7 = new org.openswing.swing.client.DateControl();
        lblDataEmissaoRg = new org.openswing.swing.client.LabelControl();
        jPanel8 = new javax.swing.JPanel();
        lblReservistaNum = new org.openswing.swing.client.LabelControl();
        textControl20 = new org.openswing.swing.client.TextControl();
        lblReservistaCategoria = new org.openswing.swing.client.LabelControl();
        numericControl21 = new org.openswing.swing.client.NumericControl();
        comboBoxControl14 = new org.openswing.swing.client.ComboBoxControl();
        jPanel9 = new javax.swing.JPanel();
        lblCnhNumero = new org.openswing.swing.client.LabelControl();
        textControl14 = new org.openswing.swing.client.TextControl();
        textControl15 = new org.openswing.swing.client.TextControl();
        lblCnhCategoria = new org.openswing.swing.client.LabelControl();
        dateControl16 = new org.openswing.swing.client.DateControl();
        lblCnhVencimento = new org.openswing.swing.client.LabelControl();
        jPanel12 = new javax.swing.JPanel();
        lblTitEleitoralNum = new org.openswing.swing.client.LabelControl();
        textControl17 = new org.openswing.swing.client.TextControl();
        lblTitEleitZona = new org.openswing.swing.client.LabelControl();
        numericControl18 = new org.openswing.swing.client.NumericControl();
        lblTitEleitoralSecao = new org.openswing.swing.client.LabelControl();
        numericControl19 = new org.openswing.swing.client.NumericControl();
        formattedTextControlCpf = new org.openswing.swing.client.FormattedTextControl();
        jSeparator1 = new javax.swing.JSeparator();
        formPessoaJuridica = new org.openswing.swing.form.client.Form();
        lblCnpj = new org.openswing.swing.client.LabelControl();
        lblFantasia = new org.openswing.swing.client.LabelControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        lblInscrMunicipal = new org.openswing.swing.client.LabelControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        lblInscEstadual = new org.openswing.swing.client.LabelControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        lblDataConstituicao = new org.openswing.swing.client.LabelControl();
        dateControl9 = new org.openswing.swing.client.DateControl();
        lblTipoRegime = new org.openswing.swing.client.LabelControl();
        comboBoxControl15 = new org.openswing.swing.client.ComboBoxControl();
        lblCrt = new org.openswing.swing.client.LabelControl();
        comboBoxControl16 = new org.openswing.swing.client.ComboBoxControl();
        lblSuframa = new org.openswing.swing.client.LabelControl();
        textControl13 = new org.openswing.swing.client.TextControl();
        formattedTextControlCnpj = new org.openswing.swing.client.FormattedTextControl();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton2 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        saveButton2 = new org.openswing.swing.client.SaveButton();
        reloadButton2 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();
        gridControlContatos = new org.openswing.swing.client.GridControl();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        insertButton2 = new org.openswing.swing.client.InsertButton();
        editButton3 = new org.openswing.swing.client.EditButton();
        deleteButton2 = new org.openswing.swing.client.DeleteButton();
        saveButton3 = new org.openswing.swing.client.SaveButton();
        reloadButton3 = new org.openswing.swing.client.ReloadButton();
        navigatorBar2 = new org.openswing.swing.client.NavigatorBar();
        gridControlEndereco = new org.openswing.swing.client.GridControl();
        textColumn9 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn10 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn11 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn12 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn13 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn14 = new org.openswing.swing.table.columns.client.TextColumn();
        integerColumn10 = new org.openswing.swing.table.columns.client.IntegerColumn();
        textColumn15 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn16 = new org.openswing.swing.table.columns.client.TextColumn();
        comboColumn14 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn15 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn16 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn17 = new org.openswing.swing.table.columns.client.ComboColumn();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        insertButton3 = new org.openswing.swing.client.InsertButton();
        editButton4 = new org.openswing.swing.client.EditButton();
        deleteButton3 = new org.openswing.swing.client.DeleteButton();
        saveButton4 = new org.openswing.swing.client.SaveButton();
        reloadButton4 = new org.openswing.swing.client.ReloadButton();
        navigatorBar3 = new org.openswing.swing.client.NavigatorBar();
        gridControlTelefone = new org.openswing.swing.client.GridControl();
        comboColumn1 = new org.openswing.swing.table.columns.client.ComboColumn();
        textColumn19 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn18 = new org.openswing.swing.table.columns.client.TextColumn();

        setTitle("Bakery Factory - Cadastro Detalhes Pessoa");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Detalhe"));
        jPanel1.setMinimumSize(new java.awt.Dimension(205, 65));
        jPanel1.setPreferredSize(new java.awt.Dimension(128, 65));
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

        form1.setEditButton(editButton1);
        form1.setFunctionId("pessoa");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        lblNome.setLabel("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblNome, gridBagConstraints);

        textControl1.setAttributeName("nome");
        textControl1.setEnabled(false);
        textControl1.setMaxCharacters(150);
        textControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl1, gridBagConstraints);

        textControl2.setAttributeName("email");
        textControl2.setEnabled(false);
        textControl2.setMaxCharacters(250);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        lblEmail.setLabel("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblEmail, gridBagConstraints);

        lblTipo.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTipo, gridBagConstraints);

        comboBoxControl2.setAttributeName("tipo");
        comboBoxControl2.setDomainId("tipoPessoa");
        comboBoxControl2.setEnabled(false);
        comboBoxControl2.setEnabledOnEdit(false);
        comboBoxControl2.setLinkLabel(lblTipo);
        comboBoxControl2.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl2, gridBagConstraints);

        textControl3.setAttributeName("site");
        textControl3.setEnabled(false);
        textControl3.setMaxCharacters(250);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        lblSite.setLabel("Site:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSite, gridBagConstraints);

        jPanel2.setPreferredSize(new java.awt.Dimension(278, 44));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblCliente.setLabel("Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblCliente, gridBagConstraints);

        comboBoxControl1.setAttributeName("cliente");
        comboBoxControl1.setDomainId("naosim");
        comboBoxControl1.setEnabled(false);
        comboBoxControl1.setLinkLabel(lblCliente);
        comboBoxControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(comboBoxControl1, gridBagConstraints);

        lblFornecedor.setLabel("Fornecedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblFornecedor, gridBagConstraints);

        comboBoxControl3.setAttributeName("fornecedor");
        comboBoxControl3.setDomainId("naosim");
        comboBoxControl3.setEnabled(false);
        comboBoxControl3.setLinkLabel(lblFornecedor);
        comboBoxControl3.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(comboBoxControl3, gridBagConstraints);

        lblColaborador.setLabel("Colaborador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblColaborador, gridBagConstraints);

        comboBoxControl4.setAttributeName("colaborador");
        comboBoxControl4.setDomainId("naosim");
        comboBoxControl4.setEnabled(false);
        comboBoxControl4.setLinkLabel(lblColaborador);
        comboBoxControl4.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(comboBoxControl4, gridBagConstraints);

        lblTransportadora.setLabel("Transportadora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblTransportadora, gridBagConstraints);

        comboBoxControl5.setAttributeName("transportadora");
        comboBoxControl5.setDomainId("naosim");
        comboBoxControl5.setEnabled(false);
        comboBoxControl5.setLinkLabel(lblTransportadora);
        comboBoxControl5.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(comboBoxControl5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        form1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(727, 433));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1477, 437));

        jPanel3.setPreferredSize(new java.awt.Dimension(671, 410));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        formPessoaFisica.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Fisica"));
        formPessoaFisica.setVOClassName("com.t2tierp.cadastros.java.PessoaFisicaVO");
        formPessoaFisica.setFunctionId("pessoaFisica");
        formPessoaFisica.setLayout(new java.awt.GridBagLayout());

        lblEstadoCivil.setLabel("Estado Civil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblEstadoCivil, gridBagConstraints);

        codLookupEstadoCivil.setAttributeName("estadoCivil.nome");
        codLookupEstadoCivil.setEnabled(false);
        codLookupEstadoCivil.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(codLookupEstadoCivil, gridBagConstraints);

        lblCpf.setLabel("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblCpf, gridBagConstraints);

        lblDtaNascimento.setLabel("Data Nascimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblDtaNascimento, gridBagConstraints);

        dateControl8.setAttributeName("dataNascimento");
        dateControl8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(dateControl8, gridBagConstraints);

        lblSexo.setLabel("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblSexo, gridBagConstraints);

        comboBoxControl12.setAttributeName("sexo");
        comboBoxControl12.setDomainId("sexo");
        comboBoxControl12.setEnabled(false);
        comboBoxControl12.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(comboBoxControl12, gridBagConstraints);

        lblNaturalidade.setLabel("Naturalidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNaturalidade, gridBagConstraints);

        textControl10.setAttributeName("naturalidade");
        textControl10.setEnabled(false);
        textControl10.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(textControl10, gridBagConstraints);

        lblNacionalidade.setLabel("Nacionalidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNacionalidade, gridBagConstraints);

        textControl11.setAttributeName("nacionalidade");
        textControl11.setEnabled(false);
        textControl11.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(textControl11, gridBagConstraints);

        lblRaca.setLabel("Raca:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblRaca, gridBagConstraints);

        comboBoxControl13.setAttributeName("raca");
        comboBoxControl13.setDomainId("racaCor");
        comboBoxControl13.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(comboBoxControl13, gridBagConstraints);

        lblTipoSangue.setLabel("Tipo Sangue:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblTipoSangue, gridBagConstraints);

        lblNomeMae.setLabel("Nome Mae:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNomeMae, gridBagConstraints);

        textControl22.setAttributeName("nomeMae");
        textControl22.setEnabled(false);
        textControl22.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(textControl22, gridBagConstraints);

        lblNomePai.setLabel("Nome Pai:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNomePai, gridBagConstraints);

        textControl23.setAttributeName("nomePai");
        textControl23.setEnabled(false);
        textControl23.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(textControl23, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("RG"));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        lblRG.setLabel("Rg:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(lblRG, gridBagConstraints);

        textControl6.setAttributeName("rg");
        textControl6.setEnabled(false);
        textControl6.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(textControl6, gridBagConstraints);

        lblOrgaoRg.setLabel("Orgao Rg:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(lblOrgaoRg, gridBagConstraints);

        textControl7.setAttributeName("orgaoRg");
        textControl7.setEnabled(false);
        textControl7.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(textControl7, gridBagConstraints);

        dateControl7.setAttributeName("dataEmissaoRg");
        dateControl7.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(dateControl7, gridBagConstraints);

        lblDataEmissaoRg.setLabel("Data Emissao Rg:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(lblDataEmissaoRg, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        formPessoaFisica.add(jPanel7, gridBagConstraints);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Reservista"));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        lblReservistaNum.setLabel("Reservista Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel8.add(lblReservistaNum, gridBagConstraints);

        textControl20.setAttributeName("reservistaNumero");
        textControl20.setEnabled(false);
        textControl20.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel8.add(textControl20, gridBagConstraints);

        lblReservistaCategoria.setLabel("Reservista Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel8.add(lblReservistaCategoria, gridBagConstraints);

        numericControl21.setAttributeName("reservistaCategoria");
        numericControl21.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel8.add(numericControl21, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        formPessoaFisica.add(jPanel8, gridBagConstraints);

        comboBoxControl14.setAttributeName("tipoSangue");
        comboBoxControl14.setDomainId("tipoSangue");
        comboBoxControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(comboBoxControl14, gridBagConstraints);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        lblCnhNumero.setLabel("Cnh Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel9.add(lblCnhNumero, gridBagConstraints);

        textControl14.setAttributeName("cnhNumero");
        textControl14.setEnabled(false);
        textControl14.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel9.add(textControl14, gridBagConstraints);

        textControl15.setAttributeName("cnhCategoria");
        textControl15.setEnabled(false);
        textControl15.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel9.add(textControl15, gridBagConstraints);

        lblCnhCategoria.setLabel("Cnh Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel9.add(lblCnhCategoria, gridBagConstraints);

        dateControl16.setAttributeName("cnhVencimento");
        dateControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel9.add(dateControl16, gridBagConstraints);

        lblCnhVencimento.setLabel("Cnh Vencimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel9.add(lblCnhVencimento, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        formPessoaFisica.add(jPanel9, gridBagConstraints);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo Eleitoral"));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        lblTitEleitoralNum.setLabel("Titulo Eleitoral Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel12.add(lblTitEleitoralNum, gridBagConstraints);

        textControl17.setAttributeName("tituloEleitoralNumero");
        textControl17.setEnabled(false);
        textControl17.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel12.add(textControl17, gridBagConstraints);

        lblTitEleitZona.setLabel("Titulo Eleitoral Zona:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel12.add(lblTitEleitZona, gridBagConstraints);

        numericControl18.setAttributeName("tituloEleitoralZona");
        numericControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel12.add(numericControl18, gridBagConstraints);

        lblTitEleitoralSecao.setLabel("Titulo Eleitoral Secao:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel12.add(lblTitEleitoralSecao, gridBagConstraints);

        numericControl19.setAttributeName("tituloEleitoralSecao");
        numericControl19.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel12.add(numericControl19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        formPessoaFisica.add(jPanel12, gridBagConstraints);

        formattedTextControlCpf.setAttributeName("cpf");
        formattedTextControlCpf.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(formattedTextControlCpf, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPessoaFisica.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(formPessoaFisica, gridBagConstraints);

        formPessoaJuridica.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Juridica"));
        formPessoaJuridica.setVOClassName("com.t2tierp.cadastros.java.PessoaJuridicaVO");
        formPessoaJuridica.setFunctionId("pessoaJuridica");
        formPessoaJuridica.setLayout(new java.awt.GridBagLayout());

        lblCnpj.setLabel("Cnpj:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblCnpj, gridBagConstraints);

        lblFantasia.setText("Nome Fantasia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblFantasia, gridBagConstraints);

        textControl8.setAttributeName("fantasia");
        textControl8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl8, gridBagConstraints);

        lblInscrMunicipal.setText("Inscrição Municipal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblInscrMunicipal, gridBagConstraints);

        textControl9.setAttributeName("inscricaoMunicipal");
        textControl9.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl9, gridBagConstraints);

        lblInscEstadual.setText("Inscrição Estadual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblInscEstadual, gridBagConstraints);

        textControl12.setAttributeName("inscricaoEstadual");
        textControl12.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl12, gridBagConstraints);

        lblDataConstituicao.setLabel("Data Constituicao:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblDataConstituicao, gridBagConstraints);

        dateControl9.setAttributeName("dataConstituicao");
        dateControl9.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(dateControl9, gridBagConstraints);

        lblTipoRegime.setLabel("Tipo Regime:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblTipoRegime, gridBagConstraints);

        comboBoxControl15.setAttributeName("tipoRegime");
        comboBoxControl15.setDomainId("tipoRegimeEmpresa");
        comboBoxControl15.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(comboBoxControl15, gridBagConstraints);

        lblCrt.setLabel("Crt:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblCrt, gridBagConstraints);

        comboBoxControl16.setAttributeName("crt");
        comboBoxControl16.setDomainId("crt");
        comboBoxControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(comboBoxControl16, gridBagConstraints);

        lblSuframa.setLabel("Suframa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblSuframa, gridBagConstraints);

        textControl13.setAttributeName("suframa");
        textControl13.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl13, gridBagConstraints);

        formattedTextControlCnpj.setAttributeName("cnpj");
        formattedTextControlCnpj.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(formattedTextControlCnpj, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPessoaJuridica.add(jSeparator2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(formPessoaJuridica, gridBagConstraints);

        jTabbedPane1.addTab("Informações do Tipo de Pessoa", jPanel3);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel10.add(insertButton1);
        jPanel10.add(editButton2);
        jPanel10.add(deleteButton1);
        jPanel10.add(saveButton2);
        jPanel10.add(reloadButton2);
        jPanel10.add(navigatorBar1);

        gridControlContatos.setAutoLoadData(false);
        gridControlContatos.setFunctionId("contato");
        gridControlContatos.setValueObjectClassName("com.t2tierp.cadastros.java.PessoaContatoVO");
        gridControlContatos.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn4.setColumnName("nome");
        textColumn4.setEditableOnEdit(true);
        textColumn4.setEditableOnInsert(true);
        textColumn4.setHeaderColumnName("Nome");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn4.setMaxCharacters(100);
        textColumn4.setPreferredWidth(200);
        gridControlContatos.getColumnContainer().add(textColumn4);

        textColumn5.setColumnName("email");
        textColumn5.setColumnRequired(false);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        textColumn5.setHeaderColumnName("Email");
        textColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn5.setMaxCharacters(250);
        textColumn5.setPreferredWidth(200);
        gridControlContatos.getColumnContainer().add(textColumn5);

        textColumn6.setColumnName("foneComercial");
        textColumn6.setColumnRequired(false);
        textColumn6.setEditableOnEdit(true);
        textColumn6.setEditableOnInsert(true);
        textColumn6.setHeaderColumnName("Fone Comercial");
        textColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn6.setMaxCharacters(14);
        gridControlContatos.getColumnContainer().add(textColumn6);

        textColumn7.setColumnName("foneResidencial");
        textColumn7.setColumnRequired(false);
        textColumn7.setEditableOnEdit(true);
        textColumn7.setEditableOnInsert(true);
        textColumn7.setHeaderColumnName("Fone Residencial");
        textColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn7.setMaxCharacters(14);
        gridControlContatos.getColumnContainer().add(textColumn7);

        textColumn8.setColumnName("foneCelular");
        textColumn8.setColumnRequired(false);
        textColumn8.setEditableOnEdit(true);
        textColumn8.setEditableOnInsert(true);
        textColumn8.setHeaderColumnName("Fone Celular");
        textColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn8.setMaxCharacters(14);
        gridControlContatos.getColumnContainer().add(textColumn8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gridControlContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(gridControlContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Contatos", jPanel4);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel11.add(insertButton2);
        jPanel11.add(editButton3);
        jPanel11.add(deleteButton2);
        jPanel11.add(saveButton3);
        jPanel11.add(reloadButton3);
        jPanel11.add(navigatorBar2);

        gridControlEndereco.setAutoLoadData(false);
        gridControlEndereco.setFunctionId("endereco");
        gridControlEndereco.setValueObjectClassName("com.t2tierp.cadastros.java.PessoaEnderecoVO");
        gridControlEndereco.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn9.setColumnName("logradouro");
        textColumn9.setEditableOnEdit(true);
        textColumn9.setEditableOnInsert(true);
        textColumn9.setHeaderColumnName("Logradouro");
        textColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn9.setMaxCharacters(60);
        textColumn9.setPreferredWidth(200);
        gridControlEndereco.getColumnContainer().add(textColumn9);

        textColumn10.setColumnName("numero");
        textColumn10.setEditableOnEdit(true);
        textColumn10.setEditableOnInsert(true);
        textColumn10.setHeaderColumnName("Numero");
        textColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn10.setMaxCharacters(10);
        gridControlEndereco.getColumnContainer().add(textColumn10);

        textColumn11.setColumnName("complemento");
        textColumn11.setColumnRequired(false);
        textColumn11.setEditableOnEdit(true);
        textColumn11.setEditableOnInsert(true);
        textColumn11.setHeaderColumnName("Complemento");
        textColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn11.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn11);

        textColumn12.setColumnName("bairro");
        textColumn12.setEditableOnEdit(true);
        textColumn12.setEditableOnInsert(true);
        textColumn12.setHeaderColumnName("Bairro");
        textColumn12.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn12.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn12);

        textColumn13.setColumnName("cidade");
        textColumn13.setEditableOnEdit(true);
        textColumn13.setEditableOnInsert(true);
        textColumn13.setHeaderColumnName("Cidade");
        textColumn13.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn13.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn13);

        textColumn14.setColumnName("cep");
        textColumn14.setColumnRequired(false);
        textColumn14.setEditableOnEdit(true);
        textColumn14.setEditableOnInsert(true);
        textColumn14.setHeaderColumnName("Cep");
        textColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn14.setMaxCharacters(8);
        gridControlEndereco.getColumnContainer().add(textColumn14);

        integerColumn10.setColumnName("municipioIbge");
        integerColumn10.setColumnRequired(false);
        integerColumn10.setHeaderColumnName("Municipio Ibge");
        integerColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(integerColumn10);

        textColumn15.setColumnName("uf");
        textColumn15.setEditableOnEdit(true);
        textColumn15.setEditableOnInsert(true);
        textColumn15.setHeaderColumnName("Uf");
        textColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn15.setMaxCharacters(2);
        gridControlEndereco.getColumnContainer().add(textColumn15);

        textColumn16.setColumnName("fone");
        textColumn16.setColumnRequired(false);
        textColumn16.setEditableOnEdit(true);
        textColumn16.setEditableOnInsert(true);
        textColumn16.setHeaderColumnName("Fone");
        textColumn16.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn16.setMaxCharacters(14);
        gridControlEndereco.getColumnContainer().add(textColumn16);

        comboColumn14.setColumnName("principal");
        comboColumn14.setDomainId("naosim");
        comboColumn14.setEditableOnEdit(true);
        comboColumn14.setEditableOnInsert(true);
        comboColumn14.setHeaderColumnName("Principal");
        comboColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumn14);

        comboColumn15.setColumnName("entrega");
        comboColumn15.setDomainId("naosim");
        comboColumn15.setEditableOnEdit(true);
        comboColumn15.setEditableOnInsert(true);
        comboColumn15.setHeaderColumnName("Entrega");
        comboColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumn15);

        comboColumn16.setColumnName("cobranca");
        comboColumn16.setDomainId("naosim");
        comboColumn16.setEditableOnEdit(true);
        comboColumn16.setEditableOnInsert(true);
        comboColumn16.setHeaderColumnName("Cobranca");
        comboColumn16.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumn16);

        comboColumn17.setColumnName("correspondencia");
        comboColumn17.setDomainId("naosim");
        comboColumn17.setEditableOnEdit(true);
        comboColumn17.setEditableOnInsert(true);
        comboColumn17.setHeaderColumnName("Correspondencia");
        comboColumn17.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumn17);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gridControlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(gridControlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Endereços", jPanel5);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel13.add(insertButton3);
        jPanel13.add(editButton4);
        jPanel13.add(deleteButton3);
        jPanel13.add(saveButton4);
        jPanel13.add(reloadButton4);
        jPanel13.add(navigatorBar3);

        gridControlTelefone.setAutoLoadData(false);
        gridControlTelefone.setFunctionId("telefone");
        gridControlTelefone.setValueObjectClassName("com.t2tierp.cadastros.java.PessoaTelefoneVO");
        gridControlTelefone.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        comboColumn1.setColumnName("tipo");
        comboColumn1.setDomainId("tipoTelefone");
        comboColumn1.setEditableOnEdit(true);
        comboColumn1.setEditableOnInsert(true);
        comboColumn1.setHeaderColumnName("Tipo");
        comboColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        comboColumn1.setPreferredWidth(150);
        gridControlTelefone.getColumnContainer().add(comboColumn1);

        textColumn19.setColumnName("numero");
        textColumn19.setColumnRequired(false);
        textColumn19.setEditableOnEdit(true);
        textColumn19.setEditableOnInsert(true);
        textColumn19.setHeaderColumnName("Numero");
        textColumn19.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn19.setMaxCharacters(14);
        gridControlTelefone.getColumnContainer().add(textColumn19);

        textColumn18.setColumnName("observacao");
        textColumn18.setColumnRequired(false);
        textColumn18.setEditableOnEdit(true);
        textColumn18.setEditableOnInsert(true);
        textColumn18.setHeaderColumnName("Observacao");
        textColumn18.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn18.setMaxCharacters(1000);
        textColumn18.setPreferredWidth(400);
        gridControlTelefone.getColumnContainer().add(textColumn18);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gridControlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(gridControlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Telefones", jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Informações do Tipo de Pessoa");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupEstadoCivil;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl12;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl13;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl14;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl15;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl16;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl3;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl5;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn1;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn14;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn15;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn16;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn17;
    private org.openswing.swing.client.DateControl dateControl16;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.client.DateControl dateControl8;
    private org.openswing.swing.client.DateControl dateControl9;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.DeleteButton deleteButton2;
    private org.openswing.swing.client.DeleteButton deleteButton3;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton2;
    private org.openswing.swing.client.EditButton editButton3;
    private org.openswing.swing.client.EditButton editButton4;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.form.client.Form formPessoaFisica;
    private org.openswing.swing.form.client.Form formPessoaJuridica;
    private org.openswing.swing.client.FormattedTextControl formattedTextControlCnpj;
    private org.openswing.swing.client.FormattedTextControl formattedTextControlCpf;
    private org.openswing.swing.client.GridControl gridControlContatos;
    private org.openswing.swing.client.GridControl gridControlEndereco;
    private org.openswing.swing.client.GridControl gridControlTelefone;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.client.InsertButton insertButton2;
    private org.openswing.swing.client.InsertButton insertButton3;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl lblCliente;
    private org.openswing.swing.client.LabelControl lblCnhCategoria;
    private org.openswing.swing.client.LabelControl lblCnhNumero;
    private org.openswing.swing.client.LabelControl lblCnhVencimento;
    private org.openswing.swing.client.LabelControl lblCnpj;
    private org.openswing.swing.client.LabelControl lblColaborador;
    private org.openswing.swing.client.LabelControl lblCpf;
    private org.openswing.swing.client.LabelControl lblCrt;
    private org.openswing.swing.client.LabelControl lblDataConstituicao;
    private org.openswing.swing.client.LabelControl lblDataEmissaoRg;
    private org.openswing.swing.client.LabelControl lblDtaNascimento;
    private org.openswing.swing.client.LabelControl lblEmail;
    private org.openswing.swing.client.LabelControl lblEstadoCivil;
    private org.openswing.swing.client.LabelControl lblFantasia;
    private org.openswing.swing.client.LabelControl lblFornecedor;
    private org.openswing.swing.client.LabelControl lblInscEstadual;
    private org.openswing.swing.client.LabelControl lblInscrMunicipal;
    private org.openswing.swing.client.LabelControl lblNacionalidade;
    private org.openswing.swing.client.LabelControl lblNaturalidade;
    private org.openswing.swing.client.LabelControl lblNome;
    private org.openswing.swing.client.LabelControl lblNomeMae;
    private org.openswing.swing.client.LabelControl lblNomePai;
    private org.openswing.swing.client.LabelControl lblOrgaoRg;
    private org.openswing.swing.client.LabelControl lblRG;
    private org.openswing.swing.client.LabelControl lblRaca;
    private org.openswing.swing.client.LabelControl lblReservistaCategoria;
    private org.openswing.swing.client.LabelControl lblReservistaNum;
    private org.openswing.swing.client.LabelControl lblSexo;
    private org.openswing.swing.client.LabelControl lblSite;
    private org.openswing.swing.client.LabelControl lblSuframa;
    private org.openswing.swing.client.LabelControl lblTipo;
    private org.openswing.swing.client.LabelControl lblTipoRegime;
    private org.openswing.swing.client.LabelControl lblTipoSangue;
    private org.openswing.swing.client.LabelControl lblTitEleitZona;
    private org.openswing.swing.client.LabelControl lblTitEleitoralNum;
    private org.openswing.swing.client.LabelControl lblTitEleitoralSecao;
    private org.openswing.swing.client.LabelControl lblTransportadora;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.NavigatorBar navigatorBar2;
    private org.openswing.swing.client.NavigatorBar navigatorBar3;
    private org.openswing.swing.client.NumericControl numericControl18;
    private org.openswing.swing.client.NumericControl numericControl19;
    private org.openswing.swing.client.NumericControl numericControl21;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton2;
    private org.openswing.swing.client.ReloadButton reloadButton3;
    private org.openswing.swing.client.ReloadButton reloadButton4;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton2;
    private org.openswing.swing.client.SaveButton saveButton3;
    private org.openswing.swing.client.SaveButton saveButton4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn10;
    private org.openswing.swing.table.columns.client.TextColumn textColumn11;
    private org.openswing.swing.table.columns.client.TextColumn textColumn12;
    private org.openswing.swing.table.columns.client.TextColumn textColumn13;
    private org.openswing.swing.table.columns.client.TextColumn textColumn14;
    private org.openswing.swing.table.columns.client.TextColumn textColumn15;
    private org.openswing.swing.table.columns.client.TextColumn textColumn16;
    private org.openswing.swing.table.columns.client.TextColumn textColumn18;
    private org.openswing.swing.table.columns.client.TextColumn textColumn19;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.table.columns.client.TextColumn textColumn9;
    private org.openswing.swing.client.TextControl textControl1;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl13;
    private org.openswing.swing.client.TextControl textControl14;
    private org.openswing.swing.client.TextControl textControl15;
    private org.openswing.swing.client.TextControl textControl17;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl20;
    private org.openswing.swing.client.TextControl textControl22;
    private org.openswing.swing.client.TextControl textControl23;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables

}
