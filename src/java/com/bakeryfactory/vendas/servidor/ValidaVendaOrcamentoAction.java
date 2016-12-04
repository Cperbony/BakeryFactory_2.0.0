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
package com.bakeryfactory.vendas.servidor;

import com.bakeryfactory.padrao.servidor.HibernateUtil;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.message.send.java.LookupValidationParams;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.util.server.HibernateUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 07/10/2016
 */
public class ValidaVendaOrcamentoAction implements Action {

    public ValidaVendaOrcamentoAction() {
    }

    @Override
    public String getRequestName() {
        return "validaVendaOrcamento";
    }

    @Override
    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            String id = ((LookupValidationParams) inputPar).getCode();
            GridParams pars = new GridParams();
            String baseSQL = "select ORCAMENTO_CABECALHO from com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO as ORCAMENTO_CABECALHO where VENDA_ORCAMENTO_CABECALHO.situacao = 'D' and VENDA_ORCAMENTO_CABECALHO.id = " + id;

            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getAllFromQuery(
                    pars.getFilteredColumns(),
                    pars.getCurrentSortedColumns(),
                    pars.getCurrentSortedVersusColumns(),
                    com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "VENDA_ORCAMENTO_CABECALHO",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception ex) {
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }
}
