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
 * @date   15/01/2017
 */
public class AgendaCategoriaCompromissoDetalheController extends FormController {

     private AgendaCategoriaCompromissoDetalhe agendaCategoriaCompromissoDetalhe = null;
    private String pk = null;
    private AgendaCategoriaCompromissoGrid agendaCategoriaCompromissoGrid = null;
    private String acaoServidor;
    
    public AgendaCategoriaCompromissoDetalheController(AgendaCategoriaCompromissoGrid agendaCategoriaCompromissoGrid, String pk) {
        this.agendaCategoriaCompromissoGrid = agendaCategoriaCompromissoGrid;
        this.pk = pk;
        this.acaoServidor = "agendaCategoriaCompromissoDetalheAction";
        agendaCategoriaCompromissoDetalhe = new AgendaCategoriaCompromissoDetalhe(this);
        agendaCategoriaCompromissoDetalhe.setParentFrame(this.agendaCategoriaCompromissoGrid);
        this.agendaCategoriaCompromissoGrid.pushFrame(agendaCategoriaCompromissoDetalhe);
        MDIFrame.add(agendaCategoriaCompromissoDetalhe);

        if (pk != null) {
            agendaCategoriaCompromissoDetalhe.getForm1().setMode(Consts.READONLY);
            agendaCategoriaCompromissoDetalhe.getForm1().reload();
        } else {
            agendaCategoriaCompromissoDetalhe.getForm1().setMode(Consts.INSERT);
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
        agendaCategoriaCompromissoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(agendaCategoriaCompromissoDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject});
    }

    @Override
    public void afterEditData() {
        agendaCategoriaCompromissoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(agendaCategoriaCompromissoDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
