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

        //CADASTROS 
        ApplicationFunction n1 = new ApplicationFunction(factory.getResources(languageId).getResource("CADASTROS"), null);

        ApplicationFunction nPessoal = new ApplicationFunction(factory.getResources(languageId).getResource("Pessoal"), null);

        ApplicationFunction n13 = new ApplicationFunction(factory.getResources(languageId).getResource("Pessoa"), null);
        ApplicationFunction n131 = new ApplicationFunction(factory.getResources(languageId).getResource("Estado Civil"), "estadoCivil", null, "getEstadoCivil");
        ApplicationFunction n132 = new ApplicationFunction(factory.getResources(languageId).getResource("Pessoa"), "pessoa", null, "getPessoa");

        ApplicationFunction n14 = new ApplicationFunction(factory.getResources(languageId).getResource("Cliente | Fornecedor | Transportadora"), null);
        ApplicationFunction n141 = new ApplicationFunction(factory.getResources(languageId).getResource("Atividade"), "atividadeForCli", null, "getAtividadeForCli");
        ApplicationFunction n142 = new ApplicationFunction(factory.getResources(languageId).getResource("Situação"), "situacaoForCli", null, "getSituacaoForCli");
        ApplicationFunction n143 = new ApplicationFunction(factory.getResources(languageId).getResource("Cliente"), "cliente", null, "getCliente");
        ApplicationFunction n144 = new ApplicationFunction(factory.getResources(languageId).getResource("Fornecedor"), "fornecedor", null, "getFornecedor");
        ApplicationFunction n145 = new ApplicationFunction(factory.getResources(languageId).getResource("Transportadora"), "transportadora", null, "getTransportadora");

        ApplicationFunction n15 = new ApplicationFunction(factory.getResources(languageId).getResource("Colaborador"), null);
        ApplicationFunction n151 = new ApplicationFunction(factory.getResources(languageId).getResource("Tipo Admissão"), "tipoAdmissao", null, "getTipoAdmissao");
        ApplicationFunction n152 = new ApplicationFunction(factory.getResources(languageId).getResource("Tipo Relacionamento"), "tipoRelacionamento", null, "getTipoRelacionamento");
        ApplicationFunction n153 = new ApplicationFunction(factory.getResources(languageId).getResource("Situação"), "situaçãoColaborador", null, "getSituacaoColaborador");
        ApplicationFunction n154 = new ApplicationFunction(factory.getResources(languageId).getResource("Tipo"), "tipoColaborador", null, "getTipoColaborador");
        ApplicationFunction n155 = new ApplicationFunction(factory.getResources(languageId).getResource("Cargo"), "tipoCargo", null, "getCargo");
        ApplicationFunction n156 = new ApplicationFunction(factory.getResources(languageId).getResource("Nível Formação"), "nivelFormacao", null, "getNivelFormacao");
        ApplicationFunction n157 = new ApplicationFunction(factory.getResources(languageId).getResource("Colaborador"), "colaborador", null, "getColaborador");

        ApplicationFunction n16 = new ApplicationFunction(factory.getResources(languageId).getResource("Outros"), null);
        ApplicationFunction n161 = new ApplicationFunction(factory.getResources(languageId).getResource("Sindicato"), "sindicato", null, "getSindicato");

        ApplicationFunction n17 = new ApplicationFunction(factory.getResources(languageId).getResource("Diversos"), null);
        ApplicationFunction n171 = new ApplicationFunction(factory.getResources(languageId).getResource("Setor"), "setor", null, "getSetor");
        ApplicationFunction n172 = new ApplicationFunction(factory.getResources(languageId).getResource("Almoxarifado"), "almoxarifado", null, "getAlmoxarifado");

        ApplicationFunction n18 = new ApplicationFunction(factory.getResources(languageId).getResource("Endereço"), null);
        ApplicationFunction n181 = new ApplicationFunction(factory.getResources(languageId).getResource("País"), "pais", null, "getPais");
        ApplicationFunction n182 = new ApplicationFunction(factory.getResources(languageId).getResource("Estado"), "uf", null, "getUf");
        ApplicationFunction n183 = new ApplicationFunction(factory.getResources(languageId).getResource("Município"), "municipio", null, "getMunicipio");
        ApplicationFunction n184 = new ApplicationFunction(factory.getResources(languageId).getResource("CEP"), "cep", null, "getCep");

        ApplicationFunction n11 = new ApplicationFunction(factory.getResources(languageId).getResource("Produto"), null);
        ApplicationFunction n111 = new ApplicationFunction(factory.getResources(languageId).getResource("Marca"), "produtoMarca", null, "getProdutoMarca");
        ApplicationFunction n112 = new ApplicationFunction(factory.getResources(languageId).getResource("NCM"), "ncm", null, "getNcm");
        ApplicationFunction n113 = new ApplicationFunction(factory.getResources(languageId).getResource("Unidade"), "unidadeProduto", null, "getUnidadeProduto");
        ApplicationFunction n114 = new ApplicationFunction(factory.getResources(languageId).getResource("Grupo"), "produtoGrupo", null, "getProdutoGrupo");
        ApplicationFunction n115 = new ApplicationFunction(factory.getResources(languageId).getResource("Subgrupo"), "produtoSubGrupo", null, "getProdutoSubGrupo");
        ApplicationFunction n116 = new ApplicationFunction(factory.getResources(languageId).getResource("Produto"), "produto", null, "getProduto");

        ApplicationFunction n01 = new ApplicationFunction(factory.getResources(languageId).getResource("Ingrediente"), null);
        ApplicationFunction n011 = new ApplicationFunction(factory.getResources(languageId).getResource("Ingrediente"), "ingrediente", null, "getIngrediente");
        ApplicationFunction n012 = new ApplicationFunction(factory.getResources(languageId).getResource("Receita"), "receita", null, "getReceita");
        ApplicationFunction n013 = new ApplicationFunction(factory.getResources(languageId).getResource("Modo de Preparo"), "modoPreparo", null, "getModoPreparo");

        n1.add(nPessoal);
        n1.add(n17);
        n1.add(n18);
        n1.add(n01);
        n1.add(n11);

        n01.add(n011);
        n01.add(n012);
        n01.add(n013);
        
        n11.add(n111);
        n11.add(n112);
        n11.add(n113);
        n11.add(n114);
        n11.add(n115);
        n11.add(n116);
        
       
        nPessoal.add(n13);
        nPessoal.add(n14);
        nPessoal.add(n15);
        nPessoal.add(n16);

        n13.add(n131);
        n13.add(n132);

        n14.add(n141);
        n14.add(n142);
        n14.add(n143);
        n14.add(n144);
        n14.add(n145);

        n15.add(n151);
        n15.add(n152);
        n15.add(n153);
        n15.add(n154);
        n15.add(n155);
        n15.add(n156);
        n15.add(n157);

        n16.add(n161);

        n17.add(n171);
        n17.add(n172);

        n18.add(n181);
        n18.add(n182);
        n18.add(n183);
        n18.add(n184);

        //PCP
        ApplicationFunction n2 = new ApplicationFunction(factory.getResources(languageId).getResource("PCP"), null);
        ApplicationFunction n21 = new ApplicationFunction(factory.getResources(languageId).getResource("Grupo"), "produtoGrupo", null, "getProdutoGrupo");
        ApplicationFunction n22 = new ApplicationFunction(factory.getResources(languageId).getResource("SubGrupo"), "produtoSubGrupo", null, "getProdutoSubGrupo");
        ApplicationFunction n23 = new ApplicationFunction(factory.getResources(languageId).getResource("Unidade"), "unidadeProduto", null, "getUnidadeProduto");
        ApplicationFunction n24 = new ApplicationFunction(factory.getResources(languageId).getResource("Produto"), "produto", null, "getProduto");
        ApplicationFunction n25 = new ApplicationFunction(factory.getResources(languageId).getResource("Instrução"), "pcpInstrucao", null, "getPcpInstrucao");
        ApplicationFunction n26 = new ApplicationFunction(factory.getResources(languageId).getResource("Ordem de Produção"), "pcpOrdemProducao", null, "getPcpOrdemProducao");

        n2.add(n21);
        n2.add(n22);
        n2.add(n23);
        n2.add(n24);
        n2.add(n25);
        n2.add(n26);

        //VENDAS
        ApplicationFunction n3 = new ApplicationFunction(factory.getResources(languageId).getResource("VENDAS"), null);
        ApplicationFunction n31 = new ApplicationFunction(factory.getResources(languageId).getResource("Tipo Nota Fiscal"), "tipoNotaFiscal", null, "getTipoNotaFiscal");
        ApplicationFunction n32 = new ApplicationFunction(factory.getResources(languageId).getResource("Condições de Pagamento"), "vendaCondicoesPagamento", null, "getVendaCondicoesPagamento");
        ApplicationFunction n33 = new ApplicationFunction(factory.getResources(languageId).getResource("Orçamento"), "vendaOrcamento", null, "getVendaOrcamento");
        ApplicationFunction n34 = new ApplicationFunction(factory.getResources(languageId).getResource("Venda"), "venda", null, "getVenda");
        ApplicationFunction n35 = new ApplicationFunction(factory.getResources(languageId).getResource("Frete"), "vendaFrete", null, "getVendaFrete");
        ApplicationFunction n36 = new ApplicationFunction(factory.getResources(languageId).getResource("Romaneio Entrega"), "vendaRomaneioEntrega", null, "getVendaRomaneioEntrega");

        n3.add(n31);
        n3.add(n32);
        n3.add(n33);
        n3.add(n34);
        n3.add(n35);
        n3.add(n36);

        // Adiciona à Árvore de Menus
        root.add(n1);
        root.add(n2);
        root.add(n3);

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

    private void autorizaFuncoes(DefaultMutableTreeNode pasta, List<String> funcoes) {
        ApplicationFunction funcao;
        for (int i = 0; i < pasta.getChildCount(); i++) {
            funcao = (ApplicationFunction) pasta.getChildAt(i);
            if (funcao.isFolder()) {
                for (int j = 0; j < funcao.getChildCount(); j++) {
                    autorizaFuncoes(funcao, funcoes);
                }
            } else if (!funcoes.contains(funcao.getFunctionId())) {
                pasta.remove(i);
                ApplicationFunction appFunction = new ApplicationFunction(funcao.getDescription() + "*", "funcaoPadrao", null, "getFuncaoPadrao");
                pasta.insert(appFunction, i);
            }
        }
    }
}