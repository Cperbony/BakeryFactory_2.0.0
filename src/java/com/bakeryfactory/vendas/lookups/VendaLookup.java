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
public class VendaLookup extends LookupController {

    private LookupController vendaLookupController;

    public VendaLookup() {

        vendaLookupController = new LookupController();
        vendaLookupController.setLookupValueObjectClassName("com.bakeryfactory.vendas.java.VendaCabecalhoVO");
        vendaLookupController.addLookup2ParentLink("id", "vendaCabecalho.id");
        vendaLookupController.addLookup2ParentLink("numeroFatura", "vendaCabecalho.numeroFatura");
        vendaLookupController.setHeaderColumnName("id", "ID");
        vendaLookupController.setHeaderColumnName("numeroFatura", "Numero Fatura");
        vendaLookupController.setHeaderColumnName("cliente.pessoa.nome", "Cliente");
        vendaLookupController.setFrameTitle("Importa Vendas");

        vendaLookupController.setVisibleStatusPanel(true);
        vendaLookupController.setVisibleColumn("id", true);
        vendaLookupController.setVisibleColumn("numeroFatura", true);
        vendaLookupController.setVisibleColumn("cliente.pessoa.nome", true);
        vendaLookupController.setFramePreferedSize(new Dimension(600, 500));

        vendaLookupController.setLookupDataLocator(new LookupDataLocatorGenerico((vendaLookupController.getLookupValueObjectClassName())));
    }
}