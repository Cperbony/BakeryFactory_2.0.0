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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Claudinei Aparecido Perboni <cperbony@gmail.com>
 */
public class ImportaDadosAction implements Action{
    
       public String getRequestName() {
       return "importaDados";
    }


    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        GridParams pars = (GridParams) inputPar;
        
        String nomeClasse = (String) pars.getOtherGridParams().get("nomeClasse");
        
        String baseSQL = "select REGISTRO from " + nomeClasse + " as REGISTRO";
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getBlockFromQuery(
                    pars.getAction(), //int action, 
                    pars.getStartPos(), //int startIndex, 
                    50, //block Size
                    pars.getFilteredColumns(), //MapFilteredColumn
                    pars.getCurrentSortedColumns(), //ArrayList CurrentSortedColums
                    pars.getCurrentSortedVersusColumns(),//ArrayList CurrentedSortedColums
                    Class.forName(nomeClasse),
                    baseSQL, // String baseSQL,     
                    new Object[0],//Object[] paramValues,
                    new Type[0], //Type[] paramTypes,
                    "REGISTRO", // tString tableName,
                    HibernateUtil.getSessionFactory(),//SessionFactory sessions,
                    session); //Session session -> throws Exception
            
            return res;
                    
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage());
        }finally {
            try {
                session.close();
            }catch (Exception ex){
            }
        }
    }


    
}
