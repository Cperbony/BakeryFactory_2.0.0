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
public class ProdutoDetalhe extends InternalFrame {

    private LookupController produtoSubGrupoLookup;
    private LookupController produtoMarcaLookup;
    private LookupController unidadeLookup;
    private LookupController ncmController;
    private LookupController almoxarifadoLookup;
    private LookupController grupoTributarioController;
    private LookupController icmsCustomizadoController;
    private LookupController fichaLookupController;
    
    private FichaTecnicaGridController fichaTecnicaController;

    /**
     * Creates new form ProdutoDetalhe
     *
     * @param controller
     */
    public ProdutoDetalhe(ProdutoDetalheController controller) {
        this.grupoTributarioController = new LookupController();
        this.icmsCustomizadoController = new LookupController();
        this.almoxarifadoLookup = new LookupController();
        this.ncmController = new LookupController();
        this.unidadeLookup = new LookupController();
        this.produtoMarcaLookup = new LookupController();
        this.produtoSubGrupoLookup = new LookupController();
        this.fichaLookupController = new LookupController();
        initComponents();

        form1.setFormController(controller);
        
        fichaTecnicaController = new FichaTecnicaGridController(this);
        gridControlFichaTecnica.setController(fichaTecnicaController);
        gridControlFichaTecnica.setGridDataLocator(fichaTecnicaController);

        /*
         * Configurações do lookup do sub grupo
         */
        produtoSubGrupoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ProdutoSubGrupoVO");
        produtoSubGrupoLookup.addLookup2ParentLink("id", "produtoSubGrupo.id");
        produtoSubGrupoLookup.addLookup2ParentLink("nome", "produtoSubGrupo.nome");
        produtoSubGrupoLookup.addLookup2ParentLink("descricao", "produtoSubGrupo.descricao");
        produtoSubGrupoLookup.setHeaderColumnName("id", "ID");
        produtoSubGrupoLookup.setHeaderColumnName("nome", "Nome");
        produtoSubGrupoLookup.setHeaderColumnName("descricao", "Descrição");
        produtoSubGrupoLookup.setFrameTitle("Importa Agrupamento");

        produtoSubGrupoLookup.setVisibleStatusPanel(true);
        produtoSubGrupoLookup.setVisibleColumn("id", true);
        produtoSubGrupoLookup.setVisibleColumn("nome", true);
        produtoSubGrupoLookup.setVisibleColumn("descricao", true);
        produtoSubGrupoLookup.setFramePreferedSize(new Dimension(600, 500));

        produtoSubGrupoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(produtoSubGrupoLookup.getLookupValueObjectClassName()));
        codLookupControlSubGrupo.setLookupController(produtoSubGrupoLookup);

        /*
         * Configurações do lookup da unidade
         */
        unidadeLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.UnidadeProdutoVO");
        unidadeLookup.addLookup2ParentLink("id", "unidadeProduto.id");
        unidadeLookup.addLookup2ParentLink("sigla", "unidadeProduto.sigla");
        unidadeLookup.setHeaderColumnName("id", "ID");
        unidadeLookup.setHeaderColumnName("sigla", "Sigla");
        unidadeLookup.setFrameTitle("Importa Unidade Produto");

        unidadeLookup.setVisibleStatusPanel(true);
        unidadeLookup.setVisibleColumn("id", true);
        unidadeLookup.setVisibleColumn("sigla", true);
        unidadeLookup.setFramePreferedSize(new Dimension(600, 500));

        unidadeLookup.setLookupDataLocator(new LookupDataLocatorGenerico(unidadeLookup.getLookupValueObjectClassName()));
        codLookupControlUnidade.setLookupController(unidadeLookup);


        /*
         * Configurações do lookup da marca
         */
        produtoMarcaLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ProdutoMarcaVO");
        produtoMarcaLookup.addLookup2ParentLink("id", "produtoMarca.id");
        produtoMarcaLookup.addLookup2ParentLink("nome", "produtoMarca.nome");
        produtoMarcaLookup.setHeaderColumnName("id", "ID");
        produtoMarcaLookup.setHeaderColumnName("nome", "Nome");
        produtoMarcaLookup.setFrameTitle("Importa Marca Produto");

        produtoMarcaLookup.setVisibleStatusPanel(true);
        produtoMarcaLookup.setVisibleColumn("id", true);
        produtoMarcaLookup.setVisibleColumn("nome", true);
        produtoMarcaLookup.setFramePreferedSize(new Dimension(600, 500));

        produtoMarcaLookup.setLookupDataLocator(new LookupDataLocatorGenerico(produtoMarcaLookup.getLookupValueObjectClassName()));
        codLookupControlMarca.setLookupController(produtoMarcaLookup);

        /*
         * Configurações do lookup do almoxarifado
         */
        almoxarifadoLookup.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.AlmoxarifadoVO");
        almoxarifadoLookup.addLookup2ParentLink("id", "almoxarifado.id");
        almoxarifadoLookup.addLookup2ParentLink("nome", "almoxarifado.nome");
        almoxarifadoLookup.setHeaderColumnName("id", "ID");
        almoxarifadoLookup.setHeaderColumnName("nome", "Nome");
        almoxarifadoLookup.setFrameTitle("Importa Almoxarifado");

        almoxarifadoLookup.setVisibleStatusPanel(true);
        almoxarifadoLookup.setVisibleColumn("id", true);
        almoxarifadoLookup.setVisibleColumn("nome", true);
        almoxarifadoLookup.setFramePreferedSize(new Dimension(600, 500));

        almoxarifadoLookup.setLookupDataLocator(new LookupDataLocatorGenerico(almoxarifadoLookup.getLookupValueObjectClassName()));
        codLookupControlAlmoxarifado.setLookupController(almoxarifadoLookup);


        /*
         * Configurações do lookup do grupo tributario
         */
        grupoTributarioController.setLookupValueObjectClassName("com.bakeryfactory.tributacao.java.TributGrupoTributarioVO");
        grupoTributarioController.addLookup2ParentLink("id", "tributGrupoTributario.id");
        grupoTributarioController.addLookup2ParentLink("descricao", "tributGrupoTributario.descricao");
        grupoTributarioController.setHeaderColumnName("id", "ID");
        grupoTributarioController.setHeaderColumnName("descricao", "Nome");
        grupoTributarioController.setFrameTitle("Importa Grupo Tributário");

        grupoTributarioController.setVisibleStatusPanel(true);
        grupoTributarioController.setVisibleColumn("id", true);
        grupoTributarioController.setVisibleColumn("descricao", true);
        grupoTributarioController.setFramePreferedSize(new Dimension(600, 500));

        grupoTributarioController.setLookupDataLocator(new LookupDataLocatorGenerico(grupoTributarioController.getLookupValueObjectClassName()));
        codLookupControlGrupoTributario.setLookupController(grupoTributarioController);

        /*
         * Configurações do lookup do icms customizado
         */
        icmsCustomizadoController.setLookupValueObjectClassName("com.bakeryfactory.tributacao.java.TributIcmsCustomCabVO");
        icmsCustomizadoController.addLookup2ParentLink("id", "tributIcmsCustomCab.id");
        icmsCustomizadoController.addLookup2ParentLink("descricao", "tributIcmsCustomCab.descricao");
        icmsCustomizadoController.setHeaderColumnName("id", "ID");
        icmsCustomizadoController.setHeaderColumnName("descricao", "Descrição");
        icmsCustomizadoController.setFrameTitle("Importa Icms Customizado");

        icmsCustomizadoController.setVisibleStatusPanel(true);
        icmsCustomizadoController.setVisibleColumn("id", true);
        icmsCustomizadoController.setVisibleColumn("descricao", true);
        icmsCustomizadoController.setFramePreferedSize(new Dimension(600, 500));

        icmsCustomizadoController.setLookupDataLocator(new LookupDataLocatorGenerico(icmsCustomizadoController.getLookupValueObjectClassName()));
        codLookupControlIcmsCustomizado.setLookupController(icmsCustomizadoController);

        /*
         * Configurações do lookup do ncm
         */
        ncmController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.NcmVO");
        ncmController.addLookup2ParentLink("codigo", "ncm");
        ncmController.setHeaderColumnName("codigo", "Código");
        ncmController.setHeaderColumnName("descricao", "Descrição");
        ncmController.setFrameTitle("Importa NCM");

        ncmController.setVisibleStatusPanel(true);
        ncmController.setVisibleColumn("codigo", true);
        ncmController.setVisibleColumn("descricao", true);
        ncmController.setFramePreferedSize(new Dimension(600, 500));

        ncmController.setLookupDataLocator(new LookupDataLocatorGenerico(ncmController.getLookupValueObjectClassName()));
        codLookupControlNcm.setLookupController(ncmController);
        
        /*
         * Configurações do lookup da ficha tecnica
         */
        fichaLookupController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ProdutoVO");
        fichaLookupController.addLookup2ParentLink("id", "idProdutoFilho");
        fichaLookupController.addLookup2ParentLink("descricao", "descricao");
        fichaLookupController.setHeaderColumnName("id", "ID");
        fichaLookupController.setHeaderColumnName("descricao", "Descrição");
        fichaLookupController.setFrameTitle("Importa Produto");

        fichaLookupController.setVisibleStatusPanel(true);
        fichaLookupController.setVisibleColumn("id", true);
        fichaLookupController.setVisibleColumn("descricao", true);
        fichaLookupController.setFramePreferedSize(new Dimension(600, 500));

        fichaLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(fichaLookupController.getLookupValueObjectClassName()));
        codLookupDescricao.setLookupController(fichaLookupController);

    }

    /**
     *
     * @return FORM
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public org.openswing.swing.client.GridControl getGridControl1() {
        return gridControlFichaTecnica;
    }

    public FichaTecnicaGridController getFichaTecnicaController() {
        return fichaTecnicaController;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPrincipal = new javax.swing.JPanel();
        lblICMSCustom = new org.openswing.swing.client.LabelControl();
        codLookupControlIcmsCustomizado = new org.openswing.swing.client.CodLookupControl();
        lblGrupoTibutario = new org.openswing.swing.client.LabelControl();
        codLookupControlGrupoTributario = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        lblUnidade = new org.openswing.swing.client.LabelControl();
        codLookupControlUnidade = new org.openswing.swing.client.CodLookupControl();
        lblMarca = new org.openswing.swing.client.LabelControl();
        codLookupControlMarca = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        lblAlmoxarifado = new org.openswing.swing.client.LabelControl();
        codLookupControlAlmoxarifado = new org.openswing.swing.client.CodLookupControl();
        lblAgrupamento = new org.openswing.swing.client.LabelControl();
        codLookupControlSubGrupo = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        jPanel3 = new javax.swing.JPanel();
        lblGtin = new org.openswing.swing.client.LabelControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        lblCodInterno = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        lblNcm = new org.openswing.swing.client.LabelControl();
        lblNome = new org.openswing.swing.client.LabelControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        lblDescricao = new org.openswing.swing.client.LabelControl();
        lblDescricaoPdv = new org.openswing.swing.client.LabelControl();
        textControl14 = new org.openswing.swing.client.TextControl();
        lblInativo = new org.openswing.swing.client.LabelControl();
        comboBoxControl29 = new org.openswing.swing.client.ComboBoxControl();
        lblClasseAbc = new org.openswing.swing.client.LabelControl();
        comboBoxControl34 = new org.openswing.swing.client.ComboBoxControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jPanel4 = new javax.swing.JPanel();
        lblValorCompra = new org.openswing.swing.client.LabelControl();
        numericControl14 = new org.openswing.swing.client.NumericControl();
        numericControl15 = new org.openswing.swing.client.NumericControl();
        lblValorVenda = new org.openswing.swing.client.LabelControl();
        numericControl16 = new org.openswing.swing.client.NumericControl();
        lblPrecoVendaMin = new org.openswing.swing.client.LabelControl();
        numericControl17 = new org.openswing.swing.client.NumericControl();
        lblPrecoSugerido = new org.openswing.swing.client.LabelControl();
        numericControl18 = new org.openswing.swing.client.NumericControl();
        lblCustoMedioLiq = new org.openswing.swing.client.LabelControl();
        numericControl19 = new org.openswing.swing.client.NumericControl();
        lblPrecoLucroZero = new org.openswing.swing.client.LabelControl();
        lblPrecoLucroMin = new org.openswing.swing.client.LabelControl();
        numericControl20 = new org.openswing.swing.client.NumericControl();
        lblPrecoLucroMax = new org.openswing.swing.client.LabelControl();
        numericControl21 = new org.openswing.swing.client.NumericControl();
        lblMarkup = new org.openswing.swing.client.LabelControl();
        numericControl22 = new org.openswing.swing.client.NumericControl();
        lblQuantEstoque = new org.openswing.swing.client.LabelControl();
        numericControl23 = new org.openswing.swing.client.NumericControl();
        lblQuantEstoqueAnterior = new org.openswing.swing.client.LabelControl();
        numericControl24 = new org.openswing.swing.client.NumericControl();
        lblEstoqueMinimo = new org.openswing.swing.client.LabelControl();
        numericControl25 = new org.openswing.swing.client.NumericControl();
        lblEstoqueMax = new org.openswing.swing.client.LabelControl();
        numericControl26 = new org.openswing.swing.client.NumericControl();
        lblEstoqueIdeal = new org.openswing.swing.client.LabelControl();
        numericControl27 = new org.openswing.swing.client.NumericControl();
        jSeparator1 = new javax.swing.JSeparator();
        codLookupControlNcm = new org.openswing.swing.client.CodLookupControl();
        jPanelDados = new javax.swing.JPanel();
        lblExTipi = new org.openswing.swing.client.LabelControl();
        textControl32 = new org.openswing.swing.client.TextControl();
        lblCodLst = new org.openswing.swing.client.LabelControl();
        textControl33 = new org.openswing.swing.client.TextControl();
        lblFotoProduto = new org.openswing.swing.client.LabelControl();
        lblIat = new org.openswing.swing.client.LabelControl();
        comboBoxControl35 = new org.openswing.swing.client.ComboBoxControl();
        lblIppt = new org.openswing.swing.client.LabelControl();
        comboBoxControl36 = new org.openswing.swing.client.ComboBoxControl();
        lblTipoItemSped = new org.openswing.swing.client.LabelControl();
        lblTotalizadorParcial = new org.openswing.swing.client.LabelControl();
        textControl44 = new org.openswing.swing.client.TextControl();
        lblCodBalanca = new org.openswing.swing.client.LabelControl();
        numericControl45 = new org.openswing.swing.client.NumericControl();
        imageCtrFotoProduto = new org.openswing.swing.client.ImageControl();
        lblPeso = new org.openswing.swing.client.LabelControl();
        numericControl38 = new org.openswing.swing.client.NumericControl();
        lblPorcentoComissao = new org.openswing.swing.client.LabelControl();
        numericControl39 = new org.openswing.swing.client.NumericControl();
        lblPontoPedido = new org.openswing.swing.client.LabelControl();
        numericControl40 = new org.openswing.swing.client.NumericControl();
        lblLoteEconomico = new org.openswing.swing.client.LabelControl();
        numericControl41 = new org.openswing.swing.client.NumericControl();
        lblAliqIcmsPaf = new org.openswing.swing.client.LabelControl();
        numericControl42 = new org.openswing.swing.client.NumericControl();
        lblAliquotaIssqnPaf = new org.openswing.swing.client.LabelControl();
        numericControl43 = new org.openswing.swing.client.NumericControl();
        jSeparator2 = new javax.swing.JSeparator();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        lblTipo = new org.openswing.swing.client.LabelControl();
        comboBoxControl47 = new org.openswing.swing.client.ComboBoxControl();
        jPanelFichaTecnica = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton2 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton2 = new org.openswing.swing.client.ReloadButton();
        saveButton2 = new org.openswing.swing.client.SaveButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();
        gridControlFichaTecnica = new org.openswing.swing.client.GridControl();
        codLookupDescricao = new org.openswing.swing.table.columns.client.CodLookupColumn();
        integerColumnSequencia = new org.openswing.swing.table.columns.client.IntegerColumn();
        decimalColumnQuantidade = new org.openswing.swing.table.columns.client.DecimalColumn();

        setTitle("Bakery Factory - Produtos");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produtos"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.bakeryfactory.cadastros.java.ProdutoVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("produto");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        jPanelPrincipal.setLayout(new java.awt.GridBagLayout());

        lblICMSCustom.setText("ICMS Customizado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblICMSCustom, gridBagConstraints);

        codLookupControlIcmsCustomizado.setAllowOnlyNumbers(true);
        codLookupControlIcmsCustomizado.setAttributeName("tributIcmsCustomCab.id");
        codLookupControlIcmsCustomizado.setEnabled(false);
        codLookupControlIcmsCustomizado.setLinkLabel(lblICMSCustom);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlIcmsCustomizado, gridBagConstraints);

        lblGrupoTibutario.setText("Grupo Tributário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblGrupoTibutario, gridBagConstraints);

        codLookupControlGrupoTributario.setAllowOnlyNumbers(true);
        codLookupControlGrupoTributario.setAttributeName("tributGrupoTributario.id");
        codLookupControlGrupoTributario.setEnabled(false);
        codLookupControlGrupoTributario.setLinkLabel(lblGrupoTibutario);
        codLookupControlGrupoTributario.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlGrupoTributario, gridBagConstraints);

        textControl5.setAttributeName("tributGrupoTributario.descricao");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(textControl5, gridBagConstraints);

        textControl2.setAttributeName("tributIcmsCustomCab.descricao");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(textControl2, gridBagConstraints);

        lblUnidade.setText("Unidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblUnidade, gridBagConstraints);

        codLookupControlUnidade.setAllowOnlyNumbers(true);
        codLookupControlUnidade.setAttributeName("unidadeProduto.id");
        codLookupControlUnidade.setEnabled(false);
        codLookupControlUnidade.setLinkLabel(lblUnidade);
        codLookupControlUnidade.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlUnidade, gridBagConstraints);

        lblMarca.setText("Marca:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblMarca, gridBagConstraints);

        codLookupControlMarca.setAllowOnlyNumbers(true);
        codLookupControlMarca.setAttributeName("produtoMarca.id");
        codLookupControlMarca.setEnabled(false);
        codLookupControlMarca.setLinkLabel(lblMarca);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlMarca, gridBagConstraints);

        textControl6.setAttributeName("produtoMarca.nome");
        textControl6.setEnabled(false);
        textControl6.setEnabledOnEdit(false);
        textControl6.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanelPrincipal.add(textControl6, gridBagConstraints);

        textControl3.setAttributeName("unidadeProduto.sigla");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanelPrincipal.add(textControl3, gridBagConstraints);

        lblAlmoxarifado.setText("Almoxarifado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblAlmoxarifado, gridBagConstraints);

        codLookupControlAlmoxarifado.setAllowOnlyNumbers(true);
        codLookupControlAlmoxarifado.setAttributeName("almoxarifado.id");
        codLookupControlAlmoxarifado.setEnabled(false);
        codLookupControlAlmoxarifado.setLinkLabel(lblAlmoxarifado);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlAlmoxarifado, gridBagConstraints);

        lblAgrupamento.setText("Agrupamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelPrincipal.add(lblAgrupamento, gridBagConstraints);

        codLookupControlSubGrupo.setAllowOnlyNumbers(true);
        codLookupControlSubGrupo.setAttributeName("produtoSubGrupo.id");
        codLookupControlSubGrupo.setEnabled(false);
        codLookupControlSubGrupo.setLinkLabel(lblUnidade);
        codLookupControlSubGrupo.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(codLookupControlSubGrupo, gridBagConstraints);

        textControl4.setAttributeName("almoxarifado.nome");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelPrincipal.add(textControl4, gridBagConstraints);

        textControl7.setAttributeName("produtoSubGrupo.nome");
        textControl7.setEnabled(false);
        textControl7.setEnabledOnEdit(false);
        textControl7.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanelPrincipal.add(textControl7, gridBagConstraints);

        textControl8.setAttributeName("produtoSubGrupo.descricao");
        textControl8.setEnabled(false);
        textControl8.setEnabledOnEdit(false);
        textControl8.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanelPrincipal.add(textControl8, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblGtin.setText("GTIN:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblGtin, gridBagConstraints);

        textControl9.setAttributeName("gtin");
        textControl9.setEnabled(false);
        textControl9.setMaxCharacters(14);
        textControl9.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(textControl9, gridBagConstraints);

        lblCodInterno.setText("Código Interno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblCodInterno, gridBagConstraints);

        textControl10.setAttributeName("codigoInterno");
        textControl10.setEnabled(false);
        textControl10.setMaxCharacters(60);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(textControl10, gridBagConstraints);

        lblNcm.setText("NCM:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblNcm, gridBagConstraints);

        lblNome.setLabel("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblNome, gridBagConstraints);

        textControl12.setAttributeName("nome");
        textControl12.setEnabled(false);
        textControl12.setMaxCharacters(100);
        textControl12.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(textControl12, gridBagConstraints);

        lblDescricao.setText("Descrição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblDescricao, gridBagConstraints);

        lblDescricaoPdv.setText("Descrição PDV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblDescricaoPdv, gridBagConstraints);

        textControl14.setAttributeName("descricaoPdv");
        textControl14.setEnabled(false);
        textControl14.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(textControl14, gridBagConstraints);

        lblInativo.setLabel("Inativo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblInativo, gridBagConstraints);

        comboBoxControl29.setAttributeName("inativo");
        comboBoxControl29.setDomainId("naosim");
        comboBoxControl29.setEnabled(false);
        comboBoxControl29.setLinkLabel(lblInativo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(comboBoxControl29, gridBagConstraints);

        lblClasseAbc.setText("Classe ABC:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(lblClasseAbc, gridBagConstraints);

        comboBoxControl34.setAttributeName("classeAbc");
        comboBoxControl34.setDomainId("produtoClasse");
        comboBoxControl34.setEnabled(false);
        comboBoxControl34.setLinkLabel(lblClasseAbc);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(comboBoxControl34, gridBagConstraints);

        textAreaControl1.setAttributeName("descricao");
        textAreaControl1.setEnabled(false);
        textAreaControl1.setMaxCharacters(1000);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(textAreaControl1, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores Principais"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblValorCompra.setLabel("Valor Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblValorCompra, gridBagConstraints);

        numericControl14.setAttributeName("valorCompra");
        numericControl14.setDecimals(2);
        numericControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl14, gridBagConstraints);

        numericControl15.setAttributeName("valorVenda");
        numericControl15.setDecimals(2);
        numericControl15.setEnabled(false);
        numericControl15.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl15, gridBagConstraints);

        lblValorVenda.setLabel("Valor Venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblValorVenda, gridBagConstraints);

        numericControl16.setAttributeName("precoVendaMinimo");
        numericControl16.setDecimals(2);
        numericControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl16, gridBagConstraints);

        lblPrecoVendaMin.setText("Preço Venda Minímo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblPrecoVendaMin, gridBagConstraints);

        numericControl17.setAttributeName("precoSugerido");
        numericControl17.setDecimals(2);
        numericControl17.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl17, gridBagConstraints);

        lblPrecoSugerido.setText("Preço Sugerido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblPrecoSugerido, gridBagConstraints);

        numericControl18.setAttributeName("custoMedioLiquido");
        numericControl18.setDecimals(2);
        numericControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl18, gridBagConstraints);

        lblCustoMedioLiq.setText("Custo Médio Líquido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblCustoMedioLiq, gridBagConstraints);

        numericControl19.setAttributeName("precoLucroZero");
        numericControl19.setDecimals(2);
        numericControl19.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl19, gridBagConstraints);

        lblPrecoLucroZero.setText("Preço Lucro Zero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblPrecoLucroZero, gridBagConstraints);

        lblPrecoLucroMin.setText("Preço Lucro Mínimo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblPrecoLucroMin, gridBagConstraints);

        numericControl20.setAttributeName("precoLucroMinimo");
        numericControl20.setDecimals(2);
        numericControl20.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl20, gridBagConstraints);

        lblPrecoLucroMax.setText("Preço Lucro Máximo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblPrecoLucroMax, gridBagConstraints);

        numericControl21.setAttributeName("precoLucroMaximo");
        numericControl21.setDecimals(2);
        numericControl21.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl21, gridBagConstraints);

        lblMarkup.setLabel("Markup:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblMarkup, gridBagConstraints);

        numericControl22.setAttributeName("markup");
        numericControl22.setDecimals(2);
        numericControl22.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl22, gridBagConstraints);

        lblQuantEstoque.setLabel("Quantidade Estoque:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblQuantEstoque, gridBagConstraints);

        numericControl23.setAttributeName("quantidadeEstoque");
        numericControl23.setDecimals(2);
        numericControl23.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl23, gridBagConstraints);

        lblQuantEstoqueAnterior.setLabel("Quantidade Estoque Anterior:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblQuantEstoqueAnterior, gridBagConstraints);

        numericControl24.setAttributeName("quantidadeEstoqueAnterior");
        numericControl24.setDecimals(2);
        numericControl24.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl24, gridBagConstraints);

        lblEstoqueMinimo.setText("Estoque Mínimo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblEstoqueMinimo, gridBagConstraints);

        numericControl25.setAttributeName("estoqueMinimo");
        numericControl25.setDecimals(2);
        numericControl25.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl25, gridBagConstraints);

        lblEstoqueMax.setText("Estoque Máximo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblEstoqueMax, gridBagConstraints);

        numericControl26.setAttributeName("estoqueMaximo");
        numericControl26.setDecimals(2);
        numericControl26.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl26, gridBagConstraints);

        lblEstoqueIdeal.setLabel("Estoque Ideal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel4.add(lblEstoqueIdeal, gridBagConstraints);

        numericControl27.setAttributeName("estoqueIdeal");
        numericControl27.setDecimals(2);
        numericControl27.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel4.add(numericControl27, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jPanel4, gridBagConstraints);

        codLookupControlNcm.setAttributeName("ncm");
        codLookupControlNcm.setEnableCodBox(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel3.add(codLookupControlNcm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelPrincipal.add(jPanel3, gridBagConstraints);

        jTabbedPane1.addTab("Principal", jPanelPrincipal);

        jPanelDados.setLayout(new java.awt.GridBagLayout());

        lblExTipi.setText("Ex TIPI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblExTipi, gridBagConstraints);

        textControl32.setAttributeName("exTipi");
        textControl32.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(textControl32, gridBagConstraints);

        lblCodLst.setText("Código LST:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblCodLst, gridBagConstraints);

        textControl33.setAttributeName("codigoLst");
        textControl33.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(textControl33, gridBagConstraints);

        lblFotoProduto.setLabel("Foto Produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblFotoProduto, gridBagConstraints);

        lblIat.setText("IAT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblIat, gridBagConstraints);

        comboBoxControl35.setAttributeName("iat");
        comboBoxControl35.setDomainId("produtoIat");
        comboBoxControl35.setEnabled(false);
        comboBoxControl35.setLinkLabel(lblIat);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(comboBoxControl35, gridBagConstraints);

        lblIppt.setText("IPPT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblIppt, gridBagConstraints);

        comboBoxControl36.setAttributeName("ippt");
        comboBoxControl36.setDomainId("produtoIppt");
        comboBoxControl36.setEnabled(false);
        comboBoxControl36.setLinkLabel(lblIppt);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(comboBoxControl36, gridBagConstraints);

        lblTipoItemSped.setLabel("Tipo Item Sped:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblTipoItemSped, gridBagConstraints);

        lblTotalizadorParcial.setLabel("Totalizador Parcial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblTotalizadorParcial, gridBagConstraints);

        textControl44.setAttributeName("totalizadorParcial");
        textControl44.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(textControl44, gridBagConstraints);

        lblCodBalanca.setText("Código Balança:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblCodBalanca, gridBagConstraints);

        numericControl45.setAttributeName("codigoBalanca");
        numericControl45.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl45, gridBagConstraints);

        imageCtrFotoProduto.setAttributeName("imagem");
        imageCtrFotoProduto.setCanCopy(false);
        imageCtrFotoProduto.setLinkLabel(lblFotoProduto);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(imageCtrFotoProduto, gridBagConstraints);

        lblPeso.setLabel("Peso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblPeso, gridBagConstraints);

        numericControl38.setAttributeName("peso");
        numericControl38.setDecimals(2);
        numericControl38.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl38, gridBagConstraints);

        lblPorcentoComissao.setText("Porcento Comissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblPorcentoComissao, gridBagConstraints);

        numericControl39.setAttributeName("porcentoComissao");
        numericControl39.setDecimals(2);
        numericControl39.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl39, gridBagConstraints);

        lblPontoPedido.setLabel("Ponto Pedido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblPontoPedido, gridBagConstraints);

        numericControl40.setAttributeName("pontoPedido");
        numericControl40.setDecimals(2);
        numericControl40.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl40, gridBagConstraints);

        lblLoteEconomico.setText("Lote Econômico Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblLoteEconomico, gridBagConstraints);

        numericControl41.setAttributeName("loteEconomicoCompra");
        numericControl41.setDecimals(2);
        numericControl41.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl41, gridBagConstraints);

        lblAliqIcmsPaf.setText("Alíquota ICMS PAF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblAliqIcmsPaf, gridBagConstraints);

        numericControl42.setAttributeName("aliquotaIcmsPaf");
        numericControl42.setDecimals(2);
        numericControl42.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl42, gridBagConstraints);

        lblAliquotaIssqnPaf.setText("Alíquota ISSQN PAF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblAliquotaIssqnPaf, gridBagConstraints);

        numericControl43.setAttributeName("aliquotaIssqnPaf");
        numericControl43.setDecimals(2);
        numericControl43.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(numericControl43, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelDados.add(jSeparator2, gridBagConstraints);

        comboBoxControl1.setAttributeName("tipoItemSped");
        comboBoxControl1.setDomainId("produtoTipoItemSped");
        comboBoxControl1.setEnabled(false);
        comboBoxControl1.setLinkLabel(lblTipoItemSped);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(comboBoxControl1, gridBagConstraints);

        lblTipo.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanelDados.add(lblTipo, gridBagConstraints);

        comboBoxControl47.setAttributeName("tipo");
        comboBoxControl47.setDomainId("produtoTipo");
        comboBoxControl47.setEnabled(false);
        comboBoxControl47.setLinkLabel(lblTipo);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanelDados.add(comboBoxControl47, gridBagConstraints);

        jTabbedPane1.addTab("Dados Complementares", jPanelDados);

        jPanelFichaTecnica.setLayout(new java.awt.GridBagLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Ficha Técnica"));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel7.add(insertButton1);
        jPanel7.add(editButton2);
        jPanel7.add(deleteButton1);
        jPanel7.add(reloadButton2);
        jPanel7.add(saveButton2);
        jPanel7.add(navigatorBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelFichaTecnica.add(jPanel7, gridBagConstraints);

        gridControlFichaTecnica.setAutoLoadData(false);
        gridControlFichaTecnica.setDeleteButton(deleteButton1);
        gridControlFichaTecnica.setEditButton(editButton2);
        gridControlFichaTecnica.setFunctionId("fichaTecnica");
        gridControlFichaTecnica.setInsertButton(insertButton1);
        gridControlFichaTecnica.setNavBar(navigatorBar1);
        gridControlFichaTecnica.setReloadButton(reloadButton2);
        gridControlFichaTecnica.setSaveButton(saveButton2);
        gridControlFichaTecnica.setValueObjectClassName("com.bakeryfactory.cadastros.java.FichaTecnicaVO");
        gridControlFichaTecnica.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupDescricao.setColumnName("descricao");
        codLookupDescricao.setEditableOnEdit(true);
        codLookupDescricao.setEditableOnInsert(true);
        codLookupDescricao.setHeaderColumnName("Descrição");
        codLookupDescricao.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupDescricao.setPreferredWidth(300);
        gridControlFichaTecnica.getColumnContainer().add(codLookupDescricao);

        integerColumnSequencia.setColumnName("sequenciaProducao");
        integerColumnSequencia.setEditableOnEdit(true);
        integerColumnSequencia.setEditableOnInsert(true);
        integerColumnSequencia.setHeaderColumnName("Sequência Produção");
        integerColumnSequencia.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        integerColumnSequencia.setPreferredWidth(120);
        gridControlFichaTecnica.getColumnContainer().add(integerColumnSequencia);

        decimalColumnQuantidade.setColumnName("quantidade");
        decimalColumnQuantidade.setDecimals(2);
        decimalColumnQuantidade.setEditableOnEdit(true);
        decimalColumnQuantidade.setEditableOnInsert(true);
        decimalColumnQuantidade.setHeaderColumnName("Quantidade");
        decimalColumnQuantidade.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlFichaTecnica.getColumnContainer().add(decimalColumnQuantidade);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelFichaTecnica.add(gridControlFichaTecnica, gridBagConstraints);

        jTabbedPane1.addTab("Ficha Técnica", jPanelFichaTecnica);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        form1.add(jTabbedPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(form1, gridBagConstraints);
        form1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControlAlmoxarifado;
    private org.openswing.swing.client.CodLookupControl codLookupControlGrupoTributario;
    private org.openswing.swing.client.CodLookupControl codLookupControlIcmsCustomizado;
    private org.openswing.swing.client.CodLookupControl codLookupControlMarca;
    private org.openswing.swing.client.CodLookupControl codLookupControlNcm;
    private org.openswing.swing.client.CodLookupControl codLookupControlSubGrupo;
    private org.openswing.swing.client.CodLookupControl codLookupControlUnidade;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupDescricao;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl29;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl34;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl35;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl36;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl47;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumnQuantidade;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton2;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControlFichaTecnica;
    private org.openswing.swing.client.ImageControl imageCtrFotoProduto;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumnSequencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelFichaTecnica;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl lblAgrupamento;
    private org.openswing.swing.client.LabelControl lblAliqIcmsPaf;
    private org.openswing.swing.client.LabelControl lblAliquotaIssqnPaf;
    private org.openswing.swing.client.LabelControl lblAlmoxarifado;
    private org.openswing.swing.client.LabelControl lblClasseAbc;
    private org.openswing.swing.client.LabelControl lblCodBalanca;
    private org.openswing.swing.client.LabelControl lblCodInterno;
    private org.openswing.swing.client.LabelControl lblCodLst;
    private org.openswing.swing.client.LabelControl lblCustoMedioLiq;
    private org.openswing.swing.client.LabelControl lblDescricao;
    private org.openswing.swing.client.LabelControl lblDescricaoPdv;
    private org.openswing.swing.client.LabelControl lblEstoqueIdeal;
    private org.openswing.swing.client.LabelControl lblEstoqueMax;
    private org.openswing.swing.client.LabelControl lblEstoqueMinimo;
    private org.openswing.swing.client.LabelControl lblExTipi;
    private org.openswing.swing.client.LabelControl lblFotoProduto;
    private org.openswing.swing.client.LabelControl lblGrupoTibutario;
    private org.openswing.swing.client.LabelControl lblGtin;
    private org.openswing.swing.client.LabelControl lblICMSCustom;
    private org.openswing.swing.client.LabelControl lblIat;
    private org.openswing.swing.client.LabelControl lblInativo;
    private org.openswing.swing.client.LabelControl lblIppt;
    private org.openswing.swing.client.LabelControl lblLoteEconomico;
    private org.openswing.swing.client.LabelControl lblMarca;
    private org.openswing.swing.client.LabelControl lblMarkup;
    private org.openswing.swing.client.LabelControl lblNcm;
    private org.openswing.swing.client.LabelControl lblNome;
    private org.openswing.swing.client.LabelControl lblPeso;
    private org.openswing.swing.client.LabelControl lblPontoPedido;
    private org.openswing.swing.client.LabelControl lblPorcentoComissao;
    private org.openswing.swing.client.LabelControl lblPrecoLucroMax;
    private org.openswing.swing.client.LabelControl lblPrecoLucroMin;
    private org.openswing.swing.client.LabelControl lblPrecoLucroZero;
    private org.openswing.swing.client.LabelControl lblPrecoSugerido;
    private org.openswing.swing.client.LabelControl lblPrecoVendaMin;
    private org.openswing.swing.client.LabelControl lblQuantEstoque;
    private org.openswing.swing.client.LabelControl lblQuantEstoqueAnterior;
    private org.openswing.swing.client.LabelControl lblTipo;
    private org.openswing.swing.client.LabelControl lblTipoItemSped;
    private org.openswing.swing.client.LabelControl lblTotalizadorParcial;
    private org.openswing.swing.client.LabelControl lblUnidade;
    private org.openswing.swing.client.LabelControl lblValorCompra;
    private org.openswing.swing.client.LabelControl lblValorVenda;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.NumericControl numericControl14;
    private org.openswing.swing.client.NumericControl numericControl15;
    private org.openswing.swing.client.NumericControl numericControl16;
    private org.openswing.swing.client.NumericControl numericControl17;
    private org.openswing.swing.client.NumericControl numericControl18;
    private org.openswing.swing.client.NumericControl numericControl19;
    private org.openswing.swing.client.NumericControl numericControl20;
    private org.openswing.swing.client.NumericControl numericControl21;
    private org.openswing.swing.client.NumericControl numericControl22;
    private org.openswing.swing.client.NumericControl numericControl23;
    private org.openswing.swing.client.NumericControl numericControl24;
    private org.openswing.swing.client.NumericControl numericControl25;
    private org.openswing.swing.client.NumericControl numericControl26;
    private org.openswing.swing.client.NumericControl numericControl27;
    private org.openswing.swing.client.NumericControl numericControl38;
    private org.openswing.swing.client.NumericControl numericControl39;
    private org.openswing.swing.client.NumericControl numericControl40;
    private org.openswing.swing.client.NumericControl numericControl41;
    private org.openswing.swing.client.NumericControl numericControl42;
    private org.openswing.swing.client.NumericControl numericControl43;
    private org.openswing.swing.client.NumericControl numericControl45;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton2;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton2;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl14;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl32;
    private org.openswing.swing.client.TextControl textControl33;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl44;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables
}
