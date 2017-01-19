/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
import com.bakeryfactory.padrao.java.Constantes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/01/2017
 */
public class AniversarianteGridController extends GridController implements GridDataLocator {

    private String acaoServidor;

    public AniversarianteGridController() {
        try {
            acaoServidor = "colaboradorGridAction";

            //define os parametros da grid
            Map otherGridParams = new HashMap();
            otherGridParams.put("acao", Constantes.LOAD);
            GridParams pars = new GridParams(0, 0, null, null, null, otherGridParams);

            Response res = ClientUtils.getData(acaoServidor, pars);
            if (res.isError()) {
                throw new Exception(res.getErrorMessage());
            }

            List<ColaboradorVO> listaColaborador = ((VOListResponse) res).getRows();

            new AgendaCalendarioGridController(listaColaborador);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //define os parametros da grid
        otherGridParams.put("acao", Constantes.LOAD);
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

}
