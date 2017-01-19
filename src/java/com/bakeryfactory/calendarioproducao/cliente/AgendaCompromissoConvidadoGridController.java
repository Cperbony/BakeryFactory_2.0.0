/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.calendarioproducao.java.AgendaCompromissoConvidadoVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */
public class AgendaCompromissoConvidadoGridController extends GridController implements GridDataLocator {

    private String acaoServidor;
    private List<AgendaCompromissoConvidadoVO> convidados;
    private AgendaCompromissoDetalhe detalhe;

    public AgendaCompromissoConvidadoGridController(AgendaCompromissoDetalhe detalhe) {
        acaoServidor = "agendaCompromissoConvidadoGridAction";
        this.detalhe = detalhe;
        convidados = new ArrayList<>();
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        return new VOListResponse(convidados, false, convidados.size());
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        edicaoForm();
        return true;
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        convidados.addAll(newValueObjects);
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    @Override
    public boolean beforeDeleteGrid(GridControl grid) {
        edicaoForm();
        return true;
    }
    
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        convidados.removeAll(persistentObjects);
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }
    
    private void edicaoForm() {
        if (detalhe.getForm1().getMode() == Consts.READONLY) {
            detalhe.getForm1().setMode(Consts.EDIT);
        }
    }

    public List<AgendaCompromissoConvidadoVO> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<AgendaCompromissoConvidadoVO> convidados) {
        if (convidados != null) {
            this.convidados = convidados;
        }
    }
}
