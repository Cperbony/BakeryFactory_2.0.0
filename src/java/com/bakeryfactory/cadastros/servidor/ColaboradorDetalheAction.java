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
package com.bakeryfactory.cadastros.servidor;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
import com.bakeryfactory.padrao.java.Constantes;
import com.bakeryfactory.padrao.servidor.HibernateUtil;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 08/10/2016
 */
public class ColaboradorDetalheAction implements Action {

    @Override
    public String getRequestName() {
        return "colaboradorDetalheAction";
    }

    @Override
    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Object[] pars = (Object[]) inputPar;
        Integer acao = (Integer) pars[0];

        switch (acao) {
            case Constantes.LOAD: {
                return load(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.INSERT: {
                return insert(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.UPDATE: {
                return update(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.DELETE: {
                return delete(inputPar, userSessionPars, request, response, userSession, context);
            }
        }
        return null;
    }

    private Response load(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        String pk = (String) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ColaboradorVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            ColaboradorVO colaborador = (ColaboradorVO) criteria.uniqueResult();

            return new VOResponse(colaborador);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }

    }

    private Response insert(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            ColaboradorVO colaborador = (ColaboradorVO) pars[1];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(ColaboradorVO.class);
            criteria.add(Restrictions.eq("pessoa", colaborador.getPessoa()));

            if (criteria.uniqueResult() != null) {
                throw new Exception("Já existe um Colaborador vinculado à pessoa selecionada.");
            }
            if (colaborador.getContabilConta().getId() == null) {
                colaborador.setContabilConta(null);
            }

            if (colaborador.getSindicato().getId() == null) {
                colaborador.setSindicato(null);
            }

            if (colaborador.getTipoAdmissao().getId() == null) {
                colaborador.setTipoAdmissao(null);
            }
            session.save(colaborador);

            session.getTransaction().commit();

            return new VOResponse(colaborador);

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    private Response update(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            ColaboradorVO colaborador = (ColaboradorVO) pars[2];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(ColaboradorVO.class);
            criteria.add(Restrictions.eq("pessoa", colaborador.getPessoa()));
            criteria.add(Restrictions.ne("id", colaborador.getId()));

            if (criteria.uniqueResult() != null) {
                throw new Exception("Já existe um Colaborador vinculado à pessoa selecionada.");
            }

            if (colaborador.getContabilConta().getId() == null) {
                colaborador.setContabilConta(null);
            }

            if (colaborador.getSindicato().getId() == null) {
                colaborador.setSindicato(null);
            }

            if (colaborador.getTipoAdmissao().getId() == null) {
                colaborador.setTipoAdmissao(null);
            }

            session.update(colaborador);

            session.getTransaction().commit();

            return new VOResponse(colaborador);

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    private Response delete(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        return null;
    }
}
