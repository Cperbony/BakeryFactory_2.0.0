/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni <cperbony@gmail.com>.
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

import com.bakeryfactory.padrao.java.Constantes;
import java.util.ArrayList;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Claudinei Aparecido Perboni <cperbony@gmail.com>
 */
class PessoaContatoGridController extends GridController implements GridDataLocator {

    private final PessoaDetalhe pessoaDetalhe;
    private final String acaoServidor;
    private String pk;

    public PessoaContatoGridController(PessoaDetalhe pessoaDetalhe) {
        acaoServidor = "pessoaContatoGridAction";
        this.pessoaDetalhe = pessoaDetalhe;
        
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        if (pk == null) {
            return new VOListResponse();
        } else {
            //define os parâmetros da GRID Openswing
            otherGridParams.put("acao", Constantes.LOAD);
            otherGridParams.put("idPessoa", pk);

            return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
        }
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        if (pessoaDetalhe.getForm1().getMode() == Consts.READONLY) {
            pessoaDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on save button and the grid is in INSERT mode.
     *
     * @param rowNumbers row indexes related to the new rows to save
     * @param newValueObjects list of new value objects to save
     * @return an ErrorResponse value object in case of errors, VOListResponse if the operation is successfully completed
     */
    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    /**
     * Callback method invoked on pressing EDIT button.
     *
     * @return <code>true</code> allows to go to EDIT mode, <code>false</code> the mode change is interrupted
     */
    @Override
    public boolean beforeEditGrid(GridControl grid) {
        if(pessoaDetalhe.getForm1().getMode() == Consts.READONLY){
            pessoaDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on save button and the grid is in EDIT mode.
     *
     * @param rowNumbers row indexes related to the changed/new rows
     * @param oldPersistentObjects old value objects, previous the changes; it can contains null objects, in case of new inserted rows
     * @param persistentObjects value objects related to the changed/new rows
     * @return an ErrorResponse value object in case of errors, VOListResponse if the operation is successfully completed
     */
    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    /**
     * Callback method invoked before deleting data when the grid was in READONLY mode (on pressing delete button).
     *
     * @return <code>true</code> allows the deleting to continue, <code>false</code> the deleting is interrupted
     */
    @Override
    public boolean beforeDeleteGrid(GridControl grid) {
         if(pessoaDetalhe.getForm1().getMode() == Consts.READONLY){
            pessoaDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on delete button and the grid is in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    public void setPk(String pk) {
        this.pk = pk;
    }
}
