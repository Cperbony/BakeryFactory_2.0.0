/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.calendarioproducao.java.AgendaCompromissoVO;
import com.bakeryfactory.padrao.java.Constantes;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/01/2017
 */
public class ProducaoSalaEventoDetalheController extends FormController {

    private AgendaCompromissoVO compromisso = null;
    private String acaoServidor;

    public ProducaoSalaEventoDetalheController() {
        this.acaoServidor = "reuniaoSalaEventoDetalheAction";
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        if (compromisso != null) {
            return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, compromisso});
        } else {
            return new VOResponse();
        }
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return new VOResponse(newPersistentObject);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return new VOResponse(persistentObject);
    }

    public void setCompromisso(AgendaCompromissoVO compromisso) {
        this.compromisso = compromisso;
    }

}
