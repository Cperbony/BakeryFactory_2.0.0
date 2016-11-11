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
package com.bakeryfactory.padrao.cliente;

import com.bakeryfactory.cadastros.java.UsuarioVO;
import com.bakeryfactory.padrao.java.Biblioteca;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.internationalization.java.Language;
import org.openswing.swing.internationalization.java.XMLResourcesFactory;
import org.openswing.swing.mdi.client.ClientFacade;
import org.openswing.swing.mdi.client.Clock;
import org.openswing.swing.mdi.client.GenericStatusPanel;
import org.openswing.swing.mdi.client.MDIController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.TextResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.permissions.client.LoginController;
import org.openswing.swing.permissions.client.LoginDialog;
import org.openswing.swing.permissions.java.ButtonsAuthorizations;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.client.HessianObjectSender;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 11/09/2016
 */
public class Menu implements MDIController, LoginController {

    private Fachada fachadaCliente = null;
    private Hashtable domains = new Hashtable();
    private String nomeUsuario = null;

    public Menu() {
        ClientUtils.setObjectSender(new HessianObjectSender());
        fachadaCliente = new Fachada();
        System.setProperty("SERVERURL", System.getProperty("jnlp.SERVERURL"));
        LoginDialog d = new LoginDialog(null, false, this);
    }

    /**
     *
     * @return clientFacade, invoked by the MDI Frame tree/menu
     */
    public ClientFacade getClientFacade() {
        return (ClientFacade) fachadaCliente;
    }

    /**
     * Method used to destroy application.
     */
    
    public void stopApplication() {
        ClientUtils.getData("closeApplication", Boolean.TRUE);
        System.exit(0);
    }

    /**
     * Defines if application functions must be viewed inside a tree panel of MDI Frame.
     *
     * @return <code>true</code> if application functions must be viewed inside a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
    
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI Frame.
     *
     * @return <code>true</code> if application functions must be viewed in the menubar of MDI Frame, <code>false</code> otherwise
     */
    
    public boolean viewFunctionsInMenuBar() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the menubar, <code>false</code> no login menu item will be added
     */
    
    public boolean viewLoginInMenuBar() {
        return true;
    }

    /**
     * @return application title
     */
    
    public String getMDIFrameTitle() {
        return "Bakery Factory - Controle de Produção de Panificadora";
    }

    
    public String getAboutText() {
        return "Aplicação: Bakery Factory\n"
                + "\n"
                + "The MIT License\n"
                + "Copyright: Copyright (C) 2016 claudineiperboni.com\n"
                + "\n"
                + "Permission is hereby granted, free of charge, to any person\n"
                + "obtaining a copy of this software and associated documentation\n"
                + "files (the 'Software'), to deal in the Software without\n"
                + "restriction, including without limitation the rights to use,\n"
                + "copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
                + "copies of the Software, and to permit persons to whom the\n"
                + "Software is furnished to do so, subject to the following\n"
                + "conditions:\n"
                + "\n"
                + "The above copyright notice and this permission notice shall be\n"
                + "included in all copies or substantial portions of the Software.\n"
                + "\n"
                + "THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,\n"
                + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES\n"
                + "OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n"
                + "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT\n"
                + "HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\n"
                + "WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\n"
                + "FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR\n"
                + "OTHER DEALINGS IN THE SOFTWARE.\n";
    }

    /**
     * @return image name to view in the about dialog window
     */
    
    public String getAboutImage() {
        return "about.jpg";
    }

    /**
     * @param parentFrame parent frame
     * @return a dialog window to logon the application; the method can return null if viewLoginInMenuBar returns false
     */
    
    public JDialog viewLoginDialog(JFrame parentFrame) {
        JDialog d = new LoginDialog(parentFrame, true, this);
        return d;
    }

    /**
     * @return maximum number of failed login
     */
    
    public int getMaxAttempts() {
        return 3;
    }

    /**
     * Method called by MDI Frame to authenticate the user.
     *
     * @param loginInfo login information, like nomeUsuario, password, ...
     * @return <code>true</code> if user is correcly authenticated, <code>false</code> otherwise
     * @throws java.lang.Exception
     */

    public boolean authenticateUser(Map loginInfo) throws Exception {
        nomeUsuario = (String) loginInfo.get("username");
        String password = (String) loginInfo.get("password");

        if (nomeUsuario == null || password == null) {
            return false;
        }
        nomeUsuario = nomeUsuario.toLowerCase();
        password = Biblioteca.MD5String(nomeUsuario + password);

        loginInfo.put("username", nomeUsuario);
        loginInfo.put("password", password);

        Response response = ClientUtils.getData("login", new String[]{nomeUsuario, password});
        
        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }

        String languageId = ((TextResponse) response).getMessage();

        response = ClientUtils.getData("containerAction", new String[]{nomeUsuario, password});
        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }

        UsuarioVO usuario = (UsuarioVO) ((VOResponse) response).getVo();
        Container.setContainer(usuario);

        response = ClientUtils.getData("getButtonAuthorizations", usuario);
        
        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }
        ButtonsAuthorizations buttonsAuthorizations = (ButtonsAuthorizations) ((VOResponse) response).getVo();

        Hashtable xmlFiles = new Hashtable();
        xmlFiles.put("EN", "Resources_en.xml");
        xmlFiles.put("IT", "Resources_it.xml");
        xmlFiles.put("ES", "Resources_es.xml");
        xmlFiles.put("PT_BR", "Resources_ptBR.xml");

        ClientSettings clientSettings = new ClientSettings(new XMLResourcesFactory(xmlFiles, true),
                domains, buttonsAuthorizations, false);

        ClientSettings.PERC_TREE_FOLDER = "folder3.gif";
        ClientSettings.BACKGROUND = "background4.jpg";
        ClientSettings.TREE_BACK = "treeback2.jpg";
        ClientSettings.FILTER_PANEL_ON_GRID = true;
        ClientSettings.LOOK_AND_FEEL_CLASS_NAME = "com.birosoft.Liquid.LiquidLookAndFeel";
        com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true);
        ClientSettings.MAX_NR_OF_LOOPS_IN_ANALYZE_VO = 3;

        ClientSettings.getInstance().setLanguage(languageId);

        return true;
    }

    /**
     * Method called after MDI creation.
     *
     * @param frame
     */
    
    public void afterMDIcreation(MDIFrame frame) {
        GenericStatusPanel userPanel = new GenericStatusPanel();
        userPanel.setColumns(12);
        MDIFrame.addStatusComponent(userPanel);
        userPanel.setText(nomeUsuario);
        MDIFrame.addStatusComponent(new Clock());
    }

    /**
     * @return @see JFrame getExtendedState method
     */
    
    public int getExtendedState() {
        return JFrame.MAXIMIZED_BOTH;
    }

    
    public void loginSuccessful(Map loginInfo) {
        //Domain tipo de pessoa, que aperecerá nos combos da aplicação
        //PESSOA E CORRELATOS
        Domain tipoPessoa = new Domain("tipoPessoa");
        tipoPessoa.addDomainPair("F", "Física");
        tipoPessoa.addDomainPair("J", "Jurídica");

        Domain tipoSangue = new Domain("tipoSangue");
        tipoSangue.addDomainPair("A+", "A+");
        tipoSangue.addDomainPair("B+", "B+");
        tipoSangue.addDomainPair("O+", "O+");
        tipoSangue.addDomainPair("AB+", "AB+");
        tipoSangue.addDomainPair("A-", "A-");
        tipoSangue.addDomainPair("B-", "B-");
        tipoSangue.addDomainPair("AB-", "AB-");
        tipoSangue.addDomainPair("O-", "O-");

        Domain dominioSexo = new Domain("sexo");
        dominioSexo.addDomainPair("M", "Masculino");
        dominioSexo.addDomainPair("F", "Feminino");

        Domain dominioRacaCor = new Domain("racaCor");
        dominioRacaCor.addDomainPair("B", "Branco");
        dominioRacaCor.addDomainPair("N", "Negro");
        dominioRacaCor.addDomainPair("P", "Pardo");
        dominioRacaCor.addDomainPair("I", "Indio");

        Domain dominioSimNao = new Domain("simnao");
        dominioSimNao.addDomainPair("S", "Sim");
        dominioSimNao.addDomainPair("N", "Não");

        Domain dominioNaoSim = new Domain("naosim");
        dominioNaoSim.addDomainPair("N", "Não");
        dominioNaoSim.addDomainPair("S", "Sim");

        Domain dominioTipoTelefone = new Domain("tipoTelefone");
        dominioTipoTelefone.addDomainPair(0, "Residencial");
        dominioTipoTelefone.addDomainPair(1, "Comercial");
        dominioTipoTelefone.addDomainPair(2, "Celular");
        dominioTipoTelefone.addDomainPair(3, "Outro");

        Domain dominioMes = new Domain("mes");
        dominioMes.addDomainPair("01", "Janeiro");
        dominioMes.addDomainPair("02", "Fevereiro");
        dominioMes.addDomainPair("03", "Março");
        dominioMes.addDomainPair("04", "Abril");
        dominioMes.addDomainPair("05", "Maio");
        dominioMes.addDomainPair("06", "Junho");
        dominioMes.addDomainPair("07", "Julho");
        dominioMes.addDomainPair("08", "Agosto");
        dominioMes.addDomainPair("09", "Setembro");
        dominioMes.addDomainPair("10", "Outubro");
        dominioMes.addDomainPair("11", "Novembro");
        dominioMes.addDomainPair("12", "Dezembro");

        // DOMÍNIOS NOTA FISCAL - FORMAS PAGAMENTO
        Domain dominioTipoOperacao = new Domain("tipoOperacao");
        dominioTipoOperacao.addDomainPair("0", "0 - Entrada");
        dominioTipoOperacao.addDomainPair("1", "1 - Saída");

        Domain dominioFormaPagamento = new Domain("formaPagamento");
        dominioFormaPagamento.addDomainPair("0", "0 - À Vista");
        dominioFormaPagamento.addDomainPair("1", "1 - À Prazo");
        dominioFormaPagamento.addDomainPair("2", "2 - Outros");

        //COMPRAS
        Domain dominioCompraTipoRequisicao = new Domain("compraTipoRequisicao");
        dominioCompraTipoRequisicao.addDomainPair("01", "Interna");
        dominioCompraTipoRequisicao.addDomainPair("02", "Externa");

        Domain dominioCompraTipoPedido = new Domain("compraTipoPedido");
        dominioCompraTipoPedido.addDomainPair("01", "Normal");
        dominioCompraTipoPedido.addDomainPair("02", "Planejado");
        dominioCompraTipoPedido.addDomainPair("03", "Aberto");

        Domain dominioCompraSituacaoCotacao = new Domain("compraSituacaoCotacao");
        dominioCompraSituacaoCotacao.addDomainPair("A", "Aberta");
        dominioCompraSituacaoCotacao.addDomainPair("C", "Confirmada");
        dominioCompraSituacaoCotacao.addDomainPair("F", "Fechada");

        Domain dominioCompraTipoFrete = new Domain("compraTipoFrete");
        dominioCompraTipoFrete.addDomainPair("C", "CIF");
        dominioCompraTipoFrete.addDomainPair("F", "FOB");

        //VENDAS
        Domain dominioVendaOrcamentoTipo = new Domain("vendaOrcamentoTipo");
        dominioVendaOrcamentoTipo.addDomainPair("O", "Orçamento");
        dominioVendaOrcamentoTipo.addDomainPair("P", "Pedido");

        Domain dominioVendaOrcamentoSituacao = new Domain("vendaOrcamentoSituacao");
        dominioVendaOrcamentoSituacao.addDomainPair("D", "Digitação");
        dominioVendaOrcamentoSituacao.addDomainPair("P", "Producão");
        dominioVendaOrcamentoSituacao.addDomainPair("X", "Expedição");
        dominioVendaOrcamentoSituacao.addDomainPair("F", "Faturado");
        dominioVendaOrcamentoSituacao.addDomainPair("E", "Entregue");

        Domain dominioVendaResponsavelFrete = new Domain("vendaResponsavelFrete");
        dominioVendaResponsavelFrete.addDomainPair("1", "Emitente");
        dominioVendaResponsavelFrete.addDomainPair("2", "Destinatário");

        Domain dominioVendaRomaneioSituacao = new Domain("vendaRomaneioSituacao");
        dominioVendaRomaneioSituacao.addDomainPair("A", "Aberto");
        dominioVendaRomaneioSituacao.addDomainPair("T", "Trânsito");
        dominioVendaRomaneioSituacao.addDomainPair("E", "Encerrado");

        //Produto
        Domain dominioProdutoTipo = new Domain("produtoTipo");
        dominioProdutoTipo.addDomainPair("V", "Venda");
        dominioProdutoTipo.addDomainPair("C", "Composição");
        dominioProdutoTipo.addDomainPair("P", "Produção");
        dominioProdutoTipo.addDomainPair("I", "Insumo");
        dominioProdutoTipo.addDomainPair("U", "Uso Próprio");

        Domain dominioProdutoClasse = new Domain("produtoClasse");
        dominioProdutoClasse.addDomainPair("A", "A");
        dominioProdutoClasse.addDomainPair("B", "B");
        dominioProdutoClasse.addDomainPair("C", "C");

        Domain dominioProdutoIat = new Domain("produtoIat");
        dominioProdutoIat.addDomainPair("A", "Arredondamento");
        dominioProdutoIat.addDomainPair("T", "Truncamento");

        Domain dominioProdutoIppt = new Domain("produtoIppt");
        dominioProdutoIppt.addDomainPair("P", "Próprio");
        dominioProdutoIppt.addDomainPair("T", "Terceiro");

        //Empresa
        Domain dominioEmpresaTipo = new Domain("empresaTipo");
        dominioEmpresaTipo.addDomainPair("M", "Matriz");
        dominioEmpresaTipo.addDomainPair("F", "Filial");
        dominioEmpresaTipo.addDomainPair("D", "Depósito");

        Domain dominioClienteTipoFrete = new Domain("clienteTipoFrete");
        dominioClienteTipoFrete.addDomainPair("E", "Emitente");
        dominioClienteTipoFrete.addDomainPair("D", "Destinatário");
        dominioClienteTipoFrete.addDomainPair("S", "Sem Frete");
        dominioClienteTipoFrete.addDomainPair("T", "Terceiros");

        Domain dominioClienteFormaDesconto = new Domain("clienteFormaDesconto");
        dominioClienteFormaDesconto.addDomainPair("P", "Produto");
        dominioClienteFormaDesconto.addDomainPair("F", "Fim do Pedido");

        Domain dominioFornecedorLocalizacao = new Domain("fornecedorLocalizacao");
        dominioFornecedorLocalizacao.addDomainPair("N", "Nacional");
        dominioFornecedorLocalizacao.addDomainPair("E", "Exterior");

        Domain dominioColaboradorFormaPagamento = new Domain("colaboradorFormaPagamento");
        dominioColaboradorFormaPagamento.addDomainPair("1", "Dinheiro");
        dominioColaboradorFormaPagamento.addDomainPair("2", "Cheque");
        dominioColaboradorFormaPagamento.addDomainPair("3", "Conta");

        Domain dominioSindicatoTipo = new Domain("sindicatoTipo");
        dominioSindicatoTipo.addDomainPair("E", "Empregados");
        dominioSindicatoTipo.addDomainPair("P", "Patronal");

        //Registros Feriados
        Domain dominioFeriadosTipo = new Domain("feriadosTipo");
        dominioFeriadosTipo.addDomainPair("F", "Fixo");
        dominioFeriadosTipo.addDomainPair("M", "Móvel");

        Domain dominioTransporteModalidadeFrete = new Domain("transporteModalidadeFrete");
        dominioTransporteModalidadeFrete.addDomainPair(0, "Conta Emitente");
        dominioTransporteModalidadeFrete.addDomainPair(1, "Conta Destinatário");
        dominioTransporteModalidadeFrete.addDomainPair(2, "Conta Terceiros");
        dominioTransporteModalidadeFrete.addDomainPair(3, "Sem Frete");

        Domain dominioRequisicaoInternaSituacao = new Domain("requisicaoInternaSituacao");
        dominioRequisicaoInternaSituacao.addDomainPair("A", "Aberta");
        dominioRequisicaoInternaSituacao.addDomainPair("D", "Deferida");
        dominioRequisicaoInternaSituacao.addDomainPair("I", "Indeferida");

        domains.clear();

        domains.put(tipoPessoa.getDomainId(), tipoPessoa);
        domains.put(tipoSangue.getDomainId(), tipoSangue);
        domains.put(dominioSexo.getDomainId(), dominioSexo);
        domains.put(dominioRacaCor.getDomainId(), dominioRacaCor);
        domains.put(dominioSimNao.getDomainId(), dominioSimNao);
        domains.put(dominioNaoSim.getDomainId(), dominioNaoSim);
        domains.put(dominioTipoTelefone.getDomainId(), dominioTipoTelefone);
        domains.put(dominioMes.getDomainId(), dominioMes);
        domains.put(dominioTipoOperacao.getDomainId(), dominioTipoOperacao);
        domains.put(dominioFormaPagamento.getDomainId(), dominioFormaPagamento);

        domains.put(dominioCompraTipoRequisicao.getDomainId(), dominioCompraTipoRequisicao);
        domains.put(dominioCompraTipoPedido.getDomainId(), dominioCompraTipoPedido);
        domains.put(dominioCompraSituacaoCotacao.getDomainId(), dominioCompraSituacaoCotacao);
        domains.put(dominioCompraTipoFrete.getDomainId(), dominioCompraTipoFrete);

        domains.put(dominioVendaOrcamentoTipo.getDomainId(), dominioVendaOrcamentoTipo);
        domains.put(dominioVendaOrcamentoSituacao.getDomainId(), dominioVendaOrcamentoSituacao);
        domains.put(dominioVendaResponsavelFrete.getDomainId(), dominioVendaResponsavelFrete);
        domains.put(dominioVendaRomaneioSituacao.getDomainId(), dominioVendaRomaneioSituacao);

        domains.put(dominioProdutoTipo.getDomainId(), dominioProdutoTipo);
        domains.put(dominioProdutoClasse.getDomainId(), dominioProdutoClasse);
        domains.put(dominioProdutoIat.getDomainId(), dominioProdutoIat);
        domains.put(dominioProdutoIppt.getDomainId(), dominioProdutoIppt);
        domains.put(dominioEmpresaTipo.getDomainId(), dominioEmpresaTipo);
        domains.put(dominioClienteTipoFrete.getDomainId(), dominioClienteTipoFrete);
        domains.put(dominioClienteFormaDesconto.getDomainId(), dominioClienteFormaDesconto);
        domains.put(dominioFornecedorLocalizacao.getDomainId(), dominioFornecedorLocalizacao);
        domains.put(dominioColaboradorFormaPagamento.getDomainId(), dominioColaboradorFormaPagamento);
        domains.put(dominioSindicatoTipo.getDomainId(), dominioSindicatoTipo);

        domains.put(dominioFeriadosTipo.getDomainId(), dominioFeriadosTipo);

        domains.put(dominioTransporteModalidadeFrete.getDomainId(), dominioTransporteModalidadeFrete);
        domains.put(dominioRequisicaoInternaSituacao.getDomainId(), dominioRequisicaoInternaSituacao);

        MDIFrame mdi = new MDIFrame(this);

    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language menu in the menubar, <code>false</code> no change language menu item will be added
     */
    
    public boolean viewChangeLanguageInMenuBar() {
        return true;
    }

    /**
     * @return list of languages supported by the application
     */
    
    public ArrayList getLanguages() {
        ArrayList list = new ArrayList();
        list.add(new Language("EN", "English"));
        list.add(new Language("IT", "Italiano"));
        list.add(new Language("ES", "Espanhol"));
        list.add(new Language("PT_BR", "Português do Brasil"));

        return list;

    }

    /**
     * @return application functions (ApplicationFunction objects), organized as a tree
     */
    
    public DefaultTreeModel getApplicationFunctions() {
        return (DefaultTreeModel) ((VOResponse) ClientUtils.getData("getFunctionAuthorizations", Container.getContainer().get("usuario"))).getVo();
    }

    
    public boolean viewFileMenu() {
        return true;
    }

    
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    public static void main(String[] argv) {
        new Menu();
    }

}
