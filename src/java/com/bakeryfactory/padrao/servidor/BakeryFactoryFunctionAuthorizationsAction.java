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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.internationalization.java.ResourcesFactory;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.Controller;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.tree.java.OpenSwingTreeNode;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 03/10/2016
 */
public class BakeryFactoryFunctionAuthorizationsAction implements Action {

    /**
     *
     * @return request name
     */
    @Override
    public String getRequestName() {
        return "getFunctionAuthorizations";
    }

    @Override
    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        //Recupera as definições de internacionalização (Objeto Resources)
        ResourcesFactory factory = (ResourcesFactory) context.getAttribute(Controller.RESOURCES_FACTORY);
        String languageId = userSessionPars.getLanguageId();

        /**
         * Deve ser gerado automático de acordo com as definições do Banco de Dados
         */
        DefaultMutableTreeNode root = new OpenSwingTreeNode();
        root.setUserObject("Bakery Factory");
        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction n1 = new ApplicationFunction(factory.getResources(languageId).getResource("Cadastros"), null);

        ApplicationFunction nPessoal = new ApplicationFunction(factory.getResources(languageId).getResource("Pessoal"), null);

        ApplicationFunction n13 = new ApplicationFunction(factory.getResources(languageId).getResource("Pessoa"), null);
        ApplicationFunction n131 = new ApplicationFunction(factory.getResources(languageId).getResource("Estado Civil"), "estadoCivil", null, "getEstadoCivil");
        
        
        
        
        
        
        
        /*
        TO DO FUNCÔES
        */

        n1.add(nPessoal);
        n1.add(n13);

        root.add(n1);

        UsuarioVO usuario = (UsuarioVO) inputPar;

        if (!usuario.getPapel().getAcessoCompleto().equals("S")) {
            for (int i = 0; i < root.getChildCount(); i++) {
                autorizaFuncoes((DefaultMutableTreeNode) root.getChildAt(i), buscaPapelFuncao(usuario));
            }
        }
        return new VOResponse(model);
    }

    private List<String> buscaPapelFuncao(UsuarioVO usuario) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(PapelFuncaoVO.class);
            criteria.add(Restrictions.eq("papel", usuario.getPapel()));

            List<PapelFuncaoVO> listaPapelFuncao = criteria.list();
            List<String> funcoes = new ArrayList<>();
            for (int i = 0; i < listaPapelFuncao.size(); i++) {
                if (listaPapelFuncao.get(i).getPodeAlterar().equals("S")
                        || listaPapelFuncao.get(i).getPodeInserir().equals("S")
                        || listaPapelFuncao.get(i).getPodeExcluir().equals("S")) {
                    funcoes.add(listaPapelFuncao.get(i).getFuncao().getNome());
                } else if (listaPapelFuncao.get(i).getPodeConsultar().equals("S")) {
                    funcoes.add(listaPapelFuncao.get(i).getFuncao().getNome());
                }
            }
            return funcoes;
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
    
    private void autorizaFuncoes(DefaultMutableTreeNode pasta, List<String> funcoes){
        ApplicationFunction funcao;
        for(int i =0; i < pasta.getChildCount(); i++) {
            funcao = (ApplicationFunction) pasta.getChildAt(i);
            if(funcao.isFolder()) {
                for(int j = 0; j<funcao.getChildCount(); j++) {
                    autorizaFuncoes(funcao, funcoes);
                }
            } else {
                if(!funcoes.contains(funcao.getFunctionId())){
                    pasta.remove(i);
                    ApplicationFunction appFunction = new ApplicationFunction(funcao.getDescription() + "*", "funcaoPadrao", null, "getFuncaoPadrao");
                    pasta.insert(appFunction, i);
                }
            }
        }
    } 

}
