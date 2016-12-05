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

import com.bakeryfactory.padrao.java.Constantes;
import com.bakeryfactory.vendas.java.VendaCabecalhoVO;
import com.bakeryfactory.vendas.java.VendaDetalheVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
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
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 13/10/2016
 */
public class VendaDetalheGridController extends GridController implements GridDataLocator {

    private VendaDetalhe vendaDetalhe;
    private final String acaoServidor;
    private String pk;

    public VendaDetalheGridController(VendaDetalhe vendaDetalhe) {
        this.vendaDetalhe = vendaDetalhe;
        acaoServidor = "vendaDetalheGridAction";
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //Define os Parâmetros da Grid
        otherGridParams.put("acao", Constantes.LOAD);
        otherGridParams.put("idVendaCabecalho", pk);

        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        if (vendaDetalhe.getForm1().getMode() == Consts.READONLY) {
            vendaDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on save button and the vendaDetalhe is in INSERT mode.
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
     * Callback method invoked after saving data when the grid was in INSERT mode (on pressing save button). The method is called ONLY if the operation is successfully completed.
     *
     * @param grid
     */
    @Override
    public void afterInsertGrid(GridControl grid) {
        calculaTotais();
    }

    /**
     * Callback method invoked on pressing EDIT button.
     *
     * @param grid
     * @return <code>true</code> allows to go to EDIT mode, <code>false</code> the mode change is interrupted
     */
    @Override
    public boolean beforeEditGrid(GridControl grid) {
        if (vendaDetalhe.getForm1().getMode() == Consts.READONLY) {
            vendaDetalhe.getForm1().setMode(Consts.EDIT);
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
     * @throws java.lang.Exception
     */
    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    /**
     * Callback method invoked after saving data when the grid was in EDIT mode (on pressing save button). The method is called ONLY if the operation is successfully completed.
     *
     * @param grid
     */
    @Override
    public void afterEditGrid(GridControl grid) {
        calculaTotais();
    }

    /**
     * Callback method invoked before deleting data when the grid was in READONLY mode (on pressing delete button).
     *
     * @param grid
     * @return <code>true</code> allows the deleting to continue, <code>false</code> the deleting is interrupted
     */
    @Override
    public boolean beforeDeleteGrid(GridControl grid) {
        if (vendaDetalhe.getForm1().getMode() == Consts.READONLY) {
            vendaDetalhe.getForm1().setMode(Consts.EDIT);
        }
        return true;
    }

    /**
     * Method invoked when the user has clicked on delete button and the vendaDetalhe is in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    /**
     * Callback method invoked after deleting data when the grid was in READONLY mode (on pressing delete button). The method is called ONLY if the operation is successfully completed.
     */
    @Override
    public void afterDeleteGrid() {
        calculaTotais();
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public void calculaTotais() {
        List<VendaDetalheVO> itensVenda = vendaDetalhe.getGrid1().getVOListTableModel().getDataVector();
        VendaCabecalhoVO vendaCabecalho = (VendaCabecalhoVO) vendaDetalhe.getForm1().getVOModel().getValueObject();
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal totalDesconto = BigDecimal.ZERO;
        for (int i = 0; i < itensVenda.size(); i++) {
            itensVenda.get(i).setValorSubtotal(itensVenda.get(i).getQuantidade().multiply(itensVenda.get(i).getValorUnitario()));
            subTotal = subTotal.add(itensVenda.get(i).getValorSubtotal());
            if (itensVenda.get(i).getTaxaDesconto() != null) {
                itensVenda.get(i).setValorDesconto(itensVenda.get(i).getValorSubtotal().multiply(itensVenda.get(i).getTaxaDesconto().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN)));
            }
            if (itensVenda.get(i).getValorDesconto() != null) {
                totalDesconto = totalDesconto.add(itensVenda.get(i).getValorDesconto());
                itensVenda.get(i).setValorTotal(itensVenda.get(i).getValorSubtotal().subtract(itensVenda.get(i).getValorDesconto()));
            } else {
                itensVenda.get(i).setValorTotal(itensVenda.get(i).getValorSubtotal());
            }
        }
        vendaCabecalho.setValorSubtotal(subTotal);
        if (totalDesconto.compareTo(BigDecimal.ZERO) != 0) {
            vendaCabecalho.setValorDesconto(totalDesconto);
            vendaCabecalho.setTaxaDesconto(totalDesconto.divide(subTotal, RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(100)));
        }

        vendaCabecalho.setValorTotal(subTotal);
        if (vendaCabecalho.getValorFrete() != null) {
            vendaCabecalho.setValorTotal(vendaCabecalho.getValorTotal().add(vendaCabecalho.getValorFrete()));
        }
        if (vendaCabecalho.getValorDesconto() != null) {
            vendaCabecalho.setValorTotal(vendaCabecalho.getValorTotal().subtract(vendaCabecalho.getValorDesconto()));
        }

        if (vendaCabecalho.getTaxaComissao() != null) {
            vendaCabecalho.setValorComissao(subTotal.subtract(totalDesconto).multiply(vendaCabecalho.getTaxaComissao().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN)));
        }
        vendaDetalhe.getFormController().atualizaTotais();
    }
}
