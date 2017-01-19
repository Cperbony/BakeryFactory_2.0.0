/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.calendarioproducao.java.AgendaCompromissoVO;
import com.bakeryfactory.calendarioproducao.java.ProducaoSalaEventoVO;
import com.bakeryfactory.padrao.java.Constantes;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */
public class AgendaCompromissoDetalheController extends FormController {
    
 private AgendaCompromissoDetalhe agendaCompromissoDetalhe = null;
    private String pk = null;
    private AgendaCompromissoGrid agendaCompromissoGrid = null;
    private String acaoServidor;

    public AgendaCompromissoDetalheController(AgendaCompromissoGrid agendaCompromissoGrid, String pk) {
        this.agendaCompromissoGrid = agendaCompromissoGrid;
        this.pk = pk;
        this.acaoServidor = "agendaCompromissoDetalheAction";
        agendaCompromissoDetalhe = new AgendaCompromissoDetalhe(this);
        agendaCompromissoDetalhe.setParentFrame(this.agendaCompromissoGrid);
        this.agendaCompromissoGrid.pushFrame(agendaCompromissoDetalhe);
        MDIFrame.add(agendaCompromissoDetalhe, true);

        if (pk != null) {
            agendaCompromissoDetalhe.getForm1().setMode(Consts.READONLY);
            agendaCompromissoDetalhe.getFormReuniao().setMode(Consts.READONLY);
            agendaCompromissoDetalhe.getForm1().reload();
        } else {
            agendaCompromissoDetalhe.getForm1().setMode(Consts.INSERT);
            agendaCompromissoDetalhe.getGridControl1().reloadData();
            agendaCompromissoDetalhe.getFormReuniao().setMode(Consts.READONLY);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        AgendaCompromissoVO compromisso = (AgendaCompromissoVO) agendaCompromissoDetalhe.getForm1().getVOModel().getValueObject();
        agendaCompromissoDetalhe.getGridConvidadoController().setConvidados(compromisso.getListaAgendaCompromissoConvidado());
        agendaCompromissoDetalhe.getGridControl1().reloadData();
        
        agendaCompromissoDetalhe.getProducaoSalaEventoController().setCompromisso(compromisso);
        agendaCompromissoDetalhe.getFormReuniao().reload();
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        ((AgendaCompromissoVO) newPersistentObject).setListaAgendaCompromissoConvidado(agendaCompromissoDetalhe.getGridConvidadoController().getConvidados());
        
        ProducaoSalaEventoVO producaoSalaEvento = (ProducaoSalaEventoVO) agendaCompromissoDetalhe.getFormReuniao().getVOModel().getValueObject();

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, producaoSalaEvento});
    }

    @Override
    public void afterInsertData() {
        agendaCompromissoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(agendaCompromissoDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        ((AgendaCompromissoVO) persistentObject).setListaAgendaCompromissoConvidado(agendaCompromissoDetalhe.getGridConvidadoController().getConvidados());

        ProducaoSalaEventoVO producaoSalaEvento = (ProducaoSalaEventoVO) agendaCompromissoDetalhe.getFormReuniao().getVOModel().getValueObject();
        
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, producaoSalaEvento});
    }

    @Override
    public void afterEditData() {
        agendaCompromissoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(agendaCompromissoDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public void visualizaAgenda() {
        try {
            AgendaCompromissoVO compromisso = (AgendaCompromissoVO) agendaCompromissoDetalhe.getForm1().getVOModel().getValueObject();

            Response res = ClientUtils.getData(acaoServidor, new Object[]{99, compromisso});
            if (res.isError()) {
                throw new Exception(res.getErrorMessage());
            }

            List<AgendaCompromissoVO> listaCompromisso = ((VOListResponse) res).getRows();

            Calendar dataCompromisso = Calendar.getInstance();
            dataCompromisso.setTime(compromisso.getDataCompromisso());

            new AgendaCalendarioGridController(dataCompromisso, listaCompromisso);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(agendaCompromissoDetalhe, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
