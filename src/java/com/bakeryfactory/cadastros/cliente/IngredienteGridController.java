/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.cadastros.cliente;

import com.bakeryfactory.cadastros.java.IngredienteVO;
import com.bakeryfactory.padrao.java.Constantes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 23/11/2016
 */
public class IngredienteGridController extends GridController implements GridDataLocator {

    private final IngredienteGrid grid;
    private final String acaoServidor;

    public IngredienteGridController() {
        grid = new IngredienteGrid(this);
        acaoServidor = "ingredienteGridAction";
        MDIFrame.add(grid);
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //Define os Parâmetros da Grid
        otherGridParams.put("acao", Constantes.LOAD);
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        new IngredienteDetalheController(this.grid, null);
        return false;
    }

    /**
     * Method invoked when the user has clicked on save button and the grid is in INSERT mode.
     *
     * @param rowNumbers row indexes related to the new rows to save
     * @param newValueObjects list of new value objects to save
     * @return an ErrorResponse value object in case of errors, VOListResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    /**
     * Callback method invoked when the user has double clicked on the selected row of the grid.
     *
     * @param rowNumber selected row index
     * @param persistentObject v.o. related to the selected row
     */
    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        IngredienteVO ingrediente = (IngredienteVO) persistentObject;
        new IngredienteDetalheController(grid, ingrediente.getId().toString());
    }

    /**
     * Method invoked when the user has clicked on delete button and the grid is in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        //Define os Parâmetros da Grid
        Map otherGridParams = new HashMap();
        otherGridParams.put("acao", Constantes.DELETE);
        otherGridParams.put("persistentObjects", persistentObjects);

        //Seta os Parâmetros da Grid
        GridParams pars = new GridParams(0, 0, null, null, null, otherGridParams);

        return ClientUtils.getData(acaoServidor, pars);
    }
}
