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

import com.bakeryfactory.cadastros.java.EstadoCivilVO;
import com.bakeryfactory.padrao.java.Constantes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 05/10/2016
 */
public class EstadoCivilGridController extends GridController implements GridDataLocator {

    private EstadoCivilGrid grid;
    private String acaoServidor;

    public EstadoCivilGridController() {
        grid = new EstadoCivilGrid(this);
        acaoServidor = "estadoCivilGridAction";
        MDIFrame.add(grid);
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //Define os parâmetros da Grid
        otherGridParams.put("acao", Constantes.LOAD);
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    /**
     * Callback method invoked on pressing INSERT button.
     *
     * @param grid
     * @return <code>true</code> allows to go to INSERT mode, <code>false</code> the mode change is interrupted
     */
    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        new EstadoCivilDetalheController(this.grid, null);
        return false;
    }

    /**
     * Callback method invoked when the user has double clicked on the selected row of the grid.
     *
     * @param rowNumber selected row index
     * @param persistentObject v.o. related to the selected row
     */
    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        EstadoCivilVO estadoCivil = (EstadoCivilVO) persistentObject;
        new EstadoCivilDetalheController(grid, estadoCivil.getId().toString());
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
        Map otherGridParams = new HashMap();
        otherGridParams.put("acao", Constantes.DELETE);
        otherGridParams.put("persistentObjects", persistentObjects);

        //Seta os parâmetros da Gris
        GridParams pars = new GridParams(0, 0, null, null, null, otherGridParams);

        return ClientUtils.getData(acaoServidor, pars);
    }

}
