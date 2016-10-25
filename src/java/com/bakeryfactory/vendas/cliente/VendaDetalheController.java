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
import com.bakeryfactory.vendas.java.VendaOrcamentoDetalheVO;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/10/2016
 */
public class VendaDetalheController extends FormController {

    private VendaDetalhe vendaDetalhe = null;
    private String pk = null;
    private VendaGrid vendaGrid = null;
    private String acaoServidor;

    public VendaDetalheController(VendaGrid vendaGrid, String pk) {
        this.vendaGrid = vendaGrid;
        this.pk = pk;
        this.acaoServidor = "vendaDetalheAction";
        vendaDetalhe = new VendaDetalhe(this);
        vendaDetalhe.setParentFrame(this.vendaGrid);
        this.vendaGrid.pushFrame(vendaDetalhe);
        MDIFrame.add(vendaDetalhe, true);

        try {
            vendaDetalhe.setMaximum(true);
        } catch (PropertyVetoException ex) {
        }

        if (pk != null) {
            vendaDetalhe.getForm1().setMode(Consts.READONLY);
            vendaDetalhe.getForm1().reload();
        } else {
            vendaDetalhe.getForm1().setMode(Consts.INSERT);
            vendaDetalhe.getGrid1().reloadData();
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
     * Callback method called when the data loading is completed.
     *
     * @param error <code>true</code> if an error occours during data loading, <code>false</code> if data loading is successfully completed
     */
    @Override
    public void loadDataCompleted(boolean error) {
        vendaDetalhe.getItensController().setPk(pk);
        vendaDetalhe.getGrid1().reloadData();
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
        List<VendaDetalheVO> itensVenda = vendaDetalhe.getGrid1().getVOListTableModel().getDataVector();

        if (itensVenda.isEmpty()) {
            return new ErrorResponse("Não produtos listados na venda.");
        }

        ((VendaCabecalhoVO) newPersistentObject).setSituacao("D");

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, itensVenda});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in INSERT mode.
     */
    @Override
    public void afterInsertData() {
        vendaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(vendaDetalhe, "Dados Salvos com Sucesso!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
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
        String situacao = ((VendaCabecalhoVO) persistentObject).getSituacao();
        
        if (!situacao.equals("D")) {
            String mensagem = "Este Registro Não Pode Ser Alterado.\n";
            
            if (situacao.equals("P")) {
                mensagem += "Situação: EM PRODUÇÂO";
            }
            
            if (situacao.equals("X")) {
                mensagem += "Situação: EM EXPEDIÇÃO";
            }
            
            if (situacao.equals("F")) {
                mensagem += "Situação: FATURADO";
            }
            
            if (situacao.equals("E")) {
                mensagem += "Situação: ENTREGUE";
            }
            
            return new ErrorResponse(mensagem);
        }
        List<VendaDetalheVO> itensVenda = vendaDetalhe.getGrid1().getVOListTableModel().getDataVector();

        if (itensVenda.isEmpty()) {
            return new ErrorResponse("Não Produtos no Orçamento.");
        }
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, itensVenda});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in EDIT mode.
     */
    @Override
    public void afterEditData() {
        vendaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(vendaDetalhe, "Dados Alterados Com Sucesso", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Callback method invoked each time an input control is edited: this method define if the new value if valid. Default behaviour: input control value is valid.
     *
     * @param attributeName attribute name related to the input control currently edited
     * @param oldValue old input control value (before editing)
     * @param newValue new input control value (just edited)
     * @return <code>true</code> if input control value is valid, <code>false</code> otherwise
     */
    @Override
    public boolean validateControl(String attributeName, Object oldValue, Object newValue) {
        if (attributeName.equals("vendaOrcamentoCabecalho.id")) {
            carregaItensOrcamento((String.valueOf(newValue)));
        }
        return super.validateControl(attributeName, oldValue, newValue);
    }

    public void atualizaTotais() {
        VendaCabecalhoVO vendaCabecalho = (VendaCabecalhoVO) vendaDetalhe.getForm1().getVOModel().getValueObject();
        if (vendaCabecalho.getValorSubtotal() != null) {
            if (vendaCabecalho.getTaxaDesconto() != null) {
                addValorDesconto(vendaCabecalho);
                addValorTotal(vendaCabecalho);
            }
            if (vendaCabecalho.getValorFrete() != null) {
                if (vendaCabecalho.getValorTotal() == null) {
                    vendaCabecalho.setValorTotal(vendaCabecalho.getValorSubtotal());
                }
                addValorFrete(vendaCabecalho);
            }
        }
        vendaDetalhe.getForm1().pull();
    }

    public void addValorFrete(VendaCabecalhoVO vendaCabecalho) {
        vendaCabecalho.setValorTotal(vendaCabecalho.getValorTotal().add(vendaCabecalho.getValorFrete()));
    }

    public void addValorTotal(VendaCabecalhoVO vendaCabecalho) {
        vendaCabecalho.setValorTotal(vendaCabecalho.getValorTotal().subtract(vendaCabecalho.getValorDesconto()));
    }

    public void addValorDesconto(VendaCabecalhoVO vendaCabecalho) {
        vendaCabecalho.setValorDesconto(vendaCabecalho.getValorSubtotal().multiply(vendaCabecalho.getTaxaDesconto().divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN)));
    }

    private void carregaItensOrcamento(String idOrcamento) {
        try {
            Map otherGridParams = new HashMap();
            otherGridParams.put("acao", Constantes.LOAD);
            otherGridParams.put("idVendaOrcamentoCabecalho", idOrcamento);

            GridParams pars = new GridParams();
            pars.setOtherGridParams(otherGridParams);

            Response res = ClientUtils.getData("vendaOrcamentoDetalheGridAction", pars);
            if (res.isError()) {
                throw new Exception(res.getErrorMessage());
            }

            List<VendaOrcamentoDetalheVO> orcamentoDetalhe = ((VOListResponse) res).getRows();
            VendaDetalheVO itemVenda;
            vendaDetalhe.getGrid1().clearData();

            for (int i = 0; i < orcamentoDetalhe.size(); i++) {
                itemVenda = new VendaDetalheVO();
                itemVenda.setProduto(orcamentoDetalhe.get(i).getProduto());
                itemVenda.setQuantidade(orcamentoDetalhe.get(i).getQuantidade());
                itemVenda.setTaxaDesconto(orcamentoDetalhe.get(i).getTaxaDesconto());
                itemVenda.setValorDesconto(orcamentoDetalhe.get(i).getValorDesconto());
                itemVenda.setValorSubtotal(orcamentoDetalhe.get(i).getValorSubtotal());
                itemVenda.setValorTotal(orcamentoDetalhe.get(i).getValorTotal());
                itemVenda.setValorUnitario(orcamentoDetalhe.get(i).getValorUnitario());

                vendaDetalhe.getGrid1().getVOListTableModel().addObject(itemVenda);
            }
            vendaDetalhe.getItensController().calculaTotais();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vendaDetalhe, "Erro ao Carregar os Itens do Orçamento\n" + e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }

}
