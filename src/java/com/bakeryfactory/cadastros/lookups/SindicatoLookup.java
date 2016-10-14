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

package com.bakeryfactory.cadastros.lookups;

import com.bakeryfactory.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   13/10/2016
 */
public class SindicatoLookup extends LookupController{
    
    private LookupController sindicatoController;

    public SindicatoLookup() {
    
        sindicatoController = new LookupController();
        sindicatoController.setLookupValueObjectClassName("com.bakeryfactory.cadastros.java.SindicatoVO");
        sindicatoController.addLookup2ParentLink("id", "sindicato.id");
        sindicatoController.addLookup2ParentLink("nome", "sindicato.nome");
        sindicatoController.setHeaderColumnName("id", "ID");
        sindicatoController.setHeaderColumnName("nome", "Nome");
        sindicatoController.setFrameTitle("Importa o Sindicato");

        sindicatoController.setVisibleStatusPanel(true);
        sindicatoController.setVisibleColumn("id", true);
        sindicatoController.setVisibleColumn("nome", true);
        sindicatoController.setFramePreferedSize(new Dimension(600, 500));

        sindicatoController.setLookupDataLocator(new LookupDataLocatorGenerico((sindicatoController.getLookupValueObjectClassName())));
    
    }
}