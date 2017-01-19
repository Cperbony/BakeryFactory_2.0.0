/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.util.client.ClientUtils;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class AgendaCompromissoDetalhe extends InternalFrame {

    private AgendaCompromissoDetalheController controller;

    private LookupController colaboradorController = new LookupController();
    private LookupController categoriaController = new LookupController();
    private LookupController colaboradorConvidadoController = new LookupController();
    private LookupController producaoSalaController = new LookupController();
    private AgendaCompromissoConvidadoGridController gridConvidadoController;
    private ProducaoSalaEventoDetalheController producaoSalaEventoController;
    private LookupController pcpProduto = new LookupController();

    /**
     * Creates new form AgendaCompromissoDetalhe
     *
     * @param controller
     */
    public AgendaCompromissoDetalhe(AgendaCompromissoDetalheController controller) {
        initComponents();

        genericButtonAgenda.setToolTipText("Visualizar Agenda");
        this.controller = controller;
        formAgendaCompromisso.setFormController(controller);

        gridConvidadoController = new AgendaCompromissoConvidadoGridController(this);
        gridControlColaborador.setController(gridConvidadoController);
        gridControlColaborador.setGridDataLocator(gridConvidadoController);

        producaoSalaEventoController = new ProducaoSalaEventoDetalheController();
        formReuniao.setFormController(producaoSalaEventoController);

        formattedTextControl1.setEnabled(false);
        try {
            MaskFormatter mask = new MaskFormatter("##:##:##");
            mask.setValidCharacters("0123456789");
            formattedTextControl1.setFormatter(mask);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /*
         * Configurações do lookup do coladorador
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
        codLookupControl2.setLookupController(colaboradorController);

        /*
         * Configurações do lookup da categoria
         */
        categoriaController.setLookupValueObjectClassName("com.bakeryfactory.calendarioproducao.java.AgendaCategoriaCompromissoVO");
        categoriaController.addLookup2ParentLink("id", "agendaCategoriaCompromisso.id");
        categoriaController.addLookup2ParentLink("nome", "agendaCategoriaCompromisso.nome");
        categoriaController.setHeaderColumnName("id", "ID");
        categoriaController.setHeaderColumnName("nome", "Nome");
        categoriaController.setFrameTitle("Importa Categoria");

        categoriaController.setVisibleStatusPanel(true);
        categoriaController.setVisibleColumn("id", true);
        categoriaController.setVisibleColumn("nome", true);
        categoriaController.setFramePreferedSize(new Dimension(600, 500));

        categoriaController.setLookupDataLocator(new LookupDataLocatorGenerico(categoriaController.getLookupValueObjectClassName()));
        codLookupControl3.setLookupController(categoriaController);

        /*
         * Configurações do lookup do convidado
         */
        colaboradorConvidadoController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ColaboradorVO");
        colaboradorConvidadoController.addLookup2ParentLink("id", "colaborador.id");
        colaboradorConvidadoController.addLookup2ParentLink("pessoa.nome", "colaborador.pessoa.nome");
        colaboradorConvidadoController.setHeaderColumnName("id", "ID");
        colaboradorConvidadoController.setHeaderColumnName("pessoa.nome", "Nome");
        colaboradorConvidadoController.setFrameTitle("Importa Colaborador");

        colaboradorConvidadoController.setVisibleStatusPanel(true);
        colaboradorConvidadoController.setVisibleColumn("id", true);
        colaboradorConvidadoController.setVisibleColumn("pessoa.nome", true);
        colaboradorConvidadoController.setFramePreferedSize(new Dimension(600, 500));

        colaboradorConvidadoController.setLookupDataLocator(new LookupDataLocatorGenerico(colaboradorConvidadoController.getLookupValueObjectClassName()));
        codLookupColumn1.setLookupController(colaboradorConvidadoController);

        /*
         * Configurações do lookup do Produto PCP
         */
        pcpProduto.setLookupValueObjectClassName("com.bakeryfactory.pcp.java.PcpOpDetalheVO");
        pcpProduto.addLookup2ParentLink("id", "pcpOpDetalhe.id");
        pcpProduto.addLookup2ParentLink("produto.nome", "pcpOpDetalhe.produto.nome");
        pcpProduto.addLookup2ParentLink("quantidadeProduzir", "pcpOpDetalhe.quantidadeProduzir");
        pcpProduto.addLookup2ParentLink("quantidadeProduzida", "pcpOpDetalhe.quantidadeProduzida");
        pcpProduto.setHeaderColumnName("id", "ID");
        pcpProduto.setHeaderColumnName("produto.nome", "Nome Produto");
        pcpProduto.setHeaderColumnName("pcpOpDetalhe.quantidadeProduzir", "Quantidade Produzir");
        pcpProduto.setHeaderColumnName("pcpOpDetalhe.quantidadeProduzida", "Quantidade Já Produzida");
        pcpProduto.setFrameTitle("Importa Produtos Produção PCP");

        pcpProduto.setVisibleStatusPanel(true);
        pcpProduto.setVisibleColumn("id", true);
        pcpProduto.setVisibleColumn("produto.nome", true);
        pcpProduto.setVisibleColumn("quantidadeProduzir", true);
        pcpProduto.setVisibleColumn("quantidadeProduzida", true);
        pcpProduto.setFramePreferedSize(new Dimension(600, 500));

        pcpProduto.setLookupDataLocator(new LookupDataLocatorGenerico(pcpProduto.getLookupValueObjectClassName()));
        codLookupControlPcpDetalhe.setLookupController(pcpProduto);

        /*
         * Configurações do lookup da sala de reuniao
         */
        producaoSalaController.setLookupValueObjectClassName("com.bakeryfactory.calendarioproducao.java.ProducaoSalaVO");
        producaoSalaController.addLookup2ParentLink("id", "producaoSala.id");
        producaoSalaController.addLookup2ParentLink("predio", "producaoSala.predio");
        producaoSalaController.addLookup2ParentLink("andar", "producaoSala.andar");
        producaoSalaController.addLookup2ParentLink("numero", "producaoSala.numero");
        producaoSalaController.setHeaderColumnName("id", "ID");
        producaoSalaController.setHeaderColumnName("predio", "Predio");
        producaoSalaController.setHeaderColumnName("andar", "Andar");
        producaoSalaController.setHeaderColumnName("numero", "Numero");
        producaoSalaController.setFrameTitle("Importa Sala Produção");

        producaoSalaController.setVisibleStatusPanel(true);
        producaoSalaController.setVisibleColumn("id", true);
        producaoSalaController.setVisibleColumn("predio", true);
        producaoSalaController.setVisibleColumn("andar", true);
        producaoSalaController.setVisibleColumn("numero", true);
        producaoSalaController.setFramePreferedSize(new Dimension(600, 500));

        producaoSalaController.setLookupDataLocator(new LookupDataLocatorGenerico(producaoSalaController.getLookupValueObjectClassName()));
        codLookupControl6.setLookupController(producaoSalaController);

    }

    /**
     * @return the form1
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return formAgendaCompromisso;
    }

    public org.openswing.swing.form.client.Form getFormReuniao() {
        return formReuniao;
    }

    public AgendaCompromissoConvidadoGridController getGridConvidadoController() {
        return gridConvidadoController;
    }

    public ProducaoSalaEventoDetalheController getProducaoSalaEventoController() {
        return producaoSalaEventoController;
    }

    public org.openswing.swing.client.GridControl getGridControl1() {
        return gridControlColaborador;

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        editButtonAgenda = new org.openswing.swing.client.EditButton();
        reloadButtonAgenda = new org.openswing.swing.client.ReloadButton();
        saveButtonAgenda = new org.openswing.swing.client.SaveButton();
        genericButtonAgenda = new org.openswing.swing.client.GenericButton(new ImageIcon(ClientUtils.getImage(ClientSettings.CALENDAR)));
        formAgendaCompromisso = new org.openswing.swing.form.client.Form();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        dateControl4 = new org.openswing.swing.client.DateControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        numericControl6 = new org.openswing.swing.client.NumericControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        formattedTextControl1 = new org.openswing.swing.client.FormattedTextControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        comboBoxControl2 = new org.openswing.swing.client.ComboBoxControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        codLookupControlPcpDetalhe = new org.openswing.swing.client.CodLookupControl();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        labelControl19 = new org.openswing.swing.client.LabelControl();
        labelControl20 = new org.openswing.swing.client.LabelControl();
        labelControl21 = new org.openswing.swing.client.LabelControl();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        insertButtonConvidados = new org.openswing.swing.client.InsertButton();
        deleteButtonConvidados = new org.openswing.swing.client.DeleteButton();
        reloadButtonConvidados = new org.openswing.swing.client.ReloadButton();
        saveButtonConvidados = new org.openswing.swing.client.SaveButton();
        navigatorBarConvidados = new org.openswing.swing.client.NavigatorBar();
        gridControlColaborador = new org.openswing.swing.client.GridControl();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        editButtonReuniao = new org.openswing.swing.client.EditButton();
        reloadButtonReuniao = new org.openswing.swing.client.ReloadButton();
        saveButtonReuniao = new org.openswing.swing.client.SaveButton();
        formReuniao = new org.openswing.swing.form.client.Form();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        codLookupControl6 = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        labelControl16 = new org.openswing.swing.client.LabelControl();
        dateControl7 = new org.openswing.swing.client.DateControl();
        jSeparator3 = new javax.swing.JSeparator();
        textControl9 = new org.openswing.swing.client.TextControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        labelControl17 = new org.openswing.swing.client.LabelControl();
        labelControl18 = new org.openswing.swing.client.LabelControl();

        setTitle("Bakery Factory - Calendário Produção");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agenda Compromisso"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButtonAgenda);
        jPanel1.add(reloadButtonAgenda);
        jPanel1.add(saveButtonAgenda);

        genericButtonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genericButtonAgendaActionPerformed(evt);
            }
        });
        jPanel1.add(genericButtonAgenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        formAgendaCompromisso.setVOClassName("com.bakeryfactory.calendarioproducao.java.AgendaCompromissoVO");
        formAgendaCompromisso.setEditButton(editButtonAgenda);
        formAgendaCompromisso.setFunctionId("agendaCompromisso");
        formAgendaCompromisso.setReloadButton(reloadButtonAgenda);
        formAgendaCompromisso.setSaveButton(saveButtonAgenda);
        formAgendaCompromisso.setLayout(new java.awt.GridBagLayout());

        labelControl1.setText("Colaborador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl1, gridBagConstraints);

        codLookupControl2.setAllowOnlyNumbers(true);
        codLookupControl2.setAttributeName("colaborador.id");
        codLookupControl2.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(codLookupControl2, gridBagConstraints);

        textControl2.setAttributeName("pcpOpDetalhe.produto.nome");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 5);
        formAgendaCompromisso.add(textControl2, gridBagConstraints);

        labelControl3.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl3, gridBagConstraints);

        codLookupControl3.setAllowOnlyNumbers(true);
        codLookupControl3.setAttributeName("agendaCategoriaCompromisso.id");
        codLookupControl3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(codLookupControl3, gridBagConstraints);

        textControl3.setAttributeName("agendaCategoriaCompromisso.nome");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(textControl3, gridBagConstraints);

        labelControl5.setLabel("Data Compromisso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl5, gridBagConstraints);

        dateControl4.setAttributeName("dataCompromisso");
        dateControl4.setEnabled(false);
        dateControl4.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(dateControl4, gridBagConstraints);

        labelControl6.setLabel("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl6, gridBagConstraints);

        labelControl7.setText("Duração:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl7, gridBagConstraints);

        numericControl6.setAttributeName("duracao");
        numericControl6.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(numericControl6, gridBagConstraints);

        labelControl8.setLabel("Onde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl8, gridBagConstraints);

        textControl7.setAttributeName("onde");
        textControl7.setEnabled(false);
        textControl7.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(textControl7, gridBagConstraints);

        labelControl9.setText("Nome Produto no PCP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        formAgendaCompromisso.add(labelControl9, gridBagConstraints);

        textControl8.setAttributeName("descricao");
        textControl8.setEnabled(false);
        textControl8.setMaxCharacters(100);
        textControl8.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(textControl8, gridBagConstraints);

        labelControl10.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl10, gridBagConstraints);

        comboBoxControl1.setAttributeName("tipo");
        comboBoxControl1.setDomainId("compromissoTipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(comboBoxControl1, gridBagConstraints);

        formattedTextControl1.setAttributeName("hora");
        formattedTextControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(formattedTextControl1, gridBagConstraints);

        labelControl11.setText("Recorrente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl11, gridBagConstraints);

        comboBoxControl2.setAttributeName("recorrente");
        comboBoxControl2.setDomainId("compromissoRecorrente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(comboBoxControl2, gridBagConstraints);

        labelControl12.setText("Qtde Ocorrência:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl12, gridBagConstraints);

        numericControl1.setAttributeName("quantidadeOcorrencia");
        numericControl1.setEnabled(false);
        numericControl1.setMinValue(1.0);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(numericControl1, gridBagConstraints);

        codLookupControlPcpDetalhe.setAllowOnlyNumbers(true);
        codLookupControlPcpDetalhe.setAttributeName("pcpOpDetalhe.id");
        codLookupControlPcpDetalhe.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formAgendaCompromisso.add(codLookupControlPcpDetalhe, gridBagConstraints);

        labelControl13.setText("Descrição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formAgendaCompromisso.add(labelControl13, gridBagConstraints);

        textControl4.setAttributeName("colaborador.pessoa.nome");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formAgendaCompromisso.add(textControl4, gridBagConstraints);

        textControl5.setAttributeName("pcpOpDetalhe.quantidadeProduzida");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 5);
        formAgendaCompromisso.add(textControl5, gridBagConstraints);

        textControl11.setAttributeName("pcpOpDetalhe.quantidadeProduzir");
        textControl11.setEnabled(false);
        textControl11.setEnabledOnEdit(false);
        textControl11.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 5);
        formAgendaCompromisso.add(textControl11, gridBagConstraints);

        labelControl19.setText("Quantidade à Produzir:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        formAgendaCompromisso.add(labelControl19, gridBagConstraints);

        labelControl20.setText("Quantidade Já Produzida:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        formAgendaCompromisso.add(labelControl20, gridBagConstraints);

        labelControl21.setText("Pedido PCP Produção:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        formAgendaCompromisso.add(labelControl21, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(formAgendaCompromisso, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel3.add(insertButtonConvidados);
        jPanel3.add(deleteButtonConvidados);
        jPanel3.add(reloadButtonConvidados);
        jPanel3.add(saveButtonConvidados);
        jPanel3.add(navigatorBarConvidados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        gridControlColaborador.setAutoLoadData(false);
        gridControlColaborador.setDeleteButton(deleteButtonConvidados);
        gridControlColaborador.setFunctionId("agendaCompromissoConvidado");
        gridControlColaborador.setInsertButton(insertButtonConvidados);
        gridControlColaborador.setNavBar(navigatorBarConvidados);
        gridControlColaborador.setReloadButton(reloadButtonConvidados);
        gridControlColaborador.setSaveButton(saveButtonConvidados);
        gridControlColaborador.setValueObjectClassName("com.bakeryfactory.calendarioproducao.java.AgendaCompromissoConvidadoVO");
        gridControlColaborador.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumn1.setColumnName("colaborador.pessoa.nome");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("Colaborador");
        codLookupColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColumn1.setPreferredWidth(600);
        gridControlColaborador.getColumnContainer().add(codLookupColumn1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControlColaborador, gridBagConstraints);

        jTabbedPane1.addTab("Convidados", jPanel2);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel5.add(editButtonReuniao);
        jPanel5.add(reloadButtonReuniao);
        jPanel5.add(saveButtonReuniao);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        formReuniao.setVOClassName("com.bakeryfactory.calendarioproducao.java.ProducaoSalaEventoVO");
        formReuniao.setEditButton(editButtonReuniao);
        formReuniao.setFunctionId("reuniaoSalaEvento");
        formReuniao.setReloadButton(reloadButtonReuniao);
        formReuniao.setSaveButton(saveButtonReuniao);
        formReuniao.setLayout(new java.awt.GridBagLayout());

        labelControl14.setText("Prédio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formReuniao.add(labelControl14, gridBagConstraints);

        codLookupControl6.setAllowOnlyNumbers(true);
        codLookupControl6.setAttributeName("producaoSala.id");
        codLookupControl6.setEnabled(false);
        codLookupControl6.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formReuniao.add(codLookupControl6, gridBagConstraints);

        textControl6.setAttributeName("producaoSala.andar");
        textControl6.setEnabled(false);
        textControl6.setEnabledOnEdit(false);
        textControl6.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formReuniao.add(textControl6, gridBagConstraints);

        labelControl16.setLabel("Data Reserva:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formReuniao.add(labelControl16, gridBagConstraints);

        dateControl7.setAttributeName("dataReserva");
        dateControl7.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formReuniao.add(dateControl7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        formReuniao.add(jSeparator3, gridBagConstraints);

        textControl9.setAttributeName("producaoSala.numero");
        textControl9.setEnabled(false);
        textControl9.setEnabledOnEdit(false);
        textControl9.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formReuniao.add(textControl9, gridBagConstraints);

        textControl10.setAttributeName("producaoSala.predio");
        textControl10.setEnabled(false);
        textControl10.setEnabledOnEdit(false);
        textControl10.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        formReuniao.add(textControl10, gridBagConstraints);

        labelControl15.setText("Andar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formReuniao.add(labelControl15, gridBagConstraints);

        labelControl17.setText("Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formReuniao.add(labelControl17, gridBagConstraints);

        labelControl18.setText("Sala Produção:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        formReuniao.add(labelControl18, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(formReuniao, gridBagConstraints);

        jTabbedPane1.addTab("Local Produção", jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genericButtonAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genericButtonAgendaActionPerformed
        controller.visualizaAgenda();
    }//GEN-LAST:event_genericButtonAgendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.client.CodLookupControl codLookupControl6;
    private org.openswing.swing.client.CodLookupControl codLookupControlPcpDetalhe;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.client.DateControl dateControl4;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.client.DeleteButton deleteButtonConvidados;
    private org.openswing.swing.client.EditButton editButtonAgenda;
    private org.openswing.swing.client.EditButton editButtonReuniao;
    private org.openswing.swing.form.client.Form formAgendaCompromisso;
    private org.openswing.swing.form.client.Form formReuniao;
    private org.openswing.swing.client.FormattedTextControl formattedTextControl1;
    private org.openswing.swing.client.GenericButton genericButtonAgenda;
    private org.openswing.swing.client.GridControl gridControlColaborador;
    private org.openswing.swing.client.InsertButton insertButtonConvidados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl12;
    private org.openswing.swing.client.LabelControl labelControl13;
    private org.openswing.swing.client.LabelControl labelControl14;
    private org.openswing.swing.client.LabelControl labelControl15;
    private org.openswing.swing.client.LabelControl labelControl16;
    private org.openswing.swing.client.LabelControl labelControl17;
    private org.openswing.swing.client.LabelControl labelControl18;
    private org.openswing.swing.client.LabelControl labelControl19;
    private org.openswing.swing.client.LabelControl labelControl20;
    private org.openswing.swing.client.LabelControl labelControl21;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NavigatorBar navigatorBarConvidados;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl6;
    private org.openswing.swing.client.ReloadButton reloadButtonAgenda;
    private org.openswing.swing.client.ReloadButton reloadButtonConvidados;
    private org.openswing.swing.client.ReloadButton reloadButtonReuniao;
    private org.openswing.swing.client.SaveButton saveButtonAgenda;
    private org.openswing.swing.client.SaveButton saveButtonConvidados;
    private org.openswing.swing.client.SaveButton saveButtonReuniao;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables
}
