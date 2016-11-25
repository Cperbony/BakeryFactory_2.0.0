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
package com.bakeryfactory.padrao.servidor;

import com.bakeryfactory.cadastros.java.PapelFuncaoVO;
import com.bakeryfactory.cadastros.java.UsuarioVO;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.permissions.java.ButtonsAuthorizations;
import org.openswing.swing.server.*;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 03/10/2016
 */
public class BakeryFactoryButtonAuthorizationsAction implements Action {

    public BakeryFactoryButtonAuthorizationsAction() {
    }

    /**
     *
     * @return Request Name
     */
    @Override
    public String getRequestName() {
        return "getButtonAuthorizations";
    }

    /**
     *
     * @param inputPar
     * @param userSessionPars
     * @param request
     * @param response
     * @param userSession
     * @param context
     * @return Business logic to execute
     */
    @Override
    public final Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            UsuarioVO usuario = (UsuarioVO) inputPar;
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(PapelFuncaoVO.class);
            criteria.add(Restrictions.eq("papel", usuario.getPapel()));

            List<PapelFuncaoVO> listaPapelFuncao = criteria.list();
            ButtonsAuthorizations ba = new ButtonsAuthorizations();

            if (!usuario.getPapel().getAcessoCompleto().equals("S")) {
                for (int i = 0; i < listaPapelFuncao.size(); i++) {
                    ba.addButtonAuthorization(listaPapelFuncao.get(i).getFuncao().getNome(),
                            listaPapelFuncao.get(i).getPodeInserir().equals("S"),
                            listaPapelFuncao.get(i).getPodeAlterar().equals("S"),
                            listaPapelFuncao.get(i).getPodeExcluir().equals("S"));
                }
            }

            return new VOResponse(ba);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }
}
