/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.padrao.java.Constantes;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/01/2017
 */
public class ProducaoSalaDetalheController extends FormController {

    private ProducaoSalaDetalhe producaoSalaDetalhe = null;
    private String pk = null;
    private ProducaoSalaGrid producaoSalaGrid = null;
    private String acaoServidor;

    public ProducaoSalaDetalheController(ProducaoSalaGrid producaoSalaGrid, String pk) {
        this.producaoSalaGrid = producaoSalaGrid;
        this.pk = pk;
        this.acaoServidor = "reuniaoSalaDetalheAction";
        producaoSalaDetalhe = new ProducaoSalaDetalhe(this);
        producaoSalaDetalhe.setParentFrame(this.producaoSalaGrid);
        this.producaoSalaGrid.pushFrame(producaoSalaDetalhe);
        MDIFrame.add(producaoSalaDetalhe);

        if (pk != null) {
            producaoSalaDetalhe.getForm1().setMode(Consts.READONLY);
            producaoSalaDetalhe.getForm1().reload();
        } else {
            producaoSalaDetalhe.getForm1().setMode(Consts.INSERT);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject});
    }

    @Override
    public void afterInsertData() {
        producaoSalaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(producaoSalaDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject});
    }

    @Override
    public void afterEditData() {
        producaoSalaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(producaoSalaDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
