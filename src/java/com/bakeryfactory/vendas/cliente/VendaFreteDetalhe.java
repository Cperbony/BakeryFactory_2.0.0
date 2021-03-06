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
public class VendaFreteDetalhe extends InternalFrame {

    private LookupController transportadoraController;
    private LookupController vendaController;

    /**
     * Creates new form ColaboradorDetalhe
     *
     * @param controller
     */
    public VendaFreteDetalhe(VendaFreteDetalheController controller) {
        this.vendaController = new LookupController();
        this.transportadoraController = new LookupController();
        initComponents();

        form1.setFormController(controller);

/*
         * Configurações do lookup da trasportadora
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
        codLookupControlTransp.setLookupController(transportadoraController);

        /*
         * Configurações do lookup da venda
         */
        vendaController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        vendaController.addLookup2ParentLink("id", "vendaCabecalho.id");
        vendaController.addLookup2ParentLink("numeroFatura", "vendaCabecalho.numeroFatura");
        vendaController.addLookup2ParentLink("cliente.pessoa.nome", "vendaCabecalho.cliente.pessoa.nome");
        vendaController.setHeaderColumnName("id", "ID");
        vendaController.setHeaderColumnName("numeroFatura", "Numero Fatura");
        vendaController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        vendaController.setFrameTitle("Importa Venda");

        vendaController.setVisibleStatusPanel(true);
        vendaController.setVisibleColumn("id", true);
        vendaController.setVisibleColumn("numeroFatura", true);
        vendaController.setVisibleColumn("cliente.pessoa.nome", true);
        vendaController.setFramePreferedSize(new Dimension(600, 500));

        vendaController.setLookupDataLocator(new LookupDataLocatorGenerico(vendaController.getLookupValueObjectClassName()));
        codLookupControlVendaFat.setLookupController(vendaController);
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

        form1 = new org.openswing.swing.form.client.Form();
        lblTransportadoraNome = new org.openswing.swing.client.LabelControl();
        codLookupControlTransp = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        lblVendaNF = new org.openswing.swing.client.LabelControl();
        codLookupControlVendaFat = new org.openswing.swing.client.CodLookupControl();
        lblConhecimento = new org.openswing.swing.client.LabelControl();
        numericControl4 = new org.openswing.swing.client.NumericControl();
        lblResponsavel = new org.openswing.swing.client.LabelControl();
        comboBoxControlResponsavel = new org.openswing.swing.client.ComboBoxControl();
        lblPlaca = new org.openswing.swing.client.LabelControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        lblUfPlaca = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        lblSeloFiscal = new org.openswing.swing.client.LabelControl();
        numericControl8 = new org.openswing.swing.client.NumericControl();
        lblQuantVolume = new org.openswing.swing.client.LabelControl();
        numericControl9 = new org.openswing.swing.client.NumericControl();
        lblMarcaVolume = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblEspecieVolume = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        lblPesoBruto = new org.openswing.swing.client.LabelControl();
        numericControl12 = new org.openswing.swing.client.NumericControl();
        lblPesoLiquido = new org.openswing.swing.client.LabelControl();
        numericControl13 = new org.openswing.swing.client.NumericControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        jSeparator1 = new javax.swing.JSeparator();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        lblVendaCliente = new org.openswing.swing.client.LabelControl();
        lblVendaID = new org.openswing.swing.client.LabelControl();
        lblTransportadora1 = new org.openswing.swing.client.LabelControl();
        jPanel1 = new javax.swing.JPanel();
        editButton1 = new org.openswing.swing.client.EditButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();

        setTitle("Bakery Factory - Vendas e Faturamento");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        form1.setVOClassName("com.bakeryfactory.vendas.java.VendaFreteVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("vendaFrete");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        lblTransportadoraNome.setText("Transportadora Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTransportadoraNome, gridBagConstraints);

        codLookupControlTransp.setAllowOnlyNumbers(true);
        codLookupControlTransp.setAttributeName("transportadora.id");
        codLookupControlTransp.setEnabled(false);
        codLookupControlTransp.setLinkLabel(lblTransportadora1);
        codLookupControlTransp.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlTransp, gridBagConstraints);

        textControl2.setAttributeName("transportadora.pessoa.nome");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        textControl2.setLinkLabel(lblTransportadoraNome);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        lblVendaNF.setText("Venda(Nr Fatura):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblVendaNF, gridBagConstraints);

        codLookupControlVendaFat.setAllowOnlyNumbers(true);
        codLookupControlVendaFat.setAttributeName("vendaCabecalho.id");
        codLookupControlVendaFat.setEnabled(false);
        codLookupControlVendaFat.setLinkLabel(lblVendaID);
        codLookupControlVendaFat.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControlVendaFat, gridBagConstraints);

        lblConhecimento.setLabel("Conhecimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblConhecimento, gridBagConstraints);

        numericControl4.setAttributeName("conhecimento");
        numericControl4.setEnabled(false);
        numericControl4.setLinkLabel(lblConhecimento);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl4, gridBagConstraints);

        lblResponsavel.setText("Responsável:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblResponsavel, gridBagConstraints);

        comboBoxControlResponsavel.setAttributeName("responsavel");
        comboBoxControlResponsavel.setDomainId("VendaResponsavelFrete");
        comboBoxControlResponsavel.setEnabled(false);
        comboBoxControlResponsavel.setLinkLabel(lblResponsavel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControlResponsavel, gridBagConstraints);

        lblPlaca.setLabel("Placa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPlaca, gridBagConstraints);

        textControl6.setAttributeName("placa");
        textControl6.setEnabled(false);
        textControl6.setLinkLabel(lblPlaca);
        textControl6.setMaxCharacters(7);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl6, gridBagConstraints);

        lblUfPlaca.setText("UF Placa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblUfPlaca, gridBagConstraints);

        textControl7.setAttributeName("ufPlaca");
        textControl7.setEnabled(false);
        textControl7.setLinkLabel(lblPlaca);
        textControl7.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl7, gridBagConstraints);

        lblSeloFiscal.setLabel("Selo Fiscal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblSeloFiscal, gridBagConstraints);

        numericControl8.setAttributeName("seloFiscal");
        numericControl8.setEnabled(false);
        numericControl8.setLinkLabel(lblSeloFiscal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl8, gridBagConstraints);

        lblQuantVolume.setLabel("Quantidade Volume:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblQuantVolume, gridBagConstraints);

        numericControl9.setAttributeName("quantidadeVolume");
        numericControl9.setDecimals(2);
        numericControl9.setEnabled(false);
        numericControl9.setLinkLabel(lblQuantVolume);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl9, gridBagConstraints);

        lblMarcaVolume.setLabel("Marca Volume:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblMarcaVolume, gridBagConstraints);

        textControl10.setAttributeName("marcaVolume");
        textControl10.setEnabled(false);
        textControl10.setLinkLabel(lblMarcaVolume);
        textControl10.setMaxCharacters(50);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl10, gridBagConstraints);

        lblEspecieVolume.setText("Espécie Volume:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblEspecieVolume, gridBagConstraints);

        textControl11.setAttributeName("especieVolume");
        textControl11.setEnabled(false);
        textControl11.setLinkLabel(lblEspecieVolume);
        textControl11.setMaxCharacters(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl11, gridBagConstraints);

        lblPesoBruto.setLabel("Peso Bruto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPesoBruto, gridBagConstraints);

        numericControl12.setAttributeName("pesoBruto");
        numericControl12.setDecimals(2);
        numericControl12.setEnabled(false);
        numericControl12.setLinkLabel(lblPesoBruto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl12, gridBagConstraints);

        lblPesoLiquido.setText("Peso Líquido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblPesoLiquido, gridBagConstraints);

        numericControl13.setAttributeName("pesoLiquido");
        numericControl13.setDecimals(2);
        numericControl13.setEnabled(false);
        numericControl13.setLinkLabel(lblPesoLiquido);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl13, gridBagConstraints);

        numericControl1.setAttributeName("cliente.pessoa.nome");
        numericControl1.setEnabled(false);
        numericControl1.setEnabledOnEdit(false);
        numericControl1.setEnabledOnInsert(false);
        numericControl1.setLinkLabel(lblVendaCliente);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        form1.add(jSeparator1, gridBagConstraints);

        numericControl2.setAttributeName("vendaCabecalho.numeroFatura");
        numericControl2.setEnabled(false);
        numericControl2.setEnabledOnEdit(false);
        numericControl2.setEnabledOnInsert(false);
        numericControl2.setLinkLabel(lblVendaNF);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl2, gridBagConstraints);

        lblVendaCliente.setText("Venda(Cliente):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblVendaCliente, gridBagConstraints);

        lblVendaID.setText("Venda(ID):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblVendaID, gridBagConstraints);

        lblTransportadora1.setText("Transportadora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(lblTransportadora1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda Frete"));
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

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControlTransp;
    private org.openswing.swing.client.CodLookupControl codLookupControlVendaFat;
    private org.openswing.swing.client.ComboBoxControl comboBoxControlResponsavel;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private org.openswing.swing.client.LabelControl lblConhecimento;
    private org.openswing.swing.client.LabelControl lblEspecieVolume;
    private org.openswing.swing.client.LabelControl lblMarcaVolume;
    private org.openswing.swing.client.LabelControl lblPesoBruto;
    private org.openswing.swing.client.LabelControl lblPesoLiquido;
    private org.openswing.swing.client.LabelControl lblPlaca;
    private org.openswing.swing.client.LabelControl lblQuantVolume;
    private org.openswing.swing.client.LabelControl lblResponsavel;
    private org.openswing.swing.client.LabelControl lblSeloFiscal;
    private org.openswing.swing.client.LabelControl lblTransportadora1;
    private org.openswing.swing.client.LabelControl lblTransportadoraNome;
    private org.openswing.swing.client.LabelControl lblUfPlaca;
    private org.openswing.swing.client.LabelControl lblVendaCliente;
    private org.openswing.swing.client.LabelControl lblVendaID;
    private org.openswing.swing.client.LabelControl lblVendaNF;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl12;
    private org.openswing.swing.client.NumericControl numericControl13;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.NumericControl numericControl4;
    private org.openswing.swing.client.NumericControl numericControl8;
    private org.openswing.swing.client.NumericControl numericControl9;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    // End of variables declaration//GEN-END:variables
}
