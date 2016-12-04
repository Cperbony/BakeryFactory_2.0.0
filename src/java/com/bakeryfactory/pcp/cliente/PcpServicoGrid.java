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
package com.bakeryfactory.pcp.cliente;

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 */
public class PcpServicoGrid extends InternalFrame {

    private PcpServicoColaboradorGridController colaboradorGridController;
    private PcpServicoEquipamentoGridController equipamentoGridController;
    private LookupController colaboradorLookupController;
    private LookupController equipamentoLookupController;

    /**
     * Creates new form TempGrid
     *
     * @param controller
     */
    public PcpServicoGrid(PcpServicoGridController controller) {
        this.colaboradorLookupController = new LookupController();
        this.equipamentoLookupController = new LookupController();
        initComponents();
        gridControlServicos.setController(controller);
        gridControlServicos.setGridDataLocator(controller);

        colaboradorGridController = new PcpServicoColaboradorGridController();
        gridControlColaborador.setController(colaboradorGridController);
        gridControlColaborador.setGridDataLocator(colaboradorGridController);

        equipamentoGridController = new PcpServicoEquipamentoGridController();
        gridControlEquipamentos.setController(equipamentoGridController);
        gridControlEquipamentos.setGridDataLocator(equipamentoGridController);

        setModal(true);
        setSize(800, 600);

        /*
         * Configurações do lookup do colaborador
         */
        colaboradorLookupController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.ColaboradorVO");
        colaboradorLookupController.addLookup2ParentLink("id", "colaborador.id");
        colaboradorLookupController.addLookup2ParentLink("pessoa.nome", "colaborador.pessoa.nome");
        colaboradorLookupController.setHeaderColumnName("id", "ID");
        colaboradorLookupController.setHeaderColumnName("nome", "Nome");
        colaboradorLookupController.setFrameTitle("Importa Colaborador");

        colaboradorLookupController.setVisibleStatusPanel(true);
        colaboradorLookupController.setVisibleColumn("id", true);
        colaboradorLookupController.setVisibleColumn("nome", true);
        colaboradorLookupController.setFramePreferedSize(new Dimension(600, 500));

        colaboradorLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(colaboradorLookupController.getLookupValueObjectClassName()));
        codLookupColaboradores.setLookupController(colaboradorLookupController);

        /*
         * Configurações do lookup do equipamento
         */
        equipamentoLookupController.setLookupValueObjectClassName("com.bakeryfactory.pcp.java.PatrimonioBemVO");
        equipamentoLookupController.addLookup2ParentLink("id", "patrimonioBem.id");
        equipamentoLookupController.addLookup2ParentLink("nome", "patrimonioBem.nome");
        equipamentoLookupController.setHeaderColumnName("id", "ID");
        equipamentoLookupController.setHeaderColumnName("nome", "Nome");
        equipamentoLookupController.setFrameTitle("Importa Equipamento");

        equipamentoLookupController.setVisibleStatusPanel(true);
        equipamentoLookupController.setVisibleColumn("id", true);
        equipamentoLookupController.setVisibleColumn("nome", true);
        equipamentoLookupController.setFramePreferedSize(new Dimension(600, 500));

        equipamentoLookupController.setLookupDataLocator(new LookupDataLocatorGenerico(equipamentoLookupController.getLookupValueObjectClassName()));
        codLookupEquipamentos.setLookupController(equipamentoLookupController);    
    }

    /**
     *
     * @return GRID associada a cada tela
     */
    public GridControl getGrid1() {
        return gridControlServicos;
    }

    public PcpServicoColaboradorGridController getColaboradorGridController() {
        return colaboradorGridController;
    }

    public PcpServicoEquipamentoGridController getEquipamentoGridController() {
        return equipamentoGridController;
    }

    public org.openswing.swing.client.GridControl getGridControlColaborador() {
        return gridControlColaborador;
    }

    public org.openswing.swing.client.GridControl getGridControlEquipamento() {
        return gridControlEquipamentos;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelServicos = new javax.swing.JPanel();
        insertButtonServicos = new org.openswing.swing.client.InsertButton();
        editButtonServicos = new org.openswing.swing.client.EditButton();
        deleteButtonServicos = new org.openswing.swing.client.DeleteButton();
        saveButtonServicos = new org.openswing.swing.client.SaveButton();
        reloadButtonServicos = new org.openswing.swing.client.ReloadButton();
        navigatorBarServicos = new org.openswing.swing.client.NavigatorBar();
        gridControlServicos = new org.openswing.swing.client.GridControl();
        dateColumn9 = new org.openswing.swing.table.columns.client.DateColumn();
        integerColumn11 = new org.openswing.swing.table.columns.client.IntegerColumn();
        dateColumn3 = new org.openswing.swing.table.columns.client.DateColumn();
        integerColumn5 = new org.openswing.swing.table.columns.client.IntegerColumn();
        dateColumn10 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn4 = new org.openswing.swing.table.columns.client.DateColumn();
        decimalColumn14 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        jPanelColaboradores = new javax.swing.JPanel();
        jPanelColaborador = new javax.swing.JPanel();
        insertButtonColaborador = new org.openswing.swing.client.InsertButton();
        editButtonColaborador = new org.openswing.swing.client.EditButton();
        deleteButtonColaborador = new org.openswing.swing.client.DeleteButton();
        reloadButtonColaborador = new org.openswing.swing.client.ReloadButton();
        saveButtonColaborador = new org.openswing.swing.client.SaveButton();
        gridControlColaborador = new org.openswing.swing.client.GridControl();
        codLookupColaboradores = new org.openswing.swing.table.columns.client.CodLookupColumn();
        jPanelEquipamentos = new javax.swing.JPanel();
        jPanelEquipamento = new javax.swing.JPanel();
        insertButtonEquipamento = new org.openswing.swing.client.InsertButton();
        editButtonEquipamento = new org.openswing.swing.client.EditButton();
        deleteButtonEquipamento = new org.openswing.swing.client.DeleteButton();
        reloadButtonEquipamento = new org.openswing.swing.client.ReloadButton();
        saveButtonEquipamento = new org.openswing.swing.client.SaveButton();
        gridControlEquipamentos = new org.openswing.swing.client.GridControl();
        codLookupEquipamentos = new org.openswing.swing.table.columns.client.CodLookupColumn();

        setTitle("Bakery Factory - PCP");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelServicos.setBorder(javax.swing.BorderFactory.createTitledBorder("PCP Serviços"));
        jPanelServicos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelServicos.add(insertButtonServicos);
        jPanelServicos.add(editButtonServicos);
        jPanelServicos.add(deleteButtonServicos);
        jPanelServicos.add(saveButtonServicos);
        jPanelServicos.add(reloadButtonServicos);
        jPanelServicos.add(navigatorBarServicos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelServicos, gridBagConstraints);

        gridControlServicos.setAutoLoadData(false);
        gridControlServicos.setDeleteButton(deleteButtonServicos);
        gridControlServicos.setEditButton(editButtonServicos);
        gridControlServicos.setFunctionId("pcpServico");
        gridControlServicos.setInsertButton(insertButtonServicos);
        gridControlServicos.setNavBar(navigatorBarServicos);
        gridControlServicos.setReloadButton(reloadButtonServicos);
        gridControlServicos.setSaveButton(saveButtonServicos);
        gridControlServicos.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpServicoVO");
        gridControlServicos.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        dateColumn9.setColumnName("inicioPrevisto");
        dateColumn9.setEditableOnEdit(true);
        dateColumn9.setEditableOnInsert(true);
        dateColumn9.setHeaderColumnName("Início Previsto");
        dateColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(dateColumn9);

        integerColumn11.setColumnName("horasPrevisto");
        integerColumn11.setEditableOnEdit(true);
        integerColumn11.setEditableOnInsert(true);
        integerColumn11.setHeaderColumnName("Horas Previsto");
        integerColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(integerColumn11);

        dateColumn3.setColumnName("inicioRealizado");
        dateColumn3.setEditableOnEdit(true);
        dateColumn3.setEditableOnInsert(true);
        dateColumn3.setHeaderColumnName("Início Realizado");
        dateColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(dateColumn3);

        integerColumn5.setColumnName("horasRealizado");
        integerColumn5.setColumnRequired(false);
        integerColumn5.setEditableOnEdit(true);
        integerColumn5.setEditableOnInsert(true);
        integerColumn5.setHeaderColumnName("Horas Realizado");
        integerColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(integerColumn5);

        dateColumn10.setColumnName("terminoPrevisto");
        dateColumn10.setEditableOnEdit(true);
        dateColumn10.setEditableOnInsert(true);
        dateColumn10.setHeaderColumnName("Término Previsto");
        dateColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        dateColumn10.setPreferredWidth(120);
        gridControlServicos.getColumnContainer().add(dateColumn10);

        dateColumn4.setColumnName("terminoRealizado");
        dateColumn4.setColumnRequired(false);
        dateColumn4.setEditableOnEdit(true);
        dateColumn4.setEditableOnInsert(true);
        dateColumn4.setHeaderColumnName("Término Realizado");
        dateColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        dateColumn4.setPreferredWidth(120);
        gridControlServicos.getColumnContainer().add(dateColumn4);

        decimalColumn14.setColumnName("custoPrevisto");
        decimalColumn14.setDecimals(2);
        decimalColumn14.setEditableOnEdit(true);
        decimalColumn14.setEditableOnInsert(true);
        decimalColumn14.setHeaderColumnName("Custo Previsto");
        decimalColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(decimalColumn14);

        decimalColumn8.setColumnName("custoRealizado");
        decimalColumn8.setColumnRequired(false);
        decimalColumn8.setDecimals(2);
        decimalColumn8.setEditableOnEdit(true);
        decimalColumn8.setEditableOnInsert(true);
        decimalColumn8.setHeaderColumnName("Custo Realizado");
        decimalColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlServicos.getColumnContainer().add(decimalColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControlServicos, gridBagConstraints);

        jPanelColaboradores.setBorder(javax.swing.BorderFactory.createTitledBorder("Colaboradores"));
        jPanelColaboradores.setLayout(new java.awt.GridBagLayout());

        jPanelColaborador.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelColaborador.add(insertButtonColaborador);
        jPanelColaborador.add(editButtonColaborador);
        jPanelColaborador.add(deleteButtonColaborador);
        jPanelColaborador.add(reloadButtonColaborador);
        jPanelColaborador.add(saveButtonColaborador);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelColaboradores.add(jPanelColaborador, gridBagConstraints);

        gridControlColaborador.setAutoLoadData(false);
        gridControlColaborador.setDeleteButton(deleteButtonColaborador);
        gridControlColaborador.setEditButton(editButtonColaborador);
        gridControlColaborador.setFunctionId("pcpServicoColaborador");
        gridControlColaborador.setInsertButton(insertButtonColaborador);
        gridControlColaborador.setReloadButton(reloadButtonColaborador);
        gridControlColaborador.setSaveButton(saveButtonColaborador);
        gridControlColaborador.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpServicoColaboradorVO");
        gridControlColaborador.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColaboradores.setColumnName("colaborador.pessoa.nome");
        codLookupColaboradores.setEditableOnEdit(true);
        codLookupColaboradores.setEditableOnInsert(true);
        codLookupColaboradores.setHeaderColumnName("Colaborador");
        codLookupColaboradores.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColaboradores.setPreferredWidth(250);
        gridControlColaborador.getColumnContainer().add(codLookupColaboradores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelColaboradores.add(gridControlColaborador, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanelColaboradores, gridBagConstraints);

        jPanelEquipamentos.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipamentos"));
        jPanelEquipamentos.setLayout(new java.awt.GridBagLayout());

        jPanelEquipamento.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanelEquipamento.add(insertButtonEquipamento);
        jPanelEquipamento.add(editButtonEquipamento);
        jPanelEquipamento.add(deleteButtonEquipamento);
        jPanelEquipamento.add(reloadButtonEquipamento);
        jPanelEquipamento.add(saveButtonEquipamento);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanelEquipamentos.add(jPanelEquipamento, gridBagConstraints);

        gridControlEquipamentos.setAutoLoadData(false);
        gridControlEquipamentos.setDeleteButton(deleteButtonEquipamento);
        gridControlEquipamentos.setEditButton(editButtonEquipamento);
        gridControlEquipamentos.setFunctionId("pcpServicoEquipamento");
        gridControlEquipamentos.setInsertButton(insertButtonEquipamento);
        gridControlEquipamentos.setReloadButton(reloadButtonServicos);
        gridControlEquipamentos.setSaveButton(saveButtonEquipamento);
        gridControlEquipamentos.setValueObjectClassName("com.bakeryfactory.pcp.java.PcpServicoEquipamentoVO");
        gridControlEquipamentos.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupEquipamentos.setColumnName("patrimonioBem.nome");
        codLookupEquipamentos.setEditableOnEdit(true);
        codLookupEquipamentos.setEditableOnInsert(true);
        codLookupEquipamentos.setHeaderColumnName("Equipamento");
        codLookupEquipamentos.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupEquipamentos.setPreferredWidth(250);
        gridControlEquipamentos.getColumnContainer().add(codLookupEquipamentos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelEquipamentos.add(gridControlEquipamentos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanelEquipamentos, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColaboradores;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupEquipamentos;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn10;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn3;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn4;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn9;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn14;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.client.DeleteButton deleteButtonColaborador;
    private org.openswing.swing.client.DeleteButton deleteButtonEquipamento;
    private org.openswing.swing.client.DeleteButton deleteButtonServicos;
    private org.openswing.swing.client.EditButton editButtonColaborador;
    private org.openswing.swing.client.EditButton editButtonEquipamento;
    private org.openswing.swing.client.EditButton editButtonServicos;
    private org.openswing.swing.client.GridControl gridControlColaborador;
    private org.openswing.swing.client.GridControl gridControlEquipamentos;
    private org.openswing.swing.client.GridControl gridControlServicos;
    private org.openswing.swing.client.InsertButton insertButtonColaborador;
    private org.openswing.swing.client.InsertButton insertButtonEquipamento;
    private org.openswing.swing.client.InsertButton insertButtonServicos;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn11;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn5;
    private javax.swing.JPanel jPanelColaborador;
    private javax.swing.JPanel jPanelColaboradores;
    private javax.swing.JPanel jPanelEquipamento;
    private javax.swing.JPanel jPanelEquipamentos;
    private javax.swing.JPanel jPanelServicos;
    private org.openswing.swing.client.NavigatorBar navigatorBarServicos;
    private org.openswing.swing.client.ReloadButton reloadButtonColaborador;
    private org.openswing.swing.client.ReloadButton reloadButtonEquipamento;
    private org.openswing.swing.client.ReloadButton reloadButtonServicos;
    private org.openswing.swing.client.SaveButton saveButtonColaborador;
    private org.openswing.swing.client.SaveButton saveButtonEquipamento;
    private org.openswing.swing.client.SaveButton saveButtonServicos;
    // End of variables declaration//GEN-END:variables
}
