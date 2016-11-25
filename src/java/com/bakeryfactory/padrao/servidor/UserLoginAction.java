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

import com.bakeryfactory.cadastros.java.UsuarioVO;
import java.util.HashSet;
import java.util.Hashtable;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.TextResponse;
import org.openswing.swing.server.*;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 04/10/2016
 */
public class UserLoginAction extends LoginAction {

    public UserLoginAction() {
    }

    /**
     *
     * @param inputPar
     * @param userSessionPars
     * @param request
     * @param response
     * @param userSession
     * @param context
     * @return Login Operation
     */
    @Override
    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            String username = ((String[]) inputPar)[0];
            String password = ((String[]) inputPar)[1];
            session = HibernateUtil.getSessionFactory().openSession();

            String baseSql = "from USUARIO in class com.bakeryfactory.cadastros.java.UsuarioVO where USUARIO.login='" + username + "' and USUARIO.senha='" + password + "'";
            UsuarioVO vo = (UsuarioVO) session.createQuery(baseSql).uniqueResult();

            String languageId = null;
            if (vo != null) {

                languageId = "PT_BR";//vo.getIdioma();
                TextResponse tr = new TextResponse(languageId);
                SessionIdGenerator gen = (SessionIdGenerator) context.getAttribute(Controller.SESSION_ID_GENERATOR);
                tr.setSessionId(gen.getSessionId(request, response, userSession, context));

                Hashtable userSessions = (Hashtable) context.getAttribute(Controller.USER_SESSIONS);
                HashSet authenticatedIds = (HashSet) context.getAttribute(Controller.SESSION_IDS);
                if (userSessionPars != null) {
                    userSessions.remove(userSessionPars.getSessionId());
                    authenticatedIds.remove(userSessionPars.getSessionId());
                }
                userSessionPars = new UserSessionParameters();
                userSessionPars.setSessionId(tr.getSessionId());
                userSessionPars.setUsername(username);
                userSessions.put(tr.getSessionId(), userSessionPars);
                userSessionPars.setLanguageId(languageId);

                authenticatedIds.add(tr.getSessionId());

                return tr;
            } else {
                return new ErrorResponse("Usuário inválido.");
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
            return new ErrorResponse(ex1.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex) {
            }
        }
    }
}
