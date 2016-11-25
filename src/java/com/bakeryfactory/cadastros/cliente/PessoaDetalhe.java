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

    private final PessoaFisicaDetalheController pessoaFisicaController;
    private final PessoaJuridicaDetalheController pessoaJuridicaController;
    private final PessoaContatoGridController contatoController;
    private final PessoaEnderecoGridController enderecoController;
    private final PessoaTelefoneGridController telefoneController;
    private final LookupController estadoCivilController;

    /**
     * Creates new form PessoaDetalhe
     * @param controller
     */
    public PessoaDetalhe(PessoaDetalheController controller) {
        initComponents();

        formattedTextControlCpf.setEnabled(false);
        formattedTextControlCnpj.setEnabled(false);

        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValidCharacters("0123456789");
            mask.setValueContainsLiteralCharacters(false);
            formattedTextControlCpf.setFormatter(mask);
            
            mask = new MaskFormatter("##.###.###/####-##");
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
        
        estadoCivilController = new LookupController();
        estadoCivilController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.EstadoCivilVO");
        estadoCivilController.addLookup2ParentLink("id", "estadoCivil.id");
        estadoCivilController.addLookup2ParentLink("nome", "estadoCivil.nome");
        estadoCivilController.setHeaderColumnName("id", "ID");
        estadoCivilController.setHeaderColumnName("nome", "Nome");
        estadoCivilController.setFrameTitle("Importa Estado Civil da Pessoa");

        estadoCivilController.setVisibleStatusPanel(true);
        estadoCivilController.setVisibleColumn("id", true);
        estadoCivilController.setVisibleColumn("nome", true);
        estadoCivilController.setFramePreferedSize(new Dimension(600, 500));

        estadoCivilController.setLookupDataLocator(new LookupDataLocatorGenerico((estadoCivilController.getLookupValueObjectClassName())));
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

        jPanelPessoaDet = new javax.swing.JPanel();
        editButtonPessoa = new org.openswing.swing.client.EditButton();
        reloadButtonPessoa = new org.openswing.swing.client.ReloadButton();
        saveButtonPessoa = new org.openswing.swing.client.SaveButton();
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
        cbControlCliente = new org.openswing.swing.client.ComboBoxControl();
        lblFornecedor = new org.openswing.swing.client.LabelControl();
        cbControlFornecedor = new org.openswing.swing.client.ComboBoxControl();
        lblColaborador = new org.openswing.swing.client.LabelControl();
        cbControlColaborador = new org.openswing.swing.client.ComboBoxControl();
        lblTransportadora = new org.openswing.swing.client.LabelControl();
        cbControlTransportadora = new org.openswing.swing.client.ComboBoxControl();
        jTabbedPanePessoas = new javax.swing.JTabbedPane();
        jPanelPessTipoPessoa = new javax.swing.JPanel();
        formPessoaFisica = new org.openswing.swing.form.client.Form();
        lblEstadoCivil = new org.openswing.swing.client.LabelControl();
        codLookupEstadoCivil = new org.openswing.swing.client.CodLookupControl();
        lblCpf = new org.openswing.swing.client.LabelControl();
        lblDtaNascimento = new org.openswing.swing.client.LabelControl();
        dateControlDataNasc = new org.openswing.swing.client.DateControl();
        lblSexo = new org.openswing.swing.client.LabelControl();
        cbControlSexo = new org.openswing.swing.client.ComboBoxControl();
        lblNaturalidade = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblNacionalidade = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        lblRaca = new org.openswing.swing.client.LabelControl();
        cbControlRaca = new org.openswing.swing.client.ComboBoxControl();
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
        cbControlTipoSangue = new org.openswing.swing.client.ComboBoxControl();
        jPanel9 = new javax.swing.JPanel();
        lblCnhNumero = new org.openswing.swing.client.LabelControl();
        textControl14 = new org.openswing.swing.client.TextControl();
        textControl15 = new org.openswing.swing.client.TextControl();
        lblCnhCategoria = new org.openswing.swing.client.LabelControl();
        dateControlCNHVenc = new org.openswing.swing.client.DateControl();
        lblCnhVencimento = new org.openswing.swing.client.LabelControl();
        jPanelTitEleitoral = new javax.swing.JPanel();
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
        jPanelPessoaContato = new javax.swing.JPanel();
        jPanelContatos = new javax.swing.JPanel();
        insertButtonContato = new org.openswing.swing.client.InsertButton();
        editButtonContato = new org.openswing.swing.client.EditButton();
        deleteButtonContato = new org.openswing.swing.client.DeleteButton();
        saveButtonContato = new org.openswing.swing.client.SaveButton();
        reloadButtonContato = new org.openswing.swing.client.ReloadButton();
        navigatorBarContato = new org.openswing.swing.client.NavigatorBar();
        gridControlContatos = new org.openswing.swing.client.GridControl();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanelPessoaEndereco = new javax.swing.JPanel();
        jPanelEnderecos = new javax.swing.JPanel();
        insertButtonEndereco = new org.openswing.swing.client.InsertButton();
        editButtonEndereco = new org.openswing.swing.client.EditButton();
        deleteButtonEndereco = new org.openswing.swing.client.DeleteButton();
        saveButtonEndereco = new org.openswing.swing.client.SaveButton();
        reloadButtonEndereco = new org.openswing.swing.client.ReloadButton();
        navigatorBarEndereco = new org.openswing.swing.client.NavigatorBar();
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
        comboColumnPrincipal = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumnEntrega = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumnCobranca = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumnCorrespondencia = new org.openswing.swing.table.columns.client.ComboColumn();
        jPanelPessoaTel = new javax.swing.JPanel();
        jPanelTelefone = new javax.swing.JPanel();
        insertButtonTel = new org.openswing.swing.client.InsertButton();
        editButtonTel = new org.openswing.swing.client.EditButton();
        deleteButtonTel = new org.openswing.swing.client.DeleteButton();
        saveButtonTel = new org.openswing.swing.client.SaveButton();
        reloadButtonTel = new org.openswing.swing.client.ReloadButton();
        navigatorBarTel = new org.openswing.swing.client.NavigatorBar();
        gridControlTelefone = new org.openswing.swing.client.GridControl();
        comboColumnTipo = new org.openswing.swing.table.columns.client.ComboColumn();
        textColumn19 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn18 = new org.openswing.swing.table.columns.client.TextColumn();

        setTitle("Bakery Factory - Cadastros");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelPessoaDet.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa Detalhe"));
        jPanelPessoaDet.setMinimumSize(new java.awt.Dimension(205, 65));
        jPanelPessoaDet.setPreferredSize(new java.awt.Dimension(128, 65));
        jPanelPessoaDet.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelPessoaDet.add(editButtonPessoa);
        jPanelPessoaDet.add(reloadButtonPessoa);
        jPanelPessoaDet.add(saveButtonPessoa);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelPessoaDet, gridBagConstraints);

        form1.setToolTipText("");
        form1.setVOClassName("com.bakeryfactory.cadastros.java.PessoaVO");
        form1.setEditButton(editButtonPessoa);
        form1.setFunctionId("pessoa");
        form1.setReloadButton(reloadButtonPessoa);
        form1.setSaveButton(saveButtonPessoa);
        form1.setLayout(new java.awt.GridBagLayout());

        lblNome.setLabel("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblNome, gridBagConstraints);

        textControl1.setAttributeName("nome");
        textControl1.setEnabled(false);
        textControl1.setLinkLabel(lblNome);
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
        textControl2.setLinkLabel(lblEmail);
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
        textControl3.setLinkLabel(lblSite);
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

        cbControlCliente.setAttributeName("cliente");
        cbControlCliente.setDomainId("naosim");
        cbControlCliente.setEnabled(false);
        cbControlCliente.setLinkLabel(lblCliente);
        cbControlCliente.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(cbControlCliente, gridBagConstraints);

        lblFornecedor.setLabel("Fornecedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblFornecedor, gridBagConstraints);

        cbControlFornecedor.setAttributeName("fornecedor");
        cbControlFornecedor.setDomainId("naosim");
        cbControlFornecedor.setEnabled(false);
        cbControlFornecedor.setLinkLabel(lblFornecedor);
        cbControlFornecedor.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(cbControlFornecedor, gridBagConstraints);

        lblColaborador.setLabel("Colaborador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblColaborador, gridBagConstraints);

        cbControlColaborador.setAttributeName("colaborador");
        cbControlColaborador.setDomainId("naosim");
        cbControlColaborador.setEnabled(false);
        cbControlColaborador.setLinkLabel(lblColaborador);
        cbControlColaborador.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(cbControlColaborador, gridBagConstraints);

        lblTransportadora.setLabel("Transportadora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(lblTransportadora, gridBagConstraints);

        cbControlTransportadora.setAttributeName("transportadora");
        cbControlTransportadora.setDomainId("naosim");
        cbControlTransportadora.setEnabled(false);
        cbControlTransportadora.setLinkLabel(lblTransportadora);
        cbControlTransportadora.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(cbControlTransportadora, gridBagConstraints);

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

        jTabbedPanePessoas.setMinimumSize(new java.awt.Dimension(727, 433));
        jTabbedPanePessoas.setPreferredSize(new java.awt.Dimension(1477, 437));

        jPanelPessTipoPessoa.setPreferredSize(new java.awt.Dimension(671, 410));
        jPanelPessTipoPessoa.setLayout(new java.awt.GridBagLayout());

        formPessoaFisica.setBorder(javax.swing.BorderFactory.createTitledBorder("PESSOA FÍSICA"));
        formPessoaFisica.setVOClassName("com.bakeryfactory.cadastros.java.PessoaFisicaVO");
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
        codLookupEstadoCivil.setLinkLabel(lblEstadoCivil);
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

        dateControlDataNasc.setAttributeName("dataNascimento");
        dateControlDataNasc.setEnabled(false);
        dateControlDataNasc.setLinkLabel(lblDtaNascimento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(dateControlDataNasc, gridBagConstraints);

        lblSexo.setLabel("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblSexo, gridBagConstraints);

        cbControlSexo.setAttributeName("sexo");
        cbControlSexo.setDomainId("sexo");
        cbControlSexo.setEnabled(false);
        cbControlSexo.setLinkLabel(lblSexo);
        cbControlSexo.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(cbControlSexo, gridBagConstraints);

        lblNaturalidade.setLabel("Naturalidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNaturalidade, gridBagConstraints);

        textControl10.setAttributeName("naturalidade");
        textControl10.setEnabled(false);
        textControl10.setLinkLabel(lblNaturalidade);
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
        textControl11.setLinkLabel(lblNacionalidade);
        textControl11.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(textControl11, gridBagConstraints);

        lblRaca.setText("Raça:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblRaca, gridBagConstraints);

        cbControlRaca.setAttributeName("raca");
        cbControlRaca.setDomainId("racaCor");
        cbControlRaca.setEnabled(false);
        cbControlRaca.setLinkLabel(lblRaca);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(cbControlRaca, gridBagConstraints);

        lblTipoSangue.setLabel("Tipo Sangue:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblTipoSangue, gridBagConstraints);

        lblNomeMae.setText("Nome Mãe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaFisica.add(lblNomeMae, gridBagConstraints);

        textControl22.setAttributeName("nomeMae");
        textControl22.setEnabled(false);
        textControl22.setLinkLabel(lblNomeMae);
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
        textControl23.setLinkLabel(lblNomePai);
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

        lblRG.setText("RG:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(lblRG, gridBagConstraints);

        textControl6.setAttributeName("rg");
        textControl6.setEnabled(false);
        textControl6.setLinkLabel(lblRG);
        textControl6.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(textControl6, gridBagConstraints);

        lblOrgaoRg.setText("Orgão RG:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(lblOrgaoRg, gridBagConstraints);

        textControl7.setAttributeName("orgaoRg");
        textControl7.setEnabled(false);
        textControl7.setLinkLabel(lblOrgaoRg);
        textControl7.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(textControl7, gridBagConstraints);

        dateControl7.setAttributeName("dataEmissaoRg");
        dateControl7.setEnabled(false);
        dateControl7.setLinkLabel(lblDataEmissaoRg);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel7.add(dateControl7, gridBagConstraints);

        lblDataEmissaoRg.setText("Data Emissão RG:");
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

        lblReservistaNum.setText("Reservista Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel8.add(lblReservistaNum, gridBagConstraints);

        textControl20.setAttributeName("reservistaNumero");
        textControl20.setEnabled(false);
        textControl20.setLinkLabel(lblReservistaNum);
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
        numericControl21.setLinkLabel(lblReservistaNum);
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
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.weightx = 1.0;
        formPessoaFisica.add(jPanel8, gridBagConstraints);

        cbControlTipoSangue.setAttributeName("tipoSangue");
        cbControlTipoSangue.setDomainId("tipoSangue");
        cbControlTipoSangue.setEnabled(false);
        cbControlTipoSangue.setLinkLabel(lblTipoSangue);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaFisica.add(cbControlTipoSangue, gridBagConstraints);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        lblCnhNumero.setText("CNH Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel9.add(lblCnhNumero, gridBagConstraints);

        textControl14.setAttributeName("cnhNumero");
        textControl14.setEnabled(false);
        textControl14.setLinkLabel(lblCnhNumero);
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
        textControl15.setLinkLabel(lblCnhCategoria);
        textControl15.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel9.add(textControl15, gridBagConstraints);

        lblCnhCategoria.setText("CNH Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel9.add(lblCnhCategoria, gridBagConstraints);

        dateControlCNHVenc.setAttributeName("cnhVencimento");
        dateControlCNHVenc.setEnabled(false);
        dateControlCNHVenc.setLinkLabel(lblCnhVencimento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel9.add(dateControlCNHVenc, gridBagConstraints);

        lblCnhVencimento.setText("CNH Vencimento:");
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

        jPanelTitEleitoral.setBorder(javax.swing.BorderFactory.createTitledBorder("Título Eleitoral"));
        jPanelTitEleitoral.setLayout(new java.awt.GridBagLayout());

        lblTitEleitoralNum.setText("Titulo Eleitoral Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelTitEleitoral.add(lblTitEleitoralNum, gridBagConstraints);

        textControl17.setAttributeName("tituloEleitoralNumero");
        textControl17.setEnabled(false);
        textControl17.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelTitEleitoral.add(textControl17, gridBagConstraints);

        lblTitEleitZona.setLabel("Titulo Eleitoral Zona:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelTitEleitoral.add(lblTitEleitZona, gridBagConstraints);

        numericControl18.setAttributeName("tituloEleitoralZona");
        numericControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelTitEleitoral.add(numericControl18, gridBagConstraints);

        lblTitEleitoralSecao.setText("Titulo Eleitoral Seção:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelTitEleitoral.add(lblTitEleitoralSecao, gridBagConstraints);

        numericControl19.setAttributeName("tituloEleitoralSecao");
        numericControl19.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelTitEleitoral.add(numericControl19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        formPessoaFisica.add(jPanelTitEleitoral, gridBagConstraints);

        formattedTextControlCpf.setAttributeName("cpf");
        formattedTextControlCpf.setLinkLabel(lblCpf);
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
        jPanelPessTipoPessoa.add(formPessoaFisica, gridBagConstraints);

        formPessoaJuridica.setBorder(javax.swing.BorderFactory.createTitledBorder("PESSOA JURÍDICA"));
        formPessoaJuridica.setVOClassName("com.bakeryfactory.cadastros.java.PessoaJuridicaVO");
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
        textControl8.setLinkLabel(lblFantasia);
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
        textControl9.setLinkLabel(lblInscrMunicipal);
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
        textControl12.setLinkLabel(lblInscEstadual);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl12, gridBagConstraints);

        lblDataConstituicao.setText("Data Constituição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formPessoaJuridica.add(lblDataConstituicao, gridBagConstraints);

        dateControl9.setAttributeName("dataConstituicao");
        dateControl9.setEnabled(false);
        dateControl9.setLinkLabel(lblDataConstituicao);
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
        comboBoxControl15.setLinkLabel(lblTipoRegime);
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
        comboBoxControl16.setLinkLabel(lblCrt);
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
        textControl13.setLinkLabel(lblSuframa);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formPessoaJuridica.add(textControl13, gridBagConstraints);

        formattedTextControlCnpj.setAttributeName("cnpj");
        formattedTextControlCnpj.setLinkLabel(lblCnpj);
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
        jPanelPessTipoPessoa.add(formPessoaJuridica, gridBagConstraints);

        jTabbedPanePessoas.addTab("Informações do Tipo de Pessoa", jPanelPessTipoPessoa);

        jPanelPessoaContato.setLayout(new java.awt.GridBagLayout());

        jPanelContatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));
        jPanelContatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelContatos.add(insertButtonContato);
        jPanelContatos.add(editButtonContato);
        jPanelContatos.add(deleteButtonContato);
        jPanelContatos.add(saveButtonContato);
        jPanelContatos.add(reloadButtonContato);
        jPanelContatos.add(navigatorBarContato);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelPessoaContato.add(jPanelContatos, gridBagConstraints);

        gridControlContatos.setAutoLoadData(false);
        gridControlContatos.setDeleteButton(deleteButtonContato);
        gridControlContatos.setEditButton(editButtonContato);
        gridControlContatos.setFunctionId("contato");
        gridControlContatos.setInsertButton(insertButtonContato);
        gridControlContatos.setNavBar(navigatorBarContato);
        gridControlContatos.setPreferredSize(new java.awt.Dimension(600, 78));
        gridControlContatos.setReloadButton(reloadButtonContato);
        gridControlContatos.setSaveButton(saveButtonContato);
        gridControlContatos.setValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaContatoVO");
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelPessoaContato.add(gridControlContatos, gridBagConstraints);

        jTabbedPanePessoas.addTab("Contatos", jPanelPessoaContato);

        jPanelPessoaEndereco.setLayout(new java.awt.GridBagLayout());

        jPanelEnderecos.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));
        jPanelEnderecos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelEnderecos.add(insertButtonEndereco);
        jPanelEnderecos.add(editButtonEndereco);
        jPanelEnderecos.add(deleteButtonEndereco);
        jPanelEnderecos.add(saveButtonEndereco);
        jPanelEnderecos.add(reloadButtonEndereco);
        jPanelEnderecos.add(navigatorBarEndereco);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelPessoaEndereco.add(jPanelEnderecos, gridBagConstraints);

        gridControlEndereco.setAutoLoadData(false);
        gridControlEndereco.setDeleteButton(deleteButtonEndereco);
        gridControlEndereco.setEditButton(editButtonEndereco);
        gridControlEndereco.setFunctionId("endereco");
        gridControlEndereco.setInsertButton(insertButtonEndereco);
        gridControlEndereco.setNavBar(navigatorBarEndereco);
        gridControlEndereco.setReloadButton(reloadButtonEndereco);
        gridControlEndereco.setSaveButton(saveButtonEndereco);
        gridControlEndereco.setValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaEnderecoVO");
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
        textColumn10.setHeaderColumnName("Número");
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
        integerColumn10.setEditableOnInsert(true);
        integerColumn10.setHeaderColumnName("Município IBGE");
        integerColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(integerColumn10);

        textColumn15.setColumnName("uf");
        textColumn15.setEditableOnEdit(true);
        textColumn15.setEditableOnInsert(true);
        textColumn15.setHeaderColumnName("UF");
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

        comboColumnPrincipal.setColumnName("principal");
        comboColumnPrincipal.setColumnRequired(false);
        comboColumnPrincipal.setDomainId("naosim");
        comboColumnPrincipal.setEditableOnEdit(true);
        comboColumnPrincipal.setEditableOnInsert(true);
        comboColumnPrincipal.setHeaderColumnName("Principal");
        comboColumnPrincipal.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumnPrincipal);

        comboColumnEntrega.setColumnName("entrega");
        comboColumnEntrega.setDomainId("naosim");
        comboColumnEntrega.setEditableOnEdit(true);
        comboColumnEntrega.setEditableOnInsert(true);
        comboColumnEntrega.setHeaderColumnName("Entrega");
        comboColumnEntrega.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumnEntrega);

        comboColumnCobranca.setColumnName("cobranca");
        comboColumnCobranca.setDomainId("naosim");
        comboColumnCobranca.setEditableOnEdit(true);
        comboColumnCobranca.setEditableOnInsert(true);
        comboColumnCobranca.setHeaderColumnName("Cobrança");
        comboColumnCobranca.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumnCobranca);

        comboColumnCorrespondencia.setColumnName("correspondencia");
        comboColumnCorrespondencia.setDomainId("naosim");
        comboColumnCorrespondencia.setEditableOnEdit(true);
        comboColumnCorrespondencia.setEditableOnInsert(true);
        comboColumnCorrespondencia.setHeaderColumnName("Correspondência");
        comboColumnCorrespondencia.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(comboColumnCorrespondencia);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelPessoaEndereco.add(gridControlEndereco, gridBagConstraints);

        jTabbedPanePessoas.addTab("Endereços", jPanelPessoaEndereco);

        jPanelPessoaTel.setLayout(new java.awt.GridBagLayout());

        jPanelTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        jPanelTelefone.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelTelefone.add(insertButtonTel);
        jPanelTelefone.add(editButtonTel);
        jPanelTelefone.add(deleteButtonTel);
        jPanelTelefone.add(saveButtonTel);
        jPanelTelefone.add(reloadButtonTel);
        jPanelTelefone.add(navigatorBarTel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelPessoaTel.add(jPanelTelefone, gridBagConstraints);

        gridControlTelefone.setAutoLoadData(false);
        gridControlTelefone.setDeleteButton(deleteButtonTel);
        gridControlTelefone.setEditButton(editButtonTel);
        gridControlTelefone.setFunctionId("telefone");
        gridControlTelefone.setInsertButton(insertButtonTel);
        gridControlTelefone.setNavBar(navigatorBarTel);
        gridControlTelefone.setReloadButton(reloadButtonTel);
        gridControlTelefone.setSaveButton(saveButtonTel);
        gridControlTelefone.setValueObjectClassName("com.bakeryfactory.cadastros.java.PessoaTelefoneVO");
        gridControlTelefone.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        comboColumnTipo.setColumnName("tipo");
        comboColumnTipo.setDomainId("tipoTelefone");
        comboColumnTipo.setEditableOnEdit(true);
        comboColumnTipo.setEditableOnInsert(true);
        comboColumnTipo.setHeaderColumnName("Tipo");
        comboColumnTipo.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        comboColumnTipo.setPreferredWidth(150);
        gridControlTelefone.getColumnContainer().add(comboColumnTipo);

        textColumn19.setColumnName("numero");
        textColumn19.setColumnRequired(false);
        textColumn19.setEditableOnEdit(true);
        textColumn19.setEditableOnInsert(true);
        textColumn19.setHeaderColumnName("Número");
        textColumn19.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn19.setMaxCharacters(14);
        gridControlTelefone.getColumnContainer().add(textColumn19);

        textColumn18.setColumnName("observacao");
        textColumn18.setColumnRequired(false);
        textColumn18.setEditableOnEdit(true);
        textColumn18.setEditableOnInsert(true);
        textColumn18.setHeaderColumnName("Observação");
        textColumn18.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn18.setMaxCharacters(1000);
        textColumn18.setPreferredWidth(400);
        gridControlTelefone.getColumnContainer().add(textColumn18);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelPessoaTel.add(gridControlTelefone, gridBagConstraints);

        jTabbedPanePessoas.addTab("Telefones", jPanelPessoaTel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPanePessoas, gridBagConstraints);
        jTabbedPanePessoas.getAccessibleContext().setAccessibleName("Informações do Tipo de Pessoa");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.ComboBoxControl cbControlCliente;
    private org.openswing.swing.client.ComboBoxControl cbControlColaborador;
    private org.openswing.swing.client.ComboBoxControl cbControlFornecedor;
    private org.openswing.swing.client.ComboBoxControl cbControlRaca;
    private org.openswing.swing.client.ComboBoxControl cbControlSexo;
    private org.openswing.swing.client.ComboBoxControl cbControlTipoSangue;
    private org.openswing.swing.client.ComboBoxControl cbControlTransportadora;
    private org.openswing.swing.client.CodLookupControl codLookupEstadoCivil;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl15;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl16;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumnCobranca;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumnCorrespondencia;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumnEntrega;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumnPrincipal;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumnTipo;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.client.DateControl dateControl9;
    private org.openswing.swing.client.DateControl dateControlCNHVenc;
    private org.openswing.swing.client.DateControl dateControlDataNasc;
    private org.openswing.swing.client.DeleteButton deleteButtonContato;
    private org.openswing.swing.client.DeleteButton deleteButtonEndereco;
    private org.openswing.swing.client.DeleteButton deleteButtonTel;
    private org.openswing.swing.client.EditButton editButtonContato;
    private org.openswing.swing.client.EditButton editButtonEndereco;
    private org.openswing.swing.client.EditButton editButtonPessoa;
    private org.openswing.swing.client.EditButton editButtonTel;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.form.client.Form formPessoaFisica;
    private org.openswing.swing.form.client.Form formPessoaJuridica;
    private org.openswing.swing.client.FormattedTextControl formattedTextControlCnpj;
    private org.openswing.swing.client.FormattedTextControl formattedTextControlCpf;
    private org.openswing.swing.client.GridControl gridControlContatos;
    private org.openswing.swing.client.GridControl gridControlEndereco;
    private org.openswing.swing.client.GridControl gridControlTelefone;
    private org.openswing.swing.client.InsertButton insertButtonContato;
    private org.openswing.swing.client.InsertButton insertButtonEndereco;
    private org.openswing.swing.client.InsertButton insertButtonTel;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelContatos;
    private javax.swing.JPanel jPanelEnderecos;
    private javax.swing.JPanel jPanelPessTipoPessoa;
    private javax.swing.JPanel jPanelPessoaContato;
    private javax.swing.JPanel jPanelPessoaDet;
    private javax.swing.JPanel jPanelPessoaEndereco;
    private javax.swing.JPanel jPanelPessoaTel;
    private javax.swing.JPanel jPanelTelefone;
    private javax.swing.JPanel jPanelTitEleitoral;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPanePessoas;
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
    private org.openswing.swing.client.NavigatorBar navigatorBarContato;
    private org.openswing.swing.client.NavigatorBar navigatorBarEndereco;
    private org.openswing.swing.client.NavigatorBar navigatorBarTel;
    private org.openswing.swing.client.NumericControl numericControl18;
    private org.openswing.swing.client.NumericControl numericControl19;
    private org.openswing.swing.client.NumericControl numericControl21;
    private org.openswing.swing.client.ReloadButton reloadButtonContato;
    private org.openswing.swing.client.ReloadButton reloadButtonEndereco;
    private org.openswing.swing.client.ReloadButton reloadButtonPessoa;
    private org.openswing.swing.client.ReloadButton reloadButtonTel;
    private org.openswing.swing.client.SaveButton saveButtonContato;
    private org.openswing.swing.client.SaveButton saveButtonEndereco;
    private org.openswing.swing.client.SaveButton saveButtonPessoa;
    private org.openswing.swing.client.SaveButton saveButtonTel;
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
