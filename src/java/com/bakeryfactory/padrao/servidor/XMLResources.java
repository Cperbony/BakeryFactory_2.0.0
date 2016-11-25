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

import java.util.Hashtable;
import javax.servlet.ServletContext;
import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.internationalization.java.XMLResourcesFactory;
import org.openswing.swing.internationalization.server.ServerResourcesFactory;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 11/09/2016
 */
public class XMLResources extends ServerResourcesFactory {

    private Hashtable xmlFiles = null;
    private XMLResourcesFactory factory = null;

    public XMLResources() {
    }

    /**
     * Method called by the server controller (Controller object) to initialize the factory.
     *
     * @param context
     */
    public void init(ServletContext context) {
        xmlFiles = new Hashtable();
        xmlFiles.put("PT_BR", this.getClass().getResource("/").getPath() + "Resources_ptBR.xml");
        xmlFiles.put("EN", this.getClass().getResource("/").getPath() + "Resources_en.xml");
        xmlFiles.put("IT", this.getClass().getResource("/").getPath() + "Resources_it.xml");
        xmlFiles.put("ES", this.getClass().getResource("/").getPath() + "Resources_es.xml");
        factory = new XMLResourcesFactory(xmlFiles, true);
    }

    /**
     * Load dictionary, according to the specified language id.
     *
     * @param langId language id identifier
     */
    public final void setLanguage(String langId) throws UnsupportedOperationException {
        factory.setLanguage(langId);
    }

    /**
     * @return internationalization settings, according with the current language
     */
    public final Resources getResources() {
        return factory.getResources();
    }

    /**
     * @param langId language id identifier
     * @return internationalization settings, according with the language specified
     */
    public final Resources getResources(String langId) throws UnsupportedOperationException {
       // if(factory == null){
       //     JOptionPane.showMessageDialog(null, "Não Há Nenhum Idioma XML Disponível!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
       // }
        return factory.getResources(langId);
        /*
        Resources resources = (Resources) factory.getResources(langId);
        if (resources != null) {
            return resources;
        }
        return factory.getResources(langId);

         */    }
}
