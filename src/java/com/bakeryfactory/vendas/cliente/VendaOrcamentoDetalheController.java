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
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/10/2016
 */
public class VendaOrcamentoDetalheController extends FormController {

    private VendaOrcamentoDetalhe vendaOrcamentoDetalhe = null;
    private String pk = null;
    private VendaOrcamentoGrid vendaOrcamentoGrid = null;
    private String acaoServidor;

    public VendaOrcamentoDetalheController(VendaOrcamentoGrid vendaOrcamentoGrid, String pk) {
        this.vendaOrcamentoGrid = vendaOrcamentoGrid;
        this.pk = pk;
        this.acaoServidor = "vendaOrcamentoDetalheAction";
        vendaOrcamentoDetalhe = new VendaOrcamentoDetalhe(this);
        vendaOrcamentoDetalhe.setParentFrame(this.vendaOrcamentoGrid);
        this.vendaOrcamentoGrid.pushFrame(vendaOrcamentoDetalhe);
        MDIFrame.add(vendaOrcamentoDetalhe, true);

        try {
            vendaOrcamentoDetalhe.setMaximum(true);
        } catch (PropertyVetoException ex) {
        }

        if (pk != null) {
            vendaOrcamentoDetalhe.getForm1().setMode(Consts.READONLY);
            vendaOrcamentoDetalhe.getForm1().reload();
        } else {
            vendaOrcamentoDetalhe.getForm1().setMode(Consts.INSERT);
            vendaOrcamentoDetalhe.getGridControl1().reloadData();
        }
    }

    /**
     * This method must be overridden by the subclass to retrieve data and return the valorized value object. If the method is not overridden, the current version will return a "demo" value object.
     *
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or an ErrorResponse object if an error occours
     */
    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    /**
     * Callback method invoked when the data loading is completed.
     *
     * @param error <code>true</code> if data loading has terminated with errors, <code>false</code> otherwise
     */
    @Override
    public void loadDataCompleted(boolean error) {
        vendaOrcamentoDetalhe.getGridController().setPk(pk);
        vendaOrcamentoDetalhe.getGridControl1().reloadData();
    }

    /**
     * Callback method invoked on pressing INSERT button to check if insert mode is allowed.
     *
     * @param form
     * @return <code>true</code> allows to go to INSERT mode, <code>false</code> the mode change is interrupted
     */
    @Override
    public boolean beforeInsertData(Form form) {
        atualizaTotais();
        return true;
    }

    /**
     * Method called by the Form panel to insert new data.
     *
     * @param newPersistentObject
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        List<VendaOrcamentoDetalheVO> orcamentoDetalhe = vendaOrcamentoDetalhe.getGridControl1().getVOListTableModel().getDataVector();

        if (orcamentoDetalhe.isEmpty()) {
            return new ErrorResponse("Não há produtos no Orçamento.");
        }
        ((VendaOrcamentoCabecalhoVO) newPersistentObject).setSituacao("D");

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, orcamentoDetalhe});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in INSERT mode.
     */
    @Override
    public void afterInsertData() {
        vendaOrcamentoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(vendaOrcamentoDetalhe, "Dados Salvos com Sucesso!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Callback method invoked on pressing EDIT button to check if edit mode is allowed.
     *
     * @param form
     * @return <code>true</code> allows to go to EDIT mode, <code>false</code> the mode change is interrupted
     */
    @Override
    public boolean beforeEditData(Form form) {
        atualizaTotais();
        return true;
    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        String situacao = ((VendaOrcamentoCabecalhoVO) persistentObject).getSituacao();
        if (!situacao.equals("D")) {
            String mensagem = "Este Registro não Pode Ser Alterado.\n";

            if (situacao.equals("P")) {
                mensagem += "Situação: EM PRODUÇÃO";
            }

            if (situacao.equals("X")) {
                mensagem += "Situação: EM EXPEDIÇÃO";
            }

            if (situacao.equals("F")) {
                mensagem += "Situação: EM FATUTADO";
            }

            if (situacao.equals("E")) {
                mensagem += "Situação: ENTREGUE";
            }

            return new ErrorResponse(mensagem);
        }
        List<VendaOrcamentoCabecalhoVO> orcamentoDetalhe = vendaOrcamentoDetalhe.getGridControl1().getVOListTableModel().getDataVector();

        if (orcamentoDetalhe.isEmpty()) {
            return new ErrorResponse("Não produtos no Orçamento");
        }
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, orcamentoDetalhe});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in EDIT mode.
     */
    @Override
    public void afterEditData() {
        vendaOrcamentoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(vendaOrcamentoDetalhe, "Dados Alterados Com Sucesso", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public void atualizaTotais() {
        VendaOrcamentoCabecalhoVO orcamentoCabecalho = (VendaOrcamentoCabecalhoVO) vendaOrcamentoDetalhe.getForm1().getVOModel().getValueObject();
        BigDecimal valorDesconto = orcamentoCabecalho.getValorSubtotal().multiply(orcamentoCabecalho.getTaxaDesconto().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN));
        if (orcamentoCabecalho.getValorSubtotal() != null) {
            if (orcamentoCabecalho.getTaxaDesconto() != null) {
                orcamentoCabecalho.setValorDesconto(valorDesconto);
                orcamentoCabecalho.setValorTotal(orcamentoCabecalho.getValorSubtotal().subtract(orcamentoCabecalho.getValorDesconto()));
            }
            if (orcamentoCabecalho.getValorFrete() != null) {
                if (orcamentoCabecalho.getValorTotal() == null) {
                    orcamentoCabecalho.setValorTotal(orcamentoCabecalho.getValorSubtotal());
                }
                orcamentoCabecalho.setValorTotal(orcamentoCabecalho.getValorTotal().add(orcamentoCabecalho.getValorFrete()));
            }
        }
        vendaOrcamentoDetalhe.getForm1().pull();
    }
}
