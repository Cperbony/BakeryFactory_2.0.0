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
package com.bakeryfactory.pcp.cliente;

import com.bakeryfactory.pcp.java.PcpOpDetalheVO;
import com.bakeryfactory.pcp.java.PcpServicoColaboradorVO;
import com.bakeryfactory.pcp.java.PcpServicoVO;
import java.util.ArrayList;
import java.util.Map;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 13/10/2016
 */
public class PcpServicoColaboradorGridController extends GridController implements GridDataLocator {

    private PcpServicoVO servico;
    private PcpServicoColaboradorVO servicoColaborador;
    private PcpOpDetalheVO opDetalhe;

    public PcpServicoColaboradorGridController(PcpOpDetalheVO opDetalhe) {
        this.servicoColaborador = new PcpServicoColaboradorVO();
        this.servico = new PcpServicoVO();
        
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        //checa se existe um serviço ?> busca a Lista de Colaboradores para carregar na grid.
        if (servico != null) {
            if (servico.getListaPcpServicoColaborador() != null) {
                return new VOListResponse(servico.getListaPcpServicoColaborador(), false, servico.getListaPcpServicoColaborador().size());
            }
        }
        return new VOListResponse();
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
        if (opDetalhe != null) {
            if (opDetalhe.getListaPcpServico() != null) {
                for (int i = 0; i < newValueObjects.size(); i++) {
                    opDetalhe.getListaPcpServico().add((PcpServicoVO) (newValueObjects.get(i)));
                }
            }
        }
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
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
       if (opDetalhe != null) {
            if (opDetalhe.getListaPcpServico()!= null) {
                for (int i = 0; i < oldPersistentObjects.size(); i++) {
                    opDetalhe.getListaPcpServico().remove((PcpServicoVO) oldPersistentObjects.get(i));
                }
                for (int i = 0; i < persistentObjects.size(); i++) {
                    opDetalhe.getListaPcpServico().add((PcpServicoVO) persistentObjects.get(i));
                }
            }
        }
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        if (opDetalhe != null) {
            if (opDetalhe.getListaPcpServico() != null) {
                for (int i = 0; i < persistentObjects.size(); i++) {
                    opDetalhe.getListaPcpServico().remove((PcpServicoVO) persistentObjects.get(i));
                }
            }
        }
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    public void setServico(PcpServicoVO servico) {
        this.servico = servico;
    }

}
