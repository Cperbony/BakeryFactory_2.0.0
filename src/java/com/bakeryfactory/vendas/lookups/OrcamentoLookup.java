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

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 13/10/2016
 */
public class OrcamentoLookup extends LookupController {

    private LookupController orcamentoLookupController;

    public OrcamentoLookup() {

        orcamentoLookupController = new LookupController();
        orcamentoLookupController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO");
        orcamentoLookupController.addLookup2ParentLink("id", "vendaOrcamentoCabecalho.id");
        orcamentoLookupController.addLookup2ParentLink("codigo", "vendaOrcamentoCabecalho.codigo");
        orcamentoLookupController.addLookup2ParentLink("condicoesPagamento", "condicoesPagamento");
        orcamentoLookupController.addLookup2ParentLink("transportadora", "transportadora");
        orcamentoLookupController.addLookup2ParentLink("cliente", "cliente");
        orcamentoLookupController.addLookup2ParentLink("vendedor", "vendedor");
        orcamentoLookupController.addLookup2ParentLink("tipoFrete", "tipoFrete");
        orcamentoLookupController.addLookup2ParentLink("valorSubtotal", "valorSubtotal");
        orcamentoLookupController.addLookup2ParentLink("valorFrete", "valorFrete");
        orcamentoLookupController.addLookup2ParentLink("taxaComissao", "taxaComissao");
        orcamentoLookupController.addLookup2ParentLink("valorComissao", "valorComissao");
        orcamentoLookupController.addLookup2ParentLink("taxaDesconto", "taxaDesconto");
        orcamentoLookupController.addLookup2ParentLink("valorDesconto", "valorDesconto");
        orcamentoLookupController.addLookup2ParentLink("valorTotal", "valorTotal");
        orcamentoLookupController.addLookup2ParentLink("observacao", "observacao");
        orcamentoLookupController.setHeaderColumnName("id", "ID");
        orcamentoLookupController.setHeaderColumnName("codigo", "Código");
        orcamentoLookupController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        orcamentoLookupController.setFrameTitle("Importa Orçamento");

        orcamentoLookupController.setVisibleStatusPanel(true);
        orcamentoLookupController.setVisibleColumn("id", true);
        orcamentoLookupController.setVisibleColumn("codigo", true);
        orcamentoLookupController.setVisibleColumn("cliente.pessoa.nome", true);
        orcamentoLookupController.setFramePreferedSize(new Dimension(600, 500));

        orcamentoLookupController.setLookupDataLocator(new LookupDataLocatorGenerico((orcamentoLookupController.getLookupValueObjectClassName())));
    }
}
