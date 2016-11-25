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

import com.bakeryfactory.cadastros.cliente.AlmoxarifadoGridController;
import com.bakeryfactory.cadastros.cliente.IngredienteGridController;
import com.bakeryfactory.cadastros.cliente.AtividadeForCliGridController;
import com.bakeryfactory.cadastros.cliente.CargoGridController;
import com.bakeryfactory.cadastros.cliente.CepGridController;
import com.bakeryfactory.cadastros.cliente.ClienteGridController;
import com.bakeryfactory.cadastros.cliente.ColaboradorGridController;
import com.bakeryfactory.cadastros.cliente.EstadoCivilGridController;
import com.bakeryfactory.cadastros.cliente.FornecedorGridController;
import com.bakeryfactory.cadastros.cliente.MunicipioGridController;
import com.bakeryfactory.cadastros.cliente.NcmGridController;
import com.bakeryfactory.cadastros.cliente.NivelFormacaoGridController;
import com.bakeryfactory.cadastros.cliente.PaisGridController;
import com.bakeryfactory.cadastros.cliente.SindicatoGridController;
import com.bakeryfactory.cadastros.cliente.PessoaGridController;
import com.bakeryfactory.cadastros.cliente.ProdutoGridController;
import com.bakeryfactory.cadastros.cliente.ProdutoGrupoGridController;
import com.bakeryfactory.cadastros.cliente.ProdutoMarcaGridController;
import com.bakeryfactory.cadastros.cliente.ProdutoSubGrupoGridController;
import com.bakeryfactory.cadastros.cliente.SetorGridController;
import com.bakeryfactory.cadastros.cliente.SituacaoColaboradorGridController;
import com.bakeryfactory.cadastros.cliente.SituacaoForCliGridController;
import com.bakeryfactory.cadastros.cliente.TipoAdmissaoGridController;
import com.bakeryfactory.cadastros.cliente.TipoColaboradorGridController;
import com.bakeryfactory.cadastros.cliente.TipoRelacionamentoGridController;
import com.bakeryfactory.cadastros.cliente.TransportadoraGridController;
import com.bakeryfactory.cadastros.cliente.UfGridController;
import com.bakeryfactory.cadastros.cliente.UnidadeProdutoGridController;
import com.bakeryfactory.pcp.cliente.PcpInstrucaoGridController;
import com.bakeryfactory.pcp.cliente.PcpOpCabecalhoGridController;
import com.bakeryfactory.vendas.cliente.NotaFiscalTipoGridController;
import com.bakeryfactory.vendas.cliente.VendaCondicoesPagamentoGridController;
import com.bakeryfactory.vendas.cliente.VendaFreteGridController;
import com.bakeryfactory.vendas.cliente.VendaGridController;
import com.bakeryfactory.vendas.cliente.VendaOrcamentoGridController;
import com.bakeryfactory.vendas.cliente.VendaRomaneioEntregaGridController;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.ClientFacade;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 11/09/2016
 */
public class Fachada implements ClientFacade {

    public Fachada() {
    }

    //PESSOA
    public void getEstadoCivil() {
        new EstadoCivilGridController();
    }

    public void getPessoa() {
        new PessoaGridController();
    }

    //CLIENTE • FORNECEDOR • TRANSPORTADORA
    public void getAtividadeForCli() {
        new AtividadeForCliGridController();
    }

    public void getSituacaoForCli() {
        new SituacaoForCliGridController();
    }

    public void getCliente() {
        new ClienteGridController();
    }

    public void getFornecedor() {
        new FornecedorGridController();
    }

    public void getTransportadora() {
        new TransportadoraGridController();
    }

    //COLABORADORES
    public void getTipoAdmissao() {
        new TipoAdmissaoGridController();
    }

    public void getColaborador() {
        new ColaboradorGridController();
    }

    public void getTipoColaborador() {
        new TipoColaboradorGridController();
    }

    public void getTipoRelacionamento() {
        new TipoRelacionamentoGridController();
    }

    public void getSituacaoColaborador() {
        new SituacaoColaboradorGridController();
    }

    public void getCargo() {
        new CargoGridController();
    }

    public void getNivelFormacao() {
        new NivelFormacaoGridController();
    }

    //OUTROS
    public void getSindicato() {
        new SindicatoGridController();
    }

    //DIVEROS - SETORES
    public void getSetor() {
        new SetorGridController();
    }

    public void getAlmoxarifado() {
        new AlmoxarifadoGridController();
    }

    //ENDEREÇO
    public void getPais() {
        new PaisGridController();
    }

    public void getUf() {
        new UfGridController();
    }

    public void getMunicipio() {
        new MunicipioGridController();
    }

    public void getCep() {
        new CepGridController();
    }

    //PCP - PRODUTOS
    public void getProduto() {
        new ProdutoGridController();
    }

    public void getProdutoMarca() {
        new ProdutoMarcaGridController();
    }

    public void getNcm() {
        new NcmGridController();
    }


    public void getUnidadeProduto() {
        new UnidadeProdutoGridController();
    }

    public void getProdutoGrupo() {
        new ProdutoGrupoGridController();
    }

    public void getProdutoSubGrupo() {
        new ProdutoSubGrupoGridController();
    }

    public void getIngrediente() {
        new IngredienteGridController();
    }

    public void getReceita() {
        // new ReceitaGridController();
    }

    public void getModoPreparo() {
        // new ModoPreparoGridController();
    }

    public void getPcpInstrucao() {
        new PcpInstrucaoGridController();
    }

    public void getPcpOrdemProducao() {
        new PcpOpCabecalhoGridController();
    }

    //VENDAS
    public void getTipoNotaFiscal() {
        new NotaFiscalTipoGridController();
    }

    public void getVendaCondicoesPagamento() {
        new VendaCondicoesPagamentoGridController();
    }

    public void getVendaOrcamento() {
        new VendaOrcamentoGridController();
    }

    public void getVenda() {
        new VendaGridController();
    }

    public void getVendaFrete() {
        new VendaFreteGridController();
    }

    public void getVendaRomaneioEntrega() {
        new VendaRomaneioEntregaGridController();
    }

    //FUNÇÕES E TABELAS
    public void getFuncaoPadrao() {
        JOptionPane.showMessageDialog(null, "Acesso não autorizado!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

}
