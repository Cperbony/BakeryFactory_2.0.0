/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni <cperbony@gmail.com>.
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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 *
 * @author Claudinei Aparecido Perboni <cperbony@gmail.com>
 */
public class BakeryFactoryContainerAction implements Action{

    public BakeryFactoryContainerAction() {
    }
    
   /*
    Retorna um RequestName
    */
    public String getRequestName() {
        return "containerAction";
    }
    
     public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
         Session session = null;
         try {
             String username = ((String[]) inputPar)[0];
             String password = ((String[]) inputPar)[1];
             session = HibernateUtil.getSessionFactory().openSession();
             
             String baseSQL = "from USUARIO in com.bakeryfactory.cadastros.java.UsuarioVO where USUARIO.login'" + username + " ' and USUARIO.senha='" + password + "'";
             UsuarioVO vo = (UsuarioVO) session.createQuery(baseSQL).uniqueResult();
             
             VOResponse voResponse = new VOResponse(vo);
             return voResponse;
         } catch (Exception e) {
         }
    }
    
    
}
