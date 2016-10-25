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
import com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO;
import com.bakeryfactory.vendas.java.VendaOrcamentoDetalheVO;
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
public class VendaOrcamentoDetalheGridController extends GridController implements GridDataLocator {

    private VendaOrcamentoDetalhe vendaOrcamentoDetalhe;
    private final String acaoServidor;
    private String pk;

    public VendaOrcamentoDetalheGridController(VendaOrcamentoDetalhe vendaOrcamentoDetalhe) {
        acaoServidor = "vendaOrcamentoDetalheGridAction";
        this.vendaOrcamentoDetalhe = vendaOrcamentoDetalhe;
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //Define os Parâmetros da Grid
        otherGridParams.put("acao", Constantes.LOAD);
        otherGridParams.put("idVendaOrcamentoCabecalho", pk);
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        formMode();
        return true;
    }

    /**
     * Method invoked when the user has clicked on save button and the vendaOrcamentoDetalhe is in INSERT mode.
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
        formMode();
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
        formMode();
        return true;
    }

    /**
     * Method invoked when the user has clicked on delete button and the vendaOrcamentoDetalhe is in READONLY mode.
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

    private void calculaTotais() {
        List<VendaOrcamentoDetalheVO> orcamentoDetalhe = vendaOrcamentoDetalhe.getGridControl1().getVOListTableModel().getDataVector();
        VendaOrcamentoCabecalhoVO orcamentoCabecalho = (VendaOrcamentoCabecalhoVO) vendaOrcamentoDetalhe.getForm1().getVOModel().getValueObject();
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal totalDesconto = BigDecimal.ZERO;
        for (int i = 0; i < orcamentoDetalhe.size(); i++) {
            orcamentoDetalhe.get(i).setValorSubtotal(orcamentoDetalhe.get(i).getQuantidade().multiply(orcamentoDetalhe.get(i).getValorUnitario()));
            subTotal = subTotal.add(orcamentoDetalhe.get(i).getValorSubtotal());

            if (orcamentoDetalhe.get(i).getTaxaDesconto() != null) {
                orcamentoDetalhe.get(i).setValorDesconto(orcamentoDetalhe.get(i).getValorSubtotal().multiply(orcamentoDetalhe.get(i).getTaxaDesconto().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN)));
            }

            if (orcamentoDetalhe.get(i).getValorDesconto() != null) {
                totalDesconto = totalDesconto.add(orcamentoDetalhe.get(i).getValorDesconto());
                orcamentoDetalhe.get(i).setValorTotal(orcamentoDetalhe.get(i).getValorSubtotal().subtract(orcamentoDetalhe.get(i).getValorDesconto()));
            } else {
                orcamentoDetalhe.get(i).setValorTotal(orcamentoDetalhe.get(i).getValorSubtotal());
            }
        }
        orcamentoCabecalho.setValorSubtotal(subTotal);
        setValorDesconto(totalDesconto, orcamentoCabecalho, subTotal);
        orcamentoCabecalho.setValorTotal(subTotal);
        addValorFrete(orcamentoCabecalho);
        subtractDesconto(orcamentoCabecalho);
        setValorComissao(orcamentoCabecalho, subTotal, totalDesconto);
        vendaOrcamentoDetalhe.getFormController().atualizaTotais();
    }

    public void setValorDesconto(BigDecimal totalDesconto, VendaOrcamentoCabecalhoVO orcamentoCabecalho, BigDecimal subTotal) {
        if (totalDesconto.compareTo(BigDecimal.ZERO) != 0) {
            orcamentoCabecalho.setValorDesconto(totalDesconto);
            orcamentoCabecalho.setTaxaDesconto(totalDesconto.divide(subTotal, RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(100)));
        }
    }

    public void setValorComissao(VendaOrcamentoCabecalhoVO orcamentoCabecalho, BigDecimal subTotal, BigDecimal totalDesconto) {
        if (orcamentoCabecalho.getTaxaComissao() != null) {
            orcamentoCabecalho.setValorComissao(subTotal.subtract(totalDesconto).multiply(orcamentoCabecalho.getTaxaComissao().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN)));
        }
    }

    public void addValorFrete(VendaOrcamentoCabecalhoVO orcamentoCabecalho) {
        if (orcamentoCabecalho.getValorFrete() != null) {
            orcamentoCabecalho.setValorTotal(orcamentoCabecalho.getValorTotal().add(orcamentoCabecalho.getValorFrete()));
        }
    }

    public void subtractDesconto(VendaOrcamentoCabecalhoVO orcamentoCabecalho) {
        if (orcamentoCabecalho.getValorDesconto() != null) {
            orcamentoCabecalho.setValorTotal((orcamentoCabecalho.getValorTotal().subtract(orcamentoCabecalho.getValorDesconto())));
        }
    }

    public void formMode() {
        if (vendaOrcamentoDetalhe.getForm1().getMode() == Consts.READONLY) {
            vendaOrcamentoDetalhe.getForm1().setMode(Consts.EDIT);
        }
    }
}
