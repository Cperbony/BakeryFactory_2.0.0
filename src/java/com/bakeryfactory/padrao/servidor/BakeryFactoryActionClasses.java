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

import com.bakeryfactory.cadastros.servidor.AlmoxarifadoDetalheAction;
import com.bakeryfactory.cadastros.servidor.AlmoxarifadoGridAction;
import com.bakeryfactory.cadastros.servidor.AtividadeForCliGridAction;
import com.bakeryfactory.cadastros.servidor.AtividadeForClilDetalheAction;
import com.bakeryfactory.cadastros.servidor.CargoDetalheAction;
import com.bakeryfactory.cadastros.servidor.CargoGridAction;
import com.bakeryfactory.cadastros.servidor.CepDetalheAction;
import com.bakeryfactory.cadastros.servidor.CepGridAction;
import com.bakeryfactory.cadastros.servidor.ClienteDetalheAction;
import com.bakeryfactory.cadastros.servidor.ClienteGridAction;
import com.bakeryfactory.cadastros.servidor.ColaboradorDetalheAction;
import com.bakeryfactory.cadastros.servidor.ColaboradorGridAction;
import com.bakeryfactory.cadastros.servidor.EstadoCivilDetalheAction;
import com.bakeryfactory.cadastros.servidor.EstadoCivilGridAction;
import com.bakeryfactory.cadastros.servidor.FornecedorDetalheAction;
import com.bakeryfactory.cadastros.servidor.FornecedorGridAction;
import com.bakeryfactory.cadastros.servidor.MunicipioDetalheAction;
import com.bakeryfactory.cadastros.servidor.MunicipioGridAction;
import com.bakeryfactory.cadastros.servidor.NcmGridAction;
import com.bakeryfactory.cadastros.servidor.NivelFormacaoDetalheAction;
import com.bakeryfactory.cadastros.servidor.NivelFormacaoGridAction;
import com.bakeryfactory.cadastros.servidor.PaisDetalheAction;
import com.bakeryfactory.cadastros.servidor.PaisGridAction;
import com.bakeryfactory.cadastros.servidor.PessoaContatoGridAction;
import com.bakeryfactory.cadastros.servidor.PessoaDetalheAction;
import com.bakeryfactory.cadastros.servidor.PessoaEnderecoGridAction;
import com.bakeryfactory.cadastros.servidor.PessoaFisicaDetalheAction;
import com.bakeryfactory.cadastros.servidor.PessoaGridAction;
import com.bakeryfactory.cadastros.servidor.PessoaJuridicaDetalheAction;
import com.bakeryfactory.cadastros.servidor.ProdutoDetalheAction;
import com.bakeryfactory.cadastros.servidor.ProdutoGridAction;
import com.bakeryfactory.cadastros.servidor.ProdutoGrupoDetalheAction;
import com.bakeryfactory.cadastros.servidor.ProdutoGrupoGridAction;
import com.bakeryfactory.cadastros.servidor.ProdutoMarcaDetalheAction;
import com.bakeryfactory.cadastros.servidor.ProdutoMarcaGridAction;
import com.bakeryfactory.cadastros.servidor.ProdutoSubGrupoDetalheAction;
import com.bakeryfactory.cadastros.servidor.ProdutoSubGrupoGridAction;
import com.bakeryfactory.cadastros.servidor.SetorDetalheAction;
import com.bakeryfactory.cadastros.servidor.SetorGridAction;
import com.bakeryfactory.cadastros.servidor.SituacaoColaboradorDetalheAction;
import com.bakeryfactory.cadastros.servidor.SituacaoColaboradorGridAction;
import com.bakeryfactory.cadastros.servidor.SituacaoForCliDetalheAction;
import com.bakeryfactory.cadastros.servidor.SituacaoForCliGridAction;
import com.bakeryfactory.cadastros.servidor.TipoAdmissaoDetalheAction;
import com.bakeryfactory.cadastros.servidor.TipoAdmissaoGridAction;
import com.bakeryfactory.cadastros.servidor.TipoColaboradorDetalheAction;
import com.bakeryfactory.cadastros.servidor.TipoColaboradorGridAction;
import com.bakeryfactory.cadastros.servidor.TransportadoraDetalheAction;
import com.bakeryfactory.cadastros.servidor.TransportadoraGridAction;
import com.bakeryfactory.cadastros.servidor.UfDetalheAction;
import com.bakeryfactory.cadastros.servidor.UfGridAction;
import com.bakeryfactory.cadastros.servidor.UnidadeProdutoDetalheAction;
import com.bakeryfactory.cadastros.servidor.UnidadeProdutoGridAction;
import com.bakeryfactory.pcp.servidor.PcpInstrucaoDetalheAction;
import com.bakeryfactory.pcp.servidor.PcpInstrucaoGridAction;
import com.bakeryfactory.pcp.servidor.PcpInstrucaoOpGridAction;
import com.bakeryfactory.pcp.servidor.PcpOpCabecalhoDetalheAction;
import com.bakeryfactory.pcp.servidor.PcpOpCabecalhoGridAction;
import com.bakeryfactory.pcp.servidor.PcpOpDetalheGridAction;
import com.bakeryfactory.vendas.servidor.NotaFiscalTipoDetalheAction;
import com.bakeryfactory.vendas.servidor.NotaFiscalTipoGridAction;
import com.bakeryfactory.vendas.servidor.VendaCondicoesPagamentoDetalheAction;
import com.bakeryfactory.vendas.servidor.VendaCondicoesPagamentoGridAction;
import com.bakeryfactory.vendas.servidor.VendaCondicoesParcelasGridAction;
import com.bakeryfactory.vendas.servidor.VendaDetalheAction;
import com.bakeryfactory.vendas.servidor.VendaDetalheGridAction;
import com.bakeryfactory.vendas.servidor.VendaFreteDetalheAction;
import com.bakeryfactory.vendas.servidor.VendaFreteGridAction;
import com.bakeryfactory.vendas.servidor.VendaGridAction;
import com.bakeryfactory.vendas.servidor.VendaOrcamentoDetalheAction;
import com.bakeryfactory.vendas.servidor.VendaOrcamentoDetalheGridAction;
import com.bakeryfactory.vendas.servidor.VendaOrcamentoGridAction;
import com.bakeryfactory.vendas.servidor.VendaRomaneioEntregaDetalheAction;
import com.bakeryfactory.vendas.servidor.VendaRomaneioEntregaDetalheGridAction;
import com.bakeryfactory.vendas.servidor.VendaRomaneioEntregaGridAction;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.ActionsCollection;

/**
 *
 * @author Claudinei Aparecido Perboni <cperbony@gmail.com>
 */
public class BakeryFactoryActionClasses extends ActionsCollection {

    public BakeryFactoryActionClasses() {
        Action a = null;

        /*Actions do Módulo */
        //INFRA
        a = new BakeryFactoryButtonAuthorizationsAction();
        put(a.getRequestName(), a);

        a = new BakeryFactoryFunctionAuthorizationsAction();
        put(a.getRequestName(), a);

        a = new BakeryFactoryContainerAction();
        put(a.getRequestName(), a);

        a = new UserLoginAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //VALIDAÇÕES E IMPORTAÇÕES
        a = new ImportaDadosAction();
        put(a.getRequestName(), a);

        a = new ValidaDadosAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //PESSOA
        a = new EstadoCivilGridAction();
        put(a.getRequestName(), a);

        a = new EstadoCivilDetalheAction();
        put(a.getRequestName(), a);

        a = new PessoaGridAction();
        put(a.getRequestName(), a);

        a = new PessoaDetalheAction();
        put(a.getRequestName(), a);

        a = new PessoaContatoGridAction();
        put(a.getRequestName(), a);

        a = new PessoaEnderecoGridAction();
        put(a.getRequestName(), a);

        a = new PessoaFisicaDetalheAction();
        put(a.getRequestName(), a);

        a = new PessoaJuridicaDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //CLIENTE - FORNECEDOR - TRANSPORTADORA
        a = new AtividadeForCliGridAction();
        put(a.getRequestName(), a);

        a = new AtividadeForClilDetalheAction();
        put(a.getRequestName(), a);

        a = new SituacaoForCliGridAction();
        put(a.getRequestName(), a);

        a = new SituacaoForCliDetalheAction();
        put(a.getRequestName(), a);

        a = new ClienteGridAction();
        put(a.getRequestName(), a);

        a = new ClienteDetalheAction();
        put(a.getRequestName(), a);

        a = new FornecedorGridAction();
        put(a.getRequestName(), a);

        a = new FornecedorDetalheAction();
        put(a.getRequestName(), a);

        a = new TransportadoraGridAction();
        put(a.getRequestName(), a);

        a = new TransportadoraDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //COLABORADOR
        a = new TipoAdmissaoGridAction();
        put(a.getRequestName(), a);

        a = new TipoAdmissaoDetalheAction();
        put(a.getRequestName(), a);

        a = new SituacaoColaboradorGridAction();
        put(a.getRequestName(), a);

        a = new SituacaoColaboradorDetalheAction();
        put(a.getRequestName(), a);

        a = new TipoColaboradorGridAction();
        put(a.getRequestName(), a);

        a = new TipoColaboradorDetalheAction();
        put(a.getRequestName(), a);

        a = new CargoGridAction();
        put(a.getRequestName(), a);

        a = new CargoDetalheAction();
        put(a.getRequestName(), a);

        a = new NivelFormacaoGridAction();
        put(a.getRequestName(), a);

        a = new NivelFormacaoDetalheAction();
        put(a.getRequestName(), a);

        a = new ColaboradorGridAction();
        put(a.getRequestName(), a);

        a = new ColaboradorDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //SINDICATO
        //a = new SindicatoGridAction(); put(a.getRequestName(), a);
        //a = new SindicatoDetalheAction(); put(a.getRequestName(), a);
        /*Actions do Módulo */
        //DIVERSOS
        a = new SetorGridAction();
        put(a.getRequestName(), a);

        a = new SetorDetalheAction();
        put(a.getRequestName(), a);

        a = new AlmoxarifadoGridAction();
        put(a.getRequestName(), a);

        a = new AlmoxarifadoDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //ENDEREÇO
        a = new PaisGridAction();
        put(a.getRequestName(), a);

        a = new PaisDetalheAction();
        put(a.getRequestName(), a);

        a = new UfGridAction();
        put(a.getRequestName(), a);

        a = new UfDetalheAction();
        put(a.getRequestName(), a);

        a = new MunicipioGridAction();
        put(a.getRequestName(), a);

        a = new MunicipioDetalheAction();
        put(a.getRequestName(), a);

        a = new CepGridAction();
        put(a.getRequestName(), a);

        a = new CepDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //PRODUTO
        a = new ProdutoMarcaGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoMarcaDetalheAction();
        put(a.getRequestName(), a);

        a = new UnidadeProdutoGridAction();
        put(a.getRequestName(), a);

        a = new UnidadeProdutoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoGrupoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoGrupoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoSubGrupoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoSubGrupoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoDetalheAction();
        put(a.getRequestName(), a);

        a = new NcmGridAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //PCP
        a = new PcpInstrucaoGridAction();
        put(a.getRequestName(), a);

        a = new PcpInstrucaoDetalheAction();
        put(a.getRequestName(), a);

        a = new PcpInstrucaoOpGridAction();
        put(a.getRequestName(), a);

        a = new PcpOpDetalheGridAction();
        put(a.getRequestName(), a);

        a = new PcpOpCabecalhoGridAction();
        put(a.getRequestName(), a);

        a = new PcpOpCabecalhoDetalheAction();
        put(a.getRequestName(), a);

        /*Actions do Módulo */
        //PRODUTO
        a = new UnidadeProdutoGridAction();
        put(a.getRequestName(), a);

        a = new UnidadeProdutoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoGrupoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoGrupoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoSubGrupoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoSubGrupoDetalheAction();
        put(a.getRequestName(), a);

        a = new ProdutoGridAction();
        put(a.getRequestName(), a);

        a = new ProdutoDetalheAction();
        put(a.getRequestName(), a);

        //   a = new FichaTecnicaGridAction(); put(a.getRequestName(), a);
        /*Actions do Módulo */
        //VENDAS
        a = new NotaFiscalTipoGridAction();
        put(a.getRequestName(), a);

        a = new NotaFiscalTipoDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaCondicoesPagamentoGridAction();
        put(a.getRequestName(), a);

        a = new VendaCondicoesPagamentoDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaCondicoesParcelasGridAction();
        put(a.getRequestName(), a);

        a = new VendaOrcamentoGridAction();
        put(a.getRequestName(), a);

        a = new VendaOrcamentoDetalheGridAction();
        put(a.getRequestName(), a);

        a = new VendaOrcamentoDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaGridAction();
        put(a.getRequestName(), a);

        a = new VendaDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaDetalheGridAction();
        put(a.getRequestName(), a);

        a = new VendaFreteGridAction();
        put(a.getRequestName(), a);

        a = new VendaFreteDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaRomaneioEntregaGridAction();
        put(a.getRequestName(), a);

        a = new VendaRomaneioEntregaDetalheAction();
        put(a.getRequestName(), a);

        a = new VendaRomaneioEntregaDetalheGridAction();
        put(a.getRequestName(), a);
    }
}
