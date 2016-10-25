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
package com.bakeryfactory.vendas.cliente;

import temp.com.bakeryfactory.cliente.*;
import com.bakeryfactory.cadastros.java.ColaboradorVO;
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
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 13/10/2016
 */
public class VendaCondicoesParcelasGridController extends GridController implements GridDataLocator {

    private VendaCondicoesPagamentoDetalhe vendaCondicoesPagamentoDetalhe;
    private final String acaoServidor;
    private String pk;

    public VendaCondicoesParcelasGridController(VendaCondicoesPagamentoDetalhe vendaCondicoesPagamentoDetalhe) {
        acaoServidor = "vendaCondicoesParcelasGridAction";
        this.vendaCondicoesPagamentoDetalhe = vendaCondicoesPagamentoDetalhe;
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //Define os Parâmetros da Grid
        otherGridParams.put("acao", Constantes.LOAD);
        otherGridParams.put("idVendaCondicaoPagamento", pk);
        
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        return setFormMode();
    }

    @Override
    public boolean beforeEditGrid(GridControl grid) {
        return setFormMode();
    }

    public boolean setFormMode() {
        if (vendaCondicoesPagamentoDetalhe.getForm1().getMode() == Consts.READONLY) {
            vendaCondicoesPagamentoDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on save button and the vendaCondicoesPagamentoDetalhe is in INSERT mode.
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

    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    /**
     * Method invoked when the user has clicked on delete button and the vendaCondicoesPagamentoDetalhe is in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

}
