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

package com.bakeryfactory.vendas.lookups;

import com.bakeryfactory.cadastros.lookups.*;
import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   13/10/2016
 */
public class SetorVendasLookup extends LookupController{
    
    private LookupController setorVendasController;

    public SetorVendasLookup() {
    
        setorVendasController = new LookupController();
        setorVendasController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        setorVendasController.addLookup2ParentLink("vendaOrcamentoCabecalho", "vendaOrcamentoCabecalho");
        setorVendasController.addLookup2ParentLink("condicoesPagamento", "condicoesPagamento");
        setorVendasController.addLookup2ParentLink("cliente", "cliente");
        setorVendasController.addLookup2ParentLink("vendedor", "vendedor");
        setorVendasController.addLookup2ParentLink("notaFiscalTipo", "notaFiscalTipo");
        setorVendasController.addLookup2ParentLink("transportadora", "transportadora");
        setorVendasController.addLookup2ParentLink("vendaRomaneioEntrega", "vendaRomaneioEntrega");
        setorVendasController.addLookup2ParentLink("id", "id");
        setorVendasController.addLookup2ParentLink("dataVenda", "dataVenda");
        setorVendasController.addLookup2ParentLink("dataSaida", "dataSaida");
        setorVendasController.addLookup2ParentLink("horaSaida", "horaSaida");
        setorVendasController.addLookup2ParentLink("numeroFatura", "numeroFatura");
        setorVendasController.addLookup2ParentLink("localEntrega", "localEntrega");
        setorVendasController.addLookup2ParentLink("localCobranca", "localCobranca");
        setorVendasController.addLookup2ParentLink("valorSubtotal", "valorSubtotal");
        setorVendasController.addLookup2ParentLink("taxaComissao", "taxaComissao");
        setorVendasController.addLookup2ParentLink("valorComissao", "valorComissao");
        setorVendasController.addLookup2ParentLink("taxaDesconto", "taxaDesconto");
        setorVendasController.addLookup2ParentLink("valorDesconto", "valorDesconto");
        setorVendasController.addLookup2ParentLink("valorTotal", "valorTotal");
        setorVendasController.addLookup2ParentLink("tipoFrete", "tipoFrete");
        setorVendasController.addLookup2ParentLink("formaPagamento", "formaPagamento");
        setorVendasController.addLookup2ParentLink("valorFrete", "valorFrete");
        setorVendasController.addLookup2ParentLink("valorSeguro", "valorSeguro");
        setorVendasController.addLookup2ParentLink("observacao", "observacao");
        setorVendasController.addLookup2ParentLink("situacao", "situacao");

        setorVendasController.setHeaderColumnName("numeroFatura", "Número Fatura");
        setorVendasController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        setorVendasController.setHeaderColumnName("dataVenda", "Data Venda");
        setorVendasController.setHeaderColumnName("valorTotal", "Valor Total");
        setorVendasController.setFrameTitle("Importa Venda");

        setorVendasController.setVisibleStatusPanel(true);
        setorVendasController.setVisibleColumn("numeroFatura", true);
        setorVendasController.setVisibleColumn("cliente.pessoa.nome", true);
        setorVendasController.setVisibleColumn("dataVenda", true);
        setorVendasController.setVisibleColumn("valorTotal", true);
        setorVendasController.setFramePreferedSize(new Dimension(600, 500));

        setorVendasController.setLookupDataLocator(new LookupDataLocatorGenerico((setorVendasController.getLookupValueObjectClassName())));
    
    }
}
